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
package org.eclipse.che.dto.definitions.model;

import java.util.List;

/**
 * Test interface serves as base model, should be extended with dto interface
 *
 * @author Eugene Voevodin
 */
public interface Model {

    List<? extends ModelComponent> getComponents();

    ModelComponent getPrimary();
}
