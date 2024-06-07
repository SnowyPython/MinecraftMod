package net.snowypython.minecraftmod.networking.packet;

import net.minecraft.network.FriendlyByteBuf;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.MobSpawnType;
import net.minecraftforge.network.NetworkEvent;

import java.util.function.Supplier;

public class FirstC2SPacket {
    public FirstC2SPacket() {

    }

    public FirstC2SPacket(FriendlyByteBuf buf) {

    }

    public void toBytes(FriendlyByteBuf buf) {

    }

    public boolean handle(Supplier<NetworkEvent.Context> supplier) {
        NetworkEvent.Context context = supplier.get();
        context.enqueueWork(() -> {
            //on server
            ServerPlayer player = context.getSender();
            ServerLevel level = player.getLevel();

            EntityType.COW.spawn(level, null, null, player.blockPosition(),
                    MobSpawnType.COMMAND, true, false);
        });
        return true;
    }
}
