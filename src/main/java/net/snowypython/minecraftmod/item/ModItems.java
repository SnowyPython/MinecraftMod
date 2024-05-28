package net.snowypython.minecraftmod.item;

import net.minecraft.world.food.FoodProperties;
import net.minecraft.world.item.*;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;
import net.snowypython.minecraftmod.MinecraftMod;

public class ModItems {
    public static final DeferredRegister<Item> ITEMS =
            DeferredRegister.create(ForgeRegistries.ITEMS, MinecraftMod.MOD_ID);

    //ingots
    public static final RegistryObject<Item> ALUMINUM_INGOT = ITEMS.register("aluminum_ingot",
            () -> new Item(new Item.Properties().tab(ModCreativeModeTab.RESOURCES_TAB)));
    public static final RegistryObject<Item> TIN_INGOT = ITEMS.register("tin_ingot",
            () -> new Item(new Item.Properties().tab(ModCreativeModeTab.RESOURCES_TAB)));
    public static final RegistryObject<Item> LEAD_INGOT = ITEMS.register("lead_ingot",
            () -> new Item(new Item.Properties().tab(ModCreativeModeTab.RESOURCES_TAB)));
    public static final RegistryObject<Item> PLATINUM_INGOT = ITEMS.register("platinum_ingot",
            () -> new Item(new Item.Properties().tab(ModCreativeModeTab.RESOURCES_TAB)));
    public static final RegistryObject<Item> SILVER_INGOT = ITEMS.register("silver_ingot",
            () -> new Item(new Item.Properties().tab(ModCreativeModeTab.RESOURCES_TAB)));
    public static final RegistryObject<Item> TITANIUM_INGOT = ITEMS.register("titanium_ingot",
            () -> new Item(new Item.Properties().tab(ModCreativeModeTab.RESOURCES_TAB)));

    //raw_resources
    public static final RegistryObject<Item> RAW_TIN = ITEMS.register("raw_tin",
            () -> new Item(new Item.Properties().tab(ModCreativeModeTab.RESOURCES_TAB)));
    public static final RegistryObject<Item> RAW_ALUMINUM = ITEMS.register("raw_aluminum",
            () -> new Item(new Item.Properties().tab(ModCreativeModeTab.RESOURCES_TAB)));
    public static final RegistryObject<Item> RAW_LEAD = ITEMS.register("raw_lead",
            () -> new Item(new Item.Properties().tab(ModCreativeModeTab.RESOURCES_TAB)));
    public static final RegistryObject<Item> RAW_PLATINUM = ITEMS.register("raw_platinum",
            () -> new Item(new Item.Properties().tab(ModCreativeModeTab.RESOURCES_TAB)));
    public static final RegistryObject<Item> RAW_SILVER = ITEMS.register("raw_silver",
            () -> new Item(new Item.Properties().tab(ModCreativeModeTab.RESOURCES_TAB)));
    public static final RegistryObject<Item> RAW_TITANIUM = ITEMS.register("raw_titanium",
            () -> new Item(new Item.Properties().tab(ModCreativeModeTab.RESOURCES_TAB)));

    //food
    public static final RegistryObject<Item> BANANA = ITEMS.register("banana",
            () -> new Item(new Item.Properties().food(new FoodProperties.Builder().nutrition(4).saturationMod(1.2f).build())
                    .tab(ModCreativeModeTab.FOOD_TAB)));
    public static final RegistryObject<Item> ORANGE = ITEMS.register("orange",
            () -> new Item(new Item.Properties().food(new FoodProperties.Builder().nutrition(4).saturationMod(1.2f).build())
                    .tab(ModCreativeModeTab.FOOD_TAB)));

    //tools
    public static final RegistryObject<Item> PLATINUM_PICKAXE = ITEMS.register("platinum_pickaxe",
            () -> new PickaxeItem(Tiers.DIAMOND, 1, -2.8f, new Item.Properties().tab(ModCreativeModeTab.TOOLS_TAB)));
    public static final RegistryObject<Item> PLATINUM_AXE = ITEMS.register("platinum_axe",
            () -> new AxeItem(Tiers.DIAMOND, 5, -3f, new Item.Properties().tab(ModCreativeModeTab.TOOLS_TAB)));
    public static final RegistryObject<Item> PLATINUM_SHOVEL = ITEMS.register("platinum_shovel",
            () -> new ShovelItem(Tiers.DIAMOND, 1.5f, -3f, new Item.Properties().tab(ModCreativeModeTab.TOOLS_TAB)));
    public static final RegistryObject<Item> PLATINUM_HOE = ITEMS.register("platinum_hoe",
            () -> new HoeItem(Tiers.DIAMOND, -3, 0f, new Item.Properties().tab(ModCreativeModeTab.TOOLS_TAB)));

    public static void register(IEventBus eventBus) {
        ITEMS.register(eventBus);
    }
}
