package cn.mcbugdev.another_tools.objects.entity;

import cn.mcbugdev.another_tools.init.EntityRegistration;
import cn.mcbugdev.another_tools.init.ItemRegistration;
import net.minecraft.block.Blocks;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.IRendersAsItem;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.projectile.AbstractArrowEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.network.IPacket;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.SoundCategory;
import net.minecraft.util.math.MathHelper;
import net.minecraft.world.World;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;
import net.minecraftforge.fml.network.FMLPlayMessages;
import net.minecraftforge.fml.network.NetworkHooks;
import net.minecraftforge.registries.ForgeRegistries;

import java.util.Random;

@OnlyIn(value = Dist.CLIENT, _interface = IRendersAsItem.class)
public class ArrowCustomEntity extends AbstractArrowEntity implements IRendersAsItem {
    public ArrowCustomEntity(FMLPlayMessages.SpawnEntity packet, World world) {
        super(EntityRegistration.GATHERING_STAFF_ENTITY.get(), world);
    }

    public ArrowCustomEntity(EntityType<? extends ArrowCustomEntity> type, World world) {
        super(type, world);
    }

    public ArrowCustomEntity(EntityType<? extends ArrowCustomEntity> type, double x, double y, double z, World world) {
        super(type, x, y, z, world);
    }

    public ArrowCustomEntity(EntityType<? extends ArrowCustomEntity> type, LivingEntity entity, World world) {
        super(type, entity, world);
    }

    @Override
    public IPacket<?> createSpawnPacket() {
        return NetworkHooks.getEntitySpawningPacket(this);
    }

    @Override
    @OnlyIn(Dist.CLIENT)
    public ItemStack getItem() {
        return new ItemStack(ItemRegistration.WORLD_GATHERING_STAFF.get());
    }

    @Override
    protected ItemStack getArrowStack() {
        return ItemStack.EMPTY;
    }

    @Override
    protected void arrowHit(LivingEntity entity) {
        super.arrowHit(entity);
        entity.setArrowCountInEntity(entity.getArrowCountInEntity() - 1);
    }

    @Override
    public void tick() {
        super.tick();
        double x = this.getPosX();
        double y = this.getPosY();
        double z = this.getPosZ();
        World world = this.world;
        Entity entity = this.getEntity();
        Entity immediatesourceentity = this;
        if (this.inGround) {
            this.remove();
        }
    }

    public static ArrowCustomEntity shoot(World world, LivingEntity entity, Random random, float power, double damage, int knockback) {
        ArrowCustomEntity entityarrow = new ArrowCustomEntity(EntityRegistration.GATHERING_STAFF_ENTITY.get(), entity, world);
        entityarrow.shoot(entity.getLook(1).x, entity.getLook(1).y, entity.getLook(1).z, power * 2, 0);
        entityarrow.setSilent(true);
        entityarrow.setIsCritical(false);
        entityarrow.setDamage(damage);
        entityarrow.setKnockbackStrength(knockback);
        world.addEntity(entityarrow);
        double x = entity.getPosX();
        double y = entity.getPosY();
        double z = entity.getPosZ();
        world.playSound((PlayerEntity) null, (double) x, (double) y, (double) z,
                (net.minecraft.util.SoundEvent) ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("entity.arrow.shoot")),
                SoundCategory.PLAYERS, 1, 1f / (random.nextFloat() * 0.5f + 1) + (power / 2));
        return entityarrow;
    }

    public static ArrowCustomEntity shoot(LivingEntity entity, LivingEntity target) {
        ArrowCustomEntity entityarrow = new ArrowCustomEntity(EntityRegistration.GATHERING_STAFF_ENTITY.get(), entity, entity.world);
        double d0 = target.getPosY() + (double) target.getEyeHeight() - 1.1;
        double d1 = target.getPosX() - entity.getPosX();
        double d3 = target.getPosZ() - entity.getPosZ();
        entityarrow.shoot(d1, d0 - entityarrow.getPosY() + (double) MathHelper.sqrt(d1 * d1 + d3 * d3) * 0.2F, d3, 99f * 2, 12.0F);
        entityarrow.setSilent(true);
        entityarrow.setDamage(9999);
        entityarrow.setKnockbackStrength(99);
        entityarrow.setIsCritical(false);
        entity.world.addEntity(entityarrow);
        double x = entity.getPosX();
        double y = entity.getPosY();
        double z = entity.getPosZ();
        entity.world.playSound((PlayerEntity) null, (double) x, (double) y, (double) z,
                (net.minecraft.util.SoundEvent) ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("entity.arrow.shoot")),
                SoundCategory.PLAYERS, 1, 1f / (new Random().nextFloat() * 0.5f + 1));
        return entityarrow;
    }
}