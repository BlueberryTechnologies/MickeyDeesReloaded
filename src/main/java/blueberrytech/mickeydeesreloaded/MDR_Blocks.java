package blueberrytech.mickeydeesreloaded;

import java.util.function.Function;

import blueberrytech.mickeydeesreloaded.MickeyDeesReloaded;
import net.fabricmc.fabric.api.itemgroup.v1.FabricItemGroup;
import net.fabricmc.fabric.api.itemgroup.v1.ItemGroupEvents;
import net.minecraft.block.*;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.registry.RegistryKey;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.text.Text;
import net.minecraft.util.Identifier;

import net.minecraft.util.math.intprovider.UniformIntProvider;


public class MDR_Blocks {

    private static Block register(String name, Function<AbstractBlock.Settings, Block> blockFactory, AbstractBlock.Settings settings, boolean shouldRegisterItem) {
        // Create a registry key for the block
        RegistryKey<Block> blockKey = keyOfBlock(name);
        // Create the block instance
        Block block = blockFactory.apply(settings.registryKey(blockKey));

        // Sometimes, you may not want to register an item for the block.
        // Eg: if it's a technical block like `minecraft:moving_piston` or `minecraft:end_gateway`
        if (shouldRegisterItem) {
            // Items need to be registered with a different type of registry key, but the ID
            // can be the same.
            RegistryKey<Item> itemKey = keyOfItem(name);

            BlockItem blockItem = new BlockItem(block, new Item.Settings().registryKey(itemKey));
            Registry.register(Registries.ITEM, itemKey, blockItem);
        }

        return Registry.register(Registries.BLOCK, blockKey, block);
    }

    private static RegistryKey<Block> keyOfBlock(String name) {
        return RegistryKey.of(RegistryKeys.BLOCK, Identifier.of(MickeyDeesReloaded.MOD_ID, name));
    }

    private static RegistryKey<Item> keyOfItem(String name) {
        return RegistryKey.of(RegistryKeys.ITEM, Identifier.of(MickeyDeesReloaded.MOD_ID, name));
    }

    public static final RegistryKey<ItemGroup> MICKEY_DEES_GROUP_BLOCKS_KEY = RegistryKey.of(Registries.ITEM_GROUP.getKey(), Identifier.of(MickeyDeesReloaded.MOD_ID, "item_group_blocks"));
    public static final ItemGroup MICKEY_DEES_GROUP_BLOCKS = FabricItemGroup.builder()
            .icon(() -> new ItemStack(MDR_Blocks.BBQ_ORE))
            .displayName(Text.translatable("itemGroup.mickeydeesreloaded_blocks"))
            .build();

    // :::1

    public static void initialize() {
        Registry.register(Registries.ITEM_GROUP, MICKEY_DEES_GROUP_BLOCKS_KEY, MICKEY_DEES_GROUP_BLOCKS);

        ItemGroupEvents.modifyEntriesEvent(MICKEY_DEES_GROUP_BLOCKS_KEY).register(itemGroup -> {
            itemGroup.add(MDR_Blocks.BBQ_ORE);
        });
    }


    public static final Block BBQ_ORE = register("bbq_ore", settings -> new ExperienceDroppingBlock(UniformIntProvider.create(2,5), settings), Block.Settings.create().strength(3f).requiresTool(), true); // the 2,5 is the range of exp


    // :::1
}
// :::1