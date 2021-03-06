package com.viesis.gemstones.common.utils.damagesources;

import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.item.ItemStack;
import net.minecraft.util.EntityDamageSourceIndirect;
import net.minecraft.util.text.ITextComponent;
import net.minecraft.util.text.TextComponentTranslation;
import net.minecraft.util.text.translation.I18n;

public class EntityDamageSourceElectric extends EntityDamageSourceIndirect {
	
	private final Entity indirectEntity;
	
	public EntityDamageSourceElectric(String damageTypeIn, Entity source, Entity indirectEntityIn) 
	{
		super(damageTypeIn, source, indirectEntityIn);
	    this.setDamageBypassesArmor();
	    
	    this.indirectEntity = indirectEntityIn;
	    
	}
	
	public Entity getSourceOfDamage()
    {
        return this.damageSourceEntity;
    }

    public Entity getEntity()
    {
        return this.indirectEntity;
    }
	
	public ITextComponent getDeathMessage(EntityLivingBase entityLivingBaseIn)
    {
        ITextComponent itextcomponent = this.indirectEntity == null ? this.damageSourceEntity.getDisplayName() : this.indirectEntity.getDisplayName();
        ItemStack itemstack = this.indirectEntity instanceof EntityLivingBase ? ((EntityLivingBase)this.indirectEntity).getHeldItemMainhand() : null;
        String s = "death.attack." + this.damageType;
        String s1 = s + ".item";
        return itemstack != null && itemstack.hasDisplayName() && I18n.canTranslate(s1) ? new TextComponentTranslation(s1, new Object[] {entityLivingBaseIn.getDisplayName(), itextcomponent, itemstack.getTextComponent()}): new TextComponentTranslation(s, new Object[] {entityLivingBaseIn.getDisplayName(), itextcomponent});
    }
	
	public static EntityDamageSourceElectric causeElectricDamage(Entity source, Entity transmitter) 
	{
		return new EntityDamageSourceElectric("electric.entity", transmitter, source);
	}
}
