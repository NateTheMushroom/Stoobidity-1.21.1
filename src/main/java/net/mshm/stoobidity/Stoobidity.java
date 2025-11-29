package net.mshm.stoobidity;

import net.fabricmc.api.ModInitializer;

import net.mshm.stoobidity.block.ModBlocks;
import net.mshm.stoobidity.item.ModItemGroups;
import net.mshm.stoobidity.item.ModItems;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Stoobidity implements ModInitializer {
	public static final String MOD_ID = "stoobidity";
    public static final Logger LOGGER = LoggerFactory.getLogger(MOD_ID);

	@Override
	public void onInitialize() {
        ModItemGroups.registerItemGroups();

        ModItems.registerModItems();
        ModBlocks.registerModBlock();
	}
}