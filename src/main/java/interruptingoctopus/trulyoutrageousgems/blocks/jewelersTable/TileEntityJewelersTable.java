package interruptingoctopus.trulyoutrageousgems.blocks.jewelersTable;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.tileentity.TileEntityChest;
import net.minecraft.util.EnumFacing;
import net.minecraftforge.common.capabilities.Capability;
import net.minecraftforge.items.CapabilityItemHandler;
import net.minecraftforge.items.ItemStackHandler;

public class TileEntityJewelersTable extends TileEntity{
	
	// Determines if the check for adjacent chests has taken place
	public boolean jeweleryBoxChecked;
	// Contains the chest tile located adjacent to this one (if any)
	public TileEntityChest adjacentJeweleryBoxYPos;
	
	public static final int SIZE = 27;
	
	private ItemStackHandler inv = new ItemStackHandler(SIZE) {
		@Override
		protected void onContentsChanged(int slot) {
			TileEntityJewelersTable.this.markDirty();
		}
	};
	
	@Override
	public void readFromNBT(NBTTagCompound compound) {
		super.readFromNBT(compound);
		if (compound.hasKey("items")) {
			inv.deserializeNBT((NBTTagCompound) compound.getTag("items"));
		}
	}
	
	@Override
	public NBTTagCompound writeToNBT(NBTTagCompound compound) {
		super.writeToNBT(compound);
		compound.setTag("items", inv.serializeNBT());
		return compound;
	}

	/*public TileEntityJewelersTable(BlockJewelersTable type) {
		this.cachedChestType = type;
		}
	*/

	public boolean canInteractWith(EntityPlayer player) {
		return !isInvalid() && player.getDistanceSq(pos.add(0.5D, 0.5D, 0.5D)) <= 64D;
	}
	
	@Override
	public boolean hasCapability(Capability<?> cap, EnumFacing facing) {
		if (cap == CapabilityItemHandler.ITEM_HANDLER_CAPABILITY) return true;
		return super.hasCapability(cap, facing);
	}
	
	@Override
	public <T> T getCapability(Capability<T> cap, EnumFacing facing) {
		if (cap == CapabilityItemHandler.ITEM_HANDLER_CAPABILITY) return CapabilityItemHandler.ITEM_HANDLER_CAPABILITY.cast(inv);
		return super.getCapability(cap, facing);
	}
	
}
