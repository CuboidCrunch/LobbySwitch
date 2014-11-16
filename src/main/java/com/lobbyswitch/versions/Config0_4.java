package com.lobbyswitch.versions;

import com.lobbyswitch.config.ConfigPaths;
import org.bukkit.configuration.file.FileConfiguration;

import java.util.Arrays;
import java.util.List;

/**
 * Created by Derek on 11/15/2014.
 * Time: 9:23 PM
 */
public abstract class Config0_4 {

    public static FileConfiguration update(FileConfiguration fileConfiguration) {
        for (String string : fileConfiguration.getConfigurationSection(ConfigPaths.SERVER_SLOTS).getKeys(false)) {
            List<String> lore = Arrays.asList(new String[]{"\2477%PLAYER_COUNT% \247cOnline"});
            fileConfiguration.set(ConfigPaths.getSlotPath(ConfigPaths.SERVER_SLOT_LORE, Integer.valueOf(string)), lore);
        }
        fileConfiguration.set(ConfigPaths.VERSION, "0.4");
        return fileConfiguration;
    }

    public static boolean equals(FileConfiguration fileConfiguration) {
        if (fileConfiguration.contains(ConfigPaths.VERSION)) {
            if (fileConfiguration.getString(ConfigPaths.VERSION).equals("0.4")) {
                return true;
            }
        }
        return false;
    }
}
