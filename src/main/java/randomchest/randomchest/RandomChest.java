package randomchest.randomchest;

import ChestManager.PlaceChest;
import EventManager.onClick;
import org.bukkit.Material;
import org.bukkit.block.Block;
import org.bukkit.block.Chest;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.plugin.java.JavaPlugin;

public final class RandomChest extends JavaPlugin {

    public static RandomChest main;

    @Override
    public void onEnable() {
        main = this;

        getServer().getPluginManager().registerEvents(new onClick(),this);
    }

    @Override
    public void onDisable() {

    }

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        Player p = (Player) sender;
        if(label.contains("fuck1")) {
            PlaceChest.placeChest(p,10);
        }
        return false;
    }
}
