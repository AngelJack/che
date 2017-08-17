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

/** Component that handles editions display. */
public interface VcsEditionRender {

    /**
     * Add an insertion mark in the gutter on the given line.
     *
     * @param lineNumber
     *         line to set the mark
     */
    void addInsertion(int lineNumber);

    /**
     * Add a modification mark in the gutter on the given line.
     *
     * @param lineNumber
     *         line to set the mark
     */
    void addModification(int lineNumber);

    /**
     * Add a deletion mark in the gutter on the given line.
     *
     * @param lineNumber
     *         line to set the mark
     */
    void addDeletion(int lineNumber);

    /**
     * Fills empty line in the edition region, when new line added.
     *
     * @param line
     *         new line
     */
    void handleNewLineAdded(int line);

    /**
     * Clear all edition marks in the gutter.
     */
    void clearAllEditions();
}
