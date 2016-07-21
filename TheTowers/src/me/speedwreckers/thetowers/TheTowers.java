package me.speedwreckers.thetowers;

import java.util.logging.Logger;

import org.bukkit.plugin.PluginManager;
import org.bukkit.plugin.java.JavaPlugin;

import me.speedwreckers.commands.StartCommand;
import me.speedwreckers.listeners.JoinListener;
import me.speedwreckers.listeners.MenuListener;

public class TheTowers extends JavaPlugin {

	public Logger log;
	public PluginManager pm;
	
	public StartCommand startCom;
	
	@Override
	public void onEnable() {
		
		this.log = this.getLogger();
		this.pm = this.getServer().getPluginManager();
		
		this.getConfig().options().copyDefaults(true);
		this.saveConfig();
		
		pm.registerEvents(new MenuListener(this), this);
		pm.registerEvents(new JoinListener(this), this);
		
		this.startCom = new StartCommand(this);
		
		this.getCommand("start").setExecutor(startCom);
	}
	
	@Override
	public void onDisable() {
		
	}
	
}
