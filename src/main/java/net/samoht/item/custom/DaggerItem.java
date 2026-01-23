package net.samoht.item.custom;

import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.effect.StatusEffectInstance;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.ToolMaterial;
import net.minecraft.particle.ParticleTypes;
import net.minecraft.server.world.ServerWorld;
import net.minecraft.sound.SoundCategory;
import net.minecraft.sound.SoundEvents;
import net.minecraft.util.math.Vec3d;

import java.util.List;

public class DaggerItem extends Item {
    private final List<StatusEffectInstance> effects;

    public DaggerItem(ToolMaterial material, float attackDamage, float attackSpeed, Settings settings, List<StatusEffectInstance> effects) {
        super(settings.sword(material, attackDamage, attackSpeed));
        this.effects = effects;
    }

    public DaggerItem(ToolMaterial material, float attackDamage, float attackSpeed, Settings settings) {
        this(material, attackDamage, attackSpeed, settings, List.of());
    }

    @Override
    public void postHit(ItemStack stack, LivingEntity target, LivingEntity attacker) {
        if(!effects.isEmpty()){
            for(StatusEffectInstance effect : effects){
                target.addStatusEffect(new StatusEffectInstance(effect));
            }
        }

        if(isHitFromBehind(target, attacker)){
            ServerWorld serverWorld = (ServerWorld) attacker.getEntityWorld();
            target.damage(serverWorld, attacker.getDamageSources().generic(), 3.5F);

            serverWorld.playSound(null, target.getX(), target.getY(), target.getZ(), SoundEvents.ENTITY_PLAYER_ATTACK_CRIT, SoundCategory.PLAYERS);
            serverWorld.spawnParticles(ParticleTypes.CRIT, target.getX(), target.getBodyY(0.5), target.getZ(), 5, 0.2, 0.2, 0.2, 0.1 );
        }

        super.postHit(stack, target, attacker);
    }

    private boolean isHitFromBehind(LivingEntity target, LivingEntity attacker){
        Vec3d lookDir = target.getRotationVec(1.0F).normalize();
        Vec3d attackDir = attacker.getRotationVec(1.0F).normalize();

        return lookDir.dotProduct(attackDir) > 0.5;
    }
}
