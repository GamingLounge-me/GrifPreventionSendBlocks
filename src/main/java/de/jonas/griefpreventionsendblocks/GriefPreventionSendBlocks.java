package de.jonas.griefpreventionsendblocks;

import java.util.logging.Level;
import java.util.logging.Logger;

import org.bukkit.plugin.java.JavaPlugin;

import de.jonas.griefpreventionsendblocks.commands.AddBlocks;
import de.jonas.griefpreventionsendblocks.commands.RemoveBlocks;
import de.jonas.griefpreventionsendblocks.commands.SendBlocks;
import dev.jorel.commandapi.CommandAPI;
import dev.jorel.commandapi.CommandAPIBukkitConfig;

public final class GriefPreventionSendBlocks extends JavaPlugin {

    Logger logger;

    @Override
    public void onLoad() {

        this.logger = this.getLogger();

        CommandAPI.onLoad(new CommandAPIBukkitConfig(this));
        new SendBlocks();
        new AddBlocks();
        new RemoveBlocks();
        
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
