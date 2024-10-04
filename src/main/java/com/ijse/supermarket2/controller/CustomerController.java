package com.ijse.supermarket2.controller;

import com.ijse.supermarket2.DbConnection.DataBaseConnection;
import com.ijse.supermarket2.dto.CustomerData;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class CustomerController {

    @FXML
    private TableColumn<CustomerData, String> CIDColumn;

    @FXML
    private TextField CIDLabel;

    @FXML
    private AnchorPane CustomerAnchorpane;

    @FXML
    private TableColumn<CustomerData, String> EmailColumn;

    @FXML
    private TextField EmailTextbox;

    @FXML
    private Button GenerateReportButton;

    @FXML
    private TableColumn<CustomerData, String> NICColumn;

    @FXML
    private TextField NICTextbox;

    @FXML
    private TableColumn<CustomerData, String> NameColumn;

    @FXML
    private TextField NameTextbox;

    @FXML
    private TableColumn<CustomerData, String> PhoneColumn;

    @FXML
    private TextField PhoneTextbox;

    @FXML
    private Button ResetButton;

    @FXML
    private Button SaveButton;

    @FXML
    private Button UpdateButton;

    @FXML
    private TableView<CustomerData> customerTable;

    private Connection connection;

    DataBaseConnection db = new DataBaseConnection();

    public void initialize() {
        connectDatabase();
        setupTable();
        loadCustomers();
    }

    private void connectDatabase() {
        try {
            connection = db.getConnection();
        } catch (SQLException e) {
            e.printStackTrace();
            System.err.println("Failed to establish database connection: " + e.getMessage());
        }
    }

    private void setupTable() {
        CIDColumn.setCellValueFactory(new PropertyValueFactory<>("customerId"));
        NameColumn.setCellValueFactory(new PropertyValueFactory<>("name"));
        NICColumn.setCellValueFactory(new PropertyValueFactory<>("nic"));
        EmailColumn.setCellValueFactory(new PropertyValueFactory<>("email"));
        PhoneColumn.setCellValueFactory(new PropertyValueFactory<>("phone"));
    }

    private void loadCustomers() {
        ObservableList<CustomerData> customers = FXCollections.observableArrayList();
        try {
            ResultSet rs = connection.createStatement().executeQuery("SELECT * FROM Customer");
            while (rs.next()) {
                customers.add(new CustomerData(rs.getString("customer_id"), rs.getString("name"), rs.getString("nic"), rs.getString("email"), rs.getString("phone")));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        customerTable.setItems(customers);
    }

    @FXML
    void onDeleteButtonAction(ActionEvent event) {
        String customerId = CIDLabel.getText();
        try {
            PreparedStatement ps = connection.prepareStatement("DELETE FROM Customer WHERE customer_id = ?");
            ps.setString(1, customerId);
            ps.executeUpdate();
            loadCustomers();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @FXML
    void onGenerateReportButtonAction(ActionEvent event) {
        // Handle generate report button action
    }

    @FXML
    void onResetButtonAction(ActionEvent event) {
        NameTextbox.clear();
        NICTextbox.clear();
        EmailTextbox.clear();
        PhoneTextbox.clear();
    }

    @FXML
    void onSaveButtonAction(ActionEvent event) {
        String customerId = CIDLabel.getText();
        String name = NameTextbox.getText();
        String nic = NICTextbox.getText();
        String email = EmailTextbox.getText();
        String phone = PhoneTextbox.getText();

        try {
            PreparedStatement ps = connection.prepareStatement("INSERT INTO Customer (customer_id, name, nic, email, phone) VALUES (?, ?, ?, ?, ?)");
            ps.setString(1, customerId);
            ps.setString(2, name);
            ps.setString(3, nic);
            ps.setString(4, email);
            ps.setString(5, phone);
            ps.executeUpdate();
            loadCustomers();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @FXML
    void onUpdateButtonAction(ActionEvent event) {
        String customerId = CIDLabel.getText();
        String name = NameTextbox.getText();
        String nic = NICTextbox.getText();
        String email = EmailTextbox.getText();
        String phone = PhoneTextbox.getText();

        try {
            PreparedStatement ps = connection.prepareStatement("UPDATE Customer SET name = ?, nic = ?, email = ?, phone = ? WHERE customer_id = ?");
            ps.setString(1, name);
            ps.setString(2, nic);
            ps.setString(3, email);
            ps.setString(4, phone);
            ps.setString(5, customerId);
            ps.executeUpdate();
            loadCustomers();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}