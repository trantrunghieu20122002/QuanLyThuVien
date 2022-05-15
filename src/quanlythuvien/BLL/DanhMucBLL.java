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
        
    DanhMucDAL theLoaiDAL = new DanhMucDAL();
    
    public Vector<DanhMucDTO> getAllDM(){
        return theLoaiDAL.getAllDM();
    }
    
    public String addDM(DanhMucDTO dm) {
        if (theLoaiDAL.hasMaDM(dm.getMaDM())) {
            return "Mã thể loại đã tồn tại";
        }
        if (theLoaiDAL.addDM(dm)) {
            return "Thêm thành công";
        }
        return "Thêm thất bại";
    }
    
    public String deleteDM(DanhMucDTO dm) {
        if (theLoaiDAL.deleteDM(dm)) {
            return "Xóa thành công";
        }
        return "Xóa thất bại";
    }
    
    public String updateDM(DanhMucDTO dm) {
        if (theLoaiDAL.updateDM(dm)) {
            return "Sửa thành công";
        }
        return "Sửa thất bại";
    }

}
