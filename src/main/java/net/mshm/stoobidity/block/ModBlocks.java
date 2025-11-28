package net.mshm.stoobidity.block;

import net.fabricmc.fabric.api.itemgroup.v1.ItemGroupEvents;
import net.minecraft.block.AbstractBlock;
import net.minecraft.block.Block;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.sound.BlockSoundGroup;
import net.minecraft.util.Identifier;
import net.mshm.stoobidity.Stoobidity;

public class ModBlocks {
    public static final Block POO_BLOCK = registerBlock("poo_block",
            new Block(AbstractBlock.Settings.create().strength(70f)
                    .requiresTool().sounds(BlockSoundGroup.HONEY)));


    private static Block registerBlock(String name, Block block) {
        registerBlockItem(name, block);
        return Registry.register(Registries.BLOCK, Identifier.of(Stoobidity.MOD_ID, name), block);
    }

    private static void registerBlockItem(String name, Block block) {
        Registry.register(Registries.ITEM, Identifier.of(Stoobidity.MOD_ID, name),
                new BlockItem(block, new Item.Settings()));
    }

    public static void registerModBlock() {
        Stoobidity.LOGGER.info("Registering Mod Blocks for " + Stoobidity.MOD_ID);
    }
}
