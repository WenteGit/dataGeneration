package Test.Generate;


import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Random;

/**
 * @author Wente
 * @date 2022/11/16
 * deteOrgMsg(核酸检测机构)
 * 数据生成程序
 **/
public class deteOrgMsg {
    public static void main(String[] args) throws IOException {
        String dataPath = "D:\\AAA\\txt\\dete_org_msg.txt";
        File file = new File(dataPath);
        FileWriter fileWriter = new FileWriter(file);
        PrintWriter printWriter = new PrintWriter(fileWriter);
        String miStart = "1200001";
        // 生成30组机构核酸检测机构的信息
        for (int i = 0; i < 30; i++) {
            printWriter.print(addLongInteger(miStart,i)+"|");
            printWriter.print(setName(i) + "|");
            printWriter.print(setPosition()+"|");
            printWriter.print(createTele() + "|");
            printWriter.print(createName(i));
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
    // 生成核酸检测机构的信息
    private static String setName(int i){
        return "检测机构" + (i+1) +"号";
    }
    // 生成机构地点信息
    private static String setPosition(){
        String provinces [] = {"重庆市","北京市","上海市","天津市"};
        String countries [] = {"区县1","区县2","区县3","区县4"};
        String streets[] = {"街道1","街道2","街道3","街道4"};
        String doornum[] = {"门牌1-1","门牌2-2","门牌3-3","门牌4-4"};

        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append(provinces[new Random().nextInt(4)]);
        stringBuffer.append(countries[new Random().nextInt(4)]);
        stringBuffer.append(streets[new Random().nextInt(4)]);
        stringBuffer.append(doornum[new Random().nextInt(4)]);

        return stringBuffer.toString();
    }
    //电话随机生成
    private static String createTele(){
        StringBuffer stringBuffer = new StringBuffer("1");
        for (int i = 0; i < 10; i++) {
            stringBuffer.append(String.valueOf(new Random().nextInt(10)));
        }
        return stringBuffer.toString();
    }
    // 联系人姓名随机生成
    private static String createName(int i){
        return "联系人" + (i+1) + "号";
    }

}
