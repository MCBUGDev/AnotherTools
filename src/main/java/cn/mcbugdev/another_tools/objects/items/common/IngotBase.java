package cn.mcbugdev.another_tools.objects.items.common;

import net.minecraft.item.Item;

import static cn.mcbugdev.another_tools.utils.Reference.ANOTHER_TOOLS_GROUP;

public class IngotBase extends Item {
    public IngotBase() {
        super(new Properties().group(ANOTHER_TOOLS_GROUP));
    }
}
