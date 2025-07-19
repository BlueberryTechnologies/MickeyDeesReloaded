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

public class MDR_Tools {

    public static void initialize(){
        // Register the group.
        Registry.register(Registries.ITEM_GROUP, MICKEY_DEES_GROUP_TOOLS_KEY, MICKEY_DEES_GROUP_TOOLS);

        ItemGroupEvents.modifyEntriesEvent(MICKEY_DEES_GROUP_TOOLS_KEY).register(itemGroup -> itemGroup.add(MDR_Tools.FLINT_KNIFE));
    }

    public static final RegistryKey<ItemGroup> MICKEY_DEES_GROUP_TOOLS_KEY = RegistryKey.of(Registries.ITEM_GROUP.getKey(), Identifier.of(MickeyDeesReloaded.MOD_ID, "item_group_tools"));
    public static final ItemGroup MICKEY_DEES_GROUP_TOOLS = FabricItemGroup.builder()
            .icon(() -> new ItemStack(MDR_Tools.FLINT_KNIFE))
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


}