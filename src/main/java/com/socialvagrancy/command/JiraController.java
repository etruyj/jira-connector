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
import com.socialvagrancy.utils.http.RestClient;
import com.socialvagrancy.utils.io.Configuration;

public class JiraController {
    private RestClient rest_client;

    public JiraController() throws Exception {
        String configPath = "../config.yml";
        try {
            Configuration.load(configPath, JiraConfig.class);
            JiraConfig config = Configuration.get();
            rest_client = new RestClient(config.isIgnoreSsl());
        } catch(Exception e) {
            // Create a config if it doesn't exist.
            JiraConfig config = new JiraConfig();
            config.setEmail("user@example.com");
            config.setApiKey("abcdefghijklmnop");
            config.setIgnoreSsl(false);

            Configuration.create(configPath, config, JiraConfig.class);
        }
    }


}
