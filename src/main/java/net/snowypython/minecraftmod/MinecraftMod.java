package net.snowypython.minecraftmod;

import com.mojang.logging.LogUtils;
import net.minecraft.client.renderer.ItemBlockRenderTypes;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.world.level.block.Blocks;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import net.minecraftforge.registries.ForgeRegistries;
import net.snowypython.minecraftmod.block.ModBlocks;
import net.snowypython.minecraftmod.item.ModItems;
import net.snowypython.minecraftmod.painting.ModPaintings;
import net.snowypython.minecraftmod.villager.ModVillagers;
import org.slf4j.Logger;

@Mod(MinecraftMod.MOD_ID)
public class MinecraftMod
{
    public static final String MOD_ID = "minecraftmod";

    private static final Logger LOGGER = LogUtils.getLogger();

    public MinecraftMod()
    {
        IEventBus modEventBus = FMLJavaModLoadingContext.get().getModEventBus();

        ModItems.register(modEventBus);
        ModBlocks.register(modEventBus);
        ModVillagers.register(modEventBus);
        ModPaintings.register(modEventBus);

        modEventBus.addListener(this::commonSetup);

        MinecraftForge.EVENT_BUS.register(this);
    }

    private void commonSetup(final FMLCommonSetupEvent event)
    {
        event.enqueueWork(() -> {
            ModVillagers.registerPOIs();
        });
    }

    // You can use EventBusSubscriber to automatically register all static methods in the class annotated with @SubscribeEvent
    @Mod.EventBusSubscriber(modid = MOD_ID, bus = Mod.EventBusSubscriber.Bus.MOD)
    public static class ClientModEvents
    {
        @SubscribeEvent
        public static void onClientSetup(FMLClientSetupEvent event)
        {
            //noinspection removal
            ItemBlockRenderTypes.setRenderLayer(ModBlocks.CORN_CROP.get(), RenderType.cutout());
        }
    }
}
