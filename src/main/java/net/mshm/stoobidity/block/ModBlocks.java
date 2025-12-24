package net.mshm.stoobidity.block;

import net.fabricmc.fabric.api.itemgroup.v1.ItemGroupEvents;
import net.minecraft.block.AbstractBlock;
import net.minecraft.block.Block;
import net.minecraft.block.ExperienceDroppingBlock;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.sound.BlockSoundGroup;
import net.minecraft.util.Identifier;
import net.minecraft.util.math.intprovider.UniformIntProvider;
import net.mshm.stoobidity.Stoobidity;

public class ModBlocks {

//~~EXPERIENCE DROPPING BLOCKS~~
    public static final Block POO_ORE = registerBlock("poo_ore",
            new ExperienceDroppingBlock(UniformIntProvider.create(2, 5),
                    AbstractBlock.Settings.create().strength(3f)
                    .requiresTool().sounds(BlockSoundGroup.STONE)));
    public static final Block POO_ORE_DEEPSLATE = registerBlock("poo_ore_deepslate",
            new ExperienceDroppingBlock(UniformIntProvider.create(3, 5),
                    AbstractBlock.Settings.create().strength(4.5f)
                    .requiresTool().sounds(BlockSoundGroup.DEEPSLATE)));
//~~REGULAR BLOCKS~~
    public static final Block POO_BLOCK = registerBlock("poo_block",
            new Block(AbstractBlock.Settings.create().strength(0.2f).sounds(BlockSoundGroup.HONEY)));
    public static final Block PETRIFIED_POO_BLOCK = registerBlock("petrified_poo_block",
            new Block(AbstractBlock.Settings.create().strength(2f)
                    .requiresTool().sounds(BlockSoundGroup.STONE)));




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
