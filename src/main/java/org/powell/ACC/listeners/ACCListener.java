package org.powell.ACC.listeners;

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
        if (e.getClickedInventory() == null && e.getView().getTitle().equals(main.getMainMenu().getTitle())) {
            Player player = (Player) e.getWhoClicked();
            e.setCancelled(true);
            switch (e.getSlot()) {
                case 0:
                    e.setCancelled(true);
                    break;
                case 10:
                    break;
                case 12:
                    break;
                case 14:
                    break;
                case 16:
                    break;
                case 28:
                    break;
                case 32:
                    break;
                case 34:
                default:
                    e.setCancelled(true);
                    break;
            }
            player.closeInventory();
        }
    }
}
