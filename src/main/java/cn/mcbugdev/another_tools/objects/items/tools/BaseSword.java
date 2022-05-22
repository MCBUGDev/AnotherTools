package cn.mcbugdev.another_tools.objects.items.tools;

import net.minecraft.item.IItemTier;
import net.minecraft.item.SwordItem;

public class BaseSword extends SwordItem {
    public BaseSword(IItemTier tier, int attackDamageIn, float attackSpeedIn, Properties builderIn) {
        super(tier, attackDamageIn, attackSpeedIn, builderIn);
    }
}
