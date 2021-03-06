package cn.mcbugdev.another_tools.objects.blocks;

import cn.mcbugdev.another_tools.init.BlockRegistration;
import cn.mcbugdev.another_tools.init.ItemRegistration;
import net.minecraft.block.BlockState;
import net.minecraft.block.Blocks;
import net.minecraft.block.GrassBlock;
import net.minecraft.block.SnowBlock;
import net.minecraft.item.ItemStack;
import net.minecraft.loot.LootContext;
import net.minecraft.tags.FluidTags;
import net.minecraft.util.Direction;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.IWorldReader;
import net.minecraft.world.lighting.LightEngine;
import net.minecraft.world.server.ServerWorld;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import static net.minecraft.block.SnowyDirtBlock.SNOWY;

public class KeplerGrassBlock extends KeplerDirt{

    @Override
    public List<ItemStack> getDrops(BlockState state, LootContext.Builder builder) {
        List<ItemStack> drops = new ArrayList<>();
        drops.add(new ItemStack(ItemRegistration.KGB_ITEM.get()));
        return drops;
    }
    private static boolean isSnowyConditions(BlockState state, IWorldReader worldReader, BlockPos pos) {
        BlockPos blockpos = pos.up();
        BlockState blockstate = worldReader.getBlockState(blockpos);
        if (blockstate.matchesBlock(Blocks.SNOW) && blockstate.get(SnowBlock.LAYERS) == 1) {
            return true;
        } else if (blockstate.getFluidState().getLevel() == 8) {
            return false;
        } else {
            int i = LightEngine.func_215613_a(worldReader, state, pos, blockstate, blockpos, Direction.UP, blockstate.getOpacity(worldReader, blockpos));
            return i < worldReader.getMaxLightLevel();
        }
    }
    private static boolean isSnowyAndNotUnderwater(BlockState state, IWorldReader worldReader, BlockPos pos) {
        BlockPos blockpos = pos.up();
        return isSnowyConditions(state, worldReader, pos) && !worldReader.getFluidState(blockpos).isTagged(FluidTags.WATER);
    }
    public void randomTick(BlockState state, ServerWorld worldIn, BlockPos pos, Random random) {
        if (!isSnowyConditions(state, worldIn, pos)) {
            if (!worldIn.isAreaLoaded(pos, 3)) return; // Forge: prevent loading unloaded chunks when checking neighbor's light and spreading
            worldIn.setBlockState(pos, Blocks.DIRT.getDefaultState());
        } else {
            if (worldIn.getLight(pos.up()) >= 9) {
                BlockState blockstate = this.getDefaultState();

                for(int i = 0; i < 4; ++i) {
                    BlockPos blockpos = pos.add(random.nextInt(3) - 1, random.nextInt(5) - 3, random.nextInt(3) - 1);
                    if (worldIn.getBlockState(blockpos).matchesBlock(BlockRegistration.KEPLER_EARTH.get()) && isSnowyAndNotUnderwater(blockstate, worldIn, blockpos)) {
                        worldIn.setBlockState(blockpos, blockstate.with(SNOWY, worldIn.getBlockState(blockpos.up()).matchesBlock(Blocks.SNOW)));
                    }
                }
            }

        }
    }
}
