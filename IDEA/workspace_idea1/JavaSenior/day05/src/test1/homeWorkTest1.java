package test1;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @author TJ
 * @create 2021-05-06  16:12
 */
public class homeWorkTest1 {
    public static void main(String[] args) {
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
//        simpleDateFormat.format("2017-08-16");
        Date parse = null;
        try {
            parse = simpleDateFormat.parse("2017-08-16");
        } catch (ParseException e) {
            e.printStackTrace();
        }
        System.out.println(parse);
    }
}
