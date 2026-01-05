package net.mshm.stoobidity.datagen;

import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricModelProvider;
import net.minecraft.data.client.BlockStateModelGenerator;
import net.minecraft.data.client.ItemModelGenerator;
import net.minecraft.data.client.Models;
import net.minecraft.data.client.TexturedModel;
import net.mshm.stoobidity.block.ModBlocks;
import net.mshm.stoobidity.item.ModItems;

public class ModModelProvider extends FabricModelProvider {
    public ModModelProvider(FabricDataOutput output) {
        super(output);
    }

    @Override
    public void generateBlockStateModels(BlockStateModelGenerator blockStateModelGenerator) {
        BlockStateModelGenerator.BlockTexturePool pooPool = blockStateModelGenerator.registerCubeAllModelTexturePool(ModBlocks.POO_BLOCK);
        BlockStateModelGenerator.BlockTexturePool ppPool = blockStateModelGenerator.registerCubeAllModelTexturePool(ModBlocks.PETRIFIED_POO_BLOCK);
        blockStateModelGenerator.registerSimpleCubeAll(ModBlocks.POO_ORE);
        blockStateModelGenerator.registerSimpleCubeAll(ModBlocks.POO_ORE_DEEPSLATE);

        blockStateModelGenerator.registerSingleton(ModBlocks.SACRIFICIAL_ALTAR, TexturedModel.CUBE_BOTTOM_TOP);

        pooPool.stairs(ModBlocks.POO_STAIRS);
        pooPool.slab(ModBlocks.POO_SLAB);
        pooPool.button(ModBlocks.POO_BUTTON);
        pooPool.pressurePlate(ModBlocks.POO_PRESSURE_PLATE);
        pooPool.fence(ModBlocks.POO_FENCE);
        pooPool.fenceGate(ModBlocks.POO_FENCE_GATE);
        pooPool.wall(ModBlocks.POO_WALL);
        blockStateModelGenerator.registerDoor(ModBlocks.POO_DOOR);
        blockStateModelGenerator.registerTrapdoor(ModBlocks.POO_TRAPDOOR);

        pooPool.stairs(ModBlocks.PP_STAIRS);
        pooPool.slab(ModBlocks.PP_SLAB);
        pooPool.button(ModBlocks.PP_BUTTON);
        pooPool.pressurePlate(ModBlocks.PP_PRESSURE_PLATE);
        pooPool.fence(ModBlocks.PP_FENCE);
        pooPool.fenceGate(ModBlocks.PP_FENCE_GATE);
        pooPool.wall(ModBlocks.PP_WALL);
        blockStateModelGenerator.registerDoor(ModBlocks.PP_DOOR);
        blockStateModelGenerator.registerTrapdoor(ModBlocks.PP_TRAPDOOR);
    }

    @Override
    public void generateItemModels(ItemModelGenerator itemModelGenerator) {
        itemModelGenerator.register(ModItems.POO, Models.GENERATED);
        itemModelGenerator.register(ModItems.PETRIFIED_POO, Models.GENERATED);
        itemModelGenerator.register(ModItems.SHIZEL, Models.GENERATED);
        itemModelGenerator.register(ModItems.VEIN_SHARD, Models.GENERATED);
        itemModelGenerator.register(ModItems.HALLS, Models.GENERATED);
        itemModelGenerator.register(ModItems.NOT_A_CROSS, Models.GENERATED);

    }
}
