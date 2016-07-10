package me.foxley.listeners;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import me.foxley.foxplugin.FoxPlugin;

public class Menu implements Listener {
	
	private FoxPlugin plugin;
	
	public Menu(FoxPlugin plugin) {
		this.plugin = plugin;
	}

	
	@EventHandler
	public void onClickItemInInventory(InventoryClickEvent e) {
		try {
			Inventory inv = e.getClickedInventory();
			String invTitle = inv.getTitle();
			if (invTitle == "Menu des kits") {
				Player p = (Player) inv.getViewers().get(0);
				
				if (e.getCurrentItem().getType() == Material.WOOD_SWORD) {
					// set kit
					plugin.getServer().broadcastMessage("Le code marche et j'aime les saucisses");
					
					p.closeInventory();
					}
			} else if (invTitle == "Menu de navigation") {
				Player p = (Player) inv.getViewers().get(0);
				if (e.getCurrentItem().getType() == Material.BANNER) {
					
					plugin.getServer().broadcastMessage("Le code marche et j'aime les saucisses");
					
					p.closeInventory();
				}
				
			}
		} catch (NullPointerException exc) {
				
		}
	}
	
	
	@EventHandler
	public void onClickCompass(PlayerInteractEvent e) {
		try {
			if(e.getItem().getType().getItemMeta().getDisplayName() == "Jeux") {
				Player p = e.getPlayer();
				if(e.getAction() == Action.RIGHT_CLICK_AIR) {
					Inventory inv = Bukkit.createInventory(null, 27, "Menu de navigation");	//	27 = taille de l'inventaire
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
	
	@EventHandler
	public void onClickSword(PlayerInteractEvent e) {
		try { 
			if(e.getItem().getType().getItemMeta().getDisplayName() == "Kits"") {
				Player p = e.getPlayer();
				if(e.getAction() == Action.RIGHT_CLICK_AIR) {
					Inventory inv = Bukkit.createInventory(null, 27, "Menu des kits");
					ItemStack woodsword = new ItemStack(Material.WOOD_SWORD, 1);
					ItemMeta woodswordM = woodsword.getItemMeta();
					woodswordM.setDisplayName(ChatColor.YELLOW + "Par défaut");
					woodsword.setItemMeta(woodswordM);
					
					inv.setItem(13, woodsword);
					
					p.openInventory(inv);
				}
			}
		} catch (NullPointerException exc) {
			
		}
	}
	
}
