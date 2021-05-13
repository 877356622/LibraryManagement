/*
 * Created by JFormDesigner on Mon May 10 11:44:19 GMT+08:00 2021
 */

package ui;

import dao.Delete;
import dao.Insert;
import dao.Select;
import dao.Update;
import entity.Administrators;
import entity.Bookcategory;
import entity.Books;

import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;
import java.util.List;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;

/**
 * @author 1
 */
public class AdmsMainForm extends JFrame {
    public AdmsMainForm(String aid) {
        initComponents(aid);
    }

    private void menuItem1ActionPerformed(ActionEvent e) {
        // TODO add your code here
        //图书类别添加
        panel9.setVisible(false);
        panel2.setVisible(false);
        panel3.setVisible(false);
        panel4.setVisible(false);
        panel5.setVisible(false);
        panel6.setVisible(false);
        panel7.setVisible(false);
        panel8.setVisible(false);
        panel1.setVisible(true);
    }


    private void menuItem3ActionPerformed(ActionEvent e) {
        // TODO add your code here
        System.exit(0);
    }

    private void menuItem4ActionPerformed(ActionEvent e) {
        // TODO add your code here
        panel9.setVisible(false);
        panel1.setVisible(false);
        panel2.setVisible(false);
        panel3.setVisible(false);
        panel4.setVisible(false);
        panel5.setVisible(false);
        panel6.setVisible(false);
        panel8.setVisible(false);
        panel7.setVisible(true);
    }

    private void menuItem5ActionPerformed(ActionEvent e) {
        // TODO add your code here
        panel9.setVisible(false);
        panel1.setVisible(false);
        panel2.setVisible(false);
        panel3.setVisible(false);
        panel4.setVisible(false);
        panel5.setVisible(false);
        panel6.setVisible(false);
        panel7.setVisible(false);
        panel8.setVisible(true);
    }

    private void menuItem8ActionPerformed(ActionEvent e) {
        // TODO add your code here
        //图书类别管理
        panel9.setVisible(false);
        panel1.setVisible(false);
        panel3.setVisible(false);
        panel4.setVisible(false);
        panel5.setVisible(false);
        panel6.setVisible(false);
        panel7.setVisible(false);
        panel8.setVisible(false);
        panel2.setVisible(true);
        java.util.List<Bookcategory> list = new ArrayList<Bookcategory>();
        list = Select.serchbookcategorys();
        totalPage = list.size() % rowsPerPage == 0 ? list.size() / rowsPerPage : list.size() / rowsPerPage + 1;
        spinner1.setValue(currentPage);
        textField4.setText(String.valueOf(totalPage));
        bkdata = new Object[list.size()][bkhead.length];
        for (int i = 0; i < list.size(); i++) {
            bkdata[i][0] = list.get(i).getBk_id();
            bkdata[i][1] = list.get(i).getBk_name();
            bkdata[i][2] = list.get(i).getBk_desc();
        }
        DefaultTableModel tableModel1 = new DefaultTableModel(bkdata, bkhead);
        table1.setModel(tableModel1);
        bkdata = null;
    }

    private void menuItem9ActionPerformed(ActionEvent e) {
        // TODO add your code here
        //图书添加
        panel9.setVisible(false);
        panel1.setVisible(false);
        panel2.setVisible(false);
        panel4.setVisible(false);
        panel5.setVisible(false);
        panel6.setVisible(false);
        panel7.setVisible(false);
        panel8.setVisible(false);
        panel3.setVisible(true);
        List<Bookcategory> list = new ArrayList<Bookcategory>();
        list = Select.serchbookcategorys();
        comboBox1.addItem("-请选择-");
        for (int i = 0; i < list.size(); i++) {
            String bk_name = list.get(i).getBk_name();
            comboBox1.addItem(bk_name);
        }

    }

