//
//  ========================================================================
//  Copyright (c) 1995-2017 Mort Bay Consulting Pty. Ltd.
//  ------------------------------------------------------------------------
//  All rights reserved. This program and the accompanying materials
//  are made available under the terms of the Eclipse Public License v1.0
//  and Apache License v2.0 which accompanies this distribution.
//
//      The Eclipse Public License is available at
//      http://www.eclipse.org/legal/epl-v10.html
//
//      The Apache License v2.0 is available at
//      http://www.opensource.org/licenses/apache2.0.php
//
//  You may elect to redistribute this code under either of these licenses.
//  ========================================================================
//

package org.eclipse.jetty.websocket.tests;

import org.eclipse.jetty.websocket.core.scopes.WebSocketContainerScope;
import org.junit.rules.TestName;

public class CloseableLocalWebSocketSession extends LocalWebSocketSession implements AutoCloseable
{
    public CloseableLocalWebSocketSession(WebSocketContainerScope containerScope, TestName testname, Object websocket)
    {
        super(containerScope, testname, websocket);
        // LifeCycle start
        try
        {
            start();
        }
        catch (Exception e)
        {
            throw new RuntimeException(e);
        }
    }

    @Override
    public void close()
    {
        // WebSocketSession.close();
        super.close();

        // LifeCycle Stop
        try
        {
            stop();
        }
        catch (Exception e)
        {
            throw new RuntimeException(e);
        }
    }
}
