//===================================================================
// JqlSearchResultsModel.java
//      Description:
//          A container class for the response from Atlassian when
//          performing a jql query.
//===================================================================

package com.socialvagrancy.jiraconnector.model;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class JqlSearchResultsModel {
    String expand;
    int startAt;
    int maxResults;
    int total;
    Map<String, String> names; // field name map.
    ArrayList<JiraIssueModel> issues;

    public JqlSearchResultsModel() {
        names = new HashMap();
        issues = new ArrayList<JiraIssueModel>();
    }

    //===========================================
    // Getters
    //===========================================

    public String getExpand() { return expand; }
    public int getStartAt() { return startAt; }
    public int getMaxResults() { return maxResults; }
    public int getTotal() { return total; }
    public Map<String, String> getNames() { return names; }
    public ArrayList<JiraIssueModel> getIssues() { return issues; }

    //===========================================
    // Setters
    //===========================================

    public void setExpand(String expand) { this.expand = expand; }
    public void setStartAt(int start_at) { this.startAt = start_at; }
    public void setMaxResults(int max_results) { this.maxResults = max_results; }
    public void setTotal(int total) { this.total = total; }
    public void setNames(Map<String, String> names) { this.names = names; }
    public void setIssues(ArrayList<JiraIssueModel> issues) { this.issues = issues; }
}
