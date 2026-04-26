package com.example.hurricanemod;

import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.client.event.RegisterClientCommandsEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraft.network.chat.Component;

@Mod.EventBusSubscriber(modid = HurricaneMod.MODID, value = Dist.CLIENT, bus = Mod.EventBusSubscriber.Bus.FORGE)
public class HurricaneCommandClient {
    
    @SubscribeEvent
    public static void onClientCommandRegister(RegisterClientCommandsEvent event) {
        event.getDispatcher().register(
            net.minecraft.commands.Commands.literal("hurricane")
            .then(net.minecraft.commands.Commands.literal("start").executes(context -> {
                HurricaneManager.start(net.minecraft.client.Minecraft.getInstance().player.position());
                net.minecraft.client.Minecraft.getInstance().player.displayClientMessage(Component.literal("§bHurricane effect started!"), false);
                return 1;
            }))
            .then(net.minecraft.commands.Commands.literal("stop").executes(context -> {
                HurricaneManager.stop();
                if (net.minecraft.client.Minecraft.getInstance().player != null) {
                    net.minecraft.client.Minecraft.getInstance().player.displayClientMessage(Component.literal("§cHurricane effect stopped!"), false);
                }
                return 1;
            }))
        );
    }
}
