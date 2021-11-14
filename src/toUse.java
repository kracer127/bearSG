import javax.swing.*;
import javax.swing.GroupLayout.Alignment;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.border.EmptyBorder;
import javax.swing.border.EtchedBorder;
import java.awt.*;

/**
 * @Auther: kracer
 * @Date: 2021-11-11 - 11 - 11 - 17:21
 * @version: 1.0
 */

public class toUse extends JDialog {
    private final JPanel contentPanel = new JPanel();

    public toUse() {
        this.setTitle("How to use?");
        this.setBounds((guiUtil.getWidth() - 455) / 2, (guiUtil.getHeight() - 400) / 2, 455, 430);
        this.getContentPane().setLayout(new BorderLayout());
        this.contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
        this.getContentPane().add(this.contentPanel, "Center");
        this.contentPanel.setLayout((LayoutManager)null);
        JPanel panel = new JPanel();
        panel.setBorder(new EtchedBorder(1, (Color)null, (Color)null));
        panel.setBounds(5, 5, 430, 390);
        this.contentPanel.add(panel);
        JLabel lblNewLabel = new JLabel("输入格式示例");
        lblNewLabel.setForeground(Color.RED);
        lblNewLabel.setHorizontalAlignment(0);
        lblNewLabel.setFont(new Font("微软雅黑", 0, 16));
        JTextPane textPane = new JTextPane();
        textPane.setFont(new Font("微软雅黑", 0, 13));
        textPane.setEditable(false);
        textPane.setText("姓名：zhou xing chi 或者 ma yun\r\n\n" +
                "生日：0327      身份证后六位：271212\r\n\n" +
                "出生年份：1996       当前年份：2021\r\n\n" +
                "手机号：13500000000\r\n\n" +
                "网站的域名：baidu.com或者shitu.baidu.com\r\n\n" +
                "喜好的数字：520,1314,12345\r\n\n" +
                "喜好的符号：?,@,&\r\n\n" +
                "喜欢的人或物：zhouxingchi\r\n\n" +
                "注意空格和使用英文符号下的逗号！！！");
        GroupLayout gl_panel = new GroupLayout(panel);
        gl_panel.setHorizontalGroup(gl_panel.createParallelGroup(Alignment.LEADING).addGroup(gl_panel.createSequentialGroup().addGroup(gl_panel.createParallelGroup(Alignment.LEADING).addGroup(gl_panel.createSequentialGroup().addGap(152).addComponent(lblNewLabel, -2, 102, -2)).addGroup(gl_panel.createSequentialGroup().addGap(12).addContainerGap().addComponent(textPane, -1, 1236, -1))).addContainerGap(23, 39767)));
        gl_panel.setVerticalGroup(gl_panel.createParallelGroup(Alignment.LEADING).addGroup(gl_panel.createSequentialGroup().addContainerGap().addComponent(lblNewLabel, -2, 29, -2).addPreferredGap(ComponentPlacement.UNRELATED).addComponent(textPane, -2, 1234, -2).addContainerGap(27, 39767)));
        panel.setLayout(gl_panel);
    }
}

