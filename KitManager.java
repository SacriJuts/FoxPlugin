package me.foxley.towers;

import java.util.ArrayList;

import org.bukkit.Material;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;

public class KitManager {

	private Towers plugin;
	private Player player;
	private FileConfiguration config;
	private ArrayList<ItemStack> kit;
	
	public KitManager(Towers  plugin, Player p) {
		this.plugin = plugin;
		this.player = p;
		this.config = plugin.getConfig();
	}
	
	private void getKit(String name) {
		this.kit = new ArrayList<ItemStack>();
		
		
		//Récupère les armures dans le fichier config
		for(String s : config.getConfigurationSection("Kits." + name + ".Armor").getKeys(false)) {
			Material mat = Material.matchMaterial(s);
			int amount = config.getInt("Kits." + name + ".Armor." + s);
			
			if(mat == null) {
				try {
					String itemMC = config.getConfigurationSection("PersonnalItems." + s).getString("item");
					
					mat = Material.matchMaterial(itemMC);
					
					ItemStack personnalItem = new ItemStack(mat, amount);
					
					for(String ench : config.getConfigurationSection("PersonnalItems." + s + ".enchantment").getKeys(false)) {
						int levelEnchant = config.getInt("PersonnalItems." + s + ".enchantment." + ench);
						
						Enchantment enchant = Enchantment.getByName(ench);
						
						personnalItem.addUnsafeEnchantment(enchant, levelEnchant);
						
					}
					this.kit.add(personnalItem);
				} catch(Exception e) {
					mat = Material.AIR;
				}
				
			} else {
				ItemStack item = new ItemStack(mat, amount);
				this.kit.add(item);
			}
		}
		
		//Récupère les items dans le fichier config
		for(String s : config.getConfigurationSection("Kits." + name + ".Items").getKeys(false)) {
			Material mat = Material.matchMaterial(s);
			int amount = config.getInt("Kits." + name + ".Items." + s);
			
			if(mat == null) {
				try {
					String itemMC = config.getConfigurationSection("PersonnalItems." + s).getString("item");
					
					mat = Material.matchMaterial(itemMC);
					
					ItemStack personnalItem = new ItemStack(mat, amount);
					
					for(String ench : config.getConfigurationSection("PersonnalItems." + s + ".enchantment").getKeys(false)) {
						int levelEnchant = config.getInt("PersonnalItems." + s + ".enchantment." + ench);
						
						Enchantment enchant = Enchantment.getByName(ench);
						
						personnalItem.addUnsafeEnchantment(enchant, levelEnchant);
					}
					this.kit.add(personnalItem);
					
				} catch(Exception e) {
					mat = Material.AIR;
				}
				
			} else {
				ItemStack item = new ItemStack(mat, amount);
				this.kit.add(item);
			}
		}
		
		
		return;
	}
	
	public void giveKit(String name) {
		this.getKit(name);
		
		for(ItemStack i : this.kit) {
			player.getInventory().addItem(i);
		}
		
		player.sendMessage("Vous avez recu le kit : " + name);
		
	}
	
}
