package me.speedwreckers.listeners;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import me.speedwreckers.managers.KitManager;
import me.speedwreckers.thetowers.TheTowers;

public class MenuListener implements Listener {
	
	private TheTowers plugin;
	private FileConfiguration config;
	
	public MenuListener(TheTowers plugin) {
		this.plugin = plugin;
		this.config = plugin.getConfig();
	}

	
	
	@EventHandler
	public void onClickCompass(PlayerInteractEvent e) {
		try {
			String name = config.getConfigurationSection("Data.MenuObjects.Jeux").getString("name");
			Material matS = Material.matchMaterial(config.getConfigurationSection("Data.MenuObjects.Jeux").getString("affiliated_object"));
			
			if(e.getItem().getItemMeta().getDisplayName().equalsIgnoreCase(name) && e.getItem().getType() == matS) {
				Player p = e.getPlayer();
				if(e.getAction() == Action.RIGHT_CLICK_AIR) {
					Inventory inv = Bukkit.createInventory(null, 27, config.getConfigurationSection("Data.MenuObjects.Jeux").getString("menu_name"));	//	27 = taille de l'inventaire
					ItemStack banner = new ItemStack(Material.BANNER, 1, (byte) 5);			//	1 = nb d'objets | (byte) 5 = variante de l'objet
					ItemMeta bannerM = banner.getItemMeta();								//	
					bannerM.setDisplayName(ChatColor.YELLOW + "The Towers !");				//	
					banner.setItemMeta(bannerM);
					
					inv.setItem(13, banner);	// 13 = place de l'item dans l'inventaire
					
					
					p.openInventory(inv);
				}
			}
		} catch (NullPointerException exc) {
			
		}
	}
	
	public void onClickBanner(PlayerInteractEvent e) {
		try {
			String name = config.getConfigurationSection("Data.MenuObjects.Teams").getString("name");
			Material matS = Material.matchMaterial(config.getConfigurationSection("Data.MenuObjects.Teams").getString("affiliated_object"));
			
			if(e.getItem().getItemMeta().getDisplayName().equalsIgnoreCase(name) && e.getItem().getType() == matS) {
				Player p = e.getPlayer();
				if(e.getAction() == Action.RIGHT_CLICK_AIR) {
					Inventory inv = Bukkit.createInventory(null, 27, config.getConfigurationSection("Data.MenuObjects.Teams").getString("menu_name"));	//	27 = taille de l'inventaire
					ItemStack bannerBlue = new ItemStack(Material.BANNER, 1, (byte) 4);			//	1 = nb d'objets | (byte) 5 = variante de l'objet
					ItemStack bannerRed = new ItemStack(Material.BANNER, 1, (byte) 1);
					ItemMeta bannerBlueM = bannerBlue.getItemMeta();
					ItemMeta bannerRedM = bannerRed.getItemMeta(); //	
					bannerBlueM.setDisplayName(ChatColor.BLUE + "Equipe rouge");
					bannerRedM.setDisplayName(ChatColor.RED + "Equipe Bleue"); //	
					bannerBlue.setItemMeta(bannerBlueM);
					bannerRed.setItemMeta(bannerRedM);
					
					inv.setItem(11, bannerBlue);	// 13 = place de l'item dans l'inventaire
					inv.setItem(15, bannerRed);
					
					p.openInventory(inv);
				}
			}
		} catch (NullPointerException exc) {
			
		}
	}
	
	@EventHandler
	public void onClickSword(PlayerInteractEvent e) {
		try { 
			String name = config.getConfigurationSection("Data.MenuObjects.Kits").getString("name");
			Material matS = Material.matchMaterial(config.getConfigurationSection("Data.MenuObjects.Kits").getString("affiliated_object"));
			
			
			if(e.getItem().getItemMeta().getDisplayName().equalsIgnoreCase(name) && e.getItem().getType() == matS) {
				Player p = e.getPlayer();
				
				if(e.getAction() == Action.RIGHT_CLICK_AIR) {
					
					
					String menu_name = config.getConfigurationSection("Data.MenuObjects.Kits").getString("menu_name");
					int menu_size = config.getConfigurationSection("Data.MenuObjects.Kits").getInt("menu_size");
					
					Inventory inv = Bukkit.createInventory(null, menu_size, menu_name);
					
					
					int i=0;
					
					for(String s : config.getConfigurationSection("Kits").getKeys(false)) {
						
						i++;
						
						Material mat = Material.matchMaterial(config.getConfigurationSection("Kits." + s).getString("affiliated_object"));						
						
						ItemStack item = new ItemStack(mat);
						ItemMeta itemM = item.getItemMeta();
						
						itemM.setDisplayName(ChatColor.YELLOW + config.getConfigurationSection("Kits." + s).getString("name"));
						
						item.setItemMeta(itemM);
						
						inv.setItem(3*i, item);
					}
					
					
					p.openInventory(inv);
				}
			}
		} catch (NullPointerException exc) {
			
		}
	}
	
	
	
	@EventHandler
	public void onClickItemInInventory(InventoryClickEvent e) {
		try {
			Inventory inv = e.getClickedInventory();
			String invTitle = inv.getTitle();
			
			if (invTitle == "Menu de navigation") {
				Player p = (Player) inv.getViewers().get(0);
				
				if (e.getCurrentItem().getType() == Material.WOOD_AXE) {
					
					plugin.getServer().broadcastMessage("Le code marche et j'aime les saucisses");
					
					p.closeInventory();
					}
			} else if (invTitle == "Menu des kits") {
				Player p = (Player) inv.getViewers().get(0);
				
				for(String s : config.getConfigurationSection("Kits").getKeys(false)) {
					
					Material mat = Material.matchMaterial(config.getConfigurationSection("Kits." + s).getString("affiliated_object"));
					
					if (e.getCurrentItem().getType() == mat) {
						p.closeInventory();
					}
				}
				
			}
		} catch (NullPointerException exc) {
				
		}
	}
	
	
	
}