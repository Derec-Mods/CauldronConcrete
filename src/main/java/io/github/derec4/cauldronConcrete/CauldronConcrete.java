package io.github.derec4.cauldronConcrete;

import io.github.derec4.cauldronConcrete.listeners.PowderInCauldronListener;
import org.bukkit.plugin.java.JavaPlugin;

public final class CauldronConcrete extends JavaPlugin {

    @Override
    public void onEnable() {
        // Plugin startup logic
        getServer().getPluginManager().registerEvents(new PowderInCauldronListener(), this);
    }

    @Override
    public void onDisable() {
        // Plugin shutdown logic
    }
}
