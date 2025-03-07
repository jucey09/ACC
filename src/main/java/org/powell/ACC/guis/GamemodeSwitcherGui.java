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

public class GamemodeSwitcherGui {
    private ACC main;
    public GamemodeSwitcherGui(ACC main) { this.main = main; }

    String title = ChatColor.DARK_AQUA + "ACC: Gamemode Switcher";

    Inventory inv = Bukkit.createInventory(null, 27, title);

    public void openGui(Player player) {

        ItemStack close = new ItemStack(Material.RED_STAINED_GLASS_PANE);
        ItemMeta closeMeta = close.getItemMeta();
        closeMeta.setDisplayName(ChatColor.RED + "Close");
        close.setItemMeta(closeMeta);

        inv.setItem(0, close);

        //10 12 14 16
        ItemStack survival = new ItemStack(main.getHead("eb76b4ee988572297cbd874683bee96ae3c55ce94c004e51adc82cee16cd0b0c"));
        ItemMeta survivalMeta = survival.getItemMeta();
        survivalMeta.setDisplayName(ChatColor.RED + "Gamemode Survival");
        survival.setItemMeta(survivalMeta);

        inv.setItem(10, survival);

        ItemStack creative = new ItemStack(main.getHead("1ca8293c832514f253438958bb43caca89e6dd2f9e427e30fa0ff5f1a7d28f51"));
        ItemMeta creativeMeta = creative.getItemMeta();
        creativeMeta.setDisplayName(ChatColor.AQUA + "Gamemode Creative");
        creative.setItemMeta(creativeMeta);

        inv.setItem(12, creative);

        ItemStack spectator = new ItemStack(main.getHead("76b1ee60e1b63665366489b543d44fa50350dd40ea6ba76ffec435af39afd12c"));
        ItemMeta spectatorMeta = spectator.getItemMeta();
        spectatorMeta.setDisplayName(ChatColor.GOLD + "Gamemode Spectator");
        spectator.setItemMeta(spectatorMeta);

        inv.setItem(14, spectator);

        ItemStack adventure = new ItemStack(main.getHead("cd878b8f052a5e49a1bf90981775b1ac6deebaa38c18c877b5a9515756419f79"));
        ItemMeta adventureMeta = adventure.getItemMeta();
        adventureMeta.setDisplayName(ChatColor.LIGHT_PURPLE + "Gamemode Adventure");
        adventure.setItemMeta(adventureMeta);

        inv.setItem(16, adventure);

        ItemStack back = new ItemStack(main.getHead("76ebaa41d1d405eb6b60845bb9ac724af70e85eac8a96a5544b9e23ad6c96c62"));
        ItemMeta backMeta = back.getItemMeta();
        backMeta.setDisplayName(ChatColor.GREEN + "Go Back");
        back.setItemMeta(backMeta);

        inv.setItem(18, back);

        ItemStack frame = new ItemStack(Material.GRAY_STAINED_GLASS_PANE);
        ItemMeta fmeta = frame.getItemMeta();
        fmeta.setDisplayName(ChatColor.DARK_GRAY + "_");
        fmeta.setLore(List.of(" "));
        frame.setItemMeta(fmeta);

        for (int i : new int[]{1, 2, 3, 4, 5, 6, 7, 8, 9, 11, 13, 15, 17, 19, 20, 21, 22, 23, 24, 25, 26}) {
            inv.setItem(i, frame);
        }

        player.openInventory(inv);
    }
    public String getTitle() { return title; }
}
