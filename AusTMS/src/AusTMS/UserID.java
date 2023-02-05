
package AusTMS;

public class UserID {
    private static String userID;
    public static String getUserID(){
        return userID;
    }
    public static void setUserID(String userID){
        UserID.userID = userID;
    }
}
