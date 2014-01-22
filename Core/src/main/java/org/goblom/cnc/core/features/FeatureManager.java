/*
 * Copywrite 2014 Goblom.
 *
 * All Rights Reserved unless otherwise explicitly stated.
 */

package org.goblom.cnc.core.features;

import java.util.List;

/**
 *
 * @author Goblom
 */
public interface FeatureManager {
    boolean registerFeature(Feature feature);
    boolean disableFeature(String featureName);
    boolean enableFeature(String featureName);
    Feature getFeature(String featureName);
    List<Feature> getFeatures();
}
