package com.steelfeathers.dimensions.init;

import com.steelfeathers.dimensions.client.renderer.entity.RenderTestMob;

import net.minecraft.entity.passive.EntityCow;
import net.minecraftforge.fml.client.registry.RenderingRegistry;

public class ModEntities {

	public static void registerRenders() 
	{
		
		RenderingRegistry.registerEntityRenderingHandler(EntityCow.class, RenderTestMob::new);
		//RenderingRegistry.registerEntityRenderingHandler(EntityEggBee.class, renderFactory);
	}
}
