package quanlythuvien.DAL;

import quanlythuvien.DTO.SachDTO;
import java.sql.*;
import java.util.Vector;

public class SachDAL {

    private Connection con;

    public boolean openConnection() {
        try {
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            String dbUrl = "localhost";
            String DatabaseName = "QLThuVien";
            String username = "sa";
            String password = "123";
            String url = "jdbc:sqlserver://" + dbUrl + ":1433;DatabaseName=" + DatabaseName + ";username=" + username + ";password=" + password + ";encrypt=true;trustServerCertificate=true;";
            con = DriverManager.getConnection(url);
            return true;
        } catch (Exception ex) {
            System.out.println(ex);
            return false;
        }
    }

    public void closeConnection() {
        try {
            if (con != null) {
                con.close();
            }
        } catch (SQLException ex) {
            System.out.println(ex);
        }
    }

    public Vector<SachDTO> getAllBook() {
        Vector<SachDTO> arr = new Vector<SachDTO>();
        if (openConnection()) {
            try {
                String sql = "Select * from Sach";
                Statement stmt = con.createStatement();
                ResultSet rs = stmt.executeQuery(sql);
                while (rs.next()) {
                    SachDTO em = new SachDTO();
                    em.setSach_id(rs.getString(1));
                    em.setSach_name(rs.getString(2));
                    em.setSach_DM(rs.getString(3));
                    em.setSach_TL(rs.getString(4));
                    em.setSach_author(rs.getString(5));
                    em.setSach_nxb(rs.getString(6));
                    em.setSach_year(rs.getInt(7));
                    em.setSach_quantity(rs.getInt(8));
                    em.setSach_noidung(rs.getString(9));
                    arr.add(em);
                }
            } catch (SQLException ex) {
                System.out.println(ex);
            } finally {
                closeConnection();
            }
        }
        return arr;
    }

    public Vector<SachDTO> FindBookByName(String name) {
        Vector<SachDTO> arr = new Vector<SachDTO>();
        if (openConnection()) {
            try {
                String sql = "Select * from Sach where TenSach like N'%" + name + "%'";
                Statement stmt = con.createStatement();
                ResultSet rs = stmt.executeQuery(sql);
                while (rs.next()) {
                    SachDTO em = new SachDTO();
                    em.setSach_id(rs.getString(1));
                    em.setSach_name(rs.getString(2));
                    em.setSach_DM(rs.getString(3));
                    em.setSach_TL(rs.getString(4));
                    em.setSach_author(rs.getString(5));
                    em.setSach_nxb(rs.getString(6));
                    em.setSach_year(rs.getInt(7));
                    em.setSach_quantity(rs.getInt(8));
                    em.setSach_noidung(rs.getString(9));
                    arr.add(em);
                }
            } catch (SQLException ex) {
                System.out.println(ex);
            } finally {
                closeConnection();
            }
        }
        return arr;
    }

    public Vector<SachDTO> ChiTietSach(String id) {
        Vector<SachDTO> arr = new Vector<SachDTO>();
        if (openConnection()) {
            try {
                String sql = "Select * from Sach where MaSach = '" + id + "'";
                Statement stmt = con.createStatement();
                ResultSet rs = stmt.executeQuery(sql);
                while (rs.next()) {
                    SachDTO em = new SachDTO();
                    em.setSach_id(rs.getString(1));
                    em.setSach_name(rs.getString(2));
                    em.setSach_DM(rs.getString(3));
                    em.setSach_TL(rs.getString(4));
                    em.setSach_author(rs.getString(5));
                    em.setSach_nxb(rs.getString(6));
                    em.setSach_year(rs.getInt(7));
                    em.setSach_quantity(rs.getInt(8));
                    em.setSach_noidung(rs.getString(9));
                    arr.add(em);
                }
            } catch (SQLException ex) {
                System.out.println(ex);
            } finally {
                closeConnection();
            }
        }
        return arr;
    }
    
        
    public boolean hasBookId(String id){
        boolean result = false;
        if (openConnection()){
            try {
                String sql = "select * from Sach where MaSach = " + id;
                Statement stmt = con.createStatement();
                ResultSet rs = stmt.executeQuery(sql);
                result = rs.next();
            }catch (SQLException ex){
                System.out.println(ex);
            }finally {
                closeConnection();
            }
        }
        return result;
    }
    
    public boolean addBook(SachDTO book) {
        boolean result = false;
        if (openConnection()) {
            try {
                String sql = "insert into Sach values(?, ?, ?, ?, ?, ?, ?, ?, ?)";
                PreparedStatement stmt = con.prepareStatement(sql);
                stmt.setString(1, book.getSach_id());
                stmt.setString(2, book.getSach_name());
                stmt.setString(3, book.getSach_DM());
                stmt.setString(4, book.getSach_TL());
                stmt.setString(5, book.getSach_author());
                stmt.setString(6, book.getSach_nxb());
                stmt.setInt(7, book.getSach_year());
                stmt.setInt(8, book.getSach_quantity());
                stmt.setString(9, book.getSach_noidung());
                if (stmt.executeUpdate() >= 1) {
                    result = true;
                }
            } catch (SQLException ex) {
                System.out.println(ex);
            } finally {
                closeConnection();
            }
        }
        return result;
    }
}
