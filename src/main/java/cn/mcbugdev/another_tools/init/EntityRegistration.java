package cn.mcbugdev.another_tools.init;

import cn.mcbugdev.another_tools.objects.entity.ArrowCustomEntity;
import cn.mcbugdev.another_tools.utils.Reference;
import net.minecraft.entity.EntityClassification;
import net.minecraft.entity.EntityType;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;

public class EntityRegistration {
    public static final DeferredRegister<EntityType<?>> ENTITIES = DeferredRegister.create(ForgeRegistries.ENTITIES, Reference.MOD_ID);
    public static final RegistryObject<EntityType<ArrowCustomEntity>> GATHERING_STAFF_ENTITY;
    static{
        GATHERING_STAFF_ENTITY = ENTITIES.register("gathering_staff_entity",()->EntityType.Builder.<ArrowCustomEntity>create(ArrowCustomEntity::new, EntityClassification.MISC).size(0.1f,0.1f).setShouldReceiveVelocityUpdates(true).setTrackingRange(64).setUpdateInterval(1).build("gathering_staff_entity"));
    }
}
