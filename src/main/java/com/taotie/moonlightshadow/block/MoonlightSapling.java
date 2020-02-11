package com.taotie.moonlightshadow.block;

import java.util.Random;

import com.taotie.moonlightshadow.creativetab.CreativeTabsLoader;
import com.taotie.moonlightshadow.util.WorldGenTrees;

import net.minecraft.block.BlockBush;
import net.minecraft.block.IGrowable;
import net.minecraft.block.state.IBlockState;
import net.minecraft.init.Blocks;
import net.minecraft.util.math.AxisAlignedBB;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;
import net.minecraft.world.gen.feature.WorldGenerator;
import net.minecraftforge.event.terraingen.TerrainGen;

public class MoonlightSapling extends BlockBush implements IGrowable {
	protected static final AxisAlignedBB SAPLING_AABB = new AxisAlignedBB(0.09999999403953552D, 0.0D,
			0.09999999403953552D, 0.8999999761581421D, 0.800000011920929D, 0.8999999761581421D);

	public MoonlightSapling() {
		this.setRegistryName("moonlight_sapling");
		this.setUnlocalizedName("MoonlightSapling");
		this.setCreativeTab(CreativeTabsLoader.moonlightBlock);
	}

	@Override
	public boolean canGrow(World worldIn, BlockPos pos, IBlockState state, boolean isClient) {
		return true;
	}

	@Override
	public boolean canUseBonemeal(World worldIn, Random rand, BlockPos pos, IBlockState state) {
		return worldIn.rand.nextFloat() < 0.45D;
	}

	@Override
	public void grow(World worldIn, Random rand, BlockPos pos, IBlockState state) {

		if (!worldIn.isRemote && TerrainGen.saplingGrowTree(worldIn, rand, pos)) {
			WorldGenerator worldgenerator = new WorldGenTrees(true, 4, EBlock.MoonlightLog.getBlock().getDefaultState(),
					EBlock.MoonlightLeaves.getBlock().getDefaultState(), false);
			IBlockState iblockstate2 = Blocks.AIR.getDefaultState();
			int i = 0;
			int j = 0;

			worldIn.setBlockState(pos, iblockstate2, 4);
			if (!worldgenerator.generate(worldIn, rand, pos.add(i, 0, j))) {
				worldIn.setBlockState(pos, state, 4);
			}
		}
	}

	@Override
	public AxisAlignedBB getBoundingBox(IBlockState state, IBlockAccess source, BlockPos pos) {
		return SAPLING_AABB;
	}

	@Override
	public void updateTick(World worldIn, BlockPos pos, IBlockState state, Random rand) {
		if (!worldIn.isRemote) {
			super.updateTick(worldIn, pos, state, rand);

			if (!worldIn.isAreaLoaded(pos, 1))
				return;
			if (worldIn.getLightFromNeighbors(pos.up()) >= 9 && rand.nextInt(7) == 0) {
				this.grow(worldIn, rand, pos, state);
			}
		}
	}
}
