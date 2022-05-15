/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package quanlythuvien.BLL;

import java.util.Vector;
import quanlythuvien.DAL.DanhMucDAL;
import quanlythuvien.DTO.DanhMucDTO;

/**
 *
 * @author huyga
 */
public class DanhMucBLL {
        
    DanhMucDAL danhMucDAL = new DanhMucDAL();
    
    public Vector<DanhMucDTO> getAllDM(){
        return danhMucDAL.getAllDM();
    }
    
    public Vector<DanhMucDTO> getDMByName(String name) {
        return danhMucDAL.getDMByName(name);
    }
    
    public String addDM(DanhMucDTO dm) {
        if (danhMucDAL.hasMaDM(dm.getMaDM())) {
            return "Mã thể loại đã tồn tại";
        }
        if (danhMucDAL.addDM(dm)) {
            return "Thêm thành công";
        }
        return "Thêm thất bại";
    }
    
    public String deleteDM(DanhMucDTO dm) {
        if (danhMucDAL.deleteDM(dm)) {
            return "Xóa thành công";
        }
        return "Xóa thất bại";
    }
    
    public String updateDM(DanhMucDTO dm) {
        if (danhMucDAL.updateDM(dm)) {
            return "Sửa thành công";
        }
        return "Sửa thất bại";
    }

}
