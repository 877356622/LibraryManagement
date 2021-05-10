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
    }

    private void menuItem2ActionPerformed(ActionEvent e) {
        // TODO add your code here
    }

    private void menuItem3ActionPerformed(ActionEvent e) {
        // TODO add your code here
    }

    private void menuItem4ActionPerformed(ActionEvent e) {
        // TODO add your code here
    }

    private void menuItem5ActionPerformed(ActionEvent e) {
        // TODO add your code here
    }

    private void initComponents(String aname) {
        // JFormDesigner - Component initialization - DO NOT MODIFY  //GEN-BEGIN:initComponents
        menuBar1 = new JMenuBar();
        menu1 = new JMenu();
        menuItem1 = new JMenuItem();
        menuItem2 = new JMenuItem();
        menuItem3 = new JMenuItem();
        menu2 = new JMenu();
        menuItem4 = new JMenuItem();
        menuItem5 = new JMenuItem();

        //======== this ========
        setTitle("欢迎管理员 "+aname+" 登录本图书管理系统");
        Container contentPane = getContentPane();
        contentPane.setLayout(null);

        //======== menuBar1 ========
        {

            //======== menu1 ========
            {
                menu1.setText("\u6570\u636e\u7ba1\u7406");

                //---- menuItem1 ----
                menuItem1.setText("\u56fe\u4e66\u7c7b\u522b\u7ba1\u7406");
                menuItem1.addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        menuItem1ActionPerformed(e);
                    }
                });
                menu1.add(menuItem1);

                //---- menuItem2 ----
                menuItem2.setText("\u56fe\u4e66\u7ba1\u7406");
                menuItem2.addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        menuItem2ActionPerformed(e);
                    }
                });
                menu1.add(menuItem2);

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

        contentPane.setPreferredSize(new Dimension(800, 600));
        pack();
        setLocationRelativeTo(getOwner());
        setVisible(true);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        // JFormDesigner - End of component initialization  //GEN-END:initComponents
    }

    // JFormDesigner - Variables declaration - DO NOT MODIFY  //GEN-BEGIN:variables
    private JMenuBar menuBar1;
    private JMenu menu1;
    private JMenuItem menuItem1;
    private JMenuItem menuItem2;
    private JMenuItem menuItem3;
    private JMenu menu2;
    private JMenuItem menuItem4;
    private JMenuItem menuItem5;
    // JFormDesigner - End of variables declaration  //GEN-END:variables
}
