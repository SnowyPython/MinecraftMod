package net.snowypython.minecraftmod.networking.packet;

import net.minecraft.ChatFormatting;
import net.minecraft.network.FriendlyByteBuf;
import net.minecraft.network.chat.Component;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.sounds.SoundSource;
import net.minecraft.world.level.block.Blocks;
import net.minecraftforge.network.NetworkEvent;
import net.snowypython.minecraftmod.thirst.PlayerThirstProvider;

import java.util.function.Supplier;

public class DrinkWaterC2SPacket {
    private static final String MESSAGE_DRINK_WATER = "message.minecraftmod.drink_water";
    private static final String MESSAGE_NO_WATER = "message.minecraftmod.no_water";
    public DrinkWaterC2SPacket() {

    }

    public DrinkWaterC2SPacket(FriendlyByteBuf buf) {

    }

    public void toBytes(FriendlyByteBuf buf) {

    }

    public boolean handle(Supplier<NetworkEvent.Context> supplier) {
        NetworkEvent.Context context = supplier.get();
        context.enqueueWork(() -> {
            ServerPlayer player = context.getSender();
            ServerLevel level = player.getLevel();

            if(hasWaterAroundThem(player, level, 2)) {
                player.sendSystemMessage(Component.translatable(MESSAGE_DRINK_WATER).withStyle(ChatFormatting.DARK_AQUA));

                level.playSound(null, player.getOnPos(), SoundEvents.GENERIC_DRINK, SoundSource.PLAYERS,
                        0.5f, level.random.nextFloat() * 0.1f + 0.9f);

                player.getCapability(PlayerThirstProvider.PLAYER_THIRST).ifPresent(thirst -> {
                    thirst.addThirst(1);
                    player.sendSystemMessage(Component.literal("Current thirst " + thirst.getThirst()).withStyle(ChatFormatting.AQUA));
                });

            }
            else {
                player.sendSystemMessage(Component.translatable(MESSAGE_DRINK_WATER).withStyle(ChatFormatting.RED));
            }

        });
        return true;
    }

    private boolean hasWaterAroundThem(ServerPlayer player, ServerLevel level, int size) {
        return level.getBlockStates(player.getBoundingBox().inflate(size))
                .filter(state -> state.is(Blocks.WATER)).toArray().length > 0;
    }
}
