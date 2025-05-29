//===================================================================
// Comment.java
//      Description:
//          Functions related to Jira issue comments.
//
// Created by etruyj
//===================================================================

package com.socialvagrancy.jiraconnector.util.http;

import com.socialvagrancy.jiraconnector.model.JiraIssue;
import com.socialvagrancy.jiraconnector.model.JiraCommentResults;
import com.socialvagrancy.jiraconnector.model.IssueCommentBody;
import com.socialvagrancy.utils.http.RestClient;

import org.apache.http.HttpResponse;
import org.apache.http.util.EntityUtils;

import com.google.gson.Gson;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Comment {
    private static final Logger log = LoggerFactory.getLogger(Comment.class);

    public static JiraCommentResults post(String url, String issue_id, IssueCommentBody comment, String basic_auth, RestClient rest_client) throws Exception {
        Gson gson = new Gson();

        String api_call = JiraApiUrls.issueComment(url, issue_id);
        String body = gson.toJson(comment);

        log.debug("POST " + api_call);
        log.debug("PAYLOAD: " + body);

        HttpResponse response = rest_client.post(api_call, "Authorization", basic_auth, body);

        String responseStr = EntityUtils.toString(response.getEntity());
        log.debug("RESPONSE: [" + response.getStatusLine().getStatusCode() + "] " + responseStr);

        JiraCommentResults results = gson.fromJson(responseStr, JiraCommentResults.class);

        return results;
    }
}
