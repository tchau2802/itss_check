package org.example.demo;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.stage.Stage;

import java.io.IOException;

public class DashboardBpdhqtController {
    @FXML
    private Label welcomeLabel;

    @FXML
    public void initialize() {
//        welcomeLabel.setText("Chào mừng đến với trang Dashboard của Bộ phận đặt hàng quốc tế");
    }

    @FXML
    public void handleTrangChu() {
        loadFXML("/org/example/demo/DashboardBpdhqt.fxml");
    }

    private void loadFXML(String fxmlFilePath) {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource(fxmlFilePath));
            Parent root = loader.load();
            Stage stage = new Stage();
            stage.setScene(new Scene(root));
            stage.show();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
