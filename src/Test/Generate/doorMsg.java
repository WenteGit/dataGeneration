package Test.Generate;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Random;

/**
 * @author Wente
 * @date 2022/11/16
 * door_msg 门岗基本信息
 * 数据生成程序
 **/
// 生成门岗的基本信息
public class doorMsg {
    public static void main(String[] args) throws IOException {
        String dataPath = "D:\\AAA\\txt\\door_msg.txt";
        File file = new File(dataPath);
        FileWriter fileWriter = new FileWriter(file);
        PrintWriter printWriter = new PrintWriter(fileWriter);
        String idStart = "2100001";
        // 生成6个门岗
        for (int i = 0; i < 6; i++) {
            printWriter.print(addLongInteger(idStart,i) + "|");
            printWriter.print(createDoorName(i) + "|");
            printWriter.print(createDoorPosition(i) + "|");
            printWriter.print(createTele()+"|");
            printWriter.print("");
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
    // 生成门岗名称
    private static String createDoorName(int i){
        return "第" + (i+1) + "号门岗";
    }
    // 生成门岗位置
    private static String createDoorPosition(int i){
        return (i+1) + "号位置";
    }
    //电话随机生成
    private static String createTele(){
        StringBuffer stringBuffer = new StringBuffer("1");
        for (int i = 0; i < 10; i++) {
            stringBuffer.append(String.valueOf(new Random().nextInt(10)));
        }
        return stringBuffer.toString();
    }



}
