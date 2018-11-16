package com.steelfeathers.dimensions.items;

import com.steelfeathers.dimensions.blocks.hive.HoneycombBlock;

import net.minecraft.block.Block;
import net.minecraft.item.ItemBlock;
import net.minecraft.item.ItemStack;
import net.minecraftforge.fml.relauncher.Side;

public class ItemBlockHoneycomb extends ItemBlock {

	public ItemBlockHoneycomb(Block block) {
		super(block);
		
		this.setHasSubtypes(true);
		this.setMaxDamage(0);
		this.setRegistryName(block.getRegistryName());
	}
//	
//	@Override
//	public int getMetadata(int damage)
//	{
//		return damage;
//	}
//	
//	@Override
//	public String getUnlocalizedName(ItemStack stack)
//	{
//		String name = HoneycombBlock.EnumType.values()[stack.getItemDamage()].getName();
//		return super.getUnlocalizedName() + "_" + name;
//	}

}
