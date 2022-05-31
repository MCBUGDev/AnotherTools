package cn.mcbugdev.another_tools.objects.blocks;

import cn.mcbugdev.another_tools.init.ItemRegistration;
import net.minecraft.block.BlockState;
import net.minecraft.item.ItemStack;
import net.minecraft.loot.LootContext;

import java.util.ArrayList;
import java.util.List;

public class KeplerEarth extends KeplerDirt{
    @Override
    public List<ItemStack> getDrops(BlockState state, LootContext.Builder builder) {
        List<ItemStack> drops = new ArrayList<>();
        drops.add(new ItemStack(ItemRegistration.KE_ITEM.get()));
        return drops;
    }
}
