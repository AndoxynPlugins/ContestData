package net.daboross.bukkitdev.contestdata;

import java.util.logging.Level;
import net.daboross.bukkitdev.playerdata.ColorList;
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
    public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
        if (cmd.getName().equalsIgnoreCase("dcommand")) {
            String commandName = isCommandValid(sender, cmd, label, args);
            if (commandName == null) {
                return true;
            }
            if (commandName.equalsIgnoreCase("name")) {
                runSubCommand(sender, cmd, getSubArray(args));
            }
            return true;
        }
        return false;
    }

    private void runSubCommand(CommandSender sender, Command cmd, String[] args) {
        sender.sendMessage(ColorList.MAIN + "You Just Ran Sub Command");
        pluginMain.getLogger().log(Level.INFO, "{0} just ran Sub Command", sender.getName());
    }
}
