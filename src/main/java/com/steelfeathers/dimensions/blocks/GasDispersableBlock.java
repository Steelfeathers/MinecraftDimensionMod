package com.steelfeathers.dimensions.blocks;

import java.util.Random;

import javax.annotation.Nullable;

import com.steelfeathers.dimensions.init.ModBlocks;
import com.steelfeathers.dimensions.tileentity.TileEntityGas;

import net.minecraft.block.Block;
import net.minecraft.block.ITileEntityProvider;
import net.minecraft.block.material.Material;
import net.minecraft.block.properties.IProperty;
import net.minecraft.block.properties.PropertyBool;
import net.minecraft.block.properties.PropertyInteger;
import net.minecraft.block.state.BlockFaceShape;
import net.minecraft.block.state.BlockStateContainer;
import net.minecraft.block.state.IBlockState;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.init.Blocks;
import net.minecraft.init.MobEffects;
import net.minecraft.item.Item;
import net.minecraft.potion.Potion;
import net.minecraft.potion.PotionEffect;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.BlockRenderLayer;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.math.AxisAlignedBB;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;
import scala.Console;

public class GasDispersableBlock extends GasBlock  implements ITileEntityProvider {
	
	public static final PropertyInteger SPREAD_LEVEL = PropertyInteger.create("spread_level", 0, 5);
	
	protected int max_spread_level = 2;
	protected int spread_ticks = 5;
	protected int disperse_ticks = 100;
	
	public GasDispersableBlock(String name, Material material, Potion effect, int effect_duration) {
		super(name, material, effect, effect_duration);
		this.setDefaultState(this.blockState.getBaseState().withProperty(SPREAD_LEVEL, Integer.valueOf(0)));
		
	}

	
    @Nullable
    private TileEntityGas getTileEntity(World worldIn, BlockPos pos)
    {
        TileEntity tileentity = worldIn.getTileEntity(pos);
        return tileentity instanceof TileEntityGas ? (TileEntityGas)tileentity : null;
    }
    
    @Override
    public boolean hasTileEntity(IBlockState state)
    {
    	return true;
    }
    
    @Override
    public TileEntity createNewTileEntity(World worldIn, int meta)
    {
    	int lifetime = disperse_ticks;
    	int spreadtime = spread_ticks;
    	if (meta > 0)
    	{
    		lifetime -= (meta*3 + worldIn.rand.nextInt(meta*2));
    		spreadtime += (meta*2 + worldIn.rand.nextInt(meta));
    	}
    	
        return new TileEntityGas(lifetime, spreadtime, meta);
    }
    
    public void tryDisperse(World worldIn, int spread, BlockPos pos)
    {
    	if (spread < max_spread_level)
    	{
    		int i1 = 1;
    		Random rand = worldIn.rand;

    		int j = i1 + rand.nextInt(2);
			int k = i1 + rand.nextInt(2);
			int l = i1 + rand.nextInt(2);
			float f = (float)(j + k + l) * 0.333F + 0.5F;

			for (BlockPos blockpos : BlockPos.getAllInBox(pos.add(-j, -k, -l), pos.add(j, k, l)))
			{
				if (blockpos.distanceSq(pos) <= (double)(f*f) && worldIn.isAirBlock(blockpos))
				{
					worldIn.setBlockState(blockpos, this.getDefaultState().withProperty(SPREAD_LEVEL, spread + 1)); 
				}
			}
    			
    	}
    }
	
    public IBlockState getStateFromMeta(int meta)
    {
        return this.getDefaultState().withProperty(SPREAD_LEVEL, Integer.valueOf(meta));
    }

    public int getMetaFromState(IBlockState state)
    {
        return ((Integer)state.getValue(SPREAD_LEVEL)).intValue();
    }

    protected BlockStateContainer createBlockState()
    {
        return new BlockStateContainer(this, new IProperty[] {SPREAD_LEVEL});
    }


	   
}
