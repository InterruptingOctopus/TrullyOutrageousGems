package interruptingoctopus.trulyoutrageousgems.proxy;

import interruptingoctopus.trulyoutrageousgems.init.ModItems;

public class ClientProxy implements CommonProxy{

	@Override
	public void init() {
		ModItems.registerRenders();
	}

}
