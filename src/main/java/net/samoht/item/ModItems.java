package net.samoht.item;

import net.minecraft.item.Item;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.registry.RegistryKey;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.util.Identifier;
import net.samoht.Medivalism;

import java.util.function.Function;

public class ModItems {

    public static final Item RAW_ARGENTIUM = registerItem("raw_argentium", Item::new);
    public static final Item ARGENTIUM_INGOT = registerItem("argentium_ingot", Item::new);

    private static Item registerItem(String name, Function<Item.Settings, Item> function) {
        return Registry.register(Registries.ITEM, Identifier.of(Medivalism.MOD_ID, name),
                function.apply(new Item.Settings().registryKey(RegistryKey.of(RegistryKeys.ITEM, Identifier.of(Medivalism.MOD_ID, name)))));
    }

    public static void registerModItems() {
        Medivalism.LOGGER.info("Registering Mod Items for " + Medivalism.MOD_ID);
    }

}
