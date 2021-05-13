package dao;

import entity.*;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class Select {

    public static int totalPage;

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

    public static List<Books> serchBooks(int currentPage,int rowsPage) {
        List<Books> list = new ArrayList<Books>();
        Connection conn = null;
        String url = "jdbc:oracle:thin:@8.129.212.155:1521:orcl";
        PreparedStatement pstmt = null;
        String sql = "SELECT * FROM (SELECT rownum rn,b.* FROM books b WHERE rownum<=?) WHERE rn>=?";
        ResultSet rs = null;
        try {
            Class.forName("oracle.jdbc.driver.OracleDriver");
            conn = DriverManager.getConnection(url, "lhh", "lhh1234");
            System.out.println("连接: " + conn);
            pstmt = conn.prepareStatement(sql);
            pstmt.setInt(1,currentPage*rowsPage);
            pstmt.setInt(2,(currentPage-1)*rowsPage+1);
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
            if(currentPage==1) {
                sql = "SELECT COUNT(*) FROM books";
                pstmt = conn.prepareStatement(sql);
                rs = pstmt.executeQuery();
                int totalRows = 0;
                if (rs.next()) {
                    totalRows = rs.getInt(1);
                }
                totalPage = totalRows % rowsPage == 0 ? totalRows / rowsPage : totalRows / rowsPage + 1;
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

    public static List<Books> serchBooksForName(String b_name) {
        List<Books> list = new ArrayList<Books>();
        Connection conn = null;
        String url = "jdbc:oracle:thin:@8.129.212.155:1521:orcl";
        PreparedStatement pstmt = null;
        String sql = "SELECT * FROM books WHERE b_name LIKE ?";
        ResultSet rs = null;
        try {
            Class.forName("oracle.jdbc.driver.OracleDriver");
            conn = DriverManager.getConnection(url, "lhh", "lhh1234");
            System.out.println("连接: " + conn);
            pstmt = conn.prepareStatement(sql);
            pstmt.setString(1,"%"+b_name+"%");
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

    public static List<Books> serchBooksForName(String b_name,int currentPage,int rowsPage) {
        List<Books> list = new ArrayList<Books>();
        Connection conn = null;
        String url = "jdbc:oracle:thin:@8.129.212.155:1521:orcl";
        PreparedStatement pstmt = null;
        String sql = "SELECT * FROM (SELECT rownum rn,b.* FROM books b WHERE b_name LIKE ? AND rownum<=?) WHERE rn>=?";
        ResultSet rs = null;
        try {
            Class.forName("oracle.jdbc.driver.OracleDriver");
            conn = DriverManager.getConnection(url, "lhh", "lhh1234");
            System.out.println("连接: " + conn);
            pstmt = conn.prepareStatement(sql);
            pstmt.setString(1,"%"+b_name+"%");
            pstmt.setInt(2,currentPage*rowsPage);
            pstmt.setInt(3,(currentPage-1)*rowsPage+1);
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
            if(currentPage==1) {
                sql = "SELECT COUNT(*) FROM books WHERE b_name LIKE ?";
                pstmt = conn.prepareStatement(sql);
                pstmt.setString(1,"%"+b_name+"%");
                rs = pstmt.executeQuery();
                int totalRows = 0;
                if (rs.next()) {
                    totalRows = rs.getInt(1);
                }
                totalPage = totalRows % rowsPage == 0 ? totalRows / rowsPage : totalRows / rowsPage + 1;
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

    public static List<Books> serchBooksForauthor(String b_author) {
        List<Books> list = new ArrayList<Books>();
        Connection conn = null;
        String url = "jdbc:oracle:thin:@8.129.212.155:1521:orcl";
        PreparedStatement pstmt = null;
        String sql = "SELECT * FROM books WHERE b_author LIKE ?";
        ResultSet rs = null;
        try {
            Class.forName("oracle.jdbc.driver.OracleDriver");
            conn = DriverManager.getConnection(url, "lhh", "lhh1234");
            System.out.println("连接: " + conn);
            pstmt = conn.prepareStatement(sql);
            pstmt.setString(1,"%"+b_author+"%");
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

    public static List<Books> serchBooksForauthor(String b_author,int currentPage,int rowsPage) {
        List<Books> list = new ArrayList<Books>();
        Connection conn = null;
        String url = "jdbc:oracle:thin:@8.129.212.155:1521:orcl";
        PreparedStatement pstmt = null;
        String sql = "SELECT * FROM (SELECT rownum rn,b.* FROM books b WHERE b_author LIKE ? AND rownum<=?) WHERE rn>=?";
        ResultSet rs = null;
        try {
            Class.forName("oracle.jdbc.driver.OracleDriver");
            conn = DriverManager.getConnection(url, "lhh", "lhh1234");
            System.out.println("连接: " + conn);
            pstmt = conn.prepareStatement(sql);
            pstmt.setString(1,"%"+b_author+"%");
            pstmt.setInt(2,currentPage*rowsPage);
            pstmt.setInt(3,(currentPage-1)*rowsPage+1);
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
            if(currentPage==1) {
                sql = "SELECT COUNT(*) FROM books WHERE b_author LIKE ?";
                pstmt = conn.prepareStatement(sql);
                pstmt.setString(1,"%"+b_author+"%");
                rs = pstmt.executeQuery();
                int totalRows = 0;
                if (rs.next()) {
                    totalRows = rs.getInt(1);
                }
                totalPage = totalRows % rowsPage == 0 ? totalRows / rowsPage : totalRows / rowsPage + 1;
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

    public static List<Books> serchBooksForBkid(String bk_id) {
        List<Books> list = new ArrayList<Books>();
        Connection conn = null;
        String url = "jdbc:oracle:thin:@8.129.212.155:1521:orcl";
        PreparedStatement pstmt = null;
        String sql = "SELECT * FROM books WHERE bk_id = ?";
        ResultSet rs = null;
        try {
            Class.forName("oracle.jdbc.driver.OracleDriver");
            conn = DriverManager.getConnection(url, "lhh", "lhh1234");
            System.out.println("连接: " + conn);
            pstmt = conn.prepareStatement(sql);
            pstmt.setString(1,bk_id);
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

    public static List<Books> serchBooksForBkid(String bk_id,int currentPage,int rowsPage) {
        List<Books> list = new ArrayList<Books>();
        Connection conn = null;
        String url = "jdbc:oracle:thin:@8.129.212.155:1521:orcl";
        PreparedStatement pstmt = null;
        String sql = "SELECT * FROM (SELECT rownum rn,b.* FROM books b WHERE bk_id = ? AND rownum<=?) WHERE rn>=?";
        ResultSet rs = null;
        try {
            Class.forName("oracle.jdbc.driver.OracleDriver");
            conn = DriverManager.getConnection(url, "lhh", "lhh1234");
            System.out.println("连接: " + conn);
            pstmt = conn.prepareStatement(sql);
            pstmt.setString(1,bk_id);
            pstmt.setInt(2,currentPage*rowsPage);
            pstmt.setInt(3,(currentPage-1)*rowsPage+1);
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
            if(currentPage==1) {
                sql = "SELECT count(*) FROM books WHERE bk_id = ?";
                pstmt = conn.prepareStatement(sql);
                pstmt.setString(1,bk_id);
                rs = pstmt.executeQuery();
                int totalRows = 0;
                if (rs.next()) {
                    totalRows = rs.getInt(1);
                }
                totalPage = totalRows % rowsPage == 0 ? totalRows / rowsPage : totalRows / rowsPage + 1;
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

    public static List<Books> serchBooksForNameAndAuthor(String b_name,String b_author) {
        List<Books> list = new ArrayList<Books>();
        Connection conn = null;
        String url = "jdbc:oracle:thin:@8.129.212.155:1521:orcl";
        PreparedStatement pstmt = null;
        String sql = "SELECT * FROM books WHERE b_name LIKE ? AND b_author LIKE ?";
        ResultSet rs = null;
        try {
            Class.forName("oracle.jdbc.driver.OracleDriver");
            conn = DriverManager.getConnection(url, "lhh", "lhh1234");
            System.out.println("连接: " + conn);
            pstmt = conn.prepareStatement(sql);
            pstmt.setString(1,"%"+b_name+"%");
            pstmt.setString(2,"%"+b_author+"%");
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

    public static List<Books> serchBooksForNameAndAuthor(String b_name,String b_author,int currentPage,int rowsPage) {
        List<Books> list = new ArrayList<Books>();
        Connection conn = null;
        String url = "jdbc:oracle:thin:@8.129.212.155:1521:orcl";
        PreparedStatement pstmt = null;
        String sql = "SELECT * FROM (SELECT rownum rn,b.* FROM books b WHERE b_name LIKE ? AND b_author LIKE ? AND rownum<=?) WHERE rn>=?";
        ResultSet rs = null;
        try {
            Class.forName("oracle.jdbc.driver.OracleDriver");
            conn = DriverManager.getConnection(url, "lhh", "lhh1234");
            System.out.println("连接: " + conn);
            pstmt = conn.prepareStatement(sql);
            pstmt.setString(1,"%"+b_name+"%");
            pstmt.setString(2,"%"+b_author+"%");
            pstmt.setInt(3,currentPage*rowsPage);
            pstmt.setInt(4,(currentPage-1)*rowsPage+1);
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
            if(currentPage==1) {
                sql = "SELECT count(*) FROM books WHERE b_name LIKE ? AND b_author LIKE ?";
                pstmt = conn.prepareStatement(sql);
                pstmt.setString(1,"%"+b_name+"%");
                pstmt.setString(2,"%"+b_author+"%");
                rs = pstmt.executeQuery();
                int totalRows = 0;
                if (rs.next()) {
                    totalRows = rs.getInt(1);
                }
                totalPage = totalRows % rowsPage == 0 ? totalRows / rowsPage : totalRows / rowsPage + 1;
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

    public static List<Books> serchBooksForNameAndBkid(String b_name,String bk_id) {
        List<Books> list = new ArrayList<Books>();
        Connection conn = null;
        String url = "jdbc:oracle:thin:@8.129.212.155:1521:orcl";
        PreparedStatement pstmt = null;
        String sql = "SELECT * FROM books WHERE b_name LIKE ? AND bk_id=?";
        ResultSet rs = null;
        try {
            Class.forName("oracle.jdbc.driver.OracleDriver");
            conn = DriverManager.getConnection(url, "lhh", "lhh1234");
            System.out.println("连接: " + conn);
            pstmt = conn.prepareStatement(sql);
            pstmt.setString(1,"%"+b_name+"%");
            pstmt.setString(2,bk_id);
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

    public static List<Books> serchBooksForNameAndBkid(String b_name,String bk_id,int currentPage,int rowsPage) {
        List<Books> list = new ArrayList<Books>();
        Connection conn = null;
        String url = "jdbc:oracle:thin:@8.129.212.155:1521:orcl";
        PreparedStatement pstmt = null;
        String sql = "SELECT * FROM (SELECT rownum rn,b.* FROM books b WHERE b_name LIKE ? AND bk_id=? AND rownum<=?) WHERE rn>=?";
        ResultSet rs = null;
        try {
            Class.forName("oracle.jdbc.driver.OracleDriver");
            conn = DriverManager.getConnection(url, "lhh", "lhh1234");
            System.out.println("连接: " + conn);
            pstmt = conn.prepareStatement(sql);
            pstmt.setString(1,"%"+b_name+"%");
            pstmt.setString(2,bk_id);
            pstmt.setInt(3,currentPage*rowsPage);
            pstmt.setInt(4,(currentPage-1)*rowsPage+1);
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
            if(currentPage==1) {
                sql = "SELECT COUNT(*) FROM books WHERE b_name LIKE ? AND bk_id=?";
                pstmt = conn.prepareStatement(sql);
                pstmt.setString(1,"%"+b_name+"%");
                pstmt.setString(2,bk_id);
                rs = pstmt.executeQuery();
                int totalRows = 0;
                if (rs.next()) {
                    totalRows = rs.getInt(1);
                }
                totalPage = totalRows % rowsPage == 0 ? totalRows / rowsPage : totalRows / rowsPage + 1;
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

    public static List<Books> serchBooksForAuthorAndBkid(String b_author,String bk_id) {
        List<Books> list = new ArrayList<Books>();
        Connection conn = null;
        String url = "jdbc:oracle:thin:@8.129.212.155:1521:orcl";
        PreparedStatement pstmt = null;
        String sql = "SELECT * FROM books WHERE b_author LIKE ? AND bk_id=?";
        ResultSet rs = null;
        try {
            Class.forName("oracle.jdbc.driver.OracleDriver");
            conn = DriverManager.getConnection(url, "lhh", "lhh1234");
            System.out.println("连接: " + conn);
            pstmt = conn.prepareStatement(sql);
            pstmt.setString(1,"%"+b_author+"%");
            pstmt.setString(2,bk_id);
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

    public static List<Books> serchBooksForAuthorAndBkid(String b_author,String bk_id,int currentPage,int rowsPage) {
        List<Books> list = new ArrayList<Books>();
        Connection conn = null;
        String url = "jdbc:oracle:thin:@8.129.212.155:1521:orcl";
        PreparedStatement pstmt = null;
        String sql = "SELECT * FROM (SELECT rownum rn,b.* FROM books b WHERE b_author LIKE ? AND bk_id=? AND rownum<=?) WHERE rn>=?";
        ResultSet rs = null;
        try {
            Class.forName("oracle.jdbc.driver.OracleDriver");
            conn = DriverManager.getConnection(url, "lhh", "lhh1234");
            System.out.println("连接: " + conn);
            pstmt = conn.prepareStatement(sql);
            pstmt.setString(1,"%"+b_author+"%");
            pstmt.setString(2,bk_id);
            pstmt.setInt(3,currentPage*rowsPage);
            pstmt.setInt(4,(currentPage-1)*rowsPage+1);
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
            if(currentPage==1) {
                sql = "SELECT COUNT(*) FROM books WHERE b_author LIKE ? AND bk_id=?";
                pstmt = conn.prepareStatement(sql);
                pstmt.setString(1,"%"+b_author+"%");
                pstmt.setString(2,bk_id);
                rs = pstmt.executeQuery();
                int totalRows = 0;
                if (rs.next()) {
                    totalRows = rs.getInt(1);
                }
                totalPage = totalRows % rowsPage == 0 ? totalRows / rowsPage : totalRows / rowsPage + 1;
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

    public static List<Books> serchBooks(String b_name,String b_author,String bk_id) {
        List<Books> list = new ArrayList<Books>();
        Connection conn = null;
        String url = "jdbc:oracle:thin:@8.129.212.155:1521:orcl";
        PreparedStatement pstmt = null;
        String sql = "SELECT * FROM books WHERE b_name LIKE ? AND b_author LIKE ? AND bk_id=?";
        ResultSet rs = null;
        try {
            Class.forName("oracle.jdbc.driver.OracleDriver");
            conn = DriverManager.getConnection(url, "lhh", "lhh1234");
            System.out.println("连接: " + conn);
            pstmt = conn.prepareStatement(sql);
            pstmt.setString(1,"%"+b_name+"%");
            pstmt.setString(2,"%"+b_author+"%");
            pstmt.setString(3,bk_id);
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

    public static List<Books> serchBooks(String b_name,String b_author,String bk_id,int currentPage,int rowsPage) {
        List<Books> list = new ArrayList<Books>();
        Connection conn = null;
        String url = "jdbc:oracle:thin:@8.129.212.155:1521:orcl";
        PreparedStatement pstmt = null;
        String sql = "SELECT * FROM (SELECT rownum rn,b.* FROM books b WHERE b_name LIKE ? AND b_author LIKE ? AND bk_id=? AND rownum<=?) WHERE rn>=?";
        ResultSet rs = null;
        try {
            Class.forName("oracle.jdbc.driver.OracleDriver");
            conn = DriverManager.getConnection(url, "lhh", "lhh1234");
            System.out.println("连接: " + conn);
            pstmt = conn.prepareStatement(sql);
            pstmt.setString(1,"%"+b_name+"%");
            pstmt.setString(2,"%"+b_author+"%");
            pstmt.setString(3,bk_id);
            pstmt.setInt(4,currentPage*rowsPage);
            pstmt.setInt(5,(currentPage-1)*rowsPage+1);
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
            if(currentPage==1) {
                sql = "SELECT COUNT(*) FROM books WHERE b_name LIKE ? AND b_author LIKE ? AND bk_id=?";
                pstmt = conn.prepareStatement(sql);
                pstmt.setString(1,"%"+b_name+"%");
                pstmt.setString(2,"%"+b_author+"%");
                pstmt.setString(3,bk_id);
                rs = pstmt.executeQuery();
                int totalRows = 0;
                if (rs.next()) {
                    totalRows = rs.getInt(1);
                }
                totalPage = totalRows % rowsPage == 0 ? totalRows / rowsPage : totalRows / rowsPage + 1;
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

    public static String serchbkname(String bk_id){
        String bk_name="";
        Connection conn = null;
        String url = "jdbc:oracle:thin:@8.129.212.155:1521:orcl";
        PreparedStatement pstmt = null;
        String sql = "SELECT * FROM bookcategory WHERE bk_id=?";
        ResultSet rs = null;
        try {
            Class.forName("oracle.jdbc.driver.OracleDriver");
            conn = DriverManager.getConnection(url, "lhh", "lhh1234");
            System.out.println("连接: " + conn);
            pstmt = conn.prepareStatement(sql);
            pstmt.setString(1, String.valueOf(bk_id));
            rs = pstmt.executeQuery();
            if (rs.next()) {
                bk_name=rs.getString("bk_name");
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
        return bk_name;
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

    public static Users serchuser(String uid){
        Users users=new Users();
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
                users.setU_id(rs.getString("u_id"));
                users.setU_name(rs.getString("u_name"));
                users.setU_password(rs.getString("u_password"));
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
        return users;
    }

    public static List<Borrows> serchBoroows(String uid){
        List<Borrows> list=new ArrayList<Borrows>();
        Connection conn = null;
        String url = "jdbc:oracle:thin:@8.129.212.155:1521:orcl";
        PreparedStatement pstmt = null;
        String sql = "SELECT * FROM borrows WHERE u_id=?";
        ResultSet rs = null;
        try {
            Class.forName("oracle.jdbc.driver.OracleDriver");
            conn = DriverManager.getConnection(url, "lhh", "lhh1234");
            System.out.println("连接: " + conn);
            pstmt = conn.prepareStatement(sql);
            pstmt.setString(1, uid);
            rs = pstmt.executeQuery();
            while (rs.next()) {
                Borrows borrows=new Borrows();
                borrows.setB_id(rs.getString("b_id"));
                borrows.setU_id(rs.getString("u_id"));
                borrows.setBr_id(rs.getString("br_id"));
                borrows.setBr_date(rs.getDate("br_time"));
                borrows.setRe_date(rs.getDate("re_time"));
                list.add(borrows);
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

    public static Borrows serchBoroowsForBrid(String brid){
        Borrows borrows=new Borrows();
        Connection conn = null;
        String url = "jdbc:oracle:thin:@8.129.212.155:1521:orcl";
        PreparedStatement pstmt = null;
        String sql = "SELECT * FROM borrows WHERE br_id=?";
        ResultSet rs = null;
        try {
            Class.forName("oracle.jdbc.driver.OracleDriver");
            conn = DriverManager.getConnection(url, "lhh", "lhh1234");
            System.out.println("连接: " + conn);
            pstmt = conn.prepareStatement(sql);
            pstmt.setString(1, brid);
            rs = pstmt.executeQuery();
            if (rs.next()) {
                borrows.setB_id(rs.getString("b_id"));
                borrows.setU_id(rs.getString("u_id"));
                borrows.setBr_id(rs.getString("br_id"));
                borrows.setBr_date(rs.getDate("br_time"));
                borrows.setRe_date(rs.getDate("re_time"));
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
        return borrows;
    }

    public static List<String> serchBk_name(String bk_id[]){
        List<String> list=new ArrayList<String>();
        Connection conn = null;
        String url = "jdbc:oracle:thin:@8.129.212.155:1521:orcl";
        PreparedStatement pstmt = null;
        String sql = "SELECT * FROM bookcategory WHERE bk_id=?";
        ResultSet rs = null;
        try {
            Class.forName("oracle.jdbc.driver.OracleDriver");
            conn = DriverManager.getConnection(url, "lhh", "lhh1234");
            System.out.println("连接: " + conn);
            pstmt = conn.prepareStatement(sql);
            for(int i=0;i<bk_id.length;i++) {
                pstmt.setString(1, bk_id[i]);
                rs = pstmt.executeQuery();
                if (rs.next()) {
                    list.add(rs.getString("bk_name"));
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
        return list;
    }

    public static List<String> serchB_name(String b_id[]){
        List<String> list=new ArrayList<String>();
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
            for(int i=0;i<b_id.length;i++) {
                pstmt.setString(1, b_id[i]);
                rs = pstmt.executeQuery();
                if (rs.next()) {
                    list.add(rs.getString("b_name"));
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
        return list;
    }
}
