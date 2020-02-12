package com.taotie.moonlightshadow.creativetab;

import net.minecraft.creativetab.CreativeTabs;

public class CreativeTabsLoader {
	public static CreativeTabs moonlightEntity;
	public static CreativeTabs moonlightBlock;

	public CreativeTabsLoader() {
		moonlightEntity = new CreativeTabsEntity();
		moonlightBlock = new CreativeTabsBlock();
	}
}
