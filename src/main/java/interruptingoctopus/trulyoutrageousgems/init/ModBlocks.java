package interruptingoctopus.trulyoutrageousgems.init;

import interruptingoctopus.trulyoutrageousgems.blocks.BlockGarnetBlock;
import interruptingoctopus.trulyoutrageousgems.blocks.BlockGarnetOre;
import interruptingoctopus.trulyoutrageousgems.items.ItemGarnet;
import net.minecraft.block.Block;
import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.block.model.ModelResourceLocation;
import net.minecraft.item.Item;
import net.minecraft.item.ItemBlock;
import net.minecraftforge.fml.common.registry.GameRegistry;

public class ModBlocks {
	
	public static Block garnetBlock;
	public static Block garnetOre;

	public static void init() {
		garnetBlock = new BlockGarnetBlock();
		garnetOre = new BlockGarnetOre();
		
	}
	
	public static void register() {
		registerBlock(garnetBlock);
		registerBlock(garnetOre);
	}
	
	private static void registerBlock(Block block){
		GameRegistry.register(block);
		ItemBlock item = new ItemBlock(block);
		item.setRegistryName(block.getRegistryName());
		GameRegistry.register(item);
	}
	
	public static void registerRenders() {
		registerRender(garnetBlock);
		registerRender(garnetOre);
	}
	
	private static void registerRender(Block block) {
		System.out.println(block.getRegistryName());
		Minecraft.getMinecraft().getRenderItem().getItemModelMesher().register(Item.getItemFromBlock(block), 0, new ModelResourceLocation(block.getRegistryName(), "inventory"));

	}
}
