package com.taotie.moonlightshadow.block;

import com.taotie.moonlightshadow.creativetab.CreativeTabsLoader;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;

public class MoonlightPlanks extends Block{
	public MoonlightPlanks() {
		super(Material.WOOD);
		this.setRegistryName("moonlight_planks");
		this.setUnlocalizedName("MoonlightPlanks");
		this.setLightLevel(1.0F);
		this.setCreativeTab(CreativeTabsLoader.moonlightBlock);
	}
}
