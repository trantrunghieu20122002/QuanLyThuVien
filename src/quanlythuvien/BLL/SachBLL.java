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
    
    public String addBook(SachDTO book) {
        String s = "Thêm thất bại";
        if (empDAL.hasBookId(book.getSach_id())) {
            s = "Mã sách đã tồn tại";
        } else if (empDAL.addBook(book)){
            s = "Thêm thành công";
        } 
        return s;
    }
}
