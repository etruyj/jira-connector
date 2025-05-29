//===================================================================
// JiraStatusCategory.java
//      Description:
//          Contains the information on the jira status category object
//===================================================================

package com.socialvagrancy.jiraconnector.model;

public class JiraStatusCategory {
    String self;
    int id;
    String key;
    String colorName;
    String name;

    //===========================================
    // Getters
    //===========================================

    public String getSelf() { return self; }
    public int getId() { return id; }
    public String getKey() { return key; }
    public String getColorName() { return colorName; }
    public String getName() { return name; }

    //===========================================
    // Setters
    //===========================================
    
    public void setSelf(String address) { this.self = address; }
    public void setId(int id) { this.id = id; }
    public void setKey(String key) { this.key = key; }
    public void setColorName(String color) { this.colorName = color; }
    public void setName(String name) { this.name = name; }
}
