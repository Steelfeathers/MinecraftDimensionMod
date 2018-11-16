package com.steelfeathers.dimensions;

import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.init.Items;
import net.minecraft.item.ItemStack;

public class MyTab extends CreativeTabs {
	
	public MyTab() {
		super("tab_dimensions");
	}

	@Override
	public ItemStack getTabIconItem() {
		return new ItemStack(Items.APPLE);
	}
	
	
}
