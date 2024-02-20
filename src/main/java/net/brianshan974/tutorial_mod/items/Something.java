package net.brianshan974.tutorial_mod.items;

import net.minecraft.entity.EntityType;
import net.minecraft.entity.mob.EndermiteEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.server.world.ServerWorld;
import net.minecraft.sound.SoundCategory;
import net.minecraft.sound.SoundEvent;
import net.minecraft.sound.SoundEvents;
import net.minecraft.util.Hand;
import net.minecraft.util.TypedActionResult;
import net.minecraft.util.math.MathHelper;
import net.minecraft.world.GameRules;
import net.minecraft.world.World;

public class Something extends Item {

    public Something(Settings settings) {
        super(settings);
    }

    @Override
    public TypedActionResult<ItemStack> use(World world, PlayerEntity user, Hand hand) {
        if (!world.isClient) {
            double d = user.getX();
            double e = user.getY();
            double f = user.getZ();
            for (int i = 0; i < 16; ++i) {
                double g = user.getX() + (user.getRandom().nextDouble() - 0.5) * 6.0;
                double h = MathHelper.clamp(user.getY() + (double)(user.getRandom().nextInt(16) - 8), (double)world.getBottomY(), (double)(world.getBottomY() + ((ServerWorld)world).getLogicalHeight() - 1));
                double j = user.getZ() + (user.getRandom().nextDouble() - 0.5) * 6.0;
                if (user.hasVehicle()) {
                    user.stopRiding();
                }
                if (!user.teleport(g, h, j, true)) continue;
                SoundEvent soundEvent = SoundEvents.ITEM_CHORUS_FRUIT_TELEPORT;
                world.playSound(null, d, e, f, soundEvent, SoundCategory.PLAYERS, 1.0f, 1.0f);
                user.playSound(soundEvent, 1.0f, 1.0f);
                break;
            }
            if (user.getRandom().nextFloat() < 0.5f && world.getGameRules().getBoolean(GameRules.DO_MOB_SPAWNING)) {
                EndermiteEntity endermiteEntity = EntityType.ENDERMITE.create(world);
                endermiteEntity.refreshPositionAndAngles(d, e, f, user.getYaw(), user.getPitch());
                world.spawnEntity(endermiteEntity);
            }
        }
        return TypedActionResult.success(user.getStackInHand(hand));
    }

}
