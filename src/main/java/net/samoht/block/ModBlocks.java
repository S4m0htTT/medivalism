package net.samoht.block;

import net.minecraft.block.AbstractBlock;
import net.minecraft.block.Block;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.registry.RegistryKey;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.sound.BlockSoundGroup;
import net.minecraft.util.Identifier;
import net.samoht.Medivalism;

import java.util.function.Function;

public class ModBlocks {

    public static final Block ARGENTIUM_ORE = registerBlock("argentium_ore",
            settings -> new Block(settings.strength(4f)
                    .requiresTool().sounds(BlockSoundGroup.STONE)));
    public static final Block DEEPSLATE_ARGENTIUM_ORE = registerBlock("deepslate_argentium_ore",
            settings -> new Block(settings.strength(4f)
                    .requiresTool().sounds(BlockSoundGroup.DEEPSLATE)));
    public static final Block ARGENTIUM_BLOCK = registerBlock("argentium_block",
            settings -> new Block(settings.strength(4f)));

    private static Block registerBlock(String name, Function<AbstractBlock.Settings, Block> function) {
        Block toRegister = function.apply(AbstractBlock.Settings.create().registryKey(RegistryKey.of(RegistryKeys.BLOCK, Identifier.of(Medivalism.MOD_ID, name))));
        registerBlockItem(name, toRegister);
        return Registry.register(Registries.BLOCK, Identifier.of(Medivalism.MOD_ID, name), toRegister);
    }

    private static Block registerBlockWithoutBlockItem(String name, Function<AbstractBlock.Settings, Block> function) {
        return Registry.register(Registries.BLOCK, Identifier.of(Medivalism.MOD_ID, name),
                function.apply(AbstractBlock.Settings.create().registryKey(RegistryKey.of(RegistryKeys.BLOCK, Identifier.of(Medivalism.MOD_ID, name)))));
    }

    private static void registerBlockItem(String name, Block block) {
        Registry.register(Registries.ITEM, Identifier.of(Medivalism.MOD_ID, name),
                new BlockItem(block, new Item.Settings().useBlockPrefixedTranslationKey()
                        .registryKey(RegistryKey.of(RegistryKeys.ITEM, Identifier.of(Medivalism.MOD_ID, name)))));
    }

    public static void registerModBlocks() {
        Medivalism.LOGGER.info("Registering Mod Blocks for " + Medivalism.MOD_ID);
    }

}
