package org.powell.ACC;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class AACCommand implements CommandExecutor {
    private ACC main;
    public AACCommand(ACC main) {
        this.main = main;
    }
    @Override
    public boolean onCommand(CommandSender commandSender, Command command, String s, String[] strings) {
        if (commandSender instanceof Player){
            Player player = (Player) commandSender;
            if (player.isOp()){
                main.getMainMenu().openMenu(player);
            }
        }

        return false;
    }
}
