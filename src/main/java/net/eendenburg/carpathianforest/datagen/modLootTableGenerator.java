package net.eendenburg.carpathianforest.datagen;

import net.eendenburg.carpathianforest.datagen.loot.modBlockLootTables;
import net.minecraft.data.PackOutput;
import net.minecraft.data.loot.LootTableProvider;
import net.minecraft.world.level.storage.loot.parameters.LootContextParamSets;

import java.util.List;
import java.util.Set;

public class modLootTableGenerator {
    public static LootTableProvider create(PackOutput packOutput) {
        return new LootTableProvider(packOutput, Set.of(),
                List.of(new LootTableProvider.SubProviderEntry(modBlockLootTables::new, LootContextParamSets.BLOCK)));
    }
}
