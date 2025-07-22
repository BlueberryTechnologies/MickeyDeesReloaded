package blueberrytech.mickeydeesreloaded;

import net.fabricmc.fabric.api.itemgroup.v1.FabricItemGroup;
import net.fabricmc.fabric.api.itemgroup.v1.ItemGroupEvents;
import net.minecraft.component.type.ConsumableComponent;
import net.minecraft.component.type.ConsumableComponents;
import net.minecraft.component.type.FoodComponent;
import net.minecraft.entity.effect.StatusEffectInstance;
import net.minecraft.entity.effect.StatusEffects;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;
import net.minecraft.item.consume.ApplyEffectsConsumeEffect;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.registry.RegistryKey;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.text.Text;
import net.minecraft.util.Identifier;

import java.util.function.Function;

public class MDR_Foods {

    public static void initialize(){
        Registry.register(Registries.ITEM_GROUP, MICKEY_DEES_GROUP_FOOD_KEY, MICKEY_DEES_GROUP_FOOD);

        ItemGroupEvents.modifyEntriesEvent(MICKEY_DEES_GROUP_FOOD_KEY).register(itemGroup -> {
            itemGroup.add(MDR_Foods.RAW_NUGGIE);
            itemGroup.add(MDR_Foods.COOKED_NUGGIE);
            itemGroup.add(MDR_Foods.RAW_DINO_NUGGIE);
            itemGroup.add(MDR_Foods.COOKED_DINO_NUGGIE);
            itemGroup.add(MDR_Foods.RAW_FRIES);
            itemGroup.add(MDR_Foods.COOKED_FRIES);
            itemGroup.add(MDR_Foods.LARGE_FRY);
            itemGroup.add(MDR_Foods.SIX_PIECE_NUGGIE);
            itemGroup.add(MDR_Foods.SIX_PIECE_DINO_NUGGIE);
            itemGroup.add(MDR_Foods.APPLE_PIE);
            itemGroup.add(MDR_Foods.RAW_PATTY);
            itemGroup.add(MDR_Foods.COOKED_PATTY);
            itemGroup.add(MDR_Foods.BURGER);
        });


    }
    public static final RegistryKey<ItemGroup> MICKEY_DEES_GROUP_FOOD_KEY = RegistryKey.of(Registries.ITEM_GROUP.getKey(), Identifier.of(MickeyDeesReloaded.MOD_ID, "item_group_food"));
    public static final ItemGroup MICKEY_DEES_GROUP_FOOD = FabricItemGroup.builder()
            .icon(() -> new ItemStack(MDR_Foods.COOKED_NUGGIE))
            .displayName(Text.translatable("itemGroup.mickeydeesreloaded_food"))
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

    // Gives hunger to the foods that the user eats
    public static final ConsumableComponent HUNGER_FOOD_EFFECT_COMPONENT = ConsumableComponents.food()
            // The duration is in ticks, 20 ticks = 1 second
            .consumeEffect(new ApplyEffectsConsumeEffect(new StatusEffectInstance(StatusEffects.HUNGER, 6 * 20, 1), 0.4f))
            .build();


    // Gives Poison to the foods that the user eats
    public static final ConsumableComponent POISON_FOOD_EFFECT_COMPONENT = ConsumableComponents.food()
            // The duration is in ticks, 20 ticks = 1 second
            .consumeEffect(new ApplyEffectsConsumeEffect(new StatusEffectInstance(StatusEffects.POISON, 6 * 20, 1), 0.3f))
            .build();

    public static final ConsumableComponent REGEN_FOOD_EFFECT_COMPONENT = ConsumableComponents.food()
            // The duration is in ticks, 20 ticks = 1 second
            .consumeEffect(new ApplyEffectsConsumeEffect(new StatusEffectInstance(StatusEffects.REGENERATION, 6 * 20, 1), 1.0f))
            .build();




    // RAW FOODS
    // Give the user hunger/poison depending the type of food.
    /*
    CHICKEN -> POISON
    BEEF -> HUNGER
    OTHERS -> HUNGER
     */

