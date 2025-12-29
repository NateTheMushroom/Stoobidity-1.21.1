package net.mshm.stoobidity.item.custom;

import net.minecraft.block.Block;
import net.minecraft.block.Blocks;
import net.minecraft.entity.EquipmentSlot;
import net.minecraft.item.Item;
import net.minecraft.item.ItemUsageContext;
import net.minecraft.server.network.ServerPlayerEntity;
import net.minecraft.server.world.ServerWorld;
import net.minecraft.sound.SoundCategory;
import net.minecraft.sound.SoundEvents;
import net.minecraft.util.ActionResult;
import net.minecraft.world.World;

import java.util.Map;

public class ShizelItem extends Item {
    private static final Map<Block, Block> SHIZEL_MAP =
            Map.of(
                    Blocks.STONE, Blocks.STONE_BRICKS,
                    Blocks.END_STONE, Blocks.END_STONE_BRICKS,
                    Blocks.CLAY, Blocks.BRICKS,
                    Blocks.DEEPSLATE, Blocks.DEEPSLATE_BRICKS,
                    Blocks.QUARTZ_BLOCK, Blocks.QUARTZ_BRICKS,
                    Blocks.PACKED_MUD, Blocks.MUD_BRICKS,
                    Blocks.PRISMARINE, Blocks.PRISMARINE_BRICKS,
                    Blocks.NETHERRACK, Blocks.NETHER_BRICKS,
                    Blocks.POLISHED_BLACKSTONE, Blocks.POLISHED_BLACKSTONE_BRICKS,
                    Blocks.COPPER_BLOCK, Blocks.CUT_COPPER
            );

    public ShizelItem(Settings settings) {
        super(settings);
    }

    @Override
    public ActionResult useOnBlock(ItemUsageContext context) {
        World world = context.getWorld();
        Block clickedBlock = world.getBlockState(context.getBlockPos()).getBlock();

        if(SHIZEL_MAP.containsKey(clickedBlock)) {
            if(!world.isClient()) {
                world.setBlockState(context.getBlockPos(), SHIZEL_MAP.get(clickedBlock).getDefaultState());

                context.getStack().damage(1, ((ServerWorld) world), ((ServerPlayerEntity) context.getPlayer()),
                        item -> context.getPlayer().sendEquipmentBreakStatus(item, EquipmentSlot.MAINHAND));

                world.playSound(null, context.getBlockPos(), SoundEvents.BLOCK_HONEY_BLOCK_FALL, SoundCategory.BLOCKS);

            }
        }

        return ActionResult.SUCCESS;
    }
}
