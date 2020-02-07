package com.taotie.moonlightshadow.creativetab;

import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.init.Items;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;

public class CreativeTabsEntity extends CreativeTabs {

	public CreativeTabsEntity() {
		super("entity");
	}

	@Override
	public ItemStack getTabIconItem() {
		return new ItemStack(Items.APPLE);
	}

}
