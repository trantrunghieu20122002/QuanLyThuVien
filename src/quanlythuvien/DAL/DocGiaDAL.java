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
                String sql ="INSERT [dbo].[TaiKhoan] ([MaTaiKhoan], [TenDangNhap], [MatKhau], [Quyen]) VALUES (?, ?, ?, ?)";
                //INSERT [dbo].[DocGia] ([MaDocGia], [TenDocGia], [NgaySinh], [GioiTinh], [Email], [SDT], [Status], [SoLuongMuon]) VALUES (?,?, CAST(? AS DATE), ?,?,?,?,?)";
//                CallableStatement stmt = con.prepareCall("{call insertDocGia(?,?,?,?,?,?,?,?,?,?,?,?)");
//                CallableStatement stmt = con.prepareCall("{call insertDocGia('DG100','DG100','van','van123',1,'Vân','2003-1-20','Nu','van123@gmail.com','0123456789',1,5)");
                PreparedStatement stmt = con.prepareStatement(sql);

                stmt.setString(1, doc.getMaDocGia());
//                stmt.setString(2, doc.getMaDocGia());
                stmt.setString(2, doc.getTenDangNhap());
                stmt.setString(3,doc.getMatKhau());
                stmt.setInt(4,1);
//                stmt.setInt(5,1);

//                stmt.setString(6,doc.getTenDocGia());
//                stmt.setString(7,doc.getNgaySinh());
//                stmt.setString(8,doc.getGioiTinh());
//                stmt.setString(9,doc.getEmail());
//                stmt.setString(10,doc.getSDT());
//                stmt.setInt(11, doc.getStatus());
//                stmt.setInt(12, 5);

                if (stmt.executeUpdate() >= 1 ){
                    result = true;
                    System.out.println("Complete");
                }

            }catch (SQLException ex){
                System.out.println(ex);
            }finally {
                closeConection();}}
        return result;
    }
//    public boolean deleteDocGia(DocGiaDTO doc){
//
//    }
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
