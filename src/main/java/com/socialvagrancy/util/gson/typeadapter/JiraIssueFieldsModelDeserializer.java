//======================================================================
// JiraIssueFieldsDeserializer.java
//      Description:
//          Custom deserializer for JiraIssueFields that parses known fields
//          directly and stores all unknown/custom fields in a map.
//
// Created by etruyj
//======================================================================

package com.socialvagrancy.jiraconnector.util.gson.typeadapter;

import com.google.gson.JsonDeserializer;
import com.google.gson.JsonDeserializationContext;
import com.google.gson.JsonParseException;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;

import com.socialvagrancy.jiraconnector.model.DocumentText;
import com.socialvagrancy.jiraconnector.model.JiraIssueFieldsModel;
import com.socialvagrancy.jiraconnector.model.JiraIssueType;
import com.socialvagrancy.jiraconnector.model.JiraProjectModel;
import com.socialvagrancy.jiraconnector.model.JiraStatus;
import com.socialvagrancy.jiraconnector.model.JiraUserModel;

import java.lang.reflect.Type;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class JiraIssueFieldsModelDeserializer implements JsonDeserializer<JiraIssueFieldsModel> {
    @Override
    public JiraIssueFieldsModel deserialize(JsonElement json, Type typeOfT, JsonDeserializationContext context) throws JsonParseException {
        JsonObject jsonObj = json.getAsJsonObject();
        JiraIssueFieldsModel fields = new JiraIssueFieldsModel();

        if (jsonObj.has("summary")) {
            fields.setSummary(jsonObj.get("summary").getAsString());
        }

        if (jsonObj.has("assignee") && !jsonObj.get("assignee").isJsonNull()) {
            JiraUserModel assignee = context.deserialize(jsonObj.get("assignee"), JiraUserModel.class);
            fields.setAssignee(assignee);
        }

        if (jsonObj.has("project") && !jsonObj.get("project").isJsonNull()) {
            JiraProjectModel project = context.deserialize(jsonObj.get("project"), JiraProjectModel.class);
            fields.setProject(project);
        }

        if (jsonObj.has("issuetype") && !jsonObj.get("issuetype").isJsonNull()) {
            JiraIssueType issuetype = context.deserialize(jsonObj.get("issuetype"), JiraIssueType.class);
            fields.setIssuetype(issuetype);
        }

        if (jsonObj.has("status") && !jsonObj.get("status").isJsonNull()) {
            JiraStatus status = context.deserialize(jsonObj.get("status"), JiraStatus.class);
            fields.setStatus(status);
        }

        if (jsonObj.has("description") && !jsonObj.get("description").isJsonNull()) {
            DocumentText description = context.deserialize(jsonObj.get("description"), DocumentText.class);
            fields.setDescription(description);
        }

        if (jsonObj.has("duedate") && !jsonObj.get("duedate").isJsonNull()) {
            fields.setDueDate(jsonObj.get("duedate").getAsString());
        }

        // Handle all custom fields dynamically
        Map<String, Object> customFields = new HashMap<>();
        Set<Map.Entry<String, JsonElement>> entries = jsonObj.entrySet();

        for (Map.Entry<String, JsonElement> entry : entries) {
            String key = entry.getKey();
            if (key.startsWith("customfield_")) {
                customFields.put(key, context.deserialize(entry.getValue(), Object.class));
            }
        }

        fields.setCustomFields(customFields);
        return fields;
    }
}
