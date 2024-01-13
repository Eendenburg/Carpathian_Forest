package net.eendenburg.carpathianforest.block;

import net.eendenburg.carpathianforest.CarpathianForest;
import net.eendenburg.carpathianforest.item.modItems;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.neoforged.bus.EventBus;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.client.event.RenderHighlightEvent;
import net.neoforged.neoforge.registries.*;

import java.util.function.Supplier;

public class modBlocks {
    public static final DeferredRegister.Blocks BLOCKS =
            DeferredRegister.createBlocks(CarpathianForest.MOD_ID);


//registering block as an Item
public static <T extends Block> DeferredBlock<T> registerBlock(String name, Supplier<T> block) {
    DeferredBlock<T> ret = BLOCKS.register(name, block);
    modItems.ITEMS.register(name, () -> new BlockItem(ret.get(), new Item.Properties()));
    return ret;
}


// registering blocks
    public static final DeferredBlock<Block> APATITE_BLOCK = registerBlock("apatite_block",
            () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.AMETHYST_BLOCK)));


        public static void register(IEventBus eventBus) {
            BLOCKS.register(eventBus);
        }


};




















