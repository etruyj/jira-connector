//===================================================================
// JiraIssueType.java
//      Description:
//          This class models the issue type returned by the Jira
//          api/3 api.
//
// etruyj
//===================================================================

package com.socialvagrancy.jiraconnector.model;

import com.google.gson.annotations.SerializedName;

public class JiraIssueType {
    private String self;
    private String id;
    private String description;
    private String icon_url;
    private String name;
    private Boolean subtask;
    @SerializedName("avatarId")
    private Integer avatar_id;
    @SerializedName("hierarchyLevel")
    private Integer hierarchy_level;

    public JiraIssueType() {}

    public JiraIssueType(String self, String id, String description, String icon_url, String name, Boolean subtask, Integer avatar_id, Integer hierarchy_level) {
        this.self = self;
        this.id = id;
        this.description = description;
        this.icon_url = icon_url;
        this.name = name;
        this.subtask = subtask;
        this.avatar_id = avatar_id;
        this.hierarchy_level = hierarchy_level;
    }

    //===========================================
    // Getters
    //===========================================
    public String getSelf() { return self; }
    public String getId() { return id; }
    public String getDescription() { return description; }
    public String getIconUrl() { return icon_url; }
    public String getName() { return name; }
    public Boolean isSubtask() { return subtask; }
    public Integer getAvatarId() { return avatar_id; }
    public Integer getHierarchyLevel() { return hierarchy_level; }

    //===========================================
    // Setters
    //===========================================
    public void setSelf(String self) { this.self = self; }
    public void setId(String id) { this.id = id; }
    public void setDescription(String description) { this.description = description; }
    public void setIconUrl(String icon_url) { this.icon_url = icon_url; }
    public void setName(String name) { this.name = name; }
    public void setSubtask(Boolean subtask) { this.subtask = subtask; }
    public void setAvatarId(Integer avatar_id) { this.avatar_id = avatar_id; }
    public void setHierarchyLevel(Integer hierarchy_level) { this.hierarchy_level = hierarchy_level; }
}

