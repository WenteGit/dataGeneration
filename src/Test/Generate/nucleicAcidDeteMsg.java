package Test.Generate;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Random;

/**
 * @author Wente
 * @date 2022/11/17
 * nucleicAcid_dete_msg 核酸检测情况表
 * 数据生成程序
 **/
public class nucleicAcidDeteMsg {

    public static void main(String[] args) throws IOException {


        String jcID = "6532000";
        String txtPath = "D:\\AAA\\txt\\nucleicAcid_dete_msg.txt";
        File file = new File(txtPath);
        FileWriter fileWriter = new FileWriter(file);
        PrintWriter printWriter = new PrintWriter(fileWriter);
        long l = System.currentTimeMillis();
        //生成200组检测信息
        for (int i = 0; i < 200; i++) {
            l = l - new Random().nextInt(5000000);
            printWriter.print(addLongInteger(jcID,i)+"|");
            printWriter.print(getsid()+"|");
            printWriter.print(getjigou()+"|");
            printWriter.print(getresult()+"|");
            printWriter.print(getTime(l)+"|");
            printWriter.print("日常检测");
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

    // 随机指定某个师生
    private static String getsid(){
        ArrayList<String> list = new ArrayList<>();
        for (int i = 0; i < 30; i++) {
            list.add(addLongInteger("12003070301",i));
        }
        for (int i = 0; i < 20; i++) {
            list.add(addLongInteger("83521000001",i));
        }
        return list.get(new Random().nextInt(list.size()));
    }
    // 随机指定一个机构
    private static String getjigou(){
        ArrayList<String> list = new ArrayList<>();
        for (int i = 0; i < 30; i++) {
            list.add(addLongInteger("1200001",i));
        }
        return list.get(new Random().nextInt(list.size()));
    }
    // 检测结果
    private static String getresult(){
        ArrayList<String> list = new ArrayList<>();
        for (int i = 0; i < 50; i++) {
            list.add("阴性");
        }
        list.add("阳性");
        return list.get(new Random().nextInt(list.size()));
    }
    // 检测时间
    private static String getTime(long jctime){
        Date date = new Date(jctime);
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String ftime = format.format(date);
        return ftime;
    }

}
