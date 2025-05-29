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
import com.socialvagrancy.utils.io.Configuration;
import com.socialvagrancy.utils.ui.ArgParser;

import java.util.List;

public class JiraShell {
    public static void main(String[] args) {
        ArgParser aparser = new ArgParser();
        aparser.parse(args);
        
        try {
            JiraController conn = new JiraController();

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
                    default:
                        System.err.println("Invalid command [" + aparser.getRequired("command") + "]. Use --help to list available options.");
                        break;
                }

                if(output != null) {
                    //Display.output(output, aparser.get("output-format") != null ? aparser.get("output-format") : outputFormat);
                }   
            }
        } catch(Exception e) {
            System.err.println(e.getMessage());
        }
    }
}

