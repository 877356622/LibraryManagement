package dao;

import entity.Books;

import java.sql.*;

public class Insert {
    public static boolean registeradmin(String a_id, String a_name, String a_password) {
        boolean flag = true;
        Connection conn = null;
        String url = "jdbc:oracle:thin:@8.129.212.155:1521:orcl";
        PreparedStatement pstmt = null;
        String sql = "INSERT INTO administrators VALUES(?,?,?)";
        try {
            Class.forName("oracle.jdbc.driver.OracleDriver");
            conn = DriverManager.getConnection(url, "lhh", "lhh1234");
            System.out.println("连接: " + conn);
            pstmt = conn.prepareStatement(sql);
            pstmt.setString(1, a_id);
            pstmt.setString(2, a_name);
            pstmt.setString(3, a_password);
            pstmt.execute();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
            flag = false;
        } finally {
            try {
                pstmt.close();
                conn.close();
                return flag;
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return flag;
    }

    public static boolean registeruser(String u_id, String u_name, String u_password) {
        boolean flag = true;
        Connection conn = null;
        String url = "jdbc:oracle:thin:@8.129.212.155:1521:orcl";
        PreparedStatement pstmt = null;
        String sql = "INSERT INTO users VALUES(?,?,?)";
        try {
            Class.forName("oracle.jdbc.driver.OracleDriver");
            conn = DriverManager.getConnection(url, "lhh", "lhh1234");
            System.out.println("连接: " + conn);
            pstmt = conn.prepareStatement(sql);
            pstmt.setString(1, u_id);
            pstmt.setString(2, u_name);
            pstmt.setString(3, u_password);
            pstmt.execute();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
            flag = false;
        } finally {
            try {
                pstmt.close();
                conn.close();
                return flag;
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return flag;
    }

    public static boolean Insertbookcategory(String bk_id, String bk_name, String bk_desc) {
        boolean flag = true;
        Connection conn = null;
        String url = "jdbc:oracle:thin:@8.129.212.155:1521:orcl";
        PreparedStatement pstmt = null;
        String sql = "INSERT INTO bookcategory VALUES(?,?,?)";
        try {
            Class.forName("oracle.jdbc.driver.OracleDriver");
            conn = DriverManager.getConnection(url, "lhh", "lhh1234");
            System.out.println("连接: " + conn);
            pstmt = conn.prepareStatement(sql);
            pstmt.setString(1, bk_id);
            pstmt.setString(2, bk_name);
            pstmt.setString(3, bk_desc);
            pstmt.execute();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
            flag = false;
        } finally {
            try {
                pstmt.close();
                conn.close();
                return flag;
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return flag;
    }

    public static boolean Insertbooks(Books books) {
        boolean flag = true;
        Connection conn = null;
        String url = "jdbc:oracle:thin:@8.129.212.155:1521:orcl";
        PreparedStatement pstmt = null;
        String sql = "INSERT INTO books VALUES(?,?,?,?,?,?,?,?)";
        try {
            Class.forName("oracle.jdbc.driver.OracleDriver");
            conn = DriverManager.getConnection(url, "lhh", "lhh1234");
            System.out.println("连接: " + conn);
            pstmt = conn.prepareStatement(sql);
            pstmt.setString(1, books.getB_id());
            pstmt.setString(2, books.getBk_id());
            pstmt.setString(3, books.getB_name());
            pstmt.setString(4, books.getB_desc());
            pstmt.setString(5, books.getB_author());
            pstmt.setDouble(6, books.getB_price());
            pstmt.setString(7, books.getB_edit());
            pstmt.setInt(8,books.getB_number());
            pstmt.execute();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
            flag = false;
        } finally {
            try {
                pstmt.close();
                conn.close();
                return flag;
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return flag;
    }
}

