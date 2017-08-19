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
package org.eclipse.che.ide.api.machine.execagent;

import com.google.inject.Inject;
import com.google.inject.Singleton;

import org.eclipse.che.api.core.jsonrpc.commons.RequestHandlerConfigurator;
import org.eclipse.che.api.machine.shared.dto.execagent.event.ProcessDiedEventDto;
import org.eclipse.che.ide.util.loging.Log;

/**
 * Handles event fired by exec agent when process died
 *
 * @author Dmitry Kuleshov
 */
@Singleton
public class ProcessDiedEventHandler extends AbstractExecAgentEventHandler<ProcessDiedEventDto> {

    @Inject
    public void configureHandler(RequestHandlerConfigurator configurator) {
        configurator.newConfiguration()
                    .methodName("process_died")
                    .paramsAsDto(ProcessDiedEventDto.class)
                    .noResult()
                    .withBiConsumer(this);
    }

    @Override
    public void accept(String endpointId, ProcessDiedEventDto params) {
        Log.debug(getClass(), "Handling process died event. Params: " + params);
        handle(endpointId, params);
    }
}
