package com.taotie.moonlightshadow.block;

import com.taotie.moonlightshadow.creativetab.CreativeTabsLoader;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;

public class MoonlightDirt extends Block{
	public MoonlightDirt() {
		super(Material.GROUND);
		this.setRegistryName("moonlight_dirt");
		this.setUnlocalizedName("MoonlightDirt");
		this.setLightLevel(1.0F);
		this.setCreativeTab(CreativeTabsLoader.moonlightBlock);
	}
}
