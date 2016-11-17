package interruptingoctopus.trulyoutrageousgems.blocks.jewelersTable;

import javax.annotation.Nullable;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.inventory.Container;
import net.minecraft.inventory.Slot;
import net.minecraft.inventory.IInventory;
import net.minecraft.item.ItemStack;
import net.minecraftforge.items.CapabilityItemHandler;
import net.minecraftforge.items.IItemHandler;

public class ContainerJewelersTable extends Container {
	
	private TileEntityJewelersTable tileEntity;
	
	public ContainerJewelersTable(IInventory playerInventory, TileEntityJewelersTable tileEntity) {
		this.tileEntity = tileEntity;
		
		addOwnSlots();
		addPlayerSlots(playerInventory);
	}
	
	private void addPlayerSlots(IInventory playerInventory) {
		// Slots for the main inventory
		for (int row = 0; row < 3; ++row) {
			for (int col = 0; col < 9; ++col) {
				int x = 8 + col * 18;
				int y = row * 18 + 84;
				this.addSlotToContainer(new Slot(playerInventory, col + row * 9 + 9, x, y));
			}
		}
		
		// Slots for the hotbar
		for (int row = 0; row < 9; ++row) {
			int x = 8 + row * 18;
			int y = 142;
			this.addSlotToContainer(new Slot(playerInventory, row, x, y));
		}
	}
	
	private void addOwnSlots() {
		IItemHandler itemHandler = this.tileEntity.getCapability(CapabilityItemHandler.ITEM_HANDLER_CAPABILITY, null);
		int slotIndex = 0;
		int x = 8;
		int y = 17;
		for (int row = 0; row < itemHandler.getSlots() / 9; ++row) {
			for (int col = 0; col < 9; ++col) {
				addSlotToContainer(new SlotJew(itemHandler, slotIndex, x, y));
				slotIndex++;
				x += 18;
			}
		y += 18;
		x = 8;
		}
	}
	
	@Nullable
	@Override
	public ItemStack transferStackInSlot(EntityPlayer player, int index) {
		ItemStack itemstack = null;
		Slot slot = this.inventorySlots.get(index);
		
		if (slot != null && slot.getHasStack()) {
			ItemStack sourceStack = slot.getStack();
			itemstack = sourceStack.copy();
			
			if (index < TileEntityJewelersTable.SIZE) {
				if (!this.mergeItemStack(sourceStack, TileEntityJewelersTable.SIZE, this.inventorySlots.size(), true)) {
					return null;
				}
			}else if (!this.mergeItemStack(sourceStack, 0, TileEntityJewelersTable.SIZE, false)) {
				return null;
			}
			
			if (sourceStack.stackSize == 0) {
				slot.putStack(null);
			} else {
				slot.onSlotChanged();
			}
		}
		
		return itemstack;
	}
	
	@Override
	public boolean canInteractWith(EntityPlayer player) {
		return tileEntity.canInteractWith(player);
	}

}
