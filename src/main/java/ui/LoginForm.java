/*
 * Created by JFormDesigner on Wed May 05 14:12:47 GMT+08:00 2021
 */

package ui;

import dao.Select;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;

/**
 * @author 1
 */
public class LoginForm extends JFrame {
    public LoginForm() {
        initComponents();
    }

    private void button2ActionPerformed(ActionEvent e) {
        // TODO add your code here
        String uid = textField1.getText();
        String password = textField2.getText();
        if (uid.isEmpty()) {
            JOptionPane.showMessageDialog(null, "用户名不能为空");
            return;
        }
        if (password.isEmpty()) {
            JOptionPane.showMessageDialog(null, "密码不能为空");
            return;
        }
        String uname = Select.checkuser(uid, password);
        if (!uname.isEmpty()) {
            System.out.println("登录成功");
            JOptionPane.showMessageDialog(null,"登录成功");
            userMainForm userMainForm=new userMainForm();
            userMainForm.setVisible(true);
            userMainForm.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            setVisible(false);
        } else {
            JOptionPane.showMessageDialog(null, "用户名或密码错误!");
        }

    }

    private void button1ActionPerformed(ActionEvent e) {
        // TODO add your code here
        String aid = textField1.getText();
        String apassword = textField2.getText();
        if (aid.isEmpty()) {
            JOptionPane.showMessageDialog(null, "用户名不能为空");
            return;
        }
        if (apassword.isEmpty()) {
            JOptionPane.showMessageDialog(null, "密码不能为空");
            return;
        }
        String aname = Select.checkadms(aid, apassword);
        if (!aname.isEmpty()) {
            JOptionPane.showMessageDialog(null, "登录成功");
            admsMainForm admsMainForm=new admsMainForm(aid);
            admsMainForm.setVisible(true);
            admsMainForm.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            setVisible(false);
        } else {
            JOptionPane.showMessageDialog(null, "用户名或密码错误");
        }
    }

    private void button3ActionPerformed(ActionEvent e) {
        // TODO add your code here
        RegisterForm registerForm = new RegisterForm();
        registerForm.setVisible(true);
        setVisible(false);
        registerForm.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    private void initComponents() {
        // JFormDesigner - Component initialization - DO NOT MODIFY  //GEN-BEGIN:initComponents
        label1 = new JLabel();
        label2 = new JLabel();
        label3 = new JLabel();
        button1 = new JButton();
        button2 = new JButton();
        button3 = new JButton();
        textField1 = new JTextField();
        textField2 = new JPasswordField();

        //======== this ========
        setTitle("\u767b\u5f55");
        setResizable(false);
        Container contentPane = getContentPane();
        contentPane.setLayout(null);

        //---- label1 ----
        label1.setText("\u56fe\u4e66\u7ba1\u7406\u7cfb\u7edf");
        label1.setFont(label1.getFont().deriveFont(label1.getFont().getSize() + 10f));
        contentPane.add(label1);
        label1.setBounds(new Rectangle(new Point(135, 50), label1.getPreferredSize()));

        //---- label2 ----
        label2.setText("\u8d26\u53f7\uff1a");
        contentPane.add(label2);
        label2.setBounds(new Rectangle(new Point(90, 110), label2.getPreferredSize()));

        //---- label3 ----
        label3.setText("\u5bc6\u7801\uff1a");
        contentPane.add(label3);
        label3.setBounds(new Rectangle(new Point(90, 155), label3.getPreferredSize()));

        //---- button1 ----
        button1.setText("\u7ba1\u7406\u5458\u767b\u5f55");
        button1.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                button1ActionPerformed(e);
            }
        });
        contentPane.add(button1);
        button1.setBounds(new Rectangle(new Point(58, 200), button1.getPreferredSize()));

        //---- button2 ----
        button2.setText("\u7528\u6237\u767b\u5f55");
        button2.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                button2ActionPerformed(e);
            }
        });
        contentPane.add(button2);
        button2.setBounds(new Rectangle(new Point(170, 200), button2.getPreferredSize()));

        //---- button3 ----
        button3.setText("\u6ce8\u518c");
        button3.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                button3ActionPerformed(e);
            }
        });
        contentPane.add(button3);
        button3.setBounds(new Rectangle(new Point(270, 200), button3.getPreferredSize()));
        contentPane.add(textField1);
        textField1.setBounds(160, 110, 95, textField1.getPreferredSize().height);
        contentPane.add(textField2);
        textField2.setBounds(160, 150, 95, textField2.getPreferredSize().height);

        contentPane.setPreferredSize(new Dimension(400, 300));
        pack();
        setLocationRelativeTo(getOwner());
        setVisible(true);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        // JFormDesigner - End of component initialization  //GEN-END:initComponents
    }

    // JFormDesigner - Variables declaration - DO NOT MODIFY  //GEN-BEGIN:variables
    private JLabel label1;
    private JLabel label2;
    private JLabel label3;
    private JButton button1;
    private JButton button2;
    private JButton button3;
    private JTextField textField1;
    private JPasswordField textField2;
    // JFormDesigner - End of variables declaration  //GEN-END:variables
}
