/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package quanlythuvien.DAL;

import java.sql.*;
import quanlythuvien.DTO.DanhMucDTO;
import java.util.Vector;

/**
 *
 * @author huyga
 */
public class DanhMucDAL {

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

    public Vector<DanhMucDTO> getAllDM() {
        Vector<DanhMucDTO> tmp = new Vector<>();
        if (openConnection()) {
            try {
                String sql = "Select * from DanhMucSach";
                Statement stmt = con.createStatement();
                ResultSet rs = stmt.executeQuery(sql);
                while (rs.next()) {
                    DanhMucDTO dm = new DanhMucDTO();
                    dm.setMaDM(rs.getString(1));
                    dm.setTenDM(rs.getString(2));
                    tmp.add(dm);
                }
            } catch (SQLException e) {
                System.out.println(e);
            } finally {
                closeConnection();
            }
        }
        return tmp;
    }

    public Vector<DanhMucDTO> getDMByName(String tenDM) {
        Vector<DanhMucDTO> tmp = new Vector<>();
        if (openConnection()) {
            try {
                String sql = "Select * from DanhMucSach where TenDanhMuc like N'%" + tenDM + "%'";
                Statement stmt = con.createStatement();
                ResultSet rs = stmt.executeQuery(sql);
                while (rs.next()) {
                    DanhMucDTO dm = new DanhMucDTO();
                    dm.setMaDM(rs.getString(1));
                    dm.setTenDM(rs.getString(2));
                    tmp.add(dm);
                }
            } catch (SQLException e) {
                System.out.println(e);
            } finally {
                closeConnection();
            }
        }
        return tmp;
    }

    public boolean hasMaDM(String maDM) {
        boolean result = false;
        if (openConnection()) {
            try {
                String sql = "select * from DanhMucSach where MaDanhMuc = " + maDM;
                Statement stmt = con.createStatement();
                ResultSet rs = stmt.executeQuery(sql);
                result = rs.next();
            } catch (SQLException e) {
                System.out.println(e);
            } finally {
                closeConnection();
            }
        }
        return result;
    }

    public boolean addDM(DanhMucDTO dm) {
        boolean result = false;
        if (openConnection()) {
            try {
                String sql = "insert into DanhMucSach values(?, ?)";
                PreparedStatement stmt = con.prepareStatement(sql);
                stmt.setString(1, dm.getMaDM());
                stmt.setString(2, dm.getTenDM());
                if (stmt.executeUpdate() >= 1) {
                    result = true;
                }
            } catch (SQLException e) {
                System.out.println(e);
            } finally {
                closeConnection();
            }
        }
        return result;
    }

    public boolean deleteDM(DanhMucDTO dm) {
        boolean result = false;
        if (openConnection()) {
            try {
                String sql = "delete from DanhMucSach where MaDanhMuc = '" + dm.getMaDM() + "'";
                PreparedStatement stmt = con.prepareStatement(sql);
                result = stmt.executeUpdate() > 0 ? true : false;
            } catch (SQLException e) {
                System.out.println(e);
            } finally {
                closeConnection();
            }
        }
        return result;
    }

    public boolean updateDM(DanhMucDTO dm) {
        boolean result = false;
        if (openConnection()) {
            try {
                String sql = "UPDATE DanhMucSach SET TenDanhMuc = N'" + dm.getTenDM() + "' WHERE MaDanhMuc= '" + dm.getMaDM() + "'";
                PreparedStatement stmt = con.prepareStatement(sql);
                result = stmt.executeUpdate() > 0 ? true : false;
            } catch (SQLException e) {
                System.out.println(e);
            } finally {
                closeConnection();
            }
        }
        return result;
    }
}
