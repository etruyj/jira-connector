# JiraConnector
This script is intended to act as connection to Jira Cloud via the Jira API. The intent is to use this as a plug-in for other scripts, but a light-weight shell script is available for testing and CLI interaction with Jira. For scripted access, the main entry-point for the script will be com.socialvagrancy.jiraconnector.command.JiraController. This class can be used to interface with the different APIs with JIRA, returning models or list of models of Jira objects.
## Requirements
This script leverages functionality built into the socialvagrancy.utils package v2.6.0 which can be downloaded from https://github.com/etruyj/sv_utils.
