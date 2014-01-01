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

import net.daboross.bukkitdev.playerdata.api.PlayerDataPlugin;
import net.daboross.bukkitdev.playerdata.api.PlayerHandler;
import org.bukkit.command.PluginCommand;

/**
 *
 * @author daboross
 */
public class ContestDataCommandExecutor {

    private final ContestData pluginMain;
    private final PlayerDataPlugin pDataM;
    private final PlayerHandler playerHandler;

    /**
     *
     */
    protected ContestDataCommandExecutor(ContestData mainPlugin) {
        pluginMain = mainPlugin;
        pDataM = mainPlugin.getPlayerDataPlugin();
        playerHandler = pDataM.getHandler();
//        commandExecutorBase = new CommandExecutorBase("contestdata.help");
//        commandExecutorBase.addSubCommand(new SubCommand("entercontest", new String[]{"ec"}, true, "contestdata.enter", "This Command Enters you Into a Contest", null));
    }

    protected void registerCommand() {
        PluginCommand contestdata = pluginMain.getCommand("contestdata:contestdata");
        if (contestdata != null) {
//            contestdata.setExecutor(commandExecutorBase);
        }
    }
}
