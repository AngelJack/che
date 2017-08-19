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
package org.eclipse.che.plugin.docker.client;

import org.eclipse.che.commons.annotation.Nullable;
import org.eclipse.che.plugin.docker.client.dto.AuthConfig;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

/**
 * @author Mykola Morhun
 */
public class NoOpDockerRegistryDynamicAuthResolverImpl implements DockerRegistryDynamicAuthResolver {
    @Override
    @Nullable
    public AuthConfig getXRegistryAuth(@Nullable String registry) {
        return null;
    }

    @Override
    public Map<String, AuthConfig> getXRegistryConfig() {
        return Collections.emptyMap();
    }
}
