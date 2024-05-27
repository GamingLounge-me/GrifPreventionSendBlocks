package de.jonas.griefpreventionsendblocks.utility;

import me.ryanhamshire.GriefPrevention.GriefPrevention;
import org.bukkit.Bukkit;
import org.bukkit.entity.Player;

public class ClaimBlocks {

    public int getRemaining(Player p) {
        return GriefPrevention.instance.dataStore.getPlayerData(p.getUniqueId()).getRemainingClaimBlocks();
    }

    public void setRemaining(Player p, int count) {
        Bukkit.getServer().dispatchCommand(Bukkit.getServer().getConsoleSender(),
                "setaccruedclaimblocks " + p.displayName() + " " + count);
    }

    public void addRemaining(Player p, int count) {
        setRemaining(p, getRemaining(p) + count);
    }

    public void subtractRemaining(Player p, int count) {
        setRemaining(p, getRemaining(p) - count);
    }

}
