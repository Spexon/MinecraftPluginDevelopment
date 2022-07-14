package me.spexon.minecraftplugin;

import org.bukkit.Material;
import org.bukkit.World;
import org.bukkit.block.Block;
import org.bukkit.block.BlockFace;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.LivingEntity;
import org.bukkit.entity.Monster;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.CreatureSpawnEvent;
import org.bukkit.event.player.PlayerMoveEvent;
import org.bukkit.inventory.ItemStack;

public class PlayerMovementListener implements Listener {

  @EventHandler
  public void onPlayerMove(PlayerMoveEvent event) {

    // Get the player that just moved
    Player p = event.getPlayer();

    // Get the Block right below the player
    Block b = p.getLocation().getBlock().getRelative(BlockFace.DOWN);

    // Create an explosion of power 5 on the player's location
    if (b.getType() == Material.GRASS_BLOCK) {

      World w = p.getWorld();
      w.createExplosion(p.getLocation(), 1);
    }
  }

  @EventHandler
  public void onMobSpawn(CreatureSpawnEvent event) {

    LivingEntity entity = event.getEntity();

    if (entity instanceof Monster) {

      // Give the Monster full diamond armor.
      entity.getEquipment().setBoots(new ItemStack(Material.DIAMOND_BOOTS));
      entity.getEquipment().setChestplate(new ItemStack(Material.DIAMOND_CHESTPLATE));
      entity.getEquipment().setHelmet(new ItemStack(Material.DIAMOND_HELMET));
      entity.getEquipment().setLeggings(new ItemStack(Material.DIAMOND_LEGGINGS));
      if (entity.getType() == EntityType.SKELETON) {

        // Create an enchanted bow and give it to the skeleton.
        ItemStack bow = new ItemStack(Material.BOW);
        bow.addEnchantment(Enchantment.ARROW_DAMAGE, 4);
        entity.getEquipment().setItemInMainHand(bow);

      }

      if (entity.getType() == EntityType.CREEPER) {

        entity.setInvisible(true);

      }
    }
  }


}
