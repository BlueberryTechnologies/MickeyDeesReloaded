package blueberrytech.mickeydeesreloaded;

import net.fabricmc.fabric.api.itemgroup.v1.FabricItemGroup;
import net.fabricmc.fabric.api.itemgroup.v1.ItemGroupEvents;
import net.minecraft.component.type.FoodComponent;
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

public class ModItems {

    public static void initialize(){
        // Register the group.
        Registry.register(Registries.ITEM_GROUP, CUSTOM_ITEM_GROUP_KEY, CUSTOM_ITEM_GROUP);

        // Register items to the custom item group.
        ItemGroupEvents.modifyEntriesEvent(CUSTOM_ITEM_GROUP_KEY).register(itemGroup -> {
            itemGroup.add(ModItems.DEV_ITEM);
            itemGroup.add(ModItems.RAW_NUGGIE);
            itemGroup.add(ModItems.COOKED_NUGGIE);
            itemGroup.add(ModItems.FLINT_KNIFE);
        });
    }

    public static final RegistryKey<ItemGroup> CUSTOM_ITEM_GROUP_KEY = RegistryKey.of(Registries.ITEM_GROUP.getKey(), Identifier.of(MickeyDeesReloaded.MOD_ID, "item_group"));
    public static final ItemGroup CUSTOM_ITEM_GROUP = FabricItemGroup.builder()
            .icon(() -> new ItemStack(ModItems.DEV_ITEM))
            .displayName(Text.translatable("itemGroup.mickeydeesreloaded"))
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

    // Item items

    public static final Item DEV_ITEM = register("dev_item", Item::new, new Item.Settings());
    public static final Item FLINT_KNIFE = register("flint_knife", Item::new,
            new Item.Settings()
                    .maxCount(1)
    );


    // Food items

    public static final Item RAW_NUGGIE = register("raw_nuggie", Item::new,
            new Item.Settings().food(new FoodComponent.Builder()
                    .nutrition(2)
                    .build()
            )
    );

    public static final Item COOKED_NUGGIE = register("cooked_nuggie", Item::new,
            new Item.Settings().food(new FoodComponent.Builder()
                    .nutrition(5)
                    .build()
            )
    );


}