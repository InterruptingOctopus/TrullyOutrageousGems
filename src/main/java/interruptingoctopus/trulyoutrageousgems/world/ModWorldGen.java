package interruptingoctopus.trulyoutrageousgems.world;

import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.fml.common.registry.GameRegistry;

public class ModWorldGen {

	public static void init() {
		TogemsWorldGenerator generator = TogemsWorldGenerator.instance;
		GameRegistry.registerWorldGenerator(generator, 10);
		MinecraftForge.EVENT_BUS.register(generator);
	}
}
