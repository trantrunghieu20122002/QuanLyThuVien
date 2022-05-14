package quanlythuvien.DTO;

import java.sql.Date;

public class PhieuMuonDTO {
    private String MaPhieuMuon;
    private String NgayMuon;
    private int SoNgayMuon;
    private String MaDocGia;
    private String MaNhanVien;
    private String GhiChu;
    private int TrangThai;
    private String MaSach;
    private String NgayThucTra;
    private float TienPhat;
    private int TinhTrangSach;

    public String getMaPhieuMuon() {
        return MaPhieuMuon;
    }

    public void setMaPhieuMuon(String MaPhieuMuon) {
        this.MaPhieuMuon = MaPhieuMuon;
    }

    public String getNgayMuon() {
        return NgayMuon;
    }

    public void setNgayMuon(String NgayMuon) {
        this.NgayMuon = NgayMuon;
    }

    public int getSoNgayMuon() {
        return SoNgayMuon;
    }

    public void setSoNgayMuon(int SoNgayMuon) {
        this.SoNgayMuon = SoNgayMuon;
    }

    public String getMaDocGia() {
        return MaDocGia;
    }

    public void setMaDocGia(String MaDocGia) {
        this.MaDocGia = MaDocGia;
    }

    public String getMaNhanVien() {
        return MaNhanVien;
    }

    public void setMaNhanVien(String MaNhanVien) {
        this.MaNhanVien = MaNhanVien;
    }

    public String getGhiChu() {
        return GhiChu;
    }

    public void setGhiChu(String GhiChu) {
        this.GhiChu = GhiChu;
    }

    public int getTrangThai() {
        return TrangThai;
    }

    public void setTrangThai(int TrangThai) {
        this.TrangThai = TrangThai;
    }

    public String getMaSach() {
        return MaSach;
    }

    public void setMaSach(String MaSach) {
        this.MaSach = MaSach;
    }

    public String getNgayThucTra() {
        return NgayThucTra;
    }

    public void setNgayThucTra(String NgayThucTra) {
        this.NgayThucTra = NgayThucTra;
    }

    public float getTienPhat() {
        return TienPhat;
    }

    public void setTienPhat(float TienPhat) {
        this.TienPhat = TienPhat;
    }

    public int getTinhTrangSach() {
        return TinhTrangSach;
    }

    public void setTinhTrangSach(int TinhTrangSach) {
        this.TinhTrangSach = TinhTrangSach;
    }
}
