/*
 * Copywrite 2014 Goblom.
 *
 * All Rights Reserved unless otherwise explicitly stated.
 */

package org.goblom.cnc.common;

import java.io.File;
import org.bukkit.configuration.file.FileConfiguration;
import org.goblom.cnc.core.Configuration;

/**
 *
 * @author Goblom
 */
public class CNConfiguration implements Configuration {
    
    private final FileConfiguration config;
    private final CNCore core;
    
    public CNConfiguration(CNCore core, FileConfiguration config) {
        this.core = core;
        this.config = config;
    }

    public FileConfiguration getFileConfiguration() {
        return config;
    }

    public File getFile() {
        return new File(core.getDataFolder() + File.separator + "config.yml");
    }

    public void save() {
        throw new UnsupportedOperationException("Not supported yet.");
    }
}
