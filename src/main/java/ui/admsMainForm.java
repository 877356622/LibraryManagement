/*
 * Created by JFormDesigner on Mon May 10 11:44:19 GMT+08:00 2021
 */

package ui;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

/**
 * @author 1
 */
public class admsMainForm extends JFrame {
    public admsMainForm(String aname) {
        initComponents(aname);
    }

    private void menuItem1ActionPerformed(ActionEvent e) {
        // TODO add your code here
        panel1.setVisible(true);
    }


    private void menuItem3ActionPerformed(ActionEvent e) {
        // TODO add your code here
        System.exit(0);
    }

    private void menuItem4ActionPerformed(ActionEvent e) {
        // TODO add your code here
    }

    private void menuItem5ActionPerformed(ActionEvent e) {
        // TODO add your code here
    }

    private void menuItem8ActionPerformed(ActionEvent e) {
        // TODO add your code here
    }

    private void menuItem9ActionPerformed(ActionEvent e) {
        // TODO add your code here
    }

    private void menuItem10ActionPerformed(ActionEvent e) {
        // TODO add your code here
    }

    private void menuItem6ActionPerformed(ActionEvent e) {
        // TODO add your code here
    }

    private void menuItem7ActionPerformed(ActionEvent e) {
        // TODO add your code here
    }

    private void button1ActionPerformed(ActionEvent e) {
        // TODO add your code here
    }

    private void button2ActionPerformed(ActionEvent e) {
        // TODO add your code here
    }

    private void button14ActionPerformed(ActionEvent e) {
        // TODO add your code here
    }

    private void button15ActionPerformed(ActionEvent e) {
        // TODO add your code here
    }

    private void button12ActionPerformed(ActionEvent e) {
        // TODO add your code here
    }

    private void button13ActionPerformed(ActionEvent e) {
        // TODO add your code here
    }

    private void button11ActionPerformed(ActionEvent e) {
        // TODO add your code here
    }

    private void button9ActionPerformed(ActionEvent e) {
        // TODO add your code here
    }

    private void button10ActionPerformed(ActionEvent e) {
        // TODO add your code here
    }

    private void button8ActionPerformed(ActionEvent e) {
        // TODO add your code here
    }

    private void button7ActionPerformed(ActionEvent e) {
        // TODO add your code here
    }

    private void button6ActionPerformed(ActionEvent e) {
        // TODO add your code here
    }

    private void button5ActionPerformed(ActionEvent e) {
        // TODO add your code here
    }

    private void button4ActionPerformed(ActionEvent e) {
        // TODO add your code here
    }

    private void button3ActionPerformed(ActionEvent e) {
        // TODO add your code here
    }

