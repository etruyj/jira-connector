//===================================================================
// JiraIssue.java
//      Description:
//          A container class for jira issue fields.
//===================================================================

package com.socialvagrancy.jiraconnector.model;

import java.time.LocalDate;

public class JiraIssue {
    String expand;
    String id;
    String self;
    String key;
    JiraIssueFields fields;

    public JiraIssue() {
        fields = new JiraIssueFields();
    }

    //===========================================
    // Getters
    //===========================================
    
    public String getExpand() { return expand; }
    public String getId() { return id; }
    public String getSelf() { return self; }
    public String getKey() { return key; }
    public JiraIssueFields getFields() { return fields; }

    //===========================================
    // Setters
    //===========================================

    public void setExpand(String expand) { this.expand = expand; }
    public void setId(String id) { this.id = id; }
    public void setSelf(String url) { this.self = url; }
    public void setKey(String key) { this.key = key; }
    public void setFields(JiraIssueFields fields) { this.fields = fields; }
}
