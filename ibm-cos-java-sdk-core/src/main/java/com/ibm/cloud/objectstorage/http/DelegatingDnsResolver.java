/*
 * Copyright 2015-2017 Amazon.com, Inc. or its affiliates. All Rights Reserved.
 *
 * Licensed under the Apache License, Version 2.0 (the "License").
 * You may not use this file except in compliance with the License.
 * A copy of the License is located at
 *
 *  http://aws.amazon.com/apache2.0
 *
 * or in the "license" file accompanying this file. This file is distributed
 * on an "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either
 * express or implied. See the License for the specific language governing
 * permissions and limitations under the License.
 */
package com.ibm.cloud.objectstorage.http;

import java.net.InetAddress;
import java.net.UnknownHostException;

import cz.msebera.android.httpclient.conn.DnsResolver;

/**
 * Implements the {@link cz.msebera.android.httpclient.conn.DnsResolver} interface,
 * taking in a {@link com.ibm.cloud.objectstorage.DnsResolver} implementation and executing its
 * {@link com.ibm.cloud.objectstorage.DnsResolver#resolve(String)} method to perform the
 * actual DNS resolution.
 */
public class DelegatingDnsResolver implements DnsResolver {

    private final com.ibm.cloud.objectstorage.DnsResolver delegate;

    public DelegatingDnsResolver(com.ibm.cloud.objectstorage.DnsResolver delegate) {
        this.delegate = delegate;
    }

    @Override
    public InetAddress[] resolve(String host) throws UnknownHostException {
        return delegate.resolve(host);
    }
}
