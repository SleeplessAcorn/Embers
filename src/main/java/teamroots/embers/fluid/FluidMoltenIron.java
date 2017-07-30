package teamroots.embers.fluid;

import net.minecraft.util.ResourceLocation;
import net.minecraftforge.fluids.Fluid;
import teamroots.embers.Embers;

import java.awt.Color;

public class FluidMoltenIron extends Fluid {
    public FluidMoltenIron() {
        super("iron", new ResourceLocation(Embers.MODID + ":blocks/fluid_metal_base"), new ResourceLocation(Embers.MODID + ":blocks/fluid_metal_flowing"));
        setViscosity(6000);
        setDensity(2000);
        setLuminosity(15);
        setTemperature(900);
        setUnlocalizedName("iron");
    }

    @Override
    public int getColor() {
        return Color.WHITE.getRGB();
    }
}
