package blueberrytech.mickeydeesreloaded;

import net.minecraft.block.BlockState;
import net.minecraft.block.entity.AbstractFurnaceBlockEntity;
import net.minecraft.block.entity.BlockEntityType;
import net.minecraft.entity.player.PlayerInventory;
import net.minecraft.recipe.AbstractCookingRecipe;
import net.minecraft.recipe.RecipeType;
import net.minecraft.screen.ScreenHandler;
import net.minecraft.text.Text;
import net.minecraft.util.math.BlockPos;

public class MincerBlockEntity extends AbstractFurnaceBlockEntity {

    protected MincerBlockEntity() {
        super(MDR_Blocks.MINCER, MDR_Blocks.RETARD);
    }

    @Override
    protected Text getContainerName() {
        return Text.of("Mincer");
    }

    @Override
    protected ScreenHandler createScreenHandler(int syncId, PlayerInventory playerInventory) {
        return new MincerScreenHandler(syncId, playerInventory, this, this.propertyDelegate);
    }
}
