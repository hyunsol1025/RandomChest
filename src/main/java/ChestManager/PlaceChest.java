package ChestManager;

import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.World;
import org.bukkit.entity.Player;
import randomchest.randomchest.PlayerGlobal;
import randomchest.randomchest.ServerGlobal;

import java.util.ArrayList;

public class PlaceChest {

    private static int getIntCoord(double d) {
        return Integer.parseInt((""+d).split("\\.")[0]);
    }

    public static void placeChest(Player p, int chestAmount) {
        Location pos1 = PlayerGlobal.pos1.get(p);
        Location pos2 = PlayerGlobal.pos2.get(p);

        int x1 = getIntCoord(pos1.getX()); int x2 = getIntCoord(pos2.getX());
        int y1 = getIntCoord(pos1.getY()); int y2 = getIntCoord(pos2.getY());
        int z1 = getIntCoord(pos1.getZ()); int z2 = getIntCoord(pos2.getZ());

        int ax = (x1 >= x2) ? -1 : 1;
        int ay = (y1 >= y2) ? -1 : 1;
        int az = (z1 >= z2) ? -1 : 1;

        int chestCounter = 0;
        int whileStopper = 0;

        while(chestCounter != chestAmount && whileStopper < chestAmount+20) {
            whileStopper++;

            for(int lx = x1; lx != x2+ax; lx += ax) {
                for(int ly = y1; ly != y2+ay; ly += ay) {
                    for(int lz = z1; lz != z2+az; lz += az) {
                        Location targetLocation = new Location(p.getWorld(),lx,ly,lz);
                        World w = p.getWorld();

                        if(w.getBlockAt(targetLocation.clone().add(0,-1,0)).getType() != Material.AIR &&
                            w.getBlockAt(targetLocation.clone().add(0,1,0)).getType() == Material.AIR &&
                            w.getBlockAt(targetLocation).getType() == Material.AIR) {

                            boolean isOkay = true;

                            ArrayList<Location> targetLocation2 = new ArrayList<>();
                            targetLocation2.add(targetLocation.clone().add(1,0,0));
                            targetLocation2.add(targetLocation.clone().add(-1,0,0));

                            targetLocation2.add(targetLocation.clone().add(0,0,-1));
                            targetLocation2.add(targetLocation.clone().add(0,0,1));

                            targetLocation2.add(targetLocation.clone().add(0,-1,0));

                            targetLocation2.add(targetLocation.clone().add(1,0,1));
                            targetLocation2.add(targetLocation.clone().add(1,0,-1));
                            targetLocation2.add(targetLocation.clone().add(-1,0,1));
                            targetLocation2.add(targetLocation.clone().add(-1,0,-1));

                            for(Location loc : targetLocation2) {
                                if(w.getBlockAt(loc).getType() == Material.CHEST) isOkay = false;
                            }

                            if(isOkay) {
                                // 랜덤 상자 배치
                                chestCounter++;

                                w.getBlockAt(targetLocation).setType(Material.CHEST);
                                ServerGlobal.chestItem.put(targetLocation.toCenterLocation(), new ArrayList<>());
                            }
                        }
                    }
                }
            }
        }

        if(chestCounter < chestAmount) {
            p.sendMessage("§c§l랜덤상자 | §f지정된 상자 갯수§7("+chestAmount+"개)§f만큼의 상자를 둘 공간이 없어, "+chestCounter+"개가 배치되었습니다.");
        }

        SpreadItem.SpreadItem();
    }


}
