package net.daboross.bukkitdev.contestdata;

import java.util.logging.Level;
import net.daboross.bukkitdev.playerdata.PlayerDataBukkit;
import org.bukkit.Bukkit;
import org.bukkit.plugin.Plugin;
import org.bukkit.plugin.java.JavaPlugin;

/**
 *
 * @author daboross
 */
public class ContestData extends JavaPlugin {

    private static ContestData currentInstance;
    private PlayerDataBukkit pDataM;
    private ContestDataCommandExecutor commandExecutor;

    @Override
    public void onEnable() {
        Plugin playerDataPlugin = Bukkit.getPluginManager().getPlugin("PlayerData");
        if (playerDataPlugin == null) {
            getLogger().log(Level.SEVERE, "PlayerData Not Found!");
        } else {
            if (playerDataPlugin instanceof PlayerDataBukkit) {
                pDataM = (PlayerDataBukkit) playerDataPlugin;
            } else {
                getLogger().log(Level.SEVERE, "PlayerData Not Instance Of Player Data!");
            }
        }
        if (pDataM == null) {
            Bukkit.getPluginManager().disablePlugin(this);
            return;
        }
        commandExecutor = new ContestDataCommandExecutor(this);
        commandExecutor.registerCommand();
        currentInstance = this;
    }

    @Override
    public void onDisable() {
        currentInstance = null;
    }

    protected static ContestData getCurrentInstance() {
        return currentInstance;
    }

    protected PlayerDataBukkit getPDataMain() {
        return pDataM;
    }
}
