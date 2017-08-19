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
import java.util.Map;
import org.eclipse.che.dto.shared.DTO;

@DTO
public interface GitIndexChangeEventDto {
  Status getStatus();

  void setStatus(Status status);

  GitIndexChangeEventDto withStatus(Status status);

  Map<String, List<Edition>> getModifiedFiles();

  void setModifiedFiles(Map<String, List<Edition>> modifiedFiles);

  GitIndexChangeEventDto withModifiedFiles(Map<String, List<Edition>> modifiedFiles);
}
