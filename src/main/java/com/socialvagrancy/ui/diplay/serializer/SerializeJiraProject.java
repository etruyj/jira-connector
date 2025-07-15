//===================================================================
// SerializeJiraProject.java
//      Description:
//          This class converts an List<JiraProject> to List<OutputFormat>
//          for display.
//
// Created by etruyj
//===================================================================

package com.socialvagrancy.jiraconnector.ui.display.serializer;

import com.socialvagrancy.jiraconnector.model.JiraProject;
import com.socialvagrancy.utils.ui.structures.OutputFormat;

import java.util.ArrayList;
import java.util.List;

public class SerializeJiraProject {
    public static List<OutputFormat> toOutputFormat(List<JiraProject> output) {
        List<OutputFormat> print = new ArrayList<OutputFormat>();
        OutputFormat line;

        for(JiraProject project : output) {
            line = new OutputFormat();
            line.key = "key";
            line.value = project.getKey();
            line.indents = 0;
            print.add(line);

            line = new OutputFormat();
            line.key = "name";
            line.value = project.getName();
            line.indents = 0;
            print.add(line);


        }

        return print;
    }
}
