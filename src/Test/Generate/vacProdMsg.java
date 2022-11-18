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
 * 疫苗生产信息表 vac_prod_msg
 **/
public class vacProdMsg {
    public static void main(String[] args) throws IOException {
        long l = System.currentTimeMillis();
        String scbh = "7541200";
        String txtPath = "D:\\AAA\\txt\\vac_prod_msg.txt";
        File file = new File(txtPath);
        FileWriter fileWriter = new FileWriter(file);
        PrintWriter printWriter = new PrintWriter(fileWriter);
        // 20组生产信息表
        for (int i = 0; i < 20; i++) {
            l = l - new Random().nextInt(10000000) - 10000000;
            printWriter.print(addLongInteger(scbh,i)+"|");
            printWriter.print(scrq(l)+"|");
            printWriter.print(scpc()+"|");
            printWriter.print(proMan());
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

    // 生产日期
    private static String scrq(long scrq){
        Date date = new Date(scrq);
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String ftime = format.format(date);
        return ftime;
    }
    // 生成批次
    private static String scpc(){
        String pc = "20221117";
        ArrayList<String> list = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            String s = addLongInteger(pc, i);
            list.add("CPX"+s);
        }
        return list.get(new Random().nextInt(list.size()));
    }
    // 生产厂商
    private  static String proMan(){
        String[]cs = {"康希诺生物","辉瑞公司","重庆智飞","赛诺菲","北京科兴生物"};
        return cs[new Random().nextInt(cs.length)];
    }
}
