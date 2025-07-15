//===================================================================
// JqlSearchRequest.java
//      Description:
//          This class handles the REST API calls necessary to make
//          a JQL search for the specified server.
//
// Created by etruyj
//===================================================================

package com.socialvagrancy.jiraconnector.util.http;

import com.google.gson.Gson;

import com.socialvagrancy.jiraconnector.model.JqlSearchResultsModel;
import com.socialvagrancy.jiraconnector.model.JqlSearchModel;
import com.socialvagrancy.utils.http.RestClient;

import org.apache.http.HttpResponse;
import org.apache.http.util.EntityUtils;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class JqlSearchRequest {
    private static final Logger log = LoggerFactory.getLogger(JqlSearchRequest.class);
    private static final Gson gson = new Gson();

    public static JqlSearchResultsModel query(JqlSearchModel search, String baseUrl, String basicAuth, RestClient api) throws Exception {
        String apiCall = JiraApiUrls.jqlSearch(baseUrl);
        String payload = gson.toJson(search);

        log.debug("POST " + apiCall);
        log.debug("PAYLOAD: " + payload);

        HttpResponse response = api.post(apiCall, basicAuth, payload);

        String responseStr = EntityUtils.toString(response.getEntity());
        log.debug("RESPONSE: [" + response.getStatusLine().getStatusCode() + "] " + responseStr);

        if(response.getStatusLine().getStatusCode() < 300) {
            JqlSearchResultsModel results = gson.fromJson(responseStr, JqlSearchResultsModel.class);
            return results;
        } else {
            throw new Exception("[" + response.getStatusLine().getStatusCode() + "]: " + responseStr);
        }
    }
}
