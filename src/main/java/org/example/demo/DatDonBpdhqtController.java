package org.example.demo;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.collections.transformation.FilteredList;
import javafx.collections.transformation.SortedList;
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
        colTenSanPham.setCellValueFactory(new PropertyValueFactory<>("tenHang"));
        colMaHang.setCellValueFactory(new PropertyValueFactory<>("maHang"));
        colSoLuong.setCellValueFactory(new PropertyValueFactory<>("soLuong"));
        colVanChuyen.setCellValueFactory(new PropertyValueFactory<>("phuongThuc"));
        colTongTien.setCellValueFactory(new PropertyValueFactory<>("tongTien"));

        cartItems = CartManager.getInstance().getCartItems();
        datDonTableView.setItems(cartItems);

        siteComboBox.setItems(FXCollections.observableArrayList("Site A", "Site B", "Site C"));
        siteComboBox.getSelectionModel().selectedItemProperty().addListener((observable, oldValue, newValue) -> filterBySite(newValue));
    }

    public void updateTableView() {
        datDonTableView.refresh();
    }

    public void setSiteInComboBox(String site) {
        siteComboBox.getSelectionModel().select(site);
    }

    private void filterBySite(String site) {
        if (site == null || site.isEmpty()) {
            datDonTableView.setItems(cartItems);
        } else {
            FilteredList<ChiTietMatHangBpdhqt> filteredItems = new FilteredList<>(cartItems, item -> site.equals(item.getThuocSite()));
            datDonTableView.setItems(new SortedList<>(filteredItems));
        }
    }
}
