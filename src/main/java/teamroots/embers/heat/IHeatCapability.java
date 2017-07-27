package teamroots.embers.heat;

import net.minecraft.nbt.NBTTagCompound;

public interface IHeatCapability {
    double getHeat();

    void setHeat(double value);

    double getHeatCapacity();

    void setHeatCapacity(double value);

    double addAmount(double value, boolean doAdd);

    double removeAmount(double value, boolean doRemove);

    void writeToNBT(NBTTagCompound tag);

    void readFromNBT(NBTTagCompound tag);
}
