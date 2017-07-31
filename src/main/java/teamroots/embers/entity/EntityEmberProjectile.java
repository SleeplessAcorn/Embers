package teamroots.embers.entity;

import net.minecraft.block.state.IBlockState;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.network.datasync.DataParameter;
import net.minecraft.network.datasync.DataSerializers;
import net.minecraft.network.datasync.EntityDataManager;
import net.minecraft.util.DamageSource;
import net.minecraft.util.math.AxisAlignedBB;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import teamroots.embers.network.PacketHandler;
import teamroots.embers.network.message.MessageEmberSizedBurstFX;
import teamroots.embers.particle.ParticleUtil;
import teamroots.embers.registry.RegistrarEmbers;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

//import elucent.albedo.lighting.ILightProvider;
//import elucent.albedo.lighting.Light;

//@Interface(iface = "elucent.albedo.lighting.ILightProvider", modid = "albedo")
public class EntityEmberProjectile extends Entity/* implements ILightProvider*/ {
    public static final DataParameter<Float> value = EntityDataManager.createKey(EntityEmberProjectile.class, DataSerializers.FLOAT);
    public static final DataParameter<Boolean> dead = EntityDataManager.createKey(EntityEmberProjectile.class, DataSerializers.BOOLEAN);
    public static final DataParameter<Integer> lifetime = EntityDataManager.createKey(EntityEmberProjectile.class, DataSerializers.VARINT);
    public BlockPos dest = new BlockPos(0, 0, 0);
    public UUID id = null;
    BlockPos pos = new BlockPos(0, 0, 0);

    public EntityEmberProjectile(World worldIn) {
        super(worldIn);
        this.setInvisible(true);
        this.getDataManager().register(value, Float.valueOf(0));
        this.getDataManager().register(dead, false);
        this.getDataManager().register(lifetime, Integer.valueOf(160));
    }

    public void initCustom(double x, double y, double z, double vx, double vy, double vz, double value, UUID playerId) {
        this.posX = x;
        this.posY = y;
        this.posZ = z;
        this.motionX = vx;
        this.motionY = vy;
        this.motionZ = vz;
        setSize((float) value / 10.0f, (float) value / 10.0f);
        getDataManager().set(EntityEmberProjectile.value, (float) value);
        getDataManager().setDirty(EntityEmberProjectile.value);
        setSize((float) value / 10.0f, (float) value / 10.0f);
        this.id = playerId;
    }

    @Override
    protected void entityInit() {
    }

    @Override
    protected void readEntityFromNBT(NBTTagCompound compound) {
        getDataManager().set(EntityEmberProjectile.value, compound.getFloat("value"));
        getDataManager().setDirty(EntityEmberProjectile.value);
        if (compound.hasKey("UUIDmost")) {
            id = new UUID(compound.getLong("UUIDmost"), compound.getLong("UUIDleast"));
        }
    }

    @Override
    protected void writeEntityToNBT(NBTTagCompound compound) {
        compound.setFloat("value", getDataManager().get(value));
        if (id != null) {
            compound.setLong("UUIDmost", id.getMostSignificantBits());
            compound.setLong("UUIDleast", id.getLeastSignificantBits());
        }
    }

