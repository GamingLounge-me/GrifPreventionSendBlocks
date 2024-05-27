package de.jonas.griefpreventionsendblocks;

import de.jonas.griefpreventionsendblocks.commands.SendBlocks;
import dev.jorel.commandapi.CommandAPI;
import dev.jorel.commandapi.CommandAPIBukkitConfig;
import org.bukkit.plugin.java.JavaPlugin;

import java.util.logging.Level;
import java.util.logging.Logger;

public final class GriefPreventionSendBlocks extends JavaPlugin {

    Logger logger;

    @Override
    public void onLoad() {

        this.logger = this.getLogger();

        CommandAPI.onLoad(new CommandAPIBukkitConfig(this));
        new SendBlocks();

    }

    @Override
    public void onEnable() {
        // Plugin startup logic

        CommandAPI.onEnable();

        logger.log(Level.INFO, "Plugin aktiviert");

    }

    @Override
    public void onDisable() {
        // Plugin shutdown logic

        CommandAPI.onDisable();

        logger.log(Level.INFO, "Plugin deaktiviert");

    }
}
