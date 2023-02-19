package AusTMS;

/**
 *
 * @author Lenovo
 */
public class Routineinfrm {
    String Time1,Time2,Time3,day;
    

    public Routineinfrm( String Time1, String Time2, String Time3,String day) {
        
        this.Time1 = Time1;
        this.Time2 = Time2;
        this.Time3 = Time3;
        this.day = day;
    }

    
    public String getTime1() {
        return Time1;
    }

    public String getTime2() {
        return Time2;
    }

    public String getTime3() {
        return Time3;
    }
    public String getDay() {
        return day;
    }

   

    public void setTime1(String Time1) {
        this.Time1 = Time1;
    }

    public void setTime2(String Time2) {
        this.Time2 = Time2;
    }

    public void setTime3(String Time3) {
        this.Time3 = Time3;
    }
    public void setDay(String day) {
        this.day = day;
    }
    
}