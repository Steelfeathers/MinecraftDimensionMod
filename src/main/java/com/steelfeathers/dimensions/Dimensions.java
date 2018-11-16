package com.steelfeathers.dimensions;

import com.steelfeathers.dimensions.init.ModBiomes;
import com.steelfeathers.dimensions.init.ModEntities;
import com.steelfeathers.dimensions.init.ModRecipes;
import com.steelfeathers.dimensions.init.ModTileEntities;
import com.steelfeathers.dimensions.init.ModWorldGen;
import com.steelfeathers.dimensions.proxy.CommonProxy;
import com.steelfeathers.dimensions.util.Reference;

import net.minecraft.creativetab.CreativeTabs;
import net.minecraftforge.common.DimensionManager;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.Mod.EventHandler;
import net.minecraftforge.fml.common.Mod.Instance;
import net.minecraftforge.fml.common.SidedProxy;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;

@Mod(modid = Reference.MOD_ID, name = Reference.NAME, version = Reference.VERSION, acceptedMinecraftVersions = Reference.ACCEPTED_VERSIONS)
public class Dimensions {
	
	public static final CreativeTabs myTab = new MyTab();
	
	@Instance
	public static Dimensions instance;
	
	@SidedProxy(clientSide = Reference.CLIENT_PROXY_CLASS, serverSide = Reference.COMMON_PROXY_CLASS)
	public static CommonProxy proxy;
	
	@EventHandler
	public static void PreInit(FMLPreInitializationEvent event)
	{
		ModTileEntities.register();
		//ModEntities.registerRenders();
		ModWorldGen.registerDimensions();
		
		proxy.registerRenders();
	}
	
	@EventHandler
	public static void Init(FMLInitializationEvent event)
	{
		ModRecipes.register();
		ModWorldGen.registerWorldGenerators();
		ModBiomes.initBiomeManagerAndDictionary();
		
		//MinecraftForge.TERRAIN_GEN_BUS.register(new TerrainGenEventHandler());
		
	}
	
	@EventHandler
	public static void PostInit(FMLPostInitializationEvent event)
	{
		
	}
}
