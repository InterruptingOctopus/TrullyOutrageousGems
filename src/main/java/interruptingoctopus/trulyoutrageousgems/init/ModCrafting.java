package interruptingoctopus.trulyoutrageousgems.init;

import net.minecraft.init.Blocks;
import net.minecraft.item.ItemStack;
import net.minecraftforge.fml.common.registry.GameRegistry;

public class ModCrafting {

	public static void register(){
		/*//garnet
		GameRegistry.addShapedRecipe(new ItemStack(ModBlocks.gemBlock, 1, 0), "GGG","GGG","GGG", 'G', new ItemStack(ModItems.gem, 1, 0));
		GameRegistry.addShapelessRecipe(new ItemStack(ModItems.gem, 9, 0), ModBlocks.gemBlock, 1, 0);
		GameRegistry.addSmelting(ModBlocks.garnetOre, new ItemStack(ModItems.gem, 1, 0), 1F);
		//amethyst
		GameRegistry.addShapedRecipe(new ItemStack(ModBlocks.gemBlock, 1, 1), "GGG","GGG","GGG", 'G', new ItemStack(ModItems.gem, 1, 1));
		GameRegistry.addShapelessRecipe(new ItemStack(ModItems.gem, 9, 1), ModBlocks.gemBlock, 1, 1);
		GameRegistry.addSmelting(ModBlocks.amethystOre, new ItemStack(ModItems.gem, 1, 1), 1F);
		//pearl
		GameRegistry.addShapedRecipe(new ItemStack(ModBlocks.gemBlock, 1, 2), "GGG","GGG","GGG", 'G', new ItemStack(ModItems.gem, 1, 2));
		GameRegistry.addShapelessRecipe(new ItemStack(ModItems.gem, 9, 2), ModBlocks.gemBlock, 1, 2);*/
		//benches
		GameRegistry.addShapedRecipe(new ItemStack(ModBlocks.jewelersTable), " S ","LCL","LPL", 'S', Blocks.STONE_SLAB,'L', Blocks.LOG, 'C', Blocks.CHEST,'P', Blocks.WOODEN_SLAB);
	}
}
