/*
 * Copyright (c) 2012-2017 Red Hat, Inc.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *   Red Hat, Inc. - initial API and implementation
 */
package org.eclipse.che.ide.editor.macro;

import com.google.common.annotations.Beta;
import com.google.inject.Inject;
import com.google.inject.Singleton;

import org.eclipse.che.api.promises.client.Promise;
import org.eclipse.che.api.promises.client.PromiseProvider;
import org.eclipse.che.ide.CoreLocalizationConstant;
import org.eclipse.che.ide.api.editor.EditorAgent;
import org.eclipse.che.ide.api.editor.EditorPartPresenter;
import org.eclipse.che.ide.api.resources.File;
import org.eclipse.che.ide.api.resources.VirtualFile;

/**
 * Provider which is responsible for retrieving the file name without extension from the opened editor.
 *
 * Macro provided: <code>${editor.current.file.basename}</code>
 *
 * @see AbstractEditorMacro
 * @see EditorAgent
 * @since 5.6.0
 */
@Beta
@Singleton
public class EditorCurrentFileBaseNameMacro extends AbstractEditorMacro {

    public static final String KEY = "${editor.current.file.basename}";

    private PromiseProvider promises;
    private final CoreLocalizationConstant localizationConstants;

    @Inject
    public EditorCurrentFileBaseNameMacro(EditorAgent editorAgent,
                                          PromiseProvider promises,
                                          CoreLocalizationConstant localizationConstants) {
        super(editorAgent);
        this.promises = promises;
        this.localizationConstants = localizationConstants;
    }

    /** {@inheritDoc} */
    @Override
    public String getName() {
        return KEY;
    }

    @Override
    public String getDescription() {
        return localizationConstants.macroEditorCurrentFileBaseNameDescription();
    }

    /** {@inheritDoc} */
    @Override
    public Promise<String> expand() {
        final EditorPartPresenter editor = getActiveEditor();

        if (editor == null) {
            return promises.resolve("");
        }

        final VirtualFile virtualFile = editor.getEditorInput().getFile();

        if (virtualFile instanceof File) {
            return promises.resolve(((File)virtualFile).getNameWithoutExtension());
        }

        final String rawName = virtualFile.getName();

        final int lastDotIndex = rawName.lastIndexOf('.');
        if (lastDotIndex == -1) {
            return promises.resolve(rawName);
        }

        return promises.resolve(rawName.substring(0, lastDotIndex));
    }
}
