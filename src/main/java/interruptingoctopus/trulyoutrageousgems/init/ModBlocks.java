package interruptingoctopus.trulyoutrageousgems.init;

import interruptingoctopus.trulyoutrageousgems.blocks.BlockGemBlock;
import interruptingoctopus.trulyoutrageousgems.Reference;
import interruptingoctopus.trulyoutrageousgems.blocks.BlockAmethystOre;
import interruptingoctopus.trulyoutrageousgems.blocks.BlockGarnetOre;
import interruptingoctopus.trulyoutrageousgems.blocks.jewelersTable.BlockJewelersTable;
import interruptingoctopus.trulyoutrageousgems.handlers.EnumHandler;
import interruptingoctopus.trulyoutrageousgems.items.ItemBlockItem;
import net.minecraft.block.Block;
import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.block.model.ModelResourceLocation;
import net.minecraft.item.Item;
import net.minecraft.item.ItemBlock;
import net.minecraftforge.fml.common.registry.GameRegistry;

public class ModBlocks {
	
	public static Block gemBlock;
	public static Block garnetOre;
	public static Block amethystOre;
	public static Block jewelersTable;

	public static void init() {
		gemBlock = new BlockGemBlock("gemBlock");
		garnetOre = new BlockGarnetOre();
		amethystOre = new BlockAmethystOre();
		jewelersTable = new BlockJewelersTable();
		
	}
	
	public static void register() {
		registerBlock(gemBlock, new ItemBlockItem(gemBlock));
		registerBlock(garnetOre);
		registerBlock(amethystOre);
		registerBlock(jewelersTable);
	}
	
	private static void registerBlock(Block block, ItemBlock itemBlock) {
		GameRegistry.register(block);
		Item item = itemBlock.setRegistryName(block.getRegistryName());
		GameRegistry.register(item);
	}
	
	private static void registerBlock(Block block){
		GameRegistry.register(block);
		ItemBlock item = new ItemBlock(block);
		item.setRegistryName(block.getRegistryName());
		GameRegistry.register(item);
	}
	
	public static void registerRenders() {
		for (int i = 0; i < EnumHandler.GemTypes.values().length; i++) {
			String itemModelName = "Block" + EnumHandler.GemTypes.values()[i].getName();
			registerRender(gemBlock, i, itemModelName);
		}
		registerRender(garnetOre);
		registerRender(amethystOre);
		registerRender(jewelersTable);
	}
	
	private static void registerRender(Block block) {
		System.out.println(block.getRegistryName());
		Minecraft.getMinecraft().getRenderItem().getItemModelMesher().register(Item.getItemFromBlock(block), 0, new ModelResourceLocation(block.getRegistryName(), "inventory"));
	}
	
	private static void registerRender(Block block, int meta, String fileName) {
		System.out.println(block.getRegistryName());
		Minecraft.getMinecraft().getRenderItem().getItemModelMesher().register(Item.getItemFromBlock(block), meta, new ModelResourceLocation(Reference.MOD_ID + ":" + fileName, "inventory"));
	}
}
