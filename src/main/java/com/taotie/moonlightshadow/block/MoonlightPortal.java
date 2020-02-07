package com.taotie.moonlightshadow.block;

import com.taotie.moonlightshadow.world.MoonlightWorldProvider;
import com.taotie.moonlightshadow.world.WorldTeleporter;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.block.state.IBlockState;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.EntityPlayerMP;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.EnumHand;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraftforge.fml.common.FMLCommonHandler;

public class MoonlightPortal extends Block {

	public MoonlightPortal() {
		super(Material.PORTAL);
		this.setUnlocalizedName("MoonlightPortal");
		this.setRegistryName("moonlightportal");
	}

	public boolean onBlockActivated(World worldIn, BlockPos pos, IBlockState state, EntityPlayer playerIn,
			EnumHand hand, EnumFacing side, float hitX, float hitY, float hitZ) {
		if (!worldIn.isRemote && !playerIn.isSneaking()) {
			if (worldIn.provider.getDimension() != MoonlightWorldProvider.MoonlightWorldID)
				FMLCommonHandler.instance().getMinecraftServerInstance().getPlayerList().transferPlayerToDimension(
						(EntityPlayerMP) playerIn, MoonlightWorldProvider.MoonlightWorldID, new WorldTeleporter(
								playerIn.getServer().getWorld(MoonlightWorldProvider.MoonlightWorldID), pos));
			else
				FMLCommonHandler.instance().getMinecraftServerInstance().getPlayerList().transferPlayerToDimension(
						(EntityPlayerMP) playerIn, 0, new WorldTeleporter(playerIn.getServer().getWorld(0), pos));
			return true;
		} else {
			return super.onBlockActivated(worldIn, pos, state, playerIn, hand, side, hitX, hitY, hitZ);
		}
	}

	public float getBlockHardness(IBlockState blockState, World worldIn, BlockPos pos) {
		if (worldIn.provider.getDimension() == MoonlightWorldProvider.MoonlightWorldID)
			return 1000F;
		else
			return super.getBlockHardness(blockState, worldIn, pos);
	}
}
