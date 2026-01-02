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
        blockStateModelGenerator.registerSimpleCubeAll(ModBlocks.POO_BLOCK);
        blockStateModelGenerator.registerSimpleCubeAll(ModBlocks.PETRIFIED_POO_BLOCK);
        blockStateModelGenerator.registerSimpleCubeAll(ModBlocks.POO_ORE);
        blockStateModelGenerator.registerSimpleCubeAll(ModBlocks.POO_ORE_DEEPSLATE);

        blockStateModelGenerator.registerSingleton(ModBlocks.SACRIFICIAL_ALTAR, TexturedModel.CUBE_BOTTOM_TOP);
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
