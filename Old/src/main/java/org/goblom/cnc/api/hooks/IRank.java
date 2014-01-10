/*
 * Copyright 2013 Goblom.
 *
 * All Rights Reserved unless otherwise explicitly stated.
 */

package org.goblom.cnc.api.hooks;

/**
 *
 * @author Goblom
 */
public interface IRank {
    public String getName();
    public String[] getPermissions();
    public IRank[] getInheritance();
}
