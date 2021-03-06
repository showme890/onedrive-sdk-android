// ------------------------------------------------------------------------------
// Copyright (c) 2015 Microsoft Corporation
// 
// Permission is hereby granted, free of charge, to any person obtaining a copy
// of this software and associated documentation files (the "Software"), to deal
// in the Software without restriction, including without limitation the rights
// to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
// copies of the Software, and to permit persons to whom the Software is
// furnished to do so, subject to the following conditions:
// 
// The above copyright notice and this permission notice shall be included in
// all copies or substantial portions of the Software.
// 
// THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
// IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
// FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
// AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
// LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
// OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN
// THE SOFTWARE.
// ------------------------------------------------------------------------------

package com.onedrive.sdk.generated;

import com.onedrive.sdk.concurrency.*;
import com.onedrive.sdk.core.*;
import com.onedrive.sdk.extensions.*;
import com.onedrive.sdk.http.*;
import com.onedrive.sdk.generated.*;
import com.onedrive.sdk.options.*;
import com.onedrive.sdk.serializer.*;

import java.util.*;

// **NOTE** This file was generated by a tool and any changes will be overwritten.

/**
 * The class for the Base Recent Request.
 */
public class BaseRecentRequest extends BaseCollectionRequest<BaseRecentCollectionResponse, IRecentCollectionPage> implements IBaseRecentRequest {

    /**
     * The request for this Recent
     *
     * @param requestUrl The request url
     * @param client The service client
     * @param options The options for this request
     */
    public BaseRecentRequest(final String requestUrl, final IOneDriveClient client, final List<Option> options) {
        super(requestUrl, client, options, BaseRecentCollectionResponse.class, IRecentCollectionPage.class);
    }

    public void get(final ICallback<IRecentCollectionPage> callback) {
        final IExecutors executors = getBaseRequest().getClient().getExecutors();
        executors.performOnBackground(new Runnable() {
           @Override
           public void run() {
                try {
                    executors.performOnForeground(get(), callback);
                } catch (final ClientException e) {
                    executors.performOnForeground(e, callback);
                }
           }
        });
    }

    public IRecentCollectionPage get() throws ClientException {
        final BaseRecentCollectionResponse response = send();
        return buildFromResponse(response);
    }

    public IRecentRequest select(final String value) {
        addQueryOption(new QueryOption("select", value));
        return (RecentRequest)this;
    }

    public IRecentRequest top(final int value) {
        addQueryOption(new QueryOption("top", value+""));
        return (RecentRequest)this;
    }

    public IRecentRequest expand(final String value) {
        addQueryOption(new QueryOption("expand", value));
        return (RecentRequest)this;
    }

    public IRecentCollectionPage buildFromResponse(final BaseRecentCollectionResponse response) {
        final IRecentRequestBuilder builder;
        if (response.nextLink != null) {
            builder = new RecentRequestBuilder(response.nextLink, getBaseRequest().getClient(), /* options */ null);
        } else {
            builder = null;
        }
        final IRecentCollectionPage page = new RecentCollectionPage(response, builder);
        page.setRawObject(response.getSerializer(), response.getRawObject());
        return page;
    }
}