    public static final FoodComponent RAW_FOOD_COMPONENT = new FoodComponent.Builder()
            .alwaysEdible()
            .nutrition(1)
            .saturationModifier(0.5f)
            .build();

    public static final Item RAW_NUGGIE = register("raw_nuggie", Item::new,
            new Item.Settings().food(RAW_FOOD_COMPONENT, POISON_FOOD_EFFECT_COMPONENT)
    );

    public static final Item RAW_DINO_NUGGIE = register("raw_dino_nuggie", Item::new,
            new Item.Settings().food(RAW_FOOD_COMPONENT, POISON_FOOD_EFFECT_COMPONENT)
    );

    public static final Item RAW_FRIES = register("raw_fries", Item::new,
            new Item.Settings().food(RAW_FOOD_COMPONENT, HUNGER_FOOD_EFFECT_COMPONENT)
    );

    public static final Item RAW_PATTY = register("raw_patty", Item::new,
            new Item.Settings().food(RAW_FOOD_COMPONENT, HUNGER_FOOD_EFFECT_COMPONENT)
    );

    public static final Item COOKED_NUGGIE = register("cooked_nuggie", Item::new,
            new Item.Settings().food(new FoodComponent.Builder()
                    // Nutrition and Saturation are based on the regular Java Edition food items that are most similar
                    // See https://minecraft.wiki/w/Hunger for more details
                    .nutrition(4) // This provides 2 full hunger hearts
                    .saturationModifier(5.2f) // Cooked Chicken is 7.2

                    .build()
            )
    );



    public static final Item COOKED_DINO_NUGGIE = register("cooked_dino_nuggie", Item::new,
            new Item.Settings().food(new FoodComponent.Builder()
                    // Nutrition and Saturation are based on the regular Java Edition food items that are most similar
                    // See https://minecraft.wiki/w/Hunger for more details
                    .nutrition(4) // This provides 2 full hunger hearts
                    .saturationModifier(5.2f) // Cooked Chicken is 7.2
                    .build()
            )
    );




    public static final Item COOKED_FRIES = register("cooked_fries", Item::new,
            new Item.Settings().food(new FoodComponent.Builder()
                    .nutrition(4)
                    .saturationModifier(5.0f)
                    .build()
            )
    );

    public static final Item LARGE_FRY = register("large_fry", Item::new,
            new Item.Settings().maxCount(1).food(new FoodComponent.Builder()
                    .nutrition(10)
                    .saturationModifier(8.0f)
                    .build()
            )
    );

    public static final Item SIX_PIECE_NUGGIE = register("six_piece_nuggie", Item::new,
            new Item.Settings().maxCount(1).food(new FoodComponent.Builder()
                    .nutrition(14)
                    .saturationModifier(10.0f)
                    .build()
            )
    );

    public static final Item SIX_PIECE_DINO_NUGGIE = register("six_piece_dino_nuggie", Item::new,
            new Item.Settings().maxCount(1).food(new FoodComponent.Builder()
                    .nutrition(14)
                    .saturationModifier(10.0f)
                    .build()
            )
    );

    public static final Item APPLE_PIE = register("apple_pie", Item::new,
            new Item.Settings().maxCount(1).food(new FoodComponent.Builder()
                    .nutrition(10)
                    .saturationModifier(6.3f)
                    .build()
            )
    );





    public static final Item COOKED_PATTY = register("cooked_patty", Item::new,
            new Item.Settings().food(new FoodComponent.Builder()
                    .nutrition(6)
                    .saturationModifier(7.1f)
                    .build())
    );

    public static final Item BURGER = register("burger", Item::new,
            new Item.Settings().maxCount(16).food(new FoodComponent.Builder()
                    .nutrition(16)
                    .saturationModifier(13.5f)
                    .build()
            , REGEN_FOOD_EFFECT_COMPONENT) // The burger provides regen when eaten
    );
}