    private void menuItem10ActionPerformed(ActionEvent e) {
        // TODO add your code here
        //图书管理
        panel9.setVisible(false);
        panel1.setVisible(false);
        panel2.setVisible(false);
        panel3.setVisible(false);
        panel5.setVisible(false);
        panel6.setVisible(false);
        panel7.setVisible(false);
        panel8.setVisible(false);
        panel4.setVisible(true);
        List<Bookcategory> list = new ArrayList<Bookcategory>();
        list = Select.serchbookcategorys();
        comboBox2.addItem("-请选择-");
        for (int i = 0; i < list.size(); i++) {
            String bk_name = list.get(i).getBk_name();
            comboBox2.addItem(bk_name);
        }

        bdata = new Object[0][bhead.length];
        DefaultTableModel tableModel2 = new DefaultTableModel(bdata, bhead);
        table2.setModel(tableModel2);
        bdata = null;

    }

    private void menuItem6ActionPerformed(ActionEvent e, String aname) {
        // TODO add your code here
        //查询个人信息
        panel9.setVisible(false);
        panel1.setVisible(false);
        panel2.setVisible(false);
        panel3.setVisible(false);
        panel4.setVisible(false);
        panel6.setVisible(false);
        panel7.setVisible(false);
        panel8.setVisible(false);
        panel5.setVisible(true);
        Administrators administrators = Select.serchadms(aname);
        textField26.setText(administrators.getA_id());
        textField27.setText(administrators.getA_name());

    }

    private void menuItem7ActionPerformed(ActionEvent e, String aid) {
        // TODO add your code here
        //修改个人信息
        panel9.setVisible(false);
        panel1.setVisible(false);
        panel2.setVisible(false);
        panel3.setVisible(false);
        panel4.setVisible(false);
        panel5.setVisible(false);
        panel7.setVisible(false);
        panel8.setVisible(false);
        panel6.setVisible(true);
        Administrators administrators = Select.serchadms(aid);
        textField28.setText(administrators.getA_id());
        textField29.setText(administrators.getA_name());
    }

    private void button1ActionPerformed(ActionEvent e) {
        // TODO add your code here
        //图书类别添加按钮
        String bk_id = textField1.getText();
        String bk_name = textField2.getText();
        String bk_desc = textField9.getText();
        if (bk_id.isEmpty()) {
            JOptionPane.showMessageDialog(null, "图书类别id不能为空");
            return;
        }
        if (bk_name.isEmpty()) {
            JOptionPane.showMessageDialog(null, "图书类别名称不能为空");
            return;
        }
        if (Insert.Insertbookcategory(bk_id, bk_name, bk_desc)) {
            JOptionPane.showMessageDialog(null, "图书类别添加成功");
        } else {
            JOptionPane.showMessageDialog(null, "图书类别添加失败，可能原因为图书id已存在");
        }
    }

    private void button2ActionPerformed(ActionEvent e) {
        // TODO add your code here
        //图书类别重置按钮
        textField1.setText("");
        textField2.setText("");
        textField9.setText("");
    }

    private void button14ActionPerformed(ActionEvent e) {
        // TODO add your code here
        //修改用户名和密码
        String a_id = textField28.getText();
        String a_name = textField29.getText();
        String a_password = textField30.getText();
        if (a_id.isEmpty()) {
            JOptionPane.showMessageDialog(null, "用户id不能为空");
            return;
        }
        if (a_name.isEmpty()) {
            JOptionPane.showMessageDialog(null, "用户名不能为空");
            return;
        }
        if (a_password.isEmpty()) {
            JOptionPane.showMessageDialog(null, "密码不能为空");
            return;
        }
        if (Update.updateAdms(a_id, a_name, a_password)) {
            JOptionPane.showMessageDialog(null, "修改信息成功");
            initComponents(a_id);
        } else {
            JOptionPane.showMessageDialog(null, "修改信息失败");

        }

    }

    private void button15ActionPerformed(ActionEvent e) {
        // TODO add your code here
        //重置
        textField28.setText("");
        textField29.setText("");
        textField30.setText("");
    }


