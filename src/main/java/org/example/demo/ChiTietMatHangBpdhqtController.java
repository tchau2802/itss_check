package org.example.demo;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.collections.transformation.FilteredList;
import javafx.collections.transformation.SortedList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;

import java.io.IOException;

public class ChiTietMatHangBpdhqtController {

    @FXML
    private TableView<ChiTietMatHangBpdhqt> tableView;

    @FXML
    private TableColumn<ChiTietMatHangBpdhqt, String> colMaHang;

    @FXML
    private TableColumn<ChiTietMatHangBpdhqt, String> colTenHang;

    @FXML
    private TableColumn<ChiTietMatHangBpdhqt, String> colLoai;

    @FXML
    private TableColumn<ChiTietMatHangBpdhqt, String> colThuocSite;

    @FXML
    private TableColumn<ChiTietMatHangBpdhqt, String> colGiaTien;

    @FXML
    private TableColumn<ChiTietMatHangBpdhqt, String> colThoiGianGiao;

    @FXML
    private TableColumn<ChiTietMatHangBpdhqt, String> colDatHang;

    @FXML
    private TextField searchFieldID;

    @FXML
    private TextField searchFieldSite;

    private ObservableList<ChiTietMatHangBpdhqt> masterData = FXCollections.observableArrayList();

    @FXML
    public void initialize() {
        colMaHang.setCellValueFactory(new PropertyValueFactory<>("maHang"));
        colTenHang.setCellValueFactory(new PropertyValueFactory<>("tenHang"));
        colLoai.setCellValueFactory(new PropertyValueFactory<>("loai"));
        colThuocSite.setCellValueFactory(new PropertyValueFactory<>("thuocSite"));
        colGiaTien.setCellValueFactory(new PropertyValueFactory<>("giaTien"));
        colThoiGianGiao.setCellValueFactory(new PropertyValueFactory<>("thoiGianGiao"));
        colDatHang.setCellValueFactory(new PropertyValueFactory<>("phuongThuc"));

        masterData.addAll(getItems());

        // Thiết lập chức năng tìm kiếm
        addSearchFunctionality();

        // Add double-click event handler
        tableView.setRowFactory(tv -> {
            TableRow<ChiTietMatHangBpdhqt> row = new TableRow<>();
            row.setOnMouseClicked(event -> {
                if (event.getClickCount() == 2 && (!row.isEmpty())) {
                    ChiTietMatHangBpdhqt rowData = row.getItem();
                    showProductDetails(rowData);
                }
            });
            return row;
        });
    }

    private void addSearchFunctionality() {
        FilteredList<ChiTietMatHangBpdhqt> filteredData = new FilteredList<>(masterData, p -> true);

        searchFieldID.textProperty().addListener((observable, oldValue, newValue) -> updateFilter(filteredData));
        searchFieldSite.textProperty().addListener((observable, oldValue, newValue) -> updateFilter(filteredData));

        SortedList<ChiTietMatHangBpdhqt> sortedData = new SortedList<>(filteredData);
        sortedData.comparatorProperty().bind(tableView.comparatorProperty());

        tableView.setItems(sortedData);
    }

    private void updateFilter(FilteredList<ChiTietMatHangBpdhqt> filteredData) {
        String searchID = searchFieldID.getText().toLowerCase();
        String searchSite = searchFieldSite.getText().toLowerCase();

        filteredData.setPredicate(item -> {
            boolean matchesID = searchID.isEmpty() || item.getMaHang().toLowerCase().contains(searchID);
            boolean matchesSite = searchSite.isEmpty() || item.getThuocSite().toLowerCase().contains(searchSite);
            return matchesID && matchesSite;
        });
    }

