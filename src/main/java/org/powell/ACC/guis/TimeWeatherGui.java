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

public class TimeWeatherGui {
    private ACC main;
    public TimeWeatherGui(ACC main) { this.main = main; }

    String title = ChatColor.DARK_AQUA + "ACC: Time & Weather Manager";
    Inventory inv = Bukkit.createInventory(null, 36, title);

    public void openGui(Player player) {
        //CLOSE
        ItemStack close = new ItemStack(Material.RED_STAINED_GLASS_PANE);
        ItemMeta closeMeta = close.getItemMeta();
        closeMeta.setDisplayName(ChatColor.RED + "Close");
        close.setItemMeta(closeMeta);

        inv.setItem(0, close);

        ItemStack daytime = new ItemStack(main.getHead("2640ced4a7c9b6073c352131d8c49dff873c0ccd3db569d9fd49778f903c4e55"));
        ItemMeta daytimeMeta = daytime.getItemMeta();
        daytimeMeta.setDisplayName(ChatColor.YELLOW + "Sunrise");
        daytime.setItemMeta(daytimeMeta);

        inv.setItem(10, daytime);

        ItemStack noon  = new ItemStack(main.getHead("ed2ff09cf6e793ca8871b46070d1a582fdc16e7b9fba67d3c08f15c6e47eb645"));
        ItemMeta noonMeta = noon.getItemMeta();
        noonMeta.setDisplayName(ChatColor.GOLD + "Afternoon");
        noon.setItemMeta(noonMeta);

        inv.setItem(12, noon);

        ItemStack sunset = new ItemStack(main.getHead("2972cd34bf8c26c2f5bcb7358bc2dd0c8da0a960333a12f7d3abba2c94272ab9"));
        ItemMeta sunsetMeta = sunset.getItemMeta();
        sunsetMeta.setDisplayName(ChatColor.RED + "Sunset");
        sunset.setItemMeta(sunsetMeta);

        inv.setItem(14, sunset);

        ItemStack night = new ItemStack(main.getHead("dcfd4020792e076bee6ba8d14d9b8bd4b28eb63bac765abb626ca503cc453eec"));
        ItemMeta nightMeta = night.getItemMeta();
        nightMeta.setDisplayName(ChatColor.BLUE + "Night");
        night.setItemMeta(nightMeta);

        inv.setItem(16, night);

        ItemStack clear = new ItemStack(main.getHead("250e276fa17865f4fdf28231f0e4d389a052b03e9af1438d311199de78672ace"));
        ItemMeta clearMeta = clear.getItemMeta();
        clearMeta.setDisplayName(ChatColor.AQUA + "Clear Weather");
        clear.setItemMeta(clearMeta);

        inv.setItem(19, clear);

        ItemStack rain = new ItemStack(main.getHead("9292d1726171ababf73f8441154cf7b72ee2e0e4644d6ee0838d760dc3489c92"));
        ItemMeta rainMeta = rain.getItemMeta();
        rainMeta.setDisplayName(ChatColor.BLUE + "Rainy Weather");
        rain.setItemMeta(rainMeta);

        inv.setItem(21, rain);

        ItemStack thunder = new ItemStack(main.getHead("33d69a60d970ad0b8aa15897914f5aac265e99e6f5016a7d8aa7be9ac03b6148"));
        ItemMeta thunderMeta = thunder.getItemMeta();
        thunderMeta.setDisplayName(ChatColor.DARK_GRAY + "Thundering Weather");
        thunder.setItemMeta(thunderMeta);

        inv.setItem(23, thunder);

        ItemStack mystery = new ItemStack(main.getHead("a70216baf1b9675f805dfdf95db043afe6f881c82b25937e46b15068e8f3e882"));
        ItemMeta mysteryMeta = mystery.getItemMeta();
        mysteryMeta.setDisplayName(ChatColor.DARK_PURPLE + "Mystery Weather");
        mystery.setItemMeta(mysteryMeta);

        inv.setItem(25, mystery);

        ItemStack frame = new ItemStack(Material.GRAY_STAINED_GLASS_PANE);
        ItemMeta fmeta = frame.getItemMeta();
        fmeta.setDisplayName(ChatColor.DARK_GRAY + "_");
        fmeta.setLore(List.of(" "));
        frame.setItemMeta(fmeta);

        for (int i : new int[]{1, 2, 3, 4, 5, 6, 7, 8, 9, 11, 13, 15, 17, 18, 20, 22, 24, 26, 28, 29, 30, 31, 32, 33, 34, 35}) {
            inv.setItem(i, frame);
        }

        ItemStack back = new ItemStack(main.getHead("76ebaa41d1d405eb6b60845bb9ac724af70e85eac8a96a5544b9e23ad6c96c62"));
        ItemMeta backMeta = back.getItemMeta();
        backMeta.setDisplayName(ChatColor.GREEN + "Go Back To Main Menu");
        back.setItemMeta(backMeta);

        inv.setItem(27, back);

        player.openInventory(inv);
    }
    public String getTitle() { return title; }

}
