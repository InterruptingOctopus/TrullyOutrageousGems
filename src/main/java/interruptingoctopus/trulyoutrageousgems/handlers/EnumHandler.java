package interruptingoctopus.trulyoutrageousgems.handlers;

import net.minecraft.util.IStringSerializable;

public class EnumHandler {
	
	public static enum GemTypes implements IStringSerializable{
		GARNET("garnet", 0),
		AMETHYST("amethyst", 1),
		PEARL("pearl", 2);
		
		private String name;
		private int meta;
		
		private GemTypes(String name, int meta) {
			this.meta = meta;
			this.name = name;
		}
		
		public int getMetadata() {
			return this.meta;
		}
		
		@Override
		public String getName() {
			return this.name;
		}
		
		@Override
		public String toString() {
			return getName();
		}
	}

}

