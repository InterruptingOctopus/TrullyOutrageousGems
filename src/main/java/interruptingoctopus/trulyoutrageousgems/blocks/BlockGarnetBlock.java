package interruptingoctopus.trulyoutrageousgems.blocks;

import interruptingoctopus.trulyoutrageousgems.Reference;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.creativetab.CreativeTabs;

public class BlockGarnetBlock extends Block {

	public BlockGarnetBlock() {
		super(Material.ROCK);
		setUnlocalizedName(Reference.TogemsBlocks.GARNETBLOCK.getUnlocalizedName());
		setRegistryName(Reference.TogemsBlocks.GARNETBLOCK.getRegistryName());
		setCreativeTab(CreativeTabs.BUILDING_BLOCKS);
		setHardness(5.0F);
		setResistance(20.0F);
		setHarvestLevel("pickaxe", 1);
		}

}
