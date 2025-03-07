package org.powell.ACC;

import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.SkullMeta;
import org.bukkit.plugin.java.JavaPlugin;
import org.bukkit.profile.PlayerProfile;
import org.bukkit.profile.PlayerTextures;
import org.powell.ACC.guis.*;
import org.powell.ACC.listeners.ACCListener;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.UUID;

public final class ACC extends JavaPlugin {
private MainMenu mainMenu;
private ChatManagerGui chatManager;
private GamemodeSwitcherGui gamemodeSwitcher;
private MiscGui misc;
private OPItemsGui opItems;
private PlayerManagerGui playerManager;
private PlayerTeleportationGui playerTeleportation;
private ServerManagerGui serverManager;
private TimeWeatherGui timeWeather;

    @Override
    public void onEnable() {
        // Plugin startup logic

        mainMenu = new MainMenu(this);
        chatManager = new ChatManagerGui(this);
        gamemodeSwitcher = new GamemodeSwitcherGui(this);
        misc = new MiscGui(this);
        opItems = new OPItemsGui(this);
        playerManager = new PlayerManagerGui(this);
        playerTeleportation = new PlayerTeleportationGui(this);
        serverManager = new ServerManagerGui(this);
        timeWeather = new TimeWeatherGui(this);

        getCommand("acc").setExecutor(new AACCommand(this));

        Bukkit.getPluginManager().registerEvents(new ACCListener(this), this);
    }

    public MainMenu getMainMenu() { return mainMenu; }
    public ChatManagerGui getChatManager() { return chatManager; }
    public GamemodeSwitcherGui getGamemodeSwitcher() { return gamemodeSwitcher; }
    public MiscGui getMisc() { return misc; }
    public OPItemsGui getOPItems() { return opItems; }
    public PlayerManagerGui getPlayerManager() { return playerManager; }
    public PlayerTeleportationGui getPlayerTeleportation() { return playerTeleportation; }
    public ServerManagerGui getServerManager() { return serverManager; }
    public TimeWeatherGui getTimeWeather() { return timeWeather; }

    public ItemStack getHead(String texture) {
        ItemStack head = new ItemStack(Material.PLAYER_HEAD);
        SkullMeta meta = (SkullMeta) head.getItemMeta();
        PlayerProfile profile = Bukkit.getServer().createPlayerProfile(UUID.randomUUID());
        PlayerTextures textures = profile.getTextures();
        try {
            textures.setSkin(new URL("http://textures.minecraft.net/texture/" + texture));
        } catch (MalformedURLException e) {
            e.printStackTrace();
        }
        profile.setTextures(textures);
        meta.setOwnerProfile(profile);
        head.setItemMeta(meta);
        return head;
    }
}
