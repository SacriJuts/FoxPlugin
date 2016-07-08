package me.foxley.listeners;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import me.foxley.foxplugin.FoxPlugin;

public class Menu implements Listener {
	
	public Menu(FoxPlugin plugin) {
		
	}

	
	
	@EventHandler
	public void onClickCompass(PlayerInteractEvent e) {
		if(e.getItem().getType() == Material.COMPASS) {
			Player p = e.getPlayer();
			if(e.getAction() == Action.RIGHT_CLICK_AIR) {
				Inventory inv = Bukkit.createInventory(null, 18, "Menu de navigation");
				ItemStack banner = new ItemStack(Material.BANNER, 1, (byte) 5);
				ItemMeta bannerM = banner.getItemMeta();
				bannerM.setDisplayName(ChatColor.YELLOW + "The Towers !");
				banner.setItemMeta(bannerM);
				
				inv.setItem(5, banner);
				
				p.openInventory(inv);
			}
		}
		
	}
	
	@EventHandler
	public void onClickSword(PlayerInteractEvent e) {
		if(e.getItem().getType() == Material.DIAMOND_SWORD) {
			Player p = e.getPlayer();
			if(e.getAction() == Action.RIGHT_CLICK_AIR) {
				Inventory inv = Bukkit.createInventory(null, 18, "Menu des kits");
				ItemStack woodsword = new ItemStack(Material.WOOD_SWORD, 1);
				ItemMeta woodswordM = woodsword.getItemMeta();
				woodswordM.setDisplayName(ChatColor.YELLOW + "Par défaut");
				woodsword.setItemMeta(woodswordM);
				
				inv.setItem(5, woodsword);
				
				p.openInventory(inv);
			}
		}
		
	}
	
}
