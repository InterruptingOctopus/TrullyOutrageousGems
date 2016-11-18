package world;

import java.util.Random;

import net.minecraft.block.state.IBlockState;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraft.world.chunk.IChunkGenerator;
import net.minecraft.world.chunk.IChunkProvider;
import net.minecraft.world.gen.feature.WorldGenMinable;
import net.minecraftforge.fml.common.IWorldGenerator;

public class TogemsWorldGenerator implements IWorldGenerator{
	 public static final String RETRO_NAME = "TogemsGen";
	 public static TogemsWorldGenerator instance = new TogemsWorldGenerator();

	@Override
	public void generate(Random random, int chunkX, int chunkZ, World world, IChunkGenerator chunkGenerator,IChunkProvider chunkProvider) 
	{
		generateWorld(random, chunkX, chunkZ, world, true);
	}
	
	public void generateWorld(Random random, int chunkX, int chunkZ, World world, boolean newGen) 
	{
          return;
    }
	
	 public void addOreSpawn(IBlockState block, final IBlockState targetBlock, World world, Random random, int blockXPos, int blockZPos, int minVeinSize, int maxVeinSize, int chancesToSpawn, int minY, int maxY)
	 {
		 WorldGenMinable minable = new WorldGenMinable(block, (minVeinSize - random.nextInt(maxVeinSize - minVeinSize)));
		 for (int i = 0 ; i < chancesToSpawn ; i++) 
		 {
			 int posX = blockXPos + random.nextInt(16);
			 int posY = minY + random.nextInt(maxY - minY);
			 int posZ = blockZPos + random.nextInt(16);
			 minable.generate(world, random, new BlockPos(posX, posY, posZ));
		 }
	 }

}
