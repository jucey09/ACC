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

public class MainMenu {
    private ACC main;
    public MainMenu(ACC main) { this.main = main; }

    String title = ChatColor.DARK_AQUA + "Admin Control Center: Main Menu";
    Inventory inv = Bukkit.createInventory(null, 45, title);

    public void openMenu(Player player) {
        //CLOSE
        ItemStack close = new ItemStack(Material.RED_STAINED_GLASS_PANE);
        ItemMeta closeMeta = close.getItemMeta();
        closeMeta.setDisplayName(ChatColor.RED + "Close");
        close.setItemMeta(closeMeta);

        inv.setItem(0, close);

        //PLAYER MANAGER
        ItemStack pmanagement = new ItemStack(main.getHead("7fa5148e821c1fbe23d63d08776b055b0654028e2e3965ec0dc48b4e62ce6d05"));
        ItemMeta pmanagementMeta = pmanagement.getItemMeta();
        pmanagementMeta.setDisplayName(ChatColor.GREEN + "Player Manager");
        pmanagement.setItemMeta(pmanagementMeta);

        inv.setItem(10, pmanagement);

        //SERVER MANAGER
        ItemStack sc = new ItemStack(main.getHead("2067c067bb0f7bdbaa4a55c601af7dd566c7f10f63675a34e934b24ded262f6e"));
        ItemMeta scMeta = sc.getItemMeta();
        scMeta.setDisplayName(ChatColor.GOLD + "Server Manager");
        sc.setItemMeta(scMeta);

        inv.setItem(12, sc);

        //GAMEMODE
        ItemStack gamemode = new ItemStack(main.getHead("5cdbf613bc0b885587294857af0cf12c01153264ac25e15773a9d8bcdc3f00a9"));
        ItemMeta gmeta = gamemode.getItemMeta();
        gmeta.setDisplayName(ChatColor.LIGHT_PURPLE + "Gamemode Switcher");
        gamemode.setItemMeta(gmeta);

        inv.setItem(14, gamemode);

        //TIME & WEATHER
        ItemStack timeweather = new ItemStack(main.getHead("e6f3f0334c9438e8c74c0f2167b0917d0d46d973636964f902742ed556fb0782"));
        ItemMeta timeweatherMeta = timeweather.getItemMeta();
        timeweatherMeta.setDisplayName(ChatColor.DARK_AQUA + "Time & Weather Control");
        timeweather.setItemMeta(timeweatherMeta);

        inv.setItem(16, timeweather);

        //CHAT MANAGER
        ItemStack chat = new ItemStack(main.getHead("667a9267f2b0322bf80da7dc65960c579f96ba72feaf258fb036c803f1bdba2"));
        ItemMeta chatMeta = chat.getItemMeta();
        chatMeta.setDisplayName(ChatColor.GRAY + "Chat Manager");
        chat.setItemMeta(chatMeta);

        inv.setItem(28, chat);

        //PLAYER TELEPORTATION
        ItemStack playert = new ItemStack(main.getHead("d4531461b8f03be7231dd78fbadcbb5b50cc410a8164cade657321bbcd37d188"));
        ItemMeta playertMeta = playert.getItemMeta();
        playertMeta.setDisplayName(ChatColor.BLUE + "Player Teleportation");
        playert.setItemMeta(playertMeta);

        inv.setItem(30, playert);

        //OP ITEMS
        ItemStack op = new ItemStack(main.getHead("e7bc251a6cb0d6d9f05c5711911a6ec24b209dbe64267901a4b03761debcf738"));
        ItemMeta opMeta = op.getItemMeta();
        opMeta.setDisplayName(ChatColor.YELLOW + "OP Items");
        op.setItemMeta(opMeta);

        inv.setItem(32, op);

        //MISC
        ItemStack misc = new ItemStack(main.getHead("c8b71839152e7933e1bd2ff47020a6820032561792f0df6ab36197825abd0da7"));
        ItemMeta miscMeta = misc.getItemMeta();
        miscMeta.setDisplayName(ChatColor.DARK_PURPLE + "Misc");
        misc.setItemMeta(miscMeta);

        inv.setItem(34, misc);

        ItemStack frame = new ItemStack(Material.GRAY_STAINED_GLASS_PANE);
        ItemMeta fmeta = frame.getItemMeta();
        fmeta.setDisplayName(ChatColor.DARK_GRAY + "_");
        fmeta.setLore(List.of(" "));
        frame.setItemMeta(fmeta);

        for (int i : new int[]{1, 2, 3, 4, 5, 6, 7, 8, 9, 11, 13, 15, 17, 18, 19, 20, 21, 22, 23, 24, 25, 26, 27, 29, 31, 33, 35, 36, 37, 38, 39, 40, 41, 42, 43, 44}) {
            inv.setItem(i, frame);
        }
        player.openInventory(inv);
    }

    public String getTitle() {
        return title;
    }

}

