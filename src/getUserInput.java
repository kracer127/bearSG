import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;

/**
 * @Auther: kracer
 * @Date: 2021-11-10 - 11 - 10 - 15:39
 * @version: 1.0
 */

public class getUserInput {
    static List<String> areaA = new ArrayList<String>();  // 社工字典的A区域<姓名等>
    static List<String> areaB = new ArrayList<String>();  // 社工字典的B区域<数字等>
    static List<String> areaC = new ArrayList<String>();  // 社工字典的C区域<特殊符号等>
    static List<String> areaUrl = new ArrayList<String>();  // 网址类的特殊生成
    static List<String> allDict = new ArrayList<String>();  // 所生成的社工字典
    static String fileInputPath = "";
    static String fileOutPath = "";


    // 函数：对用户输入的姓名进行预处理
    public static void processNameInit(String name) {
        String[] c = name.split("\\s+");
        if (c.length == 4) {
            String[] backThreeName = Arrays.copyOfRange(c, 1, 4); // 取四位名字的后三位
            processNameThree(backThreeName);
            String[] backTwoName = Arrays.copyOfRange(c, 1, 3); // 取四位名字的后两位
            processNameTwo(backTwoName);
            String[] headThreeName = Arrays.copyOfRange(c, 0, 3); // 取四位名字的前三位
            processNameThree(headThreeName);
            String[] headTwoName = Arrays.copyOfRange(c, 0, 2); // 取四位名字的前两位
            processNameTwo(headTwoName);
        } else if (c.length == 3) {
            processNameThree(c);
        } else {
            processNameTwo(c);
        }
    }

    // 函数：对长度为3的名字进行主处理
    public static void processNameThree(String[] c){
        String firstName = c[0]; // 第一个名字
        String firstNameInitial = c[0].substring(0,1); // 第一个名字的首字母
        String firstNameInitialUpper = firstNameInitial.substring(0,1).toUpperCase(); // 第一个名字的首字母大写
        String firstNameInitialString = c[0].substring(0,1).toUpperCase() + c[0].substring(1); // 首字母大写的第一个名字

        String secondName = c[1]; // 第二个名字
        String secondNameInitial = c[1].substring(0,1); // 第二个名字的首字母
        String secondNameInitialUpper = secondNameInitial.substring(0,1).toUpperCase(); // 第二个名字的首字母大写
        String secondNameInitialString = c[1].substring(0,1).toUpperCase() + c[1].substring(1); // 首字母大写的第二个名字

        String thirdName = c[2]; // 第三个名字
        String thirdNameInitial = c[2].substring(0,1); // 第三个名字的首字母
        String thirdNameInitialUpper = thirdNameInitial.substring(0,1).toUpperCase(); // 第三个名字的首字母大写
        String thirdNameInitialString = c[2].substring(0,1).toUpperCase() + c[2].substring(1); // 首字母大写的第三个名字

        /* 规则下取得的 12 种可能性名字组合 */
        String[] nameList = {firstName+secondName+thirdName, firstNameInitialString+secondName+thirdName, firstNameInitialString+secondNameInitialString+thirdName, firstNameInitialString+secondNameInitialString+thirdNameInitialString, firstName+secondNameInitialString+thirdName, firstName+secondNameInitialString+thirdNameInitialString, firstName+secondName+thirdNameInitialString, firstNameInitial+secondNameInitial+thirdNameInitial, firstNameInitialUpper+secondNameInitial+thirdNameInitial, firstNameInitialUpper+secondNameInitialUpper+thirdNameInitial, firstNameInitialUpper+secondNameInitialUpper+thirdNameInitialUpper, firstNameInitial+secondNameInitial+thirdNameInitialUpper, firstName+secondNameInitial+thirdNameInitial, firstNameInitialString+secondNameInitial+thirdNameInitial, firstNameInitialString+secondNameInitialUpper+thirdNameInitialUpper, firstName+secondNameInitialUpper+thirdNameInitialUpper};
        for (String i : nameList){
            areaA.add(i);
        }
    }

