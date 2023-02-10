
package AusTMS;

import javafx.scene.layout.Pane;

public class UserID {
    private static String userID;
    private static String description;
    private static String javaFXLink;
    private static String javaSocketLink;
    private static String derbyLink;
    private static String graphLink;
    private static String linkedListLink;
    private static String studentID;
    public static String getStudentID(){
        return studentID;
    }
    public static void setStudentID(String studentID){
        UserID.studentID = studentID;
    }
    public static String getGraphLink(){
        return graphLink;
    }
    public static String getLinkedListLink(){
        return linkedListLink;
    }
    public static String getUserID(){
        return userID;
    }
    public static String getJavaFXLink(){
        return javaFXLink;
    }
    public static String getJavaSocketLink(){
        return javaSocketLink;
    }
    public static String getDerbyLink(){
        return derbyLink;
    }
    public static String getDescription(){
        return description;
    }
    public static void setUserID(String userID){
        UserID.userID = userID;
    }
    public static void setDescription(String description){
        UserID.description = description;
    }
    public static void setJavaFXLink(String javaFXLink){
        UserID.javaFXLink = javaFXLink;
    }
    public static void setJavaSocketLink(String javaSocketLink){
        UserID.javaSocketLink = javaSocketLink;
    }
    public static void setDerbyLink(String derbyLink){
        UserID.derbyLink = derbyLink;
    }
    public static void setGraphLink(String graphLink){
        UserID.graphLink = graphLink;
    }
    public static void setLinkedListLink(String linkedListLink){
        UserID.linkedListLink = linkedListLink;
    }
}
