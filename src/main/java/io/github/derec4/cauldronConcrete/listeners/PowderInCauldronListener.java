package io.github.derec4.cauldronConcrete.listeners;

import com.destroystokyo.paper.MaterialTags;
import io.papermc.paper.event.entity.EntityInsideBlockEvent;
import org.bukkit.Material;
import org.bukkit.entity.Item;
import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.event.Listener;

public class PowderInCauldronListener implements Listener {
    @EventHandler(priority = EventPriority.MONITOR, ignoreCancelled = true)
    public void onEntityInsideBlock(final EntityInsideBlockEvent event) {
        if (!(event.getEntity() instanceof final Item item)) {
            return;
        }

        if (event.getBlock().getType() != Material.WATER_CAULDRON) {
            return;
        }

        if (MaterialTags.CONCRETE_POWDER.isTagged(item.getItemStack())) {
            return;
        }

//            item.getWorld().dropItem(item.getLocation(), new ItemStack(CauldronConcrete.toConcreteFromPowder(item.getItemStack().getType()), item.getItemStack().getAmount()));
        item.remove();
    }
}
