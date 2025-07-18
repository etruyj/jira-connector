//===================================================================
// FetchCustomfields.java
//      Description:
//          This class fetches the customfields from the jira project
//          and updates the configuration with the map of fields to
//          to custome fields.
//
// Created by etruyj
//===================================================================

package com.socialvagrancy.jiraconnector.command;

import com.socialvagrancy.jiraconnector.model.JiraConfig;
import com.socialvagrancy.jiraconnector.model.JqlSearchResultsModel;
import com.socialvagrancy.jiraconnector.util.http.JiraConnector;
import com.socialvagrancy.jiraconnector.util.map.CustomfieldMap;

import java.util.HashMap;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class FetchCustomfields {
    private static final Logger log = LoggerFactory.getLogger(FetchCustomfields.class);

    public static JiraConfig updateConfig(JiraConfig config, String project, int page_length, JiraConnector jira) throws Exception {
        log.info("Updating customfields map in JiraConfig.");
        String jql = "Project=" + project;

        JqlSearchResultsModel results = ListIssues.jqlRawSearch(jql, page_length, null, jira);

        Map<String, String> fields = CustomfieldMap.invert(results.getNames());
        log.info("Mapped (" + fields.size() + ") customfields from project " + project);

        config.setCustomfieldsMap(fields);


        return config;
    }
}
