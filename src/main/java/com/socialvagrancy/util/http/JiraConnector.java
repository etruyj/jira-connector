//===================================================================
// JiraConnector.java
//      Description:
//          This class is the interface for the API calls to Jira.
//          All calls will pass through this function.
//
// Created by etruyj
//===================================================================

package com.socialvagrancy.jiraconnector.util.http;

import com.socialvagrancy.jiraconnector.model.JiraProjectModel;
import com.socialvagrancy.jiraconnector.model.JqlSearchModel;
import com.socialvagrancy.jiraconnector.model.JqlSearchResultsModel;
import com.socialvagrancy.utils.http.RestClient;

import java.util.Base64;
import java.util.List;

public class JiraConnector {
    private RestClient rest_client;
    private String url;
    private String basic_auth;

    public JiraConnector(String url, String username, String api_key, RestClient client) {
        this.rest_client = client;
        this.url = url;
        this.basic_auth = "Basic " + Base64.getEncoder().encodeToString((username + ":" + api_key).getBytes());
    }

    //===========================================
    // Functions
    //===========================================
    public JqlSearchResultsModel jqlSearch(JqlSearchModel search) throws Exception {
        return JqlSearchRequest.query(search, url, basic_auth, rest_client);    
    }

    public List<JiraProjectModel> listProjects() throws Exception {
        return ProjectsRequest.list(url, basic_auth, rest_client);
    }
}
