package net.samoht.item;

import net.fabricmc.fabric.api.itemgroup.v1.FabricItemGroup;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.text.Text;
import net.minecraft.util.Identifier;
import net.samoht.Medivalism;
import net.samoht.block.ModBlocks;

public class ModItemGroups {
    public static final ItemGroup BLOCK_GROUP = Registry.register(Registries.ITEM_GROUP,
            Identifier.of(Medivalism.MOD_ID, "block_group"),
            //TODO Replace icon by ARGENTIUM_BLOCK or TIMBER_FRAME_CROSS
            FabricItemGroup.builder().icon(() -> new ItemStack(ModBlocks.ARGENTIUM_ORE))
                    .displayName(Text.translatable("itemgroup.medivalism.block_group"))
                    .entries(((displayContext, entries) -> {
                        entries.add(ModBlocks.ARGENTIUM_ORE);
                        entries.add(ModBlocks.DEEPSLATE_ARGENTIUM_ORE);
                        entries.add(ModBlocks.ARGENTIUM_BLOCK);
                    })).build());

    public static final ItemGroup INGREDIENTS_GROUP = Registry.register(Registries.ITEM_GROUP,
            Identifier.of(Medivalism.MOD_ID, "ingredients_group"),
            //TODO Replace icon by ASTRALITE_INGOT
            FabricItemGroup.builder().icon(() -> new ItemStack(ModBlocks.ARGENTIUM_ORE))
                    .displayName(Text.translatable("itemgroup.medivalism.ingredients_group"))
                    .entries(((displayContext, entries) -> {
                        entries.add(ModItems.ARGENTIUM_INGOT);
                        entries.add(ModItems.RAW_ARGENTIUM);
                    })).build());

    public static final ItemGroup COMBAT_GROUP = Registry.register(Registries.ITEM_GROUP,
            Identifier.of(Medivalism.MOD_ID, "combat_group"),
            //TODO Replace icon by SCYTHE_ORICHALCUM or SWORD_ASTRALITE
            FabricItemGroup.builder().icon(() -> new ItemStack(ModItems.ARGENTIUM_CHESTPLATE))
                    .displayName(Text.translatable("itemgroup.medivalism.combat_group"))
                    .entries(((displayContext, entries) -> {
                        entries.add(ModItems.ARGENTIUM_HELMET);
                        entries.add(ModItems.ARGENTIUM_CHESTPLATE);
                        entries.add(ModItems.ARGENTIUM_LEGGINGS);
                        entries.add(ModItems.ARGENTIUM_BOOTS);
                    })).build());

    public static void registerItemGroups() {
        Medivalism.LOGGER.info("Registering Item Groups for " + Medivalism.MOD_ID);
    }
}
