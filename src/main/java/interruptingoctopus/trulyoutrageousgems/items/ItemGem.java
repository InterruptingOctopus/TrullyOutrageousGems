package interruptingoctopus.trulyoutrageousgems.items;

import java.util.List;

import interruptingoctopus.trulyoutrageousgems.Reference;
import interruptingoctopus.trulyoutrageousgems.TrulyOutrageousGems;
import interruptingoctopus.trulyoutrageousgems.handlers.EnumHandler.GemTypes;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ResourceLocation;

public class ItemGem extends Item{
	
	public ItemGem(String unlocalizedName){
		this.setUnlocalizedName(unlocalizedName);
		this.setRegistryName(new ResourceLocation(Reference.MOD_ID, unlocalizedName));
		this.setHasSubtypes(true);
		this.setCreativeTab(TrulyOutrageousGems.CREATIVE_TAB);
	}
	
	@Override
	public int getMetadata(int meta) {
		return meta;
	}
	
	@Override
	public void getSubItems(Item item, CreativeTabs tab, List<ItemStack> Items) {
		for(int i = 0; i < GemTypes.values().length; i++) {
			Items.add(new ItemStack(item, 1, i));
		}
	}
	
	@Override
	public String getUnlocalizedName(ItemStack stack) {
		int meta = stack.getMetadata();
		if (meta < 0 || meta >= GemTypes.values().length) {
			return this.getUnlocalizedName() + "." + GemTypes.GARNET.getName();
		}
		return this.getUnlocalizedName() + "." + GemTypes.values()[meta].getName();
	}

}
