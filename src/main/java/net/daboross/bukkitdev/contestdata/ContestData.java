/*
 * Copyright (C) 2013-2014 Dabo Ross <http://www.daboross.net/>
 *
 * This program is free software: you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License
 * along with this program.  If not, see <http://www.gnu.org/licenses/>.
 */
package net.daboross.bukkitdev.contestdata;

import java.io.IOException;
import java.util.logging.Level;
import net.daboross.bukkitdev.playerdata.api.PlayerDataPlugin;
import org.bukkit.Bukkit;
import org.bukkit.plugin.Plugin;
import org.bukkit.plugin.java.JavaPlugin;
import org.mcstats.MetricsLite;

/**
 *
 * @author daboross
 */
public class ContestData extends JavaPlugin {

    private PlayerDataPlugin playerDataMain;
    private ContestDataCommandExecutor commandExecutor;

    @Override
    public void onEnable() {
        Plugin playerDataPlugin = Bukkit.getPluginManager().getPlugin("PlayerData");
        if (playerDataPlugin == null) {
            getLogger().log(Level.SEVERE, "PlayerData not found!");
        } else {
            if (playerDataPlugin instanceof PlayerDataPlugin) {
                playerDataMain = (PlayerDataPlugin) playerDataPlugin;
            } else {
                getLogger().log(Level.SEVERE, "PlayerData plugin not instanceof PlayerDataPlugin!");
            }
        }
        if (playerDataMain == null) {
            Bukkit.getPluginManager().disablePlugin(this);
            return;
        }
        commandExecutor = new ContestDataCommandExecutor(this);
        commandExecutor.registerCommand();
        MetricsLite metrics = null;
        try {
            metrics = new MetricsLite(this);
        } catch (IOException ex) {
            getLogger().log(Level.WARNING, "Unable to create Metrics", ex);
        }
        if (metrics != null) {
            metrics.start();
        }
    }

    @Override
    public void onDisable() {
    }

    protected PlayerDataPlugin getPlayerDataPlugin() {
        return playerDataMain;
    }
}
