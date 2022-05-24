package cn.mcbugdev.another_tools.objects.blocks;

import net.minecraft.block.AbstractBlock;
import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;
import net.minecraft.util.Direction;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.IBlockReader;
import net.minecraftforge.client.event.ColorHandlerEvent;
import net.minecraftforge.common.IPlantable;

import javax.annotation.ParametersAreNonnullByDefault;

public class KeplerGrassBlock extends Block {
    public KeplerGrassBlock() {
        super(Properties.create(Material.EARTH).sound(SoundType.GROUND));
    }

    @Override
    @ParametersAreNonnullByDefault
    public boolean canSustainPlant(BlockState state, IBlockReader world, BlockPos pos, Direction facing, IPlantable plantable) {
        return true;
    }
}
