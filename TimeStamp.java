package test1;

import java.sql.Timestamp;
import java.text.SimpleDateFormat;

public class TimeStamp {


    private static final SimpleDateFormat sdf = new SimpleDateFormat("yyyy.MM.dd.HH.mm.ss");

    public static void main(String[] args) {

        //return number of milliseconds since January 1, 1970, 00:00:00 GMT
        Timestamp timestamp = new Timestamp(System.currentTimeMillis());
        System.out.println(timestamp.getTime());


    }

}