    private void button12ActionPerformed(ActionEvent e) {
        // TODO add your code here
        //图书修改
        Books books=new Books();
        books.setB_id(textField19.getText());
        books.setB_name(textField20.getText());
        books.setB_desc(textField22.getText());
        books.setB_author(textField23.getText());
        books.setB_edit(textField24.getText());
        books.setB_number(Integer.parseInt(textField12.getText()));
        books.setB_price(Double.valueOf(textField25.getText()));
        if(Update.updateBooks(books)){
            JOptionPane.showMessageDialog(null,"修改成功");
        }else {
            JOptionPane.showMessageDialog(null,"修改失败");
        }
    }

    private void button13ActionPerformed(ActionEvent e) {
        // TODO add your code here
        //图书删除
        String b_id=textField19.getText();
        if(Delete.deletebook(b_id)){
            JOptionPane.showMessageDialog(null,"删除成功");
        }else {
            JOptionPane.showMessageDialog(null,"删除失败");
        }
    }

    private void button11ActionPerformed(ActionEvent e) {
        // TODO add your code here
        //图书管理查找
        String b_name = textField17.getText();
        String b_author = textField18.getText();
        String bk_name = (String) comboBox2.getSelectedItem();
        List<Books> list = new ArrayList<Books>();
        if (b_name.isEmpty() && b_author.isEmpty() && bk_name.equals("-请选择-")) {
            list = Select.serchBooks();
        } else if (!b_name.isEmpty() && b_author.isEmpty() && bk_name.equals("-请选择-")) {
            list = Select.serchBooksForName(b_name);
        } else if (b_name.isEmpty() && !b_author.isEmpty() && bk_name.equals("-请选择-")) {
            list = Select.serchBooksForauthor(b_author);
        } else if (b_name.isEmpty() && b_author.isEmpty() && !bk_name.equals("-请选择-")) {
            String bk_id = Select.serchbk_id(bk_name);
            list = Select.serchBooksForBkid(bk_id);
        } else if (!b_name.isEmpty() && !b_author.isEmpty() && bk_name.equals("-请选择-")) {
            list = Select.serchBooksForNameAndAuthor(b_name, b_author);
        } else if (!b_name.isEmpty() && b_author.isEmpty() && !bk_name.equals("-请选择-")) {
            String bk_id = Select.serchbk_id(bk_name);
            list = Select.serchBooksForNameAndBkid(b_name, bk_id);
        } else if (b_name.isEmpty() && !b_author.isEmpty() && !bk_name.equals("-请选择-")) {
            String bk_id = Select.serchbk_id(bk_name);
            list = Select.serchBooksForAuthorAndBkid(b_author, bk_id);
        } else {
            String bk_id = Select.serchbk_id(bk_name);
            list = Select.serchBooks(b_name, b_author, bk_id);
        }
        if (!bk_name.equals("-请选择-")) {
            bdata = new Object[list.size()][bhead.length];
            for (int i = 0; i < list.size(); i++) {
                bdata[i][0] = list.get(i).getB_id();
                bdata[i][1] = list.get(i).getB_name();
                bdata[i][2] = bk_name;
                bdata[i][3] = list.get(i).getB_author();
                bdata[i][4] = list.get(i).getB_price();
                bdata[i][5] = list.get(i).getB_edit();
                bdata[i][6] = list.get(i).getB_number();
                bdata[i][7] = list.get(i).getB_desc();
            }
        } else {
            String bk_id[]=new String[list.size()];
            for(int i=0;i<list.size();i++){
                bk_id[i]=list.get(i).getBk_id();
            }
            List<String> bk_nameList=Select.serchBk_name(bk_id);
            bdata = new Object[list.size()][bhead.length];
            for (int i = 0; i < list.size(); i++) {
                bdata[i][0] = list.get(i).getB_id();
                bdata[i][1] = list.get(i).getB_name();
                bdata[i][2] = bk_nameList.get(i);
                bdata[i][3] = list.get(i).getB_author();
                bdata[i][4] = list.get(i).getB_price();
                bdata[i][5] = list.get(i).getB_edit();
                bdata[i][6] = list.get(i).getB_number();
                bdata[i][7] = list.get(i).getB_desc();
            }
        }
        DefaultTableModel tableModel2 = new DefaultTableModel(bdata, bhead);
        table2.setModel(tableModel2);
        bdata = null;
    }

