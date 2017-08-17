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
     * First line of the edition range.
     */
    int getBeginLine();

    void setBeginLine(int startLine);

    Edition withBeginLine(int startLine);

    /**
     * Last line of the edition range.
     */
    int getEndLine();

    void setEndLine(int endLine);

    Edition withEndLine(int endLine);

    /**
     * Type of the edition e.g. insertion, modification, deletion.
     */
    String getType();

    void setType(String type);

    Edition withType(String type);
}
