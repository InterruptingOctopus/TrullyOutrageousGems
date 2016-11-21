package interruptingoctopus.trulyoutrageousgems.world;

import java.util.Random;

import interruptingoctopus.trulyoutrageousgems.init.ModBlocks;
import net.minecraft.block.state.IBlockState;
import net.minecraft.init.Blocks;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraft.world.chunk.IChunkGenerator;
import net.minecraft.world.chunk.IChunkProvider;
import net.minecraft.world.gen.feature.WorldGenMinable;
import net.minecraftforge.fml.common.IWorldGenerator;

public class TogemsWorldGenerator implements IWorldGenerator {

	public static final String RETRO_NAME = "TogemsGen";
	public static TogemsWorldGenerator instance = new TogemsWorldGenerator();

	@Override
	public void generate(Random random, int chunkX, int chunkZ, World world, IChunkGenerator chunkGenerator,
			IChunkProvider chunkProvider) {
		generateWorld(random, chunkX, chunkZ, world, true);
	}

	public void generateWorld(Random random, int chunkX, int chunkZ, World world, boolean newGen) {
		if (!newGen && !WorldGenConfiguration.retrogen) return;
		
		if (WorldGenConfiguration.gemSpawnChance > 0 && random.nextInt(WorldGenConfiguration.gemSpawnChance) == 0) {
			attemptSpawnGem(random, chunkX, chunkZ, world);
		}
		
		if (!newGen) {
			world.getChunkFromChunkCoords(chunkX, chunkZ).setChunkModified();
		}
	}

	public static void spawnRandomGem(World world, Random random, BlockPos pos) {
		int rand = random.nextInt(2);
		if (rand == 0) {
			world.setBlockState(pos, ModBlocks.garnetOre.getDefaultState(), 3);
		}
		if (rand == 1) {
			world.setBlockState(pos, ModBlocks.amethystOre.getDefaultState(), 3);
		}
	}

	private void attemptSpawnGem(Random random, int chunkX, int chunkZ, World world) {
		for (int i = 0; i < WorldGenConfiguration.gemSpawnTries; i++) {
			int x = chunkX * 16 + random.nextInt(16);
			int z = chunkZ * 16 + random.nextInt(16);
			int y = world.getTopSolidOrLiquidBlock(new BlockPos(x, world.provider.getActualHeight(), z)).getY() - 1;
			boolean air = false;
			BlockPos.MutableBlockPos pos = new BlockPos.MutableBlockPos(x, y, z);

			while (y > 1 && !air) {
				if (world.isAirBlock(pos)) {
					air = true;
				}
				y--;
				pos.setPos(x, y, z);
			}

			if (air) {
				while (y > 1 && air) {
					if (!world.isAirBlock(pos)) {
						air = false;
					} else {
						y--;
						pos.setPos(x, y, z);
					}
				}

				if (!air) {
					if (world.getBlockState(pos) == Blocks.STONE) {
						spawnRandomGem(world, random, new BlockPos(pos.setPos(x, y+1, z)));
						return;
					}
				}
			}
		}
	}

/*	public void addOreSpawn(IBlockState block, final IBlockState targetBlock, World world, Random random, int blockXPos,
			int blockZPos, int minVeinSize, int maxVeinSize, int chancesToSpawn, int minY, int maxY) {
		WorldGenMinable minable = new WorldGenMinable(block, (minVeinSize - random.nextInt(maxVeinSize - minVeinSize)));
		for (int i = 0; i < chancesToSpawn; i++) {
			int posX = blockXPos + random.nextInt(16);
			int posY = minY + random.nextInt(maxY - minY);
			int posZ = blockZPos + random.nextInt(16);
			minable.generate(world, random, new BlockPos(posX, posY, posZ));
		}
	}
*/
}
