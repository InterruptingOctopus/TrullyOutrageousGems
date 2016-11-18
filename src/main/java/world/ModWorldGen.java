package world;

import java.util.Random;

import interruptingoctopus.trulyoutrageousgems.blocks.BlockGarnetOre;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraft.world.chunk.IChunkGenerator;
import net.minecraft.world.chunk.IChunkProvider;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.fml.common.IWorldGenerator;
import net.minecraftforge.fml.common.registry.GameRegistry;

public class ModWorldGen {
	
	  public static void init() {
	        GameRegistry.registerWorldGenerator(TogemsWorldGenerator.instance, 10);
	        MinecraftForge.EVENT_BUS.register(TogemsWorldGenerator.instance);
	    }
	}
