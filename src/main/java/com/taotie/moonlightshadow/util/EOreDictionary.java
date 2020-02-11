package com.taotie.moonlightshadow.util;

import net.minecraft.block.Block;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import com.taotie.moonlightshadow.block.EBlock;

public enum EOreDictionary {
	;
	private String name;
	private Block ore_block;
	private Item ore_item;
	private ItemStack ore_itemstack;
	private int type;

	private EOreDictionary(String name, Block ore_block) {
		this.name = name;
		this.ore_block = ore_block;
		this.type = 0;
	}

	private EOreDictionary(String name, Item ore_item) {
		this.name = name;
		this.ore_item = ore_item;
		this.type = 1;
	}

	private EOreDictionary(String name, ItemStack ore_itemstack) {
		this.name = name;
		this.ore_itemstack = ore_itemstack;
		this.type = 2;
	}

	public String getName() {
		return name;
	}

	public int getType() {
		return type;
	}

	public Block getBlock() {
		return ore_block;
	}

	public Item getItem() {
		return ore_item;
	}

	public ItemStack getItemStack() {
		return ore_itemstack;
	}
}
