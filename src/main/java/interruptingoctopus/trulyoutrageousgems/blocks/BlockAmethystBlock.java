package interruptingoctopus.trulyoutrageousgems.blocks;

import interruptingoctopus.trulyoutrageousgems.Reference;
import interruptingoctopus.trulyoutrageousgems.TrulyOutrageousGems;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.creativetab.CreativeTabs;

public class BlockAmethystBlock extends Block {

	public BlockAmethystBlock() {
		super(Material.ROCK);
		setUnlocalizedName(Reference.TogemsBlocks.AMETHYSTBLOCK.getUnlocalizedName());
		setRegistryName(Reference.TogemsBlocks.AMETHYSTBLOCK.getRegistryName());
		setCreativeTab(TrulyOutrageousGems.CREATIVE_TAB);
		setHardness(5.0F);
		setResistance(20.0F);
		setHarvestLevel("pickaxe", 1);
		}

}
