package com.taotie.moonlightshadow.creativetab;

import com.taotie.moonlightshadow.block.EBlock;

import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.ItemStack;

public class CreativeTabsBlock extends CreativeTabs {
	public CreativeTabsBlock() {
		super("block");
	}

	@Override
	public ItemStack getTabIconItem() {
		return new ItemStack(EBlock.MoonlightGrass.getBlock());
	}
}
