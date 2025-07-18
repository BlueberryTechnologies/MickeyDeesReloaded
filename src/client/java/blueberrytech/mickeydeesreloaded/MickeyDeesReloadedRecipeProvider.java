package blueberrytech.mickeydeesreloaded;

import java.util.List;
import java.util.concurrent.CompletableFuture;

import net.minecraft.data.recipe.RecipeExporter;
import net.minecraft.data.recipe.RecipeGenerator;
import net.minecraft.item.Item;
import net.minecraft.item.Items;
import net.minecraft.recipe.Ingredient;
import net.minecraft.recipe.book.RecipeCategory;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.registry.RegistryWrapper;
import net.minecraft.registry.tag.ItemTags;

import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricRecipeProvider;

public class MickeyDeesReloadedRecipeProvider extends FabricRecipeProvider {
    public MickeyDeesReloadedRecipeProvider(FabricDataOutput output, CompletableFuture<RegistryWrapper.WrapperLookup> registriesFuture) {
        super(output, registriesFuture);
    }

    @Override
    protected RecipeGenerator getRecipeGenerator(RegistryWrapper.WrapperLookup registryLookup, RecipeExporter exporter) {
        return new RecipeGenerator(registryLookup, exporter) {
            @Override
            public void generate() {
                RegistryWrapper.Impl<Item> itemLookup = registries.getOrThrow(RegistryKeys.ITEM);

                createShaped(RecipeCategory.TOOLS, ModItems.FLINT_KNIFE)
                        .pattern(" F")
                        .pattern("S ")
                        .input('F', Items.FLINT)
                        .input('S', Items.STICK)
                        .group("flint_tools")
                        .criterion(hasItem(Items.STICK), conditionsFromItem(Items.STICK))
                        .criterion(hasItem(Items.FLINT), conditionsFromItem(Items.FLINT))
                        .offerTo(exporter);

                createShapeless(RecipeCategory.FOOD, ModItems.RAW_NUGGIE) // You can also specify an int to produce more than one
                        .input(Items.CHICKEN) // You can also specify an int to require more than one, or a tag to accept multiple things
                        .input(ModItems.FLINT_KNIFE)
                        // Create an advancement that gives you the recipe
                        .criterion(hasItem(Items.COARSE_DIRT), conditionsFromItem(Items.COARSE_DIRT))
                        .offerTo(exporter);

                offerStonecuttingRecipe(
                        RecipeCategory.FOOD,
                        ModItems.RAW_NUGGIE,
                        Items.CHICKEN,
                        6
                );

                offerSmelting(
                        List.of(ModItems.RAW_NUGGIE), // Inputs
                        RecipeCategory.FOOD, // Category
                        ModItems.COOKED_NUGGIE, // Output
                        0.1f, // Experience
                        300, // Cooking time
                        "nuggie_to_nuggie" // group
                );
            }
        };
    }

    @Override
    public String getName() {
        return "MickeyDeesReloadedRecipeProvider";
    }
}