    // 函数：对长度为2的名字进行主处理
    public static void processNameTwo(String[] c){
        String firstName = c[0]; // 第一个名字
        String firstNameInitial = c[0].substring(0,1); // 第一个名字的首字母
        String firstNameInitialUpper = firstNameInitial.substring(0,1).toUpperCase(); // 第一个名字的首字母大写
        String firstNameInitialString = c[0].substring(0,1).toUpperCase() + c[0].substring(1); // 首字母大写的第一个名字

        String secondName = c[1]; // 第二个名字
        String secondNameInitial = c[1].substring(0,1); // 第二个名字的首字母
        String secondNameInitialUpper = secondNameInitial.substring(0,1).toUpperCase(); // 第二个名字的首字母大写
        String secondNameInitialString = c[1].substring(0,1).toUpperCase() + c[1].substring(1); // 首字母大写的第二个名字
        /* 规则下取得的 12 种可能性名字组合 */
        String[] nameList = {firstName+secondName, firstNameInitialString+secondName, firstNameInitialString+secondNameInitialString, firstName+secondNameInitialString, firstNameInitial+secondNameInitial, firstNameInitialUpper+secondNameInitial, firstNameInitialUpper+secondNameInitialUpper, firstNameInitial+secondNameInitialUpper, firstName+secondNameInitialUpper, firstName+secondNameInitial};
        for (String i : nameList){
            areaA.add(i);
        }
    }

    // 函数：对用户输入的网址进行处理
    public static void processUrl(String url){
        String[] urlArray = url.split("[.]");
        if (urlArray.length == 3){
            String[] newUrlArray = {urlArray[0]+"."+urlArray[1], urlArray[1]+"."+urlArray[2]};
            for (String i : newUrlArray){
                areaUrl.add(i);
            }
        }else{
            String[] newUrlArray = {urlArray[0]+"."+urlArray[1]};
            areaUrl.add(newUrlArray[0]);
        }
    }

    // 函数：组合url和当前年份
    public static void processUrlAndYear() {
        List<String> urlList = new ArrayList<String>();
        List<String> tmpUrl = new ArrayList<String>();
        tmpUrl.addAll(areaUrl);
        for (String u : tmpUrl){
            if(u.contains(".")){
                urlList.add(u);
                areaUrl.remove(u);
            }
        }
        if (!urlList.isEmpty()) {
            for (String u : urlList) {
                for (String n : areaUrl) {
                    allDict.add(u + n);
                }
            }
            for (String n : areaUrl) {
                for (String u : urlList) {
                    allDict.add(n + u);
                }
            }
        }
    }

    // 函数：对电话的处理
    public static void processPhone(String tel){
        String lasrFourPhoneNumber = tel.substring(tel.length()-4, tel.length());
        areaB.add(lasrFourPhoneNumber);
        areaUrl.add(lasrFourPhoneNumber);
    }

    // 函数：对爱好的数字的处理
    public static void processHobbyNumber(String Num){
        String Number = Num+",520,1314,7520,123,321,111,890";
        String[] splitNumber = Number.split("[,]");
        for(String i : splitNumber){
            areaB.add(i);
        }
    }

    // 函数：对当前年份的处理
    public static void processNowYear(String Year){
        String nowYear = Year;
        areaB.add(nowYear);
        areaUrl.add(nowYear);
        String lastYear = String.valueOf(Integer.parseInt(nowYear) - 1);
        areaUrl.add(lastYear);
        String lastLastYear = String.valueOf(Integer.parseInt(nowYear) - 2);
        areaUrl.add(lastLastYear);
    }

    // 函数：对用户输入的字符（特殊字符|特好字符）进行处理
    public static void processSymbol(String ss) {
        String symbol = "@,!,?,$,&,_,*,";
        symbol += ss;
        String[] symbolArray = symbol.split("[,]");
        for (String i : symbolArray) {
            areaC.add(i);
        }
    }

