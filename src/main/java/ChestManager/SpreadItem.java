package ChestManager;

import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.World;
import org.bukkit.block.Chest;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import randomchest.randomchest.ServerGlobal;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Random;

public class SpreadItem {

    public static boolean isAlreadyChestSet = false;

    public static void SpreadItem() {
        int chestMax = ServerGlobal.chestMax;

        ArrayList<ItemStack> list = new ArrayList<>();
        list.add(new ItemStack(Material.PAPER, 2));
        list.add(new ItemStack(Material.DIRT, 3));
        list.add(new ItemStack(Material.GRASS, 5));

        int whileStopper = 0;

        while(list.size() != 0 && whileStopper < list.size()+100) {
            Bukkit.broadcastMessage("whil도는중..");
            whileStopper++;

            Collections.shuffle(list);

            ArrayList<ItemStack> currentItemList = new ArrayList<>();

            Random rand = new Random();
            for(int i=0; i < rand.nextInt(chestMax); i++) {

                currentItemList.add(list.get(0));
                list.remove(0);

                if(list.size() == 0) break;
            }

            ServerGlobal.chestItem.forEach((key, value) -> {
                if(value.size() == 0 && !isAlreadyChestSet) {
                    ServerGlobal.chestItem.put(key, currentItemList);

                    Chest c = (Chest) key.getBlock().getState();
                    Inventory cInv = c.getInventory();

                    for(ItemStack e : currentItemList) {
                        cInv.addItem(e);
                    }

                    isAlreadyChestSet = true;
                }
            });

            isAlreadyChestSet = false;
        }

        Bukkit.broadcastMessage("아이템 숨기기 반복문 끝!");
    }

}