    private void button16ActionPerformed(ActionEvent e){
        //图书管理获取
        String getname;
        if(textField19.getText().isEmpty()) {
            int count = table2.getSelectedRow();//获取你选中的行号（记录）
            getname = table2.getValueAt(count, 0).toString();//读取你获取行号的某一列的值（也就是字段）
            textField19.setText(getname);
        }
        String b_id=textField19.getText();
        Books books=Select.getBooks(b_id);
        if(books.getBk_id().length()==0){
            JOptionPane.showMessageDialog(null,"没有该图书");
            return;
        }
        textField22.setText(books.getB_desc());
        textField12.setText(String.valueOf(books.getB_number()));
        textField20.setText(books.getB_name());
        textField23.setText(books.getB_author());
        textField24.setText(books.getB_edit());
        textField25.setText(String.valueOf(books.getB_price()));
    }

    private void button9ActionPerformed(ActionEvent e) {
        // TODO add your code here
        //图书添加按钮
        Books books = new Books();
        books.setB_id(textField10.getText());
        books.setB_name(textField11.getText());
        books.setB_author(textField13.getText());
        books.setB_edit(textField14.getText());
        books.setB_price(Double.valueOf(textField15.getText()));
        books.setB_desc(textField16.getText());
        books.setB_number(Integer.valueOf(textField3.getText()));
        books.setBk_id(Select.serchbk_id(comboBox1.getSelectedItem()));
        if(books.getB_id().isEmpty()){
            JOptionPane.showMessageDialog(null,"图书编号不能为空");
            return;
        }
        if(books.getB_author().isEmpty()){
            JOptionPane.showMessageDialog(null,"图书作者不能为空");
            return;
        }
        if(books.getB_name().isEmpty()){
            JOptionPane.showMessageDialog(null,"图书名字不能为空");
            return;
        }
        if(books.getB_desc().isEmpty()){
            JOptionPane.showMessageDialog(null,"图书描述不能为空");
            return;
        }
        if(books.getB_edit().isEmpty()){
            JOptionPane.showMessageDialog(null,"图书出版社不能为空");
            return;
        }
        if(String.valueOf(books.getB_price()).isEmpty()){
            JOptionPane.showMessageDialog(null,"图书价格不能为空");
            return;
        }
        if(String.valueOf(books.getB_price()).isEmpty()){
            JOptionPane.showMessageDialog(null,"图书数量不能为空");
            return;
        }
        if(Insert.Insertbooks(books)){
            JOptionPane.showMessageDialog(null,"添加图书成功");
        }else {
            JOptionPane.showMessageDialog(null,"添加图书失败");
        }
    }

    private void button10ActionPerformed(ActionEvent e) {
        // TODO add your code here
        //图书添加重置按钮
        textField10.setText("");
        textField11.setText("");
        textField13.setText("");
        textField14.setText("");
        textField15.setText("");
        textField16.setText("");
        textField3.setText("");
    }

    private void button8ActionPerformed(ActionEvent e) {
        // TODO add your code here
        //图书类别删除按钮
        String bk_id = textField6.getText();
        if (Delete.deletebookcategory(bk_id)) {
            JOptionPane.showMessageDialog(null, "删除成功");
        } else {
            JOptionPane.showMessageDialog(null, "删除失败");
        }
    }

