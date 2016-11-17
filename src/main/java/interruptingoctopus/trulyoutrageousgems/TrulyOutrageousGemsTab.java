package interruptingoctopus.trulyoutrageousgems;

import interruptingoctopus.trulyoutrageousgems.init.ModItems;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;

public class TrulyOutrageousGemsTab extends CreativeTabs{

	public TrulyOutrageousGemsTab(){
		super("tabTrulyOutrageousGems");
	}

	@Override
	public Item getTabIconItem() {
		return ModItems.gem;
	}
	
	

}
