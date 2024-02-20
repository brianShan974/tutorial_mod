package net.brianshan974.tutorial_mod;

import net.fabricmc.fabric.api.client.itemgroup.FabricItemGroupBuilder;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;
import net.minecraft.util.Identifier;

public class ItemGroups {

    public static final ItemGroup ITEMS = FabricItemGroupBuilder.build(
            new Identifier(TutorialMod.MOD_ID, "items"),
            () -> new ItemStack(TutorialMod.SOMETHING)
    );

    public static final ItemGroup BLOCKS = FabricItemGroupBuilder.build(
            new Identifier(TutorialMod.MOD_ID, "blocks"),
            () -> new ItemStack(TutorialMod.SOME_BLOCK)
    );

}
