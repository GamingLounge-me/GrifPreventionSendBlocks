package de.jonas.griefpreventionsendblocks.commands;

import de.jonas.griefpreventionsendblocks.utility.ClaimBlocks;
import dev.jorel.commandapi.CommandAPICommand;
import dev.jorel.commandapi.CommandPermission;
import dev.jorel.commandapi.arguments.IntegerArgument;
import dev.jorel.commandapi.arguments.PlayerArgument;
import net.kyori.adventure.text.Component;
import net.kyori.adventure.text.minimessage.MiniMessage;
import net.kyori.adventure.text.minimessage.tag.resolver.Placeholder;
import org.bukkit.entity.Player;

public class AddBlocks {

    MiniMessage mm = MiniMessage.miniMessage();
    ClaimBlocks claimBlocks = new ClaimBlocks();

    public AddBlocks() {

        new CommandAPICommand("claimset")
                .withPermission(CommandPermission.OP)
                .withArguments(new PlayerArgument("Spieler"))
                .withArguments(new IntegerArgument("Anzahl"))
                .executes((sender, args) -> {
                    Player p = (Player) args.get("Spieler");
                    Integer count = (Integer) args.get("Anzahl");

                    if (count == null || count <= 0) {
                        if (sender instanceof Player) {
                            sender.sendMessage(mm.deserialize("<red>Das ist kein valider sende Wert!"));
                        }
                        return;
                    }
                    if (p == null) {
                        if (sender instanceof Player) {
                            sender.sendMessage(mm.deserialize("<red>Das ist kein Spieler!"));
                        }
                        return;
                    }

                    claimBlocks.addRemaining(p, count);

                    if (sender instanceof Player) {
                        sender.sendMessage(mm.deserialize("Du hast <green><count><reset> Claimblöcke and " +
                                        "<green><player><reset> hinzugefügt.",
                                Placeholder.component("count", Component.text(count)),
                                Placeholder.component("player", p.teamDisplayName())));
                    }

                })
                .register();

    }

}
