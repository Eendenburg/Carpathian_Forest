package net.eendenburg.carpathianforest.block;

import net.eendenburg.carpathianforest.CarpathianForest;
import net.eendenburg.carpathianforest.item.modItems;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.registries.DeferredBlock;
import net.neoforged.neoforge.registries.DeferredItem;
import net.neoforged.neoforge.registries.DeferredRegister;
import net.neoforged.neoforge.registries.NeoForgeRegistries;

import java.util.function.Supplier;

public class modBlocks {
    public static final DeferredRegister.Blocks BLOCKS =
            DeferredRegister.createBlocks(CarpathianForest.MOD_ID);


    public static final DeferredBlock<Block> APATITE_BLOCK = BLOCKS.register("apatite_block",
            () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.IRON_BLOCK)));



    public static <T extends Block> DeferredRegister<Item> registerBlockItem(String name, DeferredItem<BlockItem> block) {
        return modItems.ITEMS.register(name, () -> new BlockItem(Block.getId(), new Item.Properties()));
    }

    public static void register(IEventBus eventBus) {
        BLOCKS.register(eventBus);
    }
}




















