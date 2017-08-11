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
package org.eclipse.che.ide.editor.orion.client.events;

import com.google.gwt.event.shared.GwtEvent;

import org.eclipse.che.ide.editor.orion.client.OrionEditorPresenter;

/**
 * Event for scrolls.
 */
public class NewLineAddedEvent extends GwtEvent<OnNewLineAddedHandler> {
    /** The type instance for this event. */
    public static final Type<OnNewLineAddedHandler> TYPE = new Type<>();
    private final OrionEditorPresenter orionEditorPresenter;
    private final int                  line;


    public NewLineAddedEvent(OrionEditorPresenter orionEditorPresenter, int line) {
        this.orionEditorPresenter = orionEditorPresenter;
        this.line = line;
    }

    @Override
    public Type<OnNewLineAddedHandler> getAssociatedType() {
        return TYPE;
    }

    @Override
    protected void dispatch(final OnNewLineAddedHandler handler) {
        handler.onNewLineAdded(this);
    }

    public OrionEditorPresenter getOrionEditorPresenter() {
        return orionEditorPresenter;
    }

    public int getLine() {
        return line;
    }
}
