package quanlythuvien.DAL;
import quanlythuvien.DTO.SachDTO;
import java.sql.*;
import java.util.Vector;
public class SachDAL {
    private Connection con;
    public boolean openConnection() {
        try{
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            String dbUrl = "jdbc:sqlserver://localhost:1433; DatabaseName=QLThuVien";
            String username = "sa"; 
            String password= "123";
            con=DriverManager.getConnection(dbUrl, username, password);
            return true;
        }
        catch(Exception ex){
            System.out.println(ex);
            return false; 
        }
    }
    public void closeConnection() {
        try {
            if (con!=null)
            con.close();
        } catch (SQLException ex) {
            System.out.println(ex); }
    }
    public Vector<SachDTO> getAllBook(){
        Vector<SachDTO> arr = new Vector<SachDTO>();
        if (openConnection()) {
            try{
                String sql = "Select * from Sach";
                Statement stmt = con.createStatement();
                ResultSet rs = stmt.executeQuery(sql);
                while(rs.next()){
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
            }
            catch (SQLException ex) {
                System.out.println(ex);
            }
            finally {
                closeConnection();
            }
        }
        return arr;
    }
    
    public Vector<SachDTO> FindBookByName(String name){
        Vector<SachDTO> arr = new Vector<SachDTO>();
        if (openConnection()) {
            try{
                String sql = "Select * from Sach where TenSach like '%"+name+"%'";
                Statement stmt = con.createStatement();
                ResultSet rs = stmt.executeQuery(sql);
                while(rs.next()){
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
            }
            catch (SQLException ex) {
                System.out.println(ex);
            }
            finally {
                closeConnection();
            }
        }
        return arr;
    }
    public Vector<SachDTO> ChiTietSach(String id){
        Vector<SachDTO> arr = new Vector<SachDTO>();
        if (openConnection()) {
            try{
                String sql = "Select * from Sach where MaSach = '"+id+"'";
                Statement stmt = con.createStatement();
                ResultSet rs = stmt.executeQuery(sql);
                while(rs.next()){
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
            }
            catch (SQLException ex) {
                System.out.println(ex);
            }
            finally {
                closeConnection();
            }
        }
        return arr;

    }
}
