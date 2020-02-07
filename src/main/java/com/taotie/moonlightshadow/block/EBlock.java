package com.taotie.moonlightshadow.block;

import net.minecraft.block.Block;

public enum EBlock {
	MoonlightGrass(new MoonlightGrass()), MoonlightDirt(new MoonlightDirt()), MoonlightPortal(new MoonlightPortal());
	private Block block;

	private EBlock(Block block) {
		this.block = block;
	}

	public Block getBlock() {
		return block;
	}
}
