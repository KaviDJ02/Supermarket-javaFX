package com.ijse.supermarket2.controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.Alert;
import javafx.scene.layout.AnchorPane;

import java.io.IOException;

public class MainViewController {
    @FXML
    private AnchorPane Content;

    @FXML
    void navigateCustomerOnAction(ActionEvent event) {
        navigateTo("/view/CustomerView.fxml");
    }
//    @FXML
//    void navigateItemOnAction(ActionEvent event) {
//        navigateTo("/view/ItemView.fxml");
//    }
    @FXML
    void navigateOrdersOnAction(ActionEvent event) {
        navigateTo("/view/OrdersView.fxml");
    }
    private void navigateTo(String fxmlPath) {
        try {
            Content.getChildren().clear();
            AnchorPane load = FXMLLoader.load(getClass().getResource(fxmlPath));
            Content.getChildren().add(load);
        } catch (IOException e) {
            e.printStackTrace();
            new Alert(Alert.AlertType.ERROR, "Fail to load ui !").show();
        }
    }
}
