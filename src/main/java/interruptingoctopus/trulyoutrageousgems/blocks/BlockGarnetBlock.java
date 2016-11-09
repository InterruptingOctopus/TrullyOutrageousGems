package interruptingoctopus.trulyoutrageousgems.blocks;

import interruptingoctopus.trulyoutrageousgems.Reference;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;

public class BlockGarnetBlock extends Block {

	public BlockGarnetBlock() {
		super(Material.ROCK);
		setUnlocalizedName(Reference.TogemsBlocks.GARNETBLOCK.getUnlocalizedName());
		setRegistryName(Reference.TogemsBlocks.GARNETBLOCK.getRegistryName());
		}

}
