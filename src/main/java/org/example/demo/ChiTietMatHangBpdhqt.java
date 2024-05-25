package org.example.demo;

public class ChiTietMatHangBpdhqt {

    private String maHang;
    private String tenHang;
    private String loai;
    private String thuocSite;
    private String giaTien;
    private String thoiGianGiao;
    private String phuongThuc;
    private int soLuong;

    public ChiTietMatHangBpdhqt(String maHang, String tenHang, String loai, String thuocSite, String giaTien, String thoiGianGiao, String phuongThuc, int soLuong) {
        this.maHang = maHang;
        this.tenHang = tenHang;
        this.loai = loai;
        this.thuocSite = thuocSite;
        this.giaTien = giaTien;
        this.thoiGianGiao = thoiGianGiao;
        this.phuongThuc = phuongThuc;
        this.soLuong = soLuong;
    }

    // Getters and setters

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

    public String getPhuongThuc() {
        return phuongThuc;
    }

    public void setPhuongThuc(String phuongThuc) {
        this.phuongThuc = phuongThuc;
    }

    public int getSoLuong() {
        return soLuong;
    }

    public void setSoLuong(int soLuong) {
        this.soLuong = soLuong;
    }

    public String getTongTien() {
        // Assuming that the total price is calculated by multiplying price by quantity
        return String.valueOf(Integer.parseInt(giaTien) * soLuong);
    }
}
