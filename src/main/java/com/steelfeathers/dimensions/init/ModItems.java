package com.steelfeathers.dimensions.init;

import java.util.ArrayList;
import java.util.List;

import com.steelfeathers.dimensions.items.ItemBase;
import com.steelfeathers.dimensions.items.ItemEggBee;
import com.steelfeathers.dimensions.items.ItemEggBeeQueen;

import net.minecraft.item.Item;

public class ModItems {
	
	public static final List<Item> ITEMS = new ArrayList<Item>();
	
	public static final Item RUBY = new ItemBase("ruby");
	public static final Item HONEYCOMB = new ItemBase("honeycomb");
	public static final Item WAX = new ItemBase("wax");
	public static final Item EGG_BEE = new ItemEggBee("egg_bee");
	public static final Item EGG_BEE_QUEEN = new ItemEggBeeQueen("egg_bee_queen");

}
