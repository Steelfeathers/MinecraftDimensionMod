package com.steelfeathers.dimensions.blocks;

import com.steelfeathers.dimensions.Dimensions;
import com.steelfeathers.dimensions.init.ModBlocks;
import com.steelfeathers.dimensions.init.ModItems;
import com.steelfeathers.dimensions.util.IHasModel;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.item.Item;
import net.minecraft.item.ItemBlock;

public class BlockBase extends Block implements IHasModel {

	public BlockBase(String name, Material material) 
	{
		super(material);
		setUnlocalizedName(name);
		setRegistryName(name);
		setCreativeTab(Dimensions.myTab);
		
		ModBlocks.BLOCKS.add(this);
		registerItemBlock();
	}
	
	protected void registerItemBlock() 
	{
		ModItems.ITEMS.add(new ItemBlock(this).setRegistryName(this.getRegistryName()));
	}

	@Override
	public void registerModels() 
	{
		Dimensions.proxy.registerItemRenderer(Item.getItemFromBlock(this), 0, "inventory");
	}

	
}
