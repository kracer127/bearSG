import javax.swing.*;
import javax.swing.GroupLayout.Alignment;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;
import javax.swing.border.TitledBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.text.SimpleDateFormat;
import java.util.Date;


/**
 * @Auther: kracer
 * @Date: 2021-11-11 - 11 - 11 - 14:56
 * @version: 1.0
 */



public class mainGUI extends JFrame {
    private JPanel contentPane;
    private JTextField myname;
    private JTextField myBirth;
    private JTextField myIdcard;
    private JTextField myBirthYear;
    private JTextField myPhone;
    private JTextField myUrl;
    private JTextField myHobbyNumber;
    private JTextField myHobbySymbol;
    private JTextField myNearPersonName;
    private JTextField myNearPersonBirth;
    private JTextField nowYear;
    private JTextField myLove;
    getUserInput cp;  // 主要更改
    StringBuffer info;
    StringBuffer topAndInfo;
    StringBuffer top100;
    StringBuffer topAndfinfo;
    StringBuffer ainfo;
    StringBuffer all;

    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    mainGUI frame = new mainGUI();
                    frame.setVisible(true);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }

    public mainGUI() {
        this.setResizable(false); // 设置此窗体是否可由用户调整大小
        this.setAutoRequestFocus(false); // 设置焦点定位在文本框
        this.setIconImage(Toolkit.getDefaultToolkit().getImage(mainGUI.class.getResource("icon.jpg")));
        this.setTitle("小熊社工密码生成器V1.0 __by:kracer");
        this.setDefaultCloseOperation(3); // 窗口的关闭，直接关闭应用程序
        this.setBounds((guiUtil.getWidth() - 788) / 2, (guiUtil.getHeight() - 666) / 2, 788, 667);
        JMenuBar menuBar = new JMenuBar(); // 创建菜单栏对象
        this.setJMenuBar(menuBar); // 将菜单栏对象添加到窗体的菜单栏中
        menuBar.setBackground(Color.green);  // 设置菜单栏的颜色
        JMenu Menu1 = new JMenu("说明");  // 创建菜单对象
        Menu1.setFont(new Font("微软雅黑", 1, 14));
        menuBar.add(Menu1); // 将菜单对象添加到菜单栏对象中
        JMenuItem Menu1_Item1 = new JMenuItem("参数格式"); // 创建菜单项对象
        Menu1_Item1.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                toUse dialog = new toUse();
                dialog.setDefaultCloseOperation(2);
                dialog.setVisible(true);
            }
        }); // 为菜单项添加事件监听器
        Menu1.add(Menu1_Item1);  // 将菜单项对象添加到菜单对象中
        JMenu Menu2 = new JMenu("关于");
        Menu2.setAlignmentX(100);
        Menu2.setFont(new Font("微软雅黑", 1, 14));
        menuBar.add(Menu2);
        JMenuItem Menu2_Item1 = new JMenuItem("whoami");
        Menu2_Item1.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                whoami dialog = new whoami();
                dialog.setDefaultCloseOperation(2);
                dialog.setVisible(true);
            }
        });
        Menu2.add(Menu2_Item1);
        this.contentPane = new JPanel();
        this.contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        this.setContentPane(this.contentPane);
        JPanel panel = new JPanel();  // 基本信息面板
        JPanel panel_1 = new JPanel(); // 其他选项面板
        JPanel panel_2 = new JPanel(); // 发车区面板
        /* 三个面板的边界设计 */
        panel.setBorder(new TitledBorder(new LineBorder(new Color(171, 173, 179)), "基本信息", 4, 2, (Font)null, new Color(0, 0, 0)));
        panel_1.setBorder(new TitledBorder(new LineBorder(new Color(171, 173, 179)), "其它选项", 4, 2, (Font)null, new Color(0, 0, 0)));
        panel_2.setBorder(new TitledBorder(new LineBorder(new Color(171, 173, 179)), "开始生成", 4, 2, (Font)null, new Color(0, 0, 0)));
        JLabel label_11 = new JLabel("关系人的名字：");
        label_11.setFont(new Font("微软雅黑", 1, 11));
        this.myNearPersonName = new JTextField();
        this.myNearPersonName.setToolTipText("");
        this.myNearPersonName.setColumns(10);
        JLabel label_12 = new JLabel("关系人的生日：");
        label_12.setFont(new Font("微软雅黑", 1, 11));
        this.myNearPersonBirth = new JTextField();
        this.myNearPersonBirth.setToolTipText("");
        this.myNearPersonBirth.setColumns(10);
        JLabel label_13 = new JLabel("当前年份：         ");
        label_13.setFont(new Font("微软雅黑", 1, 11));
        this.nowYear = new JTextField();
        this.nowYear.setToolTipText("");
        this.nowYear.setColumns(10);
        /* 可选项面板布局 */
        GroupLayout gl_panel_1 = new GroupLayout(panel_1);
        gl_panel_1.setHorizontalGroup(gl_panel_1.createParallelGroup(Alignment.LEADING).addGap(0, 274, 32767).addGroup(gl_panel_1.createSequentialGroup().addContainerGap().addGroup(gl_panel_1.createParallelGroup(Alignment.LEADING, false).addGroup(gl_panel_1.createSequentialGroup().addComponent(label_11).addPreferredGap(ComponentPlacement.RELATED, -1, 32767).addComponent(this.myNearPersonName, -2, 145, -2)).addGroup(gl_panel_1.createSequentialGroup().addComponent(label_12).addGap(28).addComponent(this.myNearPersonBirth, -2, 145, -2)).addGroup(gl_panel_1.createSequentialGroup().addComponent(label_13).addGap(20).addComponent(this.nowYear, -2, 145, -2))).addContainerGap(19, 32767)));
        gl_panel_1.setVerticalGroup(gl_panel_1.createParallelGroup(Alignment.LEADING).addGroup(gl_panel_1.createSequentialGroup().addGap(22).addGroup(gl_panel_1.createParallelGroup(Alignment.BASELINE).addComponent(label_11).addComponent(this.myNearPersonName, -2, -1, -2)).addPreferredGap(ComponentPlacement.UNRELATED).addGroup(gl_panel_1.createParallelGroup(Alignment.BASELINE).addComponent(label_12).addComponent(this.myNearPersonBirth, -2, -1, -2)).addGap(20).addGroup(gl_panel_1.createParallelGroup(Alignment.BASELINE).addComponent(label_13).addComponent(this.nowYear, -2, -1, -2)).addContainerGap(388, 32767)));
        panel_1.setLayout(gl_panel_1);
        /* 文字区域设计 */
        JLabel lblNewLabel_2 = new JLabel("注意事项：");
        lblNewLabel_2.setFont(new Font("华文新魏", 1, 14));
        JLabel lblNewLabel_3 = new JLabel("失败说明有的格式输入错了，点击说明参考格式！");
        lblNewLabel_3.setFont(new Font("华文新魏", 1, 14));
        JLabel lblNewLabel_4 = new JLabel("姓名是必填的，否则这个工具白用了。");
        lblNewLabel_4.setFont(new Font("华文新魏", 1, 14));
        JLabel lblNewLabel_5 = new JLabel("勾选混合弱口令：内置总结优化的top320弱口令。");
        lblNewLabel_5.setFont(new Font("华文新魏", 1, 14));
        JLabel lblNewLabel_6 = new JLabel("勾选自选弱口令：外部加载你的弱口令字典。");
        lblNewLabel_6.setFont(new Font("华文新魏", 1, 14));
        /* 文字说明区域面板布局 */
        GroupLayout gl_contentPane = new GroupLayout(this.contentPane);
        gl_contentPane.setHorizontalGroup(gl_contentPane.createParallelGroup(Alignment.LEADING).addGroup(gl_contentPane.createSequentialGroup().addContainerGap().addComponent(panel, -2, 394, -2).addGap(37).addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING).addComponent(panel_1, -2, 274, -2).addComponent(lblNewLabel_2).addComponent(lblNewLabel_3).addComponent(lblNewLabel_4).addComponent(lblNewLabel_5).addComponent(lblNewLabel_6).addComponent(panel_2, -2, 289, -2)).addContainerGap(22, 32767)));
        gl_contentPane.setVerticalGroup(gl_contentPane.createParallelGroup(Alignment.LEADING).addGroup(gl_contentPane.createSequentialGroup().addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING).addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE).addGroup(gl_contentPane.createSequentialGroup().addComponent(panel_1, -2, 168, -2).addGap(31).addComponent(lblNewLabel_2).addGap(17).addComponent(lblNewLabel_3).addGap(19).addComponent(lblNewLabel_4).addGap(19).addComponent(lblNewLabel_5).addGap(19).addComponent(lblNewLabel_6).addGap(19).addPreferredGap(ComponentPlacement.RELATED, 33, 32767).addComponent(panel_2, -2, 181, -2).addGap(33))).addComponent(panel, -2, 577, -2)).addContainerGap()));
        /* 勾选自选弱口令监听器设计 */
        final JCheckBox checkBox = new JCheckBox("自选弱口令");
        checkBox.addMouseListener(new MouseAdapter() {
            public void mouseClicked(MouseEvent e) {
                if (checkBox.isSelected()) {
                    FileDialog fd = new FileDialog(new resultMessage(), "选择弱口令文件");
                    fd.setVisible(true);
                    System.out.println(fd.getDirectory() + fd.getFile());
                    String dir = fd.getDirectory();
                    String file = fd.getFile();
                    if (dir != null && file != null) {
                        getUserInput.fileInputPath = dir + file;
                    }
                } else {
                    getUserInput.fileInputPath = null;
                }
            }
        });
        /* 勾选混合弱口令监听器设计 */
        final JCheckBox checkBox_1 = new JCheckBox("混合弱口令");
        checkBox_1.addMouseListener(new MouseAdapter() {
            public void mouseClicked(MouseEvent e) {
                if (checkBox_1.isSelected()) {
                    System.out.println("勾选了混合弱口令");
                } else {
                    System.out.println("没有勾选混合弱口令");;
                }
            }
        });
        JButton start = new JButton("开始");
        start.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                System.out.println("开始生成社工字典......");
                if (checkBox_1.isSelected()) {
                    System.out.println("加入弱口令");
                    cp.produceTop320();
                }

                if (checkBox.isSelected()) {
                    System.out.println("加入自选弱口令");
                    cp.produceOwntop100();
                }

                if (mainGUI.this.myname.getText() != null && !mainGUI.this.myname.getText().equals("")) {
                    cp.processNameInit(mainGUI.this.myname.getText().trim());
                }

                if (mainGUI.this.myNearPersonName.getText() != null && !mainGUI.this.myNearPersonName.getText().equals("")) {
                    cp.processNameInit(mainGUI.this.myNearPersonName.getText().trim());
                }

                if (mainGUI.this.myLove.getText() != null && !mainGUI.this.myLove.getText().equals("")) {
                    cp.processLove(mainGUI.this.myLove.getText().trim());
                }

                if (mainGUI.this.myBirth.getText() != null && !mainGUI.this.myBirth.getText().equals("")) {
                    cp.areaB.add(mainGUI.this.myBirth.getText().trim());
                    cp.areaUrl.add(mainGUI.this.myBirth.getText().trim());
                }

                if (mainGUI.this.myIdcard.getText() != null && !mainGUI.this.myIdcard.getText().equals("")) {
                    cp.areaB.add(mainGUI.this.myIdcard.getText().trim());
                    cp.areaUrl.add(mainGUI.this.myIdcard.getText().trim());
                }

                if (mainGUI.this.myNearPersonBirth.getText() != null && !mainGUI.this.myNearPersonBirth.getText().equals("")) {
                    cp.areaB.add(mainGUI.this.myNearPersonBirth.getText().trim());
                    cp.areaUrl.add(mainGUI.this.myNearPersonBirth.getText().trim());
                }

                if (mainGUI.this.myBirthYear.getText() != null && !mainGUI.this.myBirthYear.getText().equals("")) {
                    cp.areaB.add(mainGUI.this.myBirthYear.getText().trim());
                    cp.areaUrl.add(mainGUI.this.myBirthYear.getText().trim());
                }

                if (mainGUI.this.nowYear.getText() != null && !mainGUI.this.nowYear.getText().equals("")) {
                    cp.processNowYear(mainGUI.this.nowYear.getText().trim());
                }else{
                    SimpleDateFormat formatter= new SimpleDateFormat("yyyy");
                    Date date = new Date(System.currentTimeMillis());
                    String Year = formatter.format(date);
                    cp.processNowYear(Year);
                }

                if (mainGUI.this.myPhone.getText() != null && !mainGUI.this.myPhone.getText().equals("")) {
                    cp.processPhone(mainGUI.this.myPhone.getText().trim());
                }

                if (mainGUI.this.myHobbyNumber.getText() != null && !mainGUI.this.myHobbyNumber.getText().equals("")) {
                    cp.processHobbyNumber(mainGUI.this.myHobbyNumber.getText().trim());
                    cp.areaUrl.add(mainGUI.this.myHobbyNumber.getText().trim());
                }else{
                        cp.processHobbyNumber("456");
                }

                if (mainGUI.this.myHobbySymbol.getText() != null && !mainGUI.this.myHobbySymbol.getText().equals("")) {
                    cp.processSymbol(mainGUI.this.myHobbySymbol.getText().trim());
                }

                if (mainGUI.this.myUrl.getText() != null && !mainGUI.this.myUrl.getText().equals("")) {
                    cp.processUrl(mainGUI.this.myUrl.getText().trim());
                }

                /* 开始生成字典 */
                cp.produceAll(cp.areaA, cp.areaB, cp.areaC);
                cp.processUrlAndYear();
                cp.produceAllDict();

                resultMessage dialog = new resultMessage();
                dialog.setDefaultCloseOperation(2);
                dialog.setVisible(true);
                /* 确定后清空所以生成器数据缓存 */
                cp.clearListAll();

            }
        });
        JButton clearAll = new JButton("清空");
        clearAll.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                mainGUI.this.myname.setText("");
                mainGUI.this.myLove.setText("");
                mainGUI.this.myPhone.setText("");
                mainGUI.this.myBirth.setText("");
                mainGUI.this.myBirthYear.setText("");
                mainGUI.this.myHobbyNumber.setText("");
                mainGUI.this.myHobbySymbol.setText("");
                mainGUI.this.myIdcard.setText("");
                mainGUI.this.myUrl.setText("");
                mainGUI.this.myNearPersonName.setText("");
                mainGUI.this.myNearPersonBirth.setText("");
                mainGUI.this.nowYear.setText("");
            }
        });
        /* 开始选项面板布局 */
        GroupLayout gl_panel_2 = new GroupLayout(panel_2);
        gl_panel_2.setHorizontalGroup(gl_panel_2.createParallelGroup(Alignment.LEADING).addGroup(gl_panel_2.createSequentialGroup().addContainerGap().addGroup(gl_panel_2.createParallelGroup(Alignment.LEADING).addGroup(gl_panel_2.createParallelGroup(Alignment.LEADING).addComponent(checkBox_1).addComponent(start, -1, 85, 32767))).addGroup(gl_panel_2.createParallelGroup(Alignment.LEADING).addGroup(gl_panel_2.createSequentialGroup().addPreferredGap(ComponentPlacement.RELATED, 122, 32767)).addGroup(gl_panel_2.createSequentialGroup().addGap(70).addGroup(gl_panel_2.createParallelGroup(Alignment.LEADING).addComponent(checkBox).addGroup(gl_panel_2.createParallelGroup(Alignment.TRAILING).addComponent(clearAll, -2, 82, -2))).addContainerGap()))));
        gl_panel_2.setVerticalGroup(gl_panel_2.createParallelGroup(Alignment.LEADING).addGroup(gl_panel_2.createSequentialGroup().addContainerGap().addGroup(gl_panel_2.createParallelGroup(Alignment.BASELINE).addComponent(checkBox_1).addComponent(checkBox)).addGap(30).addGap(30).addGroup(gl_panel_2.createParallelGroup(Alignment.BASELINE).addComponent(start, -2, 45, -2).addComponent(clearAll, -2, 45, -2)).addContainerGap(45, 32767)));
        panel_2.setLayout(gl_panel_2);
        /* 基本信息面板设计 */
        JLabel label_1 = new JLabel("姓名：");
        label_1.setFont(new Font("微软雅黑", 1, 15));
        label_1.setForeground(Color.RED);
        this.myname = new JTextField();
        this.myname.setToolTipText("");
        this.myname.setColumns(10);
        JLabel label_2 = new JLabel("生日：");
        label_2.setFont(new Font("微软雅黑", 1, 15));
        label_2.setForeground(Color.RED);
        this.myBirth = new JTextField();
        this.myBirth.setToolTipText("");
        this.myBirth.setColumns(10);
        JLabel label_3 = new JLabel("身份证后六位：");
        label_3.setFont(new Font("微软雅黑", 1, 15));
        label_3.setForeground(Color.RED);
        this.myIdcard = new JTextField();
        this.myIdcard.setToolTipText("");
        this.myIdcard.setColumns(10);
        JLabel label_4 = new JLabel("出生年份：");
        label_4.setFont(new Font("微软雅黑", 1, 15));
        label_4.setForeground(Color.RED);
        this.myBirthYear = new JTextField();
        this.myBirthYear.setToolTipText("");
        this.myBirthYear.setColumns(10);
        JLabel label_5 = new JLabel("手机号：");
        label_5.setFont(new Font("微软雅黑", 1, 15));
        label_5.setForeground(Color.RED);
        this.myPhone = new JTextField();
        this.myPhone.setToolTipText("");
        this.myPhone.setColumns(10);
        JLabel label_6 = new JLabel("网站的域名：");
        label_6.setFont(new Font("微软雅黑", 1, 15));
        label_6.setForeground(Color.RED);
        this.myUrl = new JTextField();
        this.myUrl.setToolTipText("");
        this.myUrl.setColumns(10);
        JLabel label_7 = new JLabel("喜好的数字：");
        label_7.setFont(new Font("微软雅黑", 1, 15));
        label_7.setForeground(Color.RED);
        this.myHobbyNumber = new JTextField();
        this.myHobbyNumber.setToolTipText("");
        this.myHobbyNumber.setColumns(10);
        JLabel label_8 = new JLabel("喜好的符号：");
        label_8.setFont(new Font("微软雅黑", 1, 15));
        label_8.setForeground(Color.RED);
        this.myHobbySymbol = new JTextField();
        this.myHobbySymbol.setToolTipText("");
        this.myHobbySymbol.setColumns(10);
        JLabel label_9 = new JLabel("喜好的人或物：");
        label_9.setFont(new Font("微软雅黑", 1, 15));
        label_9.setForeground(Color.RED);
        this.myLove = new JTextField();
        this.myLove.setToolTipText("");
        this.myLove.setColumns(10);
        /* 基本信息面板布局 */
        GroupLayout gl_panel = new GroupLayout(panel);
        gl_panel.setHorizontalGroup(gl_panel.createParallelGroup(Alignment.LEADING).addGroup(gl_panel.createSequentialGroup().addContainerGap().addGroup(gl_panel.createParallelGroup(Alignment.LEADING).addGroup(gl_panel.createSequentialGroup().addGroup(gl_panel.createParallelGroup(Alignment.LEADING).addGroup(gl_panel.createSequentialGroup().addGroup(gl_panel.createParallelGroup(Alignment.LEADING, false).addComponent(label_1, -1, 72, 32767).addComponent(label_2, -1, 72, 32767).addComponent(label_3, -1, 72, 32767).addComponent(label_4, -1, 72, 32767).addComponent(label_5, -1, 72, 32767).addComponent(label_6, -1, -1, 32767).addComponent(label_7).addComponent(label_8)).addGap(68).addGroup(gl_panel.createParallelGroup(Alignment.LEADING).addComponent(this.myname, -2, 145, -2).addComponent(this.myHobbyNumber, -2, 145, -2).addComponent(this.myUrl, -2, 145, -2).addComponent(this.myPhone, -2, 145, -2).addComponent(this.myIdcard, -2, 145, -2).addComponent(this.myBirth, -2, 145, -2).addComponent(this.myBirthYear, -2, 145, -2).addComponent(this.myHobbySymbol, -2, 145, -2).addComponent(this.myLove, -2, 145, -2)))).addGap(29).addGroup(gl_panel.createParallelGroup(Alignment.LEADING).addGroup(gl_panel.createParallelGroup(Alignment.TRAILING, false)))).addComponent(label_9)).addContainerGap()));
        gl_panel.setVerticalGroup(gl_panel.createParallelGroup(Alignment.LEADING).addGroup(gl_panel.createSequentialGroup().addGap(29).addGroup(gl_panel.createParallelGroup(Alignment.LEADING).addGroup(gl_panel.createSequentialGroup().addPreferredGap(ComponentPlacement.UNRELATED).addGap(28).addGap(57).addGap(80).addGap(9).addGap(28).addContainerGap()).addGroup(gl_panel.createSequentialGroup().addGroup(gl_panel.createParallelGroup(Alignment.BASELINE).addGap(28).addComponent(label_1).addComponent(this.myname, -2, -1, -2)).addGroup(gl_panel.createParallelGroup(Alignment.BASELINE)).addGap(28).addGroup(gl_panel.createParallelGroup(Alignment.BASELINE).addGap(28).addComponent(label_2).addComponent(this.myBirth, -2, -1, -2)).addGap(28).addPreferredGap(ComponentPlacement.UNRELATED).addGroup(gl_panel.createParallelGroup(Alignment.BASELINE).addGap(28).addComponent(this.myIdcard, -2, -1, -2).addComponent(label_3)).addGap(28).addPreferredGap(ComponentPlacement.UNRELATED).addGroup(gl_panel.createParallelGroup(Alignment.BASELINE).addGap(28).addComponent(this.myBirthYear, -2, -1, -2).addComponent(label_4)).addGap(28).addGroup(gl_panel.createParallelGroup(Alignment.BASELINE).addGap(28).addComponent(label_5).addComponent(this.myPhone, -2, -1, -2)).addGap(28).addGroup(gl_panel.createParallelGroup(Alignment.BASELINE).addGap(28).addComponent(label_6).addComponent(this.myUrl, -2, -1, -2)).addGap(28).addPreferredGap(ComponentPlacement.UNRELATED).addGroup(gl_panel.createParallelGroup(Alignment.LEADING)).addPreferredGap(ComponentPlacement.UNRELATED).addGroup(gl_panel.createParallelGroup(Alignment.LEADING).addComponent(label_7).addComponent(this.myHobbyNumber, -2, -1, -2)).addGap(38).addGroup(gl_panel.createParallelGroup(Alignment.LEADING).addComponent(label_8).addComponent(this.myHobbySymbol, -2, -1, -2).addGroup(gl_panel.createSequentialGroup().addGap(56).addGroup(gl_panel.createParallelGroup(Alignment.BASELINE).addComponent(label_9).addComponent(this.myLove, -2, -1, -2))).addGroup(gl_panel.createSequentialGroup().addGap(28).addGroup(gl_panel.createParallelGroup(Alignment.BASELINE).addGap(28)))).addPreferredGap(ComponentPlacement.RELATED, -1, 32767).addGap(28)))));
        panel.setLayout(gl_panel);
        this.contentPane.setLayout(gl_contentPane);
    }

}

