/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package myjava;

import java.io.IOException;
import java.net.URL;
import java.util.Arrays;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javas.Accountant;
import javas.Employee;
import javas.User;

/**
 * FXML Controller class
 *
 * @author Dell
 */
public class SalariesFXMLController implements Initializable {
    
    ObservableList<Employee> employee = FXCollections.observableArrayList();
    @FXML
    private TableView<Employee> table;
    @FXML
    private TableColumn<Employee, String> names;
    @FXML
    private TableColumn<Employee, String> salaries;
    @FXML
    private TableColumn<Employee, String> designation;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        String userID = User.findLoggedInID();
        Accountant accountant = new Accountant(userID);
        Employee[] employees = new Employee[99];
        try {
            employees = accountant.getSalaries();
        } catch (IOException ex) {
            Logger.getLogger(SalariesFXMLController.class.getName()).log(Level.SEVERE, null, ex);
        }
        employee.addAll(Arrays.asList(employees));
        
        names.setCellValueFactory(new PropertyValueFactory<Employee,String>("id"));
        salaries.setCellValueFactory(new PropertyValueFactory<Employee,String>("salary"));
        designation.setCellValueFactory(new PropertyValueFactory<Employee,String>("type"));
        
        table.setItems(employee);
    }    

    @FXML
    private void issueSalaryAction(ActionEvent event) throws IOException {
        String userID = User.findLoggedInID();
        Accountant accountant = new Accountant(userID);
        accountant.issueSalaries();
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setHeaderText("Update");
        alert.setContentText("Salaries have been issued.");
        alert.showAndWait();
    }
    
}
