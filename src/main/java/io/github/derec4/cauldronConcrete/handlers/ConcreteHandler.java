package io.github.derec4.cauldronConcrete.handlers;

import com.destroystokyo.paper.MaterialTags;
import org.bukkit.Material;

import static java.util.Objects.requireNonNull;

public class ConcreteHandler {
    public static Material turnPowderIntoConcrete (final Material concretePowder) {
        // define variable as final because we will not be changing it, only reading

        if (!MaterialTags.CONCRETE_POWDER.isTagged(concretePowder)) {
            throw new IllegalArgumentException(concretePowder + " is not a concrete powder");
        }

        // feel this may be more expensive using String.replace() function, could be replaced by a static map of powder
        // concrete names. But this implementation supports any future blocks Mojang or mods may add that are concrete powders
        return requireNonNull(Material.matchMaterial(concretePowder.name().replace("_POWDER", "")));
    }
}
