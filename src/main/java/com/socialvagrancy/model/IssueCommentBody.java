//===================================================================
// IssueCommentBody.java
//      Description:
//          The container class for the fields in the Jira Issue Comment
//          body.
//===================================================================

package com.socialvagrancy.jiraconnector.model;

import java.util.ArrayList;
import java.util.List;

public class IssueCommentBody {
    private BodyDetails body;

    public IssueCommentBody() {
        body = new BodyDetails();
    }
   
    //===========================================
    // Getters
    //===========================================

    public BodyDetails getBody() { return body; }

    //===========================================
    // Setters
    //===========================================
    
    public void setBody(BodyDetails body) { this.body = body; }
    public void setBodyType(String type) { body.setType(type); }
    public void setVersion(int version) { body.setVersion(version); }
    public void setCommentMention(JiraUser user) { body.setCommentMention(user); }
    public void setCommentText(String text) { body.setCommentText(text); }

    //===========================================
    // Inner Classes
    //===========================================
    
    public class BodyDetails {
        private String type;
        private int version;
        private ArrayList<CommentDetails> content;
    
        public BodyDetails() {
            type = "doc";
            version = 1;
            content = new ArrayList<CommentDetails>();
            CommentDetails details = new CommentDetails();
            content.add(details);
        }
        
        //===========================================
        // Getters
        //===========================================
    
        public String getType() { return type; }
        public int getVersion() { return version; }
        public ArrayList<CommentDetails> getContent() { return content; }
        public CommentDetails getContentDetails(int i) { return content.get(i); }

        //===========================================
        // Setters
        //===========================================

        public void setType(String type) { this.type = type; }
        public void setVersion(int version) { this.version = version; }
        public void setContent(ArrayList<CommentDetails> content) { this.content = content; }
        public void setCommentMention(JiraUser user) { this.content.get(0).addContentMention(user); }
        public void setCommentText(String text) { this.content.get(0).addContentText(text); }
    }

    public class CommentDetails {
        private String type;
        private ArrayList<Document> content;

        public CommentDetails() {
            type = "paragraph";
            content = new ArrayList<>();
        }
        
        //=======================================
        // Getters
        //=======================================
        
        public String getType() { return type; }
        public List<? extends Document> getContent() { return content; }
        public String getContentType(int i) { return content.get(i).getType(); }

        //=======================================
        // Setters
        //=======================================

        public void setType(String type) { this.type = type; }
        public void setContent(ArrayList<Document> content) { this.content = content; }
        public void addContentMention(JiraUser user) {
            DocumentMention mention = new DocumentMention();

            mention.setId(user.getAccountId());
            mention.setText("@" + user.getDisplayName());
            mention.setUserType("APP");

            content.add(mention);
        }
        
        public void addContentText(String text) { 
            DocumentText comment = new DocumentText();

            comment.setText(text);
            content.add(comment);
            
        }
    }

    /*
    public class Comment {
        private String type;
        private String text;

        public Comment() {
            type = "text";
        }

        //=======================================
        // Getters
        //=======================================
        
        public String getType() { return type; }
        public String getText() { return text; }
        
        //=======================================
        // Getters
        //=======================================
        
        public void setType(String type) { this.type = type; }
        public void setText(String text) { this.text = text; }
    }V
    */

}
