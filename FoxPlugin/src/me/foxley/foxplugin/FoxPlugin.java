package me.foxley.foxplugin;

import java.util.logging.Logger;

import org.bukkit.plugin.PluginManager;
import org.bukkit.plugin.java.JavaPlugin;

import me.foxley.commands.CommandPing;
import me.foxley.listeners.Menu;

public class FoxPlugin extends JavaPlugin{

	public Logger log;
	public CommandPing ping;
	public PluginManager pm;
	
	@Override
	public void onEnable() {
		this.log = this.getLogger();
		this.pm = this.getServer().getPluginManager();
		
		this.getConfig().options().copyDefaults(true);
		this.saveConfig();
		
		pm.registerEvents(new Menu(this), this);
		
		this.ping = new CommandPing(this);
		
		getCommand("ping").setExecutor(ping);
		
		
		log.info("FoxPlugin started...");
	}
	
	@Override
	public void onDisable() {
		
	}
	
}

void Yolo() {
	
	
}
