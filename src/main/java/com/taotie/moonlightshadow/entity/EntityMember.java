package com.taotie.moonlightshadow.entity;

import net.minecraft.entity.Entity;
import net.minecraft.entity.monster.EntityMob;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.world.World;

public class EntityMember extends EntityMob {

	public static int experienceValue;

	public EntityMember(World worldIn) {
		super(worldIn);
	}
}
