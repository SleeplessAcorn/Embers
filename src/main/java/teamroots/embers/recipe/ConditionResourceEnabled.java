package teamroots.embers.recipe;

import com.google.gson.JsonObject;
import net.minecraft.util.JsonUtils;
import net.minecraftforge.common.crafting.IConditionFactory;
import net.minecraftforge.common.crafting.JsonContext;
import teamroots.embers.ConfigHandler;

import java.util.function.BooleanSupplier;

public class ConditionResourceEnabled implements IConditionFactory {

    @Override
    public BooleanSupplier parse(JsonContext context, JsonObject json) {
        String type = JsonUtils.getString(json, "material");
        switch (type) {
            case "nickel": return () -> ConfigHandler.compat.enableNickel;
            case "tin": return () -> ConfigHandler.compat.enableTin;
            case "aluminum": return () -> ConfigHandler.compat.enableAluminum;
            case "bronze": return () -> ConfigHandler.compat.enableBronze;
            case "electrum": return () -> ConfigHandler.compat.enableElectrum;
        }

        return () -> false;
    }
}
