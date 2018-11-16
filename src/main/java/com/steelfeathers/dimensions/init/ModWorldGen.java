package com.steelfeathers.dimensions.init;

import javax.annotation.Nullable;

import com.steelfeathers.dimensions.world.WorldProviderHive;
import com.steelfeathers.dimensions.world.gen.WorldTypeHive;

import net.minecraft.world.DimensionType;
import net.minecraft.world.WorldType;
import net.minecraftforge.common.DimensionManager;
import net.minecraftforge.fml.common.registry.GameRegistry;
import net.minecraftforge.fml.common.registry.VillagerRegistry.IVillageCreationHandler;

public class ModWorldGen {
	
	
	@Nullable
    private static Integer findFreeDimensionID()
    {
        for (int i=2; i<Integer.MAX_VALUE; i++)
        {
            if (!DimensionManager.isDimensionRegistered(i))
            {
                // DEBUG
                System.out.println("Found free dimension ID = "+i);
                return i;
            }
        }
        
        // DEBUG
        System.out.println("ERROR: Could not find free dimension ID");
        return null;
    }
	
	
	 public static final String HIVE_NAME = "hive";
	 public static final int HIVE_DIM_ID = findFreeDimensionID();
	 public static final DimensionType HIVE_DIM_TYPE = DimensionType.register(HIVE_NAME, "_"+ HIVE_NAME, HIVE_DIM_ID, WorldProviderHive.class, true);
	 public static final WorldType HIVE_WORLD_TYPE = new WorldTypeHive(); // although instance isn't used, must create the instance to register the WorldType
	 //public static final IVillageCreationHandler HIVE_VILLAGE_HANDLER = new VillageHouseCloudCreationHandler();
	    
	 public static final void registerDimensions()
	 {
		 DimensionManager.registerDimension(HIVE_DIM_ID, HIVE_DIM_TYPE);
	 }
	 
	 public static void registerWorldGenerators()
	 {
	  
		 System.out.println("Registering world generators");
	    // GameRegistry.registerWorldGenerator(new WorldGenShrine(), 10);
	        
	 }

}
