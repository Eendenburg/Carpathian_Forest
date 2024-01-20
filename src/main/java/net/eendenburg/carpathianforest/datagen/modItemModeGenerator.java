package net.eendenburg.carpathianforest.datagen;

import net.eendenburg.carpathianforest.CarpathianForest;
import net.eendenburg.carpathianforest.item.modItems;
import net.minecraft.data.PackOutput;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.Item;
import net.neoforged.neoforge.client.model.generators.ItemModelBuilder;
import net.neoforged.neoforge.client.model.generators.ItemModelProvider;
import net.neoforged.neoforge.common.data.ExistingFileHelper;
import net.neoforged.neoforge.registries.DeferredItem;

public class modItemModeGenerator extends ItemModelProvider {
    public modItemModeGenerator(PackOutput output, ExistingFileHelper existingFileHelper) {
        super(output, CarpathianForest.MOD_ID, existingFileHelper);
    }

    @Override
    protected void registerModels() {
        //add simple items
        simpleItem(modItems.APATITE);
        simpleItem(modItems.APATITE_DUST);

        handheldItem(modItems.CARPATHIAN_HAMMER_MK1);

    }

    private ItemModelBuilder simpleItem(DeferredItem<Item> item) {
        return withExistingParent(item.getId().getPath(),
                new ResourceLocation("item/generated")).texture("layer0",
                new ResourceLocation(CarpathianForest.MOD_ID, "item/" + item.getId().getPath()));
    }

    private ItemModelBuilder handheldItem(DeferredItem<Item> item) {
        return withExistingParent(item.getId().getPath(),
                new ResourceLocation("item/handheld")).texture("layer0",
                new ResourceLocation(CarpathianForest.MOD_ID,"item/" + item.getId().getPath()));
    }

}
