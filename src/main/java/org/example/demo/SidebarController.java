package org.example.demo;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class SidebarController {

    @FXML
    private void handleTrangChu() {
        // Xử lý chuyển đến trang chủ
        loadPage("/org/example/demo/DashboardBpdhqt.fxml", "Trang chủ");
    }

    @FXML
    private void handleDonDatHang() {
        // Xử lý chuyển đến trang đơn đặt hàng
        loadPage("/org/example/demo/DanhSachDonHangBpdhqt.fxml", "Danh sách đơn hàng");
    }

    @FXML
    private void handleSanPham() {
        // Xử lý chuyển đến trang sản phẩm
        loadPage("/org/example/demo/ChiTietMatHangBpdhqt.fxml", "Chi tiết mặt hàng");
    }

    @FXML
    private void handleDonHang() {
        // Xử lý chuyển đến trang đơn hàng
        loadPage("/org/example/demo/DatDonBpdhqt.fxml", "Đặt đơn hàng");
    }

    @FXML
    private void handleTaiKhoan() {
        // Xử lý chuyển đến trang tài khoản
        // Implement your logic here
    }

    @FXML
    private void handleCaiDat() {
        // Xử lý chuyển đến trang cài đặt
        // Implement your logic here
    }

    @FXML
    private void handleTroGiup() {
        // Xử lý chuyển đến trang trợ giúp
        // Implement your logic here
    }

    @FXML
    private void handleDangXuat() {
        // Xử lý đăng xuất
        // Implement your logic here
    }

    private void loadPage(String fxmlPath, String title) {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource(fxmlPath));
            Parent root = loader.load();

            Stage stage = new Stage();
            stage.setScene(new Scene(root));
            stage.setTitle(title);
            stage.show();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
