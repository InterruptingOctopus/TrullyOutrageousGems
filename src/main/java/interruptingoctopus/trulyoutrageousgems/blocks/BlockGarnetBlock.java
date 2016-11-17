package interruptingoctopus.trulyoutrageousgems.blocks;

import interruptingoctopus.trulyoutrageousgems.Reference;
import interruptingoctopus.trulyoutrageousgems.TrulyOutrageousGems;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;

public class BlockGarnetBlock extends Block {

	public BlockGarnetBlock() {
		super(Material.ROCK);
		setUnlocalizedName(Reference.TogemsBlocks.GARNETBLOCK.getUnlocalizedName());
		setRegistryName(Reference.TogemsBlocks.GARNETBLOCK.getRegistryName());
		setCreativeTab(TrulyOutrageousGems.CREATIVE_TAB);
		setHardness(5.0F);
		setResistance(20.0F);
		setHarvestLevel("pickaxe", 1);
		}

}
