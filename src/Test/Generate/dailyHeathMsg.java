package Test.Generate;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.math.BigDecimal;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Random;

/**
 * @author Wente
 * @date 2022/11/16
 * daily_heath_msg 日常健康信息表
 * 数据生成程序
 **/
public class dailyHeathMsg {
    public static void main(String[] args) throws IOException {
        String dailyPath = "D:\\AAA\\txt\\daily_heath_msg.txt";
        File file = new File(dailyPath);
        FileWriter fileWriter = new FileWriter(file);
        PrintWriter printWriter = new PrintWriter(fileWriter);
        String dailyId = "4200001";
        // 生成50组学生的日常信息
        for (int i = 0; i < 50; i++) {
            printWriter.print(addLongInteger(dailyId,i)+"|");
            printWriter.print(""+"|");
            printWriter.print(createTempre()+"|");
            printWriter.print(createBody()+"|");
            printWriter.print(nowposi()+"|");
            printWriter.print(ifatschool()+"|");
            printWriter.print(ifleaveCQ()+"|");
            printWriter.print(ifsick()+"|");
            printWriter.print(iftouch()+"|");
            printWriter.print(ifisola()+"|");
            printWriter.print(leaveReason()+"|");
            printWriter.print(portTime());
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

    // 生成体温温度
    private static BigDecimal createTempre(){
        String []temperature = {"37.0","36.5","36.4","36.3","36.7","36.8","36.9","38.0"};
        String tep = temperature[new Random().nextInt(temperature.length)];
        return new BigDecimal(tep);
    }
    // 身体状况
    private static String createBody(){
        String []states = {"身体健康无异常","轻微感冒","身体舒适","身体好","身体倍儿棒","胸闷气短","咳嗽"};
        return states[new Random().nextInt(states.length)];
    }
    // 所处位置
    private static String nowposi(){
        String []pos = {"重庆市巴南区","重庆市渝中区","重庆市渝北区","重庆市巴南区","重庆市巴南区","重庆市巴南区","重庆市巴南区","重庆市巴南区"};
        return pos[new Random().nextInt(pos.length)];
    }
    //是否在校
    private static int ifatschool(){
        int flag = new Random().nextInt(2);
        return flag > 0 ?1:0;
    }
    //是否离渝
    private static int  ifleaveCQ(){
        int flag = new Random().nextInt(2);
        return flag > 0 ?1:0;
    }
    //是否隔离观察
    private static int ifisola(){
        int flag = new Random().nextInt(2);
        return flag > 0 ?1:0;
    }
    //确诊情况
    private static int ifsick(){
        int flag = new Random().nextInt(2);
        return flag > 0 ?1:0;
    }
    //接触史
    private static String iftouch(){
        String [] touchs = {"无接触","一级接触","二级接触","无接触","无接触","无接触","无接触","无接触","无接触","无接触"};
        return touchs[new Random().nextInt(touchs.length)];
    }
    //离渝事由
    private static String leaveReason(){
     String[] reasons = {"回家","比赛","考试","旅游","探亲","出差"};
        return reasons[new Random().nextInt(reasons.length)];
    }
    //上报日期
    private static String portTime(){
        long l = System.currentTimeMillis();
        l = l - new Random().nextInt(1000000000);
        Date date = new Date(l);
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String ftime = format.format(date);
        return ftime;
    }
}
