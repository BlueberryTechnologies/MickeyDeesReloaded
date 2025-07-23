package blueberrytech.mickeydeesreloaded;

import net.fabricmc.api.ModInitializer;

import net.minecraft.block.entity.BlockEntityType;
import net.minecraft.text.Text;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class MickeyDeesReloaded implements ModInitializer {
	public static final String MOD_ID = "mickeydeesreloaded";

	// This logger is used to write text to the console and the log file.
	// It is considered best practice to use your mod id as the logger's name.
	// That way, it's clear which mod wrote info, warnings, and errors.
	public static final Logger LOGGER = LoggerFactory.getLogger(MOD_ID);




	@Override
	public void onInitialize() {
		// This code runs as soon as Minecraft is in a mod-load-ready state.
		// However, some things (like resources) may still be uninitialized.
		// Proceed with mild caution.


		MDR_Tools.initialize();
		MDR_Foods.initialize();
		MDR_Items.initialize();
		MDR_Blocks.initialize();
		Generatable_Ore.initialize();

		LOGGER.info("Hello Fabric world!");
	}
}