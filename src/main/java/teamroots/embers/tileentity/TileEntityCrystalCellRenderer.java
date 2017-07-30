package teamroots.embers.tileentity;

import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.BufferBuilder;
import net.minecraft.client.renderer.GlStateManager;
import net.minecraft.client.renderer.RenderItem;
import net.minecraft.client.renderer.Tessellator;
import net.minecraft.client.renderer.tileentity.TileEntitySpecialRenderer;
import net.minecraft.client.renderer.vertex.DefaultVertexFormats;
import net.minecraft.util.ResourceLocation;
import org.lwjgl.opengl.GL11;
import teamroots.embers.Embers;

import java.util.Random;

public class TileEntityCrystalCellRenderer extends TileEntitySpecialRenderer<TileEntityCrystalCell> {
    public ResourceLocation texture = new ResourceLocation(Embers.MODID + ":textures/blocks/crystal_material.png");
    RenderItem renderItem = Minecraft.getMinecraft().getRenderItem();
    Random random = new Random();

    @Override
    public void render(TileEntityCrystalCell cell, double x, double y, double z, float partialTicks, int destroyStage, float tileAlpha) {
            random.setSeed(cell.seed);
            float numLayers = 2 + (float) Math.floor(cell.capability.getEmberCapacity() / 128000.0f);
            float layerHeight = 0.25f;
            float height = layerHeight * numLayers;
            float[] widths = new float[(int) numLayers + 1];
            for (float i = 0; i < numLayers + 1; i++) {
                if (i < numLayers / 2.0f) {
                    widths[(int) i] = (i / (numLayers / 2.0f)) * (layerHeight * 0.1875f + layerHeight * 0.09375f * random.nextFloat()) * numLayers;
                }
                if (i >= numLayers / 2.0f) {
                    widths[(int) i] = ((numLayers - i) / (numLayers / 2.0f)) * (layerHeight * 0.1875f + layerHeight * 0.09375f * random.nextFloat()) * numLayers;
                }
            }

            GlStateManager.pushAttrib();
            Minecraft.getMinecraft().renderEngine.bindTexture(texture);
            GlStateManager.disableCull();
            GlStateManager.disableLighting();
            GlStateManager.enableAlpha();
            GlStateManager.enableBlend();
            GlStateManager.blendFunc(GlStateManager.SourceFactor.SRC_ALPHA, GlStateManager.DestFactor.ONE);
            Tessellator tess = Tessellator.getInstance();
            BufferBuilder buffer = tess.getBuffer();

        int l = getWorld().getCombinedLight(cell.getPos(), 15);
            int lx = l >> 0x10 & 0xFFFF;
            int ly = l & 0xFFFF;

            for (float j = 0; j < 12; j++) {

                GlStateManager.pushMatrix();

                float scale = j / 12.0f;

                GlStateManager.translate(x + 0.5, y + height / 2.0f + 1.5, z + 0.5);
                GlStateManager.scale(scale, scale, scale);

                GlStateManager.rotate(partialTicks + cell.ticksExisted % 360, 0, 1, 0);
                GlStateManager.rotate(30.0f * (float) Math.sin(Math.toRadians(partialTicks / 3.0f + cell.ticksExisted / 3 % 360)), 1, 0, 0);

                buffer.begin(GL11.GL_QUADS, DefaultVertexFormats.POSITION_TEX_LMAP_COLOR);
                for (int i = 0; i < widths.length - 1; i++) {
                    buffer.pos(-widths[i], layerHeight * i - height / 2.0f, -widths[i]).tex(0, 0).lightmap(lx, ly).color(1, 1, 1, 0.65f).endVertex();
                    buffer.pos(widths[i], layerHeight * i - height / 2.0f, -widths[i]).tex(0.5, 0).lightmap(lx, ly).color(1, 1, 1, 0.65f).endVertex();
                    buffer.pos(widths[i + 1], layerHeight + layerHeight * i - height / 2.0f, -widths[i + 1]).tex(0.5, 0.5).lightmap(lx, ly).color(1, 1, 1, 0.65f).endVertex();
                    buffer.pos(-widths[i + 1], layerHeight + layerHeight * i - height / 2.0f, -widths[i + 1]).tex(0, 0.5).lightmap(lx, ly).color(1, 1, 1, 0.65f).endVertex();

                    buffer.pos(-widths[i], layerHeight * i - height / 2.0f, widths[i]).tex(0, 0).lightmap(lx, ly).color(1, 1, 1, 0.65f).endVertex();
                    buffer.pos(widths[i], layerHeight * i - height / 2.0f, widths[i]).tex(0.5, 0).lightmap(lx, ly).color(1, 1, 1, 0.65f).endVertex();
                    buffer.pos(widths[i + 1], layerHeight + layerHeight * i - height / 2.0f, widths[i + 1]).tex(0.5, 0.5).lightmap(lx, ly).color(1, 1, 1, 0.65f).endVertex();
                    buffer.pos(-widths[i + 1], layerHeight + layerHeight * i - height / 2.0f, widths[i + 1]).tex(0, 0.5).lightmap(lx, ly).color(1, 1, 1, 0.65f).endVertex();

                    buffer.pos(-widths[i], layerHeight * i - height / 2.0f, -widths[i]).tex(0, 0).lightmap(lx, ly).color(1, 1, 1, 0.65f).endVertex();
                    buffer.pos(-widths[i], layerHeight * i - height / 2.0f, widths[i]).tex(0.5, 0).lightmap(lx, ly).color(1, 1, 1, 0.65f).endVertex();
                    buffer.pos(-widths[i + 1], layerHeight + layerHeight * i - height / 2.0f, widths[i + 1]).tex(0.5, 0.5).lightmap(lx, ly).color(1, 1, 1, 0.65f).endVertex();
                    buffer.pos(-widths[i + 1], layerHeight + layerHeight * i - height / 2.0f, -widths[i + 1]).tex(0, 0.5).lightmap(lx, ly).color(1, 1, 1, 0.65f).endVertex();

                    buffer.pos(widths[i], layerHeight * i - height / 2.0f, -widths[i]).tex(0, 0).lightmap(lx, ly).color(1, 1, 1, 0.65f).endVertex();
                    buffer.pos(widths[i], layerHeight * i - height / 2.0f, widths[i]).tex(0.5, 0).lightmap(lx, ly).color(1, 1, 1, 0.65f).endVertex();
                    buffer.pos(widths[i + 1], layerHeight + layerHeight * i - height / 2.0f, widths[i + 1]).tex(0.5, 0.5).lightmap(lx, ly).color(1, 1, 1, 0.65f).endVertex();
                    buffer.pos(widths[i + 1], layerHeight + layerHeight * i - height / 2.0f, -widths[i + 1]).tex(0, 0.5).lightmap(lx, ly).color(1, 1, 1, 0.65f).endVertex();
                }
                tess.draw();
                GlStateManager.popMatrix();
            }

            GlStateManager.enableLighting();
            GlStateManager.disableBlend();
            GlStateManager.popAttrib();
    }
}
