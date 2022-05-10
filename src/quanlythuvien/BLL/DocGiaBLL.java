package quanlythuvien.BLL;
import quanlythuvien.DTO.DocGiaDTO;
import quanlythuvien.DAL.DocGiaDAL;

import java.util.Vector;

public class DocGiaBLL {
    DocGiaDAL docgiaDAL = new DocGiaDAL();

    public Vector<DocGiaDTO> getAllDocGia() {
        return docgiaDAL.getAllDocGia();
    }

    public String addDocGia(DocGiaDTO doc) {
        if (docgiaDAL.hasMaDocGia(doc.getMaDocGia()))
            return "Mã độc giả đã tồn tại";
        if (docgiaDAL.addDocGia(doc)) {
            return "Thêm thành công";
        }
        return "Thêm thất bại";
    }

    public String deleteDocGia(DocGiaDTO doc) {
        if (docgiaDAL.hasMaDocGia(doc.getMaDocGia()))
            return "Mã độc giả không tồn tại";
        if (docgiaDAL.deleteDocGia()) {
            return "Xóa thành công";
        }
        return  "Xóa thất bại";
    }
}
