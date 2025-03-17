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

public class ChatManagerGui {
    private ACC main;

    public ChatManagerGui(ACC main) {
        this.main = main;
    }

    String title = ChatColor.DARK_AQUA + "ACC: Chat Manager";
    Inventory inv = Bukkit.createInventory(null, 27, title);

    public void openGui(Player player) {
        ItemStack close = new ItemStack(Material.RED_STAINED_GLASS_PANE);
        ItemMeta closeMeta = close.getItemMeta();
        closeMeta.setDisplayName(ChatColor.RED + "Close");
        close.setItemMeta(closeMeta);

        inv.setItem(0, close);

        ItemStack enable = new ItemStack(main.getHead("a79a5c95ee17abfef45c8dc224189964944d560f19a44f19f8a46aef3fee4756"));
        ItemMeta enableMeta = enable.getItemMeta();
        enableMeta.setDisplayName(ChatColor.GREEN + "Enable Chat");
        enable.setItemMeta(enableMeta);

        inv.setItem(11, enable);

        ItemStack disable = new ItemStack(main.getHead("beb588b21a6f98ad1ff4e085c552dcb050efc9cab427f46048f18fc803475f7"));
        ItemMeta disableMeta = disable.getItemMeta();
        disableMeta.setDisplayName(ChatColor.GREEN + "Disable Chat");
        disable.setItemMeta(disableMeta);

        inv.setItem(13, disable);

        ItemStack clear = new ItemStack(main.getHead("bc761ff1b56ddb3906e5146e6bd7df0922f2ba6c3e3024803f794a719da184a3"));
        ItemMeta clearMeta = clear.getItemMeta();
        clearMeta.setDisplayName(ChatColor.GREEN + "Clear Chat");
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

        for (int i : new int[]{1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 12, 14, 16, 17, 19, 20, 21, 22, 23, 24, 25, 26}) {
            inv.setItem(i, frame);
        }

        player.openInventory(inv);
    }

    public String getTitle() {
        return title;
    }
}
