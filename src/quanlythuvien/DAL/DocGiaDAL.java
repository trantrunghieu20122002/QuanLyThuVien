package quanlythuvien.DAL;
import quanlythuvien.DTO.DocGiaDTO;
import java.sql.*;
import java.util.Vector;
public class DocGiaDAL {
    private Connection con;
    public boolean openConnection() {
        try{
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            String dbUrl = "localhost";
            String DatabaseName="QLThuVien" ;
            String username = "sa"; 
            String password= "26092002";
            String url = "jdbc:sqlserver://" +dbUrl + ":1433;DatabaseName=" + DatabaseName + ";username="+username+";password="+password+";encrypt=true;trustServerCertificate=true;";
            con=DriverManager.getConnection(url);  
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
    public Vector<DocGiaDTO> getAllBook(){
        Vector<DocGiaDTO> arr = new Vector<DocGiaDTO>();
        if (openConnection()) {
            try{
                String sql = "Select * from Sach";
                Statement stmt = con.createStatement();
                ResultSet rs = stmt.executeQuery(sql);
                while(rs.next()){
                    DocGiaDTO em = new DocGiaDTO();
                    em.setDocGia_id(rs.getString(1));
                    em.setDocGia_name(rs.getString(2));
                    em.setDocGia_DM(rs.getString(3));
                    em.setDocGia_TL(rs.getString(4));
                    em.setDocGia_author(rs.getString(5));
                    em.setDocGia_nxb(rs.getString(6));
                    em.setDocGia_year(rs.getInt(7));
                    em.setDocGia_quantity(rs.getInt(8));
                    em.setDocGia_noidung(rs.getString(9));
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
    
    public Vector<DocGiaDTO> FindBookByName(String name){
        Vector<DocGiaDTO> arr = new Vector<DocGiaDTO>();
        if (openConnection()) {
            try{
                String sql = "Select * from Sach where TenSach like '%"+name+"%'";
                Statement stmt = con.createStatement();
                ResultSet rs = stmt.executeQuery(sql);
                while(rs.next()){
                    DocGiaDTO em = new DocGiaDTO();
                    em.setDocGia_id(rs.getString(1));
                    em.setDocGia_name(rs.getString(2));
                    em.setDocGia_DM(rs.getString(3));
                    em.setDocGia_TL(rs.getString(4));
                    em.setDocGia_author(rs.getString(5));
                    em.setDocGia_nxb(rs.getString(6));
                    em.setDocGia_year(rs.getInt(7));
                    em.setDocGia_quantity(rs.getInt(8));
                    em.setDocGia_noidung(rs.getString(9));
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
    public Vector<DocGiaDTO> ChiTietSach(String id){
        Vector<DocGiaDTO> arr = new Vector<DocGiaDTO>();
        if (openConnection()) {
            try{
                String sql = "Select * from Sach where MaSach = '"+id+"'";
                Statement stmt = con.createStatement();
                ResultSet rs = stmt.executeQuery(sql);
                while(rs.next()){
                    DocGiaDTO em = new DocGiaDTO();
                    em.setDocGia_id(rs.getString(1));
                    em.setDocGia_name(rs.getString(2));
                    em.setDocGia_DM(rs.getString(3));
                    em.setDocGia_TL(rs.getString(4));
                    em.setDocGia_author(rs.getString(5));
                    em.setDocGia_nxb(rs.getString(6));
                    em.setDocGia_year(rs.getInt(7));
                    em.setDocGia_quantity(rs.getInt(8));
                    em.setDocGia_noidung(rs.getString(9));
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
