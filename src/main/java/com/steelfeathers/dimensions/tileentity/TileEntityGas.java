package com.steelfeathers.dimensions.tileentity;

import net.minecraft.util.ITickable;

import com.steelfeathers.dimensions.blocks.GasDispersableBlock;

import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.network.NetworkManager;
import net.minecraft.network.play.server.SPacketUpdateTileEntity;
import net.minecraft.tileentity.TileEntity;
import scala.Console;

public class TileEntityGas extends TileEntity implements ITickable{

	public int lifetime;
	public int spreadtime;
	public int spreadlevel;

	public TileEntityGas()
	{
	}
	
	public TileEntityGas(int lifetime, int spreadtime, int spreadlevel)
	{
		this.lifetime = lifetime;
		this.spreadtime = spreadtime;
		this.spreadlevel = spreadlevel;
		Console.println("lifetime=" + this.lifetime +", spreadtime=" + this.spreadtime + ", spreadlevel=" + this.spreadlevel);
	}
	
	@Override
	public void onLoad() {
		
	}
	
	@Override
    public void readFromNBT(NBTTagCompound compound)
    {
        this.lifetime = compound.getInteger("lifetime");
        this.spreadtime = compound.getInteger("spreadtime");
        this.spreadlevel = compound.getInteger("spreadlevel");
        super.readFromNBT(compound);
    }
	
	@Override
    public NBTTagCompound writeToNBT(NBTTagCompound compound)
    {  
        compound.setInteger("lifetime", this.lifetime);
        compound.setInteger("spreadtime", this.spreadtime);
        compound.setInteger("spreadlevel", this.spreadlevel);
        return super.writeToNBT(compound);
    }
	
	/**
	 * The packet which is used to update the tile entity which holds all of the
	 * tileentities data
	 */
	@Override
	public SPacketUpdateTileEntity getUpdatePacket() {
		NBTTagCompound nbt = new NBTTagCompound();
		this.writeToNBT(nbt);
		int metadata = getBlockMetadata();
		return new SPacketUpdateTileEntity(this.pos, metadata, nbt);
	}

	/**
	 * Reads the nbt when it receives a packet
	 */
	@Override
	public void onDataPacket(NetworkManager net, SPacketUpdateTileEntity pkt) {
		this.readFromNBT(pkt.getNbtCompound());
	}

	/**
	 * Gets the nbt for a new packet
	 */
	@Override
	public NBTTagCompound getUpdateTag() {
		NBTTagCompound nbt = new NBTTagCompound();
		this.writeToNBT(nbt);
		return nbt;
	}

	/**
	 * Handles when you get an update
	 */
	@Override
	public void handleUpdateTag(NBTTagCompound tag) {
		this.readFromNBT(tag);
	}

	/**
	 * Gets the tile entities nbt with all of the data stored in it
	 */
	@Override
	public NBTTagCompound getTileData() 
	{
		NBTTagCompound nbt = new NBTTagCompound();
		this.writeToNBT(nbt);
		return nbt;
	}

	@Override
	public void update() {
		if (this.spreadtime > 0)
		{
			this.spreadtime -= 1;
			this.markDirty();
			if (this.spreadtime <= 0)
			{
				GasDispersableBlock gasBlock = (GasDispersableBlock)this.getBlockType();
				gasBlock.tryDisperse(this.world, this.spreadlevel, this.pos);
				
			}
		}
		
		if (this.lifetime > 0)
		{
			this.lifetime -= 1;
			this.markDirty();
			if (this.lifetime <= 0)
			{
				this.getWorld().setBlockToAir(this.pos);
			}
			
		}
	}
	

	
}
