package cn.mcbugdev.another_tools.objects.items.tools;

import cn.mcbugdev.another_tools.utils.Reference;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.projectile.SnowballEntity;
import net.minecraft.item.*;
import net.minecraft.stats.Stats;
import net.minecraft.util.ActionResult;
import net.minecraft.util.Hand;
import net.minecraft.util.SoundCategory;
import net.minecraft.util.SoundEvents;
import net.minecraft.world.World;

public class ATTools {
    public static class PotatoPickaxe extends PickaxeItem {
        public PotatoPickaxe() {
            super(ATTiers.POTATO,1, -2.8F,new Properties().group(Reference.ANOTHER_TOOLS_GROUP));
        }
    }
    public static class PotatoSword extends SwordItem {
        public PotatoSword() {
            super(ATTiers.POTATO,4, -2.4f, new Properties().group(Reference.ANOTHER_TOOLS_GROUP));
        }
    }
}
