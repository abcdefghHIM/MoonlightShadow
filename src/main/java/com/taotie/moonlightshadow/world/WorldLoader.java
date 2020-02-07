package com.taotie.moonlightshadow.world;

import net.minecraft.world.DimensionType;
import net.minecraftforge.common.DimensionManager;

public class WorldLoader {
	public static final DimensionType MoonlightWorld = DimensionType.register("moonlightworld", "moonlight",
			MoonlightWorldProvider.MoonlightWorldID, MoonlightWorldProvider.class, false);

	public WorldLoader() {
		DimensionManager.registerDimension(MoonlightWorldProvider.MoonlightWorldID, MoonlightWorld);
	}
}
