package net.eendenburg.carpathianforest.villager;

import com.google.common.collect.ImmutableSet;
import net.eendenburg.carpathianforest.CarpathianForest;
import net.eendenburg.carpathianforest.block.modBlocks;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.world.entity.ai.village.poi.PoiType;
import net.minecraft.world.entity.npc.VillagerProfession;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.registries.DeferredRegister;

import java.util.function.Supplier;

public class modVillager {

    private modVillager() {}

    public static final DeferredRegister<PoiType> POI_TYPES = DeferredRegister.create(BuiltInRegistries.POINT_OF_INTEREST_TYPE, CarpathianForest.MOD_ID);
    public static final DeferredRegister<VillagerProfession> VILLAGER_PROFESSIONS = DeferredRegister.create(BuiltInRegistries.VILLAGER_PROFESSION, CarpathianForest.MOD_ID);

    public static final Supplier<PoiType> BLUEPRINT_STATION_POI = POI_TYPES.register("blueprint_station_poi",
            () -> new PoiType(ImmutableSet.of(modBlocks.BLUEPRINT_STATION.get().defaultBlockState()), 1, 1));

    public static final Supplier<VillagerProfession> APIARIST_PROFESSION = VILLAGER_PROFESSIONS.register("apiarist",
            () -> new VillagerProfession("apiarist", poiType -> poiType.value() == BLUEPRINT_STATION_POI.get(),
                    poiType -> poiType.value() == BLUEPRINT_STATION_POI.get(),
                    ImmutableSet.of(), ImmutableSet.of(), SoundEvents.VILLAGER_WORK_FARMER));


    public static void register(IEventBus modEventBus) {
        POI_TYPES.register(modEventBus);
        VILLAGER_PROFESSIONS.register(modEventBus);
    }
}

//3342
