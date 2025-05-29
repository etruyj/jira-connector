//===================================================================
// Project.java
//      Description:
//          This class handles APIv3 calls associated with Jira Projects
//
// etruyj
//===================================================================

package com.socialvagrancy.jiraconnector.util.http;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import com.socialvagrancy.jiraconnector.model.JiraProject;
import com.socialvagrancy.utils.http.RestClient;

import org.apache.http.HttpResponse;
import org.apache.http.util.EntityUtils;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Projects {
    private static final Gson gson = new Gson();
    private static final Logger log = LoggerFactory.getLogger(Projects.class);

    public static JiraProject get(String url, String projectId, String basic_auth, RestClient rest_client) throws Exception {
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
    
    public static List<JiraProject> list(String url, String basic_auth, RestClient rest_client) throws Exception {
        String api_call = JiraApiUrls.project(url);

        log.debug("GET " + api_call);

        HttpResponse response = rest_client.get(api_call, basic_auth);

        String responseStr = EntityUtils.toString(response.getEntity());
        log.debug("RESPONSE: [" + response.getStatusLine().getStatusCode() + "] " + responseStr);

        List<JiraProject> results = gson.fromJson(responseStr, new TypeToken<List<JiraProject>>() {}.getType());

        if(results != null && results.get(0).getKey() == null) {
            throw new Exception("[FAILED] Could not list projects");
        }

        return results;
    }
}
