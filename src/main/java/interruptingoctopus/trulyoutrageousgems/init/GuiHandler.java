package interruptingoctopus.trulyoutrageousgems.init;

import interruptingoctopus.trulyoutrageousgems.TrulyOutrageousGems;
import interruptingoctopus.trulyoutrageousgems.blocks.jewelersTable.GuiJewelersTable;
import interruptingoctopus.trulyoutrageousgems.blocks.jewelersTable.ContainerJewelersTable;
import interruptingoctopus.trulyoutrageousgems.blocks.jewelersTable.TileEntityJewelersTable;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraftforge.fml.common.network.IGuiHandler;
import net.minecraftforge.fml.common.network.NetworkRegistry;

public class GuiHandler implements IGuiHandler{
	
	@Override
	public Object getServerGuiElement(int ID, EntityPlayer player, World world, int x, int y, int z) {
		BlockPos pos = new BlockPos(x, y, z);
		TileEntity tileEntity = world.getTileEntity(pos);
		if (tileEntity instanceof TileEntityJewelersTable) {
			return new ContainerJewelersTable(player.inventory, (TileEntityJewelersTable) tileEntity);
		}
		return null;
	}
	
	@Override
	public Object getClientGuiElement(int ID, EntityPlayer player, World world, int x, int y, int z) {
		BlockPos pos = new BlockPos(x, y, z);
		TileEntity tileEntity = world.getTileEntity(pos);
		if (ID == 1) {
			TileEntityJewelersTable tileEntityJewelersTable = (TileEntityJewelersTable) tileEntity;
			return new GuiJewelersTable(tileEntityJewelersTable, new ContainerJewelersTable(player.inventory, tileEntityJewelersTable));
		}
		return null;
	}
	
	public static void init() {
		NetworkRegistry.INSTANCE.registerGuiHandler(TrulyOutrageousGems.instance, new GuiHandler());
	}
}
