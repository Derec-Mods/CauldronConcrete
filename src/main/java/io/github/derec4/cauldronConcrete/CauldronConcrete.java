package io.github.derec4.cauldronConcrete;

import io.github.derec4.cauldronConcrete.listeners.PowderInCauldronListener;
import net.kyori.adventure.text.Component;
import net.kyori.adventure.text.format.NamedTextColor;
import org.bukkit.Bukkit;
import org.bukkit.plugin.java.JavaPlugin;

public final class CauldronConcrete extends JavaPlugin {

    @Override
    public void onEnable() {
        // Plugin startup logic
        getServer().getPluginManager().registerEvents(new PowderInCauldronListener(), this);

        Bukkit.getLogger().info("");
        Bukkit.getServer().getConsoleSender().sendMessage(Component.text("  |_______|                             " +
                "  ").color(NamedTextColor.GREEN));
        Bukkit.getServer().getConsoleSender().sendMessage(Component.text("  | Derex |     Cauldron Concrete v1.0.0.0").color(NamedTextColor.GREEN));
        Bukkit.getServer().getConsoleSender().sendMessage(Component.text("  |_______|     Running on " + Bukkit.getName() + " - " + Bukkit.getVersion()).color(NamedTextColor.GREEN));
        Bukkit.getLogger().info("");
    }

    @Override
    public void onDisable() {
        // Plugin shutdown logic
    }
}