    private ObservableList<ChiTietMatHangBpdhqt> getItems() {
        ObservableList<ChiTietMatHangBpdhqt> items = FXCollections.observableArrayList();
        items.add(new ChiTietMatHangBpdhqt("KT001", "Máy tính xách tay", "Điện tử", "Site A", "15000000", "01-01-2023", "Đặt hàng", 1));
        items.add(new ChiTietMatHangBpdhqt("NS002", "Bàn làm việc", "Nội thất", "Site B", "2500000", "05-01-2023", "Đặt hàng", 1));
        items.add(new ChiTietMatHangBpdhqt("IT003", "Máy chủ", "Điện tử", "Site A", "50000000", "10-01-2023", "Đặt hàng", 1));
        items.add(new ChiTietMatHangBpdhqt("KD004", "Điện thoại di động", "Điện tử", "Site C", "10000000", "15-01-2023", "Đặt hàng", 1));
        items.add(new ChiTietMatHangBpdhqt("KH005", "Máy in", "Điện tử", "Site B", "7000000", "20-01-2023", "Đặt hàng", 1));
        items.add(new ChiTietMatHangBpdhqt("MS006", "Ghế xoay văn phòng", "Nội thất", "Site A", "1500000", "25-01-2023", "Đặt hàng", 1));
        items.add(new ChiTietMatHangBpdhqt("SX007", "Nguyên liệu sản xuất", "Công nghiệp", "Site C", "20000000", "30-01-2023", "Đặt hàng", 1));
        items.add(new ChiTietMatHangBpdhqt("KV008", "Xe nâng", "Công nghiệp", "Site B", "30000000", "05-02-2023", "Đặt hàng", 1));
        items.add(new ChiTietMatHangBpdhqt("RD009", "Thiết bị nghiên cứu", "Điện tử", "Site A", "40000000", "10-02-2023", "Đặt hàng", 1));
        items.add(new ChiTietMatHangBpdhqt("BL010", "Sản phẩm trưng bày", "Khác", "Site C", "5000000", "15-02-2023", "Đặt hàng", 1));
        items.add(new ChiTietMatHangBpdhqt("TC011", "Phần mềm kế toán", "Phần mềm", "Site B", "8000000", "20-02-2023", "Đặt hàng", 1));
        items.add(new ChiTietMatHangBpdhqt("MK012", "Poster quảng cáo", "Khác", "Site A", "3000000", "25-02-2023", "Đặt hàng", 1));
        items.add(new ChiTietMatHangBpdhqt("DV013", "Máy fax", "Điện tử", "Site C", "2000000", "02-03-2023", "Đặt hàng", 1));
        items.add(new ChiTietMatHangBpdhqt("BT014", "Thiết bị sửa chữa", "Công nghiệp", "Site B", "6000000", "07-03-2023", "Đặt hàng", 1));
        items.add(new ChiTietMatHangBpdhqt("HC015", "Văn phòng phẩm", "Nội thất", "Site A", "1000000", "12-03-2023", "Đặt hàng", 1));
        return items;
    }

