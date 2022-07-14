package me.spexon.minecraftplugin;

import org.bukkit.plugin.java.JavaPlugin;

public final class MinecraftPlugin extends JavaPlugin {

  @Override
  public void onEnable() {
    // Plugin startup logic
    System.out.println("Hello World!");
    getServer().getPluginManager().registerEvents(new PlayerMovementListener(), this);
    getServer().getPluginCommand("mark-location").setExecutor(new TowerCommandExecutor());
    getServer().getPluginCommand("continuous-wither-spawn").setExecutor(new WitherSpawnExecutor());
    saveDefaultConfig();
  }

  @Override
  public void onDisable() {
    // Plugin shutdown logic
  }
}
