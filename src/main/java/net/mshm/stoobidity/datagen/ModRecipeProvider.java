package net.mshm.stoobidity.datagen;

import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricRecipeProvider;
import net.minecraft.data.server.recipe.RecipeExporter;
import net.minecraft.data.server.recipe.ShapedRecipeJsonBuilder;
import net.minecraft.item.ItemConvertible;
import net.minecraft.item.Items;
import net.minecraft.recipe.Ingredient;
import net.minecraft.recipe.book.RecipeCategory;
import net.minecraft.registry.RegistryWrapper;
import net.mshm.stoobidity.block.ModBlocks;
import net.mshm.stoobidity.item.ModItems;

import java.util.List;
import java.util.concurrent.CompletableFuture;

public class ModRecipeProvider extends FabricRecipeProvider {
    public ModRecipeProvider(FabricDataOutput output, CompletableFuture<RegistryWrapper.WrapperLookup> registriesFuture) {
        super(output, registriesFuture);
    }

    @Override
    public void generate(RecipeExporter exporter) {
        List<ItemConvertible> POO_SMELTABLES = List.of(ModItems.PETRIFIED_POO, ModBlocks.POO_ORE, ModBlocks.POO_ORE_DEEPSLATE);

        offerSmelting(exporter, POO_SMELTABLES, RecipeCategory.MISC, ModItems.POO, 0.25f, 200, "poo");
        offerBlasting(exporter, POO_SMELTABLES, RecipeCategory.MISC, ModItems.POO, 0.25f, 100, "poo");

        offerReversibleCompactingRecipes(exporter, RecipeCategory.BUILDING_BLOCKS, ModItems.POO, RecipeCategory.DECORATIONS, ModBlocks.POO_BLOCK);
        offerReversibleCompactingRecipes(exporter, RecipeCategory.BUILDING_BLOCKS, ModItems.PETRIFIED_POO, RecipeCategory.DECORATIONS, ModBlocks.PETRIFIED_POO_BLOCK);


        ShapedRecipeJsonBuilder.create(RecipeCategory.TOOLS, ModItems.SHIZEL)
                .pattern("X")
                .pattern("#")
                .pattern("#")
                .input('X', ModItems.POO)
                .input('#', Items.STICK)
                .criterion(hasItem(ModItems.POO), conditionsFromItem(ModItems.POO))
                .offerTo(exporter);

        createStairsRecipe(ModBlocks.POO_STAIRS, Ingredient.ofItems(ModBlocks.POO_BLOCK))
                .criterion(hasItem(ModItems.POO), conditionsFromItem(ModItems.POO)).offerTo(exporter);
        createTransmutationRecipe(ModBlocks.POO_BUTTON, Ingredient.ofItems(ModBlocks.POO_BLOCK))
                .criterion(hasItem(ModItems.POO), conditionsFromItem(ModItems.POO)).offerTo(exporter);
        createFenceRecipe(ModBlocks.POO_FENCE, Ingredient.ofItems(ModBlocks.POO_BLOCK))
                .criterion(hasItem(ModItems.POO), conditionsFromItem(ModItems.POO)).offerTo(exporter);
        createFenceGateRecipe(ModBlocks.POO_FENCE_GATE, Ingredient.ofItems(ModBlocks.POO_BLOCK))
                .criterion(hasItem(ModItems.POO), conditionsFromItem(ModItems.POO)).offerTo(exporter);
        createDoorRecipe(ModBlocks.POO_DOOR, Ingredient.ofItems(ModBlocks.POO_BLOCK))
                .criterion(hasItem(ModItems.POO), conditionsFromItem(ModItems.POO)).offerTo(exporter);
        createTrapdoorRecipe(ModBlocks.POO_TRAPDOOR, Ingredient.ofItems(ModBlocks.POO_BLOCK))
                .criterion(hasItem(ModItems.POO), conditionsFromItem(ModItems.POO)).offerTo(exporter);
        offerWallRecipe(exporter,RecipeCategory.BUILDING_BLOCKS, ModBlocks.POO_WALL, ModBlocks.POO_BLOCK);
        offerSlabRecipe(exporter, RecipeCategory.BUILDING_BLOCKS, ModBlocks.POO_SLAB, ModBlocks.POO_BLOCK);
        offerPressurePlateRecipe(exporter, ModBlocks.POO_PRESSURE_PLATE, ModBlocks.POO_BLOCK);
        //////////////////////////////////////////////////////////////////////////////////////////
        createStairsRecipe(ModBlocks.PP_STAIRS, Ingredient.ofItems(ModBlocks.PETRIFIED_POO_BLOCK))
                .criterion(hasItem(ModItems.PETRIFIED_POO), conditionsFromItem(ModItems.PETRIFIED_POO)).offerTo(exporter);
        createTransmutationRecipe(ModBlocks.PP_BUTTON, Ingredient.ofItems(ModBlocks.PETRIFIED_POO_BLOCK))
                .criterion(hasItem(ModItems.PETRIFIED_POO), conditionsFromItem(ModItems.PETRIFIED_POO)).offerTo(exporter);
        createFenceRecipe(ModBlocks.PP_FENCE, Ingredient.ofItems(ModBlocks.PETRIFIED_POO_BLOCK))
                .criterion(hasItem(ModItems.PETRIFIED_POO), conditionsFromItem(ModItems.PETRIFIED_POO)).offerTo(exporter);
        createFenceGateRecipe(ModBlocks.PP_FENCE_GATE, Ingredient.ofItems(ModBlocks.PETRIFIED_POO_BLOCK))
                .criterion(hasItem(ModItems.PETRIFIED_POO), conditionsFromItem(ModItems.PETRIFIED_POO)).offerTo(exporter);
        createDoorRecipe(ModBlocks.PP_DOOR, Ingredient.ofItems(ModBlocks.PETRIFIED_POO_BLOCK))
                .criterion(hasItem(ModItems.PETRIFIED_POO), conditionsFromItem(ModItems.PETRIFIED_POO)).offerTo(exporter);
        createTrapdoorRecipe(ModBlocks.PP_TRAPDOOR, Ingredient.ofItems(ModBlocks.PETRIFIED_POO_BLOCK))
                .criterion(hasItem(ModItems.PETRIFIED_POO), conditionsFromItem(ModItems.PETRIFIED_POO)).offerTo(exporter);
        offerWallRecipe(exporter,RecipeCategory.BUILDING_BLOCKS, ModBlocks.PP_WALL, ModBlocks.PETRIFIED_POO_BLOCK);
        offerSlabRecipe(exporter, RecipeCategory.BUILDING_BLOCKS, ModBlocks.PP_SLAB, ModBlocks.PETRIFIED_POO_BLOCK);
        offerPressurePlateRecipe(exporter, ModBlocks.PP_PRESSURE_PLATE, ModBlocks.PETRIFIED_POO_BLOCK);
    }
}
