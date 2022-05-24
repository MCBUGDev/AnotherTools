package cn.mcbugdev.another_tools.init;

import cn.mcbugdev.another_tools.objects.blocks.KeplerGrassBlock;
import cn.mcbugdev.another_tools.utils.Reference;
import net.minecraft.block.AbstractBlock;
import net.minecraft.block.Block;
import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;

public class BlockRegistration {
    public static final DeferredRegister<Block> BLOCKS = DeferredRegister.create(ForgeRegistries.BLOCKS, Reference.MOD_ID);
    public static final RegistryObject<Block> KEPLER_GRASS_BLOCK = BLOCKS.register("kepler_grass_block", KeplerGrassBlock::new);
}
