package com.taotie.moonlightshadow.client;

import com.taotie.moonlightshadow.block.BlockLoader;
import com.taotie.moonlightshadow.item.ItemLoader;

public class ItemRenderLoader {
	public ItemRenderLoader() {
		ItemLoader.registerRenders();
		BlockLoader.registerRenders();
	}
}
