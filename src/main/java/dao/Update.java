package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class Update {
    public static boolean updateAdms(String a_id, String a_name, String a_password) {
        boolean flag=true;
        Connection conn = null;
        String url = "jdbc:oracle:thin:@8.129.212.155:1521:orcl";
        PreparedStatement pstmt = null;
        String sql = "UPDATE administrators SET a_name=?,a_password=? WHERE a_id=?";
        try {
            Class.forName("oracle.jdbc.driver.OracleDriver");
            conn = DriverManager.getConnection(url, "lhh", "lhh1234");
            System.out.println("连接: " + conn);
            pstmt = conn.prepareStatement(sql);
            pstmt.setString(1, a_name);
            pstmt.setString(2, a_password);
            pstmt.setString(3, a_id);
            pstmt.execute();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
            flag=false;
        } finally {
            try {
                pstmt.close();
                conn.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return flag;
    }

    public static boolean updateBookcategory(String bk_id, String bk_name, String bk_desc) {
        boolean flag=true;
        Connection conn = null;
        String url = "jdbc:oracle:thin:@8.129.212.155:1521:orcl";
        PreparedStatement pstmt = null;
        String sql = "UPDATE bookcategory SET bk_name=?,bk_desc=? WHERE bk_id=?";
        try {
            Class.forName("oracle.jdbc.driver.OracleDriver");
            conn = DriverManager.getConnection(url, "lhh", "lhh1234");
            System.out.println("连接: " + conn);
            pstmt = conn.prepareStatement(sql);
            pstmt.setString(1, bk_name);
            pstmt.setString(2, bk_desc);
            pstmt.setString(3, bk_id);
            pstmt.execute();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
            flag=false;
        } finally {
            try {
                pstmt.close();
                conn.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return flag;
    }
}
