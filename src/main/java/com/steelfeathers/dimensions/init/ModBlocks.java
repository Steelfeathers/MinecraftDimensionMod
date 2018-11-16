package com.steelfeathers.dimensions.init;

import java.util.ArrayList;
import java.util.List;

import com.steelfeathers.dimensions.blocks.BlockBase;
import com.steelfeathers.dimensions.blocks.GasDispersableBlock;
import com.steelfeathers.dimensions.blocks.SulfurBlock;
import com.steelfeathers.dimensions.blocks.hive.HoneycombBlock;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.init.MobEffects;

public class ModBlocks {

	public static final List<Block> BLOCKS = new ArrayList<Block>();
	
	public static final Block RUBY_BLOCK = new BlockBase("ruby_block", Material.IRON);
	public static final Block SULFUR_BLOCK = new SulfurBlock("sulfur_block", Material.ROCK);
	public static final Block SULFUR_GAS_BLOCK = new GasDispersableBlock("sulfur_gas_block", ModMaterials.GAS, MobEffects.NAUSEA, 100);
	
	public static final Block HONEYCOMB_BLOCK = new HoneycombBlock("honeycomb_block"); 
	public static final Block HONEYCOMB_FILLED_BLOCK = new HoneycombBlock("honeycomb_filled_block"); 
	public static final Block HONEYCOMB_DARK_BLOCK = new HoneycombBlock("honeycomb_dark_block"); 
	public static final Block HONEYCOMB_EGG_BLOCK = new HoneycombBlock("honeycomb_egg_block"); 
	public static final Block HONEYCOMB_EGG_QUEEN_BLOCK = new HoneycombBlock("honeycomb_egg_queen_block"); 

}
