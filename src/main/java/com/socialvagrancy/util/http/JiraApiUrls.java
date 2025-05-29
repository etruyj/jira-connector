//===================================================================
// JiraApiUrls.java
//      Description:
//          A list of Jira's APIs
//===================================================================

package com.socialvagrancy.jiraconnector.util.http;

public class JiraApiUrls {
    private static String api_base_uri = "rest/api/3/";

    public static String issueComment(String url, String id) { return "https://" + url + "/" + api_base_uri + "issue/" + id + "/comment"; }
    public static String issue(String url) { return "https://" + url + "/" + api_base_uri + "issue"; }
    public static String issue(String url, String id) { return "https://" + url + "/" + api_base_uri + "issue/" + id; }
    public static String jqlSearch(String url) { return "https://" + url + "/" + api_base_uri + "search"; }
    public static String project(String url) { return "https://" + url + "/" + api_base_uri + "project"; }
    public static String project(String url, String projectId) { return "https://" + url + "/" + api_base_uri + "project/" + projectId; }
}
