package Test.Generate;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Time;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Random;

/**
 * @author Wente
 * @date 2022/11/17
 * isolation_msg 隔离记录信息表
 * 数据生成程序
 **/
public class isolationMsg {
    public static void main(String[] args) throws IOException {
        ArrayList<String> stuTeaList = new ArrayList<>();
        for (int i = 0; i < 30; i++) {
            stuTeaList.add(addLongInteger("12003070301",i));
        }
        for (int i = 0; i < 20; i++) {
            stuTeaList.add(addLongInteger("83521000001",i));
        }
        String glbh = "6302100";
        String wpath = "D:\\AAA\\txt\\isolation_msg.txt";
        File file = new File(wpath);
        FileWriter fileWriter = new FileWriter(file);
        PrintWriter printWriter = new PrintWriter(fileWriter);
        // 随机生成隔离时间
        long l = System.currentTimeMillis();
        // 任意取5个人隔离
        for (int i = 0; i < 5; i++) {
            l = l - new Random().nextInt(52012054)-10250545;
            printWriter.print(addLongInteger(glbh,i)+"|");
            printWriter.print(getSid(stuTeaList)+"|");
            printWriter.print(getbds()+"|");
            printWriter.print(glsbh()+"|");
            printWriter.print(scrq(l)+"|");
            printWriter.print(glTime()+"|");
            printWriter.print(glReason());
            printWriter.println();
        }
        printWriter.close();
    }



    // 长整数加法器
    private static String addLongInteger(String str, int num){
        int ci = 0;
        StringBuffer sb = new StringBuffer();
        for(int i = str.length() -1 ; i>=0 ;i--){
            int tempnum = (str.charAt(i) - 48) + ci +num;
            ci = 0;
            num = 0;
            if (tempnum >= 10){
                ci = tempnum/10;
                tempnum = tempnum %10;
            }
            sb.append(String.valueOf(tempnum));
        }
        return sb.reverse().toString();
    }
    // 隔离时间
    private static String scrq(long scrq){
        Date date = new Date(scrq);
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String ftime = format.format(date);
        return ftime;
    }
    // 隔离时长
    private static String glTime(){
        int hour = new Random().nextInt(24);
        int minute = new Random().nextInt(60);
        int seconds = new Random().nextInt(60);

        String h_str ;  String m_str ;  String s_str ;
        if (hour>=10){
            h_str = String.valueOf(hour);
        }
        else{
            h_str = "0"+ hour;
        }

        if (minute>=10){
            m_str = String.valueOf(minute);
        }
        else{
            m_str = "0"+ minute;
        }

        if (seconds>=10){
            s_str = String.valueOf(seconds);
        }
        else{
            s_str = "0"+ seconds;
        }
        return h_str+":"+m_str+":"+s_str;
    }
    // 隔离原因
    private static String glReason(){
        String []reason = {"核酸检测异常","健康码异常","行程码异常","场所码异常","中高风险地区返校","有明显身体异常情况"};
        return reason[new Random().nextInt(reason.length)];
    }
    // 学号
    private static String getSid(List list){
        return (String) list.remove(new Random().nextInt(list.size()));
    }
    // 班导师工号
    private static String getbds(){
        ArrayList<String> list = new ArrayList<>();
        String tid = "83521000001";
        for (int i = 0; i < 10; i++) {
            list.add(addLongInteger(tid,i));
        }
        return list.get(new Random().nextInt(list.size()));
    }
    // 隔离室编号
    private static String glsbh(){
        String ISORID = "3302000";
        ArrayList<String> list = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            list.add(addLongInteger(ISORID,i));
        }
        return list.get(new Random().nextInt(list.size()));
    }
}
