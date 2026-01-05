package net.mshm.stoobidity.datagen;

import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricBlockLootTableProvider;
import net.minecraft.block.Block;
import net.minecraft.enchantment.Enchantment;
import net.minecraft.enchantment.Enchantments;
import net.minecraft.item.Item;
import net.minecraft.item.Items;
import net.minecraft.loot.LootTable;
import net.minecraft.loot.entry.ItemEntry;
import net.minecraft.loot.entry.LeafEntry;
import net.minecraft.loot.entry.LootPoolEntry;
import net.minecraft.loot.function.ApplyBonusLootFunction;
import net.minecraft.loot.function.SetCountLootFunction;
import net.minecraft.loot.provider.number.UniformLootNumberProvider;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.registry.RegistryWrapper;
import net.mshm.stoobidity.block.ModBlocks;
import net.mshm.stoobidity.item.ModItems;

import java.util.concurrent.CompletableFuture;

public class ModLootTableProvider extends FabricBlockLootTableProvider {
    public ModLootTableProvider(FabricDataOutput dataOutput, CompletableFuture<RegistryWrapper.WrapperLookup> registryLookup) {
        super(dataOutput, registryLookup);
    }

    @Override
    public void generate() {
        addDrop(ModBlocks.POO_BLOCK);
        addDrop(ModBlocks.PETRIFIED_POO_BLOCK);
        addDrop(ModBlocks.SACRIFICIAL_ALTAR);
        addDrop(ModBlocks.POO_STAIRS);
        addDrop(ModBlocks.POO_SLAB, slabDrops(ModBlocks.POO_SLAB));
        addDrop(ModBlocks.POO_BUTTON);
        addDrop(ModBlocks.POO_PRESSURE_PLATE);
        addDrop(ModBlocks.POO_FENCE);
        addDrop(ModBlocks.POO_FENCE_GATE);
        addDrop(ModBlocks.POO_WALL);
        addDrop(ModBlocks.POO_DOOR, doorDrops(ModBlocks.POO_DOOR));
        addDrop(ModBlocks.POO_TRAPDOOR);
        addDrop(ModBlocks.PP_STAIRS);
        addDrop(ModBlocks.PP_SLAB, slabDrops(ModBlocks.PP_SLAB));
        addDrop(ModBlocks.PP_BUTTON);
        addDrop(ModBlocks.PP_PRESSURE_PLATE);
        addDrop(ModBlocks.PP_FENCE);
        addDrop(ModBlocks.PP_FENCE_GATE);
        addDrop(ModBlocks.PP_WALL);
        addDrop(ModBlocks.PP_DOOR, doorDrops(ModBlocks.PP_DOOR));
        addDrop(ModBlocks.PP_TRAPDOOR);

        addDrop(ModBlocks.POO_ORE, multipleOreDrops(ModBlocks.POO_ORE, ModItems.PETRIFIED_POO, 2, 4));
        addDrop(ModBlocks.POO_ORE_DEEPSLATE, multipleOreDrops(ModBlocks.POO_ORE_DEEPSLATE, ModItems.PETRIFIED_POO, 3, 7));
    }

    public LootTable.Builder multipleOreDrops(Block drop, Item item, float minDrops, float maxDrops) {
        RegistryWrapper.Impl<Enchantment> impl = this.registryLookup.getWrapperOrThrow(RegistryKeys.ENCHANTMENT);
        return this.dropsWithSilkTouch(drop, this.applyExplosionDecay(drop, ((LeafEntry.Builder<?>)
                ItemEntry.builder(item).apply(SetCountLootFunction.builder(UniformLootNumberProvider.create(minDrops, maxDrops))))
                .apply(ApplyBonusLootFunction.oreDrops(impl.getOrThrow(Enchantments.FORTUNE)))));
    }
}
