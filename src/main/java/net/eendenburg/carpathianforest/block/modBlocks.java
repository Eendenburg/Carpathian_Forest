package net.eendenburg.carpathianforest.block;

import com.mojang.authlib.properties.Property;
import net.eendenburg.carpathianforest.CarpathianForest;
import net.eendenburg.carpathianforest.item.modItems;
import net.minecraft.core.Direction;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.context.BlockPlaceContext;
import net.minecraft.world.level.block.*;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.StateDefinition;
import net.minecraft.world.level.block.state.properties.BlockStateProperties;
import net.minecraft.world.level.block.state.properties.DirectionProperty;
import net.neoforged.bus.EventBus;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.client.event.RenderHighlightEvent;
import net.neoforged.neoforge.registries.*;

import java.util.function.Supplier;

import static net.minecraft.world.level.block.state.BlockBehaviour.*;

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

    public static final DeferredBlock<Block> BLUEPRINT_STATION = registerBlock("blueprint_station",
            () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.IRON_BLOCK)));
    public static final DeferredBlock<Block> APATITE_ORE = registerBlock("apatite_ore",
            () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.IRON_ORE)));

    public static final DeferredBlock<Block> APATITE_STAIRS = registerBlock("apatite_stairs",
            () -> new StairBlock(() -> modBlocks.APATITE_BLOCK.get().defaultBlockState(),BlockBehaviour.Properties.ofFullCopy(Blocks.ANDESITE_STAIRS).sound(SoundType.AMETHYST)));

    public static final DeferredBlock<Block> APATITE_SLAB = registerBlock("apatite_slab",
            () -> new SlabBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.ANDESITE_STAIRS).sound(SoundType.AMETHYST)));


    public static void register(IEventBus eventBus) {
            BLOCKS.register(eventBus);
        }


};




















