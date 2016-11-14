package interruptingoctopus.trulyoutrageousgems.blocks;

import interruptingoctopus.trulyoutrageousgems.Reference;
import interruptingoctopus.trulyoutrageousgems.TrulyOutrageousGems;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.block.state.IBlockState;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.util.BlockRenderLayer;

public class BlockJewelersTable extends Block {

	public BlockJewelersTable() {
		super(Material.WOOD);
		setUnlocalizedName(Reference.TogemsBlocks.JEWELERSTABLE.getUnlocalizedName());
		setRegistryName(Reference.TogemsBlocks.JEWELERSTABLE.getRegistryName());
		setCreativeTab(TrulyOutrageousGems.CREATIVE_TAB);
		setHardness(5.0F);
		setResistance(20.0F);
		setHarvestLevel("axe", 0);
		}
	
	@Override
	public boolean isFullCube(IBlockState state) {
		return false;
	}
	
	@Override
	public boolean isOpaqueCube(IBlockState state) {
		return false;
	}
	/**
	@Override
		public BlockRenderLayer getBlockLayer() {
			return BlockRenderLayer.TRANSLUCENT;
		}
	*/
	
}
