package com.steelfeathers.dimensions.blocks.hive;

import java.util.Random;

import javax.annotation.Nullable;

import com.steelfeathers.dimensions.Dimensions;
import com.steelfeathers.dimensions.blocks.BlockBase;
import com.steelfeathers.dimensions.init.ModBlocks;
import com.steelfeathers.dimensions.init.ModItems;
import com.steelfeathers.dimensions.items.ItemBlockHoneycomb;

import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;
import net.minecraft.block.properties.IProperty;
import net.minecraft.block.properties.PropertyEnum;
import net.minecraft.block.state.BlockStateContainer;
import net.minecraft.block.state.IBlockState;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.enchantment.EnchantmentHelper;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Blocks;
import net.minecraft.init.Enchantments;
import net.minecraft.item.Item;
import net.minecraft.item.ItemBlock;
import net.minecraft.item.ItemMultiTexture;
import net.minecraft.item.ItemStack;
import net.minecraft.stats.StatList;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.IStringSerializable;
import net.minecraft.util.NonNullList;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.MathHelper;
import net.minecraft.world.World;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;
import scala.Console;

public class HoneycombBlock extends BlockBase {
	
//	public static final PropertyEnum<HoneycombBlock.EnumType> VARIANT = PropertyEnum.<HoneycombBlock.EnumType>create("variant", HoneycombBlock.EnumType.class);

	public HoneycombBlock(String name) {
		super(name, Material.ROCK);
		
		this.setHardness(1.25f);
		this.setResistance(15f);
		this.setSoundType(SoundType.STONE);
		
//		this.setDefaultState(this.blockState.getBaseState().withProperty(VARIANT, EnumType.EMPTY));
	}
	
	@Override
	public Item getItemDropped(IBlockState state, Random rand, int fortune)
    {
        if (this == ModBlocks.HONEYCOMB_BLOCK || this == ModBlocks.HONEYCOMB_DARK_BLOCK)
        	return ModItems.HONEYCOMB;
        else if (this == ModBlocks.HONEYCOMB_EGG_BLOCK)
        	return ModItems.EGG_BEE;
        else if (this == ModBlocks.HONEYCOMB_EGG_QUEEN_BLOCK)
        	return ModItems.EGG_BEE_QUEEN;
        else
        	return Item.getItemFromBlock(this);
        			
    }
	
	@Override
	public int quantityDropped(Random random)
	{
		if (this == ModBlocks.HONEYCOMB_BLOCK)
			return 1 + random.nextInt(3);
		else if (this == ModBlocks.HONEYCOMB_DARK_BLOCK)
			return random.nextInt(2);
		else if (this == ModBlocks.HONEYCOMB_EGG_BLOCK || this == ModBlocks.HONEYCOMB_EGG_QUEEN_BLOCK)
			return 1;
		else
			return 0;
	}
	
	@Override
	public int quantityDroppedWithBonus(int fortune, Random random)
    {
		if (fortune > 0 && Item.getItemFromBlock(this) != this.getItemDropped((IBlockState)this.getBlockState().getValidStates().iterator().next(), random, fortune))
        {
            int i = random.nextInt(fortune + 2) - 1;

            if (i < 0)
            {
                i = 0;
            }

            return this.quantityDropped(random) * (i + 1);
        }
        else
        {
            return this.quantityDropped(random);
        }
    }
	
	@Override
    public int getExpDrop(IBlockState state, net.minecraft.world.IBlockAccess world, BlockPos pos, int fortune)
    {
		Random rand = world instanceof World ? ((World)world).rand : new Random();
        if (this.getItemDropped(state, rand, fortune) != Item.getItemFromBlock(this))
        {
        	int i = 0;
        	
        	if (this == ModBlocks.HONEYCOMB_EGG_BLOCK)
        		i = MathHelper.getInt(rand, 0, 2);
        	else if (this == ModBlocks.HONEYCOMB_EGG_QUEEN_BLOCK)
        		i = MathHelper.getInt(rand, 3, 7);
        	
        	return i;
        }
        
        return 0;
    }
	
