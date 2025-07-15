//===================================================================
// JiraConfig.java
//      Description:
//          This class holds the configuration information for the
//          Jira projects.
//
// Created by etruyj
//===================================================================

package com.socialvagrancy.jiraconnector.model;

import java.util.List;
import java.util.Map;

public class JiraConfig {
    private JiraServerConfig server;
    private String defaultProject;
    private Integer pageLength;
    private Map<String, String> customFieldsMap;
    private List<String> issueFields;

    //===========================================
    // Getter
    //===========================================
    public JiraServerConfig getServer() { return server; }
    public String getDefaultProject() { return defaultProject; }
    public Integer getPageLength() { return pageLength; }
    public Map<String, String> getCustomFieldsMap() { return customFieldsMap; }
    public List<String> getIssueFields() { return issueFields; }

    //===========================================
    // Setter
    //===========================================
    public void setServer(JiraServerConfig server) { this.server = server; }
    public void setDefaultProject(String project) { this.defaultProject = project; }
    public void setPageLength(Integer length) { this.pageLength = length; }
    public void setCustomFieldsMap(Map<String, String> map) { this.customFieldsMap = map; }
    public void setIssueFields(List<String> fields) { this.issueFields = fields; }
}
