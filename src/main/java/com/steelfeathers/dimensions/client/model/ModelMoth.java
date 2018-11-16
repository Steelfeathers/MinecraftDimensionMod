package com.steelfeathers.dimensions.client.model;

import net.minecraft.client.model.ModelBase;
import net.minecraft.client.model.ModelRenderer;
import net.minecraft.entity.Entity;

public class ModelMoth extends ModelBase {
	
	public ModelRenderer body;
    public ModelRenderer neck;
    public ModelRenderer fintop1;
    public ModelRenderer finsideL;
    public ModelRenderer finsideR;
    public ModelRenderer body2;
    public ModelRenderer head;
    public ModelRenderer jaw;
    public ModelRenderer teeth;
    public ModelRenderer body3;
    public ModelRenderer tail1;
    public ModelRenderer fintop2;
    public ModelRenderer tailtop;
    public ModelRenderer tailbottom;

//	private final ModelRenderer body;
//	private final ModelRenderer abdomen;
//	private final ModelRenderer head;
//	private final ModelRenderer wingR1;
//	private final ModelRenderer wingR2;
//	private final ModelRenderer wingL1;
//	private final ModelRenderer wingL2;
//	private final ModelRenderer leg1R;
//	private final ModelRenderer leg2R;
//	private final ModelRenderer leg3R;
//	private final ModelRenderer leg1L;
//	private final ModelRenderer leg2L;
//	private final ModelRenderer leg3L;
//	private final ModelRenderer feelerR;
//	private final ModelRenderer feelerL;
//	private final ModelRenderer feelerR2;
//	private final ModelRenderer feelerL2;
	