    @Override
    public void onUpdate() {
        super.onUpdate();
        if (!getEntityWorld().isRemote && getDataManager().get(lifetime) > 18 && getDataManager().get(dead)) {
            PacketHandler.INSTANCE.sendToAll(new MessageEmberSizedBurstFX(posX, posY, posZ, getDataManager().get(value) / 1.75f));
        }
        getDataManager().set(lifetime, getDataManager().get(lifetime) - 1);
        getDataManager().setDirty(lifetime);
        if (getDataManager().get(lifetime) <= 0) {
            getEntityWorld().removeEntity(this);
            this.setDead();
        }
        if (!getDataManager().get(dead)) {
            getDataManager().set(value, getDataManager().get(value) - 0.025f);
            if (getDataManager().get(value) <= 0) {
                getEntityWorld().removeEntity(this);
            }

            posX += motionX;
            posY += motionY;
            posZ += motionZ;
            IBlockState state = getEntityWorld().getBlockState(getPosition());
            if (state.isFullCube() && state.isOpaqueCube()) {
                if (!getEntityWorld().isRemote) {
                    PacketHandler.INSTANCE.sendToAll(new MessageEmberSizedBurstFX(posX, posY, posZ, getDataManager().get(value) / 1.75f));
                    getDataManager().set(lifetime, 20);
                    getDataManager().setDirty(lifetime);
                    this.getDataManager().set(dead, true);
                    getDataManager().setDirty(dead);
                }
            }
            if (getEntityWorld().isRemote) {
                for (double i = 0; i < 9; i++) {
                    double coeff = i / 9.0;
                    ParticleUtil.spawnParticleGlow(getEntityWorld(), (float) (prevPosX + (posX - prevPosX) * coeff), (float) (prevPosY + (posY - prevPosY) * coeff), (float) (prevPosZ + (posZ - prevPosZ) * coeff), 0.0125f * (rand.nextFloat() - 0.5f), 0.0125f * (rand.nextFloat() - 0.5f), 0.0125f * (rand.nextFloat() - 0.5f), 255, 64, 16, getDataManager().get(value) / 1.75f, 24);
                }
            }
            List<EntityLivingBase> rawEntities = getEntityWorld().getEntitiesWithinAABB(EntityLivingBase.class, new AxisAlignedBB(posX - getDataManager().get(value) * 0.125, posY - getDataManager().get(value) * 0.125, posZ - getDataManager().get(value) * 0.125, posX + getDataManager().get(value) * 0.125, posY + getDataManager().get(value) * 0.125, posZ + getDataManager().get(value) * 0.125));
            ArrayList<EntityLivingBase> entities = new ArrayList<EntityLivingBase>();
            for (EntityLivingBase rawEntity : rawEntities) {
                if (id != null) {
                    if (rawEntity.getUniqueID().compareTo(id) != 0) {
                        entities.add(rawEntity);
                    }
                }
            }
            if (entities.size() > 0) {
                for (EntityLivingBase target : entities) {
                    DamageSource source = RegistrarEmbers.DAMAGE_EMBER;
                    if (getEntityWorld().getPlayerEntityByUUID(id) != null) {
                        EntityPlayer player = getEntityWorld().getPlayerEntityByUUID(id);
                        source = DamageSource.causePlayerDamage(player);
                        target.setFire(1);
                        target.attackEntityFrom(source, getDataManager().get(value));
                        target.setLastAttackedEntity(player);
                        target.setRevengeTarget(player);
                        target.knockBack(this, 0.5f, -motionX, -motionZ);
                    } else {
                        target.attackEntityFrom(source, getDataManager().get(value));
                    }
                    if (!getEntityWorld().isRemote) {
                        PacketHandler.INSTANCE.sendToAll(new MessageEmberSizedBurstFX(posX, posY, posZ, getDataManager().get(value) / 1.75f));
                        getDataManager().set(lifetime, 20);
                        getDataManager().setDirty(lifetime);
                        this.getDataManager().set(dead, true);
                        getDataManager().setDirty(dead);
                    }
                }
            }
        } else {
            motionX = 0;
            motionY = 0;
            motionZ = 0;
        }
    }

	/*@Method(modid = "albedo")
    @Override
	public Light provideLight() {
		if (getDataManager().get(dead)){
			return new Light((float)posX,(float)posY,(float)posZ,1.0f,0.5f,0.0625f,1.0f,(getDataManager().get(value)/2.625f) * ((float)getDataManager().get(lifetime)/20f));
		}
		return new Light((float)posX,(float)posY,(float)posZ,1.0f,0.5f,0.0625f,1.0f,(getDataManager().get(value)/2.625f));
	}*/
}
