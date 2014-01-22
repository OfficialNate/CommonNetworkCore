/*
 * Copywrite 2014 Goblom.
 *
 * All Rights Reserved unless otherwise explicitly stated.
 */

package org.goblom.cnc.common.manager;

import org.goblom.cnc.core.permissions.defaults.CNDefaultRank;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.bukkit.ChatColor;
import org.goblom.cnc.core.permissions.Rank;
import org.goblom.cnc.core.permissions.RankManager;

/**
 *
 * @author Goblom
 */
public class CNRankManager implements RankManager {

    private final Map<String, Rank> ranks = new HashMap();
    
    public CNRankManager() {
        registerRank(new CNDefaultRank());
    }
    
    @Override
    public Map<String, Rank> getRanks() {
        return ranks;
    }

    @Override
    public void registerRank(Rank rank) {
        ranks.put(ChatColor.stripColor(rank.getName()), rank);
    }

    @Override
    public void removeRank(String rankName) {
        ranks.remove(rankName);
    }

    @Override
    public void removeRank(Rank rank) {
        ranks.remove(rank.getName());
    }

    @Override
    public Rank getRank(String rankName) {
        return ranks.get(rankName);
    }

    @Override
    public Rank[] getInheritance(String rankName) {
        return getRank(rankName).getInheritance().toArray(new Rank[getRank(rankName).getInheritance().size()]);
    }

    @Override
    public List<String> getPermissionsforRank(String rankName) {
        List<String> perms = new ArrayList();
        for (Rank rank : getRank(rankName).getInheritance()) {
            perms.addAll(rank.getPermissions());
        }
        perms.addAll(getRank(rankName).getPermissions());
        
        return perms;
    }
    
}
