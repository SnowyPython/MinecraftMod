package net.snowypython.minecraftmod.painting;

import net.minecraft.world.entity.decoration.PaintingVariant;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;
import net.snowypython.minecraftmod.MinecraftMod;

public class ModPaintings {
    public static final DeferredRegister<PaintingVariant> PAINTING_VARIANTS =
            DeferredRegister.create(ForgeRegistries.PAINTING_VARIANTS, MinecraftMod.MOD_ID);

    public static final RegistryObject<PaintingVariant> GIRL = PAINTING_VARIANTS.register("girl",
            () -> new PaintingVariant(64, 64));

    public static void register(IEventBus eventBus) {
        PAINTING_VARIANTS.register(eventBus);
    }
}
