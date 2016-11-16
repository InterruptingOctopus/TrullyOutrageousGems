package interruptingoctopus.trulyoutrageousgems.tileentity;

import interruptingoctopus.trulyoutrageousgems.blocks.BlockJewelersTable;
import net.minecraft.block.BlockChest;
import net.minecraft.block.BlockContainer;
import net.minecraft.item.ItemStack;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.tileentity.TileEntityChest;

public class TileEntityJewelersTable extends TileEntity{
	private ItemStack[] jeweleryBoxContents = new ItemStack[27];
    /** Determines if the check for adjacent chests has taken place. */
    public boolean jeweleryBoxChecked;
    /** Contains the chest tile located adjacent to this one (if any) */
    public TileEntityChest adjacentJeweleryBoxYPos;
    /** Contains the chest tile located adjacent to this one (if any) */

	/**public TileEntityJewelersTable(BlockJewelersTable typeIn) {
		this.cachedChestType = typeIn;
		}
	*/

/**
 * Returns the number of slots in the inventory.
 */
	public int getSizeInventory() {
		return 27;
		}
}
