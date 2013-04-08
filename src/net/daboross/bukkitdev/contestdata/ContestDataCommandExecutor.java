package net.daboross.bukkitdev.contestdata;

import net.daboross.bukkitdev.commandexecutorbase.CommandExecutorBase;
import net.daboross.bukkitdev.playerdata.PlayerData;
import net.daboross.bukkitdev.playerdata.PlayerDataHandler;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;

/**
 *
 * @author daboross
 */
public class ContestDataCommandExecutor extends CommandExecutorBase {

    private ContestData pluginMain;
    private PlayerData pDataM;
    private PlayerDataHandler pDataH;

    /**
     *
     */
    protected ContestDataCommandExecutor(ContestData mainPlugin) {
        pluginMain = mainPlugin;
        pDataM = mainPlugin.getPDataMain();
        pDataH = pDataM.getHandler();
        initCommand("help", new String[]{"?"}, true, "contestdata.help", "This Command Views This Page");
        initCommand("entercontest", new String[]{"ec"}, true, "contestdata.enter", "This Command Enters you Into a Contest");
    }

    @Override
    public void runCommand(CommandSender sender, Command mainCommand, String mainCommandLabel, String subCommand, String subCommandLabel, String[] subCommandArgs) {
        if (subCommand.equalsIgnoreCase("entercontest")) {
        }
    }

    @Override
    public String getCommandName() {
        return "cd";
    }
}
