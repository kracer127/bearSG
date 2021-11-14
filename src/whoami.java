import javax.swing.*;
import javax.swing.GroupLayout.Alignment;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.border.EmptyBorder;
import javax.swing.border.EtchedBorder;
import java.awt.*;


/**
 * @Auther: kracer
 * @Date: 2021-11-11 - 11 - 11 - 14:54
 * @version: 1.0
 */

public class whoami extends JDialog {
    private final JPanel contentPanel = new JPanel();

    public whoami() {
        this.setTitle("whoami");
        this.setBounds((guiUtil.getWidth() - 455) / 2, (guiUtil.getHeight() - 430) / 2, 455, 430);
        this.getContentPane().setLayout(new BorderLayout());
        this.contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
        this.getContentPane().add(this.contentPanel, "Center");
        this.contentPanel.setLayout((LayoutManager)null);
        JPanel panel = new JPanel();
        panel.setBorder(new EtchedBorder(1, (Color)null, (Color)null));
        panel.setBounds(22, 10, 400, 364);
        this.contentPanel.add(panel);
        JLabel lblNewLabel = new JLabel("关于");
        lblNewLabel.setForeground(Color.RED);
        lblNewLabel.setHorizontalAlignment(0);
        lblNewLabel.setFont(new Font("微软雅黑", 1, 16));
        JTextPane textPane = new JTextPane();
        textPane.setFont(new Font("微软雅黑", 0, 15));
        textPane.setEditable(false);
        textPane.setText("出于网上社工工具的使用繁琐，界面不友好，生成的字典不符合国人设密习惯的出发点，设计开发了此工具。\r\n\n" +
                "工具开发过程总结了几款软件的生成机制，加上自己对国人设密码的规律总结，" +
                "做出了这款方便渗透爆破的工具。\r\n\n" +
                "当前为开发的第一个版本，后续优化的工具放在网址\r\nhttps://github.com/kracer127/bearSG\r\n\n" +
                "好的建议大家不吝赐教，唯一QQ:0x91b8bb99。");
        GroupLayout gl_panel = new GroupLayout(panel);
        gl_panel.setHorizontalGroup(gl_panel.createParallelGroup(Alignment.LEADING).addGroup(gl_panel.createSequentialGroup().addGroup(gl_panel.createParallelGroup(Alignment.LEADING).addGroup(gl_panel.createSequentialGroup().addGap(150).addComponent(lblNewLabel, -2, 80, -2)).addGroup(gl_panel.createSequentialGroup().addGap(5).addContainerGap().addComponent(textPane, -1, 936, -1))).addContainerGap(23, 39767)));
        gl_panel.setVerticalGroup(gl_panel.createParallelGroup(Alignment.LEADING).addGroup(gl_panel.createSequentialGroup().addContainerGap().addComponent(lblNewLabel, -2, 29, -2).addPreferredGap(ComponentPlacement.UNRELATED).addComponent(textPane, -1, 774, -1).addContainerGap(27, 42767)));
        panel.setLayout(gl_panel);
    }
}


