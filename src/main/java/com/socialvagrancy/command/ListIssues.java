//===================================================================
// ListIssues.java
//      Description:
//          This class pulls a list of Jira issues associated with
//          the specified project. As Jira doesn't have a pagenated
//          GET /issue call, this is handled through the JQL search
//          API.
//
// Created by etruyj
//===================================================================

package com.socialvagrancy.jiraconnector.command;

import com.socialvagrancy.jiraconnector.model.JiraIssueModel;
import com.socialvagrancy.jiraconnector.model.JqlSearchModel;
import com.socialvagrancy.jiraconnector.model.JqlSearchResultsModel;
import com.socialvagrancy.jiraconnector.util.http.JiraConnector;

import java.util.Arrays;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class ListIssues {
    private static final Logger log = LoggerFactory.getLogger(ListIssues.class);

    public static List<JiraIssueModel> forProject(String project, String status, String statusCategory, String startDateField, String startDate, int pageLength, JiraConnector jira) throws Exception {
        log.info("Searching for jira issues in project [" + project + "].");
        //=== Build the JQL String ===
        StringBuilder jql = new StringBuilder();
        jql.append("Project=" + project);
        if(status != null) jql.append(" AND Status=" + status);
        if(statusCategory != null) jql.append(" AND StatusCategory=" + statusCategory);
        if(startDate != null) jql.append(" AND " + startDateField + ">=" + startDate);


        return jqlIssueSearch(jql.toString(), pageLength, null, jira); // no next page token
    }

    public static List<JiraIssueModel> jqlIssueSearch(String jql, int pageLength, String nextPageToken, JiraConnector jira) throws Exception {
        // A JQL search for issues.
        return jqlRawSearch(jql, pageLength, nextPageToken, jira).getIssues();
    }

    public static JqlSearchResultsModel jqlRawSearch(String jql, int pageLength, String nextPageToken, JiraConnector jira) throws Exception {
        log.info("Performing JQL Query: " + jql.toString());
        JqlSearchModel search = new JqlSearchModel();

        search.setExpand("names");
        search.setFields(Arrays.asList("*all", "-custom"));
        search.setJql(jql);
        search.setMaxResults(pageLength);
        search.setNextPageToken(nextPageToken);
   
        JqlSearchResultsModel results = jira.jqlSearch(search);
        log.info("Retrieved (" + results.getIssues().size() + ") Jira issues.");

        return results;
    }
}
