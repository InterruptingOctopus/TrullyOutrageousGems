package interruptingoctopus.trulyoutrageousgems.blocks;

import java.util.List;

import interruptingoctopus.trulyoutrageousgems.Reference;
import interruptingoctopus.trulyoutrageousgems.TrulyOutrageousGems;
import interruptingoctopus.trulyoutrageousgems.handlers.EnumHandler.GemTypes;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.block.properties.IProperty;
import net.minecraft.block.properties.PropertyEnum;
import net.minecraft.block.state.BlockStateContainer;
import net.minecraft.block.state.IBlockState;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ResourceLocation;

public class BlockGemBlock extends Block implements IMetaBlockName{
	
	public static final PropertyEnum<GemTypes> GEMTYPE = PropertyEnum.create("type", GemTypes.class);

	public BlockGemBlock(String unlocalizedName) {
		super(Material.ROCK);
		this.setUnlocalizedName(unlocalizedName);
		this.setRegistryName(new ResourceLocation(Reference.MOD_ID, unlocalizedName));
		setCreativeTab(TrulyOutrageousGems.CREATIVE_TAB);
		setHardness(5.0F);
		setResistance(20.0F);
		setHarvestLevel("pickaxe", 1);
		setDefaultState(blockState.getBaseState().withProperty(GEMTYPE, GemTypes.GARNET));
	}
	
	@Override
	protected BlockStateContainer createBlockState() {
		return new BlockStateContainer(this, new IProperty[] { GEMTYPE });
	}

	@Override
	public int getMetaFromState(IBlockState state) {
		return ((GemTypes)state.getValue(GEMTYPE)).getMetadata();
	}
	
	@Override
	public IBlockState getStateFromMeta(int meta) {
		return getDefaultState().withProperty(GEMTYPE, GemTypes.values()[meta]);
	}
	
	@Override
	public void getSubBlocks(Item item, CreativeTabs tab, List<ItemStack> Items) {
		for(int i = 0; i < GemTypes.values().length; i++) {
			Items.add(new ItemStack(item, 1, i));
		}
	}

	@Override
	public String getSpecialName(ItemStack stack) {
		return GemTypes.values()[stack.getItemDamage()].getName();
	}
	
}
