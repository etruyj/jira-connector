//===================================================================
// Issue.java
//      Description:
//          Functions related to interacting with JIRA issues over
//          the API
//
// Created by etruyj
//===================================================================

package com.socialvagrancy.jiraconnector.util.http;

import com.socialvagrancy.jiraconnector.model.JiraIssue;
import com.socialvagrancy.utils.http.RestClient;

import org.apache.http.HttpResponse;
import org.apache.http.util.EntityUtils;

import com.google.gson.Gson;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Issues {
    private static final Logger log = LoggerFactory.getLogger(Issues.class);

    public static JiraIssue post(JiraIssue issue, String url, String basic_auth, RestClient rest_client) throws Exception {
        Gson gson = new Gson();

        String api_call = JiraApiUrls.issue(url, null); // no issue id passed;
        String body = gson.toJson(issue);

        log.debug("POST: " + api_call);
        log.debug("PAYLOAD: " + body);

        HttpResponse response = rest_client.post(api_call, basic_auth, body);

        String responseStr = EntityUtils.toString(response.getEntity());
        log.debug("RESPONSE: [" + response.getStatusLine().getStatusCode() + "] " + responseStr);

        if(response.getStatusLine().getStatusCode() < 300) {
            return gson.fromJson(responseStr, JiraIssue.class);
        } else {
            log.error("[" + response.getStatusLine().getStatusCode() + "] " + responseStr);
            throw new Exception("[FAILED] Unable to create issue: " + issue.getFields().getSummary());
        }
    }

    public static JiraIssue get(String url, String issue_id, String basic_auth, RestClient rest_client) throws Exception {
        Gson gson = new Gson();

        String api_call = JiraApiUrls.issue(url, issue_id);
        JiraIssue issue = null;

        log.debug("GET " + api_call);

        HttpResponse response = rest_client.get(api_call, basic_auth);

        String responseStr = EntityUtils.toString(response.getEntity());
        log.debug("RESPONSE: [" + response.getStatusLine().getStatusCode() + "] " + responseStr);

        if(response.getStatusLine().getStatusCode() < 300) {
            issue = gson.fromJson(responseStr, JiraIssue.class);
        } 
        else {
            if(responseStr.contains("issue does not exist")) {
               throw new Exception("[DOES NOT EXIST] Issue " + issue_id + " does not exist.");
            } else {
                throw new Exception("[" + response.getStatusLine().getStatusCode() + "] " + responseStr);
            }
        }
        
        return issue;
    }
}
