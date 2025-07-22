package blueberrytech.mickeydeesreloaded;

import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricBlockLootTableProvider;
import net.minecraft.registry.RegistryWrapper;

import java.util.concurrent.CompletableFuture;

public class MickeyDeesReloadedBlockLootTableProvider extends FabricBlockLootTableProvider {
    protected MickeyDeesReloadedBlockLootTableProvider(FabricDataOutput dataOutput, CompletableFuture<RegistryWrapper.WrapperLookup> registryLookup) {
        super(dataOutput, registryLookup);
    }

    @Override
    public void generate() {
        // Make condensed dirt drop its block item.
        // Also adds the condition that it survives the explosion that broke it, if applicable,
        addDrop(MDR_Blocks.BBQ_ORE);
        // Make prismarine lamps drop themselves with silk touch only
        //addDropWithSilkTouch(ModBlocks.PRISMARINE_LAMP);
        // Make condensed oak logs drop between 7 and 9 oak logs
        //addDrop(ModBlocks.CONDENSED_OAK_LOG, LootTable.builder().pool(addSurvivesExplosionCondition(Items.OAK_LOG, LootPool.builder()
          //      .rolls(new UniformLootNumberProvider(new ConstantLootNumberProvider(7), new ConstantLootNumberProvider(9)))
            //    .with(ItemEntry.builder(Items.OAK_LOG))))
      //  );
    }
}
