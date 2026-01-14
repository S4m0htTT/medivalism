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
    }
}
