package net.mshm.stoobidity.item;

import net.fabricmc.fabric.api.itemgroup.v1.ItemGroupEvents;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroups;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;
import net.mshm.stoobidity.Stoobidity;
import net.mshm.stoobidity.item.custom.ShizelItem;

public class ModItems {
    public static final Item PETRIFIED_POO = registerItem("petrified_poo", new Item(new Item.Settings()));
    public static final Item POO = registerItem("poo", new Item(new Item.Settings()));
    public static final Item VEIN_SHARD = registerItem("vein_shard", new Item(new Item.Settings()));

//~~CUSTOM ITEMS~~
    public static final Item SHIZEL = registerItem("shizel", new ShizelItem(new Item.Settings().maxDamage(600)));
//~~            ~~

    private static Item registerItem(String name, Item item) {
        return Registry.register(Registries.ITEM, Identifier.of(Stoobidity.MOD_ID, name), item);
    }

    public static void registerModItems() {
        Stoobidity.LOGGER.info("Registering Mod Items for " + Stoobidity.MOD_ID);

        ItemGroupEvents.modifyEntriesEvent(ItemGroups.SEARCH).register(fabricItemGroupEntries -> {
            fabricItemGroupEntries.add(PETRIFIED_POO);
            fabricItemGroupEntries.add(POO);
        });
    }
}
