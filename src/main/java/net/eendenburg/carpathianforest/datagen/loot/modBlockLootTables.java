package net.eendenburg.carpathianforest.datagen.loot;

import net.eendenburg.carpathianforest.CarpathianForest;
import net.eendenburg.carpathianforest.block.modBlocks;
import net.eendenburg.carpathianforest.item.modItems;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.data.loot.BlockLootSubProvider;
import net.minecraft.world.flag.FeatureFlagSet;
import net.minecraft.world.flag.FeatureFlags;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;
import net.neoforged.neoforge.registries.DeferredBlock;
import net.neoforged.neoforge.registries.DeferredRegister;

import java.util.Optional;
import java.util.Set;
import java.util.stream.Collectors;

public class modBlockLootTables extends BlockLootSubProvider {
    public modBlockLootTables() {
        super(Set.of(), FeatureFlags.REGISTRY.allFlags());
    }

    @Override
    protected void generate() {
        dropSelf(modBlocks.APATITE_BLOCK.get());
        dropSelf(modBlocks.BLUEPRINT_STATION.get());
        dropSelf(modBlocks.APATITE_STAIRS.get());

        add(modBlocks.APATITE_ORE.get(),
                block -> createOreDrop(modBlocks.APATITE_ORE.get(), modItems.APATITE.get()));
        add(modBlocks.APATITE_SLAB.get(),
                block -> createSlabItemTable(modBlocks.APATITE_SLAB.get()));

    }

    @Override
    protected Iterable<Block> getKnownBlocks() {
        return BuiltInRegistries.BLOCK.stream()
                .filter(block -> Optional.of(BuiltInRegistries.BLOCK.getKey(block))
                        .filter(key -> key.getNamespace().equals(CarpathianForest.MOD_ID))
                        .isPresent())
                .collect(Collectors.toSet());
    }
}
