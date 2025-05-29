//===================================================================
// JiraConfig.java
//      Description:
//          This class holds the configuration information for the
//          Jira connection.
//
// Created by etruyj
//===================================================================

package com.socialvagrancy.jiraconnector.model;

public class JiraConfig {
    private String url;
    private String email;
    private String apiKey;
    private boolean ignoreSsl;

    //===========================================
    // Getter
    //===========================================
    public String getUrl() { return url; }
    public String getEmail() { return email; }
    public String getApiKey() { return apiKey;}
    public boolean isIgnoreSsl() { return ignoreSsl; }

    //===========================================
    // Setter
    //===========================================
    public void setUrl(String url) { this.url = url; }
    public void setEmail(String email) { this.email = email; }
    public void setApiKey(String key) { this.apiKey = key; }
    public void setIgnoreSsl(boolean ignore) { this.ignoreSsl = ignore; }
}
