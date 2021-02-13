package randomchest.randomchest;

import org.bukkit.Location;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;

import java.util.HashMap;
import java.util.UUID;

public class PlayerGlobal {
    public static HashMap<UUID, Inventory> inv = new HashMap<>();

    public static HashMap<Player, Location> pos1 = new HashMap<>();
    public static HashMap<Player, Location> pos2 = new HashMap<>();
}
