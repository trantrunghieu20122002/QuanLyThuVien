package quanlythuvien.DAL;
import quanlythuvien.DTO.DocGiaDTO;
import java.sql.*;
import java.util.Vector;

public class DocGiaDAL {
    private Connection con;
    public boolean openConection(){
        try {
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            String dbUrl = "jdbc:sqlserver://localhost:1433; DatabaseName = QLThuVien";
            String username = "sa"; String password= "123";
            con = DriverManager.getConnection(dbUrl, username, password);
            return true;
        }catch (Exception ex){
            System.out.println(ex);
            return false;
        }
    }
    public void closeConection(){
        try {
            if (con != null)
                con.close();
        } catch (SQLException ex) {
            System.out.println(ex); }
    }
    public Vector<DocGiaDTO> getAllDocGia(){
        Vector<DocGiaDTO> arr = new Vector<DocGiaDTO>();
        if(openConection()){
            try {
                String sql = "Select * from DocGia";
                Statement stmt = con.createStatement();
                ResultSet rs = stmt.executeQuery(sql);
                while(rs.next()){
                    DocGiaDTO doc= new DocGiaDTO();
                    doc.setMaDocGia(rs.getString(1));
                    doc.setTenDocGia(rs.getString(2));
                    doc.setNgaySinh(rs.getString(3));
                    doc.setGioiTinh(rs.getString(4));
                    doc.setEmail(rs.getString(5));
                    doc.setSDT(rs.getString(6));
                    doc.setStatus(rs.getInt(7));
                    doc.setSoLuongMuon(rs.getInt(8));
                    arr.add(doc);}
            }catch (SQLException ex){
                System.out.println(ex);
            }finally {
                closeConection();
            }}
        System.out.print(arr);
            return arr;
    }
    public boolean addDocGia(DocGiaDTO doc){
        boolean result = true;
        if (openConection()){
            try {
                String sql = "Insert into DocGia values(?,?,?,?,?,?,?,?)";
                PreparedStatement stmt = con.prepareStatement(sql);
                stmt.setString(1,doc.getMaDocGia());
                stmt.setString(2,doc.getTenDocGia());
                stmt.setString(3,doc.getNgaySinh());
                stmt.setString(4,doc.getGioiTinh());
                stmt.setString(5,doc.getEmail());
                stmt.setString(6,doc.getSDT());
                stmt.setString(7, String.valueOf(doc.getStatus()));
                stmt.setString(8, String.valueOf(doc.getSoLuongMuon()));
                if (stmt.executeUpdate() >= 1)
                    result = true;
            }catch (SQLException ex){
                System.out.println(ex);
            }finally {
                closeConection();}}
        return result;
    }
    public boolean hasMaDocGia(String id){
        boolean result = false;
        if (openConection()){
            try {
                String sql = "Select * from DocGia where MaDocGia=" + id;
                Statement stmt = con.createStatement();
                ResultSet rs = stmt.executeQuery(sql);
                result = rs.next();
            }catch (SQLException ex){
                System.out.println(ex);
            }finally {
                closeConection();}}
        return result;
    }
}
