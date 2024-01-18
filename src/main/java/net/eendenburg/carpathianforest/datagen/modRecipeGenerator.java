package net.eendenburg.carpathianforest.datagen;

import net.eendenburg.carpathianforest.CarpathianForest;
import net.eendenburg.carpathianforest.block.modBlocks;
import net.eendenburg.carpathianforest.item.modItems;
import net.minecraft.advancements.critereon.ItemPredicate;
import net.minecraft.core.HolderLookup;
import net.minecraft.data.PackOutput;
import net.minecraft.data.recipes.*;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.crafting.AbstractCookingRecipe;
import net.minecraft.world.item.crafting.Ingredient;
import net.minecraft.world.item.crafting.RecipeSerializer;
import net.minecraft.world.level.ItemLike;
import net.minecraft.world.level.block.Block;
import net.neoforged.neoforge.common.conditions.IConditionBuilder;
import net.neoforged.neoforge.registries.DeferredBlock;
import net.neoforged.neoforge.registries.DeferredItem;
import org.jetbrains.annotations.NotNull;

import javax.annotation.Nullable;
import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.function.Consumer;

import static com.ibm.icu.lang.UCharacter.GraphemeClusterBreak.T;

public class modRecipeGenerator extends RecipeProvider implements IConditionBuilder {
    private static final List<ItemLike> APATITE_SMELTABLES = List.of(modItems.APATITE.get(),
            modBlocks.APATITE_ORE.get());

    public modRecipeGenerator(PackOutput output, CompletableFuture<HolderLookup.Provider> provider) {
        super(output, provider);
    }

    @Override
    protected void buildRecipes(RecipeOutput pWriter) {

        nineBlockStorageRecipes(pWriter, RecipeCategory.MISC, modItems.APATITE.get(), RecipeCategory.MISC, modBlocks.APATITE_BLOCK.get(),
                "carpathian_forest:apatite", "apatite","carpathian_forest:apatite_block", "apatite");
        oreSmelting(pWriter, APATITE_SMELTABLES, RecipeCategory.MISC, modItems.APATITE.get(), 0.25f, 200, "apatite");
        oreBlasting(pWriter, APATITE_SMELTABLES, RecipeCategory.MISC, modItems.APATITE.get(), 0.25f, 100, "apatite");
        slab(pWriter, RecipeCategory.MISC, modBlocks.APATITE_SLAB, modBlocks.APATITE_BLOCK);

    }

    protected static void oreSmelting(RecipeOutput pFinishedRecipeConsumer, List<ItemLike> pIngredients, RecipeCategory pCategory, ItemLike pResult, float pExperience, int pCookingTIme, String pGroup) {
        oreCooking(pFinishedRecipeConsumer, RecipeSerializer.SMELTING_RECIPE, pIngredients, pCategory, pResult, pExperience, pCookingTIme, pGroup, "_from_smelting");
    }

    protected static void oreBlasting(RecipeOutput pFinishedRecipeConsumer, List<ItemLike> pIngredients, RecipeCategory pCategory, ItemLike pResult, float pExperience, int pCookingTime, String pGroup) {
        oreCooking(pFinishedRecipeConsumer, RecipeSerializer.BLASTING_RECIPE, pIngredients, pCategory, pResult, pExperience, pCookingTime, pGroup, "_from_blasting");
    }

    protected static void oreCooking(RecipeOutput pFinishedRecipeConsumer, RecipeSerializer<? extends AbstractCookingRecipe> pCookingSerializer, List<ItemLike> pIngredients, RecipeCategory pCategory, ItemLike pResult, float pExperience, int pCookingTime, String pGroup, String pRecipeName) {
        for(ItemLike itemlike : pIngredients) {
            SimpleCookingRecipeBuilder.smelting(Ingredient.of(itemlike), pCategory, pResult,
                            pExperience, pCookingTime)
                    .group(pGroup).unlockedBy(getHasName(itemlike), has(itemlike))
                    .save(pFinishedRecipeConsumer,  CarpathianForest.MOD_ID + ":" + getItemName(pResult) + pRecipeName + "_" + getItemName(itemlike));
        }
    }
}
