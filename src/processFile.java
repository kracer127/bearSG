import java.io.BufferedReader;
import java.io.File;
import java.io.FileOutputStream;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

/**
 * @Auther: kracer
 * @Date: 2021-11-11 - 11 - 11 - 14:44
 * @version: 1.0
 */
public class processFile {
    public static List<String> read(String pathStr) {
        System.out.println(pathStr);
        Charset charset = Charset.forName("utf-8"); //设置字典文件编码方式为utf-8
        Path path = Paths.get(pathStr);
        List<String> lines = new ArrayList<String>();
        try (BufferedReader br = Files.newBufferedReader(path, charset);) {
            String line = "";
            while ((line = br.readLine()) != null) {
                lines.add(line); //逐行读取密码并添加到List
            }
            return lines; //返回载有字典密码的List
        } catch (Exception e) {
            Charset charset1 = Charset.forName("gbk"); //设置字典文件编码方式为gbk, 后续优化
        }
        return null;
    }

    public static void writeTxt(String txtPath, List<String> lines) {
        FileOutputStream fileOutputStream = null;
        File file = new File(txtPath);
        try {
            if (file.exists()) {
                //判断文件是否存在，如果不存在就新建一个txt
                file.createNewFile();
            }
            fileOutputStream = new FileOutputStream(file);
            for (String i : lines) {
                String inputStr = i+"\n";
                fileOutputStream.write(inputStr.getBytes());
            }
            fileOutputStream.flush();
            fileOutputStream.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
