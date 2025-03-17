package org.powell.ACC.guis;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.powell.ACC.ACC;

import java.util.List;

public class MiscGui {
    private ACC main;
    public MiscGui(ACC main) { this.main = main; }

    String title = ChatColor.DARK_AQUA + "ACC: Misc";
    Inventory inv = Bukkit.createInventory(null, 27, title);

    public void openGui(Player player) {
        ItemStack close = new ItemStack(Material.RED_STAINED_GLASS_PANE);
        ItemMeta closeMeta = close.getItemMeta();
        closeMeta.setDisplayName(ChatColor.RED + "Close");
        close.setItemMeta(closeMeta);

        inv.setItem(0, close);

        ItemStack enable = new ItemStack(Material.TOTEM_OF_UNDYING, 99);
        ItemMeta enableMeta = enable.getItemMeta();
        enableMeta.setDisplayName(ChatColor.BLUE + "Stack of Totems");
        enableMeta.setMaxStackSize(99);
        enable.setItemMeta(enableMeta);

        inv.setItem(11, enable);

        ItemStack clear = new ItemStack(Material.SHIELD);
        ItemMeta clearMeta = clear.getItemMeta();
        clearMeta.setDisplayName(ChatColor.RED + "Become Invincible");
        clear.setItemMeta(clearMeta);

        inv.setItem(13, clear);

        ItemStack un = new ItemStack(Material.BARRIER);
        ItemMeta uMeta = un.getItemMeta();
        uMeta.setDisplayName(ChatColor.RED + "Become Un-Invincible");
        un.setItemMeta(uMeta);

        inv.setItem(15, un);

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

        for (int i : new int[]{1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 12, 14, 16, 17, 19, 20, 21, 22, 23, 24, 25, 26}) {
            inv.setItem(i, frame);
        }

        player.openInventory(inv);
    }

    public String getTitle() {
        return title;
    }
}
