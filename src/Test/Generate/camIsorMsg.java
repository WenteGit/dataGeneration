package Test.Generate;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Random;

/**
 * @author Wente
 * @date 2022/11/16
 * cam_isor_msg(校园隔离室)
 * 数据生成程序
 **/
public class camIsorMsg {
    public static void main(String[] args) throws IOException {
        String dataPath = "D:\\AAA\\txt\\cam_isor_msg.txt";
        File file = new File(dataPath);
        FileWriter fileWriter = new FileWriter(file);
        PrintWriter printWriter = new PrintWriter(fileWriter);
        String ISORID = "3302000";
        // 生成10个隔离室
        for (int i = 0; i < 10; i++) {
            printWriter.print(addLongInteger(ISORID,i)+"|");
            printWriter.print(createName(i)+"|");
            printWriter.print(createArea(i)+"|");
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

    // 隔离室名称
    private static String createName(int i){
            return (i+1)+"号隔离室";
    }
    // 隔离室地点
    private static  String createArea(int i){
        return (i+1) + "号地点";
    }
    // 隔离室电话
    private static String createTele(){
        StringBuffer stringBuffer = new StringBuffer("1");
        for (int i = 0; i < 10; i++) {
            stringBuffer.append(String.valueOf(new Random().nextInt(10)));
        }
        return stringBuffer.toString();
    }

}
