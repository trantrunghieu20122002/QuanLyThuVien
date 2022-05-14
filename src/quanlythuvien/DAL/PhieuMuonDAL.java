package quanlythuvien.DAL;
import quanlythuvien.DTO.PhieuMuonDTO;
import java.sql.*;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.ZoneId;
import java.util.Vector;
import quanlythuvien.DTO.DocGiaDTO;
import quanlythuvien.DTO.SachDTO;

import javax.swing.*;

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
    public boolean editPhieuMuon(String NgayMuon, int SoNgayMuon, String idDocGia, String idNhanVien, String GhiChu, int TrangThai,String idPhieuMuon){
        boolean result = true;
        if (openConection()){
            try {

                if (openConection()){
                    try {
                        String sql = "UPDATE PhieuMuon SET NgayMuon = '"+NgayMuon +"', SoNgayMuon = "+ SoNgayMuon+", MaDocGia = '"+idDocGia+"', MaNhanVien = '"+idNhanVien+"', GhiChu = '"+GhiChu+"', TrangThai =0 Where MaPhieuMuon = '"+idPhieuMuon+"'" ;
                        PreparedStatement stmt = con.prepareStatement(sql);
                        if (stmt.executeUpdate() >= 1 ){
                            result = true;
                            System.out.println("Complete");
                        }
                        else
                            result = false;
                        } catch (SQLException e) {
                        e.printStackTrace();
                        }finally {
                        closeConection();}}
                return result;

            }finally {
                closeConection();}}
        return result;
    }
    public boolean hasMaPhieuMuon(String id){
        boolean result = false;
        if (openConection()){
            try {
                String sql = "Select * from PhieuMuon where MaPhieuMuon= '" + id+"'";
                Statement stmt = con.createStatement();
                ResultSet rs = stmt.executeQuery(sql);
            }catch (SQLException ex){
                System.out.println(ex);
            }finally {
                closeConection();}}
        return result;
    }
//    public boolean addPhieuMuon(PhieuMuonDTO phie){
//        boolean result = true;
//        if (openConection()){
//            try {
//                String sql = "INSERT [dbo].[PhieuMuon] ([MaPhieuMuon], [NgayMuon], [SoNgayMuon], [MaDocGia], [MaNhanVien], [GhiChu], [TrangThai]) VALUES (?,?,?,?,?,?,?)\n" +
//                        "INSERT [dbo].[ChiTietPM] ([MaPhieuMuon], [MaSach]) VALUES (?, 'None')";
//
//                PreparedStatement stmt = con.prepareStatement(sql);
//                stmt.setString(1,phie.getMaPhieuMuon());
//                stmt.setString(2,phie.getNgayMuon());
//                stmt.setInt(3,phie.getSoNgayMuon());
//                stmt.setString(4,phie.getMaDocGia());
//                stmt.setString(5,phie.getMaNhanVien());
//                stmt.setString(6,phie.getGhiChu());
//                stmt.setInt(7,phie.getTrangThai());
//                stmt.setString(8,phie.getMaPhieuMuon());
//                if (stmt.executeUpdate() >= 1 ){
//                    result = true;
//                    System.out.println("Complete");
//                }
//            }catch (SQLException ex){
//                System.out.println(ex);
//                System.out.println("Lỗi insert");
//            } finally {
//                closeConection();}}
//        return result;
//    }
    public boolean deletePhieuMuon(String id) {
        boolean result = true;
        if (openConection()){
            try {
                PhieuMuonDTO pmu = new PhieuMuonDTO();
                String sql = "Delete from [dbo].[PhieuMuon] where MaPhieuMuon = '"+id+"'";

                Statement stmt = con.createStatement();
//                if (stmt.executeUpdate() >= 1){
//                    result = true;
//                    System.out.println("Complete");
//                }
                stmt.executeUpdate(sql);

            }catch (SQLException ex){
                System.out.println(ex);
                JOptionPane.showMessageDialog(null,"Độc giả chưa trả sách không thể xóa phiếu mươn này");
                result = false;
            }finally {
                closeConection();}}
        return result;
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
        
    public Vector<PhieuMuonDTO> getAllPhieuMuon(){
        Vector<PhieuMuonDTO> arr = new Vector<PhieuMuonDTO>();
        if(openConection()){
            try {
                String sql = "Select * from PhieuMuon";
                Statement stmt2 = con.createStatement();
                ResultSet rs = stmt2.executeQuery(sql);
                while(rs.next()){
                    PhieuMuonDTO phie = new PhieuMuonDTO();
                    phie.setMaPhieuMuon(rs.getString(1));
                    phie.setNgayMuon(rs.getString(2));
                    phie.setSoNgayMuon(rs.getInt(3));
                    phie.setMaDocGia(rs.getString(4));
                    phie.setMaNhanVien(rs.getString(5));
                    phie.setGhiChu(rs.getString(6));
                    phie.setTrangThai(rs.getInt(7));
                    arr.add(phie);}

            }catch (SQLException ex){
                System.out.println(ex);
                System.out.println("lỗiiiii");
            }finally {
                closeConection();
            }}
        System.out.print(arr);
        return arr;
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
