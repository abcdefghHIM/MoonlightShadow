package com.taotie.moonlightshadow.entity;

import javax.annotation.Nullable;

import net.minecraft.block.Block;
import net.minecraft.entity.monster.EntityZombie;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.SoundEvents;
import net.minecraft.item.ItemStack;
import net.minecraft.util.DamageSource;
import net.minecraft.util.SoundEvent;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;

public class EntityMember extends EntityZombie {
	public int experienceValue = 10;

	public EntityMember(World worldIn) {
		super(worldIn);
		this.setHealth(20);
	}

	@Override
	public boolean isChild() {
		return false;
	}

	@Override
	protected boolean shouldBurnInDay() {
		return false;
	}

	@Override
	protected int getExperiencePoints(EntityPlayer player) {
		return experienceValue;
	}

	@Override
	public boolean isBreakDoorsTaskSet() {
		return false;
	}

	@Override
	protected SoundEvent getAmbientSound() {
		return SoundEvents.ENTITY_ZOMBIE_AMBIENT;
	}

	@Override
	protected SoundEvent getHurtSound(DamageSource damageSourceIn) {
		return SoundEvents.ENTITY_PLAYER_HURT;
	}

	@Override
	protected SoundEvent getDeathSound() {
		return SoundEvents.ENTITY_PLAYER_DEATH;
	}

	@Override
	protected SoundEvent getStepSound() {
		return SoundEvents.ENTITY_ZOMBIE_STEP;
	}

	@Override
	protected void playStepSound(BlockPos pos, Block blockIn) {
		this.playSound(this.getStepSound(), 0.15F, 1.0F);
	}

	@Override
	protected boolean canEquipItem(ItemStack stack) {
		return true;
	}

	@Override
	public boolean getCanSpawnHere() {
		return false;
	}

	@Override
	protected boolean canDropLoot() {
		return false;
	}

	@Override
	public boolean isPreventingPlayerRest(EntityPlayer playerIn) {
		return false;
	}

	@Override
	public boolean canPickUpLoot() {
		return true;
	}
}
