package net.eendenburg.carpathianforest.datagen;

import net.eendenburg.carpathianforest.CarpathianForest;
import net.eendenburg.carpathianforest.block.modBlocks;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.data.PackOutput;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.SlabBlock;
import net.minecraft.world.level.block.StairBlock;
import net.neoforged.neoforge.client.model.generators.BlockStateProvider;
import net.neoforged.neoforge.client.model.generators.ModelFile;
import net.neoforged.neoforge.common.data.ExistingFileHelper;
import net.neoforged.neoforge.registries.DeferredBlock;
import net.neoforged.neoforge.registries.DeferredRegister;
import net.neoforged.neoforge.registries.NeoForgeRegistries;

public class modBlockStateProvider extends BlockStateProvider {
    public modBlockStateProvider(PackOutput output, ExistingFileHelper exFileHelper) {
        super(output, CarpathianForest.MOD_ID, exFileHelper);
    }

    @Override
    protected void registerStatesAndModels() {
        blockWithItem(modBlocks.APATITE_BLOCK);
        blockWithItem(modBlocks.APATITE_ORE);
        stairsBlock((StairBlock) modBlocks.APATITE_STAIRS.get(), blockTexture(modBlocks.APATITE_BLOCK.get()));
        slabBlock(((SlabBlock) modBlocks.APATITE_SLAB.get()), blockTexture(modBlocks.APATITE_BLOCK.get()), blockTexture(modBlocks.APATITE_BLOCK.get()));

        blockItem(modBlocks.APATITE_STAIRS);
        blockItem(modBlocks.APATITE_SLAB);


    }

    private void blockItem(DeferredBlock<Block> blockRegistryObject) {
        simpleBlockItem(blockRegistryObject.get(), new ModelFile.UncheckedModelFile("carpathian_forest:block/" + BuiltInRegistries.BLOCK.getKey(blockRegistryObject.get()).getPath()));
    }

    private void blockWithItem(DeferredBlock<Block> blockRegistryObject) {
        simpleBlockWithItem(blockRegistryObject.get(), cubeAll(blockRegistryObject.get()));
    }
}
