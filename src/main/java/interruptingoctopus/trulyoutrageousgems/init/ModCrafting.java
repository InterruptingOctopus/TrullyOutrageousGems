package interruptingoctopus.trulyoutrageousgems.init;

import net.minecraft.item.ItemStack;
import net.minecraftforge.fml.common.registry.GameRegistry;

public class ModCrafting {

	public static void register(){
		GameRegistry.addShapedRecipe(new ItemStack(ModBlocks.garnetBlock), "GGG","GGG","GGG", 'G', ModItems.garnet);
		GameRegistry.addShapelessRecipe(new ItemStack(ModItems.garnet, 9), ModBlocks.garnetBlock);
		GameRegistry.addSmelting(ModBlocks.garnetOre, new ItemStack(ModItems.garnet, 1), 1F);
	}
}
