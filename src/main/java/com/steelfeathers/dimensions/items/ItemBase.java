package com.steelfeathers.dimensions.items;

import com.steelfeathers.dimensions.Dimensions;
import com.steelfeathers.dimensions.init.ModItems;
import com.steelfeathers.dimensions.util.IHasModel;

import net.minecraft.item.Item;

public class ItemBase extends Item implements IHasModel {

	public ItemBase(String name)
	{
		setUnlocalizedName(name);
		setRegistryName(name);
		setCreativeTab(Dimensions.myTab);
		
		ModItems.ITEMS.add(this);
	}

	@Override
	public void registerModels() {
		
		Dimensions.proxy.registerItemRenderer(this, 0, "inventory");
		
	}
	

}
