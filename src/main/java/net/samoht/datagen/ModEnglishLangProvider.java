package net.samoht.datagen;

import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricLanguageProvider;
import net.minecraft.registry.RegistryWrapper;
import net.samoht.block.ModBlocks;
import net.samoht.item.ModItems;

import java.util.concurrent.CompletableFuture;

public class ModEnglishLangProvider extends FabricLanguageProvider {
    public ModEnglishLangProvider(FabricDataOutput dataOutput, CompletableFuture<RegistryWrapper.WrapperLookup> registryLookup) {
        super(dataOutput, "en_us", registryLookup);
    }

    @Override
    public void generateTranslations(RegistryWrapper.WrapperLookup wrapperLookup, TranslationBuilder translationBuilder) {
        translationBuilder.add(ModBlocks.ARGENTIUM_ORE, "Argentium Ore");
        translationBuilder.add(ModBlocks.DEEPSLATE_ARGENTIUM_ORE, "Deepslate Argentium Ore");
        translationBuilder.add(ModBlocks.ARGENTIUM_BLOCK, "Argentium Block");

        translationBuilder.add(ModItems.RAW_ARGENTIUM, "Raw Argentium");
        translationBuilder.add(ModItems.ARGENTIUM_INGOT, "Argentium Ingot");
        translationBuilder.add(ModItems.ARGENTIUM_HELMET, "Argentium Helmet");
        translationBuilder.add(ModItems.ARGENTIUM_CHESTPLATE, "Argentium Chestplate");
        translationBuilder.add(ModItems.ARGENTIUM_LEGGINGS, "Argentium Leggings");
        translationBuilder.add(ModItems.ARGENTIUM_BOOTS, "Argentium Boots");
        translationBuilder.add(ModItems.ARGENTIUM_SWORD, "Argentium Sword");
        translationBuilder.add(ModItems.ARGENTIUM_SPEAR, "Argentium Spear");
        translationBuilder.add(ModItems.ARGENTIUM_PICKAXE, "Argentium Pickaxe");
        translationBuilder.add(ModItems.ARGENTIUM_AXE, "Argentium Axe");
        translationBuilder.add(ModItems.ARGENTIUM_SHOVEL, "Argentium Shovel");
        translationBuilder.add(ModItems.ARGENTIUM_HOE, "Argentium Hoe");
        translationBuilder.add(ModItems.ARGENTIUM_DAGGER, "Argentium Dagger");
        translationBuilder.add(ModItems.ARGENTIUM_SCYTHE, "Argentium Scythe");
        translationBuilder.add(ModItems.PYROLITHE, "Pyrolithe");

        translationBuilder.add("itemgroup.medivalism.block_group", "Medivalism Blocks");
        translationBuilder.add("itemgroup.medivalism.ingredients_group", "Medivalism Ingredients");
        translationBuilder.add("itemgroup.medivalism.combat_group", "Medivalism Combats");
        translationBuilder.add("itemgroup.medivalism.tools_group", "Medivalism Tools");
    }
}
