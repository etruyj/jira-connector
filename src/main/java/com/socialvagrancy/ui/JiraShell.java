//===================================================================
// JiraShell.java
//      Description:
//          This class is the entry point for the shell script of the
//          tool.
//
// Created by etruyj
//===================================================================

package com.socialvagrancy.jiraconnector.ui;

import com.socialvagrancy.jiraconnector.command.JiraController;
import com.socialvagrancy.jiraconnector.model.JiraConfig;
import com.socialvagrancy.jiraconnector.ui.display.Display;
import com.socialvagrancy.utils.io.Configuration;
import com.socialvagrancy.utils.ui.ArgParser;

import java.util.List;

public class JiraShell {
    public static String configPath;
    
    public static void main(String[] args) {
        ArgParser aparser = new ArgParser();
        aparser.parse(args);
        

        try {
            configPath = aparser.get("config") != null ? aparser.get("config") : "../config.yml";
            
            Configuration.load(configPath, JiraConfig.class);
            JiraConfig config = Configuration.get();
            JiraController conn = new JiraController(config);

            processCommand(aparser, conn);
        } catch(Exception e) {
            System.err.println(e.getMessage());
        }
    }

    public static void processCommand(ArgParser aparser, JiraController conn) {
        List output = null;
        String outputFormat = "table";

        try {
            if(aparser.getBoolean("help")) {
                //Display.print("../lib/options/help.txt");
            } else if(aparser.getBoolean("version")) {
                //Display.print("../lib/options/version.txt");
            } else {
                switch(aparser.getRequired("command")) {
                    case "jql-search":
                        output = conn.jqlSearch(aparser.getRequired("jql"),
                                                aparser.get("page-length"),
                                                aparser.get("page"));
                        break;
                    case "list-issues":
                        output = conn.listIssues(aparser.get("project"),
                                                aparser.get("page-length"),
                                                aparser.get("start-date"),
                                                aparser.get("status"),
                                                aparser.get("status-category"));
                        break;
                    case "list-projects":
                        output = conn.listProjects();
                        break;
                    case "update-customfields":
                        conn.updateJiraConfigCustomfields(aparser.get("project"),
                                aparser.get("page-length"),
                                configPath);
                        break;
                    default:
                        System.err.println("Invalid command [" + aparser.getRequired("command") + "]. Use --help to list available options.");
                        break;
                }

                if(output != null) {
                    Display.output(output, aparser.get("output-format"));
                }   
            }
        } catch(Exception e) {
            System.err.println(e.getMessage());
        }
    }
}

