package net.eendenburg.carpathianforest.item;

import net.eendenburg.carpathianforest.CarpathianForest;
import net.eendenburg.carpathianforest.block.modBlocks;
import net.minecraft.core.registries.Registries;
import net.minecraft.network.chat.Component;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.ItemStack;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.registries.DeferredHolder;
import net.neoforged.neoforge.registries.DeferredRegister;

public class modCreativeModeTabs {
    public static final DeferredRegister<CreativeModeTab> CREATIVE_MODE_TAB =
            DeferredRegister.create(Registries.CREATIVE_MODE_TAB, CarpathianForest.MOD_ID);

    public static final DeferredHolder<CreativeModeTab, CreativeModeTab> CARPATHIAN_FOREST_TAB = CREATIVE_MODE_TAB.register("carpathian_forest_tab",
            () -> CreativeModeTab.builder().icon(() -> new ItemStack(modItems.APATITE.get()))
                    .title(Component.translatable("creativetab.carpathian_forest_tab"))
                    .displayItems((pParameters, pOutput) -> {
                        pOutput.accept(modItems.APATITE.get());
                        pOutput.accept(modItems.APATITE_DUST.get());
                        pOutput.accept(modBlocks.APATITE_BLOCK.get());
                    })
                    .build());

    public static void register(IEventBus eventBus) {
        CREATIVE_MODE_TAB.register(eventBus);
    }
}
