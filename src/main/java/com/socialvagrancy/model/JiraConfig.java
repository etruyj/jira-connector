//===================================================================
// JiraConfig.java
//      Description:
//          This class holds the configuration information for the
//          Jira projects.
//
// Created by etruyj
//===================================================================

package com.socialvagrancy.jiraconnector.model;

public class JiraConfig {
    private JiraServerConfig server;
    private String defaultProject;
    private Integer pageLength;

    //===========================================
    // Getter
    //===========================================
    public JiraServerConfig getServer() { return server; }
    public String getDefaultProject() { return defaultProject; }
    public Integer getPageLength() { return pageLength; }

    //===========================================
    // Setter
    //===========================================
    public void setServer(JiraServerConfig server) { this.server = server; }
    public void setDefaultProject(String project) { this.defaultProject = project; }
    public void setPageLength(Integer length) { this.pageLength = length; }
}
