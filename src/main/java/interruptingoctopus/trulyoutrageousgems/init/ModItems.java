package interruptingoctopus.trulyoutrageousgems.init;

import interruptingoctopus.trulyoutrageousgems.handlers.EnumHandler;
import interruptingoctopus.trulyoutrageousgems.items.ItemGem;
import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.block.model.ModelResourceLocation;
import net.minecraft.item.Item;
import net.minecraftforge.fml.common.registry.GameRegistry;

public class ModItems {
	
	public static Item gem;

	public static void init() {
		gem = new ItemGem("gem");
	}
	
	public static void register() {
		GameRegistry.register(gem);
	}
	
	public static void registerRenders() {
		for (int i = 0; i < EnumHandler.GemTypes.values().length; i++) {
			String itemModelName = "gem_" + EnumHandler.GemTypes.values()[i].getName();
			registerRender(gem, i, itemModelName);
		}
	}
	
	private static void registerRender(Item item, int meta, String fileName) {
		System.out.println(item.getRegistryName());
		Minecraft.getMinecraft().getRenderItem().getItemModelMesher().register(item, meta, new ModelResourceLocation("togems:" + fileName, "inventory"));

	}
}