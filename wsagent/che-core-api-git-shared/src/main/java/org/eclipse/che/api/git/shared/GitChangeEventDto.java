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
package org.eclipse.che.api.git.shared;

import java.util.List;
import org.eclipse.che.dto.shared.DTO;

/**
 * Dto object that contains information about changed git file event.
 *
 * @author Igor Vinokurs
 */
@DTO
public interface GitChangeEventDto {

  /** Status of the file. */
  Status getStatus();

  GitChangeEventDto withStatus(Status type);

  /** Path of the file. */
  String getPath();

  GitChangeEventDto withPath(String path);

  /** List of edited regions of the file. */
  List<Edition> getEditions();

  void setEditions(List<Edition> editions);

  GitChangeEventDto withEditions(List<Edition> editions);

  enum Status {
    ADDED,
    MODIFIED,
    UNTRACKED,
    NOT_MODIFIED
  }
}
