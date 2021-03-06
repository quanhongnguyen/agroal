// Copyright (C) 2017 Red Hat, Inc. and individual contributors as indicated by the @author tags.
// You may not use this file except in compliance with the Apache License, Version 2.0.

package io.agroal.test;

import javax.sql.XAConnection;
import javax.sql.XADataSource;
import java.io.PrintWriter;
import java.sql.SQLException;

import static java.lang.System.identityHashCode;

/**
 * @author <a href="lbarreiro@redhat.com">Luis Barreiro</a>
 */
public interface MockXADataSource extends MockDataSource, XADataSource {

    @Override
    default XAConnection getXAConnection() throws SQLException {
        return new MockXAConnection.Empty();
    }

    @Override
    default XAConnection getXAConnection(String user, String password) throws SQLException {
        return null;
    }

    @Override
    default PrintWriter getLogWriter() throws SQLException {
        return null;
    }

    @Override
    default void setLogWriter(PrintWriter out) throws SQLException {
    }

    @Override
    default int getLoginTimeout() throws SQLException {
        return 0;
    }

    @Override
    default void setLoginTimeout(int seconds) throws SQLException {
    }

    // --- //

    class Empty implements MockXADataSource {

        @Override
        public String toString() {
            return "MockXADataSource@" + identityHashCode( this );
        }
    }

}
