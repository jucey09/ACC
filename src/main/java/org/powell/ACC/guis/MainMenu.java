package org.powell.ACC.guis;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;

public class MainMenu {
    Inventory inv = Bukkit.createInventory(null, 9, ChatColor.DARK_AQUA + "Admin Control Center - Main Menu");


    public void openMenu(Player player) {
        player.openInventory(inv);
    }
}
