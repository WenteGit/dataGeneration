package Test.Generate;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 * @author Wente
 * @date 2022/11/17
 * 班导师信息表
 **/
public class classTeaMsg {
    public static void main(String[] args) throws IOException {
        String txtPath = "D:\\AAA\\txt\\class_tea_msg.txt";
        File file = new File(txtPath);
        FileWriter fileWriter = new FileWriter(file);
        PrintWriter printWriter = new PrintWriter(fileWriter);
        // 班导师也是师生的一部分，所以班导师的工号应该从师生表中取
        List<String> list = new ArrayList<>();
        String tid = "83521000001";
        for (int i = 0; i < 20; i++) {
            list.add(addLongInteger(tid,i));
        }
        // 生成十组班导师
        for (int i = 0; i < 10; i++) {
            printWriter.print(getId(list)+"|");
            printWriter.print(getName(i)+"|");
            printWriter.print(createTele());
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

    // 班导师姓名
    private static String getName(int i){
        return "班导师"+ (i+1) + "号";
    }
    // 班导师联系电话
    private static String createTele(){
        StringBuffer stringBuffer = new StringBuffer("1");
        for (int i = 0; i < 10; i++) {
            stringBuffer.append(String.valueOf(new Random().nextInt(10)));
        }
        return stringBuffer.toString();
    }
    // 班导师编号
    private static String getId(List list){
        return (String) list.remove(new Random().nextInt(list.size()));
    }
}
