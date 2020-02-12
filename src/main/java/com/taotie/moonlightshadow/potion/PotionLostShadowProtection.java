package com.taotie.moonlightshadow.potion;

import com.taotie.moonlightshadow.MoonLightShadow;

import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.Gui;
import net.minecraft.potion.Potion;
import net.minecraft.potion.PotionEffect;
import net.minecraft.util.ResourceLocation;

public class PotionLostShadowProtection extends Potion {
	private final ResourceLocation res;

	protected PotionLostShadowProtection() {
		super(false, 0x7F0000);
		res = new ResourceLocation(MoonLightShadow.MODID + ":" + "textures/gui/potion.png");
		this.setPotionName("potion.LostShadowProtection");
		this.setRegistryName("lost_shadow_protection");
	}

	@Override
	public boolean hasStatusIcon() {
		return false;
	}

	@Override
	public void renderInventoryEffect(int x, int y, PotionEffect effect, Minecraft mc) {
		this.renderHUDEffect(x, y, effect, mc, 1F);
	}

	@Override
	public void renderHUDEffect(int x, int y, PotionEffect effect, Minecraft mc, float alpha) {
		mc.getTextureManager().bindTexture(res);
		Gui.drawModalRectWithCustomSizedTexture(x, y, 0, 0, 0, 0, 0, 0);
	}
}
