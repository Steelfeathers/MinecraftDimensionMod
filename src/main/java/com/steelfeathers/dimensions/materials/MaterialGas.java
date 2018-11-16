package com.steelfeathers.dimensions.materials;

import net.minecraft.block.material.MapColor;
import net.minecraft.block.material.MaterialTransparent;

public class MaterialGas extends MaterialTransparent {

	public MaterialGas(MapColor color) {
		super(color);
		
		this.setNoPushMobility();
	}

}
