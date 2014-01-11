/*
 * Copywrite 2014 Goblom.
 *
 * All Rights Reserved unless otherwise explicitly stated.
 */

package org.goblom.cnc.core.permissions;

import java.util.List;

/**
 *
 * @author Goblom
 */
public interface Rank {
    public String getName();
    public List<String> getPermissions();
    public List<Rank> getInheritance();
}
