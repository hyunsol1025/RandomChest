package EventManager;

import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.block.Block;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.player.PlayerInteractEvent;
import randomchest.randomchest.PlayerGlobal;

public class onClick implements Listener {
    @EventHandler
    void onClick(PlayerInteractEvent e) {
        Player p = e.getPlayer();

        if(p.getInventory().getItemInMainHand() == null) return;
        if(e.getClickedBlock() == null) return;

        Location bLoc = e.getClickedBlock().getLocation();
        if(p.getInventory().getItemInMainHand().getType() == Material.NAME_TAG) {

            e.setCancelled(true);

            if(e.getAction() == Action.LEFT_CLICK_BLOCK) {
                p.sendMessage("§b§l랜덤상자 | §f첫번째 좌표가 지정되었습니다. §7("+bLoc.getX()+", "+bLoc.getY()+", "+bLoc.getZ()+")");
                PlayerGlobal.pos1.put(p,bLoc);
            }

            else if(e.getAction() == Action.RIGHT_CLICK_BLOCK) {
                p.sendMessage("§b§l랜덤상자 | §f두번째 좌표가 지정되었습니다. §7("+bLoc.getX()+", "+bLoc.getY()+", "+bLoc.getZ()+")");
                PlayerGlobal.pos2.put(p,bLoc);
            }
        }
    }
}
