package blueberrytech.mickeydeesreloaded;

import net.fabricmc.fabric.api.itemgroup.v1.FabricItemGroup;
import net.fabricmc.fabric.api.itemgroup.v1.ItemGroupEvents;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.registry.RegistryKey;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.text.Text;
import net.minecraft.util.Identifier;

import java.util.function.Function;

public class MDR_Items {

    public static void initialize(){
        // Register the group.
        Registry.register(Registries.ITEM_GROUP, MICKEY_DEES_GROUP_ITEMS_KEY, MICKEY_DEES_GROUP_ITEMS);

        // Register items to the custom item group.
        ItemGroupEvents.modifyEntriesEvent(MICKEY_DEES_GROUP_ITEMS_KEY).register(itemGroup -> {
            itemGroup.add(MDR_Items.NUGGIE_BOX);
            itemGroup.add(MDR_Items.FRY_BOX);
            itemGroup.add(MDR_Items.KNIFE_HILT);
            itemGroup.add(MDR_Items.MD_TOY);
            itemGroup.add(MDR_Items.RAW_BBQ);
        });
    }

    public static final RegistryKey<ItemGroup> MICKEY_DEES_GROUP_ITEMS_KEY = RegistryKey.of(Registries.ITEM_GROUP.getKey(), Identifier.of(MickeyDeesReloaded.MOD_ID, "item_group_items"));
    public static final ItemGroup MICKEY_DEES_GROUP_ITEMS = FabricItemGroup.builder()
            .icon(() -> new ItemStack(MDR_Items.NUGGIE_BOX))
            .displayName(Text.translatable("itemGroup.mickeydeesreloaded_items"))
            .build();


    public static Item register(String name, Function<Item.Settings, Item> itemFactory, Item.Settings settings) {
        // Create the item key.
        RegistryKey<Item> itemKey = RegistryKey.of(RegistryKeys.ITEM, Identifier.of(MickeyDeesReloaded.MOD_ID, name));

        // Create the item instance.
        Item item = itemFactory.apply(settings.registryKey(itemKey));

        // Register the item.
        Registry.register(Registries.ITEM, itemKey, item);
        return item;

    }


    // Adding items here

    // Boxes
    public static final Item NUGGIE_BOX = register("nuggie_box", Item::new,
            new Item.Settings()
                    .maxCount(16)
    );
    public static final Item FRY_BOX = register("fry_box", Item::new,
            new Item.Settings()
                    .maxCount(16)
    );

    // Knife Hilt
    public static final Item KNIFE_HILT = register("knife_hilt", Item::new,
            new Item.Settings()
                    .maxCount(16));

    // Toys
    public static final Item MD_TOY = register("md_toy", Item::new, new Item.Settings()
            .maxCount(1));


    // MISC. Items
    public static final Item RAW_BBQ = register("raw_bbq", Item::new, new Item.Settings());

}