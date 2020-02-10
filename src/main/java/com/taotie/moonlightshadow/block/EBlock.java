package com.taotie.moonlightshadow.block;

import net.minecraft.block.Block;

public enum EBlock {
	MoonlightGrass(new MoonlightGrass()), MoonlightDirt(new MoonlightDirt()), MoonlightPortal(new MoonlightPortal()),
	MoonlightLog(new MoonlightLog()), MoonlightLeaves(new MoonlightLeaves()), MoonlightSapling(new MoonlightSapling()),
	MoonlightPlanks(new MoonlightPlanks());
	private Block block;

	private EBlock(Block block) {
		this.block = block;
	}

	public Block getBlock() {
		return block;
	}
}
