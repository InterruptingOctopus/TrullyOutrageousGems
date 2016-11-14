package interruptingoctopus.trulyoutrageousgems.tileentity;

import interruptingoctopus.trulyoutrageousgems.init.ModItems;
import net.minecraft.entity.item.EntityItem;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.tileentity.TileEntity;

public class TileEntityJewelersTable extends TileEntity{
	
	private int garnetCount = 0;
	
	public boolean addGarnet(){
		if(garnetCount < 8){
			garnetCount++;
			return true;
		}
		
		return false;
	}
	
	public void removeGarnet(){
		if(garnetCount > 0) {
			worldObj.spawnEntityInWorld(new EntityItem(worldObj, pos.getX() + 0.5, pos.getY() + 1.0, pos.getZ() + 0.5, new ItemStack(ModItems.garnet)));
			garnetCount--;
		}
	}
	
	
	@Override
	public NBTTagCompound writeToNBT(NBTTagCompound compound) {
		super.writeToNBT(compound);
		compound.setInteger("GarnetCount", this.garnetCount);
		return compound;
	}
	
	@Override
	public void readFromNBT(NBTTagCompound compound) {
		super.readFromNBT(compound);
		this.garnetCount = compound.getInteger("GarnetCount");
	}

}
