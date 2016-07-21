package me.speedwreckers.listeners;

import org.bukkit.GameMode;
import org.bukkit.Material;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import me.speedwreckers.thetowers.TheTowers;

public class JoinListener implements Listener {

	private TheTowers plugin;
	private FileConfiguration config;
	
	public JoinListener(TheTowers plugin) {
		this.plugin = plugin;
		this.config = plugin.getConfig();
	}
	
	
	@EventHandler
	public void onPlayerConnect(PlayerJoinEvent e) {
		Player p = e.getPlayer();
		
		p.setGameMode(GameMode.ADVENTURE);
		
		ItemStack kits = new ItemStack(Material.matchMaterial(config.getConfigurationSection("Data.MenuObjects.Kits").getString("affiliated_object")));
		ItemStack teams = new ItemStack(Material.matchMaterial(config.getConfigurationSection("Data.MenuObjects.Teams").getString("affiliated_object")), 1, (byte) 15);
		
		ItemMeta kitsM = kits.getItemMeta();
		ItemMeta teamsM = teams.getItemMeta();
		
		kitsM.setDisplayName(config.getConfigurationSection("Data.MenuObjects.Kits").getString("name"));
		teamsM.setDisplayName(config.getConfigurationSection("Data.MenuObjects.Teams").getString("name"));
		
		kits.setItemMeta(kitsM);
		teams.setItemMeta(teamsM);
		
		p.getInventory().setItem(2, kits);
		p.getInventory().setItem(6, teams);
	}
	
}
