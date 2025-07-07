package io.github.derec4.cauldronConcrete.handlers;

import org.bukkit.*;
import org.bukkit.block.Block;
import org.bukkit.block.data.Levelled;

public class EffectsHandler {
    /**
     * Water particle and sound calculation code by RezzedUp
     * https://rezzedup.com/
     *
     * @param cauldron
     */
    public static void splashEffects(Block cauldron) {
        if (cauldron.getType() != Material.WATER_CAULDRON) {
            return;
        }

        World world = cauldron.getWorld();
        Location loc = cauldron.getLocation().add(0.5, 0, 0.5);
        int level = ((Levelled) cauldron.getBlockData()).getLevel();
        double waterHeight = 0.9 - (0.1875 * (3 - level));
        loc.setY(loc.getY() + waterHeight);

        world.spawnParticle(Particle.WATER_SPLASH, loc, 8, 0.15, 0.05, 0.15);
        world.playSound(loc, Sound.ENTITY_GENERIC_SPLASH, 0.7f, 1.2f);
    }

    /**
     * Water particle and sound calculation code by RezzedUp
     * https://rezzedup.com/
     *
     * @param cauldron
     */
    public static void particleEffects(Block cauldron) {
        if (cauldron.getType() != Material.WATER_CAULDRON) {
            return;
        }

        World world = cauldron.getWorld();
        Location loc = cauldron.getLocation().add(0.5, 1.0, 0.5);
        world.spawnParticle(Particle.CLOUD, loc, 3, 0.1, 0.0, 0.1, 0.03);
        world.playSound(loc, Sound.BLOCK_STONE_PLACE, 0.8f, 1.1f);
    }
}