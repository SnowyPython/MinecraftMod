package net.snowypython.minecraftmod.villager;

import com.google.common.collect.ImmutableSet;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.world.entity.ai.village.poi.PoiType;
import net.minecraft.world.entity.npc.VillagerProfession;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.fml.util.ObfuscationReflectionHelper;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;
import net.snowypython.minecraftmod.MinecraftMod;
import net.snowypython.minecraftmod.block.ModBlocks;

import java.lang.reflect.InvocationTargetException;

public class ModVillagers {
    public static final DeferredRegister<PoiType> POI_TYPES =
            DeferredRegister.create(ForgeRegistries.POI_TYPES, MinecraftMod.MOD_ID);
    public static final DeferredRegister<VillagerProfession> VILLAGER_PROFESSIONS =
            DeferredRegister.create(ForgeRegistries.VILLAGER_PROFESSIONS, MinecraftMod.MOD_ID);

    public static final RegistryObject<PoiType> TITANIUM_BLOCK_POI = POI_TYPES.register("titanium_block_poi",
            () -> new PoiType(ImmutableSet.copyOf(ModBlocks.TITANIUM_BLOCK.get().getStateDefinition().getPossibleStates()),
                    1, 1));

    public static final RegistryObject<VillagerProfession> METALLURGIST = VILLAGER_PROFESSIONS.register("metallurgist",
            () -> new VillagerProfession("metallurgist", x -> x.get() == TITANIUM_BLOCK_POI.get(),
                    x -> x.get() == TITANIUM_BLOCK_POI.get(), ImmutableSet.of(), ImmutableSet.of(),
                    SoundEvents.VILLAGER_WORK_ARMORER));

    public static void registerPOIs() {
        try {
            ObfuscationReflectionHelper.findMethod(PoiType.class, "registerBlockStates", PoiType.class)
                    .invoke(null, TITANIUM_BLOCK_POI.get());
        }
        catch (InvocationTargetException | IllegalAccessException exception) {
            exception.printStackTrace();
        }
    }

    public static void register(IEventBus eventBus) {
        POI_TYPES.register(eventBus);
        VILLAGER_PROFESSIONS.register(eventBus);
    }
}
