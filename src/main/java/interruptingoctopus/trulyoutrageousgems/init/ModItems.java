package interruptingoctopus.trulyoutrageousgems.init;

import interruptingoctopus.trulyoutrageousgems.items.ItemGarnet;

import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.block.model.ModelResourceLocation;
import net.minecraft.item.Item;
import net.minecraftforge.fml.common.registry.GameRegistry;

public class ModItems {
	
	public static Item garnet;

	public static void init() {
		garnet = new ItemGarnet();
	}
	
	public static void register() {
		GameRegistry.register(garnet);
	}
	
	public static void registerRenders() {
		registerRender(garnet);
	}
	
	private static void registerRender(Item item) {
		System.out.println(item.getRegistryName());
<<<<<<< HEAD
		Minecraft.getMinecraft().getRenderItem().getItemModelMesher().register(item, 0, new ModelResourceLocation(Reference.MOD_ID + ":" + item.getUnlocalizedName(), "inventory"));
=======
		Minecraft.getMinecraft().getRenderItem().getItemModelMesher().register(item, 0, new ModelResourceLocation(item.getRegistryName(), "inventory"));
>>>>>>> master
	}
}