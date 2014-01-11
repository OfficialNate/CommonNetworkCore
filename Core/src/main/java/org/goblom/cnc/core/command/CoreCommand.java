/*
 * Copywrite 2014 Goblom.
 *
 * All Rights Reserved unless otherwise explicitly stated.
 */

package org.goblom.cnc.core.command;

import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;

/**
 *
 * @author Goblom
 */
public class CoreCommand extends Command {

    private CoreCommandExecutor exe = null;
    
    public CoreCommand(String command) {
        super(command);
    }
    
    public void setExecutor(CoreCommandExecutor exe) {
        this.exe = exe;
    }
    
    public boolean execute(CommandSender sender, String label, String[] args) {
        if (exe != null) {
            exe.onCommand(sender, this, label, args);
        }
        return false;
    }
}
