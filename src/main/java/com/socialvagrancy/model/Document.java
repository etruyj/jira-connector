//===================================================================
// Document.java
//  Description:
//      An abstract class for the Jira document types.
//===================================================================

package com.socialvagrancy.jiraconnector.model;

import java.util.List;

abstract class Document {
    String type;
    Integer version;
    List<DocumentText> content;

    //===========================================
    // Getters
    //===========================================
    public String getType() { return type; }
    public Integer getVersion() { return version; }
    public List<DocumentText> getContent() { return content; }

    //===========================================
    // Setters
    //===========================================

    public void setType(String type) { this.type = type; }
    public void setVersion(Integer version) { this.version = version; }
    public void setContent(List<DocumentText> content) { this.content = content; }
}
