//===================================================================
// JiraIssueFieldsModel.java
//      Description:
//          A container for the different fields tracked in a Jira
//          project. These are limited to the structure/Project fields
//          as this is what we'll convert the data into.
//===================================================================

package com.socialvagrancy.jiraconnector.model;

import com.google.gson.annotations.SerializedName;
import java.time.LocalDate;
import java.util.Map;

public class JiraIssueFieldsModel {
    String summary;
    JiraUserModel assignee;
    JiraProjectModel project;
    JiraIssueType issuetype;
    JiraStatus status;
    DocumentText description;
    String duedate;
    Map<String, Object> customFields;

    public JiraIssueFieldsModel() {}

    //===========================================
    // Getters
    //===========================================
    
    public String getSummary() { return summary; }
    public JiraUserModel getAssignee() { return assignee; }
    public String getAssigneeName() { return assignee.getDisplayName(); }
    public JiraProjectModel getProject() { return project; }
    public JiraIssueType getIssuetype() { return issuetype; }
    public JiraStatus getStatus() { return status; }
    public DocumentText getDescription() { return description; }
    public String getStatusName() { return status.getName(); }
    public LocalDate getDueDate() { 
        if(duedate == null) {
            return null;
        }

        return LocalDate.parse(duedate); 
    }
    public String getDueDateString() { return duedate; }
    public Map<String, Object> getCustomFields() { return customFields; }

    //===========================================
    // Setters
    //===========================================

    public void setSummary(String name) { this.summary = name; }
    public void setAssignee(JiraUserModel assignee) { this.assignee = assignee; }
    public void setProject(JiraProjectModel proj) { this.project = proj; }
    public void setIssuetype(JiraIssueType type) { this.issuetype = type; }
    public void setStatus(JiraStatus status) { this.status = status; }
    public void setDescription(DocumentText desc) { this.description = desc; }
    public void setDueDate(String date) { this.duedate = date; }
    public void setDueDate(LocalDate date) { this.duedate = date.toString(); } 
    public void setCustomFields(Map<String, Object> custom_fields) { this.customFields = custom_fields; }
}
