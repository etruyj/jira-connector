//===================================================================
// JiraCommentResults.java
//      Description:
//          The returned value for the Jira /issue/{issueId}/comments
//          api call.
//===================================================================

package com.socialvagrancy.jiraconnector.model;

import java.util.ArrayList;

public class JiraCommentResults {
    int startAt;
    int maxResults;
    int total;
    ArrayList<JiraComment> comments;

    //===========================================
    // Getters
    //===========================================
    
    public int getStartAt() { return startAt; }
    public int getMaxResults() { return maxResults; }
    public int getTotal() { return total; }
    public ArrayList<JiraComment> getComments() { return comments; }
    
    //===========================================
    // Setters
    //===========================================

    public void setStartAt(int start) { this.startAt = start; }
    public void setMaxResults(int max_results) { this.maxResults = max_results; }
    public void setTotal(int total) { this.total = total; }
    public void setComments(ArrayList<JiraComment> comments) { this.comments = comments; }
}
