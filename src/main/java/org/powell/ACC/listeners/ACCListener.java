package org.powell.ACC.listeners;

import org.bukkit.*;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.inventory.meta.SkullMeta;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;
import org.powell.ACC.ACC;

import java.util.Calendar;
import java.util.List;
import java.util.Random;

public class ACCListener implements Listener {
    private final ACC main;

    public ACCListener(ACC main) {
        this.main = main;
    }

    @EventHandler
    public void onClick(InventoryClickEvent e) {
        ItemStack close = new ItemStack(Material.RED_STAINED_GLASS_PANE);
        ItemMeta closeMeta = close.getItemMeta();
        closeMeta.setDisplayName(ChatColor.RED + "Close");
        close.setItemMeta(closeMeta);

        Player player = (Player) e.getWhoClicked();
        if (e.getClickedInventory() != null && e.getView().getTitle().equals(main.getMainMenu().getTitle())) {
            e.setCancelled(true);
            switch (e.getSlot()) {
                case 0:
                    if (e.getCurrentItem() == close) {
                        e.setCancelled(true);
                        player.closeInventory();
                    }
                    break;
                case 10:
                    e.setCancelled(true);
                    main.getPlayerManager().openGUI(player);
                    break;
                case 12:
                    main.getServerManager().openGui(player);
                    break;
                case 14:
                    e.setCancelled(true);
                    main.getGamemodeSwitcher().openGui(player);
                    break;
                case 16:
                    e.setCancelled(true);
                    main.getTimeWeather().openGui(player);
                    break;
                case 28:
                    e.setCancelled(true);
                    main.getChatManager().openGui(player);
                    break;
                case 30:
                    main.getPlayerTeleportation().openGUI(player);
                    break;
                case 32:
                    e.setCancelled(true);
                    main.getOPItems().openGui(player);
                    break;
                case 34:
                    main.getMisc().openGui(player);
                default:
                    e.setCancelled(true);
                    break;
            }
        }
        if (e.getCurrentItem() != null && e.getView().getTitle().equals(main.getGamemodeSwitcher().getTitle())) {
            switch (e.getSlot()) {
                case 0:
                    if (e.getCurrentItem() == close) {
                        e.setCancelled(true);
                        player.closeInventory();
                    }
                    break;
                case 10:
                    e.setCancelled(true);
                    player.setGameMode(GameMode.SURVIVAL);
                    player.sendMessage(ChatColor.GREEN + "You are survival mode.");
                    player.closeInventory();
                    break;
                case 12:
                    e.setCancelled(true);
                    player.setGameMode(GameMode.CREATIVE);
                    player.sendMessage(ChatColor.GREEN + "You are creative mode.");
                    player.closeInventory();
                    break;
                case 14:
                    e.setCancelled(true);
                    player.setGameMode(GameMode.SPECTATOR);
                    player.sendMessage(ChatColor.GREEN + "You are spectator mode.");
                    player.closeInventory();
                    break;
                case 16:
                    e.setCancelled(true);
                    player.setGameMode(GameMode.ADVENTURE);
                    player.sendMessage(ChatColor.GREEN + "You are adventure mode.");
                    player.closeInventory();
                    break;
                case 18:
                    main.getMainMenu().openMenu(player);
                    break;
                default:
                    e.setCancelled(true);
                    break;
            }
        }
        if (e.getCurrentItem() != null && e.getView().getTitle().equals(main.getChatManager().getTitle())) {
            switch (e.getSlot()) {
                case 0:
                    if (e.getCurrentItem() == close) {
                        e.setCancelled(true);
                        player.closeInventory();
                    }
                    break;
                case 11:
                    //enable chat
                    e.setCancelled(true);
                    Bukkit.getServer().dispatchCommand(Bukkit.getConsoleSender(), "enablechat");
                    player.closeInventory();
                    break;
                case 13:
                    //disable chat
                    e.setCancelled(true);
                    Bukkit.getServer().dispatchCommand(Bukkit.getConsoleSender(), "disablechat");
                    player.closeInventory();
                    break;
                case 15:
                    //clear chat
                    e.setCancelled(true);
                    Bukkit.getServer().dispatchCommand(Bukkit.getConsoleSender(), "clearchat");
                    player.closeInventory();
                    break;
                case 18:
                    main.getMainMenu().openMenu(player);
                    break;
                default:
                    e.setCancelled(true);
                    break;
            }
        }
        if (e.getCurrentItem() != null && e.getView().getTitle().equals(main.getTimeWeather().getTitle())) {
            switch (e.getSlot()) {
                case 0:
                    if (e.getCurrentItem() == close) {
                        e.setCancelled(true);
                        player.closeInventory();
                    }
                    break;
                case 10:
                    e.setCancelled(true);
                    player.performCommand("time set day");
                    player.sendMessage(ChatColor.GREEN + "You set time to sunrise.");
                    player.closeInventory();
                    break;
                case 12:
                    e.setCancelled(true);
                    player.performCommand("time set noon");
                    player.sendMessage(ChatColor.GREEN + "You set time to noon.");
                    player.closeInventory();
                    break;
                case 14:
                    e.setCancelled(true);
                    player.performCommand("time set night");
                    player.sendMessage(ChatColor.GREEN + "You set time to sunset.");
                    player.closeInventory();
                    break;
                case 16:
                    e.setCancelled(true);
                    player.performCommand("time set midnight");
                    player.sendMessage(ChatColor.GREEN + "You set time to night.");
                    player.closeInventory();
                    break;
                case 19:
                    e.setCancelled(true);
                    player.performCommand("weather clear");
                    player.closeInventory();
                    break;
                case 21:
                    e.setCancelled(true);
                    player.performCommand("weather rain");
                    player.closeInventory();
                    break;
                case 23:
                    e.setCancelled(true);
                    player.performCommand("weather thunder");
                    player.closeInventory();
                    break;
                case 25:
                    e.setCancelled(true);
                    player.closeInventory();
                    Random random = new Random();
                    int number = random.nextInt(3) + 1;
                    if (number == 1) {
                        player.performCommand("weather clear");
                    } else if (number == 2) {
                        player.performCommand("weather rain");
                    } else if (number == 3) {
                        player.performCommand("weather thunder");
                    }
                    break;
                case 27:
                    e.setCancelled(true);
                    main.getMainMenu().openMenu(player);
                    break;
                default:
                    e.setCancelled(true);
                    break;
            }
        }
        if (e.getCurrentItem() != null && e.getView().getTitle().equals(main.getOPItems().getTitle())) {
            switch (e.getSlot()) {
                case 0:
                    if (e.getCurrentItem() == close) {
                        e.setCancelled(true);
                        player.closeInventory();
                    }
                    break;
                case 10:
                    e.setCancelled(true);
                    player.getInventory().addItem(main.getOPItems().getOPSword());
                    player.closeInventory();
                    break;
                case 12:
                    e.setCancelled(true);
                    player.getInventory().addItem(main.getOPItems().getOPPic());
                    player.closeInventory();
                    break;
                case 14:
                    e.setCancelled(true);
                    player.getInventory().addItem(main.getOPItems().getOPAxe());
                    player.closeInventory();
                    break;
                case 16:
                    e.setCancelled(true);
                    player.getInventory().addItem(main.getOPItems().getOPStick());
                    player.closeInventory();
                    break;
                case 19:
                    e.setCancelled(true);
                    player.getInventory().addItem(main.getOPItems().getOPHelmet());
                    player.closeInventory();
                    break;
                case 21:
                    e.setCancelled(true);
                    player.getInventory().addItem(main.getOPItems().getOPChestplate());
                    player.closeInventory();
                    break;
                case 23:
                    e.setCancelled(true);
                    player.getInventory().addItem(main.getOPItems().getOPLeggings());
                    player.closeInventory();
                    break;
                case 25:
                    e.setCancelled(true);
                    player.getInventory().addItem(main.getOPItems().getOPBoots());
                    player.closeInventory();
                    break;
                case 27:
                    e.setCancelled(true);
                    main.getMainMenu().openMenu(player);
                    break;
                default:
                    e.setCancelled(true);
                    break;
            }
        }
        if (e.getCurrentItem() != null && e.getView().getTitle().equals(main.getPlayerManager().getTitle())) {
            ItemStack clickedItem = e.getCurrentItem();
            e.setCancelled(true);

            if (e.getCurrentItem().getType() == Material.PLAYER_HEAD) {

                String player_name = clickedItem.getItemMeta().getDisplayName();
                Inventory inv = Bukkit.createInventory(player, 27, ChatColor.DARK_AQUA + "ACC: " + player_name);

                inv.setItem(0, close);

                ItemStack p = new ItemStack(Material.WHITE_STAINED_GLASS_PANE, 90);
                ItemMeta pmeta = p.getItemMeta();
                pmeta.setDisplayName(player_name);
                pmeta.setMaxStackSize(1);
                p.setItemMeta(pmeta);

                inv.setItem(1, p);

                ItemStack kick = new ItemStack(main.getHead("a9dbed522e8de1a681dddd37854ee4267efc48b59917f9a9acb420d6fdb9"));
                ItemMeta kmmeta = kick.getItemMeta();
                kmmeta.setDisplayName(ChatColor.DARK_AQUA + "Kick Player");
                kick.setItemMeta(kmmeta);

                inv.setItem(11, kick);

                ItemStack ban = new ItemStack(main.getHead("be0fd10199e8e4fcdabcae4f85c85918127a7c5553ad235f01c56d18bb9470d3"));
                ItemMeta bmmeta = ban.getItemMeta();
                bmmeta.setDisplayName(ChatColor.DARK_RED + "Ban Player");
                ban.setItemMeta(bmmeta);

                inv.setItem(13, ban);

                ItemStack tban = new ItemStack(main.getHead("5d9b712cdf9147759eba4d5573cdb63833b44f3ace4fcb66ea3ab147207da3ff"));
                ItemMeta tnmmeta = tban.getItemMeta();
                tnmmeta.setDisplayName(ChatColor.RED + "Temp Ban Player for Three days");
                tban.setItemMeta(tnmmeta);

                inv.setItem(15, tban);

                ItemStack frame = new ItemStack(Material.GRAY_STAINED_GLASS_PANE);
                ItemMeta fmeta = frame.getItemMeta();
                fmeta.setDisplayName(ChatColor.GRAY + "_");
                fmeta.setLore(List.of(""));
                frame.setItemMeta(fmeta);

                ItemStack back = new ItemStack(main.getHead("76ebaa41d1d405eb6b60845bb9ac724af70e85eac8a96a5544b9e23ad6c96c62"));
                ItemMeta backMeta = back.getItemMeta();
                backMeta.setDisplayName(ChatColor.GREEN + "Go Back To Player Manager");
                back.setItemMeta(backMeta);

                inv.setItem(18, back);


                for (int i : new int[]{2, 3, 4, 5, 6, 7, 8, 9, 10, 12, 14, 16, 17, 19, 20, 21, 22, 23, 24, 25, 26}) {
                    inv.setItem(i, frame);
                }

                if (e.getSlot() == 49) {
                    e.setCancelled(true);
                    main.getMainMenu().openMenu(player);
                } else if (e.getSlot() == 0) {
                    if (e.getCurrentItem() == close) {
                        e.setCancelled(true);
                        player.closeInventory();
                    }
                } else {
                    player.openInventory(inv);
                }
            }
        }
        Inventory inv = e.getInventory();
        if (inv.getItem(1) != null) {
            if (inv.getItem(1).getAmount() == 90) {
                String pname = inv.getItem(1).getItemMeta().getDisplayName();
                if (inv.getSize() == 27 && e.getCurrentItem() != null && e.getView().getTitle().equals(ChatColor.DARK_AQUA + "ACC: " + pname)) {
                    e.setCancelled(true);
                    Player target = Bukkit.getPlayer(pname);
                    switch (e.getRawSlot()) {
                        case 0:
                            if (e.getCurrentItem() == close) {
                                e.setCancelled(true);
                                player.closeInventory();
                            }
                            break;
                        case 11://kick
                            e.setCancelled(true);
                            target.kickPlayer(ChatColor.RED + "You have been kicked by a Moderator!");
                            player.closeInventory();
                            break;
                        case 13://ban
                            e.setCancelled(true);
                            target.kickPlayer(ChatColor.RED + "You were banned by a Moderator!");
                            Bukkit.getBanList(BanList.Type.NAME).addBan(target.getName(), ChatColor.RED + "You were banned by a Moderator!", null, null);
                            player.closeInventory();
                            break;
                        case 15://tempban
                            e.setCancelled(true);
                            Calendar cal = Calendar.getInstance();
                            cal.add(Calendar.HOUR, 72);
                            target.kickPlayer(ChatColor.RED + "You were banned by a Moderator!");
                            Bukkit.getBanList(BanList.Type.NAME).addBan(target.getName(), ChatColor.RED + "You were banned by a Moderator!", cal.getTime(), null);
                            player.closeInventory();
                            break;
                        case 18:
                            main.getPlayerManager().openGUI(player);
                            break;
                        default:
                            e.setCancelled(true);
                            break;
                    }
                }
            }
        }
        if (e.getCurrentItem() != null && e.getView().getTitle().equals(main.getPlayerTeleportation().getTitle())) {
            ItemStack clickedItem = e.getCurrentItem();
            e.setCancelled(true);

            if (e.getCurrentItem().getType() == Material.PLAYER_HEAD) {

                String player_name = clickedItem.getItemMeta().getDisplayName();
                Inventory inv2 = Bukkit.createInventory(player, 27, ChatColor.DARK_AQUA + "ACC Teleport: " + player_name);

                //CLOSE
                inv2.setItem(0, close);

                ItemStack p = new ItemStack(Material.WHITE_STAINED_GLASS_PANE, 90);
                ItemMeta pmeta = p.getItemMeta();
                pmeta.setDisplayName(player_name);
                pmeta.setMaxStackSize(1);
                p.setItemMeta(pmeta);

                inv2.setItem(1, p);

                Player target = Bukkit.getPlayer(player_name);

                ItemStack to = new ItemStack(Material.PLAYER_HEAD);
                SkullMeta tMeta = (SkullMeta) to.getItemMeta();
                tMeta.setOwningPlayer(target);
                tMeta.setDisplayName(ChatColor.DARK_AQUA + "Teleport To Player");
                to.setItemMeta(tMeta);

                inv2.setItem(11, to);


                ItemStack from = new ItemStack(Material.PLAYER_HEAD);
                SkullMeta fMeta = (SkullMeta) from.getItemMeta();
                fMeta.setOwningPlayer(player);
                fMeta.setDisplayName(ChatColor.GREEN + "Teleport Player To You");
                from.setItemMeta(fMeta);

                inv2.setItem(15, from);

                ItemStack frame = new ItemStack(Material.GRAY_STAINED_GLASS_PANE);
                ItemMeta fmeta = frame.getItemMeta();
                fmeta.setDisplayName(ChatColor.GRAY + "_");
                fmeta.setLore(List.of(""));
                frame.setItemMeta(fmeta);

                ItemStack back = new ItemStack(main.getHead("76ebaa41d1d405eb6b60845bb9ac724af70e85eac8a96a5544b9e23ad6c96c62"));
                ItemMeta backMeta = back.getItemMeta();
                backMeta.setDisplayName(ChatColor.GREEN + "Go Back To Player Teleportation");
                back.setItemMeta(backMeta);

                inv2.setItem(18, back);


                for (int i : new int[]{2, 3, 4, 5, 6, 7, 8, 9, 10, 12, 13, 14, 16, 17, 19, 20, 21, 22, 23, 24, 25, 26}) {
                    inv2.setItem(i, frame);
                }

                if (e.getSlot() == 49) {
                    e.setCancelled(true);
                    main.getMainMenu().openMenu(player);
                } else if (e.getSlot() == 0) {
                    if (e.getCurrentItem() == close) {
                        e.setCancelled(true);
                        player.closeInventory();
                    }
                } else {
                    player.openInventory(inv2);
                }
            }
        }
        Inventory inv2 = e.getInventory();
        if (inv2.getItem(1) != null) {
            if (inv2.getItem(1).getAmount() == 90) {
                String pname = inv2.getItem(1).getItemMeta().getDisplayName();
                if (inv2.getSize() == 27 && e.getCurrentItem() != null && e.getView().getTitle().equals(ChatColor.DARK_AQUA + "ACC Teleport: " + pname)) {
                    e.setCancelled(true);
                    Player target = Bukkit.getPlayer(pname);
                    switch (e.getRawSlot()) {
                        case 0:
                            if (e.getCurrentItem() == close) {
                                e.setCancelled(true);
                                player.closeInventory();
                            }
                            break;
                        case 11://to
                            e.setCancelled(true);
                            player.teleport(target);
                            player.closeInventory();
                            break;
                        case 15://from
                            e.setCancelled(true);
                            target.teleport(player);
                            player.closeInventory();
                            break;
                        case 18:
                            main.getPlayerTeleportation().openGUI(player);
                            break;
                        default:
                            e.setCancelled(true);
                            break;
                    }
                }
            }
        }
        if (e.getCurrentItem() != null && e.getView().getTitle().equals(main.getServerManager().getTitle())) {
            switch (e.getSlot()) {
                case 0:
                    if (e.getCurrentItem() == close) {
                        e.setCancelled(true);
                        player.closeInventory();
                    }
                    break;
                case 11:
                    //reload server
                    e.setCancelled(true);
                    Bukkit.getServer().dispatchCommand(Bukkit.getConsoleSender(), "reload");
                    player.closeInventory();
                    break;
                case 15:
                    //stop server
                    e.setCancelled(true);
                    Bukkit.getServer().dispatchCommand(Bukkit.getConsoleSender(), "stop");
                    player.closeInventory();
                    break;
                case 18:
                    main.getMainMenu().openMenu(player);
                    break;
                default:
                    e.setCancelled(true);
                    break;
            }
        }
        if (e.getCurrentItem() != null && e.getView().getTitle().equals(main.getMisc().getTitle())) {
            switch (e.getSlot()) {
                case 0:
                    if (e.getCurrentItem() == close) {
                        e.setCancelled(true);
                        player.closeInventory();
                    }
                    break;
                case 11:
                    //TOTEM
                    e.setCancelled(true);

                    ItemStack totem = new ItemStack(Material.TOTEM_OF_UNDYING, 99);
                    ItemMeta enableMeta = totem.getItemMeta();
                    enableMeta.setDisplayName(ChatColor.BLUE + "Stack of Totems");
                    enableMeta.setMaxStackSize(99);
                    totem.setItemMeta(enableMeta);

                    player.getInventory().addItem(totem);
                    player.closeInventory();
                    break;
                case 13:
                    //INVINCIBLE
                    e.setCancelled(true);
                    PotionEffect potionEffect = new PotionEffect(PotionEffectType.RESISTANCE,  999999999, 255, true, false);
                    player.addPotionEffect(potionEffect);
                    player.closeInventory();
                    break;
                case 15:
                    //UN INVINCIBLE
                    e.setCancelled(true);
                    player.removePotionEffect(PotionEffectType.RESISTANCE);
                    player.closeInventory();
                    break;
                case 18:
                    main.getMainMenu().openMenu(player);
                    break;
                default:
                    e.setCancelled(true);
                    break;
            }
        }
    }
}
