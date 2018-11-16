package com.steelfeathers.dimensions.init;

import com.steelfeathers.dimensions.tileentity.TileEntityGas;
import com.steelfeathers.dimensions.util.Reference;

import net.minecraft.util.ResourceLocation;
import net.minecraftforge.fml.common.registry.GameRegistry;

public class ModTileEntities {


	public static void register() {
		GameRegistry.registerTileEntity(TileEntityGas.class, new ResourceLocation(Reference.MOD_ID + ":gas"));

	}
}
