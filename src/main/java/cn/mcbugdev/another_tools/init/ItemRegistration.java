package cn.mcbugdev.another_tools.init;

import cn.mcbugdev.another_tools.objects.items.common.IngotBase;
import cn.mcbugdev.another_tools.objects.items.tools.ATTools;
import cn.mcbugdev.another_tools.objects.items.tools.GatheringStaff;
import cn.mcbugdev.another_tools.utils.Reference;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;

public class ItemRegistration {
    public static final DeferredRegister<Item> ITEMS = DeferredRegister.create(ForgeRegistries.ITEMS, Reference.MOD_ID);
    public static final RegistryObject<Item> KGB_ITEM = ITEMS.register("kepler_grass_block",()->new BlockItem(BlockRegistration.KEPLER_GRASS_BLOCK.get(),new Item.Properties().group(Reference.ANOTHER_TOOLS_GROUP)));
    public static final RegistryObject<Item> KE_ITEM = ITEMS.register("kepler_earth",()->new BlockItem(BlockRegistration.KEPLER_EARTH.get(),new Item.Properties().group(Reference.ANOTHER_TOOLS_GROUP)));
    public static final RegistryObject<Item> POTATO_INGOT = ITEMS.register("potato_ingot", IngotBase::new);
    public static final RegistryObject<Item> POTATO_SWORD = ITEMS.register("potato_sword", ATTools.PotatoSword::new);
    public static final RegistryObject<Item> POTATO_PICKAXE = ITEMS.register("potato_pickaxe", ATTools.PotatoPickaxe::new);
    public static final RegistryObject<Item> WORLD_GATHERING_STAFF = ITEMS.register("world_gathering_staff", GatheringStaff::new);
}
