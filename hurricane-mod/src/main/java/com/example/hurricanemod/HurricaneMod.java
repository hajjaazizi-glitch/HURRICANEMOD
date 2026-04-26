package com.example.hurricanemod;

import net.minecraftforge.fml.common.Mod;

@Mod(HurricaneMod.MODID)
public class HurricaneMod {
    public static final String MODID = "hurricanemod";

    public HurricaneMod() {
        // Nothing needed here since we are using @Mod.EventBusSubscriber for our client events
    }
}
