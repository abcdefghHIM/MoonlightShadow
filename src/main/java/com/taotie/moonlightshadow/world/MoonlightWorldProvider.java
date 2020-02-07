package com.taotie.moonlightshadow.world;

import com.taotie.moonlightshadow.block.MoonLightPortal;

import net.minecraft.block.Block;
import net.minecraft.util.math.Vec3d;
import net.minecraft.world.DimensionType;
import net.minecraft.world.WorldProvider;
import net.minecraft.world.gen.IChunkGenerator;

public class MoonlightWorldProvider extends WorldProvider {
	public static final int MoonlightWorldID = 55;
	public static final Block portal = new MoonLightPortal();

	public MoonlightWorldProvider() {
	}

	@Override
	public DimensionType getDimensionType() {
		return WorldLoader.MoonlightWorld;
	}

	@Override
	public IChunkGenerator createChunkGenerator() {
		return new MoonlightChunkGenerator(world);
	}

	@Override
	public boolean canRespawnHere() {
		return true;
	}

	@Override
	public void setWorldTime(long time) {
		world.getWorldInfo().setWorldTime(time / 2);
	}

	@Override
	public long getWorldTime() {
		return world.getWorldInfo().getWorldTime() * 2;
	}

	@Override
	public boolean isSurfaceWorld() {
		return true;
	}

	@Override
	public Vec3d getSkyColor(net.minecraft.entity.Entity cameraEntity, float partialTicks) {
		return new Vec3d(254 / 255f, 50 / 255f, 172 / 255f);
	}

}
