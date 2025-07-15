//===================================================================
// JiraController.java
//      Description:
//          This class is the primary interface for the application.
//          It serves the back end functionality to UI elements or
//          other scripts.
// 
// Created by etruyj
//===================================================================

package com.socialvagrancy.jiraconnector.command;

import com.socialvagrancy.jiraconnector.model.JiraConfig;
import com.socialvagrancy.jiraconnector.model.JiraIssueModel;
import com.socialvagrancy.jiraconnector.model.JiraProjectModel;
import com.socialvagrancy.jiraconnector.model.JiraServerConfig;
import com.socialvagrancy.jiraconnector.util.http.JiraConnector;
import com.socialvagrancy.utils.http.RestClient;
import com.socialvagrancy.utils.io.Configuration;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class JiraController {
    private static final Logger log = LoggerFactory.getLogger(JiraConnector.class);
    private JiraConfig config;
    private JiraConnector jira;
    private RestClient rest_client;

    public JiraController(JiraConfig c) throws Exception {
        config = c;
        rest_client = new RestClient(config.getServer().isIgnoreSsl());
        jira = new JiraConnector(config.getServer().getUrl(), config.getServer().getEmail(), config.getServer().getApiKey(), rest_client);
    }

    public JiraController(String configPath) throws Exception {
        try {
            Configuration.load(configPath, JiraConfig.class);
            config = Configuration.get();
            rest_client = new RestClient(config.getServer().isIgnoreSsl());
            jira = new JiraConnector(config.getServer().getUrl(), config.getServer().getEmail(), config.getServer().getApiKey(), rest_client);
        } catch(Exception e) {
            // Create a config if it doesn't exist.
            log.error(e.getMessage());
            config = new JiraConfig();
            config.setServer(new JiraServerConfig());
            config.getServer().setEmail("user@example.com");
            config.getServer().setApiKey("abcdefghijklmnop");
            config.getServer().setIgnoreSsl(false);

            //Configuration.create(configPath, config, JiraConfig.class);
        }
    }

    //===========================================
    // Commands
    //===========================================
    public List<JiraIssueModel> jqlSearch(String jql, String page_length, String page) throws Exception {
        int pageLength = config.getPageLength() != null ? config.getPageLength() : 100;
        pageLength = page_length != null ? Integer.valueOf(page_length) : pageLength;
    
        return ListIssues.jqlSearch(jql, pageLength, page, jira);
    }

    public List<JiraIssueModel> listIssues(String project, String page_length, String startDate, String status, String statusCategory) throws Exception {
        // Process default values based on user input and the config file.
        String projectKey = project != null ? project : config.getDefaultProject();
        int pageLength = config.getPageLength() != null ? config.getPageLength() : 100;
        pageLength = page_length != null ? Integer.valueOf(page_length) : pageLength;
    
        return ListIssues.forProject(projectKey, status, statusCategory, startDate, pageLength, jira);
    }

    public List<JiraProjectModel> listProjects() throws Exception {
        return ListProjects.all(jira);
    }
}
