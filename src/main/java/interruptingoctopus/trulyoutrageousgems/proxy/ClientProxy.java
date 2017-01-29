package interruptingoctopus.trulyoutrageousgems.proxy;

import interruptingoctopus.trulyoutrageousgems.Reference;
import interruptingoctopus.trulyoutrageousgems.init.ModBlocks;
import interruptingoctopus.trulyoutrageousgems.init.ModItems;
import net.minecraft.client.renderer.block.model.ModelBakery;
import net.minecraft.item.Item;
import net.minecraft.util.ResourceLocation;

public class ClientProxy implements CommonProxy{

	@Override
	public void init() {
		ModItems.registerRenders();
		ModBlocks.registerRenders();
		ModelBakery.registerItemVariants(ModItems.gem, new ResourceLocation(Reference.MOD_ID, "gem_garnet"), new ResourceLocation(Reference.MOD_ID, "gem_amethyst"), new ResourceLocation(Reference.MOD_ID, "gem_pearl"));
		ModelBakery.registerItemVariants(Item.getItemFromBlock(ModBlocks.gemBlock), new ResourceLocation(Reference.MOD_ID, "block_garnet"), new ResourceLocation(Reference.MOD_ID, "block_amethyst"), new ResourceLocation(Reference.MOD_ID, "block_pearl"));
	}

}
