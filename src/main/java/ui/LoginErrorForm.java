/*
 * Created by JFormDesigner on Sun May 09 23:33:47 GMT+08:00 2021
 */

package ui;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

/**
 * @author unknown
 */
public class LoginErrorForm extends JFrame {
    public LoginErrorForm() {
        initComponents();
    }

    private void button1ActionPerformed(ActionEvent e) {
        // TODO add your code here
        setVisible(false);
    }

    private void initComponents() {
        // JFormDesigner - Component initialization - DO NOT MODIFY  //GEN-BEGIN:initComponents
        label1 = new JLabel();
        button1 = new JButton();

        //======== this ========
        setResizable(false);
        setTitle("\u767b\u5f55\u5931\u8d25\u63d0\u9192");
        Container contentPane = getContentPane();
        contentPane.setLayout(null);

        //---- label1 ----
        label1.setText("\u7528\u6237\u540d\u6216\u5bc6\u7801\u9519\u8bef\uff01\u8bf7\u91cd\u65b0\u767b\u5f55\uff01");
        contentPane.add(label1);
        label1.setBounds(95, 65, 235, 50);

        //---- button1 ----
        button1.setText("\u786e\u5b9a");
        button1.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                button1ActionPerformed(e);
            }
        });
        contentPane.add(button1);
        button1.setBounds(new Rectangle(new Point(160, 135), button1.getPreferredSize()));

        contentPane.setPreferredSize(new Dimension(400, 300));
        pack();
        setLocationRelativeTo(getOwner());
        setVisible(true);
        // JFormDesigner - End of component initialization  //GEN-END:initComponents
    }

    // JFormDesigner - Variables declaration - DO NOT MODIFY  //GEN-BEGIN:variables
    private JLabel label1;
    private JButton button1;
    // JFormDesigner - End of variables declaration  //GEN-END:variables
}
