package net.samoht.datagen;

import net.fabricmc.fabric.api.client.datagen.v1.provider.FabricModelProvider;
import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.minecraft.client.data.BlockStateModelGenerator;
import net.minecraft.client.data.ItemModelGenerator;
import net.minecraft.client.data.Models;
import net.samoht.block.ModBlocks;
import net.samoht.item.ModArmorMaterials;
import net.samoht.item.ModItems;

public class ModModelProvider extends FabricModelProvider {
    public ModModelProvider(FabricDataOutput output) {
        super(output);
    }

    @Override
    public void generateBlockStateModels(BlockStateModelGenerator blockStateModelGenerator) {
        blockStateModelGenerator.registerSimpleCubeAll(ModBlocks.ARGENTIUM_ORE);
        blockStateModelGenerator.registerSimpleCubeAll(ModBlocks.DEEPSLATE_ARGENTIUM_ORE);
        blockStateModelGenerator.registerSimpleCubeAll(ModBlocks.ARGENTIUM_BLOCK);
    }

    @Override
    public void generateItemModels(ItemModelGenerator itemModelGenerator) {
        itemModelGenerator.register(ModItems.RAW_ARGENTIUM, Models.GENERATED);
        itemModelGenerator.register(ModItems.ARGENTIUM_INGOT, Models.GENERATED);

        itemModelGenerator.registerArmor(ModItems.ARGENTIUM_HELMET, ModArmorMaterials.ARGENTIUM_KEY, ItemModelGenerator.HELMET_TRIM_ID_PREFIX, false);
        itemModelGenerator.registerArmor(ModItems.ARGENTIUM_CHESTPLATE, ModArmorMaterials.ARGENTIUM_KEY, ItemModelGenerator.CHESTPLATE_TRIM_ID_PREFIX, false);
        itemModelGenerator.registerArmor(ModItems.ARGENTIUM_LEGGINGS, ModArmorMaterials.ARGENTIUM_KEY, ItemModelGenerator.CHESTPLATE_TRIM_ID_PREFIX, false);
        itemModelGenerator.registerArmor(ModItems.ARGENTIUM_BOOTS, ModArmorMaterials.ARGENTIUM_KEY, ItemModelGenerator.CHESTPLATE_TRIM_ID_PREFIX, false);
    }
}
