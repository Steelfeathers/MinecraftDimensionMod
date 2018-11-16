package com.steelfeathers.dimensions.world.biome;

import com.steelfeathers.dimensions.init.ModBiomes;
import com.steelfeathers.dimensions.init.ModWorldGen;
import com.steelfeathers.dimensions.util.Reference;

import net.minecraft.world.biome.Biome;

public class BiomeBase extends Biome 
{

	public BiomeBase(String name, BiomeProperties properties) {
		super(properties);
		
		this.setRegistryName(Reference.MOD_ID, name);
		
		ModBiomes.BIOMES.add(this);
		
		addBiomeToManagerAndDictionary();
	}
	
	public void addBiomeToManagerAndDictionary() 
	{
		
	}

}
