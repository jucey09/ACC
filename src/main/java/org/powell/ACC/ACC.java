package org.powell.ACC;

import org.bukkit.plugin.java.JavaPlugin;
import org.powell.ACC.guis.MainMenu;

public final class ACC extends JavaPlugin {
private MainMenu mainMenu;
    @Override
    public void onEnable() {
        // Plugin startup logic

        mainMenu = new MainMenu();

        getCommand("acc").setExecutor(new AACCommand(this));
    }

    public MainMenu getMainMenu() { return mainMenu; }
}
