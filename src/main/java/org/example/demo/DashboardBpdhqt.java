package org.example.demo;

import javafx.fxml.FXML;
import javafx.scene.control.Button;

public class DashboardBpdhqt {
    // Khai báo các biến FXML (ví dụ, các button, textfield, v.v.)
    @FXML
    private Button someButton;

    @FXML
    private void initialize() {
        // Cấu hình khởi tạo, ví dụ: sự kiện click cho button
        someButton.setOnAction(event -> handleButtonAction());
    }

    private void handleButtonAction() {
        // Xử lý cho sự kiện click button
        System.out.println("Button clicked!");
    }
}
