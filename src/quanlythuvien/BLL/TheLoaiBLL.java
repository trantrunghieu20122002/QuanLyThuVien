/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package quanlythuvien.BLL;

import java.util.Vector;
import quanlythuvien.DAL.TheLoaiDAL;
import quanlythuvien.DTO.TheLoaiDTO;

/**
 *
 * @author huyga
 */
public class TheLoaiBLL {
    
    TheLoaiDAL theLoaiDAL = new TheLoaiDAL();
    
    public Vector<TheLoaiDTO> getAllTL(){
        return theLoaiDAL.getAllTL();
    }
    
    public String addTL(TheLoaiDTO tl) {
        if (theLoaiDAL.hasMaTL(tl.getMaTheLoai())) {
            return "Mã thể loại đã tồn tại";
        }
        if (theLoaiDAL.addTL(tl)) {
            return "Thêm thành công";
        }
        return "Thêm thất bại";
    }
    
    public String deleteTL(TheLoaiDTO tl) {
        if (!theLoaiDAL.hasMaTL(tl.getMaTheLoai())) {
            return "Mã thể loại không tồn tại!";
        }
        if (theLoaiDAL.deleteTL(tl)) {
            return "Xóa thành công";
        }
        return "Xóa thất bại";
    }
    
    public String updateTL(TheLoaiDTO tl) {
        if (!theLoaiDAL.hasMaTL(tl.getMaTheLoai())) {
            
        }
        return "Sửa thất bại";
    }
    
}