	public ModelMoth()
	{
		this.textureWidth = 128;
        this.textureHeight = 64;
        this.neck = new ModelRenderer(this, 0, 0);
        this.neck.setRotationPoint(0.0F, 0.0F, -8.0F);
        this.neck.addBox(-4.5F, -4.5F, -6.0F, 9, 9, 6, 0.0F);
        this.body = new ModelRenderer(this, 0, 0);
        this.body.setRotationPoint(0.0F, 19.0F, 0.0F);
        this.body.addBox(-5.0F, -5.0F, -8.0F, 10, 10, 16, 0.0F);
        this.teeth = new ModelRenderer(this, 0, 0);
        this.teeth.setRotationPoint(0.0F, 0.0F, 0.0F);
        this.teeth.addBox(-3.0F, -2.5F, -5.5F, 6, 1, 6, 0.0F);
        this.fintop2 = new ModelRenderer(this, 0, 0);
        this.fintop2.setRotationPoint(0.0F, -3.0F, 2.6F);
        this.fintop2.addBox(-0.5F, -4.0F, -1.5F, 1, 4, 3, 0.0F);
        this.setRotateAngle(fintop2, -0.9105382707654417F, 0.0F, 0.0F);
        this.finsideR = new ModelRenderer(this, 0, 0);
        this.finsideR.setRotationPoint(-4.0F, 2.0F, -7.0F);
        this.finsideR.addBox(-9.0F, -0.5F, -2.0F, 10, 1, 5, 0.0F);
        this.setRotateAngle(finsideR, 0.0F, 0.27314402793711257F, -0.36425021489121656F);
        this.head = new ModelRenderer(this, 0, 0);
        this.head.setRotationPoint(0.0F, -1.5F, -6.0F);
        this.head.addBox(-4.0F, -2.5F, -8.0F, 8, 5, 10, 0.0F);
        this.body2 = new ModelRenderer(this, 0, 0);
        this.body2.setRotationPoint(0.0F, 0.0F, 6.0F);
        this.body2.addBox(-4.0F, -4.7F, 0.0F, 8, 9, 9, 0.0F);
        this.finsideL = new ModelRenderer(this, 0, 0);
        this.finsideL.setRotationPoint(4.0F, 2.0F, -7.0F);
        this.finsideL.addBox(-1.0F, -0.5F, -2.0F, 10, 1, 5, 0.0F);
        this.setRotateAngle(finsideL, 0.0F, -0.27314402793711257F, 0.36425021489121656F);
        this.fintop1 = new ModelRenderer(this, 0, 0);
        this.fintop1.setRotationPoint(0.0F, -5.2F, -1.0F);
        this.fintop1.addBox(-0.5F, -6.0F, -2.0F, 1, 9, 5, 0.0F);
        this.setRotateAngle(fintop1, -0.6108652381980153F, 0.0F, 0.0F);
        this.jaw = new ModelRenderer(this, 0, 0);
        this.jaw.setRotationPoint(0.0F, 2.5F, -6.0F);
        this.jaw.addBox(-3.5F, -1.5F, -6.0F, 7, 3, 8, 0.0F);
        this.setRotateAngle(jaw, 0.18203784098300857F, 0.0F, 0.0F);
        this.tail1 = new ModelRenderer(this, 0, 0);
        this.tail1.setRotationPoint(0.0F, 0.0F, 8.0F);
        this.tail1.addBox(-2.5F, -4.0F, -1.0F, 5, 6, 6, 0.0F);
        this.body3 = new ModelRenderer(this, 0, 0);
        this.body3.setRotationPoint(0.0F, 0.0F, 8.0F);
        this.body3.addBox(-3.0F, -4.3F, 0.0F, 6, 7, 8, 0.0F);
        this.tailtop = new ModelRenderer(this, 0, 0);
        this.tailtop.setRotationPoint(0.0F, -1.0F, 2.0F);
        this.tailtop.addBox(-0.5F, -2.5F, 0.0F, 1, 5, 11, 0.0F);
        this.setRotateAngle(tailtop, 0.7853981633974483F, 0.0F, 0.0F);
        this.tailbottom = new ModelRenderer(this, 0, 0);
        this.tailbottom.setRotationPoint(0.0F, -0.5F, 3.0F);
        this.tailbottom.addBox(-0.5F, -1.5F, 0.0F, 1, 4, 6, 0.0F);
        this.setRotateAngle(tailbottom, -0.7853981633974483F, 0.0F, 0.0F);
        this.body.addChild(this.neck);
        this.jaw.addChild(this.teeth);
        this.body3.addChild(this.fintop2);
        this.body.addChild(this.finsideR);
        this.neck.addChild(this.head);
        this.body.addChild(this.body2);
        this.body.addChild(this.finsideL);
        this.body.addChild(this.fintop1);
        this.neck.addChild(this.jaw);
        this.body3.addChild(this.tail1);
        this.body2.addChild(this.body3);
        this.tail1.addChild(this.tailtop);
        this.tail1.addChild(this.tailbottom);
		
		
//		this.textureWidth = 64;
//        this.textureHeight = 64;
//        
//        this.body = new ModelRenderer(this, 0, 12);
//        this.body.addBox(-5.0f, -5.0f, -8.0f, 10, 10, 16);
//        this.body.setRotationPoint(0.0f, 0.0f, 0.0f);
//        
//        this.head = new ModelRenderer(this, 0, 0);
//        this.head.addBox(-3.0F, -3.0F, -6.0F, 6, 6, 6);
//        this.head.setRotationPoint(0.0F, -3.0F, -8.0F);
//        this.body.addChild(this.head);
//        
//        this.abdomen = new ModelRenderer(this, 0, 0);
//        this.abdomen.addBox(-0.5F, -5.0F, -0.5F, 1, 5, 1);
//        this.abdomen.setRotationPoint(0.0F, -3.0F, -2.0F);
//        setRotation(this.abdomen, 45.0f, 0.0f, 0.0f);
//        this.head.addChild(this.abdomen);
        
        
//        this.body = new ModelRenderer(this, 0, 8);
//        this.body.addBox(-3.0F, -3.0F, -3.0F, 6, 6, 7);
//        this.body.setRotationPoint(0.0F, 18.0F, 0.0F);
//        setRotation(this.body, 0.0f, 180.0f, 180.0f);
//        
//        this.head = new ModelRenderer(this, 0, 0);
//        this.head.addBox(-2.0f, -2.0f, -2.0f, 4, 4, 4);
//        this.head.setRotationPoint(0.0f, 0.0f, 4.0f);
//        setRotation(this.head, 45.0f, 0.0f, 0.0f);
//        this.body.addChild(this.head);
//        
//        this.feelerR = new ModelRenderer(this, 20, 2);
//        this.feelerR.addBox(-1.0f, 0.0f, 0.0f, 1, 5, 1);
//        this.feelerR.setRotationPoint(-1.0f, 2.0f, -2.0f);
//        setRotation(this.feelerR, 11.0f, 0.0f, 19.0f);
//        this.head.addChild(this.feelerR);
//        
//        this.feelerR2 = new ModelRenderer(this, 16, 2);
//        this.feelerR2.addBox(0.0f, 0.0f, 0.0f, 1, 5, 1);
//        this.feelerR2.setRotationPoint(-1.0f, 5.0f, 0.0f);
//        setRotation(this.feelerR2, 17.0f, 0.0f, -13.0f);
//        this.feelerR.addChild(this.feelerR2);
//        
//        this.feelerL = new ModelRenderer(this, 20, 2);
//        this.feelerL.addBox(0.0f, 0.0f, 0.0f, 1, 5, 1);
//        this.feelerL.setRotationPoint(1.0f, 2.0f, -2.0f);
//        setRotation(this.feelerL, 11.0f, 0.0f, -19.0f);
//        this.head.addChild(this.feelerL);
//        
//        this.feelerL2 = new ModelRenderer(this, 16, 2);
//        this.feelerL2.addBox(-1.0f, 0.0f, 0.0f, 1, 5, 1);
//        this.feelerL2.setRotationPoint(1.0f, 5.0f, 0.0f);
//        setRotation(this.feelerL2, 17.0f, 0.0f, 13.0f);
//        this.feelerL.addChild(this.feelerL2);
//        
//        this.abdomen = new ModelRenderer(this, 26, 0);
//        this.abdomen.addBox(-2.5F, -3.0F, -9.0F, 5, 5, 9);
//        this.abdomen.setRotationPoint(0.0F, 0.0F, -3.0F);
//        this.body.addChild(this.abdomen);
//        
//        this.wingR1 = new ModelRenderer(this, 0, 47);
//        this.wingR1.addBox(-21.0f, 0.0f, -16.0f, 21, 1, 16);
//        this.wingR1.setRotationPoint(-2.0f, 1f, 2f);
//        setRotation(this.wingR1, 0.0f, 29.0f, 0.0f);
//        this.body.addChild(this.wingR1);
//        
//        this.wingR2 = new ModelRenderer(this, 0, 21);
//        this.wingR2.addBox(-19.0f, -0.5f, -22.0f, 19, 1, 22);
//        this.wingR2.setRotationPoint(-2.0f, 1f, -1f);
//        this.body.addChild(this.wingR2);
//        
//        this.wingL1 = new ModelRenderer(this, 0, 47);
//        this.wingL1.addBox(0.0f, 0.0f, -16.0f, 21, 1, 16);
//        this.wingL1.setRotationPoint(2.0f, 1f, 2f);
//        setRotation(this.wingL1, 0.0f, -29.0f, 0.0f);
//        this.body.addChild(this.wingL1);
//        
//        this.wingL2 = new ModelRenderer(this, 0, 21);
//        this.wingL2.addBox(0.0f, -0.5f, -22.0f, 19, 1, 22);
//        this.wingL2.setRotationPoint(2.0f, 1f, -1f);
//        this.body.addChild(this.wingL2);
//        
//        this.leg1L = new ModelRenderer(this, 16, 14);
//        this.leg1L.addBox(-7.5f, -0.5f, -0.5f, 8, 1, 1);
//        this.leg1L.setRotationPoint(3.0f, -2.0f, 3f);
//        setRotation(this.leg1L, 0.0f, 134.0f, -25.0f);
//        this.body.addChild(this.leg1L);
//        
//        this.leg2L = new ModelRenderer(this, 16, 14);
//        this.leg2L.addBox(-7.5f, -0.5f, -0.5f, 8, 1, 1);
//        this.leg2L.setRotationPoint(3.0f, -2.0f, 1f);
//        setRotation(this.leg2L, 0.0f, 165.0f, -25.0f);
//        this.body.addChild(this.leg2L);
//        
//        this.leg3L = new ModelRenderer(this, 16, 14);
//        this.leg3L.addBox(-7.5f, -0.5f, -0.5f, 8, 1, 1);
//        this.leg3L.setRotationPoint(3.0f, -2.0f, -1f);
//        setRotation(this.leg3L, -7.0f, -173.0f, -25.0f);
//        this.body.addChild(this.leg3L);
//        
//        this.leg1R = new ModelRenderer(this, 16, 14);
//        this.leg1R.addBox(-7.5f, -0.5f, -0.5f, 8, 1, 1);
//        this.leg1R.setRotationPoint(-3.0f, -2.0f, 3f);
//        setRotation(this.leg1R, 0.0f, 44.0f, 25.0f);
//        this.body.addChild(this.leg1R);
//        
//        this.leg2R = new ModelRenderer(this, 16, 14);
//        this.leg2R.addBox(-7.5f, -0.5f, -0.5f, 8, 1, 1);
//        this.leg2R.setRotationPoint(-3.0f, -2.0f, 1f);
//        setRotation(this.leg2R, 0.0f, 15.0f, 25.0f);
//        this.body.addChild(this.leg2R);
//        
//        this.leg3R = new ModelRenderer(this, 16, 14);
//        this.leg3R.addBox(-7.5f, -0.5f, -0.5f, 8, 1, 1);
//        this.leg3R.setRotationPoint(-3.0f, -2.0f, -1f);
//        setRotation(this.leg3R, -7.0f, -7.0f, 25.0f);
//        this.body.addChild(this.leg3R);
        
	}
	
	@Override
	public void render(Entity entityIn, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch, float scale)
	{
		this.setRotationAngles(limbSwing, limbSwingAmount, ageInTicks, netHeadYaw, headPitch, scale, entityIn);
		this.body.render(scale);
	}
	
	@Override
	public void setRotationAngles(float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch, float scaleFactor, Entity entityIn)
	{
		
	}
	
	protected void setRotation(ModelRenderer model, float rotX, float rotY, float rotZ)
	{
		model.rotateAngleX = degToRad(rotX);
		model.rotateAngleY = degToRad(rotY);
		model.rotateAngleZ = degToRad(rotZ);
	}
	
	protected float degToRad(float degrees)
	{
		return degrees * (float)Math.PI / 180;
	}
	
	public void setRotateAngle(ModelRenderer modelRenderer, float x, float y, float z) {
        modelRenderer.rotateAngleX = x;
        modelRenderer.rotateAngleY = y;
        modelRenderer.rotateAngleZ = z;
    }
}
