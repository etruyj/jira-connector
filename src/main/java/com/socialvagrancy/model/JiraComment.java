//===================================================================
// JiraComment.java
//      Description:
//          The container class for comments information returned by
//          the /issue/{issueId}/comment API call.
//===================================================================

package com.socialvagrancy.jiraconnector.model;

public class JiraComment {
    String self;
    String id;
    JiraUser author;
    IssueCommentBody body;
    JiraUser updateAuthor;
    String created_at;
    String updated;
    boolean jsdPublic;

    //===========================================
    // Getters
    //===========================================
    
    public String getSelf() { return self; }
    public String getId() { return id; }
    public JiraUser getAuthor() { return author; }
    public JiraUser getUpdateAuthor() { return updateAuthor; }
    public String getCreatedAt() { return created_at; }
    public String getUpdated() { return updated; }
    public boolean getJsdPublic() { return jsdPublic; }
    
    //===========================================
    // Setters
    //===========================================

    public void setSelf(String url) { this.self = url; }
    public void setId(String id) { this.id = id; }
    public void setAuthor(JiraUser author) { this.author = author; }
    public void setUpdateAuthor(JiraUser author) { this. updateAuthor = author; }
    public void setCreatedAt(String date) { this.created_at = date; }
    public void setUpdated(String date) { this.updated = date; }
    public void setJsdPublic(boolean jsd_public) { this.jsdPublic = jsd_public; }
}
