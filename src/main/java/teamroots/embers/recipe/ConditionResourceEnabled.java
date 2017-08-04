package teamroots.embers.recipe;

import com.google.gson.JsonObject;
import net.minecraft.util.JsonUtils;
import net.minecraftforge.common.crafting.IConditionFactory;
import net.minecraftforge.common.crafting.JsonContext;
import org.apache.commons.lang3.reflect.FieldUtils;
import org.apache.commons.lang3.text.WordUtils;
import teamroots.embers.ConfigHandler;
import teamroots.embers.Embers;

import java.lang.reflect.Field;
import java.util.Locale;
import java.util.function.BooleanSupplier;

public class ConditionResourceEnabled implements IConditionFactory {

    @Override
    public BooleanSupplier parse(JsonContext context, JsonObject json) {
        String type = JsonUtils.getString(json, "material");
        try {
            Field configField = FieldUtils.getField(ConfigHandler.ConfigCompat.class, "enable" + WordUtils.capitalize(type.toLowerCase(Locale.ROOT)));
            return () -> {
                try {
                    return (Boolean) configField.get(ConfigHandler.compat);
                } catch (Exception e) {
                    return false;
                }
            };
        } catch (Exception e) {
            Embers.LOGGER.error("Error loading config value for material type {}", type);
            return () -> false;
        }
    }
}
