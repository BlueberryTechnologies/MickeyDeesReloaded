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
        Registry.register(Registries.ITEM_GROUP, MICKEY_DEES_GROUP_ITEMS_KEY, MICKEY_DEES_GROUP_ITEMS);
        Registry.register(Registries.ITEM_GROUP, MICKEY_DEES_GROUP_FOOD_KEY, MICKEY_DEES_GROUP_FOOD);
        Registry.register(Registries.ITEM_GROUP, MICKEY_DEES_GROUP_TOOLS_KEY, MICKEY_DEES_GROUP_TOOLS);

        // Register items to the custom item group.
        ItemGroupEvents.modifyEntriesEvent(MICKEY_DEES_GROUP_ITEMS_KEY).register(itemGroup -> {
            itemGroup.add(ModItems.NUGGIE_BOX);
            itemGroup.add(ModItems.FRY_BOX);
        });

        ItemGroupEvents.modifyEntriesEvent(MICKEY_DEES_GROUP_FOOD_KEY).register(itemGroup -> {
            itemGroup.add(ModItems.RAW_NUGGIE);
            itemGroup.add(ModItems.COOKED_NUGGIE);
            itemGroup.add(ModItems.RAW_DINO_NUGGIE);
            itemGroup.add(ModItems.COOKED_DINO_NUGGIE);
            itemGroup.add(ModItems.RAW_FRIES);
            itemGroup.add(ModItems.COOKED_FRIES);
            itemGroup.add(ModItems.LARGE_FRY);
            itemGroup.add(ModItems.SIX_PIECE_NUGGIE);
            itemGroup.add(ModItems.SIX_PIECE_DINO_NUGGIE);
        });

        ItemGroupEvents.modifyEntriesEvent(MICKEY_DEES_GROUP_TOOLS_KEY).register(itemGroup -> {
            itemGroup.add(ModItems.FLINT_KNIFE);
        });
    }

    public static final RegistryKey<ItemGroup> MICKEY_DEES_GROUP_ITEMS_KEY = RegistryKey.of(Registries.ITEM_GROUP.getKey(), Identifier.of(MickeyDeesReloaded.MOD_ID, "item_group_items"));
    public static final ItemGroup MICKEY_DEES_GROUP_ITEMS = FabricItemGroup.builder()
            .icon(() -> new ItemStack(ModItems.NUGGIE_BOX))
            .displayName(Text.translatable("itemGroup.mickeydeesreloaded_items"))
            .build();
    public static final RegistryKey<ItemGroup> MICKEY_DEES_GROUP_FOOD_KEY = RegistryKey.of(Registries.ITEM_GROUP.getKey(), Identifier.of(MickeyDeesReloaded.MOD_ID, "item_group_food"));
    public static final ItemGroup MICKEY_DEES_GROUP_FOOD = FabricItemGroup.builder()
            .icon(() -> new ItemStack(ModItems.COOKED_NUGGIE))
            .displayName(Text.translatable("itemGroup.mickeydeesreloaded_food"))
            .build();

    public static final RegistryKey<ItemGroup> MICKEY_DEES_GROUP_TOOLS_KEY = RegistryKey.of(Registries.ITEM_GROUP.getKey(), Identifier.of(MickeyDeesReloaded.MOD_ID, "item_group_tools"));
    public static final ItemGroup MICKEY_DEES_GROUP_TOOLS = FabricItemGroup.builder()
            .icon(() -> new ItemStack(ModItems.FLINT_KNIFE))
            .displayName(Text.translatable("itemGroup.mickeydeesreloaded_tools"))
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

    public static final Item FLINT_KNIFE = register("flint_knife", Item::new,
            new Item.Settings()
                    .maxCount(1)
    );

    // Boxes

    public static final Item NUGGIE_BOX = register("nuggie_box", Item::new,
            new Item.Settings()
                    .maxCount(16)
    );
    public static final Item FRY_BOX = register("fry_box", Item::new,
            new Item.Settings()
                    .maxCount(16)
    );

    // Food items

    public static final Item RAW_NUGGIE = register("raw_nuggie", Item::new,
            new Item.Settings().food(new FoodComponent.Builder()
                    .nutrition(1)
                    .build()
            )
    );

    public static final Item COOKED_NUGGIE = register("cooked_nuggie", Item::new,
            new Item.Settings().food(new FoodComponent.Builder()
                    .nutrition(4)
                    .build()
            )
    );

    public static final Item RAW_DINO_NUGGIE = register("raw_dino_nuggie", Item::new,
            new Item.Settings().food(new FoodComponent.Builder()
                    .nutrition(1)
                    .build()
            )
    );

    public static final Item COOKED_DINO_NUGGIE = register("cooked_dino_nuggie", Item::new,
            new Item.Settings().food(new FoodComponent.Builder()
                    .nutrition(4)
                    .build()
            )
    );

    public static final Item RAW_FRIES = register("raw_fries", Item::new,
            new Item.Settings().food(new FoodComponent.Builder()
                    .nutrition(1)
                    .build()
            )
    );

    public static final Item COOKED_FRIES = register("cooked_fries", Item::new,
            new Item.Settings().food(new FoodComponent.Builder()
                    .nutrition(4)
                    .build()
            )
    );

    public static final Item LARGE_FRY = register("large_fry", Item::new,
            new Item.Settings().maxCount(1).food(new FoodComponent.Builder()
                    .nutrition(12)
                    .build()
            )
    );

    public static final Item SIX_PIECE_NUGGIE = register("six_piece_nuggie", Item::new,
            new Item.Settings().maxCount(1).food(new FoodComponent.Builder()
                    .nutrition(16)
                    .build()
            )
    );

    public static final Item SIX_PIECE_DINO_NUGGIE = register("six_piece_dino_nuggie", Item::new,
            new Item.Settings().maxCount(1).food(new FoodComponent.Builder()
                    .nutrition(16)
                    .build()
            )
    );


}