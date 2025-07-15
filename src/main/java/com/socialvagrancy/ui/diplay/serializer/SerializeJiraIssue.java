//===================================================================
// SerializeJiraIssue.java
//      Description:
//          This class converts an List<JiraIssueModel> to List<OutputFormat>
//          for display.
//
// Created by etruyj
//===================================================================

package com.socialvagrancy.jiraconnector.ui.display.serializer;

import com.socialvagrancy.jiraconnector.model.JiraIssueModel;
import com.socialvagrancy.utils.ui.structures.OutputFormat;

import java.util.ArrayList;
import java.util.List;

public class SerializeJiraIssue {
    public static List<OutputFormat> toOutputFormat(List<JiraIssueModel> output) {
        List<OutputFormat> print = new ArrayList<OutputFormat>();
        OutputFormat line;

        for(JiraIssueModel issue : output) {
            line = new OutputFormat();
            line.key = "key";
            line.value = issue.getKey();
            line.indents = 0;
            print.add(line);

            line = new OutputFormat();
            line.key = "summary";
            line.value = issue.getFields().getSummary();
            line.indents = 0;
            print.add(line);

            line = new OutputFormat();
            line.key = "assignee";
            line.value = issue.getFields().getAssignee() != null ? issue.getFields().getAssignee().getDisplayName() : "unassigned";
            line.indents = 0;
            print.add(line);

        }

        return print;
    }
}
