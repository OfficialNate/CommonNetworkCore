/*
 * Copyright 2013 Goblom.
 *
 * All Rights Reserved unless otherwise explicitly stated.
 */
package org.goblom.cnc.util;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;

/**
 *
 * @author Goblom
 */
public final class ReflectCommand extends Command {

    private CommandExecutor exe = null;

    public ReflectCommand(String command) {
        super(command);
    }

    public void setExecutor(CommandExecutor exe) {
        this.exe = exe;
    }

    @Override
    public boolean execute(CommandSender sender, String commandLabel, String[] args) {
        if (exe != null) {
            exe.onCommand(sender, this, commandLabel, args);
        }
        return false;
    }
}
