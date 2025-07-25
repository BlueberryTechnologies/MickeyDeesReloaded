package blueberrytech.mickeydeesreloaded;

import net.fabricmc.fabric.api.datagen.v1.DataGeneratorEntrypoint;
import net.fabricmc.fabric.api.datagen.v1.FabricDataGenerator;

public class MickeyDeesReloadedDataGenerator implements DataGeneratorEntrypoint {
	@Override
	public void onInitializeDataGenerator(FabricDataGenerator fabricDataGenerator) {
		FabricDataGenerator.Pack pack = fabricDataGenerator.createPack();
		pack.addProvider(MickeyDeesReloadedRecipeProvider::new);
		pack.addProvider(MickeyDeesReloadedBlockLootTableProvider::new);
		//pack.addProvider(MickeyDeesReloadedChestLootTableProvider::new);
	}
}