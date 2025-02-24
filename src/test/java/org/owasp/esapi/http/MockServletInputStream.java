/**
 * OWASP Enterprise Security API (ESAPI)
 *
 * This file is part of the Open Web Application Security Project (OWASP)
 * Enterprise Security API (ESAPI) project. For details, please see
 * <a href="http://www.owasp.org/index.php/ESAPI">http://www.owasp.org/index.php/ESAPI</a>.
 *
 * Copyright (c) 2007 - The OWASP Foundation
 *
 * The ESAPI is published by OWASP under the BSD license. You should read and accept the
 * LICENSE before you use, modify, and/or redistribute this software.
 *
 * @author Jeff Williams <a href="http://www.aspectsecurity.com">Aspect Security</a>
 * @created 2007
 */
package org.owasp.esapi.http;

import jakarta.servlet.ReadListener;
import jakarta.servlet.ServletInputStream;
import java.io.IOException;

/**
 *
 * @author jwilliams
 */
public class MockServletInputStream extends ServletInputStream {

    private byte[] body;

    private int next;

    private boolean isDone = false;
    /**
     * constructor
     * @param body
     */
    public MockServletInputStream(byte[] body) {
        this.body = body;
    }

    /**
     * read
     * @return the next char from this InputStream
     * @throws IOException
     */
    public int read() throws IOException {
        if (next < body.length) {
            return body[next++];
        } else {
            isDone = true;
            return -1;
        }
    }

    @Override
    public boolean isFinished() {
        return isDone;
    }

    @Override
    public boolean isReady() {
        return false;
    }

    @Override
    public void setReadListener(ReadListener readListener) {
        //NO_OP
    }
}
