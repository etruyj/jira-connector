//===================================================================
// ListJiraProjects.java
//      Description:
//          This command pulls a list of projects from Jira and returns
//          them as a list.
//      Note: A Jira project is the over-arching "bucket" for Jira.
//          When working with projects for this app, we're working with
//          Jira issues.
//
// Created by etruyj
//===================================================================

package com.socialvagrancy.jiraconnector.command;

import com.socialvagrancy.jiraconnector.model.JiraProject;
import com.socialvagrancy.jiraconnector.util.http.JiraConnector;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class ListProjects { 
    private static final Logger log = LoggerFactory.getLogger(ListProjects.class);

    public static List<JiraProject> all(JiraConnector jira) throws Exception {
        log.info("Querying Jira for a list of all projects.");

        List<JiraProject> projects = jira.listProjects();

        if(projects == null) {
            throw new Exception("[FAILED] Failed to list Jira projects.");
        }

        log.info("Found (" + projects.size() + ") Jira projects.");

        return projects;
    }
}