	@Override
	public void harvestBlock(World worldIn, EntityPlayer player, BlockPos pos, IBlockState state, @Nullable TileEntity te, ItemStack stack)
    {
        player.addStat(StatList.getBlockStats(this));
        player.addExhaustion(0.005F);

        if (this.canSilkHarvest(worldIn, pos, state, player) && EnchantmentHelper.getEnchantmentLevel(Enchantments.SILK_TOUCH, stack) > 0)
        {
            java.util.List<ItemStack> items = new java.util.ArrayList<ItemStack>();
            items.add(this.getSilkTouchDrop(state));

            net.minecraftforge.event.ForgeEventFactory.fireBlockHarvesting(items, worldIn, pos, state, 0, 1.0f, true, player);
            for (ItemStack is : items)
                spawnAsEntity(worldIn, pos, is);
        }
        else
        {
            if (worldIn.provider.doesWaterVaporize())
            {
                worldIn.setBlockToAir(pos);
                return;
            }

            int i = EnchantmentHelper.getEnchantmentLevel(Enchantments.FORTUNE, stack);
            harvesters.set(player);
            this.dropBlockAsItem(worldIn, pos, state, i);
            harvesters.set(null);
            
            if (this == ModBlocks.HONEYCOMB_FILLED_BLOCK)
            {
            	Material material = worldIn.getBlockState(pos.down()).getMaterial();
            	if (material.blocksMovement() || material.isLiquid())
            	{
            		worldIn.setBlockState(pos, Blocks.FLOWING_WATER.getDefaultState());
            	}
            }
        }
    }
	
	
//	@Override
//	protected void registerItemBlock() 
//	{
//		ItemMultiTexture myItemBlock = new ItemMultiTexture(this, this, new ItemMultiTexture.Mapper() {
//			public String apply(ItemStack stack)
//            {
//                return HoneycombBlock.EnumType.byMetadata(stack.getMetadata()).getUnlocalizedName();
//            }
//		});
//		
//		ModItems.ITEMS.add(myItemBlock.setRegistryName(this.getRegistryName()));
//	}
//	
//	public int damageDropped(IBlockState state)
//    {
//        return ((HoneycombBlock.EnumType)state.getValue(VARIANT)).getMetadata();
//    }
//	
//	@Override
//	@SideOnly(Side.CLIENT)
//	public void getSubBlocks(CreativeTabs itemIn, NonNullList<ItemStack> items)
//    {
//        for (HoneycombBlock.EnumType type : HoneycombBlock.EnumType.values())
//        {
//            items.add(new ItemStack(this, 1, type.getMetadata()));
//        }
//    }
//	
//	public IBlockState getStateFromMeta(int meta)
//    {
//        return this.getDefaultState().withProperty(VARIANT, HoneycombBlock.EnumType.byMetadata(meta));
//    }
//	
//	public int getMetaFromState(IBlockState state)
//    {
//        return ((HoneycombBlock.EnumType)state.getValue(VARIANT)).getMetadata();
//    }
//	
//	protected BlockStateContainer createBlockState()
//    {
//        return new BlockStateContainer(this, new IProperty[] {VARIANT});
//    }
//	
//	@Override
//	public void registerModels() 
//	{
//		Main.proxy.registerItemRenderer(Item.getItemFromBlock(this), HoneycombBlock.EnumType.EMPTY.getMetadata(), "", "inventory");
//		Main.proxy.registerItemRenderer(Item.getItemFromBlock(this), HoneycombBlock.EnumType.FILLED.getMetadata(), "_" + HoneycombBlock.EnumType.FILLED.name, "inventory");
//		Main.proxy.registerItemRenderer(Item.getItemFromBlock(this), HoneycombBlock.EnumType.EGG.getMetadata(), "_" + HoneycombBlock.EnumType.EGG.name, "inventory");
//		Main.proxy.registerItemRenderer(Item.getItemFromBlock(this), HoneycombBlock.EnumType.EGG_QUEEN.getMetadata(), "_" + HoneycombBlock.EnumType.EGG_QUEEN.name, "inventory");
//	}
//	
//	public static enum EnumType implements IStringSerializable
//	{
//		EMPTY(0, "empty"),
//		FILLED(1, "filled"),
//		EGG(2, "egg"),
//		EGG_QUEEN(3, "egg_queen");
//		
//		private final int meta;
//	    private final String name;
//		private static final EnumType[] META_LOOKUP = new EnumType[values().length];
//		
//		private EnumType(int meta, String name)
//	    {
//	    	this.meta = meta;
//	    	this.name = name;
//	    }
//		
//		public int getMetadata()
//		{
//	        return this.meta;
//	    }
//
//	    @Override
//	    public String toString()
//	    {
//	        return this.name;
//	    }
//
//	    public static EnumType byMetadata(int meta)
//	    {
//	    	  if (meta < 0 || meta >= META_LOOKUP.length)
//	          {
//	    		  meta = 0;
//	          }
//
//	    	  return META_LOOKUP[meta];
//	    }
//
//	    public String getUnlocalizedName()
//	    {
//	    	return this.name;
//	    }
//	      
//	    
//	    static
//	    {
//	    	for (EnumType type : values()) 
//	    	{
//	    		META_LOOKUP[type.getMetadata()] = type;
//	    	}
//	    }
//
//		@Override
//		public String getName() {
//			return this.name;
//		}
//		
//	}

}
