/*******************************************************************************
 * Copyright (c) 2012-2017 Codenvy, S.A.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *   Codenvy, S.A. - initial API and implementation
 *******************************************************************************/
package org.eclipse.che.ide.api.vcs;

/** Component that handles change markers. */
public interface VcsChangeMarkerRender {

    /**
     * Add change marker to the gutter on the given lines.
     *
     * @param lineStart
     *         first line of the marker
     * @param lineEnd
     *         lastLine of the marker
     * @param type
     *         tpe of the marker e.g. insertion, modification, deletion
     */
    void addChangeMarker(int lineStart, int lineEnd, EditionType type);

    /**
     * Clear all change markers in the gutter.
     */
    void clearAllMarkers();
}
