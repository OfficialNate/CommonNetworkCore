/*
 * Copywrite 2014 Goblom.
 *
 * All Rights Reserved unless otherwise explicitly stated.
 */

package org.goblom.cnc.common.manager;

import java.util.ArrayList;
import java.util.List;
import org.bukkit.Bukkit;
import org.bukkit.event.HandlerList;
import org.bukkit.event.Listener;
import org.bukkit.plugin.Plugin;
import org.goblom.cnc.common.Message;
import org.goblom.cnc.core.Core;
import org.goblom.cnc.core.features.Feature;
import org.goblom.cnc.core.features.FeatureManager;

/**
 *
 * @author Goblom
 */
public class CNFeatureManager implements FeatureManager, Listener {

    private final List<Feature> features = new ArrayList();
    
    @Override
    public boolean registerFeature(Feature feature) {
        for (Feature f : features) {
            String fName = Message.stripColor(f.getName());
            String f2Name = Message.stripColor(feature.getName());
            if (fName.equalsIgnoreCase(f2Name)) {
                return false;
            }
        }
        set(feature, true);
        return features.add(feature);
    }

    @Override
    public boolean disableFeature(String featureName) {
        for (Feature f : features) {
            String fName = Message.stripColor(f.getName());
            String f2Name = Message.stripColor(featureName);
            if (fName.equalsIgnoreCase(f2Name)) {
                HandlerList.unregisterAll(f);
                set(f, false);
                return true;
            }
        }
        return false;
    }

    @Override
    public boolean enableFeature(String featureName) {
        for (Feature f : features) {
            String fName = Message.stripColor(f.getName());
            String f2Name = Message.stripColor(featureName);
            if (fName.equalsIgnoreCase(f2Name)) {
                Bukkit.getServer().getPluginManager().registerEvents(f, getPlugin());
                set(f, true);
                return true;
            }
        }
        return false;
    }

    @Override
    public Feature getFeature(String featureName) {
        for (Feature f : features) {
            String fName = Message.stripColor(f.getName());
            String f2Name = Message.stripColor(featureName);
            if (fName.equalsIgnoreCase(f2Name)) {
                return f;
            }
        }
        return null;
    }
    
    @Override
    public List<Feature> getFeatures() {
        List<Feature> newList = features;
        return newList;
    }
    
    private void set(Feature feature, boolean b) {
        if (!Core.getCoreConfiguration().getFileConfiguration().contains("Features." + feature.getName())) {
            Core.getCoreConfiguration().getFileConfiguration().set("Features." + feature.getName(), b);
            Core.getCoreConfiguration().save();
        }
    }
    
    private Plugin getPlugin() {
        return Bukkit.getPluginManager().getPlugin("Common Network Core");
    }
}
