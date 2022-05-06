package quanlythuvien.BLL;
import java.util.Vector;
import quanlythuvien.DTO.DocGiaDTO;
import quanlythuvien.DAL.DocGiaDAL;

public class DocGiaBLL {
    DocGiaDAL empDAL = new DocGiaDAL();
    public Vector<DocGiaDTO> getAllBook(){
        return empDAL.getAllBook();
    }
    public Vector<DocGiaDTO> FindBookByName(String name){
        return empDAL.FindBookByName(name);
    }
    public Vector<DocGiaDTO> ChiTietSach(String id){
        return empDAL.ChiTietSach(id);
    }
}