    private void initComponents(String aname) {
        // JFormDesigner - Component initialization - DO NOT MODIFY  //GEN-BEGIN:initComponents
        menuBar1 = new JMenuBar();
        menu1 = new JMenu();
        menu4 = new JMenu();
        menuItem1 = new JMenuItem();
        menuItem8 = new JMenuItem();
        menu5 = new JMenu();
        menuItem9 = new JMenuItem();
        menuItem10 = new JMenuItem();
        menuItem3 = new JMenuItem();
        menu3 = new JMenu();
        menuItem6 = new JMenuItem();
        menuItem7 = new JMenuItem();
        menu2 = new JMenu();
        menuItem4 = new JMenuItem();
        menuItem5 = new JMenuItem();
        panel1 = new JPanel();
        label1 = new JLabel();
        label3 = new JLabel();
        label2 = new JLabel();
        textField1 = new JTextField();
        textField2 = new JTextField();
        button1 = new JButton();
        button2 = new JButton();
        textField9 = new JTextField();
        panel2 = new JPanel();
        label4 = new JLabel();
        scrollPane1 = new JScrollPane();
        table1 = new JTable();
        button3 = new JButton();
        button4 = new JButton();
        button5 = new JButton();
        textField4 = new JTextField();
        textField5 = new JTextField();
        label5 = new JLabel();
        button6 = new JButton();
        spinner1 = new JSpinner();
        label6 = new JLabel();
        label7 = new JLabel();
        textField6 = new JTextField();
        textField7 = new JTextField();
        button7 = new JButton();
        button8 = new JButton();
        textField8 = new JTextField();
        label8 = new JLabel();
        panel3 = new JPanel();
        label9 = new JLabel();
        label10 = new JLabel();
        label11 = new JLabel();
        label12 = new JLabel();
        label13 = new JLabel();
        label14 = new JLabel();
        label15 = new JLabel();
        button9 = new JButton();
        button10 = new JButton();
        textField10 = new JTextField();
        textField11 = new JTextField();
        textField13 = new JTextField();
        textField14 = new JTextField();
        textField15 = new JTextField();
        textField16 = new JTextField();
        comboBox1 = new JComboBox();
        panel4 = new JPanel();
        label16 = new JLabel();
        textField17 = new JTextField();
        label17 = new JLabel();
        comboBox2 = new JComboBox();
        button11 = new JButton();
        scrollPane3 = new JScrollPane();
        table2 = new JTable();
        label18 = new JLabel();
        textField18 = new JTextField();
        label19 = new JLabel();
        label20 = new JLabel();
        label21 = new JLabel();
        label22 = new JLabel();
        label23 = new JLabel();
        label24 = new JLabel();
        label25 = new JLabel();
        textField19 = new JTextField();
        textField20 = new JTextField();
        textField22 = new JTextField();
        comboBox3 = new JComboBox();
        textField23 = new JTextField();
        textField24 = new JTextField();
        textField25 = new JTextField();
        button12 = new JButton();
        button13 = new JButton();
        panel5 = new JPanel();
        label26 = new JLabel();
        label27 = new JLabel();
        textField26 = new JTextField();
        textField27 = new JTextField();
        panel6 = new JPanel();
        label28 = new JLabel();
        label29 = new JLabel();
        textField28 = new JTextField();
        textField29 = new JTextField();
        label30 = new JLabel();
        textField30 = new JTextField();
        button14 = new JButton();
        button15 = new JButton();
        panel7 = new JPanel();
        label32 = new JLabel();
        panel8 = new JPanel();
        label33 = new JLabel();
        panel9 = new JPanel();
        label31 = new JLabel();

        //======== this ========
        Container contentPane = getContentPane();
        contentPane.setLayout(null);

        //======== menuBar1 ========
        {

            //======== menu1 ========
            {
                menu1.setText("\u6570\u636e\u7ba1\u7406");

                //======== menu4 ========
                {
                    menu4.setText("\u56fe\u4e66\u7c7b\u522b\u7ba1\u7406");

                    //---- menuItem1 ----
                    menuItem1.setText("\u56fe\u4e66\u7c7b\u522b\u6dfb\u52a0");
                    menuItem1.addActionListener(new ActionListener() {
                        @Override
                        public void actionPerformed(ActionEvent e) {
                            menuItem1ActionPerformed(e);
                        }
                    });
                    menu4.add(menuItem1);

                    //---- menuItem8 ----
                    menuItem8.setText("\u56fe\u4e66\u7c7b\u522b\u7ba1\u7406");
                    menuItem8.addActionListener(new ActionListener() {
                        @Override
                        public void actionPerformed(ActionEvent e) {
                            menuItem8ActionPerformed(e);
                        }
                    });
                    menu4.add(menuItem8);
                }
                menu1.add(menu4);

                //======== menu5 ========
                {
                    menu5.setText("\u56fe\u4e66\u7ba1\u7406");

                    //---- menuItem9 ----
                    menuItem9.setText("\u56fe\u4e66\u6dfb\u52a0");
                    menuItem9.addActionListener(new ActionListener() {
                        @Override
                        public void actionPerformed(ActionEvent e) {
                            menuItem9ActionPerformed(e);
                        }
                    });
                    menu5.add(menuItem9);

                    //---- menuItem10 ----
                    menuItem10.setText("\u56fe\u4e66\u7ba1\u7406");
                    menuItem10.addActionListener(new ActionListener() {
                        @Override
                        public void actionPerformed(ActionEvent e) {
                            menuItem10ActionPerformed(e);
                        }
                    });
                    menu5.add(menuItem10);
                }
                menu1.add(menu5);
                menu1.addSeparator();

                //---- menuItem3 ----
                menuItem3.setText("\u5b89\u5168\u9000\u51fa");
                menuItem3.addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        menuItem3ActionPerformed(e);
                    }
                });
                menu1.add(menuItem3);
            }
            menuBar1.add(menu1);

            //======== menu3 ========
            {
                menu3.setText("\u4e2a\u4eba\u4fe1\u606f\u7ba1\u7406");

                //---- menuItem6 ----
                menuItem6.setText("\u67e5\u770b\u4fe1\u606f");
                menuItem6.addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        menuItem6ActionPerformed(e);
                    }
                });
                menu3.add(menuItem6);

                //---- menuItem7 ----
                menuItem7.setText("\u4fee\u6539\u4fe1\u606f");
                menuItem7.addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        menuItem7ActionPerformed(e);
                    }
                });
                menu3.add(menuItem7);
            }
            menuBar1.add(menu3);

            //======== menu2 ========
            {
                menu2.setText("\u5173\u4e8e");

                //---- menuItem4 ----
                menuItem4.setText("\u7248\u672c");
                menuItem4.addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        menuItem4ActionPerformed(e);
                    }
                });
                menu2.add(menuItem4);

                //---- menuItem5 ----
                menuItem5.setText("\u9002\u7528\u8303\u56f4");
                menuItem5.addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        menuItem5ActionPerformed(e);
                    }
                });
                menu2.add(menuItem5);
            }
            menuBar1.add(menu2);
        }
        setJMenuBar(menuBar1);

        //======== panel1 ========
        {
            panel1.setRequestFocusEnabled(false);
            panel1.setLayout(null);

            //---- label1 ----
            label1.setText("\u56fe\u4e66\u7c7b\u522bid:");
            panel1.add(label1);
            label1.setBounds(10, 15, 80, 30);

            //---- label3 ----
            label3.setText("\u56fe\u4e66\u7c7b\u522b\u540d\u79f0:");
            panel1.add(label3);
            label3.setBounds(10, 55, 80, 30);

            //---- label2 ----
            label2.setText("\u56fe\u4e66\u7c7b\u522b\u63cf\u8ff0:");
            panel1.add(label2);
            label2.setBounds(5, 145, 80, 30);
            panel1.add(textField1);
            textField1.setBounds(115, 20, 215, textField1.getPreferredSize().height);
            panel1.add(textField2);
            textField2.setBounds(115, 55, 215, textField2.getPreferredSize().height);

            //---- button1 ----
            button1.setText("\u6dfb\u52a0");
            button1.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    button1ActionPerformed(e);
                }
            });
            panel1.add(button1);
            button1.setBounds(new Rectangle(new Point(260, 270), button1.getPreferredSize()));

            //---- button2 ----
            button2.setText("\u91cd\u7f6e");
            button2.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    button2ActionPerformed(e);
                }
            });
            panel1.add(button2);
            button2.setBounds(new Rectangle(new Point(70, 270), button2.getPreferredSize()));
            panel1.add(textField9);
            textField9.setBounds(115, 110, 215, 145);
        }
        contentPane.add(panel1);
        panel1.setBounds(135, 40, 400, 300);

        //======== panel2 ========
        {
            panel2.setLayout(null);

            //---- label4 ----
            label4.setText("\u56fe\u4e66\u7c7b\u522b\u7ba1\u7406");
            panel2.add(label4);
            label4.setBounds(200, 15, 165, 25);

            //======== scrollPane1 ========
            {
                scrollPane1.setViewportView(table1);
            }
            panel2.add(scrollPane1);
            scrollPane1.setBounds(60, 45, 350, 200);

            //---- button3 ----
            button3.setText("\u4e0a\u4e00\u9875");
            button3.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    button3ActionPerformed(e);
                }
            });
            panel2.add(button3);
            button3.setBounds(new Rectangle(new Point(60, 260), button3.getPreferredSize()));

            //---- button4 ----
            button4.setText("\u4e0b\u4e00\u9875");
            button4.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    button4ActionPerformed(e);
                }
            });
            panel2.add(button4);
            button4.setBounds(new Rectangle(new Point(150, 260), button4.getPreferredSize()));

            //---- button5 ----
            button5.setText("\u8df3\u8f6c");
            button5.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    button5ActionPerformed(e);
                }
            });
            panel2.add(button5);
            button5.setBounds(new Rectangle(new Point(290, 260), button5.getPreferredSize()));
            panel2.add(textField4);
            textField4.setBounds(365, 260, 45, textField4.getPreferredSize().height);
            panel2.add(textField5);
            textField5.setBounds(420, 95, 110, textField5.getPreferredSize().height);

            //---- label5 ----
            label5.setText("\u56fe\u4e66\u7c7b\u522b\u540d\u79f0");
            panel2.add(label5);
            label5.setBounds(new Rectangle(new Point(420, 60), label5.getPreferredSize()));

            //---- button6 ----
            button6.setText("\u67e5\u8be2");
            button6.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    button6ActionPerformed(e);
                }
            });
            panel2.add(button6);
            button6.setBounds(new Rectangle(new Point(425, 135), button6.getPreferredSize()));
            panel2.add(spinner1);
            spinner1.setBounds(235, 260, 45, spinner1.getPreferredSize().height);

            //---- label6 ----
            label6.setText("\u56fe\u4e66\u7c7b\u522b\u7f16\u53f7");
            panel2.add(label6);
            label6.setBounds(new Rectangle(new Point(60, 300), label6.getPreferredSize()));

            //---- label7 ----
            label7.setText("\u56fe\u4e66\u7c7b\u522b\u540d\u79f0");
            panel2.add(label7);
            label7.setBounds(new Rectangle(new Point(60, 335), label7.getPreferredSize()));
            panel2.add(textField6);
            textField6.setBounds(145, 300, 50, textField6.getPreferredSize().height);
            panel2.add(textField7);
            textField7.setBounds(145, 335, 50, textField7.getPreferredSize().height);

            //---- button7 ----
            button7.setText("\u4fee\u6539");
            button7.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    button7ActionPerformed(e);
                }
            });
            panel2.add(button7);
            button7.setBounds(new Rectangle(new Point(60, 375), button7.getPreferredSize()));

            //---- button8 ----
            button8.setText("\u5220\u9664");
            button8.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    button8ActionPerformed(e);
                }
            });
            panel2.add(button8);
            button8.setBounds(new Rectangle(new Point(140, 375), button8.getPreferredSize()));
            panel2.add(textField8);
            textField8.setBounds(220, 300, 190, 95);

            //---- label8 ----
            label8.setText("\u56fe\u4e66\u7c7b\u522b\u63cf\u8ff0");
            panel2.add(label8);
            label8.setBounds(new Rectangle(new Point(425, 305), label8.getPreferredSize()));
        }
        contentPane.add(panel2);
        panel2.setBounds(100, 25, 540, 400);

        //======== panel3 ========
        {
            panel3.setLayout(null);

            //---- label9 ----
            label9.setText("\u56fe\u4e66\u7f16\u53f7\uff1a");
            panel3.add(label9);
            label9.setBounds(new Rectangle(new Point(50, 25), label9.getPreferredSize()));

            //---- label10 ----
            label10.setText("\u56fe\u4e66\u540d\u79f0\uff1a");
            panel3.add(label10);
            label10.setBounds(new Rectangle(new Point(50, 60), label10.getPreferredSize()));

            //---- label11 ----
            label11.setText("\u56fe\u4e66\u7c7b\u522b\uff1a");
            panel3.add(label11);
            label11.setBounds(new Rectangle(new Point(50, 95), label11.getPreferredSize()));

            //---- label12 ----
            label12.setText("\u56fe\u4e66\u4f5c\u8005\uff1a");
            panel3.add(label12);
            label12.setBounds(new Rectangle(new Point(250, 25), label12.getPreferredSize()));

            //---- label13 ----
            label13.setText("\u56fe\u4e66\u51fa\u7248\u793e\uff1a");
            panel3.add(label13);
            label13.setBounds(new Rectangle(new Point(250, 60), label13.getPreferredSize()));

            //---- label14 ----
            label14.setText("\u56fe\u4e66\u4ef7\u683c\uff1a");
            panel3.add(label14);
            label14.setBounds(new Rectangle(new Point(250, 95), label14.getPreferredSize()));

            //---- label15 ----
            label15.setText("\u56fe\u4e66\u63cf\u8ff0\uff1a");
            panel3.add(label15);
            label15.setBounds(new Rectangle(new Point(50, 130), label15.getPreferredSize()));

            //---- button9 ----
            button9.setText("\u6dfb\u52a0");
            button9.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    button9ActionPerformed(e);
                }
            });
            panel3.add(button9);
            button9.setBounds(new Rectangle(new Point(295, 300), button9.getPreferredSize()));

            //---- button10 ----
            button10.setText("\u91cd\u7f6e");
            button10.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    button10ActionPerformed(e);
                }
            });
            panel3.add(button10);
            button10.setBounds(new Rectangle(new Point(120, 300), button10.getPreferredSize()));
            panel3.add(textField10);
            textField10.setBounds(125, 20, 80, textField10.getPreferredSize().height);
            panel3.add(textField11);
            textField11.setBounds(125, 55, 80, textField11.getPreferredSize().height);
            panel3.add(textField13);
            textField13.setBounds(330, 20, 80, textField13.getPreferredSize().height);
            panel3.add(textField14);
            textField14.setBounds(330, 55, 80, textField14.getPreferredSize().height);
            panel3.add(textField15);
            textField15.setBounds(330, 90, 80, textField15.getPreferredSize().height);
            panel3.add(textField16);
            textField16.setBounds(125, 140, 285, 130);
            panel3.add(comboBox1);
            comboBox1.setBounds(125, 90, 80, 25);
        }
        contentPane.add(panel3);
        panel3.setBounds(80, 25, 500, 350);

        //======== panel4 ========
        {
            panel4.setLayout(null);

            //---- label16 ----
            label16.setText("\u56fe\u4e66\u540d\u5b57:");
            panel4.add(label16);
            label16.setBounds(new Rectangle(new Point(35, 20), label16.getPreferredSize()));
            panel4.add(textField17);
            textField17.setBounds(95, 15, 190, textField17.getPreferredSize().height);

            //---- label17 ----
            label17.setText("\u56fe\u4e66\u7c7b\u522b\uff1a");
            panel4.add(label17);
            label17.setBounds(new Rectangle(new Point(295, 20), label17.getPreferredSize()));
            panel4.add(comboBox2);
            comboBox2.setBounds(365, 15, 80, comboBox2.getPreferredSize().height);

            //---- button11 ----
            button11.setText("\u67e5\u8be2");
            button11.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    button11ActionPerformed(e);
                }
            });
            panel4.add(button11);
            button11.setBounds(new Rectangle(new Point(555, 15), button11.getPreferredSize()));

            //======== scrollPane3 ========
            {
                scrollPane3.setViewportView(table2);
            }
            panel4.add(scrollPane3);
            scrollPane3.setBounds(35, 50, 540, 290);

            //---- label18 ----
            label18.setText("\u4f5c\u8005\uff1a");
            panel4.add(label18);
            label18.setBounds(new Rectangle(new Point(455, 20), label18.getPreferredSize()));
            panel4.add(textField18);
            textField18.setBounds(490, 15, 55, textField18.getPreferredSize().height);

            //---- label19 ----
            label19.setText("\u56fe\u4e66\u63cf\u8ff0\uff1a");
            panel4.add(label19);
            label19.setBounds(35, 440, 60, 15);

            //---- label20 ----
            label20.setText("\u56fe\u4e66\u4ef7\u683c\uff1a");
            panel4.add(label20);
            label20.setBounds(295, 415, 60, 15);

            //---- label21 ----
            label21.setText("\u56fe\u4e66\u51fa\u7248\u793e\uff1a");
            panel4.add(label21);
            label21.setBounds(295, 380, 72, 15);

            //---- label22 ----
            label22.setText("\u56fe\u4e66\u4f5c\u8005\uff1a");
            panel4.add(label22);
            label22.setBounds(295, 350, 60, 15);

            //---- label23 ----
            label23.setText("\u56fe\u4e66\u7c7b\u522b\uff1a");
            panel4.add(label23);
            label23.setBounds(35, 410, 60, 15);

            //---- label24 ----
            label24.setText("\u56fe\u4e66\u540d\u79f0\uff1a");
            panel4.add(label24);
            label24.setBounds(35, 380, 60, 15);

            //---- label25 ----
            label25.setText("\u56fe\u4e66\u7f16\u53f7\uff1a");
            panel4.add(label25);
            label25.setBounds(35, 350, 60, 15);
            panel4.add(textField19);
            textField19.setBounds(105, 350, 130, textField19.getPreferredSize().height);
            panel4.add(textField20);
            textField20.setBounds(105, 380, 130, textField20.getPreferredSize().height);
            panel4.add(textField22);
            textField22.setBounds(105, 445, 380, 50);
            panel4.add(comboBox3);
            comboBox3.setBounds(110, 415, 125, comboBox3.getPreferredSize().height);
            panel4.add(textField23);
            textField23.setBounds(370, 350, 115, textField23.getPreferredSize().height);
            panel4.add(textField24);
            textField24.setBounds(370, 380, 115, textField24.getPreferredSize().height);
            panel4.add(textField25);
            textField25.setBounds(370, 410, 115, textField25.getPreferredSize().height);

            //---- button12 ----
            button12.setText("\u4fee\u6539");
            button12.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    button12ActionPerformed(e);
                }
            });
            panel4.add(button12);
            button12.setBounds(new Rectangle(new Point(525, 380), button12.getPreferredSize()));

            //---- button13 ----
            button13.setText("\u5220\u9664");
            button13.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    button13ActionPerformed(e);
                }
            });
            panel4.add(button13);
            button13.setBounds(new Rectangle(new Point(525, 445), button13.getPreferredSize()));
        }
        contentPane.add(panel4);
        panel4.setBounds(45, 25, 620, 520);

        //======== panel5 ========
        {
            panel5.setLayout(null);

            //---- label26 ----
            label26.setText("id:");
            panel5.add(label26);
            label26.setBounds(55, 25, 50, 50);

            //---- label27 ----
            label27.setText("\u7528\u6237\u540d\uff1a");
            panel5.add(label27);
            label27.setBounds(55, 105, 70, 45);
            panel5.add(textField26);
            textField26.setBounds(170, 45, 135, 30);
            panel5.add(textField27);
            textField27.setBounds(170, 110, 135, 30);
        }
        contentPane.add(panel5);
        panel5.setBounds(40, 25, 450, 305);

        //======== panel6 ========
        {
            panel6.setLayout(null);

            //---- label28 ----
            label28.setText("id:");
            panel6.add(label28);
            label28.setBounds(20, 20, 50, 50);

            //---- label29 ----
            label29.setText("\u7528\u6237\u540d\uff1a");
            panel6.add(label29);
            label29.setBounds(20, 100, 70, 45);
            panel6.add(textField28);
            textField28.setBounds(115, 35, 135, 30);
            panel6.add(textField29);
            textField29.setBounds(115, 105, 135, 30);

            //---- label30 ----
            label30.setText("\u5bc6\u7801\uff1a");
            panel6.add(label30);
            label30.setBounds(20, 180, 75, 40);
            panel6.add(textField30);
            textField30.setBounds(115, 180, 135, 30);

            //---- button14 ----
            button14.setText("\u4fee\u6539");
            button14.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    button14ActionPerformed(e);
                }
            });
            panel6.add(button14);
            button14.setBounds(new Rectangle(new Point(305, 65), button14.getPreferredSize()));

            //---- button15 ----
            button15.setText("\u91cd\u7f6e");
            button15.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    button15ActionPerformed(e);
                }
            });
            panel6.add(button15);
            button15.setBounds(new Rectangle(new Point(305, 130), button15.getPreferredSize()));
        }
        contentPane.add(panel6);
        panel6.setBounds(45, 25, 400, 300);

        //======== panel7 ========
        {
            panel7.setLayout(null);

            //---- label32 ----
            label32.setText("\u8be5\u7248\u672c\u4e3a1.0\u7248\u672c\uff01");
            panel7.add(label32);
            label32.setBounds(50, 30, 115, 30);
        }
        contentPane.add(panel7);
        panel7.setBounds(85, 10, 230, 100);

        //======== panel8 ========
        {
            panel8.setLayout(null);

            //---- label33 ----
            label33.setText("\u8be5\u7cfb\u7edf\u9002\u7528\u4e8e\u5c0f\u578b\u56fe\u4e66\u9986\uff01");
            panel8.add(label33);
            label33.setBounds(new Rectangle(new Point(40, 35), label33.getPreferredSize()));
        }
        contentPane.add(panel8);
        panel8.setBounds(105, 235, 200, 100);

        //======== panel9 ========
        {
            panel9.setLayout(null);

            //---- label31 ----
            label31.setText("\u6b22\u8fce\u8fdb\u5165\u672c\u56fe\u4e66\u7ba1\u7406\u7cfb\u7edf\uff01");
            label31.setFont(label31.getFont().deriveFont(label31.getFont().getSize() + 10f));
            panel9.add(label31);
            label31.setBounds(10, 0, 400, 170);
        }
        contentPane.add(panel9);
        panel9.setBounds(130, 75, 445, 200);

        contentPane.setPreferredSize(new Dimension(700, 600));
        pack();
        setLocationRelativeTo(getOwner());
        setVisible(true);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        // JFormDesigner - End of component initialization  //GEN-END:initComponents
    }

    // JFormDesigner - Variables declaration - DO NOT MODIFY  //GEN-BEGIN:variables
    private JMenuBar menuBar1;
    private JMenu menu1;
    private JMenu menu4;
    private JMenuItem menuItem1;
    private JMenuItem menuItem8;
    private JMenu menu5;
    private JMenuItem menuItem9;
    private JMenuItem menuItem10;
    private JMenuItem menuItem3;
    private JMenu menu3;
    private JMenuItem menuItem6;
    private JMenuItem menuItem7;
    private JMenu menu2;
    private JMenuItem menuItem4;
    private JMenuItem menuItem5;
    private JPanel panel1;
    private JLabel label1;
    private JLabel label3;
    private JLabel label2;
    private JTextField textField1;
    private JTextField textField2;
    private JButton button1;
    private JButton button2;
    private JTextField textField9;
    private JPanel panel2;
    private JLabel label4;
    private JScrollPane scrollPane1;
    private JTable table1;
    private JButton button3;
    private JButton button4;
    private JButton button5;
    private JTextField textField4;
    private JTextField textField5;
    private JLabel label5;
    private JButton button6;
    private JSpinner spinner1;
    private JLabel label6;
    private JLabel label7;
    private JTextField textField6;
    private JTextField textField7;
    private JButton button7;
    private JButton button8;
    private JTextField textField8;
    private JLabel label8;
    private JPanel panel3;
    private JLabel label9;
    private JLabel label10;
    private JLabel label11;
    private JLabel label12;
    private JLabel label13;
    private JLabel label14;
    private JLabel label15;
    private JButton button9;
    private JButton button10;
    private JTextField textField10;
    private JTextField textField11;
    private JTextField textField13;
    private JTextField textField14;
    private JTextField textField15;
    private JTextField textField16;
    private JComboBox comboBox1;
    private JPanel panel4;
    private JLabel label16;
    private JTextField textField17;
    private JLabel label17;
    private JComboBox comboBox2;
    private JButton button11;
    private JScrollPane scrollPane3;
    private JTable table2;
    private JLabel label18;
    private JTextField textField18;
    private JLabel label19;
    private JLabel label20;
    private JLabel label21;
    private JLabel label22;
    private JLabel label23;
    private JLabel label24;
    private JLabel label25;
    private JTextField textField19;
    private JTextField textField20;
    private JTextField textField22;
    private JComboBox comboBox3;
    private JTextField textField23;
    private JTextField textField24;
    private JTextField textField25;
    private JButton button12;
    private JButton button13;
    private JPanel panel5;
    private JLabel label26;
    private JLabel label27;
    private JTextField textField26;
    private JTextField textField27;
    private JPanel panel6;
    private JLabel label28;
    private JLabel label29;
    private JTextField textField28;
    private JTextField textField29;
    private JLabel label30;
    private JTextField textField30;
    private JButton button14;
    private JButton button15;
    private JPanel panel7;
    private JLabel label32;
    private JPanel panel8;
    private JLabel label33;
    private JPanel panel9;
    private JLabel label31;
    // JFormDesigner - End of variables declaration  //GEN-END:variables
}
