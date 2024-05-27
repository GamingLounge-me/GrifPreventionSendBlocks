package de.jonas.griefpreventionsendblocks.commands;

import de.jonas.griefpreventionsendblocks.utility.ClaimBlocks;
import dev.jorel.commandapi.CommandAPICommand;
import dev.jorel.commandapi.arguments.IntegerArgument;
import dev.jorel.commandapi.arguments.PlayerArgument;
import net.kyori.adventure.text.Component;
import net.kyori.adventure.text.minimessage.MiniMessage;
import net.kyori.adventure.text.minimessage.tag.resolver.Placeholder;
import org.bukkit.entity.Player;

public class SendBlocks  {

    MiniMessage mm = MiniMessage.miniMessage();
    ClaimBlocks claimBlocks = new ClaimBlocks();

    public SendBlocks() {

        new CommandAPICommand("claimsend")
                .withArguments(new PlayerArgument("Spieler"))
                .withArguments(new IntegerArgument("Anzahl"))
                .executesPlayer((player, args) -> {
                    Player p = (Player) args.get("Spieler");
                    int count = (int) args.get("Anzahl");

                    if (count <= 0) {
                        player.sendMessage(mm.deserialize("<red>Das ist kein valider sende Wert!"));
                    } else if (p == null) {
                        player.sendMessage(mm.deserialize("<red>Das ist kein Spieler!"));
                    } else if (player == p) {
                        player.sendMessage(mm.deserialize("<red>Du kannst dir nicht selbst Claimblöcke senden!"));
                    } else if (count > claimBlocks.getRemaining(player)) {
                            player.sendMessage(mm.deserialize("<red>Du kannst nicht mehr Blöcke " +
                                    "senden als du hast!"));
                    } else {
                        claimBlocks.addRemaining(p, count);
                        claimBlocks.subtractRemaining(player, count);

                        p.sendMessage(mm.deserialize("Du hast <green><count><reset> Claimblöcke von" +
                                        " <player><reset> erhalten.",
                                Placeholder.component("count", Component.text(count)),
                                Placeholder.component("player", player.teamDisplayName())
                                ));
                        player.sendMessage(mm.deserialize("Du hast <green><count><reset> Claimblöcke an " +
                                "<player><reset> gesendet.",
                                Placeholder.component("count", Component.text(count)),
                                Placeholder.component("player", p.teamDisplayName())));
                    }

                })
                .register();

    }

}
