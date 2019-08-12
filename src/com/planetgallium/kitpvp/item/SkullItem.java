package com.planetgallium.kitpvp.item;

import org.bukkit.Bukkit;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.SkullMeta;

import com.planetgallium.kitpvp.util.Toolkit;
import com.planetgallium.kitpvp.util.XMaterial;

public class SkullItem {

	private String owner;
	
	public SkullItem(String owner) {
		
		this.owner = owner;
		
	}
	
	@SuppressWarnings("deprecation")
	public ItemStack convertToSkull(ItemStack toConvert) {
		
		ItemStack newSkull = XMaterial.PLAYER_HEAD.parseItem();
		newSkull.setItemMeta(toConvert.getItemMeta());
		SkullMeta skullMeta = (SkullMeta) newSkull.getItemMeta();
		
		if (Toolkit.versionToNumber() < 13) {
			
			skullMeta.setOwner(owner);
			
			return newSkull;
			
		} else if (Toolkit.versionToNumber() >= 13) {
			
			skullMeta.setOwningPlayer(Bukkit.getOfflinePlayer(owner));
			
			return newSkull;
			
		} else {
			
			return toConvert;
			
		}
		
	}
	
}