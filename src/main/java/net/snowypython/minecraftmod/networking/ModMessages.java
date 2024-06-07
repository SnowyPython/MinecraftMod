package net.snowypython.minecraftmod.networking;

import net.minecraft.resources.ResourceLocation;
import net.minecraft.server.level.ServerPlayer;
import net.minecraftforge.network.NetworkDirection;
import net.minecraftforge.network.NetworkRegistry;
import net.minecraftforge.network.PacketDistributor;
import net.minecraftforge.network.simple.SimpleChannel;
import net.snowypython.minecraftmod.MinecraftMod;
import net.snowypython.minecraftmod.networking.packet.DrinkWaterC2SPacket;
import net.snowypython.minecraftmod.networking.packet.FirstC2SPacket;

public class ModMessages {
    private static SimpleChannel INSTANCE;

    private static int packetId = 0;
    private static int id() {
        return packetId++;
    }

    public static void register() {
        SimpleChannel net = NetworkRegistry.ChannelBuilder
                .named(new ResourceLocation(MinecraftMod.MOD_ID, "messages"))
                .networkProtocolVersion(() -> "1.0")
                .clientAcceptedVersions(s -> true)
                .serverAcceptedVersions(s -> true)
                .simpleChannel();

        INSTANCE = net;

        net.messageBuilder(FirstC2SPacket.class, id(), NetworkDirection.PLAY_TO_SERVER)
                .decoder(FirstC2SPacket::new)
                .encoder(FirstC2SPacket::toBytes)
                .consumerMainThread(FirstC2SPacket::handle)
                .add();

        net.messageBuilder(DrinkWaterC2SPacket.class, id(), NetworkDirection.PLAY_TO_SERVER)
                .decoder(DrinkWaterC2SPacket::new)
                .encoder(DrinkWaterC2SPacket::toBytes)
                .consumerMainThread(DrinkWaterC2SPacket::handle)
                .add();
    }

    public static <MSG> void sendToServer(MSG message) {
        INSTANCE.sendToServer(message);
    }

    public static <MSG> void sendToPlayer(MSG message, ServerPlayer player) {
        INSTANCE.send(PacketDistributor.PLAYER.with(() -> player), message);
    }
}
