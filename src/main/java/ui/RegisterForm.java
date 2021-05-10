/*
 * Created by JFormDesigner on Wed May 05 14:36:18 GMT+08:00 2021
 */

package ui;

import dao.Insert;

import java.awt.*;
import java.awt.event.*;
import java.sql.SQLException;
import javax.swing.*;

/**
 * @author 1
 */
public class RegisterForm extends JFrame {
    public RegisterForm() {
        initComponents();
    }

    private void button1ActionPerformed(ActionEvent e) {
        // TODO add your code here
        String a_id = textField1.getText();
        String a_name = textField5.getText();
        String a_password1 = textField2.getText();
        String a_password2 = textField3.getText();
        String ckeck = textField4.getText();
        if (a_password1.equals(a_password2)) {
            if (ckeck.equals("19992000")) {
                if(Insert.registeradmin(a_id, a_name, a_password1)) {
                    new ShowForm("管理员注册成功");
                }else {
                    new ShowForm("管理员已存在");
                }
            } else {
                new ShowForm("管理员注册认证失败");
            }
        } else {
            new ShowForm("两次输入密码不一致");
        }
    }

    private void button2ActionPerformed(ActionEvent e) {
        // TODO add your code here
        String u_id = textField1.getText();
        String u_name = textField5.getText();
        String u_password1 = textField2.getText();
        String u_password2 = textField3.getText();
        if (u_password1.equals(u_password2)) {
            if(Insert.registeruser(u_id, u_name, u_password1)) {
                new ShowForm("用户注册成功");
            }
            else {
                new ShowForm("用户已存在");
            }
        } else {
            new ShowForm("两次输入密码不一致");
        }
    }

    private void button3ActionPerformed(ActionEvent e) {
        // TODO add your code here
        new LoginForm();
        dispose();
    }

    private void initComponents() {
        // JFormDesigner - Component initialization - DO NOT MODIFY  //GEN-BEGIN:initComponents
        label1 = new JLabel();
        label2 = new JLabel();
        label3 = new JLabel();
        textField1 = new JTextField();
        textField2 = new JTextField();
        textField3 = new JTextField();
        button1 = new JButton();
        button2 = new JButton();
        label4 = new JLabel();
        textField4 = new JTextField();
        label5 = new JLabel();
        label6 = new JLabel();
        textField5 = new JTextField();
        button3 = new JButton();

        //======== this ========
        setTitle("\u6ce8\u518c");
        Container contentPane = getContentPane();
        contentPane.setLayout(null);

        //---- label1 ----
        label1.setText("\u7528\u6237id\uff1a");
        contentPane.add(label1);
        label1.setBounds(new Rectangle(new Point(60, 70), label1.getPreferredSize()));

        //---- label2 ----
        label2.setText("\u5bc6\u7801\uff1a");
        contentPane.add(label2);
        label2.setBounds(new Rectangle(new Point(60, 140), label2.getPreferredSize()));

        //---- label3 ----
        label3.setText("\u786e\u8ba4\u5bc6\u7801\uff1a");
        contentPane.add(label3);
        label3.setBounds(new Rectangle(new Point(60, 180), label3.getPreferredSize()));
        contentPane.add(textField1);
        textField1.setBounds(180, 65, 95, textField1.getPreferredSize().height);
        contentPane.add(textField2);
        textField2.setBounds(180, 135, 95, textField2.getPreferredSize().height);
        contentPane.add(textField3);
        textField3.setBounds(180, 175, 95, textField3.getPreferredSize().height);

        //---- button1 ----
        button1.setText("\u7ba1\u7406\u5458\u6ce8\u518c");
        button1.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                button1ActionPerformed(e);
            }
        });
        contentPane.add(button1);
        button1.setBounds(new Rectangle(new Point(60, 250), button1.getPreferredSize()));

        //---- button2 ----
        button2.setText("\u7528\u6237\u6ce8\u518c");
        button2.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                button2ActionPerformed(e);
            }
        });
        contentPane.add(button2);
        button2.setBounds(new Rectangle(new Point(230, 250), button2.getPreferredSize()));

        //---- label4 ----
        label4.setText("\u6ce8\u518c\u7ba1\u7406\u5458\u8ba4\u8bc1\u7801\uff1a");
        contentPane.add(label4);
        label4.setBounds(new Rectangle(new Point(60, 220), label4.getPreferredSize()));
        contentPane.add(textField4);
        textField4.setBounds(180, 215, 95, textField4.getPreferredSize().height);

        //---- label5 ----
        label5.setText("\u6b22\u8fce\u6ce8\u518c");
        label5.setFont(label5.getFont().deriveFont(label5.getFont().getSize() + 10f));
        contentPane.add(label5);
        label5.setBounds(new Rectangle(new Point(140, 10), label5.getPreferredSize()));

        //---- label6 ----
        label6.setText("\u7528\u6237\u540d\uff1a");
        contentPane.add(label6);
        label6.setBounds(new Rectangle(new Point(60, 105), label6.getPreferredSize()));
        contentPane.add(textField5);
        textField5.setBounds(180, 100, 95, textField5.getPreferredSize().height);

        //---- button3 ----
        button3.setText("\u8fd4\u56de");
        button3.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                button3ActionPerformed(e);
            }
        });
        contentPane.add(button3);
        button3.setBounds(new Rectangle(new Point(315, 135), button3.getPreferredSize()));

        contentPane.setPreferredSize(new Dimension(400, 345));
        pack();
        setLocationRelativeTo(getOwner());
        // JFormDesigner - End of component initialization  //GEN-END:initComponents
    }

    // JFormDesigner - Variables declaration - DO NOT MODIFY  //GEN-BEGIN:variables
    private JLabel label1;
    private JLabel label2;
    private JLabel label3;
    private JTextField textField1;
    private JTextField textField2;
    private JTextField textField3;
    private JButton button1;
    private JButton button2;
    private JLabel label4;
    private JTextField textField4;
    private JLabel label5;
    private JLabel label6;
    private JTextField textField5;
    private JButton button3;
    // JFormDesigner - End of variables declaration  //GEN-END:variables
}
