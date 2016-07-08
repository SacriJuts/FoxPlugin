package me.foxley.commands;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;

import me.foxley.foxplugin.FoxPlugin;

public class CommandPing implements CommandExecutor{

	private FoxPlugin plugin;
	
	public CommandPing(FoxPlugin plugin) {
		this.plugin = plugin;
	}
	
	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
		
		plugin.getLogger().warning("J'ai pété");
		
		return false;
	}

}
