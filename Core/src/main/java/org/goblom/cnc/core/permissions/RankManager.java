/*
 * Copywrite 2014 Goblom.
 *
 * All Rights Reserved unless otherwise explicitly stated.
 */

package org.goblom.cnc.core.permissions;

import java.util.List;
import java.util.Map;

/**
 *
 * @author Goblom
 */
public interface RankManager {
    public Map<String, Rank> getRanks();
    public void registerRank(Rank rank);
    public void removeRank(String rankName);
    public void removeRank(Rank rank);
    public Rank getRank(String rankName);
    public Rank[] getInheritance(String rankName);
    public List<String> getPermissionsforRank(String rankName);
}
