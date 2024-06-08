package net.snowypython.minecraftmod.event;

import it.unimi.dsi.fastutil.ints.Int2ObjectMap;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.npc.VillagerTrades;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.trading.MerchantOffer;
import net.minecraftforge.common.capabilities.RegisterCapabilitiesEvent;
import net.minecraftforge.event.AttachCapabilitiesEvent;
import net.minecraftforge.event.TickEvent;
import net.minecraftforge.event.entity.player.PlayerEvent;
import net.minecraftforge.event.village.VillagerTradesEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.LogicalSide;
import net.minecraftforge.fml.common.Mod;
import net.snowypython.minecraftmod.MinecraftMod;
import net.snowypython.minecraftmod.item.ModItems;
import net.snowypython.minecraftmod.thirst.PlayerThirst;
import net.snowypython.minecraftmod.thirst.PlayerThirstProvider;
import net.snowypython.minecraftmod.villager.ModVillagers;

import java.util.List;

@Mod.EventBusSubscriber(modid = MinecraftMod.MOD_ID)
public class ModEvents {
    @SubscribeEvent
    public static void addCustomTrades(VillagerTradesEvent event) {
        //metallurgist
        if(event.getType() == ModVillagers.METALLURGIST.get()) {
            Int2ObjectMap<List<VillagerTrades.ItemListing>> trades = event.getTrades();
            ItemStack stack = new ItemStack(Items.COPPER_INGOT, 2);
            int villagerLevel = 1;

            trades.get(villagerLevel).add((trader, rand) -> new MerchantOffer(
                    new ItemStack(Items.EMERALD, 1),
                    stack,10,8,0.02F));
        }

        if(event.getType() == ModVillagers.METALLURGIST.get()) {
            Int2ObjectMap<List<VillagerTrades.ItemListing>> trades = event.getTrades();
            ItemStack stack = new ItemStack(Items.IRON_INGOT, 2);
            int villagerLevel = 1;

            trades.get(villagerLevel).add((trader, rand) -> new MerchantOffer(
                    new ItemStack(Items.EMERALD, 1),
                    stack,10,8,0.02F));
        }

        if(event.getType() == ModVillagers.METALLURGIST.get()) {
            Int2ObjectMap<List<VillagerTrades.ItemListing>> trades = event.getTrades();
            ItemStack stack = new ItemStack(ModItems.TIN_INGOT.get(), 2);
            int villagerLevel = 2;

            trades.get(villagerLevel).add((trader, rand) -> new MerchantOffer(
                    new ItemStack(Items.EMERALD, 1),
                    stack,10,8,0.02F));
        }

        if(event.getType() == ModVillagers.METALLURGIST.get()) {
            Int2ObjectMap<List<VillagerTrades.ItemListing>> trades = event.getTrades();
            ItemStack stack = new ItemStack(ModItems.ALUMINUM_INGOT.get(), 2);
            int villagerLevel = 2;

            trades.get(villagerLevel).add((trader, rand) -> new MerchantOffer(
                    new ItemStack(Items.EMERALD, 1),
                    stack,10,8,0.02F));
        }

        if(event.getType() == ModVillagers.METALLURGIST.get()) {
            Int2ObjectMap<List<VillagerTrades.ItemListing>> trades = event.getTrades();
            ItemStack stack = new ItemStack(ModItems.LEAD_INGOT.get(), 1);
            int villagerLevel = 2;

            trades.get(villagerLevel).add((trader, rand) -> new MerchantOffer(
                    new ItemStack(Items.EMERALD, 1),
                    stack,10,8,0.02F));
        }

        if(event.getType() == ModVillagers.METALLURGIST.get()) {
            Int2ObjectMap<List<VillagerTrades.ItemListing>> trades = event.getTrades();
            ItemStack stack = new ItemStack(ModItems.SILVER_INGOT.get(), 1);
            int villagerLevel = 3;

            trades.get(villagerLevel).add((trader, rand) -> new MerchantOffer(
                    new ItemStack(Items.EMERALD, 4),
                    stack,10,8,0.02F));
        }

        if(event.getType() == ModVillagers.METALLURGIST.get()) {
            Int2ObjectMap<List<VillagerTrades.ItemListing>> trades = event.getTrades();
            ItemStack stack = new ItemStack(Items.GOLD_INGOT, 1);
            int villagerLevel = 3;

            trades.get(villagerLevel).add((trader, rand) -> new MerchantOffer(
                    new ItemStack(Items.EMERALD, 4),
                    stack,10,8,0.02F));
        }

        if(event.getType() == ModVillagers.METALLURGIST.get()) {
            Int2ObjectMap<List<VillagerTrades.ItemListing>> trades = event.getTrades();
            ItemStack stack = new ItemStack(ModItems.PLATINUM_INGOT.get(), 1);
            int villagerLevel = 4;

            trades.get(villagerLevel).add((trader, rand) -> new MerchantOffer(
                    new ItemStack(Items.EMERALD, 8),
                    stack,10,8,0.02F));
        }

        if(event.getType() == ModVillagers.METALLURGIST.get()) {
            Int2ObjectMap<List<VillagerTrades.ItemListing>> trades = event.getTrades();
            ItemStack stack = new ItemStack(ModItems.TITANIUM_INGOT.get(), 1);
            int villagerLevel = 4;

            trades.get(villagerLevel).add((trader, rand) -> new MerchantOffer(
                    new ItemStack(Items.EMERALD, 8),
                    stack,10,8,0.02F));
        }
    }

    @SubscribeEvent
    public static void onAttachCapabilitiesPlayer(AttachCapabilitiesEvent<Entity> event) {
        if(event.getObject() instanceof Player) {
            if(!event.getObject().getCapability(PlayerThirstProvider.PLAYER_THIRST).isPresent()) {
                event.addCapability(new ResourceLocation(MinecraftMod.MOD_ID, "properties"), new PlayerThirstProvider());
            }
        }
    }

    @SubscribeEvent
    public static void onPlayerCloned(PlayerEvent.Clone event) {
        if(event.isWasDeath()) {
            event.getOriginal().getCapability(PlayerThirstProvider.PLAYER_THIRST).ifPresent(oldStore -> {
                event.getOriginal().getCapability(PlayerThirstProvider.PLAYER_THIRST).ifPresent(newStore -> {
                    newStore.copyFrom(oldStore);
                });
            });
        }
    }

    @SubscribeEvent
    public static void onRegisterCapabilities(RegisterCapabilitiesEvent event) {
        event.register(PlayerThirst.class);
    }

    @SubscribeEvent
    public static void onPlayerTick(TickEvent.PlayerTickEvent event) {
        if(event.side == LogicalSide.SERVER) {
            event.player.getCapability(PlayerThirstProvider.PLAYER_THIRST).ifPresent(thirst -> {
                if(thirst.getThirst() > 0 && event.player.getRandom().nextFloat() < 0.005f) { // Once Every 10 Seconds on Avg
                    thirst.subThirst(1);
                    event.player.sendSystemMessage(Component.literal("Subtracted Thirst"));
                }
            });
        }
    }
}