    private void showProductDetails(ChiTietMatHangBpdhqt product) {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/org/example/demo/DatHangBpdhqt.fxml"));
            Parent root = loader.load();

            DatHangBpdhqtController controller = loader.getController();
            if (controller != null) {
                controller.setProductDetails(product);
            }

            Stage stage = new Stage();
            stage.setScene(new Scene(root));
            stage.show();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}


///package org.example.demo;
//
//import javafx.collections.FXCollections;
//import javafx.collections.ObservableList;
//import javafx.collections.transformation.FilteredList;
//import javafx.collections.transformation.SortedList;
//import javafx.fxml.FXML;
//import javafx.fxml.FXMLLoader;
//import javafx.scene.Parent;
//import javafx.scene.Scene;
//import javafx.scene.control.TableColumn;
//import javafx.scene.control.TableView;
//import javafx.scene.control.TextField;
//import javafx.scene.control.cell.PropertyValueFactory;
//import javafx.stage.Stage;
//
//import java.io.IOException;
//
//public class ChiTietMatHangBpdhqtController {
//
//    @FXML
//    private TableView<ChiTietMatHangBpdhqt> tableView;
//
//    @FXML
//    private TableColumn<ChiTietMatHangBpdhqt, String> colMaHang;
//
//    @FXML
//    private TableColumn<ChiTietMatHangBpdhqt, String> colTenHang;
//
//    @FXML
//    private TableColumn<ChiTietMatHangBpdhqt, String> colLoai;
//
//    @FXML
//    private TableColumn<ChiTietMatHangBpdhqt, String> colThuocSite;
//
//    @FXML
//    private TableColumn<ChiTietMatHangBpdhqt, String> colGiaTien;
//
//    @FXML
//    private TableColumn<ChiTietMatHangBpdhqt, String> colThoiGianGiao;
//
//    @FXML
//    private TableColumn<ChiTietMatHangBpdhqt, String> colDatHang;
//
//    @FXML
//    private TextField searchFieldID;
//
//    @FXML
//    private TextField searchFieldSite;
//
//    private ObservableList<ChiTietMatHangBpdhqt> masterData = FXCollections.observableArrayList();
//
//    @FXML
//    public void initialize() {
//        colMaHang.setCellValueFactory(new PropertyValueFactory<>("maHang"));
//        colTenHang.setCellValueFactory(new PropertyValueFactory<>("tenHang"));
//        colLoai.setCellValueFactory(new PropertyValueFactory<>("loai"));
//        colThuocSite.setCellValueFactory(new PropertyValueFactory<>("thuocSite"));
//        colGiaTien.setCellValueFactory(new PropertyValueFactory<>("giaTien"));
//        colThoiGianGiao.setCellValueFactory(new PropertyValueFactory<>("thoiGianGiao"));
//        colDatHang.setCellValueFactory(new PropertyValueFactory<>("datHang"));
//
//        masterData.addAll(getItems());
//
//        // Thiết lập chức năng tìm kiếm
//        addSearchFunctionality();
//
//        // Thiết lập sự kiện double-click để mở chi tiết sản phẩm
//        tableView.setOnMouseClicked(event -> {
//            if (event.getClickCount() == 2 && tableView.getSelectionModel().getSelectedItem() != null) {
//                ChiTietMatHangBpdhqt selectedProduct = tableView.getSelectionModel().getSelectedItem();
//                showProductDetails(selectedProduct);
//            }
//        });
//    }
//
//    private void addSearchFunctionality() {
//        FilteredList<ChiTietMatHangBpdhqt> filteredData = new FilteredList<>(masterData, p -> true);
//
//        searchFieldID.textProperty().addListener((observable, oldValue, newValue) -> updateFilter(filteredData));
//        searchFieldSite.textProperty().addListener((observable, oldValue, newValue) -> updateFilter(filteredData));
//
//        SortedList<ChiTietMatHangBpdhqt> sortedData = new SortedList<>(filteredData);
//        sortedData.comparatorProperty().bind(tableView.comparatorProperty());
//
//        tableView.setItems(sortedData);
//    }
//
//    private void updateFilter(FilteredList<ChiTietMatHangBpdhqt> filteredData) {
//        String searchID = searchFieldID.getText().toLowerCase();
//        String searchSite = searchFieldSite.getText().toLowerCase();
//
//        filteredData.setPredicate(item -> {
//            boolean matchesID = searchID.isEmpty() || item.getMaHang().toLowerCase().contains(searchID);
//            boolean matchesSite = searchSite.isEmpty() || item.getThuocSite().toLowerCase().contains(searchSite);
//            return matchesID && matchesSite;
//        });
//    }
//
//    private ObservableList<ChiTietMatHangBpdhqt> getItems() {
//        ObservableList<ChiTietMatHangBpdhqt> items = FXCollections.observableArrayList();
//        items.add(new ChiTietMatHangBpdhqt("KT001", "Máy tính xách tay", "Điện tử", "Site A", "15000000", "01-01-2023", "Đặt hàng"));
//        items.add(new ChiTietMatHangBpdhqt("NS002", "Bàn làm việc", "Nội thất", "Site B", "2500000", "05-01-2023", "Đặt hàng"));
//        items.add(new ChiTietMatHangBpdhqt("IT003", "Máy chủ", "Điện tử", "Site A", "50000000", "10-01-2023", "Đặt hàng"));
//        items.add(new ChiTietMatHangBpdhqt("KD004", "Điện thoại di động", "Điện tử", "Site C", "10000000", "15-01-2023", "Đặt hàng"));
//        items.add(new ChiTietMatHangBpdhqt("KH005", "Máy in", "Điện tử", "Site B", "7000000", "20-01-2023", "Đặt hàng"));
//        items.add(new ChiTietMatHangBpdhqt("MS006", "Ghế xoay văn phòng", "Nội thất", "Site A", "1500000", "25-01-2023", "Đặt hàng"));
//        items.add(new ChiTietMatHangBpdhqt("SX007", "Nguyên liệu sản xuất", "Công nghiệp", "Site C", "20000000", "30-01-2023", "Đặt hàng"));
//        items.add(new ChiTietMatHangBpdhqt("KV008", "Xe nâng", "Công nghiệp", "Site B", "30000000", "05-02-2023", "Đặt hàng"));
//        items.add(new ChiTietMatHangBpdhqt("RD009", "Thiết bị nghiên cứu", "Điện tử", "Site A", "40000000", "10-02-2023", "Đặt hàng"));
//        items.add(new ChiTietMatHangBpdhqt("BL010", "Sản phẩm trưng bày", "Khác", "Site C", "5000000", "15-02-2023", "Đặt hàng"));
//        items.add(new ChiTietMatHangBpdhqt("TC011", "Phần mềm kế toán", "Phần mềm", "Site B", "8000000", "20-02-2023", "Đặt hàng"));
//        items.add(new ChiTietMatHangBpdhqt("MK012", "Poster quảng cáo", "Khác", "Site A", "3000000", "25-02-2023", "Đặt hàng"));
//        items.add(new ChiTietMatHangBpdhqt("DV013", "Máy fax", "Điện tử", "Site C", "2000000", "02-03-2023", "Đặt hàng"));
//        items.add(new ChiTietMatHangBpdhqt("BT014", "Thiết bị sửa chữa", "Công nghiệp", "Site B", "6000000", "07-03-2023", "Đặt hàng"));
//        items.add(new ChiTietMatHangBpdhqt("HC015", "Văn phòng phẩm", "Nội thất", "Site A", "1000000", "12-03-2023", "Đặt hàng"));
//        return items;
//    }
//
//    private void showProductDetails(ChiTietMatHangBpdhqt product) {
//        try {
//            FXMLLoader loader = new FXMLLoader(getClass().getResource("/org/example/demo/DatHangBpdhqt.fxml"));
//            Parent root = loader.load();
//
//            DatHangBpdhqtController controller = loader.getController();
//            controller.setProductDetails(product);
//
//            Stage stage = new Stage();
//            stage.setScene(new Scene(root));
//            stage.show();
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
//    }
//}
