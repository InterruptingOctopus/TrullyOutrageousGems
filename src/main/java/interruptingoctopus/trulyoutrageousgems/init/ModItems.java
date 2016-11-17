package interruptingoctopus.trulyoutrageousgems.init;

import interruptingoctopus.trulyoutrageousgems.handlers.EnumHandler;
import interruptingoctopus.trulyoutrageousgems.items.ItemGem;
import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.block.model.ModelResourceLocation;
import net.minecraft.item.Item;
import net.minecraftforge.fml.common.registry.GameRegistry;

public class ModItems {
	
	public static Item garnet;
	public static Item gem;

	public static void init() {
		//garnet = new ItemGarnet();
		gem = new ItemGem("gem");
	}
	
	public static void register() {
		//GameRegistry.register(garnet);
		GameRegistry.register(gem);
	}
	
	public static void registerRenders() {
		registerRender(garnet);
		for (int i = 0; i < EnumHandler.GemTypes.values().length; i++) {
			registerRender(gem, i, "gem_" + EnumHandler.GemTypes.values()[i].getName());
		}
	}
	
	private static void registerRender(Item item) {
		System.out.println(item.getRegistryName());
		Minecraft.getMinecraft().getRenderItem().getItemModelMesher().register(item, 0, new ModelResourceLocation(item.getRegistryName(), "inventory"));

	}
	private static void registerRender(Item item, int meta, String fileName) {
		System.out.println(item.getRegistryName());
		Minecraft.getMinecraft().getRenderItem().getItemModelMesher().register(item, meta, new ModelResourceLocation(fileName));

	}
}