package com.taotie.moonlightshadow.util;

import net.minecraftforge.oredict.OreDictionary;

public class OreDictionaryLoader {
	public OreDictionaryLoader() {
		for (EOreDictionary dictionary : EOreDictionary.values()) {
			switch (dictionary.getType()) {
			case 0:
				OreDictionary.registerOre(dictionary.getName(), dictionary.getBlock());
				break;
			case 1:
				OreDictionary.registerOre(dictionary.getName(), dictionary.getItem());
				break;
			case 2:
				OreDictionary.registerOre(dictionary.getName(), dictionary.getItemStack());
				break;
			}

		}
	}
}
