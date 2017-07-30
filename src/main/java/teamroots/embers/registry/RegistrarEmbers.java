package teamroots.embers.registry;

import com.google.common.collect.Lists;
import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.color.ItemColors;
import net.minecraft.entity.EnumCreatureType;
import net.minecraft.util.DamageSource;
import net.minecraft.util.ResourceLocation;
import net.minecraft.world.biome.Biome;
import net.minecraftforge.client.event.ModelRegistryEvent;
import net.minecraftforge.common.BiomeManager;
import net.minecraftforge.common.capabilities.CapabilityManager;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.event.furnace.FurnaceFuelBurnTimeEvent;
import net.minecraftforge.fml.client.registry.ClientRegistry;
import net.minecraftforge.fml.client.registry.RenderingRegistry;
import net.minecraftforge.fml.common.IWorldGenerator;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.fml.common.registry.EntityEntry;
import net.minecraftforge.fml.common.registry.EntityRegistry;
import net.minecraftforge.fml.common.registry.GameRegistry;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;
import teamroots.embers.ConfigManager;
import teamroots.embers.Embers;
import teamroots.embers.entity.*;
import teamroots.embers.item.ItemEmberCartridge;
import teamroots.embers.item.ItemEmberJar;
import teamroots.embers.item.ItemTyrfing;
import teamroots.embers.power.DefaultEmberCapability;
import teamroots.embers.power.EmberCapabilityStorage;
import teamroots.embers.power.IEmberCapability;
import teamroots.embers.tileentity.*;
import teamroots.embers.util.Misc;
import teamroots.embers.world.WorldGenOres;
import teamroots.embers.world.WorldGenSmallRuin;

import java.util.List;

@Mod.EventBusSubscriber(modid = Embers.MODID)
@SuppressWarnings("unused")
public class RegistrarEmbers {

    public static final DamageSource DAMAGE_EMBER = new DamageSource("ember").setMagicDamage();
    public static final WorldGenOres ORE_GEN = new WorldGenOres();
    public static final IWorldGenerator WORLD_GEN_RUINS = new WorldGenSmallRuin();

    public static void registerOthers() {
        CapabilityManager.INSTANCE.register(IEmberCapability.class, new EmberCapabilityStorage(), DefaultEmberCapability.class);

        GameRegistry.registerWorldGenerator(ORE_GEN, 1);
        GameRegistry.registerWorldGenerator(WORLD_GEN_RUINS, 400);
    }

    @SideOnly(Side.CLIENT)
    public static void registerOthersClient() {
        RenderingRegistry.registerEntityRenderingHandler(EntityEmberPacket.class, new RenderEmberPacket.Factory<>());
        RenderingRegistry.registerEntityRenderingHandler(EntityEmberProjectile.class, new RenderEmberPacket.Factory<>());
        RenderingRegistry.registerEntityRenderingHandler(EntityAncientGolem.class, new RenderAncientGolem.Factory());
        RenderingRegistry.registerEntityRenderingHandler(EntityEmberLight.class, new RenderEmberPacket.Factory<>());
    }

    @SuppressWarnings("ConstantConditions")
    @SubscribeEvent
    public static void registerEntities(RegistryEvent.Register<EntityEntry> event) {
        int id = 0;

        EntityRegistry.registerModEntity(new ResourceLocation(Embers.MODID + ":ember_packet"), EntityEmberPacket.class, "ember_packet", id++, Embers.instance, 64, 1, true);
        EntityRegistry.registerModEntity(new ResourceLocation(Embers.MODID + ":ember_projectile"), EntityEmberProjectile.class, "ember_projectile", id++, Embers.instance, 64, 1, true);
        EntityRegistry.registerModEntity(new ResourceLocation(Embers.MODID + ":ancient_golem"), EntityAncientGolem.class, "ancient_golem", id++, Embers.instance, 64, 1, true);
        EntityRegistry.registerEgg(new ResourceLocation(Embers.MODID + ":ancient_golem"), Misc.intColor(48, 38, 35), Misc.intColor(79, 66, 61));
        EntityRegistry.registerModEntity(new ResourceLocation(Embers.MODID + ":ember_light"), EntityEmberLight.class, "ember_light", id++, Embers.instance, 64, 1, true);

        List<BiomeManager.BiomeEntry> biomeEntries = Lists.newArrayList();
        biomeEntries.addAll(BiomeManager.getBiomes(BiomeManager.BiomeType.COOL));
        biomeEntries.addAll(BiomeManager.getBiomes(BiomeManager.BiomeType.DESERT));
        biomeEntries.addAll(BiomeManager.getBiomes(BiomeManager.BiomeType.ICY));
        biomeEntries.addAll(BiomeManager.getBiomes(BiomeManager.BiomeType.WARM));
        List<Biome> biomes = Lists.newArrayList();
        biomeEntries.forEach(b -> biomes.add(b.biome));
        biomes.addAll(BiomeManager.oceanBiomes);

        EntityRegistry.addSpawn(EntityAncientGolem.class, ConfigManager.ancientGolemSpawnWeight, 1, 1, EnumCreatureType.MONSTER, biomes.toArray(new Biome[biomes.size()]));
    }

    @SubscribeEvent
    public static void onFurnaceBurn(FurnaceFuelBurnTimeEvent event) {
        if (!event.getItemStack().isEmpty() && event.getItemStack().getItem() == RegistrarEmbersItems.DUST_ASH)
            event.setBurnTime(200);
    }

