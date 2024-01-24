package net.eendenburg.carpathianforest.villager;

import com.google.common.collect.ImmutableSet;
import net.eendenburg.carpathianforest.CarpathianForest;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.world.entity.ai.village.poi.PoiType;
import net.minecraft.world.entity.npc.VillagerProfession;
import net.minecraft.world.level.block.Blocks;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.common.data.internal.NeoForgeEntityTypeTagsProvider;
import net.neoforged.neoforge.registries.DeferredHolder;
import net.neoforged.neoforge.registries.DeferredRegister;
import net.neoforged.neoforge.registries.NeoForgeRegistries;

import static com.ibm.icu.impl.ValidIdentifiers.Datatype.x;

public class modVillagers {
    public static final DeferredRegister<PoiType> POI_TYPES =
            DeferredRegister.create(BuiltInRegistries.POINT_OF_INTEREST_TYPE, CarpathianForest.MOD_ID);
    public static final DeferredRegister<VillagerProfession> VILLAGER_PROFESSIONS =
            DeferredRegister.create(BuiltInRegistries.VILLAGER_PROFESSION, CarpathianForest.MOD_ID);


    public static final DeferredRegister<VillagerProfession> APIARIST =
            VILLAGER_PROFESSIONS.register("apiarist", PoiType.NONE, PoiType.NONE, SoundEvent.createVariableRangeEvent

    public static void register(IEventBus eventBus) {
        POI_TYPES.register(eventBus);
        VILLAGER_PROFESSIONS.register(eventBus);
    }
}
