package net.daboross.bukkitdev.contestdata;

import java.util.logging.Level;
import net.daboross.bukkitdev.playerdata.PlayerData;
import org.bukkit.Bukkit;
import org.bukkit.command.PluginCommand;
import org.bukkit.plugin.Plugin;
import org.bukkit.plugin.java.JavaPlugin;

/**
 *
 * @author daboross
 */
public class ContestData extends JavaPlugin {

    private static ContestData currentInstance;
    private PlayerData pDataM;
    private ContestDataCommandExecutor commandExecutor;

    @Override
    public void onEnable() {
        Plugin playerDataPlugin = Bukkit.getPluginManager().getPlugin("PlayerData");
        if (playerDataPlugin == null) {
            getLogger().log(Level.SEVERE, "PlayerData Not Found!");
        } else {
            if (playerDataPlugin instanceof PlayerData) {
                pDataM = (PlayerData) playerDataPlugin;
            } else {
                getLogger().log(Level.SEVERE, "PlayerData Not Instance Of Player Data!");
            }
        }
        if (pDataM == null) {
            Bukkit.getPluginManager().disablePlugin(this);
            return;
        }
        commandExecutor = new ContestDataCommandExecutor(this);
        PluginCommand dCommand = getCommand("dcommand");
        if (dCommand != null) {
            dCommand.setExecutor(commandExecutor);
        } else {
            getLogger().log(Level.SEVERE, "dCommand Not Found!");
        }
        currentInstance = this;
    }

    @Override
    public void onDisable() {
        currentInstance = null;
    }

    protected static ContestData getCurrentInstance() {
        return currentInstance;
    }

    protected PlayerData getPDataMain() {
        return pDataM;
    }
}
