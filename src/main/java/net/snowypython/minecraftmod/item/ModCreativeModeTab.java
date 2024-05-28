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

    public static final CreativeModeTab ORES_TAB = new CreativeModeTab("orestab") {
        @Override
        public ItemStack makeIcon() {
            return new ItemStack(ModBlocks.TIN_ORE.get());
        }
    };

    public static final CreativeModeTab FOOD_TAB = new CreativeModeTab("foodtab") {
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
}
