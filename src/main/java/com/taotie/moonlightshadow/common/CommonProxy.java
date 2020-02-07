package com.taotie.moonlightshadow.common;

import com.taotie.moonlightshadow.block.BlockLoader;
import com.taotie.moonlightshadow.item.ItemLoader;

import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;

public class CommonProxy {
	public void preInit(FMLPreInitializationEvent event) {
		new ItemLoader(event);
		new BlockLoader(event);
	}

	public void init(FMLInitializationEvent event) {

	}

	public void postInit(FMLPostInitializationEvent event) {

	}
}
