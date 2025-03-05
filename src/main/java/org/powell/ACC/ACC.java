package org.powell.ACC;

import org.bukkit.Bukkit;
import org.bukkit.plugin.java.JavaPlugin;
import org.powell.ACC.guis.MainMenu;
import org.powell.ACC.listeners.ACCListener;

public final class ACC extends JavaPlugin {
private MainMenu mainMenu;
    @Override
    public void onEnable() {
        // Plugin startup logic

        mainMenu = new MainMenu();

        getCommand("acc").setExecutor(new AACCommand(this));

        Bukkit.getPluginManager().registerEvents(new ACCListener(this), this);
    }

    public MainMenu getMainMenu() { return mainMenu; }
}
