package interruptingoctopus.trulyoutrageousgems.items;

import interruptingoctopus.trulyoutrageousgems.blocks.IMetaBlockName;
import net.minecraft.block.Block;
import net.minecraft.item.ItemBlock;
import net.minecraft.item.ItemStack;

public class ItemBlockItem extends ItemBlock{

	public ItemBlockItem(Block block) {
		super(block);
		if (!(block instanceof IMetaBlockName))
			throw new IllegalArgumentException(String.format("The given Block %s is not an instance of IMetaBlockName!", block.getUnlocalizedName()));
		this.setHasSubtypes(true);
		this.setMaxDamage(0);
	}
	
	public int getMetadata(int meta)
    {
        return meta;
    }
	
	@Override
	public String getUnlocalizedName(ItemStack stack) {
		return super.getUnlocalizedName() + "." + ((IMetaBlockName) this.block).getSpecialName(stack);
	}

}
