package org.example.demo;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.Spinner;
import javafx.scene.control.SpinnerValueFactory;
import javafx.stage.Stage;

import java.io.IOException;

public class DatHangBpdhqtController {

    @FXML
    private Label maHangLabel;

    @FXML
    private Label tenHangLabel;

    @FXML
    private Label giaLabel;

    @FXML
    private Label siteLabel;

    @FXML
    private Label thoiGianDuKienLabel;

    @FXML
    private ComboBox<String> phuongThucComboBox;

    @FXML
    private Spinner<Integer> soLuongSpinner;

    private ChiTietMatHangBpdhqt currentProduct;

    @FXML
    public void initialize() {
        phuongThucComboBox.getItems().addAll("Đường thủy", "Đường hàng không", "Đường bộ");

        SpinnerValueFactory<Integer> valueFactory = new SpinnerValueFactory.IntegerSpinnerValueFactory(1, 100, 1);
        soLuongSpinner.setValueFactory(valueFactory);
    }

    public void setProductDetails(ChiTietMatHangBpdhqt product) {
        currentProduct = product;
        maHangLabel.setText(product.getMaHang());
        tenHangLabel.setText(product.getTenHang());
        giaLabel.setText(product.getGiaTien());
        siteLabel.setText(product.getThuocSite());
        thoiGianDuKienLabel.setText(product.getThoiGianGiao());
    }

    @FXML
    public void handleAddToCart() {
        if (currentProduct != null) {
            int soLuong = soLuongSpinner.getValue();
            String phuongThuc = phuongThucComboBox.getValue();

            ChiTietMatHangBpdhqt cartItem = new ChiTietMatHangBpdhqt(
                    currentProduct.getMaHang(),
                    currentProduct.getTenHang(),
                    currentProduct.getLoai(),
                    currentProduct.getThuocSite(),
                    currentProduct.getGiaTien(),
                    currentProduct.getThoiGianGiao(),
                    phuongThuc
            );

            CartManager.getInstance().addToCart(cartItem);

            // Chuyển về trang DatDonBpdhqt.fxml
            try {
                FXMLLoader loader = new FXMLLoader(getClass().getResource("/org/example/demo/DatDonBpdhqt.fxml"));
                Parent root = loader.load();

                Stage stage = (Stage) maHangLabel.getScene().getWindow();
                stage.setScene(new Scene(root));
                stage.show();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    @FXML
    public void closeWindow() {
        Stage stage = (Stage) maHangLabel.getScene().getWindow();
        stage.close();
    }
}
