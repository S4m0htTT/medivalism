package net.samoht.item;

import net.minecraft.entity.effect.StatusEffectInstance;
import net.minecraft.entity.effect.StatusEffects;
import net.minecraft.item.*;
import net.minecraft.item.equipment.EquipmentType;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.registry.RegistryKey;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.util.Identifier;
import net.samoht.Medivalism;
import net.samoht.item.custom.DaggerItem;
import net.samoht.item.custom.ModArmorItem;
import net.samoht.item.custom.ScytheItem;

import java.util.List;
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
    public static final Item ARGENTIUM_SPEAR = registerItem("argentium_spear",
            settings -> new Item(settings.spear(ModToolMaterials.ARGENTIUM, 0.95F, 1.0F, 0.55F, 2.75F, 7.75F, 6.75F, 5.1F, 11.0F, 4.6F)));
    public static final Item ARGENTIUM_PICKAXE = registerItem("argentium_pickaxe",
            settings -> new Item(settings.pickaxe(ModToolMaterials.ARGENTIUM, 1.0F, -2.8F)));
    public static final Item ARGENTIUM_AXE = registerItem("argentium_axe",
            settings -> new AxeItem(ModToolMaterials.ARGENTIUM, 5.75F, -3.1F, settings));
    public static final Item ARGENTIUM_SHOVEL = registerItem("argentium_shovel",
            settings -> new ShovelItem(ModToolMaterials.ARGENTIUM, 1.5F, -2.8F, settings));
    public static final Item ARGENTIUM_HOE = registerItem("argentium_hoe",
            settings -> new HoeItem(ModToolMaterials.ARGENTIUM, -2.5F, 1.0F, settings));

    public static final Item ARGENTIUM_DAGGER = registerItem("argentium_dagger",
            settings -> new DaggerItem(
                    ModToolMaterials.ARGENTIUM,
                    1.5F,
                    -2.0F,
                    settings,
                    List.of(new StatusEffectInstance(StatusEffects.POISON, 60, 0))
            ));
    public static final Item ARGENTIUM_SCYTHE = registerItem("argentium_scythe",
            settings -> new ScytheItem(
                    ModToolMaterials.ARGENTIUM,
                    4.25F,
                    -2.75F,
                    settings,
                    1,
                    false,
                    List.of(),
                    true,
                    0.00F // 0.05F -> 5 hit for 0.5 hearth
            ));

    private static Item registerItem(String name, Function<Item.Settings, Item> function) {
        return Registry.register(Registries.ITEM, Identifier.of(Medivalism.MOD_ID, name),
                function.apply(new Item.Settings().registryKey(RegistryKey.of(RegistryKeys.ITEM, Identifier.of(Medivalism.MOD_ID, name)))));
    }

    public static void registerModItems() {
        Medivalism.LOGGER.info("Registering Mod Items for " + Medivalism.MOD_ID);
    }

}
