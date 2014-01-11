/*
 * Copywrite 2014 Goblom.
 *
 * All Rights Reserved unless otherwise explicitly stated.
 */

package org.goblom.cnc.core.permissions.defaults;

import java.util.ArrayList;
import java.util.List;
import org.goblom.cnc.core.permissions.Rank;

/**
 *
 * @author Goblom
 */
public class CNDefaultRank implements Rank {

    public String getName() {
        return "Default";
    }

    public List<String> getPermissions() {
        return new ArrayList();
    }

    public List<Rank> getInheritance() {
        return new ArrayList();
    }
    
}