    // 函数：对用户喜欢的事物处理函数
    public static void processLove(String loves){
        String[] liveNameArray = loves.split("\\s");
        String useLoveName;
        if (liveNameArray.length == 4){
            useLoveName = liveNameArray[2] + liveNameArray[3];
        }else if(liveNameArray.length == 3){
            useLoveName = liveNameArray[1] + liveNameArray[2];
        }else if(liveNameArray.length == 2){
            useLoveName = liveNameArray[0] + liveNameArray[1];
        }else{
            useLoveName = liveNameArray[0];
        }
        areaA.add(useLoveName);
    }

    // 生成密码字典列表
    public static void produceAll(List<String> areaA, List<String> areaB, List<String> areaC) {
        /* 当喜欢的符号为空时，添加常见数字与符号 */
        if (areaC.isEmpty()){
            processSymbol("%");
        }
        /* 字典区域A去重 */
        List<String> listA = new ArrayList<String>();
        for(String i : areaA){
            if(!listA.contains(i)){
                listA.add(i);
            }
        }
        /* 字典区域B去重 */
        List<String> listB = new ArrayList<String>();
        for(String i : areaB){
            if(!listB.contains(i)){
                listB.add(i);
            }
        }
        /* 字典区域C去重 */
        List<String> listC = new ArrayList<String>();
        for(String i : areaC){
            if(!listC.contains(i)){
                listC.add(i);
            }
        }
        /* ABC 类型 */
        if (!listA.isEmpty()) {
            for (String i : listA) {
                for (String j : listB) {
                    for (String k : listC) {
                        allDict.add(i + j + k);
                    }
                }
            }
        }
        /* ACB 类型 */
        if (!listA.isEmpty()) {
            for (String i : listA) {
                for (String j : listC) {
                    for (String k : listB) {
                        allDict.add(i + j + k);
                    }
                }
            }
        }
        /* AB 类型 */
        if (!listA.isEmpty()) {
            for (String i : listA) {
                for (String j : listB) {
                    allDict.add(i + j);
                }
            }
        }
        /* AC 类型 */
        if (!listA.isEmpty()) {
            for (String i : listA) {
                for (String j : listC) {
                    allDict.add(i + j);
                }
            }
        }
        /* BAC 类型 */
        if (!listA.isEmpty()) {
            for (String i : listB) {
                for (String j : listA) {
                    for (String k : listC) {
                        allDict.add(i + j + k);
                    }
                }
            }
        }
        /* BA 类型 */
        if (!listA.isEmpty()) {
            for (String i : listB) {
                for (String j : listA) {
                    allDict.add(i + j);
                }
            }
        }
        /* 去除超短超长的密码 */
        List<String> tmp = new ArrayList<String>();
        tmp.addAll(allDict);
        for (String a : tmp){
            if ((a.length() < 6) || (a.length() > 16)){
                allDict.remove(a);
            }
        }
    }

