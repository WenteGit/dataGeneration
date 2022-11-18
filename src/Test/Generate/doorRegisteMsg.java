package Test.Generate;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Random;

/**
 * @author Wente
 * @date 2022/11/16
 *  门岗车辆登记信息表
 *  数据生成程序
 **/
public class doorRegisteMsg {
    public static void main(String[] args) throws IOException {
        String txtPath = "D:\\AAA\\txt\\door_registe_msg.txt";
        File file = new File(txtPath);
        FileWriter fileWriter = new FileWriter(file);
        PrintWriter printWriter = new PrintWriter(fileWriter);

        long nowtime = System.currentTimeMillis();
        //生成100条信息
        for (int i = 0; i < 100; i++) {
            long jointime1 = nowtime - (new Random().nextInt(1000000000)*10000);
            printWriter.print(addLongInteger("5200001",i)+"|");
            printWriter.print(mgbh()+"|");
            printWriter.print(addLicencePlate()+"|");
            printWriter.print(addName(i)+"|");
            printWriter.print(createTele()+"|");
            printWriter.print(createID()+"|");
            printWriter.print(setPosition()+"|");
            printWriter.print(joinTime(jointime1)+"|");
            printWriter.print(leaveTime(jointime1)+"|");
            printWriter.print(joinReason(i)+"|");
            printWriter.print(ifcomefromZGFX()+"|");
            printWriter.print(healthMA()+"|");
            printWriter.print(travleMA()+"|");
            printWriter.print(placeMA());
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

    // 生成车牌号
    private static String addLicencePlate(){
        String[]jc = {"京","津","黑","吉","辽","鲁","渝","渝","渝","川","赣","港","澳","滇","浙","闵","青","新","鲁","陇","桂","琼","台","苏","皖","鄂","湘"};
        String zm ="A1B2C3D4E5F6G7H8I9J0K1L2M3N4O5P6Q7R8S9T0U1V2W3X4Y5Z";
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append(jc[new Random().nextInt(jc.length)]);
        for (int i = 0; i < 6; i++) {
            stringBuffer.append(zm.charAt(new Random().nextInt(zm.length())));
        }
        return stringBuffer.toString();
    }
    // 生成姓名
    private static String addName(int i){
        return "司机"+ i +"号";
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
    // 居住地生成
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
    // 进入时间
    private static String joinTime(long jointime){
        Date date = new Date(jointime);
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String ftime = format.format(date);
        return ftime;
    }
    // 离开时间
    private static String leaveTime(long time){
        time = time + new Random().nextInt(100000000);
        Date date = new Date(time);
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String leaveTime = format.format(date);
        return leaveTime;
    }
    // 进校事由
    private static String joinReason(int i){
        String[] reason = {"上班","上课","学习","拜访","核酸检测"};
        return  reason[new Random().nextInt(reason.length)];
    }
    // 是否来自中高风险
    private static int ifcomefromZGFX(){
        return new Random().nextInt(2);
    }
    //健康码
    private static String healthMA(){
        String[] jkm= {"绿码","绿码","绿码","绿码","绿码","绿码","绿码","绿码","绿码","绿码","绿码","绿码","绿码","绿码","绿码","绿码","绿码","绿码","绿码","绿码","绿码","绿码","绿码","绿码","绿码","绿码","绿码","绿码","绿码","绿码","黄码","红码"};
        return jkm[new Random().nextInt(jkm.length)];
    }
    //行程码
    private static String travleMA(){
        String[] xcm= {"绿码","绿码","绿码","绿码","绿码","绿码","绿码","绿码","绿码","绿码","绿码","绿码","绿码","绿码","绿码","绿码","绿码","绿码","绿码","绿码","绿码","绿码","绿码","绿码","绿码","绿码","绿码","绿码","绿码","绿码","黄码","红码"};
        return xcm[new Random().nextInt(xcm.length)];
    }
    //场所码
    private static String placeMA(){
        String[] csm= {"绿码","绿码","绿码","绿码","绿码","绿码","绿码","绿码","绿码","绿码","绿码","绿码","绿码","绿码","绿码","绿码","绿码","绿码","绿码","绿码","绿码","绿码","绿码","绿码","绿码","绿码","绿码","绿码","绿码","绿码","黄码","红码"};
        return csm[new Random().nextInt(csm.length)];
    }
    // 门岗编号
    private static String mgbh(){
        String st = "2100001";
        String[]bh = new String[6];
        for (int i = 0; i < 6; i++) {
            bh[i] = addLongInteger(st, i);
        }
        return bh[new Random().nextInt(6)];
    }


}
