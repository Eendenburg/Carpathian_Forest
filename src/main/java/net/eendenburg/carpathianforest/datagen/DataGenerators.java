package net.eendenburg.carpathianforest.datagen;


import net.eendenburg.carpathianforest.CarpathianForest;
import net.minecraft.core.HolderLookup;
import net.minecraft.data.DataGenerator;
import net.minecraft.data.PackOutput;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.common.Mod;
import net.neoforged.neoforge.common.data.ExistingFileHelper;
import net.neoforged.neoforge.data.event.GatherDataEvent;

import java.util.concurrent.CompletableFuture;

@Mod.EventBusSubscriber(modid = CarpathianForest.MOD_ID, bus = Mod.EventBusSubscriber.Bus.MOD)
public class DataGenerators {
    @SubscribeEvent
    public static void gatherData(GatherDataEvent event) {
        DataGenerator generator = event.getGenerator();
        PackOutput packOutput = generator.getPackOutput();
        ExistingFileHelper existingFileHelper = event.getExistingFileHelper();
        CompletableFuture<HolderLookup.Provider> lookupProvider = event.getLookupProvider();

        generator.addProvider(event.includeClient(), new modRecipeGenerator(packOutput, lookupProvider));
        generator.addProvider(event.includeServer(), modLootTableGenerator.create(packOutput));
        generator.addProvider(event.includeServer(), new modBlockTagGenerator(packOutput, lookupProvider, existingFileHelper));
        generator.addProvider(event.includeClient(), new modItemModeGenerator(packOutput, existingFileHelper));
        generator.addProvider(event.includeClient(), new modBlockStateProvider(packOutput, existingFileHelper));
        generator.addProvider(event.includeClient(), new modPoiTypeTagProvider(packOutput, lookupProvider, existingFileHelper));


    }


}
