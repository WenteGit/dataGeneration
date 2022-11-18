package Test.Generate;


import java.io.*;
import java.util.*;

/**
 * @author Wente
 * @date 2022/11/16 14:11
 * tea_stu_msg 师生员工表
 * 数据生成程序
 **/

public class teaStuMsg {
    public static void main(String[] args) throws IOException {
        String wpath = "D:\\AAA\\txt\\teastuID.txt";
        File file = new File(wpath);
        FileWriter fileWriter = new FileWriter(file);
        PrintWriter printWriter = new PrintWriter(fileWriter);
        // 生成30组学生数据和20组老师编号
        String sid = "12003070301";
        String tid = "83521000001";

        ArrayList<String> list = new ArrayList<>();
        for (int i = 0; i < 50; i++) {
            list.add(addLongInteger("4200001",i));
        }

        for (int i = 0; i < 30; i++) {
            printWriter.print(addLongInteger(sid, i)+ "|");
            printWriter.print(dailyMsgReport(list)+"|");
            printWriter.print(createName(i)+"|");
            printWriter.print(createCollege() + "|");
            printWriter.print(createMajor() + "|");
            printWriter.print(createTele()+"|");
            printWriter.print(createID());
            printWriter.println();
        }
        // 生成20组教师信息
        for (int i = 0; i < 20; i++) {
            printWriter.print(addLongInteger(tid,i)+"|");
            printWriter.print(dailyMsgReport(list)+"|");
            printWriter.print(createTeaName(i)+"|");
            printWriter.print(createCollege() + "|");
            printWriter.print(createMajor() + "|");
            printWriter.print(createTele()+"|");
            printWriter.print(createID());
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
    //学生姓名生成
    private static String createName(int i){
        return "学生" + (i+1) + "号";
    }
    // 教师姓名生成
    private static String createTeaName(int i){
        return "教师"+ (i+1) +"号";
    }
    // 学院随机生成
    private static String createCollege(){
        String[] colleges ={"计算机科学与工程学院","车辆工程学院","会计学院","机械学院","材料学院","化工学院"};
        return colleges[new Random().nextInt(colleges.length)];
    }
    // 专业随机生成
    private static String createMajor(){
        String[]majors = {"专业1","专业2","专业3","专业4","专业5","专业6"};
        return majors[new Random().nextInt(majors.length)];
    }
    //电话随机生成
    private static String createTele(){
        StringBuffer stringBuffer = new StringBuffer("1");
        for (int i = 0; i < 10; i++) {
            stringBuffer.append(String.valueOf(new Random().nextInt(10)));
        }
        return stringBuffer.toString();
    }
    //身份证号随机生成
    private static String createID(){
        StringBuffer stringBuffer = new StringBuffer();
        for (int i = 0; i < 18; i++) {
            stringBuffer.append(String.valueOf(new Random().nextInt(10)));
        }
        return stringBuffer.toString();
    }

    // 日常健康信息上报
    // 上报信息编号
    private static String dailyMsgReport( List<String> list){
        int randomIndex = new Random().nextInt(list.size());
        String glsbh = list.get(randomIndex);
        list.remove(randomIndex);
        return glsbh;
    }

}

















