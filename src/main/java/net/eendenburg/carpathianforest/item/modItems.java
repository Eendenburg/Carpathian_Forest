package net.eendenburg.carpathianforest.item;

import net.eendenburg.carpathianforest.CarpathianForest;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.world.item.Item;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.registries.DeferredItem;
import net.neoforged.neoforge.registries.DeferredRegister;
import net.neoforged.neoforge.registries.NeoForgeRegistries;
import net.neoforged.neoforge.registries.RegistryBuilder;

public class modItems {
    public static final DeferredRegister.Items ITEMS =
            DeferredRegister.createItems("carpathian_forest");

    public static final DeferredItem<Item> APATITE = ITEMS.register("apatite",
            () -> new Item(new Item.Properties()));
    public static final DeferredItem<Item> APATITE_DUST = ITEMS.register("apatite_dust",
            () -> new Item(new Item.Properties()));

    public static void register(IEventBus eventBus) {
        ITEMS.register(eventBus);
    }
}
