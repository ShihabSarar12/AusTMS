package AusTMS;

public class Routineinfrm {
    String Time1,Time2,Time3;
    public Routineinfrm( String Time1, String Time2, String Time3) {
        
        this.Time1 = Time1;
        this.Time2 = Time2;
        this.Time3 = Time3;
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
    public void setTime1(String Time1) {
        this.Time1 = Time1;
    }
    public void setTime2(String Time2) {
        this.Time2 = Time2;
    }
    public void setTime3(String Time3) {
        this.Time3 = Time3;
    }
}