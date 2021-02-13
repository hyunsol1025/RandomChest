package randomchest.randomchest;

import org.bukkit.Location;
import org.bukkit.inventory.ItemStack;

import java.util.ArrayList;
import java.util.HashMap;

public class ServerGlobal {
    public static int chestMax = 3; // 상자 안의 아이템 최대 갯수

    public static HashMap<Location, ArrayList<ItemStack>> chestItem = new HashMap<>();
    public static ArrayList<ItemStack> chestNeeds = new ArrayList<>();
}
