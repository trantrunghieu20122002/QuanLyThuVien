package quanlythuvien.BLL;
import quanlythuvien.DTO.DocGiaDTO;
import quanlythuvien.DTO.PhieuMuonDTO;
import quanlythuvien.DAL.PhieuMuonDAL;
import java.util.Vector;
import quanlythuvien.DTO.SachDTO;

public class PhieuMuonBLL {
    PhieuMuonDAL phieDAL = new PhieuMuonDAL();
    public boolean InsertPhieuMuon(Vector<SachDTO> DanhSachMuon,DocGiaDTO user,int NgayMuon){
        if (phieDAL.InsertPhieuMuon(DanhSachMuon, user, NgayMuon))
            return true;
        else
            return false;
    }

//    public String addPhieuMuon(PhieuMuonDTO phie) {
//        if (phieDAL.hasMaPhieuMuon(phie.getMaPhieuMuon()))
//            return "Mã phiếu mượn đã tồn tại";
//        if (phieDAL.addPhieuMuon(phie)) {
//            return "Thêm thành công";
//        }
//        return "Thêm thất bại";
////        phieDAL.addPhieuMuon(phie);
////        return "Thêm thành công";
//    }
    public String editPhieuMuon(String NgayMuon, int SoNgayMuon, String idDocGia, String idNhanVien, String GhiChu, int TrangThai,String idPhieuMuon){
        if(phieDAL.editPhieuMuon(NgayMuon, SoNgayMuon,  idDocGia, idNhanVien,  GhiChu,  TrangThai, idPhieuMuon))
            return "Sửa thành công";
        else return "Sửa thất bại";
    }
    public Vector<PhieuMuonDTO> getAllPhieuMuon() {
        return phieDAL.getAllPhieuMuon();
    }
    public String deletePhieuMuon(String id){
        if(phieDAL.deletePhieuMuon(id)){
            return "Xóa thành công";
        }
        else{
            return "Xóa thất bại";
        }
    }
}
