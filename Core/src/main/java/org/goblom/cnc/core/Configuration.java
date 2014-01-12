/*
 * Copywrite 2014 Goblom.
 *
 * All Rights Reserved unless otherwise explicitly stated.
 */

package org.goblom.cnc.core;

import java.io.File;
import org.bukkit.configuration.file.FileConfiguration;

/**
 *
 * @author Goblom
 */
public interface Configuration {
    public FileConfiguration getFileConfiguration();
    public File getFile();
    public void save();
}
