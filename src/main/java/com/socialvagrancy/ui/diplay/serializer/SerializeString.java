//===================================================================
// SerializeString.java
//      Description:
//          This class converts an List<String> to List<OutputFormat>
//          for display.
//
// Created by etruyj
//===================================================================

package com.socialvagrancy.jiraconnector.ui.display.serializer;

import com.socialvagrancy.utils.ui.structures.OutputFormat;

import java.util.ArrayList;
import java.util.List;

public class SerializeString {
    public static List<OutputFormat> toOutputFormat(List<String> output) {
        List<OutputFormat> print = new ArrayList<OutputFormat>();
        OutputFormat line;

        for(String text : output) {
            line = new OutputFormat();
            line.key = "message";
            line.value = text;
            line.indents = 0;
            print.add(line);
        }

        return print;
    }
}