    private void button7ActionPerformed(ActionEvent e) {
        // TODO add your code here
        //图书类别修改按钮
        String bk_id = textField6.getText();
        String bk_name = textField7.getText();
        String bk_desc = textField8.getText();
        if (Update.updateBookcategory(bk_id, bk_name, bk_desc)) {
            JOptionPane.showMessageDialog(null, "修改成功");
        } else {
            JOptionPane.showMessageDialog(null, "修改失败");
        }
    }

    private void button6ActionPerformed(ActionEvent e) {
        // TODO add your code here
        //图书管理查询
        String bk_name = textField5.getText();
        java.util.List<Bookcategory> list = new ArrayList<Bookcategory>();
        list = Select.serchbookcategorys(bk_name);
        bkdata = new Object[list.size()][bkhead.length];
        for (int i = 0; i < list.size(); i++) {
            bkdata[i][0] = list.get(i).getBk_id();
            bkdata[i][1] = list.get(i).getBk_name();
            bkdata[i][2] = list.get(i).getBk_desc();
        }
        DefaultTableModel tableModel1 = new DefaultTableModel(bkdata, bkhead);
        table1.setModel(tableModel1);
        bkdata = null;
        spinner1.setValue(currentPage);

    }

    private void button5ActionPerformed(ActionEvent e) {
        // TODO add your code here
        //跳转
        currentPage = Integer.parseInt(String.valueOf(spinner1.getValue()));
        if (currentPage >= 1 && currentPage <= totalPage) {
            java.util.List<Bookcategory> list = new ArrayList<Bookcategory>();
            list = Select.serchbookcategorys(currentPage, rowsPerPage);
            bkdata = new Object[list.size()][bkhead.length];
            for (int i = 0; i < list.size(); i++) {
                bkdata[i][0] = list.get(i).getBk_id();
                bkdata[i][1] = list.get(i).getBk_name();
                bkdata[i][2] = list.get(i).getBk_desc();
            }
            DefaultTableModel tableModel1 = new DefaultTableModel(bkdata, bkhead);
            table1.setModel(tableModel1);
            bkdata = null;
            spinner1.setValue(currentPage);
        } else {
            JOptionPane.showMessageDialog(null, "超出范围");
        }
    }

    private void button4ActionPerformed(ActionEvent e) {
        // TODO add your code here
        //图书管理下一页
        if (currentPage == totalPage) {
            JOptionPane.showMessageDialog(null, "已经是最后一页");
            return;
        } else {
            currentPage++;
            java.util.List<Bookcategory> list = new ArrayList<Bookcategory>();
            list = Select.serchbookcategorys(currentPage, rowsPerPage);
            bkdata = new Object[list.size()][bkhead.length];
            for (int i = 0; i < list.size(); i++) {
                bkdata[i][0] = list.get(i).getBk_id();
                bkdata[i][1] = list.get(i).getBk_name();
                bkdata[i][2] = list.get(i).getBk_desc();
            }
            DefaultTableModel tableModel1 = new DefaultTableModel(bkdata, bkhead);
            table1.setModel(tableModel1);
            bkdata = null;
            spinner1.setValue(currentPage);
        }
    }

    private void button3ActionPerformed(ActionEvent e) {
        // TODO add your code here
        //图书管理上一页
        if (currentPage == 1) {
            JOptionPane.showMessageDialog(null, "已经是第一页");
            return;
        } else {
            currentPage--;
            java.util.List<Bookcategory> list = new ArrayList<Bookcategory>();
            list = Select.serchbookcategorys(currentPage, rowsPerPage);
            bkdata = new Object[list.size()][bkhead.length];
            for (int i = 0; i < list.size(); i++) {
                bkdata[i][0] = list.get(i).getBk_id();
                bkdata[i][1] = list.get(i).getBk_name();
                bkdata[i][2] = list.get(i).getBk_desc();
            }
            DefaultTableModel tableModel1 = new DefaultTableModel(bkdata, bkhead);
            table1.setModel(tableModel1);
            bkdata = null;
            spinner1.setValue(currentPage);
        }
    }


