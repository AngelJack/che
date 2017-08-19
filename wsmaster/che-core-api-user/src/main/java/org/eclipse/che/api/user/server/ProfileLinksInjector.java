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
package org.eclipse.che.api.user.server;

import org.eclipse.che.api.core.rest.ServiceContext;
import org.eclipse.che.api.core.rest.shared.dto.Link;
import org.eclipse.che.api.user.shared.dto.ProfileDto;

import javax.inject.Singleton;
import javax.ws.rs.HttpMethod;
import javax.ws.rs.core.UriBuilder;
import java.util.ArrayList;
import java.util.List;

import static javax.ws.rs.core.MediaType.APPLICATION_JSON;
import static org.eclipse.che.api.core.util.LinksHelper.createLink;
import static org.eclipse.che.api.user.server.Constants.LINK_REL_CURRENT_PROFILE;
import static org.eclipse.che.api.user.server.Constants.LINK_REL_CURRENT_PROFILE_ATTRIBUTES;
import static org.eclipse.che.api.user.server.Constants.LINK_REL_PROFILE_ATTRIBUTES;
import static org.eclipse.che.api.user.server.Constants.LINK_REL_SELF;

/**
 * Creates and injects links to the {@link ProfileDto} object.
 *
 * @author Yevhenii Voevodin
 */
@Singleton
public class ProfileLinksInjector {

    public ProfileDto injectLinks(ProfileDto profileDto, ServiceContext serviceContext) {
        final UriBuilder uriBuilder = serviceContext.getServiceUriBuilder();
        final List<Link> links = new ArrayList<>(5);
        links.add(createLink(HttpMethod.GET,
                             uriBuilder.clone()
                                       .path(ProfileService.class, "getCurrent")
                                       .build()
                                       .toString(),
                             null,
                             APPLICATION_JSON,
                             LINK_REL_CURRENT_PROFILE));
        links.add(createLink(HttpMethod.GET,
                             uriBuilder.clone()
                                       .path(ProfileService.class, "getById")
                                       .build(profileDto.getUserId())
                                       .toString(),
                             null,
                             APPLICATION_JSON,
                             LINK_REL_SELF));
        links.add(createLink(HttpMethod.PUT,
                             uriBuilder.clone()
                                       .path(ProfileService.class, "updateAttributes")
                                       .build()
                                       .toString(),
                             APPLICATION_JSON,
                             APPLICATION_JSON,
                             LINK_REL_CURRENT_PROFILE_ATTRIBUTES));
        links.add(createLink(HttpMethod.DELETE,
                             uriBuilder.clone()
                                       .path(ProfileService.class, "removeAttributes")
                                       .build(profileDto.getUserId())
                                       .toString(),
                             APPLICATION_JSON,
                             APPLICATION_JSON,
                             LINK_REL_CURRENT_PROFILE_ATTRIBUTES));
        links.add(createLink(HttpMethod.PUT,
                             uriBuilder.clone()
                                       .path(ProfileService.class, "updateAttributesById")
                                       .build(profileDto.getUserId())
                                       .toString(),
                             APPLICATION_JSON,
                             APPLICATION_JSON,
                             LINK_REL_PROFILE_ATTRIBUTES));
        return profileDto.withLinks(links);
    }
}
