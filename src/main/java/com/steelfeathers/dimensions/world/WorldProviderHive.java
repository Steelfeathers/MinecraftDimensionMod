package com.steelfeathers.dimensions.world;

import com.steelfeathers.dimensions.init.ModWorldGen;

import net.minecraft.util.math.BlockPos;
import net.minecraft.world.DimensionType;
import net.minecraft.world.WorldProvider;
import net.minecraft.world.chunk.Chunk;

public class WorldProviderHive extends WorldProvider {

	@Override
	public DimensionType getDimensionType() 
	{
		return ModWorldGen.HIVE_DIM_TYPE;
	}
	
	@Override
	public boolean isSurfaceWorld()
	{
		return true;
	}
	
	@Override
    public boolean canDoLightning(net.minecraft.world.chunk.Chunk chunk)
    {
        return true;
    }
	
	@Override
    public boolean canDoRainSnowIce(Chunk chunk)
    {
        return false;
    }
	
	@Override
    public boolean canSnowAt(BlockPos pos, boolean checkLight)
    {
        return false; 
    }

}
