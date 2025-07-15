//===================================================================
// Display.java
//      Description:
//          This class handles the shell output for the ui classes.
//
// Created by etruyj
//===================================================================

package com.socialvagrancy.jiraconnector.ui.display;

import com.socialvagrancy.jiraconnector.ui.display.serializer.Serializer;
import com.socialvagrancy.utils.ui.display.Print;
import com.socialvagrancy.utils.ui.display.Table;
import com.socialvagrancy.utils.ui.structures.OutputFormat;

import java.util.List;

public class Display {
    public static void output(List toPrint, String outputFormat) {
        String format = outputFormat != null ? outputFormat : "table";
    
        List<OutputFormat> print = Serializer.toOutputFormat(toPrint);

        switch(format) {
            case "shell":
                Print.shell(print);
                break;
            case "table":
            case "csv":
                Table.printToShell(print, format);
                break;
        }
    }
}
