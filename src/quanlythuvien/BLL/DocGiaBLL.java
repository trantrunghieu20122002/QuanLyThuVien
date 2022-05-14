package quanlythuvien.BLL;
import quanlythuvien.DTO.DocGiaDTO;
import quanlythuvien.DAL.DocGiaDAL;
import quanlythuvien.DTO.SachDTO;

import javax.print.Doc;
import java.util.Vector;

public class DocGiaBLL {
    DocGiaDAL docgiaDAL = new DocGiaDAL();
    DocGiaDTO doc = new DocGiaDTO();

    public Vector<DocGiaDTO> getAllDocGia() {
        return docgiaDAL.getAllDocGia();
    }
    public Vector<DocGiaDTO> FindUserByName(String name){
        return docgiaDAL.FindUserByName(name);
    }
    public Vector<DocGiaDTO> getAllTaiKhoan() {
        return docgiaDAL.getAllTaiKhoan();
    }
    public String addDocGia(DocGiaDTO doc) {
        if (docgiaDAL.hasMaDocGia(doc.getMaDocGia()))
            return "Mã độc giả đã tồn tại";
        if (docgiaDAL.addDocGia(doc)) {
            return "Thêm thành công";
        }
        return "Thêm thất bại";
    }

    public String editDocGia(String name, String birthday, String sex, String email, String phone, String id){
        docgiaDAL.editDocGia( name,  birthday,  sex,  email,  phone,  id);
            return "Sửa thành công";
    }
    public String deleteDocGia(String id) {
        docgiaDAL.deleteDocGia(id);
            return "Xóa thành công";

        }
//        return  "Xóa thất bại";
//    }

    
    public DocGiaDTO getIdDocGia(String id){
        return docgiaDAL.getIdDocGia(id);
    }


//    public String deleteDocGia(DocGiaDTO doc){
//        if (!docgiaDAL.hasMaDocGia(doc.getMaDocGia()))
//            return "Mã độc giả không tồn tại";
//
//    }

}
