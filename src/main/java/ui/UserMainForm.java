/*
 * Created by JFormDesigner on Tue May 11 13:31:23 GMT+08:00 2021
 */

package ui;

import dao.Insert;
import dao.Select;
import dao.Update;
import entity.Bookcategory;
import entity.Books;
import entity.Borrows;
import entity.Users;
import util.CreateUUID;

import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;
import java.util.List;
import javax.swing.*;
import javax.swing.event.*;
import javax.swing.table.DefaultTableModel;

/**
 * @author 1
 */
public class UserMainForm extends JFrame {
    public UserMainForm(String uid) {
        initComponents(uid);
    }

    private void menuItem4ActionPerformed(ActionEvent e) {
        // TODO add your code here
        System.exit(0);
    }

    private void menultemSystemInformationActionPerformed(ActionEvent e) {
        // TODO add your code here
        Main.setVisible(false);
        SystemInfirmation.setVisible(true);
        SeeInformation.setVisible(false);
        ModifyInformation.setVisible(false);
        SeeBooks.setVisible(false);
        BorrowBooks.setVisible(false);
        ReturnBooks.setVisible(false);
    }

    private void menuItemSeeInformationActionPerformed(ActionEvent e, String uid) {
        // TODO add your code here
        Main.setVisible(false);
        SystemInfirmation.setVisible(false);
        SeeInformation.setVisible(true);
        ModifyInformation.setVisible(false);
        SeeBooks.setVisible(false);
        BorrowBooks.setVisible(false);
        ReturnBooks.setVisible(false);
        Users users = Select.serchuser(uid);
        SeeIdText.setText(users.getU_id());
        SeeNameText.setText(users.getU_name());
    }

    private void menuItemModifyInformationActionPerformed(ActionEvent e, String uid) {
        // TODO add your code here
        Main.setVisible(false);
        SystemInfirmation.setVisible(false);
        SeeInformation.setVisible(false);
        ModifyInformation.setVisible(true);
        SeeBooks.setVisible(false);
        BorrowBooks.setVisible(false);
        ReturnBooks.setVisible(false);
        oldU_id=uid;
        Users users = Select.serchuser(uid);
        ModifyIdText.setText(users.getU_id());
        ModifyNameText.setText(users.getU_name());
    }

    private void ModifymodifyButtonActionPerformed(ActionEvent e) {
        // TODO add your code here
        String uid = ModifyIdText.getText();
        String uname = ModifyNameText.getText();
        String upassword = String.valueOf(ModifyPasswordText.getPassword());
        if (uid.isEmpty()) {
            JOptionPane.showMessageDialog(null, "用户id不能为空");
            return;
        }
        if (uname.isEmpty()) {
            JOptionPane.showMessageDialog(null, "用户名不能为空");
            return;
        }
        if (upassword.isEmpty()) {
            JOptionPane.showMessageDialog(null, "密码不能为空");
            return;
        }
        if (Update.updateUsers(uid, uname, upassword,oldU_id)) {
            JOptionPane.showMessageDialog(null, "修改成功");
        } else {
            JOptionPane.showMessageDialog(null, "修改失败");
        }
    }

    private void menuItemSeeBookActionPerformed(ActionEvent e) {
        // TODO add your code here
        Main.setVisible(false);
        SystemInfirmation.setVisible(false);
        SeeInformation.setVisible(false);
        ModifyInformation.setVisible(false);
        SeeBooks.setVisible(true);
        BorrowBooks.setVisible(false);
        ReturnBooks.setVisible(false);
        List<Bookcategory> list = new ArrayList<Bookcategory>();
        list = Select.serchbookcategorys();
        SeeBookBkNamecomboBox.addItem("-请选择-");
        for (int i = 0; i < list.size(); i++) {
            String bk_name = list.get(i).getBk_name();
            SeeBookBkNamecomboBox.addItem(bk_name);
        }
        bdata = new Object[0][bhead.length];
        DefaultTableModel tableModelSeeBooks = new DefaultTableModel(bdata, bhead);
        tableSeeBooks.setModel(tableModelSeeBooks);
        bdata = null;
    }

