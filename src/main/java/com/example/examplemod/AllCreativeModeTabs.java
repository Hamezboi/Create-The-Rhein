package com.example.examplemod;

import net.minecraft.core.registries.Registries;
import net.minecraft.network.chat.Component;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.RegistryObject;

public class AllCreativeModeTabs {

    public static final DeferredRegister<CreativeModeTab> REGISTER =
            DeferredRegister.create(Registries.CREATIVE_MODE_TAB, ExampleMod.ID);

    public static final RegistryObject<CreativeModeTab> MAIN_TAB =
            REGISTER.register("main_tab", () ->
                    CreativeModeTab.builder()
                            .title(Component.translatable(Lang.CREATIVE_TAB))
                            .icon(() -> new ItemStack(Items.HONEYCOMB))
                            .build()
            );

    public static void register(IEventBus modBus) {
        REGISTER.register(modBus);
    }
}