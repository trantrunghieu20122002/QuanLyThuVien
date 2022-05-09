package quanlythuvien.BLL;
import quanlythuvien.DTO.DocGiaDTO;
import quanlythuvien.DTO.PhieuMuonDTO;
import quanlythuvien.DAL.PhieuMuonDAL;
import java.util.Vector;
import quanlythuvien.DTO.SachDTO;

public class PhieuMuonBLL {
    PhieuMuonDAL PhieuMuon = new PhieuMuonDAL();
    public boolean InsertPhieuMuon(Vector<SachDTO> DanhSachMuon,DocGiaDTO user,int NgayMuon){
        if(PhieuMuon.InsertPhieuMuon(DanhSachMuon, user, NgayMuon))
            return true;
        else
            return false;
    }
}
