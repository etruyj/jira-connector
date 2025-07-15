//===================================================================
// JiraProjectModel.java
//      Description:
//          This class models the Jira project object returned by the 
//          apiv3.
//
// etruyj
//===================================================================

package com.socialvagrancy.jiraconnector.model;

import java.util.List;

public class JiraProjectModel {
    private String key;
    private String name;
    private List<JiraIssueType> issueTypes;
    
    //===========================================
    // Getters
    //===========================================
    public String getKey() { return key; }
    public String getName() { return name; }
    public List<JiraIssueType> getIssueTypes() { return issueTypes; }

    //===========================================
    // Setters
    //===========================================
    public void setKey(String key) { this.key = key; }
    public void setName(String name) { this.name = name; }
    public void setIssueTypes(List<JiraIssueType> types) { this.issueTypes = types; }
}
