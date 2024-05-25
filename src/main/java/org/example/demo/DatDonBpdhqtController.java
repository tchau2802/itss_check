package org.example.demo;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;

public class DatDonBpdhqtController {

    @FXML
    private ComboBox<String> siteComboBox;

    @FXML
    private TableView<ChiTietMatHangBpdhqt> datDonTableView;

    @FXML
    private TableColumn<ChiTietMatHangBpdhqt, String> colTenSanPham;

    @FXML
    private TableColumn<ChiTietMatHangBpdhqt, String> colMaHang;

    @FXML
    private TableColumn<ChiTietMatHangBpdhqt, Integer> colSoLuong;

    @FXML
    private TableColumn<ChiTietMatHangBpdhqt, String> colVanChuyen;

    @FXML
    private TableColumn<ChiTietMatHangBpdhqt, String> colTongTien;

    private ObservableList<ChiTietMatHangBpdhqt> cartItems;

    @FXML
    public void initialize() {
        cartItems = CartManager.getInstance().getCartItems();

        colTenSanPham.setCellValueFactory(new PropertyValueFactory<>("tenHang"));
        colMaHang.setCellValueFactory(new PropertyValueFactory<>("maHang"));
        colSoLuong.setCellValueFactory(new PropertyValueFactory<>("soLuong"));
        colVanChuyen.setCellValueFactory(new PropertyValueFactory<>("phuongThuc"));
        colTongTien.setCellValueFactory(new PropertyValueFactory<>("tongTien"));

        datDonTableView.setItems(cartItems);

        siteComboBox.setItems(FXCollections.observableArrayList("Site A", "Site B", "Site C"));
        siteComboBox.getSelectionModel().selectedItemProperty().addListener((observable, oldValue, newValue) -> filterBySite(newValue));
    }

    private void filterBySite(String site) {
        ObservableList<ChiTietMatHangBpdhqt> filteredItems = FXCollections.observableArrayList();
        for (ChiTietMatHangBpdhqt item : cartItems) {
            if (item.getThuocSite().equals(site)) {
                filteredItems.add(item);
            }
        }
        datDonTableView.setItems(filteredItems);
    }

    public void updateCartView() {
        cartItems = CartManager.getInstance().getCartItems();
        datDonTableView.setItems(cartItems);
    }
}
