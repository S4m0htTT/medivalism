package net.samoht.item;

import com.google.common.collect.Maps;
import net.minecraft.item.equipment.ArmorMaterial;
import net.minecraft.item.equipment.EquipmentAsset;
import net.minecraft.item.equipment.EquipmentType;
import net.minecraft.registry.Registry;
import net.minecraft.registry.RegistryKey;
import net.minecraft.sound.SoundEvents;
import net.minecraft.util.Identifier;
import net.samoht.Medivalism;
import net.samoht.util.ModTags;

import java.util.Map;

public class ModArmorMaterials {
    static RegistryKey<? extends Registry<EquipmentAsset>> REGISTRY_KEY = RegistryKey.ofRegistry(Identifier.ofVanilla("equipment_asset"));
    public static final RegistryKey<EquipmentAsset> ARGENTIUM_KEY = RegistryKey.of(REGISTRY_KEY, Identifier.of(Medivalism.MOD_ID, "argentium"));

    public static final ArmorMaterial ARGENTIUM_ARMOR_MATERIAL = new ArmorMaterial(250, createDefenseMap(3,5,6,3,6), 15, SoundEvents.ITEM_ARMOR_EQUIP_IRON, 0.0F, 0.0F, ModTags.Items.ARGENTIUM_REPAIR, ARGENTIUM_KEY);

    static Map<EquipmentType, Integer> createDefenseMap(int bootsDefense, int leggingsDefense, int chestplateDefense, int helmetDefense, int bodyDefense) {
        return Maps.newEnumMap(Map.of(EquipmentType.BOOTS, bootsDefense, EquipmentType.LEGGINGS, leggingsDefense, EquipmentType.CHESTPLATE, chestplateDefense, EquipmentType.HELMET, helmetDefense, EquipmentType.BODY, bodyDefense));
    }
}
