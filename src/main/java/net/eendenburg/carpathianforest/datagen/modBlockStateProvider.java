package net.eendenburg.carpathianforest.datagen;

import net.eendenburg.carpathianforest.CarpathianForest;
import net.eendenburg.carpathianforest.block.modBlocks;
import net.minecraft.data.PackOutput;
import net.minecraft.world.level.block.Block;
import net.neoforged.neoforge.client.model.generators.BlockStateProvider;
import net.neoforged.neoforge.common.data.ExistingFileHelper;
import net.neoforged.neoforge.registries.DeferredBlock;

public class modBlockStateProvider extends BlockStateProvider {
    public modBlockStateProvider(PackOutput output, ExistingFileHelper exFileHelper) {
        super(output, CarpathianForest.MOD_ID, exFileHelper);
    }

    @Override
    protected void registerStatesAndModels() {
        blockWithItem(modBlocks.APATITE_BLOCK);
        blockWithItem(modBlocks.APATITE_ORE);
    }

    private void blockWithItem(DeferredBlock<Block> blockRegistryObject) {
        simpleBlockWithItem(blockRegistryObject.get(), cubeAll(blockRegistryObject.get()));
    }
}
