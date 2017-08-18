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
package org.eclipse.che.ide.ext.git.client;

import elemental.html.DivElement;

import com.google.inject.assistedinject.Assisted;
import com.google.inject.assistedinject.AssistedInject;

import org.eclipse.che.ide.api.editor.document.Document;
import org.eclipse.che.ide.api.editor.gutter.Gutter;
import org.eclipse.che.ide.api.editor.texteditor.LineStyler;
import org.eclipse.che.ide.api.vcs.EditionType;
import org.eclipse.che.ide.api.vcs.VcsChangeMarkerRender;
import org.eclipse.che.ide.util.dom.Elements;

import static org.eclipse.che.ide.api.editor.gutter.Gutters.EDITIONS_GUTTER;

public class GitChangeMarkerRender implements VcsChangeMarkerRender {
    private final GitResources resources;
    private final Gutter       hasGutter;
    private final LineStyler   lineStyler;
    private final Document     document;

    @AssistedInject
    public GitChangeMarkerRender(GitResources resources,
                                 @Assisted final Gutter hasGutter,
                                 @Assisted final LineStyler lineStyler,
                                 @Assisted final Document document) {
        this.resources = resources;
        this.hasGutter = hasGutter;
        this.lineStyler = lineStyler;
        this.document = document;

        resources.addedCSS().ensureInjected();
    }

    @Override
    public void addChangeMarker(int lineStart, int lineEnd, EditionType type) {
        DivElement element = null;
        switch (type) {
            case INSERTION: {
                element = Elements.createDivElement(resources.addedCSS().markAdded());
                break;
            }
            case MODIFICATION: {
                element = Elements.createDivElement(resources.addedCSS().markModified());
                break;
            }
            case DELETION: {
                element = Elements.createDivElement(resources.addedCSS().markDeleted());
                break;
            }
        }
        hasGutter.addGutterItem(lineStart, lineEnd, EDITIONS_GUTTER, element);
    }

    @Override
    public void clearAllMarkers() {
        hasGutter.clearGutter(EDITIONS_GUTTER);
    }
}
