package org.powell.ACC.commands;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.powell.ACC.ACC;

public class AACCommand implements CommandExecutor {
    private final ACC main;
    public AACCommand(ACC main) {
        this.main = main;
    }
    @Override
    public boolean onCommand(CommandSender commandSender, Command command, String s, String[] strings) {
        if (commandSender instanceof Player player){
            if (player.isOp()){
                main.getMainMenu().openMenu(player);
            }
        }

        return false;
    }
}
