package com.taotie.moonlightshadow.block;

import java.util.List;
import java.util.Objects;
import java.util.Random;

import javax.annotation.Nullable;

import com.taotie.moonlightshadow.creativetab.CreativeTabsLoader;

import net.minecraft.block.BlockLeaves;
import net.minecraft.block.BlockPlanks.EnumType;
import net.minecraft.block.state.BlockStateContainer;
import net.minecraft.block.state.IBlockState;
import net.minecraft.entity.item.EntityItem;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Items;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.stats.StatList;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.BlockRenderLayer;
import net.minecraft.util.NonNullList;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;

public class MoonlightLeaves extends BlockLeaves {
	public MoonlightLeaves() {
		this.setRegistryName("moonlight_leaves");
		this.setUnlocalizedName("MoonlightLeaves");
		this.setLightLevel(1.0F);
		this.setCreativeTab(CreativeTabsLoader.moonlightBlock);
		this.setDefaultState(
				this.blockState.getBaseState().withProperty(CHECK_DECAY, false).withProperty(DECAYABLE, true));
	}

	@Override
	public IBlockState getStateFromMeta(int meta) {
		return this.getDefaultState().withProperty(DECAYABLE, (meta & 4) == 0).withProperty(CHECK_DECAY,
				(meta & 8) > 0);
	}

	@Override
	public int getMetaFromState(IBlockState state) {
		int i = 0;

		if (!state.getValue(DECAYABLE)) {
			i |= 4;
		}

		if (state.getValue(CHECK_DECAY)) {
			i |= 8;
		}

		return i;
	}

	@Override
	public List<ItemStack> onSheared(ItemStack item, IBlockAccess world, BlockPos pos, int fortune) {
		return NonNullList.withSize(1, new ItemStack(this));
	}

	@Override
	public EnumType getWoodType(int meta) {
		return null;
	}

	@Override
	protected BlockStateContainer createBlockState() {
		return new BlockStateContainer(this, CHECK_DECAY, DECAYABLE);
	}

	@Override
	public void harvestBlock(World worldIn, EntityPlayer player, BlockPos pos, IBlockState state,
			@Nullable TileEntity te, ItemStack stack) {
		if (!worldIn.isRemote && stack.getItem() == Items.SHEARS) {
			player.addStat(Objects.requireNonNull(StatList.getBlockStats(this)));
		} else {
			if (worldIn.rand.nextInt(10) == 0)
				worldIn.spawnEntity(new EntityItem(worldIn, pos.getX(), pos.getY(), pos.getZ(),
						new ItemStack(EBlock.MoonlightSapling.getBlock())));

			super.harvestBlock(worldIn, player, pos, state, te, stack);
		}
	}

	@Override
	public Item getItemDropped(IBlockState state, Random rand, int fortune) {
		return Item.getItemFromBlock(EBlock.MoonlightSapling.getBlock());
	}

	@Override
	public BlockRenderLayer getBlockLayer() {
		return BlockRenderLayer.CUTOUT_MIPPED;
	}

	@Override
	public boolean isOpaqueCube(IBlockState state) {
		return false;
	}
}
