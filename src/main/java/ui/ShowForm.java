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
public class ShowForm extends JFrame {
    public ShowForm(String message) {
        initComponents(message);
    }

    private void button1ActionPerformed(ActionEvent e) {
        // TODO add your code here
        dispose();
    }

    private void initComponents(String message) {
        // JFormDesigner - Component initialization - DO NOT MODIFY  //GEN-BEGIN:initComponents
        label1 = new JLabel();
        button1 = new JButton();

        //======== this ========
        setResizable(false);
        setTitle("提示信息");
        Container contentPane = getContentPane();
        contentPane.setLayout(null);

        //---- label1 ----
        label1.setText(message);
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
