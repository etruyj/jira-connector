//===================================================================
// DocumentMention.java
//      Description:
//          The jira mention document type.
//===================================================================

package com.socialvagrancy.jiraconnector.model;

public class DocumentMention extends Document {
    private Attributes attrs;

    public DocumentMention() {
        attrs = new Attributes();
        type = "mention";
    }

    //===========================================
    // Getters
    //===========================================

    public String getId() { return attrs.getId(); }
    public String getText() { return attrs.getText(); }
    public String getUserType() { return attrs.getUserType(); }

    //===========================================
    // Setters
    //===========================================

    public void setId(String id) { attrs.setId(id); }
    public void setText(String text) { attrs.setText(text); }
    public void setUserType(String user_type) { attrs.setUserType(user_type); }


    //===========================================
    // Private Functions
    //===========================================

    public class Attributes {
        String id;
        String text;
        String userType;

        //=======================================
        // Getters
        //=======================================

        public String getId() { return id; }
        public String getText() { return text; }
        public String getUserType() { return userType; }

        //=======================================
        // Settors
        //=======================================

        public void setId(String id) { this.id = id; }
        public void setText(String text) { this.text = text; }
        public void setUserType(String userType) { this.userType = userType; }
    }
}
