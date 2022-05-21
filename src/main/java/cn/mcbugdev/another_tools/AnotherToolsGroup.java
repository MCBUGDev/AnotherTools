package cn.mcbugdev.another_tools;

import cn.mcbugdev.another_tools.init.ItemRegistration;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;

import javax.annotation.Nonnull;

public class AnotherToolsGroup extends ItemGroup {
    public AnotherToolsGroup() {
        super("another_tools");
    }

    @Override
    @Nonnull
    public ItemStack createIcon() {
        return new ItemStack(ItemRegistration.POTATO_INGOT.get());
    }
}
