package me.speedwreckers.commands;

import java.util.Collection;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import me.speedwreckers.thetowers.TheTowers;

public class StartCommand implements CommandExecutor{

	private TheTowers plugin;
	
	public StartCommand(TheTowers plugin) {
		this.plugin = plugin;
	}
	
	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
		
		try {
			Collection <? extends Player> players = sender.getServer().getOnlinePlayers();
			
			for(Player p : players) {
				
			}
			
			
		} catch (Exception exc){
			
		}
		
		return false;
	}

}
