package interruptingoctopus.trulyoutrageousgems.blocks;

import interruptingoctopus.trulyoutrageousgems.Reference;
import interruptingoctopus.trulyoutrageousgems.TrulyOutrageousGems;
import interruptingoctopus.trulyoutrageousgems.init.ModItems;
import interruptingoctopus.trulyoutrageousgems.tileentity.TileEntityJewelersTable;
import net.minecraft.block.Block;
import net.minecraft.block.BlockPistonBase;
import net.minecraft.block.ITileEntityProvider;
import net.minecraft.block.material.Material;
import net.minecraft.block.properties.IProperty;
import net.minecraft.block.properties.PropertyDirection;
import net.minecraft.block.state.BlockStateContainer;
import net.minecraft.block.state.IBlockState;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.BlockRenderLayer;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.EnumHand;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;

public class BlockJewelersTable extends Block implements ITileEntityProvider{
	
	public static final PropertyDirection FACING = PropertyDirection.create("facing");

	public BlockJewelersTable() {
		super(Material.WOOD);
		setUnlocalizedName(Reference.TogemsBlocks.JEWELERSTABLE.getUnlocalizedName());
		setRegistryName(Reference.TogemsBlocks.JEWELERSTABLE.getRegistryName());
		setCreativeTab(TrulyOutrageousGems.CREATIVE_TAB);
		setHardness(3.0F);
		setResistance(10.0F);
		setHarvestLevel("axe", 0);
		setDefaultState(blockState.getBaseState().withProperty(FACING, EnumFacing.NORTH));
		}
	
	//rotation properties
	
		@Override
		protected BlockStateContainer createBlockState() {
			return new BlockStateContainer(this, new IProperty[] {FACING});
		};
		
		@Override
		public IBlockState onBlockPlaced(World worldIn, BlockPos pos, EnumFacing facing, float hitX, float hitY, float hitZ,
				int meta, EntityLivingBase placer) {
			return super.onBlockPlaced(worldIn, pos, BlockPistonBase.getFacingFromEntity(pos, placer), hitX, hitY, hitZ, meta, placer);
		}
		
		@Override
		public void onBlockPlacedBy(World worldIn, BlockPos pos, IBlockState state, EntityLivingBase placer,
				ItemStack stack) {
			worldIn.setBlockState(pos, state.withProperty(FACING, BlockPistonBase.getFacingFromEntity(pos, placer)), 2);
		}
		
		@Override
		public int getMetaFromState(IBlockState state) {
			return state.getValue(FACING).getIndex();
		}
	
	//block properties
	
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
	
	//tile entity properties
	
	@Override
	public boolean onBlockActivated(World worldIn, BlockPos pos, IBlockState state, EntityPlayer playerIn, EnumHand hand, ItemStack heldItem, EnumFacing side, float hitX, float hitY, float hitZ) {
		if(!worldIn.isRemote){
			TileEntity tileEntity = worldIn.getTileEntity(pos);
			if(tileEntity instanceof TileEntityJewelersTable) {
				TileEntityJewelersTable jewelersTable = (TileEntityJewelersTable) tileEntity;
				if(heldItem != null){
					if(heldItem.getItem() == ModItems.garnet){
						if(jewelersTable.addGarnet()){
							heldItem.stackSize--;
							return true;
						}
					}
				}
				jewelersTable.removeGarnet();
			}
		}
		return true;
	}

	@Override
	public TileEntity createNewTileEntity(World worldIn, int meta) {
		return new TileEntityJewelersTable();
	}
	
}
