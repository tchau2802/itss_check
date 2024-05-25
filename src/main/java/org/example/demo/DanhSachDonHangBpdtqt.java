package org.example.demo;

public class DanhSachDonHangBpdtqt {
    private String boPhanYeuCau;
    private String maHang;
    private String tenHang;
    private String thoiGianGiao;
    private String giaTien;

    public DanhSachDonHangBpdtqt(String boPhanYeuCau, String maHang, String tenHang, String thoiGianGiao, String giaTien) {
        this.boPhanYeuCau = boPhanYeuCau;
        this.maHang = maHang;
        this.tenHang = tenHang;
        this.thoiGianGiao = thoiGianGiao;
        this.giaTien = giaTien;
    }

    public String getBoPhanYeuCau() {
        return boPhanYeuCau;
    }

    public void setBoPhanYeuCau(String boPhanYeuCau) {
        this.boPhanYeuCau = boPhanYeuCau;
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

    public String getThoiGianGiao() {
        return thoiGianGiao;
    }

    public void setThoiGianGiao(String thoiGianGiao) {
        this.thoiGianGiao = thoiGianGiao;
    }

    public String getGiaTien() {
        return giaTien;
    }

    public void setGiaTien(String giaTien) {
        this.giaTien = giaTien;
    }
}
