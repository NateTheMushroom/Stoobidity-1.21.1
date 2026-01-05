package net.mshm.stoobidity.datagen;

import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricTagProvider;
import net.minecraft.block.Block;
import net.minecraft.registry.RegistryWrapper;
import net.minecraft.registry.tag.BlockTags;
import net.mshm.stoobidity.block.ModBlocks;

import java.util.concurrent.CompletableFuture;

public class ModBlockTagProvider extends FabricTagProvider.BlockTagProvider {
    public ModBlockTagProvider(FabricDataOutput output, CompletableFuture<RegistryWrapper.WrapperLookup> registriesFuture) {
        super(output, registriesFuture);
    }

    @Override
    protected void configure(RegistryWrapper.WrapperLookup wrapperLookup) {
        getOrCreateTagBuilder(BlockTags.PICKAXE_MINEABLE)
                .add(ModBlocks.PETRIFIED_POO_BLOCK)
                .add(ModBlocks.POO_ORE)
                .add(ModBlocks.POO_ORE_DEEPSLATE)
                .add(ModBlocks.SACRIFICIAL_ALTAR);

        getOrCreateTagBuilder(BlockTags.NEEDS_IRON_TOOL)
                .add(ModBlocks.POO_ORE)
                .add(ModBlocks.POO_ORE_DEEPSLATE);
        getOrCreateTagBuilder(BlockTags.NEEDS_DIAMOND_TOOL)
                .add(ModBlocks.SACRIFICIAL_ALTAR);

        getOrCreateTagBuilder(BlockTags.FENCES)
                .add(ModBlocks.POO_FENCE)
                .add(ModBlocks.PP_FENCE);
        getOrCreateTagBuilder(BlockTags.FENCE_GATES)
                .add(ModBlocks.POO_FENCE_GATE)
                .add(ModBlocks.PP_FENCE_GATE);
        getOrCreateTagBuilder(BlockTags.WALLS)
                .add(ModBlocks.POO_WALL)
                .add(ModBlocks.PP_WALL);
    }
}
