package teamroots.embers.tileentity;

import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.RenderItem;
import net.minecraft.client.renderer.tileentity.TileEntitySpecialRenderer;
import net.minecraft.entity.item.EntityItem;
import net.minecraft.item.ItemStack;
import org.lwjgl.opengl.GL11;

import java.util.Random;

public class TileEntityBinRenderer extends TileEntitySpecialRenderer<TileEntityBin> {
    RenderItem renderItem = Minecraft.getMinecraft().getRenderItem();
    Random random = new Random();

    @Override
    public void render(TileEntityBin bin, double x, double y, double z, float partialTicks, int destroyStage, float tileAlpha) {
        random.setSeed(bin.getWorld().getSeed());
            if (bin.inventory.getStackInSlot(0) != ItemStack.EMPTY) {
                int itemCount = (int) Math.ceil((bin.inventory.getStackInSlot(0).getCount()) / 4.0);
                for (int i = 0; i < itemCount; i++) {
                    GL11.glPushMatrix();
                    EntityItem item = new EntityItem(Minecraft.getMinecraft().world, x, y, z, new ItemStack(bin.inventory.getStackInSlot(0).getItem(), 1, bin.inventory.getStackInSlot(0).getMetadata()));
                    item.hoverStart = 0;
                    GL11.glTranslated(x, y + 0.2 + (i * 0.0625), z);
                    GL11.glTranslated(0.5, 0, 0.5);
                    GL11.glRotated(random.nextFloat() * 360.0, 0, 1.0, 0);
                    GL11.glTranslated(-0.5, 0, -0.5);
                    GL11.glRotated(90, 1, 0, 0);
                    GL11.glTranslated(0.5 + 0.1 * random.nextFloat(), -0.1875 + 0.1 * random.nextFloat(), 0);
                    GL11.glScaled(1.5, 1.5, 1.5);
                    Minecraft.getMinecraft().getRenderManager().doRenderEntity(item, 0, 0, 0, 0, 0, true);
                    GL11.glPopMatrix();
                }
            }
    }
}
