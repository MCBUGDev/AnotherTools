package cn.mcbugdev.another_tools.objects.blocks;

import cn.mcbugdev.another_tools.init.ItemRegistration;
import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;
import net.minecraft.item.ItemStack;
import net.minecraft.loot.LootContext;
import net.minecraft.util.Direction;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.IBlockReader;
import net.minecraftforge.common.IPlantable;
import net.minecraftforge.common.ToolType;

import javax.annotation.ParametersAreNonnullByDefault;
import java.util.ArrayList;
import java.util.List;

public abstract class KeplerDirt extends Block {
    public KeplerDirt() {
        super(Properties.create(Material.EARTH).sound(SoundType.GROUND).hardnessAndResistance(0.5f,0f).harvestTool(ToolType.SHOVEL));
    }

    @Override
    @ParametersAreNonnullByDefault
    public boolean canSustainPlant(BlockState state, IBlockReader world, BlockPos pos, Direction facing, IPlantable plantable) {
        return true;
    }

    @Override
    public abstract List<ItemStack> getDrops(BlockState state, LootContext.Builder builder);
}
