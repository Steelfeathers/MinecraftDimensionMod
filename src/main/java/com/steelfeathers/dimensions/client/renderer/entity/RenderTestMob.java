package com.steelfeathers.dimensions.client.renderer.entity;

import com.steelfeathers.dimensions.client.model.ModelMoth;
import com.steelfeathers.dimensions.util.Reference;

import net.minecraft.client.model.ModelBase;
import net.minecraft.client.model.ModelCow;
import net.minecraft.client.renderer.entity.RenderLiving;
import net.minecraft.client.renderer.entity.RenderManager;
import net.minecraft.entity.passive.EntityCow;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

@SideOnly(Side.CLIENT)
public class RenderTestMob extends RenderLiving<EntityCow>{
	
	private static final ResourceLocation texture = new ResourceLocation(Reference.MOD_ID, "textures/entity/mobs/shark.png");

	public RenderTestMob(RenderManager rendermanagerIn) {
		super(rendermanagerIn, new ModelMoth(), 0.7f);
	}

	@Override
	protected ResourceLocation getEntityTexture(EntityCow entity) {
		return texture;
	}

}
