package org.powell.ACC.commands;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.command.ConsoleCommandSender;
import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.event.Listener;
import org.bukkit.event.player.AsyncPlayerChatEvent;
import org.bukkit.event.server.BroadcastMessageEvent;
import org.bukkit.plugin.Plugin;
import org.bukkit.plugin.PluginManager;
import org.powell.ACC.ACC;

public class ToggleChatCommand implements CommandExecutor, Listener {
    private ACC main;
    private static boolean chatEnabled = true; // Static variable to hold chat state across all instances

    public ToggleChatCommand(ACC main) {
        this.main = main;
    }

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if (command.getName().equalsIgnoreCase("enablechat")) {
            if (sender instanceof ConsoleCommandSender) {
                chatEnabled = true;
                Bukkit.broadcastMessage(ChatColor.GREEN + "Chat is now enabled.");
                return true;
            } else {
                sender.sendMessage(ChatColor.RED + "You must use ACC to enable chat.");
                return false;
            }
        } else if (command.getName().equalsIgnoreCase("disablechat")) {
            if (sender instanceof ConsoleCommandSender) {
                chatEnabled = false;
                Bukkit.broadcastMessage(ChatColor.RED + "Chat is now disabled.");
                return true;
            } else {
                sender.sendMessage(ChatColor.RED + "You must use ACC to disable  chat.");
                return false;
            }
        } else if (command.getName().equalsIgnoreCase("clearchat")) {
            if (sender instanceof ConsoleCommandSender) {
                for (int i = 0; i < 100; i++) {
                    Bukkit.getServer().broadcastMessage(" ");
                }
                Bukkit.broadcastMessage(ChatColor.DARK_AQUA + "Chat has been cleared.");
            } else {
                sender.sendMessage(ChatColor.RED + "You must use ACC to clear chat.");
                return true;
            }
        }
        return false;
    }

    @EventHandler()
    public void onPlayerChat(AsyncPlayerChatEvent e) {
        if (!chatEnabled) {
            e.setCancelled(true);
            e.getPlayer().sendMessage(ChatColor.RED + "Chat is currently disabled.");
        }
    }

    public static boolean isPluginInstalled(String pluginName) {
        PluginManager pluginManager = Bukkit.getServer().getPluginManager();
        Plugin plugin = pluginManager.getPlugin(pluginName);

        return plugin != null && plugin.isEnabled();
    }

    @EventHandler
    public void onBroadcast(BroadcastMessageEvent event) {
        if (!event.getMessage().equals(ChatColor.DARK_AQUA + "Chat has been cleared.") && !event.getMessage().equals(" ") && !event.getMessage().equals(ChatColor.RED + "Chat is now disabled.")) {
            if (!chatEnabled && isPluginInstalled("Rankify")) {
                event.setCancelled(true);
            }
        }
    }

}
