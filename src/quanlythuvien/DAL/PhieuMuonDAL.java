package quanlythuvien.DAL;
import quanlythuvien.DTO.PhieuMuonDTO;
import java.sql.*;
import java.time.LocalDate;
import java.time.ZoneId;
import java.util.Vector;
import quanlythuvien.DTO.DocGiaDTO;
import quanlythuvien.DTO.SachDTO;
public class PhieuMuonDAL {
    ZoneId zonedId = ZoneId.of( "America/Montreal" );
    LocalDate today = LocalDate.now( zonedId );
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
    
    public boolean InsertPhieuMuon(Vector<SachDTO> DanhSachMuon,DocGiaDTO user,int NgayMuon){
        boolean result = true;
        System.out.println("ds: "+DanhSachMuon.size());
        if (openConection()){
            try {   
    //  =====================   Add vào bảng phiếu mượn   =====================
                    String MaPM ="PM00"+String.valueOf(SoDonHang()+1);
                    String sql="INSERT [dbo].[PhieuMuon] ([MaPhieuMuon], [NgayMuon], [SoNgayMuon], [MaDocGia], [MaNhanVien], [GhiChu], [TrangThai]) "                
                    + "VALUES (?,?,?,?,?,N'Không', N'0')";
                    PreparedStatement stmt = con.prepareStatement(sql);
                    stmt.setString(1, MaPM);
                    stmt.setString(2, String.valueOf(today));
                    stmt.setInt(3, NgayMuon);
                    stmt.setString(4, user.getMaDocGia());
                    stmt.setString(5, "NV001");
                    result = stmt.executeUpdate() >= 1;
    //  =====================   Add vào bảng chi tiết phiếu mượn   =====================
                    for(int i = 0; i < DanhSachMuon.size(); i++){
                        SachDTO em = DanhSachMuon.get(i);
                        String sql2="INSERT [dbo].[ChiTietPM] ([MaPhieuMuon], [MaSach], [NgayThucTra], [TienPhat], [TinhTrangSach]) "
                                + "VALUES (?,?,?,0,0)";
                        PreparedStatement stmt2 = con.prepareStatement(sql2);
                        stmt2.setString(1, MaPM);
                        stmt2.setString(2, em.getSach_id());
                        stmt2.setString(3, String.valueOf(today.plusDays(NgayMuon)));
                        result = stmt2.executeUpdate() >= 1;
                    }
    //  =====================   Update số lượng mượn   =====================
                    int newQuantity=DanhSachMuon.size()+user.getSoLuongMuon();
                    System.out.print(newQuantity);
                    String sql3="Update DocGia Set SoLuongMuon="+newQuantity+" where MaDocGia='"+user.getMaDocGia()+"'";
                    Statement st = con.createStatement();
                    st.executeUpdate(sql3);
            }catch (SQLException ex){
                System.out.println(ex+"1s");
            }finally {
                closeConection();
            }
        }
        return result;
        }
        
    
    
    public int SoDonHang(){
        int row=0;
        if(openConection()){
            try {
                String sql = "Select * from PhieuMuon";
                Statement stmt = con.createStatement();
                ResultSet rs = stmt.executeQuery(sql);
                while(rs.next())
                    row++;
            }catch (SQLException ex){
                System.out.println(ex+"2");
            }
        }
        return row;
    }
}
