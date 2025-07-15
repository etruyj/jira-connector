//===================================================================
// Serializer.java
//      Description:
//          This class handles the top level serialization call
//          by determining object type and calling the correct
//          serializer.
//
// Created by etruyj
//===================================================================

package com.socialvagrancy.jiraconnector.ui.display.serializer;

import com.socialvagrancy.jiraconnector.model.JiraIssueModel;
import com.socialvagrancy.jiraconnector.model.JiraProjectModel;
import com.socialvagrancy.utils.ui.structures.OutputFormat;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Serializer {
    private static final Logger log = LoggerFactory.getLogger(Serializer.class);

    public static List<OutputFormat> toOutputFormat(List output) {
        if(output != null && output.size() > 0) {
            if(output.get(0) instanceof String) {
                return SerializeString.toOutputFormat(output);
            } else if(output.get(0) instanceof JiraIssueModel) {
                return SerializeJiraIssue.toOutputFormat(output);
            } else if(output.get(0) instanceof JiraProjectModel) {
                return SerializeJiraProject.toOutputFormat(output);
            } else {
                log.debug("Unable to determine output type");
                return new ArrayList<OutputFormat>();
            }
        } else {
            // No output
            log.debug("No output provided.");
            return new ArrayList<OutputFormat>();
        }
    }
}
