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
package org.eclipse.che.api.factory.shared.dto;

import org.eclipse.che.api.core.factory.FactoryParameter;
import org.eclipse.che.api.core.model.factory.OnProjectsLoaded;
import org.eclipse.che.dto.shared.DTO;

import java.util.List;

import static org.eclipse.che.api.core.factory.FactoryParameter.Obligation.OPTIONAL;

/**
 * Describe IDE look and feel on project opened event.
 *
 * @author Sergii Kabashniuk
 */
@DTO
public interface OnProjectsLoadedDto extends OnProjectsLoaded {

    /**
     * @return actions for current event.
     */
    @Override
    @FactoryParameter(obligation = OPTIONAL)
    List<IdeActionDto> getActions();

    void setActions(List<IdeActionDto> actions);

    OnProjectsLoadedDto withActions(List<IdeActionDto> actions);
}
