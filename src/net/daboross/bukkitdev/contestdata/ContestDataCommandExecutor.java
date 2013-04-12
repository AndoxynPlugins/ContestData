package net.daboross.bukkitdev.contestdata;

import net.daboross.bukkitdev.commandexecutorbase.ColorList;
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
        initCommand("entercontest", new String[]{"ec"}, true, "contestdata.enter", "This Command Enters you Into a Contest", new CommandReactor() {
            public void runCommand(CommandSender sender, Command mainCommand, String mainCommandLabel, String subCommand, String subCommandLabel,
                    String[] subCommandArgs, CommandExecutorBridge executorBridge) {
                sender.sendMessage(ColorList.MAIN + "this isn't a command :P");
            }
        });
    }

    @Override
    public String getCommandName() {
        return "cd";
    }

    @Override
    protected String getMainCmdPermission() {
        return "contestdata.help";
    }
}
