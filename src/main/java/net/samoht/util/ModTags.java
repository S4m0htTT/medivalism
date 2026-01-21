package net.samoht.util;

import net.minecraft.block.Block;
import net.minecraft.item.Item;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.registry.tag.TagKey;
import net.minecraft.util.Identifier;
import net.samoht.Medivalism;

public class ModTags {
    public static class Blocks {
        private static TagKey<Block> createTag(String name) {
            return TagKey.of(RegistryKeys.BLOCK, Identifier.of(Medivalism.MOD_ID, name));
        }

        public static final TagKey<Block> NEEDS_ARGENTIUM_TOOL = createTag("needs_argentium_tool");
        public static final TagKey<Block> INCORRECT_FOR_ARGENTIUM_TOOL = createTag("incorrect_for_argentium_tool");
    }

    public static class Items {
        private static TagKey<Item> createTag(String name) {
            return TagKey.of(RegistryKeys.ITEM, Identifier.of(Medivalism.MOD_ID, name));
        }

        public static final TagKey<Item> ARGENTIUM_REPAIR = createTag("argentium_repair");
    }
}
