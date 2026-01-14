package net.samoht;

import net.fabricmc.api.ModInitializer;

import net.samoht.block.ModBlocks;
import net.samoht.item.ModItemGroups;
import net.samoht.item.ModItems;
import net.samoht.world.gen.ModWorldGeneration;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Medivalism implements ModInitializer {
	public static final String MOD_ID = "medivalism";
	public static final Logger LOGGER = LoggerFactory.getLogger(MOD_ID);

	@Override
	public void onInitialize() {
		ModItemGroups.registerItemGroups();

		ModBlocks.registerModBlocks();
		ModItems.registerModItems();

		ModWorldGeneration.generateModWorldGen();
	}
}