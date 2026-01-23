package net.samoht.item;

import net.minecraft.item.ToolMaterial;
import net.samoht.util.ModTags;

public class ModToolMaterials {
    public static final ToolMaterial ARGENTIUM;

    static {
        ARGENTIUM = new ToolMaterial(ModTags.Blocks.INCORRECT_FOR_ARGENTIUM_TOOL, 275, 6.5F, 2.25F, 15, ModTags.Items.ARGENTIUM_REPAIR);
    }
}
