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

        createStairsRecipe(ModBlocks.POO_STAIRS, Ingredient.ofItems(ModBlocks.POO_BLOCK));
        createSlabRecipe(RecipeCategory.BUILDING_BLOCKS, ModBlocks.POO_SLAB, Ingredient.ofItems(ModBlocks.POO_BLOCK));

    }
}
