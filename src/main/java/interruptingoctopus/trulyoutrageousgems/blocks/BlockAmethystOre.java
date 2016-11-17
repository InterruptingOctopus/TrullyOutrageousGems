package interruptingoctopus.trulyoutrageousgems.blocks;

import java.util.List;
import java.util.Random;

import interruptingoctopus.trulyoutrageousgems.Reference;
import interruptingoctopus.trulyoutrageousgems.TrulyOutrageousGems;
import interruptingoctopus.trulyoutrageousgems.handlers.EnumHandler;
import interruptingoctopus.trulyoutrageousgems.init.ModItems;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.block.properties.PropertyDirection;
import net.minecraft.block.state.BlockStateContainer;
import net.minecraft.block.state.IBlockState;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.item.Item;
// import net.minecraft.util.BlockRenderLayer;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.math.AxisAlignedBB;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;


public class BlockAmethystOre extends Block {
	
	private static final AxisAlignedBB BOUNDING_BOX = new AxisAlignedBB(.1875, 0, .1875, .75, .5625, .75);
	public static final PropertyDirection FACING = PropertyDirection.create("facing");
	protected static final AxisAlignedBB BOUNDING_BOX_EAST_AABB = new AxisAlignedBB(0, .1875, .1875, .5625, .75, .75);
    protected static final AxisAlignedBB BOUNDING_BOX_WEST_AABB = new AxisAlignedBB(.4375, .1875, .1875, 1, .75, .75);
    protected static final AxisAlignedBB BOUNDING_BOX_SOUTH_AABB = new AxisAlignedBB(.1875, .1875, 0, .75, .75, .5625);
    protected static final AxisAlignedBB BOUNDING_BOX_NORTH_AABB = new AxisAlignedBB(.1875, .1875, .4375, .75, .75, 1);
    protected static final AxisAlignedBB BOUNDING_BOX_UP_AABB = BOUNDING_BOX;
    protected static final AxisAlignedBB BOUNDING_BOX_DOWN_AABB = new AxisAlignedBB(.1875, .4375 , .1875, .75, 1, .75);
	
	
	public BlockAmethystOre() {
		super(Material.ROCK);
		setUnlocalizedName(Reference.TogemsBlocks.AMETHYSTORE.getUnlocalizedName());
		setRegistryName(Reference.TogemsBlocks.AMETHYSTORE.getRegistryName());
		setCreativeTab(TrulyOutrageousGems.CREATIVE_TAB);
		setHardness(5.0F);
		setResistance(20.0F);
		setHarvestLevel("pickaxe", 2);
		setDefaultState(blockState.getBaseState().withProperty(FACING, EnumFacing.UP));
	}
	
	//rotation properties
	
	@Override
	protected BlockStateContainer createBlockState() {
		return new BlockStateContainer(this, FACING);
	};
	
	public IBlockState onBlockPlaced(World world, BlockPos pos, EnumFacing facing, float hitX, float hitY, float hitZ, int meta, EntityLivingBase placer) {
		return this.getDefaultState().withProperty(FACING, facing);
	}
	
	@Override
	public IBlockState getStateFromMeta(int meta) {
		return getDefaultState().withProperty(FACING, EnumFacing.getFront(meta));
	}
	
	@Override
	public int getMetaFromState(IBlockState state) {
		return ((EnumFacing)state.getValue(FACING)).getIndex();
	}
	
	//block properties
	
	@Override
	public int damageDropped(IBlockState state) {
		return EnumHandler.GemTypes.AMETHYST.getMetadata();
	}
	
	public Item getItemDropped(IBlockState state, Random rand, int fortune) {
		return ModItems.gem;
	};
	
	@Override
	public boolean isFullCube(IBlockState state) {
		return false;
	}
	
	@Override
	public boolean isOpaqueCube(IBlockState state) {
		return false;
	}
	
/*	@Override
	public BlockRenderLayer getBlockLayer() {
		return BlockRenderLayer.TRANSLUCENT;
	} */
	
	@Override
	public AxisAlignedBB getBoundingBox(IBlockState state, IBlockAccess source, BlockPos pos) {
		switch ((EnumFacing)state.getValue(FACING)) {
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
	
	@Override
	public void addCollisionBoxToList(IBlockState state, World worldIn, BlockPos pos, AxisAlignedBB entityBox, List<AxisAlignedBB> collidingBoxes, Entity entityIn) {
		super.addCollisionBoxToList(pos, entityBox, collidingBoxes, BOUNDING_BOX);
	}
	
}
