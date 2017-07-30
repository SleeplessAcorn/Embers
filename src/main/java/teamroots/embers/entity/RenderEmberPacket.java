package teamroots.embers.entity;

import net.minecraft.client.renderer.entity.Render;
import net.minecraft.client.renderer.entity.RenderEntity;
import net.minecraft.client.renderer.entity.RenderManager;
import net.minecraft.entity.Entity;
import net.minecraftforge.fml.client.registry.IRenderFactory;

public class RenderEmberPacket extends RenderEntity {

    public RenderEmberPacket(RenderManager renderManagerIn) {
        super(renderManagerIn);
    }

    @Override
    public void doRender(Entity entity, double x, double y, double z, float yaw, float pTicks) {
        //
    }

    @Override
    public void doRenderShadowAndFire(Entity entity, double x, double y, double z, float yaw, float pTicks) {
        //
    }

    @Override
    public boolean canRenderName(Entity entity) {
        return false;
    }

    public static class Factory<T extends Entity> implements IRenderFactory<T> {

        @Override
        public Render<? super T> createRenderFor(RenderManager manager) {
            return new RenderEmberPacket(manager);
        }
    }
}
