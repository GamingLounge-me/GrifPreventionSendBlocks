package de.jonas.griefpreventionsendblocks.utility;

import org.bukkit.entity.Player;

import me.ryanhamshire.GriefPrevention.GriefPrevention;
import me.ryanhamshire.GriefPrevention.PlayerData;

public class ClaimBlocks {

    public int getRemaining(Player p) {
        return GriefPrevention.instance.dataStore.getPlayerData(p.getUniqueId()).getAccruedClaimBlocks();
    }

    public void setRemaining(Player p, int count) {
        PlayerData pd = GriefPrevention.instance.dataStore.getPlayerData(p.getUniqueId());
        pd.setAccruedClaimBlocks(count);
        GriefPrevention.instance.dataStore.savePlayerData(p.getUniqueId(), pd);
    }

    public void addRemaining(Player p, int count) {
        setRemaining(p, getRemaining(p) + count);
    }

    public void subtractRemaining(Player p, int count) {
        setRemaining(p, getRemaining(p) - count);
    }

}
