package interruptingoctopus.trulyoutrageousgems.blocks.jewelersTable;

import interruptingoctopus.trulyoutrageousgems.init.ModItems;
import net.minecraft.init.Items;
import net.minecraft.item.ItemStack;
import net.minecraftforge.items.IItemHandler;
import net.minecraftforge.items.SlotItemHandler;

public class SlotJew extends SlotItemHandler{
	
	public SlotJew(IItemHandler itemHandler, int index, int x, int y) {
		super(itemHandler, index, x, y);
	}
	
	@Override
	public boolean isItemValid(ItemStack stack) {
		return (stack.getItem() == ModItems.gem) | (stack.getItem() == Items.DIAMOND) | (stack.getItem() == Items.EMERALD) | (stack.getItem() == Items.QUARTZ) | (stack.getItem() == Items.PRISMARINE_CRYSTALS) | (stack.getItem() == Items.NETHER_STAR) | (stack.getItem() == Items.ENDER_PEARL);
	}
}
