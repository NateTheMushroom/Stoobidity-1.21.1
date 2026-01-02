package net.mshm.stoobidity.datagen;

import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricTagProvider;
import net.minecraft.item.Items;
import net.minecraft.registry.RegistryWrapper;
import net.mshm.stoobidity.item.ModItems;
import net.mshm.stoobidity.util.ModTags;

import java.util.concurrent.CompletableFuture;

public class ModItemTagProvider extends FabricTagProvider.ItemTagProvider {
    public ModItemTagProvider(FabricDataOutput output, CompletableFuture<RegistryWrapper.WrapperLookup> completableFuture) {
        super(output, completableFuture);
    }

    @Override
    protected void configure(RegistryWrapper.WrapperLookup wrapperLookup) {
        getOrCreateTagBuilder(ModTags.Items.SACRIFICABLE_ITEMS)
                .add(ModItems.POO)
                .add(ModItems.PETRIFIED_POO)
                .add(Items.BONE_MEAL)
                .add(Items.ROTTEN_FLESH);

    }
}
