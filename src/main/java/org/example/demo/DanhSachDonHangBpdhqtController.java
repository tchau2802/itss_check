package org.example.demo;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.collections.transformation.FilteredList;
import javafx.collections.transformation.SortedList;
import javafx.fxml.FXML;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;

public class DanhSachDonHangBpdhqtController {

    @FXML
    private TableView<DanhSachDonHangBpdtqt> tableView;

    @FXML
    private TableColumn<DanhSachDonHangBpdtqt, String> colBoPhanYeuCau;

    @FXML
    private TableColumn<DanhSachDonHangBpdtqt, String> colMaHang;

    @FXML
    private TableColumn<DanhSachDonHangBpdtqt, String> colTenHang;

    @FXML
    private TableColumn<DanhSachDonHangBpdtqt, String> colThoiGianGiao;

    @FXML
    private TableColumn<DanhSachDonHangBpdtqt, String> colGiaTien;

    @FXML
    private TextField searchField;

    private ObservableList<DanhSachDonHangBpdtqt> masterData = FXCollections.observableArrayList();

    @FXML
    public void initialize() {
        colBoPhanYeuCau.setCellValueFactory(new PropertyValueFactory<>("boPhanYeuCau"));
        colMaHang.setCellValueFactory(new PropertyValueFactory<>("maHang"));
        colTenHang.setCellValueFactory(new PropertyValueFactory<>("tenHang"));
        colThoiGianGiao.setCellValueFactory(new PropertyValueFactory<>("thoiGianGiao"));
        colGiaTien.setCellValueFactory(new PropertyValueFactory<>("giaTien"));

        masterData.addAll(getItems());

        // Gọi phương thức tìm kiếm
        addSearchFunctionality();
    }

    private void addSearchFunctionality() {
        FilteredList<DanhSachDonHangBpdtqt> filteredData = new FilteredList<>(masterData, p -> true);

        searchField.textProperty().addListener((observable, oldValue, newValue) -> {
            filteredData.setPredicate(item -> {
                if (newValue == null || newValue.isEmpty()) {
                    return true;
                }

                String lowerCaseFilter = newValue.toLowerCase();

                if (item.getBoPhanYeuCau().toLowerCase().contains(lowerCaseFilter)) {
                    return true;
                } else if (item.getMaHang().toLowerCase().contains(lowerCaseFilter)) {
                    return true;
                } else if (item.getTenHang().toLowerCase().contains(lowerCaseFilter)) {
                    return true;
                } else if (item.getThoiGianGiao().toLowerCase().contains(lowerCaseFilter)) {
                    return true;
                } else if (item.getGiaTien().toLowerCase().contains(lowerCaseFilter)) {
                    return true;
                }
                return false;
            });
        });

        SortedList<DanhSachDonHangBpdtqt> sortedData = new SortedList<>(filteredData);
        sortedData.comparatorProperty().bind(tableView.comparatorProperty());

        tableView.setItems(sortedData);
    }

    private ObservableList<DanhSachDonHangBpdtqt> getItems() {
        ObservableList<DanhSachDonHangBpdtqt> items = FXCollections.observableArrayList();
        items.add(new DanhSachDonHangBpdtqt("Bộ phận Kế toán", "KT001", "Máy tính xách tay", "01-01-2023", "15000000"));
        items.add(new DanhSachDonHangBpdtqt("Bộ phận Nhân sự", "NS002", "Bàn làm việc", "05-01-2023", "2500000"));
        items.add(new DanhSachDonHangBpdtqt("Bộ phận IT", "IT003", "Máy chủ", "10-01-2023", "50000000"));
        items.add(new DanhSachDonHangBpdtqt("Bộ phận Kinh doanh", "KD004", "Điện thoại di động", "15-01-2023", "10000000"));
        items.add(new DanhSachDonHangBpdtqt("Bộ phận Kế hoạch", "KH005", "Máy in", "20-01-2023", "7000000"));
        items.add(new DanhSachDonHangBpdtqt("Bộ phận Mua sắm", "MS006", "Ghế xoay văn phòng", "25-01-2023", "1500000"));
        items.add(new DanhSachDonHangBpdtqt("Bộ phận Sản xuất", "SX007", "Nguyên liệu sản xuất", "30-01-2023", "20000000"));
        items.add(new DanhSachDonHangBpdtqt("Bộ phận Kho vận", "KV008", "Xe nâng", "05-02-2023", "30000000"));
        items.add(new DanhSachDonHangBpdtqt("Bộ phận R&D", "RD009", "Thiết bị nghiên cứu", "10-02-2023", "40000000"));
        items.add(new DanhSachDonHangBpdtqt("Bộ phận Bán lẻ", "BL010", "Sản phẩm trưng bày", "15-02-2023", "5000000"));
        items.add(new DanhSachDonHangBpdtqt("Bộ phận Tài chính", "TC011", "Phần mềm kế toán", "20-02-2023", "8000000"));
        items.add(new DanhSachDonHangBpdtqt("Bộ phận Marketing", "MK012", "Poster quảng cáo", "25-02-2023", "3000000"));
        items.add(new DanhSachDonHangBpdtqt("Bộ phận Dịch vụ khách hàng", "DV013", "Máy fax", "02-03-2023", "2000000"));
        items.add(new DanhSachDonHangBpdtqt("Bộ phận Bảo trì", "BT014", "Thiết bị sửa chữa", "07-03-2023", "6000000"));
        items.add(new DanhSachDonHangBpdtqt("Bộ phận Hành chính", "HC015", "Văn phòng phẩm", "12-03-2023", "1000000"));

        return items;
    }
}
