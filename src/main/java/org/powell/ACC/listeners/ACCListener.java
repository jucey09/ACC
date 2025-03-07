package org.powell.ACC.listeners;

import org.bukkit.ChatColor;
import org.bukkit.GameMode;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.powell.ACC.ACC;

public class ACCListener implements Listener {
    private final ACC main;
    public ACCListener(ACC main) { this.main = main; }
    @EventHandler
    public void onClick(InventoryClickEvent e) {
        Player player = (Player) e.getWhoClicked();
        if (e.getClickedInventory() != null && e.getView().getTitle().equals(main.getMainMenu().getTitle())) {
            e.setCancelled(true);
            switch (e.getSlot()) {
                case 0:
                    player.closeInventory();
                    e.setCancelled(true);
                    break;
                case 10:
                    //player.openInventory(player manager)
                    break;
                case 12:
                    //player.openInventory(server manager)
                    break;
                case 14:
                    main.getGamemodeSwitcher().openGui(player);
                    break;
                case 16:
                    //player.openInventory(time & weather)
                    break;
                case 28:
                    main.getChatManager().openGui(player);
                    break;
                case 30:
                    //player.openInventory(player teleportation)
                    break;
                case 32:
                    //player.openInventory(op items)
                    break;
                case 34:
                    //player.openInventory(misc)
                default:
                    e.setCancelled(true);
                    break;
            }

        }
        if (e.getCurrentItem() != null && e.getView().getTitle().equals(main.getGamemodeSwitcher().getTitle())) {
            switch (e.getSlot()) {
                case 0:
                    e.setCancelled(true);
                    break;
                case 10:
                    player.setGameMode(GameMode.SURVIVAL);
                    player.sendMessage(ChatColor.GREEN + "You are survival mode.");
                    break;
                case 12:
                    player.setGameMode(GameMode.CREATIVE);
                    player.sendMessage(ChatColor.GREEN + "You are creative mode.");
                    break;
                case 14:
                    player.setGameMode(GameMode.SPECTATOR);
                    player.sendMessage(ChatColor.GREEN + "You are spectator mode.");
                    break;
                case 16:
                    player.setGameMode(GameMode.ADVENTURE);
                    player.sendMessage(ChatColor.GREEN + "You are adventure mode.");
                    break;
                case 18:
                    main.getMainMenu().openMenu(player);
                    break;
                default:
                    e.setCancelled(true);
                    break;
            }
            player.closeInventory();
        }
    }
}
