package org.example.demo;

public class ChiTietMatHangBpdhqt {
    private String maHang;
    private String tenHang;
    private String loai;
    private String thuocSite;
    private String giaTien;
    private String thoiGianGiao;
    private String datHang;

    public ChiTietMatHangBpdhqt(String maHang, String tenHang, String loai, String thuocSite, String giaTien, String thoiGianGiao, String datHang) {
        this.maHang = maHang;
        this.tenHang = tenHang;
        this.loai = loai;
        this.thuocSite = thuocSite;
        this.giaTien = giaTien;
        this.thoiGianGiao = thoiGianGiao;
        this.datHang = datHang;
    }

    public String getMaHang() {
        return maHang;
    }

    public void setMaHang(String maHang) {
        this.maHang = maHang;
    }

    public String getTenHang() {
        return tenHang;
    }

    public void setTenHang(String tenHang) {
        this.tenHang = tenHang;
    }

    public String getLoai() {
        return loai;
    }

    public void setLoai(String loai) {
        this.loai = loai;
    }

    public String getThuocSite() {
        return thuocSite;
    }

    public void setThuocSite(String thuocSite) {
        this.thuocSite = thuocSite;
    }

    public String getGiaTien() {
        return giaTien;
    }

    public void setGiaTien(String giaTien) {
        this.giaTien = giaTien;
    }

    public String getThoiGianGiao() {
        return thoiGianGiao;
    }

    public void setThoiGianGiao(String thoiGianGiao) {
        this.thoiGianGiao = thoiGianGiao;
    }

    public String getDatHang() {
        return datHang;
    }

    public void setDatHang(String datHang) {
        this.datHang = datHang;
    }
}
