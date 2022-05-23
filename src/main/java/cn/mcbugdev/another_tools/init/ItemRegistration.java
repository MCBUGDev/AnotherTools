package cn.mcbugdev.another_tools.init;

import cn.mcbugdev.another_tools.objects.items.common.IngotBase;
import cn.mcbugdev.another_tools.objects.items.tools.PotatoSword;
import cn.mcbugdev.another_tools.utils.Reference;
import net.minecraft.item.Item;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;

public class ItemRegistration {
    public static final DeferredRegister<Item> ITEMS = DeferredRegister.create(ForgeRegistries.ITEMS, Reference.MOD_ID);
    public static final RegistryObject<Item> POTATO_INGOT = ITEMS.register("potato_ingot", IngotBase::new);
    public static final RegistryObject<Item> POTATO_SWORD = ITEMS.register("potato_sword", PotatoSword::new);
}
