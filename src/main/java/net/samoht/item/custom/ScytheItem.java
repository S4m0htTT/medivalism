package net.samoht.item.custom;

import net.minecraft.block.BlockState;
import net.minecraft.block.CropBlock;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.attribute.EntityAttribute;
import net.minecraft.entity.attribute.EntityAttributes;
import net.minecraft.entity.effect.StatusEffectInstance;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.ItemUsageContext;
import net.minecraft.item.ToolMaterial;
import net.minecraft.particle.ParticleTypes;
import net.minecraft.server.world.ServerWorld;
import net.minecraft.util.ActionResult;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;

import java.util.List;

public class ScytheItem extends Item {

    private final float attackDamage;
    private final int harvestRadius;
    private final boolean replantCrops;
    private final List<StatusEffectInstance> hitEffects;
    private final boolean areaEffect;
    private final float lifeStealAmount;

    public ScytheItem(ToolMaterial material, float attackDamage, float attackSpeed, Settings settings,
                      int harvestRadius, boolean replantCrops, List<StatusEffectInstance> hitEffects,
                      boolean areaEffect, float lifeStealAmount) {
        super(settings.sword(material, attackDamage, attackSpeed));
        this.attackDamage = attackDamage;
        this.harvestRadius = harvestRadius;
        this.replantCrops = replantCrops;
        this.hitEffects = hitEffects;
        this.areaEffect = areaEffect;
        this.lifeStealAmount = lifeStealAmount;
    }

    public ScytheItem(ToolMaterial material, float attackDamage, float attackSpeed, Settings settings) {
        this(material, attackDamage, attackSpeed, settings, 0, false, List.of(), false, 0.0f);
    }

    @Override
    public void postHit(ItemStack stack, LivingEntity target, LivingEntity attacker) {
        if (!hitEffects.isEmpty()) {
            for (StatusEffectInstance effect : hitEffects) {
                target.addStatusEffect(new StatusEffectInstance(effect));
            }
        }

        if (this.lifeStealAmount > 0) {
            attacker.heal(this.lifeStealAmount * this.attackDamage);

        }

        if (areaEffect) {
            ServerWorld serverWorld = (ServerWorld) attacker.getEntityWorld();
            List<LivingEntity> nearbyEntities = serverWorld.getEntitiesByClass(LivingEntity.class,
                    target.getBoundingBox().expand(2.0),
                    e -> e != attacker && e != target);

            double x = -Math.sin(attacker.getYaw() * 0.017453292);
            double z = Math.cos(attacker.getYaw() * 0.017453292);

            serverWorld.spawnParticles(ParticleTypes.SWEEP_ATTACK, attacker.getX() + x, attacker.getBodyY(0.5), attacker.getZ() + z, 0, 0, 0, 0, 0);

            for (LivingEntity nearbyEntity : nearbyEntities) {
                nearbyEntity.damage(serverWorld, attacker.getDamageSources().generic(), this.attackDamage * 0.5F);
                if (!hitEffects.isEmpty()) {
                    for (StatusEffectInstance effect : hitEffects) {
                        nearbyEntity.addStatusEffect(new StatusEffectInstance(effect));
                    }
                }
            }
        }

        super.postHit(stack, target, attacker);
    }

    @Override
    public ActionResult useOnBlock(ItemUsageContext context) {
        if (harvestRadius > 0) {
            World world = context.getWorld();
            BlockPos pos = context.getBlockPos();
            PlayerEntity player = context.getPlayer();
            if (isMatureCrop(world, pos)) {
                harvestCrop(world, pos, player);
                return ActionResult.SUCCESS;
            }
        }

        return super.useOnBlock(context);
    }

    private boolean isMatureCrop(World world, BlockPos pos) {
        BlockState state = world.getBlockState(pos);
        if (state.getBlock() instanceof CropBlock crop) {
            return crop.isMature(state);
        }
        return false;
    }

    private void harvestCrop (World world, BlockPos center, PlayerEntity player) {
        int radius = harvestRadius;
        for (int x = -radius; x <= radius; x++) {
            for (int z = -radius; z <= radius; z++) {
                BlockPos targetPos = center.add(x, 0, z);
                if (isMatureCrop(world, targetPos)) {
                    world.breakBlock(targetPos, true);
                    if (replantCrops) {
                     // TODO
                    }
                }
            }
        }
    }
}
