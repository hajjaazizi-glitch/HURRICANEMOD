package com.example.hurricanemod;

import net.minecraft.client.Minecraft;
import net.minecraft.client.multiplayer.ClientLevel;
import net.minecraft.core.particles.ParticleTypes;
import net.minecraft.world.phys.Vec3;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.event.TickEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

import java.util.Random;

@Mod.EventBusSubscriber(modid = HurricaneMod.MODID, value = Dist.CLIENT, bus = Mod.EventBusSubscriber.Bus.FORGE)
public class HurricaneManager {
    private static boolean active = false;
    private static Vec3 center = Vec3.ZERO;
    private static int tickCounter = 0;
    private static final Random random = new Random();

    public static void start(Vec3 pos) {
        active = true;
        center = pos;
        tickCounter = 0;
    }

    public static void stop() {
        active = false;
    }

    @SubscribeEvent
    public static void onClientTick(TickEvent.ClientTickEvent event) {
        if (event.phase != TickEvent.Phase.END || !active) return;

        Minecraft mc = Minecraft.getInstance();
        ClientLevel level = mc.level;
        if (level == null || mc.isPaused()) return;

        tickCounter++;
        // Time controls the rotation speed of the overall hurricane
        double time = tickCounter * 0.15;

        int particlesPerTick = 60;
        double maxRadius = 15.0;
        double eyeRadius = 3.0;

        for (int i = 0; i < particlesPerTick; i++) {
            // Random distance from the eye
            double radius = eyeRadius + (random.nextDouble() * (maxRadius - eyeRadius));
            // Random angle offset for particle
            double angle = time + (random.nextDouble() * Math.PI * 2);
            
            // Taper effect: higher particles are further out
            double heightRatio = (radius - eyeRadius) / (maxRadius - eyeRadius);
            double heightOffset = (heightRatio * 15.0) + (random.nextDouble() * 2.0);

            double px = center.x + Math.cos(angle) * radius;
            double pz = center.z + Math.sin(angle) * radius;
            double py = center.y + heightOffset;

            // Inward / rotational velocity
            double vx = -Math.sin(angle) * 0.8;
            double vy = 0.2 + (random.nextDouble() * 0.2); // Updraft
            double vz = Math.cos(angle) * 0.8;

            if (random.nextDouble() < 0.1) {
                level.addParticle(ParticleTypes.EXPLOSION_NORMAL, px, py, pz, vx, vy, vz);
            } else if (random.nextDouble() < 0.3) {
                level.addParticle(ParticleTypes.SWEEP_ATTACK, px, py, pz, vx, vy, vz);
            } else {
                level.addParticle(ParticleTypes.CLOUD, px, py, pz, vx, vy, vz);
            }
        }
    }
}
