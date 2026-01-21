package net.samoht.datagen;

import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricTagProvider;
import net.minecraft.registry.RegistryWrapper;
import net.minecraft.registry.tag.ItemTags;
import net.samoht.item.ModItems;
import net.samoht.util.ModTags;

import java.util.concurrent.CompletableFuture;

public class ModItemTagProvider extends FabricTagProvider.ItemTagProvider{
    public ModItemTagProvider(FabricDataOutput output, CompletableFuture<RegistryWrapper.WrapperLookup> registriesFuture) {
        super(output, registriesFuture);
    }

    @Override
    protected void configure(RegistryWrapper.WrapperLookup wrapperLookup) {
        valueLookupBuilder(ModTags.Items.ARGENTIUM_REPAIR)
                .add(ModItems.ARGENTIUM_INGOT);

        valueLookupBuilder(ItemTags.TRIM_MATERIALS)
                .add(ModItems.ARGENTIUM_INGOT);

        valueLookupBuilder(ItemTags.TRIMMABLE_ARMOR)
                .add(ModItems.ARGENTIUM_HELMET)
                .add(ModItems.ARGENTIUM_CHESTPLATE)
                .add(ModItems.ARGENTIUM_LEGGINGS)
                .add(ModItems.ARGENTIUM_BOOTS);
    }
}
