package io.github.derec4.cauldronConcrete.listeners;

import com.destroystokyo.paper.MaterialTags;
import io.github.derec4.cauldronConcrete.handlers.ConcreteHandler;
import io.github.derec4.cauldronConcrete.handlers.EffectsHandler;
import io.papermc.paper.event.entity.EntityInsideBlockEvent;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.World;
import org.bukkit.block.Block;
import org.bukkit.block.data.Levelled;
import org.bukkit.entity.Item;
import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.event.Listener;
import org.bukkit.inventory.ItemStack;

public class PowderInCauldronListener implements Listener {
    /**
     * Code inspired by Jake Potrebic
     * Machine-Maker
     * from the "PaperTweaks" plugin
     * @param event
     */
    @EventHandler(priority = EventPriority.MONITOR, ignoreCancelled = true)
    public void onEntityInsideBlock(EntityInsideBlockEvent event) {
        if (!(event.getEntity() instanceof final Item item)) {
            return;
        }

        if (event.getBlock().getType() != Material.WATER_CAULDRON) {
            return;
        }

        if (MaterialTags.CONCRETE_POWDER.isTagged(item.getItemStack())) {
            return;
        }

        Block cauldron = event.getBlock();
        if (!(cauldron.getBlockData() instanceof final Levelled levelled)) {
            return;
        }

        int currentLevel = levelled.getLevel();
        if (currentLevel <= 1) {
            return;
        }

        World world = item.getWorld();
        Location location = item.getLocation();
        int amount = item.getItemStack().getAmount();
        Material type = item.getItemStack().getType();

        world.dropItem(location, new ItemStack(ConcreteHandler.turnPowderIntoConcrete(type), amount));
        item.remove();
        levelled.setLevel(currentLevel - 1);
        cauldron.setBlockData(levelled);

        EffectsHandler.splashEffects(cauldron);
        EffectsHandler.particleEffects(cauldron);

    }
}