    private void initComponents(final String aid) {
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
        label34 = new JLabel();
        textField3 = new JTextField();
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
        label24 = new JLabel();
        label25 = new JLabel();
        textField19 = new JTextField();
        textField20 = new JTextField();
        textField22 = new JTextField();
        textField23 = new JTextField();
        textField24 = new JTextField();
        textField25 = new JTextField();
        button12 = new JButton();
        button13 = new JButton();
        label35 = new JLabel();
        textField12 = new JTextField();
        button16 = new JButton();
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
        setTitle("欢迎管理员 "+Select.serchadms(aid).getA_name()+" 使用本系统");
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
                        menuItem6ActionPerformed(e,aid);
                    }
                });
                menu3.add(menuItem6);

                //---- menuItem7 ----
                menuItem7.setText("\u4fee\u6539\u4fe1\u606f");
                menuItem7.addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        menuItem7ActionPerformed(e,aid);
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
            label3.setBounds(10, 55, 95, 30);

            //---- label2 ----
            label2.setText("\u56fe\u4e66\u7c7b\u522b\u63cf\u8ff0:");
            panel1.add(label2);
            label2.setBounds(10, 145, 95, 30);
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
        panel1.setBounds(135, 40, 700, 550);

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
        panel2.setBounds(100, 25, 700, 550);

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
            label15.setBounds(new Rectangle(new Point(50, 180), label15.getPreferredSize()));

            //---- button9 ----
            button9.setText("\u6dfb\u52a0");
            button9.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    button9ActionPerformed(e);
                }
            });
            panel3.add(button9);
            button9.setBounds(new Rectangle(new Point(300, 315), button9.getPreferredSize()));

            //---- button10 ----
            button10.setText("\u91cd\u7f6e");
            button10.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    button10ActionPerformed(e);
                }
            });
            panel3.add(button10);
            button10.setBounds(new Rectangle(new Point(120, 315), button10.getPreferredSize()));
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
            textField16.setBounds(125, 165, 285, 130);
            panel3.add(comboBox1);
            comboBox1.setBounds(125, 90, 80, 25);

            //---- label34 ----
            label34.setText("\u56fe\u4e66\u6570\u91cf\uff1a");
            panel3.add(label34);
            label34.setBounds(new Rectangle(new Point(50, 130), label34.getPreferredSize()));
            panel3.add(textField3);
            textField3.setBounds(125, 130, 80, textField3.getPreferredSize().height);
        }
        contentPane.add(panel3);
        panel3.setBounds(80, 25, 700, 550);

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
            button11.setBounds(new Rectangle(new Point(600, 15), button11.getPreferredSize()));

            //======== scrollPane3 ========
            {
                scrollPane3.setViewportView(table2);
            }
            panel4.add(scrollPane3);
            scrollPane3.setBounds(35, 50, 650, 290);

            //---- label18 ----
            label18.setText("\u4f5c\u8005\uff1a");
            panel4.add(label18);
            label18.setBounds(new Rectangle(new Point(490, 20), label18.getPreferredSize()));
            panel4.add(textField18);
            textField18.setBounds(530, 15, 55, textField18.getPreferredSize().height);

            //---- label19 ----
            label19.setText("\u56fe\u4e66\u63cf\u8ff0\uff1a");
            panel4.add(label19);
            label19.setBounds(35, 440, 70, 15);

            //---- label20 ----
            label20.setText("\u56fe\u4e66\u4ef7\u683c\uff1a");
            panel4.add(label20);
            label20.setBounds(295, 415, 70, 15);

            //---- label21 ----
            label21.setText("\u56fe\u4e66\u51fa\u7248\u793e\uff1a");
            panel4.add(label21);
            label21.setBounds(295, 380, 80, 15);

            //---- label22 ----
            label22.setText("\u56fe\u4e66\u4f5c\u8005\uff1a");
            panel4.add(label22);
            label22.setBounds(295, 350, 70, 15);


            //---- label24 ----
            label24.setText("\u56fe\u4e66\u540d\u79f0\uff1a");
            panel4.add(label24);
            label24.setBounds(35, 380, 70, 15);

            //---- label25 ----
            label25.setText("\u56fe\u4e66\u7f16\u53f7\uff1a");
            panel4.add(label25);
            label25.setBounds(35, 350, 70, 15);
            panel4.add(textField19);
            textField19.setBounds(105, 350, 130, textField19.getPreferredSize().height);
            panel4.add(textField20);
            textField20.setBounds(105, 380, 130, textField20.getPreferredSize().height);
            panel4.add(textField22);
            textField22.setBounds(105, 445, 380, 120);
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
            button12.setBounds(new Rectangle(new Point(525, 425), button12.getPreferredSize()));

            //---- button13 ----
            button13.setText("\u5220\u9664");
            button13.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    button13ActionPerformed(e);
                }
            });
            panel4.add(button13);
            button13.setBounds(new Rectangle(new Point(525, 490), button13.getPreferredSize()));

            //---- label35 ----
            label35.setText("\u56fe\u4e66\u6570\u91cf\uff1a");
            panel4.add(label35);
            label35.setBounds(new Rectangle(new Point(35, 410), label35.getPreferredSize()));
            panel4.add(textField12);
            textField12.setBounds(105, 410, 130, textField12.getPreferredSize().height);

            //---- button16 ----
            button16.setText("\u83b7\u53d6");
            button16.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    button16ActionPerformed(e);
                }
            });
            panel4.add(button16);
            button16.setBounds(new Rectangle(new Point(525, 370), button16.getPreferredSize()));
        }
        contentPane.add(panel4);
        panel4.setBounds(45, 25, 700, 550);

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
        panel5.setBounds(40, 25, 700, 550);

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
        panel6.setBounds(45, 25, 700, 550);

        //======== panel7 ========
        {
            panel7.setLayout(null);

            //---- label32 ----
            label32.setText("\u8be5\u7248\u672c\u4e3a1.0\u7248\u672c\uff01");
            panel7.add(label32);
            label32.setBounds(50, 30, 115, 30);
        }
        contentPane.add(panel7);
        panel7.setBounds(85, 10, 700, 550);

        //======== panel8 ========
        {
            panel8.setLayout(null);

            //---- label33 ----
            label33.setText("\u8be5\u7cfb\u7edf\u9002\u7528\u4e8e\u5c0f\u578b\u56fe\u4e66\u9986\uff01");
            panel8.add(label33);
            label33.setBounds(new Rectangle(new Point(40, 35), label33.getPreferredSize()));
        }
        contentPane.add(panel8);
        panel8.setBounds(105, 235, 700, 550);

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
        panel9.setBounds(130, 75, 700, 550);

        panel2.setVisible(false);
        panel1.setVisible(false);
        panel3.setVisible(false);
        panel4.setVisible(false);
        panel5.setVisible(false);
        panel6.setVisible(false);
        panel7.setVisible(false);
        panel8.setVisible(false);
        contentPane.setPreferredSize(new Dimension(815, 675));
        pack();
        setLocationRelativeTo(getOwner());
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
    private JLabel label34;
    private JTextField textField3;
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
    private JLabel label24;
    private JLabel label25;
    private JTextField textField19;
    private JTextField textField20;
    private JTextField textField22;
    private JTextField textField23;
    private JTextField textField24;
    private JTextField textField25;
    private JButton button12;
    private JButton button13;
    private JLabel label35;
    private JTextField textField12;
    private JButton button16;
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
    private Object[][] bkdata = null;
    private String bkhead[] = {"图书类别编号", "图书类别名称", "图书类别描述"};
    private Object[][] bdata = null;
    private String bhead[] = {"图书编号", "图书名称", "图书类别名称", "图书作者", "价格", "出版社","数量", "描述"};
    private int currentPage = 1;
    private int rowsPerPage = 10;
    private int totalPage;
    // JFormDesigner - End of variables declaration  //GEN-END:variables
}
