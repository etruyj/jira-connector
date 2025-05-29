//===================================================================
// Project.java
//      Description:
//          This class handles APIv3 calls associated with Jira Projects
//
// etruyj
//===================================================================

package com.socialvagrancy.jiraconnector.util.http;

import com.google.gson.Gson;
import com.socialvagrancy.jiraconnector.model.JiraProject;
import com.socialvagrancy.utils.http.RestClient;

import org.apache.http.HttpResponse;
import org.apache.http.util.EntityUtils;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Project {
    private static final Logger log = LoggerFactory.getLogger(Project.class);

    public static JiraProject get(String url, String projectId, String basic_auth, RestClient rest_client) throws Exception {
        Gson gson = new Gson();

        String api_call = JiraApiUrls.project(url, projectId);

        log.debug("GET " + api_call);

        HttpResponse response = rest_client.get(api_call, basic_auth);

        String responseStr = EntityUtils.toString(response.getEntity());
        log.debug("RESPONSE: [" + response.getStatusLine().getStatusCode() + "] " + responseStr);

        JiraProject results = gson.fromJson(responseStr, JiraProject.class);

        if(results.getKey() == null) {
            throw new Exception("[FAILED] Could not find project: " + projectId);
        }

        return results;
    }
}