    @SideOnly(Side.SERVER)
    @SubscribeEvent
    public static void onModelRegister(ModelRegistryEvent event) {
        ClientRegistry.bindTileEntitySpecialRenderer(TileEntityTank.class, new TileEntityTankRenderer());
        ClientRegistry.bindTileEntitySpecialRenderer(TileEntityFluidPipe.class, new TileEntityFluidPipeRenderer());
        ClientRegistry.bindTileEntitySpecialRenderer(TileEntityFluidExtractor.class, new TileEntityFluidExtractorRenderer());
        ClientRegistry.bindTileEntitySpecialRenderer(TileEntityFurnaceTop.class, new TileEntityFurnaceTopRenderer());
        ClientRegistry.bindTileEntitySpecialRenderer(TileEntityEmitter.class, new TileEntityEmitterRenderer());
        ClientRegistry.bindTileEntitySpecialRenderer(TileEntityItemPipe.class, new TileEntityItemPipeRenderer());
        ClientRegistry.bindTileEntitySpecialRenderer(TileEntityItemExtractor.class, new TileEntityItemExtractorRenderer());
        ClientRegistry.bindTileEntitySpecialRenderer(TileEntityBin.class, new TileEntityBinRenderer());
        ClientRegistry.bindTileEntitySpecialRenderer(TileEntityStamper.class, new TileEntityStamperRenderer());
        ClientRegistry.bindTileEntitySpecialRenderer(TileEntityStampBase.class, new TileEntityStampBaseRenderer());
        ClientRegistry.bindTileEntitySpecialRenderer(TileEntityEmberBore.class, new TileEntityEmberBoreRenderer());
        ClientRegistry.bindTileEntitySpecialRenderer(TileEntityHeatCoil.class, new TileEntityHeatCoilRenderer());
        ClientRegistry.bindTileEntitySpecialRenderer(TileEntityLargeTank.class, new TileEntityLargeTankRenderer());
        ClientRegistry.bindTileEntitySpecialRenderer(TileEntityCrystalCell.class, new TileEntityCrystalCellRenderer());
        ClientRegistry.bindTileEntitySpecialRenderer(TileEntityCharger.class, new TileEntityChargerRenderer());
        ClientRegistry.bindTileEntitySpecialRenderer(TileEntityCinderPlinth.class, new TileEntityCinderPlinthRenderer());
        ClientRegistry.bindTileEntitySpecialRenderer(TileEntityKnowledgeTable.class, new TileEntityKnowledgeTableRenderer());
        ClientRegistry.bindTileEntitySpecialRenderer(TileEntityAlchemyPedestal.class, new TileEntityAlchemyPedestalRenderer());
        ClientRegistry.bindTileEntitySpecialRenderer(TileEntityAlchemyTablet.class, new TileEntityAlchemyTabletRenderer());
        ClientRegistry.bindTileEntitySpecialRenderer(TileEntityItemTransfer.class, new TileEntityItemTransferRenderer());
        ClientRegistry.bindTileEntitySpecialRenderer(TileEntityBeamCannon.class, new TileEntityBeamCannonRenderer());
        ClientRegistry.bindTileEntitySpecialRenderer(TileEntityDawnstoneAnvil.class, new TileEntityDawnstoneAnvilRenderer());
        ClientRegistry.bindTileEntitySpecialRenderer(TileEntityAutoHammer.class, new TileEntityAutoHammerRenderer());
        ClientRegistry.bindTileEntitySpecialRenderer(TileEntityBreaker.class, new TileEntityBreakerRenderer());
        ClientRegistry.bindTileEntitySpecialRenderer(TileEntitySeed.class, new TileEntitySeedRenderer());
        ClientRegistry.bindTileEntitySpecialRenderer(TileEntityFieldChart.class, new TileEntityFieldChartRenderer());
        ClientRegistry.bindTileEntitySpecialRenderer(TileEntityPulser.class, new TileEntityPulserRenderer());
        ClientRegistry.bindTileEntitySpecialRenderer(TileEntityInfernoForgeOpening.class, new TileEntityInfernoForgeOpeningRenderer());
        ClientRegistry.bindTileEntitySpecialRenderer(TileEntityAxle.class, new TileEntityAxleRenderer());
        ClientRegistry.bindTileEntitySpecialRenderer(TileEntityGearbox.class, new TileEntityGearboxRenderer());
        ClientRegistry.bindTileEntitySpecialRenderer(TileEntityPumpBottom.class, new TileEntityPumpRenderer());
    }

    @SideOnly(Side.CLIENT)
    public static void registerColorHandlers() {
        ItemColors colors = Minecraft.getMinecraft().getItemColors();
        colors.registerItemColorHandler(new ItemEmberJar.ColorHandler(), RegistrarEmbersItems.EMBER_JAR);
        colors.registerItemColorHandler(new ItemEmberCartridge.ColorHandler(), RegistrarEmbersItems.EMBER_CARTRIDGE);
        colors.registerItemColorHandler(new ItemTyrfing.ColorHandler(), RegistrarEmbersItems.TYRFING);
//        colors.registerItemColorHandler(new ItemEmberBulb.ColorHandler(), mantle_bulb);
    }
}
