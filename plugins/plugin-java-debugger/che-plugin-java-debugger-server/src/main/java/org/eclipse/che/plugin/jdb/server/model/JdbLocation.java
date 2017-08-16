/*******************************************************************************
 * Copyright (c) 2012-2017 Red Hat, Inc.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *   Red Hat, Inc. - initial API and implementation
 *******************************************************************************/
package org.eclipse.che.plugin.jdb.server.model;

import com.sun.jdi.StackFrame;

import org.eclipse.che.api.debug.shared.model.Location;
import org.eclipse.che.api.debug.shared.model.Method;
import org.eclipse.che.api.debug.shared.model.impl.LocationImpl;
import org.eclipse.che.api.debugger.server.exceptions.DebuggerException;
import org.eclipse.che.plugin.jdb.server.utils.JavaDebuggerUtils;

/**
 * {@link org.eclipse.che.api.debug.shared.model.Location} implementation for Java debugger.
 *
 * @author Anatolii Bazko
 */
public class JdbLocation implements Location {
    private static final JavaDebuggerUtils debuggerUtil = new JavaDebuggerUtils();

    private final Method   method;
    private final Location location;

    public JdbLocation(StackFrame stackFrame) {
        this(stackFrame, new JdbMethod(stackFrame));
    }

    public JdbLocation(StackFrame stackFrame, Method method) {
        this.location = getLocation(stackFrame.location());
        this.method = method;
    }

    @Override
    public String getTarget() {
        return location.getTarget();
    }

    @Override
    public int getLineNumber() {
        return location.getLineNumber();
    }

    @Override
    public String getResourcePath() {
        return location.getResourcePath();
    }

    @Override
    public boolean isExternalResource() {
        return location.isExternalResource();
    }

    @Override
    public int getExternalResourceId() {
        return location.getExternalResourceId();
    }

    @Override
    public String getResourceProjectPath() {
        return location.getResourceProjectPath();
    }

    @Override
    public Method getMethod() {
        return method;
    }

    private Location getLocation(com.sun.jdi.Location jdiLocation) {
        try {
            return debuggerUtil.getLocation(jdiLocation);
        } catch (DebuggerException e) {
            return new LocationImpl(jdiLocation.declaringType().name(), jdiLocation.lineNumber());
        }
    }
}
