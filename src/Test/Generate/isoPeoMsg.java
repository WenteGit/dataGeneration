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
 * @date 2022/11/16
 **/
public class isoPeoMsg {

    public static void main(String[] args) throws IOException {
        String txtPath = "D:\\AAA\\txt\\iso_peo_msg.txt";
        File file = new File(txtPath);
        FileWriter fileWriter = new FileWriter(file);
        PrintWriter printWriter = new PrintWriter(fileWriter);
        // 隔离室编号
        List<String> list = new ArrayList<>();
        String ISORID = "3302000";
        for (int i = 0; i < 10; i++) {
            list.add(addLongInteger(ISORID,i));
        }


        String bh = "1100";
        //10位负责人
        for (int i = 0; i < 10; i++) {
            printWriter.print(addLongInteger(bh,i)+"|");
            printWriter.print(glsbh(list)+"|");
            printWriter.print(lxrxm(i)+"|");
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

    //隔离室编号
    private static String glsbh( List<String> list){
        int randomIndex = new Random().nextInt(list.size());
        String glsbh = list.get(randomIndex);
        list.remove(randomIndex);
        return glsbh;
    }
    //联系人姓名
    private static String lxrxm(int i){
        return "联系人"+i+"号";
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
