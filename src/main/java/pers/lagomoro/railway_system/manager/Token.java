package pers.lagomoro.railway_system.manager;

import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

public class Token {

    private long timestamp;
    private int uid;

    public Token(int uid){
        this.timestamp = this.getDumpTimestamp();
        this.uid = uid;
    }

    public Token(int uid, int second){
        this.timestamp = this.getDumpTimestamp(second);
        this.uid = uid;
    }

    public Token(long timestamp, int uid){
        this.timestamp = timestamp;
        this.uid = uid;
    }

    private long getDumpTimestamp(){
        return this.getDumpTimestamp(TokenManager.TOKEN_TIME);
    }

    private long getDumpTimestamp(int second){
        Calendar calendar = new GregorianCalendar();
        calendar.setTime(new Date());
        calendar.add(calendar.SECOND, second);
        return calendar.getTime().getTime();
    }

    public boolean isDump(){
        return new Date().getTime() > this.getTimestamp();
    }

    public int getUid() {
        return uid;
    }

    public long getTimestamp() {
        return timestamp;
    }
}
