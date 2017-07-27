package teamroots.embers.heat;

import net.minecraft.util.EnumFacing;
import net.minecraftforge.common.capabilities.Capability;
import net.minecraftforge.common.capabilities.CapabilityInject;
import net.minecraftforge.common.capabilities.ICapabilityProvider;

public class HeatCapabilityProvider implements ICapabilityProvider {
    @CapabilityInject(IHeatCapability.class)
    public static final Capability<IHeatCapability> heatCapability = null;
    private IHeatCapability capability = null;

    public HeatCapabilityProvider() {
        capability = new DefaultHeatCapability();
    }

    public HeatCapabilityProvider(IHeatCapability capability) {
        this.capability = capability;
    }

    @Override
    public boolean hasCapability(Capability<?> capability, EnumFacing facing) {
        return capability == heatCapability;
    }

    @Override
    public <T> T getCapability(Capability<T> capability, EnumFacing facing) {
        if (heatCapability != null && capability == heatCapability) return (T) capability;
        return null;
    }
}
