package net.brianshan974.tutorial_mod;

import net.brianshan974.tutorial_mod.blocks.AwesomeBlock;
import net.brianshan974.tutorial_mod.items.Something;
import net.fabricmc.api.ModInitializer;
import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.fabricmc.fabric.api.object.builder.v1.block.FabricBlockSettings;
import net.minecraft.block.Block;
import net.minecraft.block.Material;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraft.sound.BlockSoundGroup;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class TutorialMod implements ModInitializer {
	// This logger is used to write text to the console and the log file.
	// It is considered best practice to use your mod id as the logger's name.
	// That way, it's clear which mod wrote info, warnings, and errors.

	public static final String MOD_ID = "tutorial_mod";

	public static final Logger LOGGER = LoggerFactory.getLogger(MOD_ID);

	public static final Item SOMETHING = new Something(new FabricItemSettings().group(ItemGroups.ITEMS));

	public static final Block SOME_BLOCK = new Block(
			FabricBlockSettings.of(Material.TNT).strength(0.5f, 1200.0f).sounds(BlockSoundGroup.GRASS));
	public static final Block AWESOME_BLOCK = new AwesomeBlock(
			FabricBlockSettings.of(Material.TNT).strength(0.5f, 1200.0f).sounds(BlockSoundGroup.GRASS));
	public static final BlockItem SOME_BLOCK_ITEM = new BlockItem(SOME_BLOCK,
			new FabricItemSettings().group(ItemGroups.BLOCKS));
	public static final BlockItem AWESOME_BLOCK_ITEM = new BlockItem(AWESOME_BLOCK,
			new FabricItemSettings().group(ItemGroups.BLOCKS));

	@Override
	public void onInitialize() {
		// This code runs as soon as Minecraft is in a mod-load-ready state.
		// However, some things (like resources) may still be uninitialized.
		// Proceed with mild caution.

		Registry.register(Registry.ITEM, new Identifier(MOD_ID, "something"), SOMETHING);

		Registry.register(Registry.ITEM, new Identifier(MOD_ID, "some_block"), SOME_BLOCK_ITEM);
		Registry.register(Registry.ITEM, new Identifier(MOD_ID, "awesome_block"), AWESOME_BLOCK_ITEM);

		Registry.register(Registry.BLOCK, new Identifier(MOD_ID, "some_block"), SOME_BLOCK);
		Registry.register(Registry.BLOCK, new Identifier(MOD_ID, "awesome_block"), AWESOME_BLOCK);

		LOGGER.info("Hello Fabric world!");
	}
}
