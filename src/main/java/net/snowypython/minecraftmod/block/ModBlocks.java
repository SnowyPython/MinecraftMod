package net.snowypython.minecraftmod.block;

import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.material.Material;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;
import net.snowypython.minecraftmod.MinecraftMod;
import net.snowypython.minecraftmod.item.ModCreativeModeTab;
import net.snowypython.minecraftmod.item.ModItems;
import net.snowypython.minecraftmod.item.custom.CornCropBlock;

import java.util.function.Supplier;

public class ModBlocks {
    public static final DeferredRegister<Block> BLOCKS =
            DeferredRegister.create(ForgeRegistries.BLOCKS, MinecraftMod.MOD_ID);

    //ores
    public static final RegistryObject<Block> TIN_ORE = registerBlock("tin_ore",
            () -> new Block(BlockBehaviour.Properties.of(Material.STONE).strength(3f)
                    .requiresCorrectToolForDrops()), ModCreativeModeTab.ORES_TAB);
    public static final RegistryObject<Block> ALUMINUM_ORE = registerBlock("aluminum_ore",
            () -> new Block(BlockBehaviour.Properties.of(Material.STONE).strength(3f)
                    .requiresCorrectToolForDrops()), ModCreativeModeTab.ORES_TAB);
    public static final RegistryObject<Block> LEAD_ORE = registerBlock("lead_ore",
            () -> new Block(BlockBehaviour.Properties.of(Material.STONE).strength(3f)
                    .requiresCorrectToolForDrops()), ModCreativeModeTab.ORES_TAB);
    public static final RegistryObject<Block> PLATINUM_ORE = registerBlock("platinum_ore",
            () -> new Block(BlockBehaviour.Properties.of(Material.STONE).strength(5f)
                    .requiresCorrectToolForDrops()), ModCreativeModeTab.ORES_TAB);
    public static final RegistryObject<Block> SILVER_ORE = registerBlock("silver_ore",
            () -> new Block(BlockBehaviour.Properties.of(Material.STONE).strength(3f)
                    .requiresCorrectToolForDrops()), ModCreativeModeTab.ORES_TAB);
    public static final RegistryObject<Block> TITANIUM_ORE = registerBlock("titanium_ore",
            () -> new Block(BlockBehaviour.Properties.of(Material.STONE).strength(5f)
                    .requiresCorrectToolForDrops()), ModCreativeModeTab.ORES_TAB);

    //deepslate_ores
    public static final RegistryObject<Block> DEEPSLATE_TIN_ORE = registerBlock("deepslate_tin_ore",
            () -> new Block(BlockBehaviour.Properties.of(Material.STONE).strength(4.5f)
                    .requiresCorrectToolForDrops()), ModCreativeModeTab.ORES_TAB);
    public static final RegistryObject<Block> DEEPSLATE_ALUMINUM_ORE = registerBlock("deepslate_aluminum_ore",
            () -> new Block(BlockBehaviour.Properties.of(Material.STONE).strength(4.5f)
                    .requiresCorrectToolForDrops()), ModCreativeModeTab.ORES_TAB);
    public static final RegistryObject<Block> DEEPSLATE_LEAD_ORE = registerBlock("deepslate_lead_ore",
            () -> new Block(BlockBehaviour.Properties.of(Material.STONE).strength(4.5f)
                    .requiresCorrectToolForDrops()), ModCreativeModeTab.ORES_TAB);
    public static final RegistryObject<Block> DEEPSLATE_PLATINUM_ORE = registerBlock("deepslate_platinum_ore",
            () -> new Block(BlockBehaviour.Properties.of(Material.STONE).strength(6.5f)
                    .requiresCorrectToolForDrops()), ModCreativeModeTab.ORES_TAB);
    public static final RegistryObject<Block> DEEPSLATE_SILVER_ORE = registerBlock("deepslate_silver_ore",
            () -> new Block(BlockBehaviour.Properties.of(Material.STONE).strength(4.5f)
                    .requiresCorrectToolForDrops()), ModCreativeModeTab.ORES_TAB);
    public static final RegistryObject<Block> DEEPSLATE_TITANIUM_ORE = registerBlock("deepslate_titanium_ore",
            () -> new Block(BlockBehaviour.Properties.of(Material.STONE).strength(6.5f)
                    .requiresCorrectToolForDrops()), ModCreativeModeTab.ORES_TAB);

    //blocks
    public static final RegistryObject<Block> TIN_BLOCK = registerBlock("tin_block",
            () -> new Block(BlockBehaviour.Properties.of(Material.STONE).strength(4f)
                    .requiresCorrectToolForDrops()), ModCreativeModeTab.RESOURCES_TAB);
    public static final RegistryObject<Block> ALUMINUM_BLOCK = registerBlock("aluminum_block",
            () -> new Block(BlockBehaviour.Properties.of(Material.STONE).strength(4f)
                    .requiresCorrectToolForDrops()), ModCreativeModeTab.RESOURCES_TAB);
    public static final RegistryObject<Block> LEAD_BLOCK = registerBlock("lead_block",
            () -> new Block(BlockBehaviour.Properties.of(Material.STONE).strength(4f)
                    .requiresCorrectToolForDrops()), ModCreativeModeTab.RESOURCES_TAB);
    public static final RegistryObject<Block> PLATINUM_BLOCK = registerBlock("platinum_block",
            () -> new Block(BlockBehaviour.Properties.of(Material.STONE).strength(6f)
                    .requiresCorrectToolForDrops()), ModCreativeModeTab.RESOURCES_TAB);
    public static final RegistryObject<Block> SILVER_BLOCK = registerBlock("silver_block",
            () -> new Block(BlockBehaviour.Properties.of(Material.STONE).strength(4f)
                    .requiresCorrectToolForDrops()), ModCreativeModeTab.RESOURCES_TAB);
    public static final RegistryObject<Block> TITANIUM_BLOCK = registerBlock("titanium_block",
            () -> new Block(BlockBehaviour.Properties.of(Material.STONE).strength(6f)
                    .requiresCorrectToolForDrops()), ModCreativeModeTab.RESOURCES_TAB);

    //crops
    public static final RegistryObject<Block> CORN_CROP = BLOCKS.register("corn_crop",
            () -> new CornCropBlock(BlockBehaviour.Properties.copy(Blocks.WHEAT)));

    private static <T extends Block> RegistryObject<T> registerBlock(
            String name, Supplier<T> block, CreativeModeTab tab) {

        RegistryObject<T> toReturn = BLOCKS.register(name, block);

        registerBlockItem(name, toReturn, tab);

        return toReturn;
    }

    private static <T extends Block> RegistryObject<Item> registerBlockItem(
            String name, RegistryObject<T> block, CreativeModeTab tab) {

        return ModItems.ITEMS.register(name, () -> new BlockItem(block.get(), new Item.Properties().tab(tab)));
    }

    public static void register(IEventBus eventBus) {
        BLOCKS.register(eventBus);
    }
}
