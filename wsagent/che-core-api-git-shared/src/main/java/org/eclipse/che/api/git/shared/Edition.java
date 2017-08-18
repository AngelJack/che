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
package org.eclipse.che.api.git.shared;

import org.eclipse.che.dto.shared.DTO;

@DTO
public interface Edition {

    /**
     * First line of the edited region.
     */
    int getBeginLine();

    void setBeginLine(int startLine);

    Edition withBeginLine(int startLine);

    /**
     * Last line of the edited region.
     */
    int getEndLine();

    void setEndLine(int endLine);

    Edition withEndLine(int endLine);

    /**
     * Status of the edition e.g. insertion, modification, deletion.
     */
    Type getType();

    void setType(Type type);

    Edition withType(Type type);

    enum Type {
        INSERTION,
        MODIFICATION,
        DELETION
    }
}
