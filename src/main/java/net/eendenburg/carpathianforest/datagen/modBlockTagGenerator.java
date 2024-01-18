package net.eendenburg.carpathianforest.datagen;

import net.eendenburg.carpathianforest.CarpathianForest;
import net.eendenburg.carpathianforest.block.modBlocks;
import net.minecraft.core.HolderLookup;
import net.minecraft.data.PackOutput;
import net.minecraft.tags.BlockTags;
import net.minecraft.world.level.block.Block;
import net.neoforged.neoforge.common.data.BlockTagsProvider;
import net.neoforged.neoforge.common.data.ExistingFileHelper;
import org.jetbrains.annotations.Nullable;

import java.util.concurrent.CompletableFuture;

public class modBlockTagGenerator extends BlockTagsProvider {
    public modBlockTagGenerator(PackOutput output, CompletableFuture<HolderLookup.Provider> lookupProvider,
                                @Nullable ExistingFileHelper existingFileHelper) {
        super(output, lookupProvider, CarpathianForest.MOD_ID, existingFileHelper);
    }

    @Override
    protected void addTags(HolderLookup.Provider pProvider) {
        //add block tag


        tag(BlockTags.MINEABLE_WITH_PICKAXE)
                .add(modBlocks.APATITE_BLOCK.get(),
                    modBlocks.APATITE_ORE.get(),
                    modBlocks.BLUEPRINT_STATION.get(),
                    modBlocks.APATITE_SLAB.get(),
                    modBlocks.APATITE_STAIRS.get()
                );

        tag(BlockTags.NEEDS_IRON_TOOL)
                .add(modBlocks.APATITE_ORE.get(),
                        modBlocks.BLUEPRINT_STATION.get(),
                        modBlocks.APATITE_BLOCK.get(),
                        modBlocks.APATITE_SLAB.get(),
                        modBlocks.APATITE_STAIRS.get()
                );


    }

    @Override
    public String getName() {
        return "Block Tags";
    }
}
