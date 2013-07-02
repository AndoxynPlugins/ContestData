package net.daboross.bukkitdev.contestdata;

import net.daboross.bukkitdev.playerdata.libraries.commandexecutorbase.ColorList;
import net.daboross.bukkitdev.playerdata.libraries.commandexecutorbase.CommandExecutorBase;
import net.daboross.bukkitdev.playerdata.libraries.commandexecutorbase.SubCommand;
import net.daboross.bukkitdev.playerdata.libraries.commandexecutorbase.SubCommandHandler;
import net.daboross.bukkitdev.playerdata.PlayerData;
import net.daboross.bukkitdev.playerdata.PlayerDataHandler;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.command.PluginCommand;

/**
 *
 * @author daboross
 */
public class ContestDataCommandExecutor {

    private final ContestData pluginMain;
    private final PlayerData pDataM;
    private final PlayerDataHandler pDataH;
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
