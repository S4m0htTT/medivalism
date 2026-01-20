package net.samoht.datagen;

import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricLanguageProvider;
import net.minecraft.registry.RegistryWrapper;
import net.samoht.block.ModBlocks;
import net.samoht.item.ModItems;

import java.util.concurrent.CompletableFuture;

public class ModFrenchLangProvider extends FabricLanguageProvider{
    public ModFrenchLangProvider(FabricDataOutput dataOutput, CompletableFuture<RegistryWrapper.WrapperLookup> registryLookup) {
        super(dataOutput, "fr_fr", registryLookup);
    }

    @Override
    public void generateTranslations(RegistryWrapper.WrapperLookup wrapperLookup, FabricLanguageProvider.TranslationBuilder translationBuilder) {
        translationBuilder.add(ModBlocks.ARGENTIUM_ORE, "Minerai d'Argentium");
        translationBuilder.add(ModBlocks.DEEPSLATE_ARGENTIUM_ORE, "Minerai d'Argentium des abîmes");
        translationBuilder.add(ModBlocks.ARGENTIUM_BLOCK, "Block d'Argentium");

        translationBuilder.add(ModItems.RAW_ARGENTIUM, "Argentium brut");
        translationBuilder.add(ModItems.ARGENTIUM_INGOT, "Lingot d'argentium");
        translationBuilder.add(ModItems.ARGENTIUM_HELMET, "Casque en argentium");
        translationBuilder.add(ModItems.ARGENTIUM_CHESTPLATE, "Plastron en argentium");
        translationBuilder.add(ModItems.ARGENTIUM_LEGGINGS, "Jambières en argentium");
        translationBuilder.add(ModItems.ARGENTIUM_BOOTS, "Bottes en argentium");

        translationBuilder.add("itemgroup.medivalism.block_group", "Medivalism Blocks");
        translationBuilder.add("itemgroup.medivalism.ingredients_group", "Medivalism Ingrédients");
        translationBuilder.add("itemgroup.medivalism.combat_group", "Medivalism Combats");
    }
}
