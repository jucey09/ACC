package org.powell.ACC.guis;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.powell.ACC.ACC;

import java.util.Arrays;
import java.util.List;

public class ServerManagerGui {
    private ACC main;
    public ServerManagerGui(ACC main) { this.main = main; }

    String title = ChatColor.DARK_AQUA + "ACC: Server Manager";
    Inventory inv = Bukkit.createInventory(null, 27, title);

    public void openGui(Player player) {
        ItemStack close = new ItemStack(Material.RED_STAINED_GLASS_PANE);
        ItemMeta closeMeta = close.getItemMeta();
        closeMeta.setDisplayName(ChatColor.RED + "Close");
        close.setItemMeta(closeMeta);

        inv.setItem(0, close);

        ItemStack enable = new ItemStack(main.getHead("d761ea71913137eb986ed861d1a9da1c70022ab5acd57b88499ab80cc4e0bd24"));
        ItemMeta enableMeta = enable.getItemMeta();
        enableMeta.setDisplayName(ChatColor.BLUE + "Reload Server");
        enableMeta.setLore(Arrays.asList(ChatColor.RED + "WARNING WILL CAUSE A LITTLE BIT OF LAG"));
        enable.setItemMeta(enableMeta);

        inv.setItem(11, enable);

        ItemStack clear = new ItemStack(main.getHead("beb588b21a6f98ad1ff4e085c552dcb050efc9cab427f46048f18fc803475f7"));
        ItemMeta clearMeta = clear.getItemMeta();
        clearMeta.setDisplayName(ChatColor.RED + "Stop Server");
        clear.setItemMeta(clearMeta);

        inv.setItem(15, clear);

        ItemStack back = new ItemStack(main.getHead("76ebaa41d1d405eb6b60845bb9ac724af70e85eac8a96a5544b9e23ad6c96c62"));
        ItemMeta backMeta = back.getItemMeta();
        backMeta.setDisplayName(ChatColor.GREEN + "Go Back To Main Menu");
        back.setItemMeta(backMeta);

        inv.setItem(18, back);

        ItemStack frame = new ItemStack(Material.GRAY_STAINED_GLASS_PANE);
        ItemMeta fmeta = frame.getItemMeta();
        fmeta.setDisplayName(ChatColor.DARK_GRAY + "_");
        fmeta.setLore(List.of(" "));
        frame.setItemMeta(fmeta);

        for (int i : new int[]{1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 12, 13, 14, 16, 17, 19, 20, 21, 22, 23, 24, 25, 26}) {
            inv.setItem(i, frame);
        }

        player.openInventory(inv);
    }

    public String getTitle() {
        return title;
    }

}
