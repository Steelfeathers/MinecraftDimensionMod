package com.steelfeathers.dimensions.util.handlers;

import com.steelfeathers.dimensions.Dimensions;
import com.steelfeathers.dimensions.entity.projectile.EntityEggBee;
import com.steelfeathers.dimensions.init.ModBiomes;
import com.steelfeathers.dimensions.init.ModBlocks;
import com.steelfeathers.dimensions.init.ModItems;
import com.steelfeathers.dimensions.util.IHasModel;
import com.steelfeathers.dimensions.util.Reference;

import net.minecraft.block.Block;
import net.minecraft.entity.passive.EntityCow;
import net.minecraft.item.Item;
import net.minecraft.util.ResourceLocation;
import net.minecraft.world.biome.Biome;
import net.minecraftforge.client.event.ModelRegistryEvent;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.fml.client.registry.RenderingRegistry;
import net.minecraftforge.fml.common.Mod.EventBusSubscriber;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.fml.common.registry.EntityEntry;
import net.minecraftforge.fml.common.registry.EntityRegistry;

@EventBusSubscriber
public class RegistryHandler {

	@SubscribeEvent
	public static void onItemRegister(RegistryEvent.Register<Item> event)
	{
		event.getRegistry().registerAll(ModItems.ITEMS.toArray(new Item[0]));
	}
	
	@SubscribeEvent
	public static void onBlockRegister(RegistryEvent.Register<Block> event)
	{
		event.getRegistry().registerAll(ModBlocks.BLOCKS.toArray(new Block[0]));
	}
	
	@SubscribeEvent
	public static void onBiomeRegister(RegistryEvent.Register<Biome> event)
	{
		event.getRegistry().registerAll(ModBiomes.BIOMES.toArray(new Biome[0]));
	}
	
	@SubscribeEvent
	public static void onEntityRegister(RegistryEvent.Register<EntityEntry> event)
	{
		EntityRegistry.registerModEntity(new ResourceLocation(Reference.MOD_ID, "custom_cow"), EntityCow.class, "custom_cow", 0, Dimensions.instance, 80, 3, false, 0, 1);
//		EntityRegistry.registerModEntity(
//	            new ResourceLocation(MODID, "trumpet_skeleton"), EntityTrumpetSkeleton.class, "trumpetskeleton.TrumpetSkeleton", 0,
//	            this,
//	            80, 3, false,
//	            0xC1C1C1, 0xFCFC00
//	    );
//	    List<Biome> biomes = ForgeRegistries.BIOMES.getValues();
//	    EntityRegistry.addSpawn(
//	            EntityTrumpetSkeleton.class,
//	            25, 4, 4,
//	            EnumCreatureType.MONSTER,
//	            biomes.toArray(new Biome[biomes.size()])
//	    );
	}
	
	@SubscribeEvent
	public static void onModelRegister(ModelRegistryEvent event)
	{
		for(Item item : ModItems.ITEMS)
		{
			if (item instanceof IHasModel)
			{
				((IHasModel)item).registerModels();
			}
		}
		
		for(Block block : ModBlocks.BLOCKS)
		{
			if (block instanceof IHasModel)
			{
				((IHasModel)block).registerModels();
			}
		}
		
	}
}
