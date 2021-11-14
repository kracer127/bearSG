import java.awt.*;


/**
 * @Auther: kracer
 * @Date: 2021-11-11 - 11 - 11 - 14:58
 * @version: 1.0
 */
public class guiUtil {
    private static Dimension screenSize;

    public guiUtil() {
    }

    public static int getWidth() {
        screenSize = Toolkit.getDefaultToolkit().getScreenSize(); // 获取屏幕尺寸对象
        return screenSize.width;
    }

    public static int getHeight() {
        screenSize = Toolkit.getDefaultToolkit().getScreenSize();
        return screenSize.height;
    }
}
