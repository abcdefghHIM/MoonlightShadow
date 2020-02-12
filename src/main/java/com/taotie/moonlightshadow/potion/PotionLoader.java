package com.taotie.moonlightshadow.potion;

import net.minecraft.potion.Potion;

public class PotionLoader {
	public static Potion LostShadowProtection;

	public PotionLoader() {
		LostShadowProtection = new PotionLostShadowProtection();
	}
}
