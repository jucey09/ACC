package org.powell.ACC.guis;

import dev.triumphteam.gui.builder.item.ItemBuilder;
import dev.triumphteam.gui.guis.Gui;
import dev.triumphteam.gui.guis.GuiItem;
import dev.triumphteam.gui.guis.PaginatedGui;
import net.kyori.adventure.text.Component;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.inventory.meta.SkullMeta;
import org.powell.ACC.ACC;

import java.util.List;

public class PlayerManagerGui {
    private final ACC main;

    public PlayerManagerGui(ACC main) {
        this.main = main;
    }

    String title = ChatColor.DARK_AQUA + "ACC: Player Manager";

    public void openGUI(Player player) {
        PaginatedGui gui = Gui.paginated()
                .title(Component.text(title))
                .rows(6)
                .pageSize(28)
                .create();

        //CLOSE
        ItemStack closebutton = new ItemStack(Material.RED_STAINED_GLASS_PANE);
        ItemMeta closemeta = closebutton.getItemMeta();
        closemeta.setDisplayName(ChatColor.RED + "Close Button");
        closemeta.setLore(List.of(""));
        closebutton.setItemMeta(closemeta);

        GuiItem close = ItemBuilder.from(closebutton).asGuiItem();

        gui.setItem(0, close);

        //FRAME
        ItemStack frame = new ItemStack(Material.GRAY_STAINED_GLASS_PANE);
        ItemMeta fmeta = frame.getItemMeta();
        fmeta.setDisplayName(ChatColor.GRAY + "_");
        fmeta.setLore(List.of(""));
        frame.setItemMeta(fmeta);

        GuiItem frames = ItemBuilder.from(frame).asGuiItem();

        for (int i : new int[]{1, 2, 3, 4, 5, 6, 7, 8, 9, 17, 18, 26, 27, 35, 36, 44, 46, 47, 48, 49, 50, 51, 52}) {
            gui.setItem(i, frames);
        }

        //PLAYERS
        for (Player all : Bukkit.getServer().getOnlinePlayers()) {

            ItemStack players = new ItemStack(Material.PLAYER_HEAD);
            SkullMeta playersMeta = (SkullMeta) players.getItemMeta();
            playersMeta.setOwningPlayer(all);
            playersMeta.setDisplayName(all.getName());
            players.setItemMeta(playersMeta);

            GuiItem all_players = ItemBuilder.from(players).asGuiItem();
            gui.addItem(all_players);

        }

        ItemStack back = new ItemStack(main.getHead("76ebaa41d1d405eb6b60845bb9ac724af70e85eac8a96a5544b9e23ad6c96c62"));
        ItemMeta backMeta = back.getItemMeta();
        backMeta.setDisplayName(ChatColor.GREEN + "Go Back To Main Menu");
        back.setItemMeta(backMeta);

        GuiItem backbutton = ItemBuilder.from(back).asGuiItem();

        gui.setItem(49, backbutton);

        //PAGE BUTTONS
        gui.setItem(45, ItemBuilder.from(Material.ARROW).setName("Previous").asGuiItem(event -> gui.previous()));
        gui.setItem(53, ItemBuilder.from(Material.ARROW).setName("Next").asGuiItem(event -> gui.next()));

        gui.open(player);
    }

    public String getTitle() {
        return title;
    }
}
