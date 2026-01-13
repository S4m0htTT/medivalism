package net.samoht.datagen;

import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricLanguageProvider;
import net.minecraft.registry.RegistryWrapper;
import net.samoht.block.ModBlocks;

import java.util.concurrent.CompletableFuture;

public class ModFrenchLangProvider extends FabricLanguageProvider{
    public ModFrenchLangProvider(FabricDataOutput dataOutput, CompletableFuture<RegistryWrapper.WrapperLookup> registryLookup) {
        super(dataOutput, "fr_fr", registryLookup);
    }

    @Override
    public void generateTranslations(RegistryWrapper.WrapperLookup wrapperLookup, FabricLanguageProvider.TranslationBuilder translationBuilder) {
        translationBuilder.add(ModBlocks.ARGENTIUM_ORE, "Minerai d'Argentium");
        translationBuilder.add(ModBlocks.DEEPSLATE_ARGENTIUM_ORE, "Minerai d'Argentium des abîmes");
    }
}
