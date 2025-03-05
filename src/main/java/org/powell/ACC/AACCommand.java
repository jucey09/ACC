package org.powell.ACC;

import org.bukkit.Material;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;

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
