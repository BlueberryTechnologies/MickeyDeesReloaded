package blueberrytech.mickeydeesreloaded;

import java.util.Random;

import net.fabricmc.fabric.api.biome.v1.BiomeModifications;
import net.fabricmc.fabric.api.biome.v1.BiomeSelectors;
import net.minecraft.block.Block;
import net.minecraft.block.ExperienceDroppingBlock;
import net.minecraft.registry.RegistryKey;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.util.Identifier;
import net.minecraft.util.math.MathHelper;
import net.minecraft.world.gen.GenerationStep;
import net.minecraft.world.gen.feature.PlacedFeature;

public class Generatable_Ore extends Block {
    // BBQ_ORE
    public static final RegistryKey<PlacedFeature> BBQ_ORE_PLACED_KEY = RegistryKey.of(RegistryKeys.PLACED_FEATURE, Identifier.of("mickeydeesreloaded","bbq_ore"));

    public Generatable_Ore(Settings settings) {
        super(settings);

    }

    public static void initialize(){

        // BBQ_ORE
        BiomeModifications.addFeature(BiomeSelectors.foundInOverworld(), GenerationStep.Feature.UNDERGROUND_ORES, BBQ_ORE_PLACED_KEY);
    }
}
