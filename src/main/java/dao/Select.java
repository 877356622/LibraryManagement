package dao;

import entity.Administrators;
import entity.Bookcategory;
import entity.Books;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class Select {
    public static List<Books> serchBooks() {
        List<Books> list = new ArrayList<Books>();
        Connection conn = null;
        String url = "jdbc:oracle:thin:@8.129.212.155:1521:orcl";
        PreparedStatement pstmt = null;
        String sql = "SELECT * FROM books";
        ResultSet rs = null;
        try {
            Class.forName("oracle.jdbc.driver.OracleDriver");
            conn = DriverManager.getConnection(url, "lhh", "lhh1234");
            System.out.println("连接: " + conn);
            pstmt = conn.prepareStatement(sql);
            rs = pstmt.executeQuery();
            while (rs.next()) {
                Books book = new Books();
                book.setB_id(rs.getString("b_id"));
                book.setBk_id(rs.getString("bk_id"));
                book.setB_name(rs.getString("b_name"));
                book.setB_desc(rs.getString("b_desc"));
                book.setB_author(rs.getString("b_author"));
                book.setB_price(rs.getDouble("b_price"));
                book.setB_edit(rs.getString("b_edit"));
                book.setB_number(rs.getInt("b_number"));
                list.add(book);
            }
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                rs.close();
                pstmt.close();
                conn.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return list;
    }

    public static String checkuser(String uid, String password) {
        String uname = "";
        Connection conn = null;
        String url = "jdbc:oracle:thin:@8.129.212.155:1521:orcl";
        PreparedStatement pstmt = null;
        String sql = "SELECT * FROM users WHERE u_id=?";
        ResultSet rs = null;
        try {
            Class.forName("oracle.jdbc.driver.OracleDriver");
            conn = DriverManager.getConnection(url, "lhh", "lhh1234");
            System.out.println("连接: " + conn);
            pstmt = conn.prepareStatement(sql);
            pstmt.setString(1, uid);
            rs = pstmt.executeQuery();
            if (rs.next()) {
                if (password.equals(rs.getString("u_id"))) {
                    uname = rs.getNString("u_name");
                    return uname;
                }
            }
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                rs.close();
                pstmt.close();
                conn.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return uname;
    }

    public static String checkadms(String aid, String apassword) {
        String aname = "";
        Connection conn = null;
        String url = "jdbc:oracle:thin:@8.129.212.155:1521:orcl";
        PreparedStatement pstmt = null;
        String sql = "SELECT * FROM administrators WHERE a_id=?";
        ResultSet rs = null;
        try {
            Class.forName("oracle.jdbc.driver.OracleDriver");
            conn = DriverManager.getConnection(url, "lhh", "lhh1234");
            System.out.println("连接: " + conn);
            pstmt = conn.prepareStatement(sql);
            pstmt.setString(1, aid);
            rs = pstmt.executeQuery();
            if (rs.next()) {
                if (apassword.equals(rs.getString("a_password"))) {
                    aname = rs.getString("a_name");
                    return aname;
                }
            }
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                rs.close();
                pstmt.close();
                conn.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return aname;
    }

    public static Administrators serchadms(String aid){
        Administrators administrators=new Administrators();
        Connection conn = null;
        String url = "jdbc:oracle:thin:@8.129.212.155:1521:orcl";
        PreparedStatement pstmt = null;
        String sql = "SELECT * FROM administrators WHERE a_id=?";
        ResultSet rs = null;
        try {
            Class.forName("oracle.jdbc.driver.OracleDriver");
            conn = DriverManager.getConnection(url, "lhh", "lhh1234");
            System.out.println("连接: " + conn);
            pstmt = conn.prepareStatement(sql);
            pstmt.setString(1, aid);
            rs = pstmt.executeQuery();
            if (rs.next()) {
                administrators.setA_id(rs.getString("a_id"));
                administrators.setA_name(rs.getString("a_name"));
                administrators.setA_password(rs.getString("a_password"));
            }
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                rs.close();
                pstmt.close();
                conn.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return administrators;
    }

    public static List<Bookcategory> serchbookcategorys(){
        List<Bookcategory> list=new ArrayList<Bookcategory>();
        Connection conn = null;
        String url = "jdbc:oracle:thin:@8.129.212.155:1521:orcl";
        PreparedStatement pstmt = null;
        String sql = "SELECT * FROM bookcategory";
        ResultSet rs = null;
        try {
            Class.forName("oracle.jdbc.driver.OracleDriver");
            conn = DriverManager.getConnection(url, "lhh", "lhh1234");
            System.out.println("连接: " + conn);
            pstmt = conn.prepareStatement(sql);
            rs = pstmt.executeQuery();
            while (rs.next()) {
                Bookcategory bookcategory=new Bookcategory();
                bookcategory.setBk_id(rs.getString("bk_id"));
                bookcategory.setBk_name(rs.getString("bk_name"));
                bookcategory.setBk_desc(rs.getString("bk_desc"));
                list.add(bookcategory);
            }
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                rs.close();
                pstmt.close();
                conn.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return list;
    }
    public static List<Bookcategory> serchbookcategorys(int currentPage,int rowsPerPage){
        List<Bookcategory> list=new ArrayList<Bookcategory>();
        Connection conn = null;
        String url = "jdbc:oracle:thin:@8.129.212.155:1521:orcl";
        PreparedStatement pstmt = null;
        String sql = "SELECT * FROM (SELECT rownum rn, b.* FROM bookcategory  b WHERE rownum<=?) WHERE rn>=?";
        ResultSet rs = null;
        try {
            Class.forName("oracle.jdbc.driver.OracleDriver");
            conn = DriverManager.getConnection(url, "lhh", "lhh1234");
            System.out.println("连接: " + conn);
            pstmt = conn.prepareStatement(sql);
            pstmt.setInt(1,currentPage*rowsPerPage);
            pstmt.setInt(2,(currentPage-1)*rowsPerPage+1);
            rs = pstmt.executeQuery();
            while (rs.next()) {
                Bookcategory bookcategory=new Bookcategory();
                bookcategory.setBk_id(rs.getString("bk_id"));
                bookcategory.setBk_name(rs.getString("bk_name"));
                bookcategory.setBk_desc(rs.getString("bk_desc"));
                list.add(bookcategory);
            }
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                rs.close();
                pstmt.close();
                conn.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return list;
    }

    public static List<Bookcategory> serchbookcategorys(String bk_name){
        List<Bookcategory> list=new ArrayList<Bookcategory>();
        Connection conn = null;
        String url = "jdbc:oracle:thin:@8.129.212.155:1521:orcl";
        Statement stmt = null;
        String sql = "SELECT * FROM bookcategory WHERE bk_name LIKE '%"+bk_name+"%'";
        ResultSet rs = null;
        try {
            Class.forName("oracle.jdbc.driver.OracleDriver");
            conn = DriverManager.getConnection(url, "lhh", "lhh1234");
            System.out.println("连接: " + conn);
            stmt = conn.createStatement();
            rs = stmt.executeQuery(sql);
            while (rs.next()) {
                Bookcategory bookcategory=new Bookcategory();
                bookcategory.setBk_id(rs.getString("bk_id"));
                bookcategory.setBk_name(rs.getString("bk_name"));
                bookcategory.setBk_desc(rs.getString("bk_desc"));
                list.add(bookcategory);
            }
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                rs.close();
                stmt.close();
                conn.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return list;
    }

    public static String serchbk_id(Object bk_name){
        String bk_id="";
        Connection conn = null;
        String url = "jdbc:oracle:thin:@8.129.212.155:1521:orcl";
        PreparedStatement pstmt = null;
        String sql = "SELECT * FROM bookcategory WHERE bk_name=?";
        ResultSet rs = null;
        try {
            Class.forName("oracle.jdbc.driver.OracleDriver");
            conn = DriverManager.getConnection(url, "lhh", "lhh1234");
            System.out.println("连接: " + conn);
            pstmt = conn.prepareStatement(sql);
            pstmt.setString(1, String.valueOf(bk_name));
            rs = pstmt.executeQuery();
            if (rs.next()) {
                bk_id=rs.getString("bk_id");
            }
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                rs.close();
                pstmt.close();
                conn.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return bk_id;
    }

    public static Books getBooks(String b_id){
        Books books=new Books();
        Connection conn = null;
        String url = "jdbc:oracle:thin:@8.129.212.155:1521:orcl";
        PreparedStatement pstmt = null;
        String sql = "SELECT * FROM books WHERE b_id=?";
        ResultSet rs = null;
        try {
            Class.forName("oracle.jdbc.driver.OracleDriver");
            conn = DriverManager.getConnection(url, "lhh", "lhh1234");
            System.out.println("连接: " + conn);
            pstmt = conn.prepareStatement(sql);
            pstmt.setString(1,b_id);
            rs = pstmt.executeQuery();
            if (rs.next()) {
                books.setB_id(rs.getString("b_id"));
                books.setB_number(rs.getInt("b_number"));
                books.setBk_id(rs.getString("bk_id"));
                books.setB_desc(rs.getString("b_desc"));
                books.setB_price(rs.getDouble("b_price"));
                books.setB_author(rs.getString("b_author"));
                books.setB_name(rs.getString("b_name"));
                books.setB_edit(rs.getString("b_edit"));
            }
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                rs.close();
                pstmt.close();
                conn.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return books;
    }
}
