//===================================================================
// JiraQueryResults.java
//      Description:
//          A container class for the response from Atlassian when
//          performing a jql query.
//===================================================================

package com.socialvagrancy.jiraconnector.model;

import java.util.ArrayList;

public class JiraQueryResults {
    String expand;
    int startAt;
    int maxResults;
    int total;
    ArrayList<JiraIssue> issues;

    public JiraQueryResults() {
        issues = new ArrayList<JiraIssue>();
    }

    //===========================================
    // Getters
    //===========================================

    public String getExpand() { return expand; }
    public int getStartAt() { return startAt; }
    public int getMaxResults() { return maxResults; }
    public int getTotal() { return total; }
    public ArrayList<JiraIssue> getIssues() { return issues; }

    //===========================================
    // Setters
    //===========================================

    public void setExpand(String expand) { this.expand = expand; }
    public void setStartAt(int start_at) { this.startAt = start_at; }
    public void setMaxResults(int max_results) { this.maxResults = max_results; }
    public void setTotal(int total) { this.total = total; }
    public void setIssues(ArrayList<JiraIssue> issues) { this.issues = issues; }
}
