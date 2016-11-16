package interruptingoctopus.trulyoutrageousgems.blocks;

import java.util.List;

import interruptingoctopus.trulyoutrageousgems.Reference;
import interruptingoctopus.trulyoutrageousgems.TrulyOutrageousGems;
import interruptingoctopus.trulyoutrageousgems.init.ModItems;
import net.minecraft.block.Block;
import net.minecraft.block.BlockPistonBase;
import net.minecraft.block.material.Material;
import net.minecraft.block.properties.IProperty;
import net.minecraft.block.properties.PropertyDirection;
import net.minecraft.block.state.BlockStateContainer;
import net.minecraft.block.state.IBlockState;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.BlockRenderLayer;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.math.AxisAlignedBB;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;


public class BlockGarnetOre extends Block {
	
	private static final AxisAlignedBB BOUNDING_BOX = new AxisAlignedBB(.1875, 0, .1875, .75, .5625, .75);
	public static final PropertyDirection FACING = PropertyDirection.create("facing");
	protected static final AxisAlignedBB BOUNDING_BOX_EAST_AABB = new AxisAlignedBB(0.0D, 0.0D, 0.0D, 0.75D, 1.0D, 1.0D);
    protected static final AxisAlignedBB BOUNDING_BOX_WEST_AABB = new AxisAlignedBB(0.25D, 0.0D, 0.0D, 1.0D, 1.0D, 1.0D);
    protected static final AxisAlignedBB BOUNDING_BOX_SOUTH_AABB = new AxisAlignedBB(0.0D, 0.0D, 0.0D, 1.0D, 1.0D, 0.75D);
    protected static final AxisAlignedBB BOUNDING_BOX_NORTH_AABB = new AxisAlignedBB(0.0D, 0.0D, 0.25D, 1.0D, 1.0D, 1.0D);
    protected static final AxisAlignedBB BOUNDING_BOX_UP_AABB = new AxisAlignedBB(0.0D, 0.0D, 0.0D, 1.0D, 0.75D, 1.0D);
    protected static final AxisAlignedBB BOUNDING_BOX_DOWN_AABB = new AxisAlignedBB(0.0D, 0.25D, 0.0D, 1.0D, 1.0D, 1.0D);
	
	
	public BlockGarnetOre() {
		super(Material.ROCK);
		setUnlocalizedName(Reference.TogemsBlocks.GARNETORE.getUnlocalizedName());
		setRegistryName(Reference.TogemsBlocks.GARNETORE.getRegistryName());
		setCreativeTab(TrulyOutrageousGems.CREATIVE_TAB);
		setHardness(5.0F);
		setResistance(20.0F);
		setHarvestLevel("pickaxe", 2);
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
	
	public int getItemDropped(IBlockState state) {
		return 0;
	};
	
	@Override
	public boolean isFullCube(IBlockState state) {
		return false;
	}
	
	@Override
	public boolean isOpaqueCube(IBlockState state) {
		return false;
	}
	
	//@Override
	//public BlockRenderLayer getBlockLayer() {
		//return BlockRenderLayer.TRANSLUCENT;
	//}
	
	@Override
	public AxisAlignedBB getBoundingBox(IBlockState state, IBlockAccess source, BlockPos pos) {
		if (state.getValue(FACING) != null){
            switch ((EnumFacing)state.getValue(FACING))
            {
                case DOWN:
                    return BOUNDING_BOX_DOWN_AABB;

                case UP:
                default:
                    return BOUNDING_BOX_UP_AABB;

                case NORTH:
                    return BOUNDING_BOX_NORTH_AABB;

                case SOUTH:
                    return BOUNDING_BOX_SOUTH_AABB;

                case WEST:
                    return BOUNDING_BOX_WEST_AABB;

                case EAST:
                    return BOUNDING_BOX_EAST_AABB;
            }
        }
        else
        {
        	return BOUNDING_BOX;
        }
		
	}
	
	@Override
	public void addCollisionBoxToList(IBlockState state, World worldIn, BlockPos pos, AxisAlignedBB entityBox, List<AxisAlignedBB> collidingBoxes, Entity entityIn) {
		super.addCollisionBoxToList(pos, entityBox, collidingBoxes, BOUNDING_BOX);
	}
	
}
