package com.taotie.moonlightshadow.creativetab;

import net.minecraft.creativetab.CreativeTabs;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;

public class CreativeTabsLoader {
	public static CreativeTabs moonlightEntity;
	public static CreativeTabs moonlightBlock;

	public CreativeTabsLoader(FMLPreInitializationEvent event) {
		moonlightEntity = new CreativeTabsEntity();
		moonlightBlock = new CreativeTabsBlock();
	}
}
