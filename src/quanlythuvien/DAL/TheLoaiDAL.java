/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package quanlythuvien.DAL;

import java.sql.*;
import quanlythuvien.DTO.TheLoaiDTO;
import java.util.Vector;


/**
 *
 * @author huyga
 */
public class TheLoaiDAL {
    
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
    
    public Vector<TheLoaiDTO> getAllTL() {
        Vector<TheLoaiDTO> tmp = new Vector<>();
        if (openConnection()) {
            try {
                String sql = "Select * from TheLoaiSach";
                Statement stmt = con.createStatement();
                ResultSet rs = stmt.executeQuery(sql);
                while (rs.next()) {
                    TheLoaiDTO tl = new TheLoaiDTO();
                    tl.setMaTheLoai(rs.getString(1));
                    tl.setTenTheLoai(rs.getString(2));
                    tmp.add(tl);
                }
            } catch (SQLException e) {
                System.out.println(e);
            } finally {
                closeConnection();
            }
        }
        return tmp;
    }
    
    public Vector<TheLoaiDTO> getTLByName(String tenTL) {
        Vector<TheLoaiDTO> tmp = new Vector<>();
        if (openConnection()) {
            try {
                String sql = "Select * from TheLoaiSach where TenTheLoai like '%N" + tenTL + "%'";
                Statement stmt = con.createStatement();
                ResultSet rs = stmt.executeQuery(sql);
                while (rs.next()) {
                    TheLoaiDTO tl = new TheLoaiDTO();
                    tl.setMaTheLoai(rs.getString(1));
                    tl.setTenTheLoai(rs.getString(2));
                    tmp.add(tl);
                }
            } catch (SQLException e) {
                System.out.println(e);
            } finally {
                closeConnection();
            }
        }
        return tmp;
    }
    
    public boolean hasMaTL(String maTL) {
        boolean result = false;
        if (openConnection()) {
            try {
                String sql = "select * from TheLoaiSach where MaTheLoai = " + maTL;
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
    
    public boolean addTL(TheLoaiDTO tl) {
        boolean result = false;
        if (openConnection()) {
            try {
                String sql = "insert into TheLoaiSach values(?, ?)";
                PreparedStatement stmt = con.prepareStatement(sql);
                stmt.setString(1, tl.getMaTheLoai());
                stmt.setString(2, tl.getTenTheLoai());
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
    
    public boolean deleteTL(TheLoaiDTO tl) {
        boolean result = false;
        if (openConnection()) {
            try {
                String sql = "delete from TheLoaiSach where MaTheLoai = '" + tl.getMaTheLoai() + "'";
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
    
    public boolean updateTL(TheLoaiDTO tl) {
        boolean result = false;
        if (openConnection()) {
            try {
                String sql = "UPDATE TheLoaiSach SET TenTheLoai= N'" + tl.getTenTheLoai() + "' WHERE MaTheLoai = '" + tl.getMaTheLoai() + "'";
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
