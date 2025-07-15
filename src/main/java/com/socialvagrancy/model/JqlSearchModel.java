//======================================================================
// JqlSearchModel.java
//      Description:
//          This class represents a model for performing JQL search queries
//          in Jira via its REST API. It includes fields for controlling the
//          JQL string, result expansion, result limits, pagination tokens,
//          filtering options, and additional properties to reconcile issues.
//
// Created by etruyj
//======================================================================

package com.socialvagrancy.jiraconnector.model;

import com.google.gson.annotations.SerializedName;
import java.util.List;

public class JqlSearchModel {
    private String expand;
    private List<String> fields;
    @SerializedName("fieldsByKeys")
    private boolean fields_by_keys;
    private String jql;
    @SerializedName("maxResults")
    private int max_results;
    @SerializedName("nextPageToken")
    private String next_page_token;
    private List<String> properties;
    @SerializedName("reconcileIssues")
    private List<Integer> reconcile_issues;

    //===========================================
    // Getters
    //===========================================
    public String getExpand() { return expand; }
    public List<String> getFields() { return fields; }
    public List<Integer> getReconcileIssues() { return reconcile_issues; }
    public List<String> getProperties() { return properties; }
    public String getNextPageToken() { return next_page_token; }
    public int getMaxResults() { return max_results; }
    public String getJql() { return jql; }
    public boolean isFieldsByKeys() { return fields_by_keys; }
    
    //===========================================
    // Setters
    //===========================================
    public void setExpand(String expand) { this.expand = expand; }
    public void setFields(List<String> fields) { this.fields = fields; }
    public void setFieldsByKeys(boolean fields_by_keys) { this.fields_by_keys = fields_by_keys; }
    public void setJql(String jql) { this.jql = jql; }
    public void setMaxResults(int max_results) { this.max_results = max_results; }
    public void setNextPageToken(String next_page_token) { this.next_page_token = next_page_token; }
    public void setProperties(List<String> properties) { this.properties = properties; }
    public void setReconcileIssues(List<Integer> reconcile_issues) { this.reconcile_issues = reconcile_issues; }
}

