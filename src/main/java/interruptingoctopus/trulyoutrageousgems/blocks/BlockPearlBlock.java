package interruptingoctopus.trulyoutrageousgems.blocks;

import interruptingoctopus.trulyoutrageousgems.Reference;
import interruptingoctopus.trulyoutrageousgems.TrulyOutrageousGems;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;

public class BlockPearlBlock extends Block {

	public BlockPearlBlock(){
		super(Material.ROCK);
		setUnlocalizedName(Reference.TogemsBlocks.PEARLBLOCK.getUnlocalizedName());
		setRegistryName(Reference.TogemsBlocks.PEARLBLOCK.getRegistryName());
		setCreativeTab(TrulyOutrageousGems.CREATIVE_TAB);
		setHardness(5.0F);
		setResistance(20.0F);
		setHarvestLevel("pickaxe", 1);
		}

}
