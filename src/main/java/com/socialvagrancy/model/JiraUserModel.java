//===================================================================
// JiraUserModel.java
//      Description:
//          A container class for Jira UserModel Information
//===================================================================

package com.socialvagrancy.jiraconnector.model;

public class JiraUserModel {
    String self;
    String accountId; 
    String emailAddress;
    String displayName;
    boolean active;
    String timeZone;
    String accountType;

    //===========================================
    // Getters
    //===========================================
    
    public String getSelf() { return self; }
    public String getAccountId() { return accountId; }
    public String getEmailAddress() { return emailAddress; }
    public String getDisplayName() { return displayName; }
    public boolean getActive() { return active; }
    public String getTimeZone() { return timeZone; }
    public String getAccountType() { return accountType; }

    //===========================================
    // Setters
    //===========================================

    public void setSelf(String url) { this.self = url; }
    public void setAccountId(String id) { this.accountId = id; }
    public void setEmailAddress(String email) { this.emailAddress = email; }
    public void setDisplayName(String name) { this.displayName = name; }
    public void setActive(boolean active) { this.active = active; }
    public void setTimeZone(String timezone) { this.timeZone = timezone; }
    public void setAccountType(String type) { this.accountType = type; }
}
