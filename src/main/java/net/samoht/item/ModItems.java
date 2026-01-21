package net.samoht.item;

import net.minecraft.item.Item;
import net.minecraft.item.equipment.EquipmentType;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.registry.RegistryKey;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.util.Identifier;
import net.samoht.Medivalism;
import net.samoht.item.custom.ModArmorItem;

import java.util.function.Function;

public class ModItems {

    public static final Item RAW_ARGENTIUM = registerItem("raw_argentium", Item::new);
    public static final Item ARGENTIUM_INGOT = registerItem("argentium_ingot", Item::new);

    public static final Item ARGENTIUM_HELMET = registerItem("argentium_helmet",
            settings -> new ModArmorItem(settings.armor(ModArmorMaterials.ARGENTIUM_ARMOR_MATERIAL, EquipmentType.HELMET)));
    public static final Item ARGENTIUM_CHESTPLATE = registerItem("argentium_chestplate",
            settings -> new ModArmorItem(settings.armor(ModArmorMaterials.ARGENTIUM_ARMOR_MATERIAL, EquipmentType.CHESTPLATE)));
    public static final Item ARGENTIUM_LEGGINGS = registerItem("argentium_leggings",
            settings -> new ModArmorItem(settings.armor(ModArmorMaterials.ARGENTIUM_ARMOR_MATERIAL, EquipmentType.LEGGINGS)));
    public static final Item ARGENTIUM_BOOTS = registerItem("argentium_boots",
            settings -> new ModArmorItem(settings.armor(ModArmorMaterials.ARGENTIUM_ARMOR_MATERIAL, EquipmentType.BOOTS)));

    public static final Item ARGENTIUM_SWORD = registerItem("argentium_sword",
            settings -> new Item(settings.sword(ModToolMaterials.ARGENTIUM, 3.0F, -2.4F)));

    private static Item registerItem(String name, Function<Item.Settings, Item> function) {
        return Registry.register(Registries.ITEM, Identifier.of(Medivalism.MOD_ID, name),
                function.apply(new Item.Settings().registryKey(RegistryKey.of(RegistryKeys.ITEM, Identifier.of(Medivalism.MOD_ID, name)))));
    }

    public static void registerModItems() {
        Medivalism.LOGGER.info("Registering Mod Items for " + Medivalism.MOD_ID);
    }

}
