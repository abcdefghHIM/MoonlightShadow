package com.taotie.moonlightshadow;

import com.taotie.moonlightshadow.common.CommonProxy;

import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.Mod.EventHandler;
import net.minecraftforge.fml.common.Mod.Instance;
import net.minecraftforge.fml.common.SidedProxy;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;

@Mod(modid = MoonLightShadow.MODID, name = MoonLightShadow.NAME, version = MoonLightShadow.VERSION, acceptedMinecraftVersions = "1.12.2")
public class MoonLightShadow {
	public static final String MODID = "moonlightshadow";
	public static final String NAME = "Moonlight Shadow";
	public static final String VERSION = "1.0.0";

	@Instance(MoonLightShadow.MODID)
	public static MoonLightShadow instance;

	@SidedProxy(clientSide = "com.taotie.moonlightshadow.client.ClientProxy", serverSide = "com.taotie.moonlightshadow.common.CommonProxy")
	public static CommonProxy proxy;

	@EventHandler
	public void preInit(FMLPreInitializationEvent event) {
		proxy.preInit(event);
	}

	@EventHandler
	public void init(FMLInitializationEvent event) {
		proxy.init(event);
	}

	@EventHandler
	public void postInit(FMLPostInitializationEvent event) {
		proxy.postInit(event);
	}
}
