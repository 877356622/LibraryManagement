/*
 * Created by JFormDesigner on Tue May 11 13:31:23 GMT+08:00 2021
 */

package ui;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

/**
 * @author 1
 */
public class userMainForm extends JFrame {
    public userMainForm() {
        initComponents();
    }

    private void menuItem4ActionPerformed(ActionEvent e) {
        // TODO add your code here
        System.exit(0);
    }

    private void initComponents() {
        // JFormDesigner - Component initialization - DO NOT MODIFY  //GEN-BEGIN:initComponents
        menuBar1 = new JMenuBar();
        menu1 = new JMenu();
        menuItem1 = new JMenuItem();
        menuItem2 = new JMenuItem();
        menuItem3 = new JMenuItem();
        menuItem4 = new JMenuItem();
        menu2 = new JMenu();
        menuItem5 = new JMenuItem();
        menuItem6 = new JMenuItem();
        menu3 = new JMenu();
        menuItem7 = new JMenuItem();

        //======== this ========
        Container contentPane = getContentPane();
        contentPane.setLayout(null);

        //======== menuBar1 ========
        {

            //======== menu1 ========
            {
                menu1.setText("\u56fe\u4e66\u64cd\u4f5c");

                //---- menuItem1 ----
                menuItem1.setText("\u67e5\u770b\u56fe\u4e66");
                menu1.add(menuItem1);

                //---- menuItem2 ----
                menuItem2.setText("\u501f\u4e66");
                menu1.add(menuItem2);

                //---- menuItem3 ----
                menuItem3.setText("\u8fd8\u4e66");
                menu1.add(menuItem3);
                menu1.addSeparator();

                //---- menuItem4 ----
                menuItem4.setText("\u5b89\u5168\u9000\u51fa");
                menuItem4.addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        menuItem4ActionPerformed(e);
                    }
                });
                menu1.add(menuItem4);
            }
            menuBar1.add(menu1);

            //======== menu2 ========
            {
                menu2.setText("\u4e2a\u4eba\u4fe1\u606f\u7ba1\u7406");

                //---- menuItem5 ----
                menuItem5.setText("\u67e5\u770b\u4fe1\u606f");
                menu2.add(menuItem5);

                //---- menuItem6 ----
                menuItem6.setText("\u4fee\u6539\u4fe1\u606f");
                menu2.add(menuItem6);
            }
            menuBar1.add(menu2);

            //======== menu3 ========
            {
                menu3.setText("\u5173\u4e8e");

                //---- menuItem7 ----
                menuItem7.setText("\u7cfb\u7edf\u4fe1\u606f");
                menu3.add(menuItem7);
            }
            menuBar1.add(menu3);
        }
        setJMenuBar(menuBar1);

        contentPane.setPreferredSize(new Dimension(700, 450));
        pack();
        setLocationRelativeTo(getOwner());
        // JFormDesigner - End of component initialization  //GEN-END:initComponents
    }

    // JFormDesigner - Variables declaration - DO NOT MODIFY  //GEN-BEGIN:variables
    private JMenuBar menuBar1;
    private JMenu menu1;
    private JMenuItem menuItem1;
    private JMenuItem menuItem2;
    private JMenuItem menuItem3;
    private JMenuItem menuItem4;
    private JMenu menu2;
    private JMenuItem menuItem5;
    private JMenuItem menuItem6;
    private JMenu menu3;
    private JMenuItem menuItem7;
    // JFormDesigner - End of variables declaration  //GEN-END:variables
}
