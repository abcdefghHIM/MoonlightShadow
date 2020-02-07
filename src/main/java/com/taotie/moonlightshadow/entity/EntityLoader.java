package com.taotie.moonlightshadow.entity;

import com.taotie.moonlightshadow.MoonLightShadow;
import com.taotie.moonlightshadow.entity.member.Entity_KaoGeGuGuGu;

import net.minecraft.entity.Entity;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.fml.common.registry.EntityRegistry;

public class EntityLoader {
	public static int id = 0;

	public EntityLoader() {
		registerModEntity(new ResourceLocation(MoonLightShadow.MODID, "kaogegugugu"), Entity_KaoGeGuGuGu.class,
				"KaoGeGuGuGu", 64, 2, true, 0xffff66, 0x660000);
	}

	public static void registerModEntity(ResourceLocation registryName, Class<? extends Entity> entityClass,
			String entityName, int trackingRange, int updateFrequency, boolean sendsVelocityUpdates, int eggPrimary,
			int eggSecondary) {
		EntityRegistry.registerModEntity(registryName, entityClass, entityName, id++, MoonLightShadow.instance,
				trackingRange, updateFrequency, sendsVelocityUpdates, eggPrimary, eggSecondary);
	}

}
