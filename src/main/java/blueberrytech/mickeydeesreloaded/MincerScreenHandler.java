package blueberrytech.mickeydeesreloaded;

import net.minecraft.entity.player.PlayerInventory;
import net.minecraft.recipe.AbstractCookingRecipe;
import net.minecraft.recipe.RecipePropertySet;
import net.minecraft.recipe.RecipeType;
import net.minecraft.recipe.book.RecipeBookType;
import net.minecraft.registry.RegistryKey;
import net.minecraft.screen.AbstractFurnaceScreenHandler;
import net.minecraft.screen.ScreenHandlerType;

public class MincerScreenHandler extends AbstractFurnaceScreenHandler {
    public MincerScreenHandler(int i, PlayerInventory playerInventory) {
        super(MDR_Blocks.MINCER_SCREEN_HANDLER, CookingRecipeExample.TEST_RECIPE_TYPE, RecipeBookCategory.FURNACE, i, playerInventory);
    }

    public MincerScreenHandler(int i, PlayerInventory playerInventory, Inventory inventory, PropertyDelegate propertyDelegate) {
        super(MDR_Blocks.MINCER_SCREEN_HANDLER, CookingRecipeExample.TEST_RECIPE_TYPE, RecipeBookCategory.FURNACE, i, playerInventory, inventory, propertyDelegate);
    }
}