    // 函数：追加top320弱口令密码
    public static void produceTop320(){
        String[] top320 = {"password", "admin", "admin123", "root", "root123", "123456", "adminroot", "admin1234", "admin12345", "admin555", "admin5555", "admin55555", "passadmin", "passadminword", "passwd", "password123", "password90", "1234.com", "1234.com123", "1234.com?", "toor", "admin123456", "root123456", "5201314", "775201314", "75201314", "1234567", "12345", "12345678", "123456789", "654321", "666666", "66666666", "888888", "88888888", "sa123456", "oracle001", "oracle.com", "admin123..", "adminroot123", "1234", "abc123", "1q2w3e4r5t", "cimerroot@123", "adminsa123..", "123123", "ahead8618", "ahead8888", "oracle", "console", "antlabs", "a123456", "a123456789", "1234567890", "woaini1314", "qq123456", "abc123456", "123456a", "123456789a", "147258369", "zxcvbnm", "987654321", "12345678910", "qq123456789", "123456789.", "7708801314520", "woaini1214", "woaini", "woaini750", "750woaini", "5201314520", "q123456", "123456abc", "1233211234567", "123123123", "123456.", "0123456789", "asd123456", "aa123456", "135792468", "q123456789", "abcd123456", "12345678900", "woaini520", "woaini123", "zxcvbnm123", "1111111111111111", "w123456", "aini1314", "abc123456789", "111111", "woaini521", "1314520520", "1234567891", "qwe123456", "asd123", "000000", "1472583690", "1357924680", "789456123", "123456789abc", "z123456", "1234567899", "aaa123456", "abcd1234", "www123456", "123456789q", "123abc", "qwe123", "w123456789", "7894561230", "123456qq", "zxc123456", "123456789qq", "1111111111", "111111111", "0000000000000000", "1234567891234567", "qazwsxedc", "qwerty", "123456..", "zxc123", "asdfghjkl", "0000000000", "1234554321", "123456q", "123456aa", "9876543210", "110120119", "qaz123456", "qq5201314", "123698745", "000000000", "as123456", "5841314520", "z123456789", "52013145201314", "a123123", "caonima", "1qaz2wsx", "1q2w3e4r", "7758521", "123qwe", "1314520", "100200", "123321", "5211314", "a5201314", "zhang123", "123123a", "aptx4869", "1qazxsw2", "5201314a", "1q2w3e", "q1w2e3r4", "31415926", "a111111", "520520", "1234qwer", "111111a", "110110", "7758258", "iloveyou", "159753", "qwer1234", "a000000", "123qweasd", "123654", "qq123123", "456852", "000000a", "1314521", "asdasd", "521521", "112233", "q1w2e3", "aaa123", "qazwsx123", "qaz123", "aaaaaa", "a123321", "12qwaszx", "123000", "11111111", "wang123", "s123456", "nihao123", "love1314", "caonima123", "asdasd123", "753951", "5845201314", "584520", "159357", "147258", "1123581321", "110120", "hao123", "a7758521", "wang123456", "abcd123", "123456789..", "woaini1314520", "123456asd", "aa123456789", "741852963", "a12345678", "t12345678", "t123456", "521", "123", "admin_default", "netscreen", "mduadmin", "firewall ", "bane@7766", "cisco", "Admin@123", "Superman", "talent��", "12345679", "7777777", "555555", "19001560", "1234560", "987654", "520302   ", "696969", "superman", "fuckyou", "121212", "qazwsx", "asdfgh", "fuckme", "131313", "777777", "222222", "q1w2e3r4t5", "999999", "333333", "232323", "87654321", "12344321", "8675309", "thx1138", "jordan23", "Password", "55555", "789456", "101010", "qwerty123", "12341234", "qwertyui", "444444", "xxxxxxxx", "bond007", "1111111", "212121", "12345a", "rush2112", "asdfghjk", "red123", "4815162342", "passw0rd", "nothing", "01012011", "69696969", "102030", "252525", "11223344", "315475", "qqqqqq", "blink182", "abcdef", "00000", "007007", "asdf1234", "1313", "12121212", "lol123", "5555", "111222", "0987654321", "147147", "12345q", "010203", "1232323q", "tester", "147852", "420420", "242424", "12345qwert", "aaaaaaaa", "lucky1", "a12345", "123789", "098765", "qwerty12", "98765432", "55555555", "141414", "zaq12wsx", "77777777", "00000000", "7654321", "PASSWORD", "202020", "202121", "test123", "9379992", "852456", "159951", "hello123", "123654789", "134679", "151515", "147852369", "12312", "xxxxxx", "a1b2c3"};
        for (String top : top320){
            allDict.add(top);
        }
    }

    // 函数：加入自选的弱口令字典
    public static void produceOwntop100() {
        StringBuffer sb = new StringBuffer();
        List<String> lines = processFile.read(fileInputPath);
        for (String i : lines){
            allDict.add(i);
        }
    }

    // 函数: 清空所有列表里的数据
    public static void clearListAll(){
        try {
            areaUrl.clear();
            allDict.clear();
            areaA.clear();
            areaB.clear();
            areaC.clear();
        } catch (Exception e){

        }
    }

    // 函数：生成字典文件
    public static void produceAllDict(){
        SimpleDateFormat formatter= new SimpleDateFormat("yyyyMMdd-HHmmss");
        Date date = new Date(System.currentTimeMillis());
        fileOutPath = formatter.format(date)+"_sgDict.txt";
        processFile.writeTxt(fileOutPath, allDict);
    }

}
