import javax.swing.*;
import javax.swing.GroupLayout.Alignment;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;

/**
 * @Auther: kracer
 * @Date: 2021-11-11 - 11 - 11 - 15:06
 * @version: 1.0
 */

public class resultMessage extends JDialog {
    private final JPanel contentPanel = new JPanel();

    public resultMessage() {
        this.setTitle("提示");
        this.setBounds((guiUtil.getWidth() - 181) / 2, (guiUtil.getHeight() - 167) / 2, 181, 167);
        this.getContentPane().setLayout(new BorderLayout());
        this.contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
        this.getContentPane().add(this.contentPanel, "Center");
        JLabel label = new JLabel("");
        label.setFont(new Font("微软雅黑", 0, 13));
        label.setHorizontalAlignment(0);
        File f = new File(getUserInput.fileOutPath);
        if (f.exists()) {
            label.setText("社工字典生成成功！");
        } else {
            label.setText("社工字典生成失败！");
        }

        JButton button = new JButton("确认");
        button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dispose(); // 关闭当前窗口
            }
        });
        button.setFont(new Font("微软雅黑", 0, 12));
        GroupLayout gl_contentPanel = new GroupLayout(this.contentPanel);
        gl_contentPanel.setHorizontalGroup(gl_contentPanel.createParallelGroup(Alignment.LEADING).addGroup(Alignment.TRAILING, gl_contentPanel.createSequentialGroup().addContainerGap(28, 32767).addComponent(label, -2, 159, -2).addGap(28)).addGroup(gl_contentPanel.createSequentialGroup().addGap(60).addComponent(button).addContainerGap(52, 32767)));
        gl_contentPanel.setVerticalGroup(gl_contentPanel.createParallelGroup(Alignment.TRAILING).addGroup(gl_contentPanel.createSequentialGroup().addGap(29).addComponent(label, -1, 28, 32767).addGap(27).addComponent(button).addGap(21)));
        this.contentPanel.setLayout(gl_contentPanel);
    }
}
