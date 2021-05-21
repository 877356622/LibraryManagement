package dao;

import entity.Books;
import entity.Borrows;

import java.sql.*;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Update {
    public static boolean updateAdms(String a_id, String a_name, String a_password,String oldA_id) {
        boolean flag=true;
        Connection conn = null;
        String url = "jdbc:oracle:thin:@8.129.212.155:1521:orcl";
        PreparedStatement pstmt = null;
        String sql = "UPDATE administrators SET a_id=?,a_name=?,a_password=? WHERE a_id=?";
        try {
            Class.forName("oracle.jdbc.driver.OracleDriver");
            conn = DriverManager.getConnection(url, "lhh", "lhh1234");
            System.out.println("连接: " + conn);
            pstmt = conn.prepareStatement(sql);
            pstmt.setString(1,a_id);
            pstmt.setString(2, a_name);
            pstmt.setString(3, a_password);
            pstmt.setString(4, oldA_id);
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

    public static boolean updateBookcategory(String bk_id1, String bk_name, String bk_desc,String bk_id2) {
        boolean flag=true;
        Connection conn = null;
        String url = "jdbc:oracle:thin:@8.129.212.155:1521:orcl";
        PreparedStatement pstmt = null;
        String sql = "UPDATE bookcategory SET bk_id=?,bk_name=?,bk_desc=? WHERE bk_id=?";
        try {
            Class.forName("oracle.jdbc.driver.OracleDriver");
            conn = DriverManager.getConnection(url, "lhh", "lhh1234");
            System.out.println("连接: " + conn);
            pstmt = conn.prepareStatement(sql);
            pstmt.setString(1,bk_id1);
            pstmt.setString(2, bk_name);
            pstmt.setString(3, bk_desc);
            pstmt.setString(4, bk_id2);
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

    public static boolean updateBooks(Books books,String oldB_id) {
        boolean flag=true;
        Connection conn = null;
        String url = "jdbc:oracle:thin:@8.129.212.155:1521:orcl";
        PreparedStatement pstmt = null;
        String sql = "UPDATE books SET b_id=?,b_name=?,b_desc=?,b_edit=?,b_author=?,b_price=?,b_number=? WHERE b_id=?";
        try {
            Class.forName("oracle.jdbc.driver.OracleDriver");
            conn = DriverManager.getConnection(url, "lhh", "lhh1234");
            System.out.println("连接: " + conn);
            pstmt = conn.prepareStatement(sql);
            pstmt.setString(1,books.getB_id());
            pstmt.setString(2, books.getB_name());
            pstmt.setString(3, books.getB_desc());
            pstmt.setString(4, books.getB_edit());
            pstmt.setString(5,books.getB_author());
            pstmt.setDouble(6,books.getB_price());
            pstmt.setInt(7,books.getB_number());
            pstmt.setString(8,oldB_id);
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

    public static boolean updateUsers(String u_id, String u_name, String u_password,String oldU_id) {
        boolean flag=true;
        Connection conn = null;
        String url = "jdbc:oracle:thin:@8.129.212.155:1521:orcl";
        PreparedStatement pstmt = null;
        String sql = "UPDATE users SET u_id=?,u_name=?,u_password=? WHERE u_id=?";
        try {
            Class.forName("oracle.jdbc.driver.OracleDriver");
            conn = DriverManager.getConnection(url, "lhh", "lhh1234");
            System.out.println("连接: " + conn);
            pstmt = conn.prepareStatement(sql);
            pstmt.setString(1,u_id);
            pstmt.setString(2, u_name);
            pstmt.setString(3, u_password);
            pstmt.setString(4, oldU_id);
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

    public static boolean updateBorrows (String br_id) {
        boolean flag=true;
        Connection conn = null;
        String url = "jdbc:oracle:thin:@8.129.212.155:1521:orcl";
        PreparedStatement pstmt = null;
        String sql = "UPDATE borrows SET re_time=? WHERE br_id=?";
        try {
            Class.forName("oracle.jdbc.driver.OracleDriver");
            conn = DriverManager.getConnection(url, "lhh", "lhh1234");
            System.out.println("连接: " + conn);
            pstmt = conn.prepareStatement(sql);
            SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
            String date = sdf.format(new Date());
            String nowDate=date.valueOf(date);
            pstmt.setTimestamp(1, Timestamp.valueOf(nowDate));
            pstmt.setString(2,br_id);
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

    public static boolean updateBrBooks(String b_id) {
        boolean flag=true;
        Connection conn = null;
        String url = "jdbc:oracle:thin:@8.129.212.155:1521:orcl";
        PreparedStatement pstmt = null;
        String sql = "UPDATE books SET b_number=b_number-1 WHERE b_id=?";
        try {
            Class.forName("oracle.jdbc.driver.OracleDriver");
            conn = DriverManager.getConnection(url, "lhh", "lhh1234");
            System.out.println("连接: " + conn);
            pstmt = conn.prepareStatement(sql);
            pstmt.setString(1, b_id);

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

    public static boolean updateReBooks(String b_id) {
        boolean flag=true;
        Connection conn = null;
        String url = "jdbc:oracle:thin:@8.129.212.155:1521:orcl";
        PreparedStatement pstmt = null;
        String sql = "UPDATE books SET b_number=b_number+1 WHERE b_id=?";
        try {
            Class.forName("oracle.jdbc.driver.OracleDriver");
            conn = DriverManager.getConnection(url, "lhh", "lhh1234");
            System.out.println("连接: " + conn);
            pstmt = conn.prepareStatement(sql);
            pstmt.setString(1, b_id);

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