    private void SeeBookSeeButtonActionPerformed(ActionEvent e) {
        // TODO add your code here
        String b_name = SeeBookNameText.getText();
        String b_author = SeeBookAothorText.getText();
        String bk_name = (String) SeeBookBkNamecomboBox.getSelectedItem();
        List<Books> list = new ArrayList<Books>();
        if (b_name.isEmpty() && b_author.isEmpty() && bk_name.equals("-请选择-")) {
            list = Select.serchBooks(firthPage,rowsPage);
        } else if (!b_name.isEmpty() && b_author.isEmpty() && bk_name.equals("-请选择-")) {
            list = Select.serchBooksForName(b_name,firthPage,rowsPage);
        } else if (b_name.isEmpty() && !b_author.isEmpty() && bk_name.equals("-请选择-")) {
            list = Select.serchBooksForauthor(b_author,firthPage,rowsPage);
        } else if (b_name.isEmpty() && b_author.isEmpty() && !bk_name.equals("-请选择-")) {
            String bk_id = Select.serchbk_id(bk_name);
            list = Select.serchBooksForBkid(bk_id,firthPage,rowsPage);
        } else if (!b_name.isEmpty() && !b_author.isEmpty() && bk_name.equals("-请选择-")) {
            list = Select.serchBooksForNameAndAuthor(b_name, b_author,firthPage,rowsPage);
        } else if (!b_name.isEmpty() && b_author.isEmpty() && !bk_name.equals("-请选择-")) {
            String bk_id = Select.serchbk_id(bk_name);
            list = Select.serchBooksForNameAndBkid(b_name, bk_id,firthPage,rowsPage);
        } else if (b_name.isEmpty() && !b_author.isEmpty() && !bk_name.equals("-请选择-")) {
            String bk_id = Select.serchbk_id(bk_name);
            list = Select.serchBooksForAuthorAndBkid(b_author, bk_id,firthPage,rowsPage);
        } else {
            String bk_id = Select.serchbk_id(bk_name);
            list = Select.serchBooks(b_name, b_author, bk_id,firthPage,rowsPage);
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
        DefaultTableModel tableModelSeeBooks = new DefaultTableModel(bdata, bhead);
        tableSeeBooks.setModel(tableModelSeeBooks);
        bdata = null;
        currentPage=firthPage;
        SeeBookCurrentPagespinner.setValue(currentPage);
        totalPage=Select.totalPage;
        SeeBooktotalPageText.setText(String.valueOf(totalPage));
    }

    private void SeeBookJumpButtonActionPerformed(ActionEvent e) {
        // TODO add your code here
    }

    private void SeeBookCurrentPagespinnerStateChanged(ChangeEvent e) {
        // TODO add your code here
        currentPage=Integer.parseInt(String.valueOf(SeeBookCurrentPagespinner.getValue()));
        if(currentPage>=1&&currentPage<=totalPage) {
            String b_name = SeeBookNameText.getText();
            String b_author = SeeBookAothorText.getText();
            String bk_name = (String) SeeBookBkNamecomboBox.getSelectedItem();
            List<Books> list = new ArrayList<Books>();
            if (b_name.isEmpty() && b_author.isEmpty() && bk_name.equals("-请选择-")) {
                list = Select.serchBooks(currentPage, rowsPage);
            } else if (!b_name.isEmpty() && b_author.isEmpty() && bk_name.equals("-请选择-")) {
                list = Select.serchBooksForName(b_name, currentPage, rowsPage);
            } else if (b_name.isEmpty() && !b_author.isEmpty() && bk_name.equals("-请选择-")) {
                list = Select.serchBooksForauthor(b_author, currentPage, rowsPage);
            } else if (b_name.isEmpty() && b_author.isEmpty() && !bk_name.equals("-请选择-")) {
                String bk_id = Select.serchbk_id(bk_name);
                list = Select.serchBooksForBkid(bk_id, currentPage, rowsPage);
            } else if (!b_name.isEmpty() && !b_author.isEmpty() && bk_name.equals("-请选择-")) {
                list = Select.serchBooksForNameAndAuthor(b_name, b_author, currentPage, rowsPage);
            } else if (!b_name.isEmpty() && b_author.isEmpty() && !bk_name.equals("-请选择-")) {
                String bk_id = Select.serchbk_id(bk_name);
                list = Select.serchBooksForNameAndBkid(b_name, bk_id, currentPage, rowsPage);
            } else if (b_name.isEmpty() && !b_author.isEmpty() && !bk_name.equals("-请选择-")) {
                String bk_id = Select.serchbk_id(bk_name);
                list = Select.serchBooksForAuthorAndBkid(b_author, bk_id, currentPage, rowsPage);
            } else {
                String bk_id = Select.serchbk_id(bk_name);
                list = Select.serchBooks(b_name, b_author, bk_id, currentPage, rowsPage);
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
                String bk_id[] = new String[list.size()];
                for (int i = 0; i < list.size(); i++) {
                    bk_id[i] = list.get(i).getBk_id();
                }
                List<String> bk_nameList = Select.serchBk_name(bk_id);
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
            DefaultTableModel tableModelSeeBooks = new DefaultTableModel(bdata, bhead);
            tableSeeBooks.setModel(tableModelSeeBooks);
            bdata = null;
        }else {
            JOptionPane.showMessageDialog(null,"超出范围");
        }
    }

    private void menuItemBorrowBookActionPerformed(ActionEvent e) {
        // TODO add your code here
        Main.setVisible(false);
        SystemInfirmation.setVisible(false);
        SeeInformation.setVisible(false);
        ModifyInformation.setVisible(false);
        SeeBooks.setVisible(false);
        BorrowBooks.setVisible(true);
        ReturnBooks.setVisible(false);
        List<Bookcategory> list = new ArrayList<Bookcategory>();
        list = Select.serchbookcategorys();
        BorrowBookBkNamecomboBox.addItem("-请选择-");
        for (int i = 0; i < list.size(); i++) {
            String bk_name = list.get(i).getBk_name();
            BorrowBookBkNamecomboBox.addItem(bk_name);
        }
    }

    private void BorrowBookSeeButtonActionPerformed(ActionEvent e) {
        // TODO add your code here
        String b_name = BorrowBookNameText.getText();
        String b_author = BorrowBookAothorText.getText();
        String bk_name = (String) BorrowBookBkNamecomboBox.getSelectedItem();
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
        DefaultTableModel tableModelBorrowBooks = new DefaultTableModel(bdata, bhead);
        BorrowBooktable.setModel(tableModelBorrowBooks);
        bdata = null;
    }

    private void BorrowBookBorrowButtonActionPerformed(ActionEvent e, String uid) {
        // TODO add your code here
        Borrows borrows = new Borrows();
        String br_id = CreateUUID.createID();
        int count = BorrowBooktable.getSelectedRow();//获取你选中的行号（记录）
        String b_id = BorrowBooktable.getValueAt(count, 0).toString();//读取你获取行号的某一列的值（也就是字段）
        borrows.setBr_id(br_id);
        borrows.setB_id(b_id);
        borrows.setU_id(uid);
        if (Insert.InsertBorrows(borrows)) {
            if (Update.updateBrBooks(borrows.getB_id())) {
                JOptionPane.showMessageDialog(null, "借书成功");
            } else {
                JOptionPane.showMessageDialog(null, "借书失败");
            }
        } else {
            JOptionPane.showMessageDialog(null, "借书失败");
        }
    }

    private void menuItemReturnBookActionPerformed(ActionEvent e, String uid) {
        // TODO add your code here
        Main.setVisible(false);
        SystemInfirmation.setVisible(false);
        SeeInformation.setVisible(false);
        ModifyInformation.setVisible(false);
        SeeBooks.setVisible(false);
        BorrowBooks.setVisible(false);
        ReturnBooks.setVisible(true);
        List<Borrows> list = Select.serchBoroows(uid);
        int j = 0;
        for (int i = 0; i < list.size(); i++) {
            if (list.get(i).getRe_date() == null) {
                j++;
            }
        }
        brdata = new Object[j][brhead.length];
        int flag = 0;
        String b_id[]=new String[j];
        int m=0;
        for (int i = 0; i < list.size(); i++) {
            if (list.get(i).getRe_date() == null) {
                b_id[m++]=list.get(i).getB_id();
            }
        }
        m=0;
        List<String> bnameList=Select.serchB_name(b_id);
        for (int i = 0; i < list.size(); i++) {
            if (list.get(i).getRe_date() == null) {
                brdata[flag][0] = list.get(i).getBr_id();
                brdata[flag][1] = bnameList.get(m++);
                brdata[flag][2] = list.get(i).getBr_date();
                brdata[flag++][3] = list.get(i).getRe_date();
            }
        }
        DefaultTableModel tableModelReturnBooks = new DefaultTableModel(brdata, brhead);
        ReturnBooktable.setModel(tableModelReturnBooks);
        brdata = null;
    }

    private void returnBookReturnbuttonActionPerformed(ActionEvent e) {
        // TODO add your code here
        String br_id;
        int count = ReturnBooktable.getSelectedRow();//获取你选中的行号（记录）
        br_id = ReturnBooktable.getValueAt(count, 0).toString();//读取你获取行号的某一列的值（也就是字段）
        Borrows borrows = Select.serchBoroowsForBrid(br_id);
        if (borrows.getRe_date() == null) {
            if (Update.updateBorrows(br_id)) {
                if (Update.updateReBooks(borrows.getB_id())) {
                    JOptionPane.showMessageDialog(null, "还书成功");
                } else {
                    JOptionPane.showMessageDialog(null, "还书失败");
                }
            } else {
                JOptionPane.showMessageDialog(null, "还书失败");
            }
        } else {
            JOptionPane.showMessageDialog(null, "图书已经归还");
        }

    }

    private void ReturnBookSeeHistorybuttonActionPerformed(ActionEvent e, String uid) {
        // TODO add your code here
        List<Borrows> list = Select.serchBoroows(uid);
        int j = 0;
        for (int i = 0; i < list.size(); i++) {
            if (list.get(i).getRe_date() != null) {
                j++;
            }
        }
        brdata = new Object[j][brhead.length];
        int flag = 0;
        String b_id[]=new String[j];
        int m=0;
        for (int i = 0; i < list.size(); i++) {
            if (list.get(i).getRe_date() != null) {
                b_id[m++]=list.get(i).getB_id();
            }
        }
        m=0;
        List<String> bnameList=Select.serchB_name(b_id);
        for (int i = 0; i < list.size(); i++) {
            if (list.get(i).getRe_date() != null) {
                brdata[flag][0] = list.get(i).getBr_id();
                brdata[flag][1] = bnameList.get(m++);
                brdata[flag][2] = list.get(i).getBr_date();
                brdata[flag++][3] = list.get(i).getRe_date();
            }
        }
        DefaultTableModel tableModelReturnBooks = new DefaultTableModel(brdata, brhead);
        ReturnBooktable.setModel(tableModelReturnBooks);
        brdata = null;
    }

    private void initComponents(final String uid) {
        setTitle("欢迎 " + Select.serchuser(uid).getU_name() + " 使用本图书管理系统");
        // JFormDesigner - Component initialization - DO NOT MODIFY  //GEN-BEGIN:initComponents
        menuBar1 = new JMenuBar();
        menu1 = new JMenu();
        menuItemSeeBook = new JMenuItem();
        menuItemBorrowBook = new JMenuItem();
        menuItemReturnBook = new JMenuItem();
        menuItemExitSafely = new JMenuItem();
        menu2 = new JMenu();
        menuItemSeeInformation = new JMenuItem();
        menuItemModifyInformation = new JMenuItem();
        menu3 = new JMenu();
        menultemSystemInformation = new JMenuItem();
        SystemInfirmation = new JPanel();
        label1 = new JLabel();
        label2 = new JLabel();
        SeeInformation = new JPanel();
        SeeIdlabel = new JLabel();
        SeeNamelabel = new JLabel();
        SeeIdText = new JTextField();
        SeeNameText = new JTextField();
        ModifyInformation = new JPanel();
        ModifyIdlabel = new JLabel();
        ModifyNamelabel = new JLabel();
        ModifyPasswordlabel = new JLabel();
        ModifyIdText = new JTextField();
        ModifyNameText = new JTextField();
        ModifyPasswordText = new JPasswordField();
        ModifymodifyButton = new JButton();
        SeeBooks = new JPanel();
        SeeBooklabel = new JLabel();
        scrollPaneSeeBooks = new JScrollPane();
        tableSeeBooks = new JTable();
        SeeBookNamelabel = new JLabel();
        SeeBookNameText = new JTextField();
        SeeBookAuthorlabel = new JLabel();
        SeeBookAothorText = new JTextField();
        SeeBookBkNamecomboBox = new JComboBox();
        SeeBookBkNamelabel = new JLabel();
        SeeBookSeeButton = new JButton();
        SeeBooktotalPagelabel = new JLabel();
        SeeBooktotalPageText = new JTextField();
        SeeBookCurrentPagespinner = new JSpinner();
        SeeBookJumpButton = new JButton();
        BorrowBooks = new JPanel();
        BorrowBooklabel = new JLabel();
        BorrowBookSeeButton = new JButton();
        BorrowBookBkNamelabel = new JLabel();
        BorrowBookBkNamecomboBox = new JComboBox();
        BorrowBookAothorText = new JTextField();
        BorrowBookAuthorlabel = new JLabel();
        BorrowBookNameText = new JTextField();
        BorrowBookNamelabel = new JLabel();
        BorrowBookscrollPane = new JScrollPane();
        BorrowBooktable = new JTable();
        BorrowBookBorrowButton = new JButton();
        ReturnBooks = new JPanel();
        ReturnBooklabel = new JLabel();
        ReturnBookscrollPane = new JScrollPane();
        ReturnBooktable = new JTable();
        returnBookReturnbutton = new JButton();
        ReturnBookSeeHistorybutton = new JButton();
        Main = new JPanel();
        Mainlabel = new JLabel();

        //======== this ========
        Container contentPane = getContentPane();
        contentPane.setLayout(null);

        //======== menuBar1 ========
        {

            //======== menu1 ========
            {
                menu1.setText("\u56fe\u4e66\u64cd\u4f5c");

                //---- menuItemSeeBook ----
                menuItemSeeBook.setText("\u67e5\u770b\u56fe\u4e66");
                menuItemSeeBook.addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        menuItemSeeBookActionPerformed(e);
                    }
                });
                menu1.add(menuItemSeeBook);

                //---- menuItemBorrowBook ----
                menuItemBorrowBook.setText("\u501f\u4e66");
                menuItemBorrowBook.addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        menuItemBorrowBookActionPerformed(e);
                    }
                });
                menu1.add(menuItemBorrowBook);

                //---- menuItemReturnBook ----
                menuItemReturnBook.setText("\u8fd8\u4e66");
                menuItemReturnBook.addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        menuItemReturnBookActionPerformed(e, uid);
                    }
                });
                menu1.add(menuItemReturnBook);
                menu1.addSeparator();

                //---- menuItemExitSafely ----
                menuItemExitSafely.setText("\u5b89\u5168\u9000\u51fa");
                menuItemExitSafely.addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        menuItem4ActionPerformed(e);
                    }
                });
                menu1.add(menuItemExitSafely);
            }
            menuBar1.add(menu1);

            //======== menu2 ========
            {
                menu2.setText("\u4e2a\u4eba\u4fe1\u606f\u7ba1\u7406");

                //---- menuItemSeeInformation ----
                menuItemSeeInformation.setText("\u67e5\u770b\u4fe1\u606f");
                menuItemSeeInformation.addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        menuItemSeeInformationActionPerformed(e, uid);
                    }
                });
                menu2.add(menuItemSeeInformation);

                //---- menuItemModifyInformation ----
                menuItemModifyInformation.setText("\u4fee\u6539\u4fe1\u606f");
                menuItemModifyInformation.addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        menuItemModifyInformationActionPerformed(e, uid);
                    }
                });
                menu2.add(menuItemModifyInformation);
            }
            menuBar1.add(menu2);

            //======== menu3 ========
            {
                menu3.setText("\u5173\u4e8e");

                //---- menultemSystemInformation ----
                menultemSystemInformation.setText("\u7cfb\u7edf\u4fe1\u606f");
                menultemSystemInformation.addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        menultemSystemInformationActionPerformed(e);
                    }
                });
                menu3.add(menultemSystemInformation);
            }
            menuBar1.add(menu3);
        }
        setJMenuBar(menuBar1);

        //======== SystemInfirmation ========
        {
            SystemInfirmation.setLayout(null);

            //---- label1 ----
            label1.setText("\u56fe\u4e66\u7ba1\u7406\u7cfb\u7edf  1.0");
            label1.setFont(label1.getFont().deriveFont(label1.getFont().getStyle() | Font.ITALIC, label1.getFont().getSize() + 10f));
            SystemInfirmation.add(label1);
            label1.setBounds(70, 70, 355, 70);

            //---- label2 ----
            label2.setText("2121\u5e745\u670812\u65e5   \u9ece\u5408\u714c");
            label2.setFont(label2.getFont().deriveFont(label2.getFont().getSize() + 10f));
            SystemInfirmation.add(label2);
            label2.setBounds(70, 175, 355, 60);
        }
        contentPane.add(SystemInfirmation);
        SystemInfirmation.setBounds(35, 20, 670, 450);

        //======== SeeInformation ========
        {
            SeeInformation.setLayout(null);

            //---- SeeIdlabel ----
            SeeIdlabel.setText("\u7528\u6237id\uff1a");
            SeeInformation.add(SeeIdlabel);
            SeeIdlabel.setBounds(60, 60, 55, 30);

            //---- SeeNamelabel ----
            SeeNamelabel.setText("\u7528\u6237\u540d\uff1a");
            SeeInformation.add(SeeNamelabel);
            SeeNamelabel.setBounds(60, 140, 55, 40);
            SeeInformation.add(SeeIdText);
            SeeIdText.setBounds(160, 60, 120, 30);
            SeeInformation.add(SeeNameText);
            SeeNameText.setBounds(160, 150, 120, 30);
        }
        contentPane.add(SeeInformation);
        SeeInformation.setBounds(35, 30, 670, 450);

        //======== ModifyInformation ========
        {
            ModifyInformation.setLayout(null);

            //---- ModifyIdlabel ----
            ModifyIdlabel.setText("\u7528\u6237id:");
            ModifyInformation.add(ModifyIdlabel);
            ModifyIdlabel.setBounds(60, 55, 55, 30);

            //---- ModifyNamelabel ----
            ModifyNamelabel.setText("\u7528\u6237\u540d\uff1a");
            ModifyInformation.add(ModifyNamelabel);
            ModifyNamelabel.setBounds(60, 110, 65, 30);

            //---- ModifyPasswordlabel ----
            ModifyPasswordlabel.setText("\u5bc6\u7801\uff1a");
            ModifyInformation.add(ModifyPasswordlabel);
            ModifyPasswordlabel.setBounds(60, 160, 65, 30);
            ModifyInformation.add(ModifyIdText);
            ModifyIdText.setBounds(160, 60, 120, 30);
            ModifyInformation.add(ModifyNameText);
            ModifyNameText.setBounds(160, 110, 120, 30);
            ModifyInformation.add(ModifyPasswordText);
            ModifyPasswordText.setBounds(160, 165, 120, 30);

            //---- ModifymodifyButton ----
            ModifymodifyButton.setText("\u4fee\u6539");
            ModifymodifyButton.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    ModifymodifyButtonActionPerformed(e);
                }
            });
            ModifyInformation.add(ModifymodifyButton);
            ModifymodifyButton.setBounds(100, 235, 105, 30);
        }
        contentPane.add(ModifyInformation);
        ModifyInformation.setBounds(35, 25, 670, 450);

        //======== SeeBooks ========
        {
            SeeBooks.setLayout(null);

            //---- SeeBooklabel ----
            SeeBooklabel.setText("\u67e5\u770b\u56fe\u4e66");
            SeeBooks.add(SeeBooklabel);
            SeeBooklabel.setBounds(275, 10, 60, 25);

            //======== scrollPaneSeeBooks ========
            {
                scrollPaneSeeBooks.setViewportView(tableSeeBooks);
            }
            SeeBooks.add(scrollPaneSeeBooks);
            scrollPaneSeeBooks.setBounds(15, 40, 600, 320);

            //---- SeeBookNamelabel ----
            SeeBookNamelabel.setText("\u56fe\u4e66\u540d\u5b57\uff1a");
            SeeBooks.add(SeeBookNamelabel);
            SeeBookNamelabel.setBounds(new Rectangle(new Point(25, 385), SeeBookNamelabel.getPreferredSize()));
            SeeBooks.add(SeeBookNameText);
            SeeBookNameText.setBounds(90, 380, 95, SeeBookNameText.getPreferredSize().height);

            //---- SeeBookAuthorlabel ----
            SeeBookAuthorlabel.setText("\u4f5c\u8005\uff1a");
            SeeBooks.add(SeeBookAuthorlabel);
            SeeBookAuthorlabel.setBounds(205, 385, 40, 20);
            SeeBooks.add(SeeBookAothorText);
            SeeBookAothorText.setBounds(255, 380, 80, SeeBookAothorText.getPreferredSize().height);
            SeeBooks.add(SeeBookBkNamecomboBox);
            SeeBookBkNamecomboBox.setBounds(430, 380, 120, SeeBookBkNamecomboBox.getPreferredSize().height);

            //---- SeeBookBkNamelabel ----
            SeeBookBkNamelabel.setText("\u56fe\u4e66\u7c7b\u522b\uff1a");
            SeeBooks.add(SeeBookBkNamelabel);
            SeeBookBkNamelabel.setBounds(360, 385, 65, 25);

            //---- SeeBookSeeButton ----
            SeeBookSeeButton.setText("\u67e5\u8be2");
            SeeBookSeeButton.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    SeeBookSeeButtonActionPerformed(e);
                }
            });
            SeeBooks.add(SeeBookSeeButton);
            SeeBookSeeButton.setBounds(new Rectangle(new Point(560, 380), SeeBookSeeButton.getPreferredSize()));

            //---- SeeBooktotalPagelabel ----
            SeeBooktotalPagelabel.setText("\u603b\u9875\u6570\uff1a");
            SeeBooks.add(SeeBooktotalPagelabel);
            SeeBooktotalPagelabel.setBounds(new Rectangle(new Point(350, 10), SeeBooktotalPagelabel.getPreferredSize()));
            SeeBooks.add(SeeBooktotalPageText);
            SeeBooktotalPageText.setBounds(410, 10, 40, SeeBooktotalPageText.getPreferredSize().height);

            //---- SeeBookCurrentPagespinner ----
            SeeBookCurrentPagespinner.setValue(1);
            SeeBookCurrentPagespinner.addChangeListener(new ChangeListener() {
                @Override
                public void stateChanged(ChangeEvent e) {
                    SeeBookCurrentPagespinnerStateChanged(e);
                }
            });
            SeeBooks.add(SeeBookCurrentPagespinner);
            SeeBookCurrentPagespinner.setBounds(480, 10, 70, SeeBookCurrentPagespinner.getPreferredSize().height);

            //---- SeeBookJumpButton ----
            SeeBookJumpButton.setText("\u8df3\u8f6c");
            SeeBookJumpButton.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    SeeBookJumpButtonActionPerformed(e);
                }
            });
            SeeBooks.add(SeeBookJumpButton);
            SeeBookJumpButton.setBounds(new Rectangle(new Point(560, 10), SeeBookJumpButton.getPreferredSize()));
        }
        contentPane.add(SeeBooks);
        SeeBooks.setBounds(30, 25, 670, 450);

        //======== BorrowBooks ========
        {
            BorrowBooks.setLayout(null);

            //---- BorrowBooklabel ----
            BorrowBooklabel.setText("\u501f\u4e66");
            BorrowBooks.add(BorrowBooklabel);
            BorrowBooklabel.setBounds(295, 10, 45, 30);

            //---- BorrowBookSeeButton ----
            BorrowBookSeeButton.setText("\u67e5\u8be2");
            BorrowBookSeeButton.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    BorrowBookSeeButtonActionPerformed(e);
                }
            });
            BorrowBooks.add(BorrowBookSeeButton);
            BorrowBookSeeButton.setBounds(540, 45, 65, 23);

            //---- BorrowBookBkNamelabel ----
            BorrowBookBkNamelabel.setText("\u56fe\u4e66\u7c7b\u522b\uff1a");
            BorrowBooks.add(BorrowBookBkNamelabel);
            BorrowBookBkNamelabel.setBounds(340, 50, 65, 25);
            BorrowBooks.add(BorrowBookBkNamecomboBox);
            BorrowBookBkNamecomboBox.setBounds(410, 45, 120, 21);
            BorrowBooks.add(BorrowBookAothorText);
            BorrowBookAothorText.setBounds(235, 45, 80, 21);

            //---- BorrowBookAuthorlabel ----
            BorrowBookAuthorlabel.setText("\u4f5c\u8005\uff1a");
            BorrowBooks.add(BorrowBookAuthorlabel);
            BorrowBookAuthorlabel.setBounds(185, 50, 40, 20);
            BorrowBooks.add(BorrowBookNameText);
            BorrowBookNameText.setBounds(70, 45, 95, 21);

            //---- BorrowBookNamelabel ----
            BorrowBookNamelabel.setText("\u56fe\u4e66\u540d\u5b57\uff1a");
            BorrowBooks.add(BorrowBookNamelabel);
            BorrowBookNamelabel.setBounds(5, 50, 70, 15);

            //======== BorrowBookscrollPane ========
            {
                BorrowBookscrollPane.setViewportView(BorrowBooktable);
            }
            BorrowBooks.add(BorrowBookscrollPane);
            BorrowBookscrollPane.setBounds(15, 75, 595, 230);

            //---- BorrowBookBorrowButton ----
            BorrowBookBorrowButton.setText("\u501f\u4e66");
            BorrowBookBorrowButton.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    BorrowBookBorrowButtonActionPerformed(e, uid);
                }
            });
            BorrowBooks.add(BorrowBookBorrowButton);
            BorrowBookBorrowButton.setBounds(new Rectangle(new Point(290, 320), BorrowBookBorrowButton.getPreferredSize()));
        }
        contentPane.add(BorrowBooks);
        BorrowBooks.setBounds(25, 25, 670, 450);

        //======== ReturnBooks ========
        {
            ReturnBooks.setLayout(null);

            //---- ReturnBooklabel ----
            ReturnBooklabel.setText("\u5f52\u8fd8\u56fe\u4e66");
            ReturnBooks.add(ReturnBooklabel);
            ReturnBooklabel.setBounds(280, 10, 115, 30);

            //======== ReturnBookscrollPane ========
            {
                ReturnBookscrollPane.setViewportView(ReturnBooktable);
            }
            ReturnBooks.add(ReturnBookscrollPane);
            ReturnBookscrollPane.setBounds(40, 45, 535, 205);

            //---- returnBookReturnbutton ----
            returnBookReturnbutton.setText("\u5f52\u8fd8\u56fe\u4e66");
            returnBookReturnbutton.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    returnBookReturnbuttonActionPerformed(e);
                }
            });
            ReturnBooks.add(returnBookReturnbutton);
            returnBookReturnbutton.setBounds(new Rectangle(new Point(350, 255), returnBookReturnbutton.getPreferredSize()));

            //---- ReturnBookSeeHistorybutton ----
            ReturnBookSeeHistorybutton.setText("查看历史记录");
            ReturnBookSeeHistorybutton.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    ReturnBookSeeHistorybuttonActionPerformed(e, uid);
                }
            });
            ReturnBooks.add(ReturnBookSeeHistorybutton);
            ReturnBookSeeHistorybutton.setBounds(new Rectangle(new Point(150, 255), ReturnBookSeeHistorybutton.getPreferredSize()));
        }
        contentPane.add(ReturnBooks);
        ReturnBooks.setBounds(35, 25, 670, 450);

        //======== Main ========
        {
            Main.setLayout(null);

            {
                // compute preferred size
                Dimension preferredSize = new Dimension();
                for (int i = 0; i < Main.getComponentCount(); i++) {
                    Rectangle bounds = Main.getComponent(i).getBounds();
                    preferredSize.width = Math.max(bounds.x + bounds.width, preferredSize.width);
                    preferredSize.height = Math.max(bounds.y + bounds.height, preferredSize.height);
                }
                Insets insets = Main.getInsets();
                preferredSize.width += insets.right;
                preferredSize.height += insets.bottom;
                Main.setMinimumSize(preferredSize);
                Main.setPreferredSize(preferredSize);
            }
        }
        contentPane.add(Main);
        Main.setBounds(new Rectangle(new Point(200, 200), Main.getPreferredSize()));

        //---- Mainlabel ----
        Mainlabel.setText("\u6b22\u8fce\u4f7f\u7528\u56fe\u4e66\u7ba1\u7406\u7cfb\u7edf\uff01");
        Mainlabel.setFont(Mainlabel.getFont().deriveFont(Mainlabel.getFont().getSize() + 10f));
        contentPane.add(Mainlabel);
        Mainlabel.setBounds(200, 100, 400, 195);

        contentPane.setPreferredSize(new Dimension(740, 515));
        pack();
        setLocationRelativeTo(getOwner());
        // JFormDesigner - End of component initialization  //GEN-END:initComponents
        Main.setVisible(true);
        SystemInfirmation.setVisible(false);
        SeeInformation.setVisible(false);
        ModifyInformation.setVisible(false);
        SeeBooks.setVisible(false);
        BorrowBooks.setVisible(false);
        ReturnBooks.setVisible(false);

    }

    // JFormDesigner - Variables declaration - DO NOT MODIFY  //GEN-BEGIN:variables
    private JMenuBar menuBar1;
    private JMenu menu1;
    private JMenuItem menuItemSeeBook;
    private JMenuItem menuItemBorrowBook;
    private JMenuItem menuItemReturnBook;
    private JMenuItem menuItemExitSafely;
    private JMenu menu2;
    private JMenuItem menuItemSeeInformation;
    private JMenuItem menuItemModifyInformation;
    private JMenu menu3;
    private JMenuItem menultemSystemInformation;
    private JPanel SystemInfirmation;
    private JLabel label1;
    private JLabel label2;
    private JPanel SeeInformation;
    private JLabel SeeIdlabel;
    private JLabel SeeNamelabel;
    private JTextField SeeIdText;
    private JTextField SeeNameText;
    private JPanel ModifyInformation;
    private JLabel ModifyIdlabel;
    private JLabel ModifyNamelabel;
    private JLabel ModifyPasswordlabel;
    private JTextField ModifyIdText;
    private JTextField ModifyNameText;
    private JPasswordField ModifyPasswordText;
    private JButton ModifymodifyButton;
    private JPanel SeeBooks;
    private JLabel SeeBooklabel;
    private JScrollPane scrollPaneSeeBooks;
    private JTable tableSeeBooks;
    private JLabel SeeBookNamelabel;
    private JTextField SeeBookNameText;
    private JLabel SeeBookAuthorlabel;
    private JTextField SeeBookAothorText;
    private JComboBox SeeBookBkNamecomboBox;
    private JLabel SeeBookBkNamelabel;
    private JButton SeeBookSeeButton;
    private JLabel SeeBooktotalPagelabel;
    private JTextField SeeBooktotalPageText;
    private JSpinner SeeBookCurrentPagespinner;
    private JButton SeeBookJumpButton;
    private JPanel BorrowBooks;
    private JLabel BorrowBooklabel;
    private JButton BorrowBookSeeButton;
    private JLabel BorrowBookBkNamelabel;
    private JComboBox BorrowBookBkNamecomboBox;
    private JTextField BorrowBookAothorText;
    private JLabel BorrowBookAuthorlabel;
    private JTextField BorrowBookNameText;
    private JLabel BorrowBookNamelabel;
    private JScrollPane BorrowBookscrollPane;
    private JTable BorrowBooktable;
    private JButton BorrowBookBorrowButton;
    private JPanel ReturnBooks;
    private JLabel ReturnBooklabel;
    private JScrollPane ReturnBookscrollPane;
    private JTable ReturnBooktable;
    private JButton returnBookReturnbutton;
    private JButton ReturnBookSeeHistorybutton;
    private JPanel Main;
    private JLabel Mainlabel;
    private Object[][] brdata = null;
    private String brhead[] = {"借书编号", "图书名称", "借书时间", "还书时间"};
    private Object[][] bdata = null;
    private String bhead[] = {"图书编号", "图书名称", "图书类别名称", "图书作者", "价格", "出版社", "数量", "描述"};
    private int firthPage=1;
    private int currentPage=1;
    private int rowsPage=20;
    private int totalPage;
    private String oldU_id;
    // JFormDesigner - End of variables declaration  //GEN-END:variables
}
