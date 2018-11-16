package com.steelfeathers.dimensions.blocks;

import java.util.Random;

import com.steelfeathers.dimensions.init.ModBlocks;

import net.minecraft.block.material.Material;
import net.minecraft.block.properties.IProperty;
import net.minecraft.block.properties.PropertyInteger;
import net.minecraft.block.state.BlockStateContainer;
import net.minecraft.block.state.IBlockState;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;

public class SulfurBlock extends BlockBase {

	public SulfurBlock(String name, Material material) {
		super(name, material);
		// this.setDefaultState(this.blockState.getBaseState().withProperty(AGE, Integer.valueOf(0)));
		
		setTickRandomly(true);

	}
	
	public int tickRate(World worldIn)
    {
        return 20;
    }

	public void updateTick(World worldIn, BlockPos pos, IBlockState state, Random rand)
	{
		if (!worldIn.isAreaLoaded(pos, 1)) return; // Forge: prevent growing cactus from loading unloaded chunks with block update
        BlockPos blockpos = pos.up();
        
        if (worldIn.isAirBlock(blockpos))
        {
        	worldIn.setBlockState(blockpos, ModBlocks.SULFUR_GAS_BLOCK.getDefaultState());    
        }

        	
	}

}
