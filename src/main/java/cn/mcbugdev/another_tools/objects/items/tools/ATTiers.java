package cn.mcbugdev.another_tools.objects.items.tools;

import net.minecraft.item.IItemTier;
import net.minecraft.item.crafting.Ingredient;

public enum ATTiers implements IItemTier {
    ;
    private final int maxUses;
    private final float efficiency;
    private final float attackDamage;
    private final int harvestLevel;
    private final int enchantAbility;
    private final Ingredient repairMaterial;
    ATTiers(int maxUses,float efficiency,float attackDamage,int harvestLevel,int enchantAbility,Ingredient repairMaterial){
        this.maxUses=maxUses;
        this.efficiency=efficiency;
        this.attackDamage=attackDamage;
        this.harvestLevel=harvestLevel;
        this.enchantAbility=enchantAbility;
        this.repairMaterial=repairMaterial;
    }
    @Override
    public int getMaxUses() {
        return maxUses;
    }

    @Override
    public float getEfficiency() {
        return efficiency;
    }

    @Override
    public float getAttackDamage() {
        return attackDamage;
    }

    @Override
    public int getHarvestLevel() {
        return harvestLevel;
    }

    @Override
    public int getEnchantability() {
        return enchantAbility;
    }

    @Override
    public Ingredient getRepairMaterial() {
        return repairMaterial;
    }
}
