package Test.Generate;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Random;

/**
 * @author Wente
 * @date 2022/11/17
 * 疫苗接种信息表
 *
 **/
public class vacInoMsg {
    public static void main(String[] args) throws IOException {
        ArrayList<String> stuTeaList = new ArrayList<>();
        for (int i = 0; i < 30; i++) {
            stuTeaList.add(addLongInteger("12003070301",i));
        }
        for (int i = 0; i < 20; i++) {
            stuTeaList.add(addLongInteger("83521000001",i));
        }
        String txtPath = "D:\\AAA\\txt\\vac_ino_msg.txt";
        File file = new File(txtPath);
        FileWriter fileWriter = new FileWriter(file);
        PrintWriter printWriter = new PrintWriter(fileWriter);
        String jzbh = "4512400";
        for (int i = 0; i < 45; i++) {
            printWriter.print(addLongInteger(jzbh,i)+"|");
            printWriter.print(getsid(stuTeaList)+"|");
            printWriter.print(getVccId()+"|");
            printWriter.print(zhusheTime()+"|");
            printWriter.print(zhusheArea()+"|");
            printWriter.print(adverseReaction()+"|");
            printWriter.print(zhusheTimes());
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
    // 注射时间
    private static String zhusheTime(){
        long l = System.currentTimeMillis();
        l = l - new Random().nextInt(1000000000);
        Date date = new Date(l);
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String ftime = format.format(date);
        return ftime;
    }
    // 注射地点
    private static String zhusheArea(){
        String []ares = {"花溪校区足球场","两江校区宿舍楼","两江校区教学楼","花溪校区学生活动中心","花溪校区宿舍楼"};
        return ares[new Random().nextInt(ares.length)];
    }
    // 不良反应
    private static String adverseReaction() {
        return "无";
    }
    // 接种次数
    private static int zhusheTimes(){
        return new Random().nextInt(3) + 1;
    }
    // 学号
    private static String getsid(List list){
        return (String) list.remove(new Random().nextInt(list.size()));
    }
    // 疫苗编号
    private static String getVccId(){
        String cid = "1543200";
        List<String> list = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            list.add(addLongInteger(cid,i));
        }
        return list.get(new Random().nextInt(list.size()));
    }

}
