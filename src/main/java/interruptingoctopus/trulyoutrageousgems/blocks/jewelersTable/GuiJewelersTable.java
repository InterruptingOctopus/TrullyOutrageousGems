package interruptingoctopus.trulyoutrageousgems.blocks.jewelersTable;

import interruptingoctopus.trulyoutrageousgems.Reference;
import net.minecraft.client.gui.inventory.GuiContainer;
import net.minecraft.util.ResourceLocation;

public class GuiJewelersTable extends GuiContainer{
	public static final int WIDTH = 180;
	public static final int HEIGHT = 168;
	
	private static final ResourceLocation background = new ResourceLocation(Reference.MOD_ID, "textures/gui/jewelerstable.png");
	
	public GuiJewelersTable(TileEntityJewelersTable tileEntity, ContainerJewelersTable container) {
		super(container);
		
		xSize = WIDTH;
		ySize = HEIGHT;
	}
	
	@Override
	protected void drawGuiContainerBackgroundLayer(float partialTicks, int mouseX, int mouseY) {
		mc.getTextureManager().bindTexture(background);
		drawTexturedModalRect(guiLeft, guiTop, 0, 0, xSize, ySize);
	}
}
