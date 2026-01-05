package net.mshm.stoobidity.block;

import net.minecraft.block.*;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.sound.BlockSoundGroup;
import net.minecraft.util.Identifier;
import net.minecraft.util.math.intprovider.UniformIntProvider;
import net.mshm.stoobidity.Stoobidity;
import net.mshm.stoobidity.block.custom.SacrificialAltar;

public class ModBlocks {

//~~EXPERIENCE DROPPING BLOCKS~~
    public static final Block POO_ORE = registerBlock("poo_ore",
            new ExperienceDroppingBlock(UniformIntProvider.create(2, 5),
                    AbstractBlock.Settings.create().strength(3f).requiresTool().sounds(BlockSoundGroup.STONE)));
    public static final Block POO_ORE_DEEPSLATE = registerBlock("poo_ore_deepslate",
            new ExperienceDroppingBlock(UniformIntProvider.create(3, 5),
                    AbstractBlock.Settings.create().strength(4.5f).requiresTool().sounds(BlockSoundGroup.DEEPSLATE)));
//~~REGULAR BLOCKS~~
    public static final Block POO_BLOCK = registerBlock("poo_block",
            new Block(AbstractBlock.Settings.create().strength(1.4f).sounds(BlockSoundGroup.HONEY)));
        //Non-Block Poo Blocks
        public static final Block POO_STAIRS = registerBlock("poo_stairs",
                new StairsBlock(ModBlocks.POO_BLOCK.getDefaultState(), AbstractBlock.Settings.create().strength(1.4f).requiresTool()));
        public static final Block POO_SLAB = registerBlock("poo_slab",
                new SlabBlock(AbstractBlock.Settings.create().strength(1.4f).requiresTool()));
                //Button + Pressure_Plate
        public static final Block POO_BUTTON = registerBlock("poo_button",
                new ButtonBlock(BlockSetType.IRON, 120, AbstractBlock.Settings.create().strength(1.4f).requiresTool().noCollision()));
        public static final Block POO_PRESSURE_PLATE = registerBlock("poo_pressure_plate",
                new PressurePlateBlock(BlockSetType.IRON, AbstractBlock.Settings.create().strength(1.4f).requiresTool().noCollision()));
                //Fence + Gate + Wall
        public static final Block POO_FENCE = registerBlock("poo_fence",
                new FenceBlock(AbstractBlock.Settings.create().strength(1.4f).requiresTool()));
        public static final Block POO_FENCE_GATE = registerBlock("poo_fence_gate",
                new FenceGateBlock(WoodType.ACACIA, AbstractBlock.Settings.create().strength(1.4f).requiresTool()));
        public static final Block POO_WALL = registerBlock("poo_wall",
                new WallBlock(AbstractBlock.Settings.create().strength(1.4f).requiresTool()));
                //Door + Trapdoor
        public static final Block POO_DOOR = registerBlock("poo_door",
                new DoorBlock(BlockSetType.ACACIA, AbstractBlock.Settings.create().strength(1.4f).requiresTool().nonOpaque()));
        public static final Block POO_TRAPDOOR = registerBlock("poo_trapdoor",
                new TrapdoorBlock(BlockSetType.ACACIA, AbstractBlock.Settings.create().strength(1.4f).requiresTool().nonOpaque()));
    //
    public static final Block PETRIFIED_POO_BLOCK = registerBlock("petrified_poo_block",
            new Block(AbstractBlock.Settings.create().strength(2f)
                    .requiresTool().sounds(BlockSoundGroup.STONE)));
        //Non-Block Petrified Blocks
        public static final Block PP_STAIRS = registerBlock("pp_stairs",
                new StairsBlock(ModBlocks.PETRIFIED_POO_BLOCK.getDefaultState(), AbstractBlock.Settings.create().strength(2f).requiresTool()));
        public static final Block PP_SLAB = registerBlock("petrified_poo_slab",
                new SlabBlock(AbstractBlock.Settings.create().strength(2f).requiresTool()));
        //Button + Pressure_Plate
        public static final Block PP_BUTTON = registerBlock("petrified_poo_button",
                new ButtonBlock(BlockSetType.IRON, 12, AbstractBlock.Settings.create().strength(2f).requiresTool().noCollision()));
        public static final Block PP_PRESSURE_PLATE = registerBlock("petrified_poo_pressure_plate",
                new PressurePlateBlock(BlockSetType.IRON, AbstractBlock.Settings.create().strength(2f).requiresTool().noCollision()));
        //Fence + Gate + Wall
        public static final Block PP_FENCE = registerBlock("petrified_poo_fence",
                new FenceBlock(AbstractBlock.Settings.create().strength(2f).requiresTool()));
        public static final Block PP_FENCE_GATE = registerBlock("petrified_poo_fence_gate",
                new FenceGateBlock(WoodType.ACACIA, AbstractBlock.Settings.create().strength(2f).requiresTool()));
        public static final Block PP_WALL = registerBlock("petrified_poo_wall",
                new WallBlock(AbstractBlock.Settings.create().strength(2f).requiresTool()));
        //Door + Trapdoor
        public static final Block PP_DOOR = registerBlock("petrified_poo_door",
                new DoorBlock(BlockSetType.ACACIA, AbstractBlock.Settings.create().strength(2f).requiresTool().nonOpaque()));
        public static final Block PP_TRAPDOOR = registerBlock("petrified_poo_trapdoor",
                new TrapdoorBlock(BlockSetType.ACACIA, AbstractBlock.Settings.create().strength(2f).requiresTool().nonOpaque()));

    //~~Custom
    public static final Block SACRIFICIAL_ALTAR = registerBlock("sacrificial_altar",
            new SacrificialAltar(AbstractBlock.Settings.create().strength(1f).requiresTool()));




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
