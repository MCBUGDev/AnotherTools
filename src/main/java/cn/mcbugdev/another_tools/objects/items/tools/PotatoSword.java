package cn.mcbugdev.another_tools.objects.items.tools;

import cn.mcbugdev.another_tools.utils.Reference;
import net.minecraft.item.IItemTier;

public class PotatoSword extends BaseSword{
    public PotatoSword() {
        super(ATTiers.POTATO,4, -2.4f, new Properties().group(Reference.ANOTHER_TOOLS_GROUP));
    }
}
