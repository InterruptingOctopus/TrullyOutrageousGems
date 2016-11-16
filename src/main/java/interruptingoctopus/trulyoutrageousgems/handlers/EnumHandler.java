package interruptingoctopus.trulyoutrageousgems.handlers;

import net.minecraft.util.IStringSerializable;

public class EnumHandler {
	
	public static enum GemTypes implements IStringSerializable{
		GARNET("garnet", 0),
		AMETHYST("amethyst", 1),
		PEARL("pearl", 2);
		;
		
		private int ID;
		private String name;
		
		private GemTypes(String name, int ID) {
			this.ID = ID;
			this.name = name;
		}
		
		@Override
		public String getName(){
			return this.name;
		}
		
		public int getID(){
			return ID;
		}
		
		@Override
		public String toString() {
			return getName();
		}
	}

}

