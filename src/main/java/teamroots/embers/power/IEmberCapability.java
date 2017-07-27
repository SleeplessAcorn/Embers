package teamroots.embers.power;

import net.minecraft.nbt.NBTTagCompound;

public interface IEmberCapability {
    double getEmber();

    void setEmber(double value);

    double getEmberCapacity();

    void setEmberCapacity(double value);

    double addAmount(double value, boolean doAdd);

    double removeAmount(double value, boolean doRemove);

    void writeToNBT(NBTTagCompound tag);

    void readFromNBT(NBTTagCompound tag);
}
