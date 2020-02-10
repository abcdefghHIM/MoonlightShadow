package com.taotie.moonlightshadow.entity;

import net.minecraft.entity.Entity;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.world.World;

public class EntityMember extends Entity {

	public static int experienceValue;

	public EntityMember(World worldIn) {
		super(worldIn);
	}

	@Override
	protected void entityInit() {
	}

	@Override
	protected void readEntityFromNBT(NBTTagCompound compound) {
	}

	@Override
	protected void writeEntityToNBT(NBTTagCompound compound) {
	}

	@Override
	public void onKillCommand() {
		System.out.println("¹¾¹¾¹¾¹¾¹¾");
	}
}
