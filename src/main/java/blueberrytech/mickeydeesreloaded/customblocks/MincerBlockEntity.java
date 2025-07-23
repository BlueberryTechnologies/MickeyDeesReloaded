package blueberrytech.mickeydeesreloaded.customblocks;

import blueberrytech.mickeydeesreloaded.MDR_Blocks;
import net.minecraft.block.BlockState;
import net.minecraft.block.entity.AbstractFurnaceBlockEntity;
import net.minecraft.block.entity.BlockEntityType;
import net.minecraft.entity.player.PlayerInventory;
import net.minecraft.recipe.RecipeType;
import net.minecraft.screen.FurnaceScreenHandler;
import net.minecraft.screen.ScreenHandler;
import net.minecraft.text.Text;
import net.minecraft.util.math.BlockPos;

public class MincerBlockEntity extends AbstractFurnaceBlockEntity {
    public MincerBlockEntity(BlockPos pos, BlockState state) {
        super(MDR_Blocks.MINCER_BLOCK_ENTITY, pos, state, RecipeType.SMELTING);
    }

    protected Text getContainerName() {
        return Text.translatable("container.furnace");
    }

    protected ScreenHandler createScreenHandler(int syncId, PlayerInventory playerInventory) {
        return new MincerScreenHandler(syncId, playerInventory, this, this.propertyDelegate);
    }
}

