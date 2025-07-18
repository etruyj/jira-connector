//===================================================================
// JiraIssueModel.java
//      Description:
//          A container class for jira issue fields.
//===================================================================

package com.socialvagrancy.jiraconnector.model;

import java.time.LocalDate;

public class JiraIssueModel { 
    String expand;
    String id;
    String self;
    String key;
    JiraIssueFieldsModel fields;

    public JiraIssueModel() {
        fields = new JiraIssueFieldsModel();
    }

    //===========================================
    // Getters
    //===========================================
    
    public String getExpand() { return expand; }
    public String getId() { return id; }
    public String getSelf() { return self; }
    public String getKey() { return key; }
    public JiraIssueFieldsModel getFields() { return fields; }

    //===========================================
    // Setters
    //===========================================

    public void setExpand(String expand) { this.expand = expand; }
    public void setId(String id) { this.id = id; }
    public void setSelf(String url) { this.self = url; }
    public void setKey(String key) { this.key = key; }
    public void setFields(JiraIssueFieldsModel fields) { this.fields = fields; }
}
