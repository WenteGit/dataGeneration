package Test.Generate;

import javafx.util.Pair;

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
 * vac_msg 疫苗信息表
 *
 **/
public class vacMsg {
    public static void main(String[] args) throws IOException {
        String txtPath = "D:\\AAA\\txt\\vac_msg.txt";
        File file = new File(txtPath);
        FileWriter fileWriter = new FileWriter(file);
        PrintWriter printWriter = new PrintWriter(fileWriter);
        String cid = "1543200";
        // 生成10种不同生产批次的疫苗
        for (int i = 0; i < 10; i++) {
            Pair pair = vaccineNameBh();
            printWriter.print(addLongInteger(cid,i)+"|");
            printWriter.print(pair.getValue()+"|");
            printWriter.print(pair.getKey()+"|");
            printWriter.print("灭活疫苗");
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

    // 疫苗名称 + 生产编号
    private static Pair vaccineNameBh(){
        Pair<String, String> bjPair1 = new Pair<>("北京生物新冠疫苗","7541204");
        Pair<String, String> bjPair2 = new Pair<>("北京生物新冠疫苗","7541207");
        Pair<String, String> bjPair3 = new Pair<>("北京生物新冠疫苗","7541212");

        Pair<String, String> kxnPair1 = new Pair<>("康希诺新冠疫苗","7541205");
        Pair<String, String> kxnPair2 = new Pair<>("康希诺新冠疫苗","7541208");
        Pair<String, String> kxnjPair3 = new Pair<>("康希诺新冠疫苗","7541211");

        Pair<String, String> zfPair1 = new Pair<>("智飞新冠疫苗","7541201");
        Pair<String, String> zfPair3 = new Pair<>("智飞新冠疫苗","7541219");

        List<Pair> list = new ArrayList<>();
        list.add(bjPair1);list.add(bjPair2);list.add(bjPair3);
        list.add(kxnPair1);list.add(kxnPair2);list.add(kxnjPair3);
        list.add(zfPair1);list.add(zfPair3);
        return list.get(new Random().nextInt(list.size()));
    }

}
