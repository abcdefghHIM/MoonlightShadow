package com.taotie.moonlightshadow.world;

import net.minecraft.entity.Entity;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Blocks;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.Teleporter;
import net.minecraft.world.WorldServer;

public class WorldTeleporter extends Teleporter {
	BlockPos pos;
	WorldServer world;

	public WorldTeleporter(WorldServer worldIn, BlockPos pos) {
		super(worldIn);
		this.pos = pos;
		world = worldIn;
	}

	public void placeInPortal(Entity entityIn, float rotationYaw) {
		if (world.provider.getDimension() != MoonlightWorldProvider.MoonlightWorldID
				&& (entityIn instanceof EntityPlayer)) {
			boolean foundBlock = false;
			net.minecraft.util.math.BlockPos.MutableBlockPos mutableBlockPos = new net.minecraft.util.math.BlockPos.MutableBlockPos(
					pos.getX(), 0, pos.getZ());
			int y = 0;
			do {
				if (y >= 256)
					break;
				mutableBlockPos.setY(y);
				if (world.getBlockState(mutableBlockPos).getBlock() == MoonlightWorldProvider.portal) {
					pos = new BlockPos(pos.getX(), y + 1, pos.getZ());
					foundBlock = true;
					break;
				}
				y++;
			} while (true);
			if (!foundBlock) {
				pos = ((EntityPlayer) entityIn).getBedLocation(world.provider.getDimension());
				if (pos == null)
					pos = world.provider.getRandomizedSpawnPoint();
			}
		}
		if (world.provider.getDimension() == MoonlightWorldProvider.MoonlightWorldID) {
			pos = new BlockPos(pos.getX(), 64, pos.getZ());
			if (world.getBlockState(pos).getBlock() != MoonlightWorldProvider.portal) {
				int color = world.rand.nextInt(15);
				for (int x = -3; x < 4; x++) {
					for (int z = -3; z < 4; z++)
						if (world.isAirBlock(pos.add(x, 0, z)))
							world.setBlockState(pos.add(x, 0, z), Blocks.STAINED_HARDENED_CLAY.getStateFromMeta(color));

				}

				world.setBlockState(pos, MoonlightWorldProvider.portal.getDefaultState());
				EnumFacing aenumfacing[] = EnumFacing.HORIZONTALS;
				int i = aenumfacing.length;
				for (int j = 0; j < i; j++) {
					EnumFacing facing = aenumfacing[j];
					world.setBlockState(pos.up().offset(facing), Blocks.TORCH.getDefaultState());
				}

			}
		}
		entityIn.setLocationAndAngles((double) pos.getX() + 0.5D, (double) pos.getY() + 1.0D,
				(double) pos.getZ() + 0.5D, entityIn.rotationYaw, 0.0F);
		entityIn.motionX = 0.0D;
		entityIn.motionY = 0.0D;
		entityIn.motionZ = 0.0D;
	}

}
