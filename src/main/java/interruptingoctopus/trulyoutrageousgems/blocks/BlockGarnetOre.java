package interruptingoctopus.trulyoutrageousgems.blocks;

import interruptingoctopus.trulyoutrageousgems.Reference;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;

public class BlockGarnetOre extends Block {

	public BlockGarnetOre() {
		super(Material.ROCK);
		setUnlocalizedName(Reference.TogemsBlocks.GARNETORE.getUnlocalizedName());
		setRegistryName(Reference.TogemsBlocks.GARNETORE.getRegistryName());
		setHardness(5.0F);
		}

}
