package net.mshm.stoobidity.item;

import net.fabricmc.fabric.api.itemgroup.v1.FabricItemGroup;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.text.Text;
import net.minecraft.util.Identifier;
import net.mshm.stoobidity.Stoobidity;
import net.mshm.stoobidity.block.ModBlocks;

public class ModItemGroups {
    public static final ItemGroup STOOBID_CRAP = Registry.register(Registries.ITEM_GROUP,
            Identifier.of(Stoobidity.MOD_ID, "stoobid_crap"),
            FabricItemGroup.builder().icon(() -> new ItemStack(ModItems.POO))
                    .displayName(Text.translatable("itemgroup.stoobidity.stoobid_crap"))
                    .entries((displayContext, entries) -> {
                //~~Items~~
                    //Normal
                        entries.add(ModItems.POO);
                        entries.add(ModItems.PETRIFIED_POO);
                        entries.add(ModItems.VEIN_SHARD);
                        entries.add(ModItems.NOT_A_CROSS);
                    //Custom
                        entries.add(ModItems.SHIZEL);
                    //Food
                        entries.add(ModItems.HALLS);

                //~~Blocks~~
                        entries.add(ModBlocks.POO_ORE);
                        entries.add(ModBlocks.POO_ORE_DEEPSLATE);
                        entries.add(ModBlocks.POO_BLOCK);
                        entries.add(ModBlocks.PETRIFIED_POO_BLOCK);
                    //Custom
                        entries.add(ModBlocks.SACRIFICIAL_ALTAR);
                    }).build());

    public static void registerItemGroups() {
        Stoobidity.LOGGER.info("Registering Item Groups for " + Stoobidity.MOD_ID);
    }
}
