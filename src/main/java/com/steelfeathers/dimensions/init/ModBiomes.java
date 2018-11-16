package com.steelfeathers.dimensions.init;

import java.util.ArrayList;
import java.util.List;

import com.steelfeathers.dimensions.util.Reference;
import com.steelfeathers.dimensions.world.biome.BiomeHive;

import net.minecraft.world.biome.Biome;
import net.minecraftforge.common.BiomeDictionary;
import net.minecraftforge.common.BiomeManager;
import net.minecraftforge.common.BiomeManager.BiomeEntry;
import net.minecraftforge.common.BiomeManager.BiomeType;

public class ModBiomes 
{

	public static final List<Biome> BIOMES = new ArrayList<Biome>();
	
	public static final Biome HIVE = new BiomeHive(ModWorldGen.HIVE_NAME);
	
	public static void initBiomeManagerAndDictionary()
    {
        BiomeManager.addBiome(BiomeType.COOL, new BiomeEntry(HIVE, 10));
        BiomeManager.addSpawnBiome(HIVE);
        BiomeManager.addStrongholdBiome(HIVE);
        BiomeManager.addVillageBiome(HIVE, true);
        BiomeDictionary.addTypes(HIVE, 
                BiomeDictionary.Type.COLD,
                BiomeDictionary.Type.DRY,
                BiomeDictionary.Type.MAGICAL
                );
    }
}
