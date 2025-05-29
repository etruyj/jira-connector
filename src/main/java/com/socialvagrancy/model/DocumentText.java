//===================================================================
// DocumentText.java
//      Description:
//          Jira text document type.
//===================================================================

package com.socialvagrancy.jiraconnector.model;

import java.util.List;

public class DocumentText extends Document {
    private String text;

    public DocumentText() {
        type = "text";
    }

    //===========================================
    // Getters
    //===========================================
    public String getText() { return text; }

    //===========================================
    // Setters
    //===========================================
    public void setText(String text) { this.text = text; }

}
