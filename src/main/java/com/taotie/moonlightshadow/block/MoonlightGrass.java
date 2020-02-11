package com.taotie.moonlightshadow.block;

import java.util.Random;

import com.taotie.moonlightshadow.creativetab.CreativeTabsLoader;

import net.minecraft.block.Block;
import net.minecraft.block.BlockTallGrass;
import net.minecraft.block.IGrowable;
import net.minecraft.block.material.Material;
import net.minecraft.block.state.IBlockState;
import net.minecraft.init.Blocks;
import net.minecraft.util.BlockRenderLayer;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

public class MoonlightGrass extends Block implements IGrowable {
	public MoonlightGrass() {
		super(Material.GLASS);
		this.setRegistryName("moonlight_grass");
		this.setUnlocalizedName("MoonlightGrass");
		this.setLightLevel(1.0F);
		this.setCreativeTab(CreativeTabsLoader.moonlightBlock);
	}

	@Override
	public boolean canGrow(World worldIn, BlockPos pos, IBlockState state, boolean isClient) {
		return true;
	}

	@Override
	public boolean canUseBonemeal(World worldIn, Random rand, BlockPos pos, IBlockState state) {
		return true;
	}

	@Override
	public void grow(World worldIn, Random rand, BlockPos pos, IBlockState state) {
		BlockPos blockpos = pos.up();
		for (int i = 0; i < 128; ++i) {
			BlockPos blockpos1 = blockpos;
			int j = 0;
			while (true) {
				if (j >= i / 16) {
					if (worldIn.isAirBlock(blockpos1)) {
						if (rand.nextInt(8) == 0) {
							worldIn.getBiome(blockpos1).plantFlower(worldIn, rand, blockpos1);
						} else {
							IBlockState iblockstate1 = Blocks.TALLGRASS.getDefaultState()
									.withProperty(BlockTallGrass.TYPE, BlockTallGrass.EnumType.GRASS);
							if (Blocks.TALLGRASS.canBlockStay(worldIn, blockpos1, iblockstate1)) {
								worldIn.setBlockState(blockpos1, iblockstate1, 3);
							}
						}
					}
					break;
				}
				blockpos1 = blockpos1.add(rand.nextInt(3) - 1, (rand.nextInt(3) - 1) * rand.nextInt(3) / 2,
						rand.nextInt(3) - 1);
				if (worldIn.getBlockState(blockpos1.down()).getBlock() != Blocks.GRASS
						|| worldIn.getBlockState(blockpos1).isNormalCube()) {
					break;
				}
				++j;
			}
		}
	}

	@SideOnly(Side.CLIENT)
	public BlockRenderLayer getBlockLayer() {
		return BlockRenderLayer.CUTOUT_MIPPED;
	}
}
