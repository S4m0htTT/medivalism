package net.samoht.datagen;

import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricRecipeProvider;
import net.minecraft.data.recipe.RecipeExporter;
import net.minecraft.data.recipe.RecipeGenerator;
import net.minecraft.item.ItemConvertible;
import net.minecraft.recipe.book.RecipeCategory;
import net.minecraft.registry.RegistryWrapper;
import net.samoht.block.ModBlocks;
import net.samoht.item.ModItems;

import java.util.List;
import java.util.concurrent.CompletableFuture;

public class ModRecipeProvider extends FabricRecipeProvider{
    public ModRecipeProvider(FabricDataOutput output, CompletableFuture<RegistryWrapper.WrapperLookup> registriesFuture) {
        super(output, registriesFuture);
    }

    @Override
    protected RecipeGenerator getRecipeGenerator(RegistryWrapper.WrapperLookup wrapperLookup, RecipeExporter recipeExporter) {
        return new RecipeGenerator(wrapperLookup, recipeExporter) {
            @Override
            public void generate() {
                List<ItemConvertible> ARGENTIUM_SMELTABLES = List.of(ModBlocks.ARGENTIUM_ORE, ModBlocks.DEEPSLATE_ARGENTIUM_ORE, ModItems.RAW_ARGENTIUM);

                offerSmelting(ARGENTIUM_SMELTABLES, RecipeCategory.MISC, ModItems.ARGENTIUM_INGOT, 0.25f, 200, "argentium");
                offerBlasting(ARGENTIUM_SMELTABLES, RecipeCategory.MISC, ModItems.ARGENTIUM_INGOT, 0.25f, 100, "argentium");

                createShaped(RecipeCategory.MISC, ModBlocks.ARGENTIUM_BLOCK)
                        .pattern("AAA")
                        .pattern("AAA")
                        .pattern("AAA")
                        .input('A', ModItems.ARGENTIUM_INGOT)
                        .criterion(hasItem(ModItems.ARGENTIUM_INGOT), conditionsFromItem(ModItems.ARGENTIUM_INGOT))
                        .offerTo(recipeExporter);
            }
        };
    }

    @Override
    public String getName() {
        return "Medivalism Recipes";
    }
}
