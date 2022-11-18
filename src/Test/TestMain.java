package Test;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @author Wente
 * @date 2022/11/16
 **/
public class TestMain {
    public static void main(String[] args) {
        long l = System.currentTimeMillis();
        Date date = new Date(l);
        System.out.println(date);
    }
}
