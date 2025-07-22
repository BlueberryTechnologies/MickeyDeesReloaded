package blueberrytech.mickeydeesreloaded;

import com.mojang.serialization.MapCodec;
import net.minecraft.block.AbstractFurnaceBlock;
import net.minecraft.block.BlockState;
import net.minecraft.block.entity.BlockEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.screen.NamedScreenHandlerFactory;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import org.jetbrains.annotations.Nullable;

public class Mincer extends AbstractFurnaceBlock {

    protected Mincer(Settings settings) {
        super(settings);
    }

    @Override
    protected MapCodec<? extends AbstractFurnaceBlock> getCodec() {
        return null;
    }

    @Override
    protected void openScreen(World world, BlockPos pos, PlayerEntity player) {
        //This is called by the onUse method inside AbstractFurnaceBlock so
        //it is a little bit different of how you open the screen for normal container
        BlockEntity blockEntity = world.getBlockEntity(pos);
        if (blockEntity instanceof MincerBlockEntity) {
            player.openHandledScreen((NamedScreenHandlerFactory)blockEntity);
            // Optional: increment player's stat
            //player.incrementStat(Stats.INTERACT_WITH_FURNACE);
        }
    }

    @Override
    public @Nullable BlockEntity createBlockEntity(BlockPos pos, BlockState state) {
        return new MincerBlockEntity();
    }
}
