//===================================================================
// JiraStatus.java
//      Description:
//          A container class for the jira status field.
//===================================================================

package com.socialvagrancy.jiraconnector.model;

public class JiraStatus {
    String self;
    String description;
    String iconUrl;
    String name; 
    String id;
    JiraStatusCategory statusCategory;

    public JiraStatus() {
        statusCategory = new JiraStatusCategory();
    }

    //===========================================
    // Getters
    //===========================================
    
    public String getSelf() { return self; }
    public String getDescription() { return description; }
    public String getIconUrl() { return iconUrl; }
    public String getName() { return name; }
    public String getId() { return id; }
    public JiraStatusCategory getStatusCategory() { return statusCategory; }
    public String getStatusCategoryName() { return statusCategory.getName(); }


    //===========================================
    // Setters
    //===========================================

    public void setSelf(String url) { this.self = url; }
    public void setDescription(String description) { this.description = description; }
    public void setIconUrl(String url) { this.iconUrl = url; }
    public void setName(String name) { this.name = name; }
    public void setId(String id) { this.id = id; }
    public void setStatusCategory(JiraStatusCategory category) { this.statusCategory = category; }
    public void setStatusCategoryName(String name) { this.statusCategory.setName(name); }
}
