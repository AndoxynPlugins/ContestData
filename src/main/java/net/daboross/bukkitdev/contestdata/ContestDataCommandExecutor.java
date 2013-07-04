package net.daboross.bukkitdev.contestdata;

import net.daboross.bukkitdev.playerdata.libraries.commandexecutorbase.CommandExecutorBase;
import net.daboross.bukkitdev.playerdata.libraries.commandexecutorbase.SubCommand;
import net.daboross.bukkitdev.playerdata.PlayerDataBukkit;
import net.daboross.bukkitdev.playerdata.api.PlayerHandler;
import org.bukkit.command.PluginCommand;

/**
 *
 * @author daboross
 */
public class ContestDataCommandExecutor {

    private final ContestData pluginMain;
    private final PlayerDataBukkit pDataM;
    private final PlayerHandler pDataH;
    private final CommandExecutorBase commandExecutorBase;

    /**
     *
     */
    protected ContestDataCommandExecutor(ContestData mainPlugin) {
        pluginMain = mainPlugin;
        pDataM = mainPlugin.getPDataMain();
        pDataH = pDataM.getHandler();
        commandExecutorBase = new CommandExecutorBase("contestdata.help");
        commandExecutorBase.addSubCommand(new SubCommand("entercontest", new String[]{"ec"}, true, "contestdata.enter", "This Command Enters you Into a Contest", null));
    }

    protected void registerCommand() {
        PluginCommand contestdata = pluginMain.getCommand("contestdata:contestdata");
        if (contestdata != null) {
            contestdata.setExecutor(commandExecutorBase);
        }
    }
}
