package quanlythuvien.DAL;
import quanlythuvien.DTO.DocGiaDTO;
import java.sql.*;
import java.util.Vector;

public class DocGiaDAL {
    private Connection con;
    public boolean openConection(){
        try {
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            String dbUrl = "localhost";
            String DatabaseName="QLThuVien" ;
            String username = "sa"; 
            String password= "123";
            String url = "jdbc:sqlserver://" +dbUrl + ":1433;DatabaseName=" + DatabaseName + ";username="+username+";password="+password+";encrypt=true;trustServerCertificate=true;";
            con=DriverManager.getConnection(url);  

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
                System.out.println(ex+"Sai ở đây 1");
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
                String sql ="INSERT [dbo].[TaiKhoan] ([MaTaiKhoan], [TenDangNhap], [MatKhau], [Quyen]) VALUES (?, ?, ?, ?)\n" + "INSERT [dbo].[DocGia] ([MaDocGia], [TenDocGia], [NgaySinh], [GioiTinh], [Email], [SDT], [Status], [SoLuongMuon]) VALUES (?,?, CAST(? AS DATE), ?,?,?,?,?)";
                PreparedStatement stmt = con.prepareStatement(sql);
                stmt.setString(1, doc.getMaDocGia());
                stmt.setString(2, doc.getTenDangNhap());
                stmt.setString(3,doc.getMatKhau());
                stmt.setInt(4,1);

                stmt.setString(5,doc.getMaDocGia());
                stmt.setString(6,doc.getTenDocGia());
                stmt.setString(7,doc.getNgaySinh());
                stmt.setString(8,doc.getGioiTinh());
                stmt.setString(9,doc.getEmail());
                stmt.setString(10,doc.getSDT());
                stmt.setInt(11, 1);
                stmt.setInt(12, 5);

                if (stmt.executeUpdate() >= 1 ){
                    result = true;
                    System.out.println("Complete");
                }
                else
                    result = false;
            }catch (SQLException ex){
                System.out.println(ex+"Sai ở đây 2");
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
                System.out.println(ex+"Sai ở đây 3");
            }finally {
                closeConection();}}
        return result;
    }


    public boolean hasbtMaDocGia(String id){
        boolean result = true;
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

    public boolean deleteDocGia() {
        boolean result = true;
        if (openConection()){
            try {
                DocGiaDTO doc = new DocGiaDTO();
                String id = doc.getMaDocGia();
                String sql = "Delete from [dbo].[DocGia] where [MaDocGia] = '"+id+"'";
//                        + "\nDelete from [dbo].[TaiKhoan] where [MaTaiKhoan] = '" +id+"'";
                PreparedStatement stmt = con.prepareStatement(sql);
//                if (stmt.executeUpdate() >= 1){
//                    result = true;
//                    System.out.println("Complete");
//                }
                stmt.executeUpdate();

            }catch (SQLException ex){
                System.out.println(ex);
            }finally {
                closeConection();}}
        return result;
    }

    public DocGiaDTO getIdDocGia(String id){
        DocGiaDTO doc= new DocGiaDTO();
        if(openConection()){
            try {
                String sql = "Select * from DocGia where MaDocGia = '"+id+"'";
                Statement stmt = con.createStatement();
                ResultSet rs = stmt.executeQuery(sql);

                while(rs.next()){
                    doc.setMaDocGia(rs.getString(1));
                    doc.setTenDocGia(rs.getString(2));
                    doc.setNgaySinh(rs.getString(3));
                    doc.setGioiTinh(rs.getString(4));
                    doc.setEmail(rs.getString(5));
                    doc.setSDT(rs.getString(6));
                    doc.setStatus(rs.getInt(7));
                    doc.setSoLuongMuon(rs.getInt(8));
                    }

            }catch (SQLException ex){
                System.out.println(ex+"Sai ở đây 4");
            }finally {
                closeConection();
            }}
            return doc;
    }
}


