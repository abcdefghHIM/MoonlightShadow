package com.taotie.moonlightshadow.block;

import com.taotie.moonlightshadow.creativetab.CreativeTabsLoader;

import net.minecraft.block.BlockLog;
import net.minecraft.block.state.BlockStateContainer;
import net.minecraft.block.state.IBlockState;

public class MoonlightLog extends BlockLog {
	public MoonlightLog() {
		this.setRegistryName("moonlight_log");
		this.setUnlocalizedName("MoonlightLog");
		this.setLightLevel(1.0F);
		this.setHardness(1.5F);
		this.setHarvestLevel("axe", 1);
		this.setCreativeTab(CreativeTabsLoader.moonlightBlock);
		this.setDefaultState(this.blockState.getBaseState().withProperty(LOG_AXIS, EnumAxis.Y));
	}

	@Override
	protected BlockStateContainer createBlockState() {
		return new BlockStateContainer(this, LOG_AXIS);
	}

	@Override
	public IBlockState getStateFromMeta(int meta) {
		EnumAxis enumfacing$axis = EnumAxis.Y;
		int i = meta & 12;

		if (i == 4) {
			enumfacing$axis = EnumAxis.X;
		} else if (i == 8) {
			enumfacing$axis = EnumAxis.Z;
		}

		return this.getDefaultState().withProperty(LOG_AXIS, enumfacing$axis);
	}

	@Override
	public int getMetaFromState(IBlockState state) {
		int i = 0;
		EnumAxis enumfacing$axis = (EnumAxis) state.getValue(LOG_AXIS);

		if (enumfacing$axis == EnumAxis.X) {
			i |= 4;
		} else if (enumfacing$axis == EnumAxis.Z) {
			i |= 8;
		}

		return i;
	}
}
