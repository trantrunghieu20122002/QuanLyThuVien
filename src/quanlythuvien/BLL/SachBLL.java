package quanlythuvien.BLL;
import java.util.Vector;
import quanlythuvien.DTO.SachDTO;
import quanlythuvien.DAL.SachDAL;

public class SachBLL {
    SachDAL empDAL = new SachDAL();
    public Vector<SachDTO> getAllBook(){
        return empDAL.getAllBook();
    }
    public Vector<SachDTO> FindBookByName(String name){
        return empDAL.FindBookByName(name);
    }
    public Vector<SachDTO> ChiTietSach(String id){
        return empDAL.ChiTietSach(id);
    }
}
