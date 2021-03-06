package com.taotie.moonlightshadow.common;

import com.taotie.moonlightshadow.block.BlockLoader;
import com.taotie.moonlightshadow.creativetab.CreativeTabsLoader;
import com.taotie.moonlightshadow.entity.EntityLoader;
import com.taotie.moonlightshadow.item.ItemLoader;
import com.taotie.moonlightshadow.potion.PotionLoader;
import com.taotie.moonlightshadow.util.OreDictionaryLoader;
import com.taotie.moonlightshadow.world.WorldLoader;

import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;

public class CommonProxy {
	public void preInit(FMLPreInitializationEvent event) {
		new CreativeTabsLoader();
		new ItemLoader();
		new BlockLoader();
		new WorldLoader();
		new EntityLoader();
		new OreDictionaryLoader();
		new PotionLoader();
	}

	public void init(FMLInitializationEvent event) {

	}

	public void postInit(FMLPostInitializationEvent event) {

	}
}
