package net.snowypython.minecraftmod.item;

import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.ItemStack;
import net.snowypython.minecraftmod.block.ModBlocks;

public class ModCreativeModeTab {
    public static final CreativeModeTab RESOURCES_TAB = new CreativeModeTab("resourcestab") {
        @Override
        public ItemStack makeIcon() {
            return new ItemStack(ModItems.TIN_INGOT.get());
        }
    };

    public static final CreativeModeTab BLOCKS_TAB = new CreativeModeTab("blockstab") {
        @Override
        public ItemStack makeIcon() {
            return new ItemStack(ModBlocks.SPEEDY_BLOCK.get());
        }
    };

    public static final CreativeModeTab NATURE_TAB = new CreativeModeTab("naturetab") {
        @Override
        public ItemStack makeIcon() {
            return new ItemStack(ModItems.ORANGE.get());
        }
    };

    public static final CreativeModeTab TOOLS_TAB = new CreativeModeTab("toolstab") {
        @Override
        public ItemStack makeIcon() {
            return new ItemStack(ModItems.PLATINUM_PICKAXE.get());
        }
    };

    public static final CreativeModeTab COMBAT_TAB = new CreativeModeTab("combattab") {
        @Override
        public ItemStack makeIcon() {
            return new ItemStack(ModItems.PLATINUM_CHESTPLATE.get());
        }
    };
}
