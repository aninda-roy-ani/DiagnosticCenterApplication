/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package myjava;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import java.util.Scanner;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;
import javas.Admin;
import javas.EmployeeType;

/**
 * FXML Controller class
 *
 * @author Dell
 */
public class SalaryDataFXMLController implements Initializable {

    @FXML
    private TableView<EmployeeType> table;
    @FXML
    private TableColumn<EmployeeType, String> emloyee;
    @FXML
    private TableColumn<EmployeeType, String> salary;
    @FXML
    private ComboBox<String> empCB;
    @FXML
    private TextField salaryTF;

    ObservableList<EmployeeType> emps = FXCollections.observableArrayList();
    ObservableList<String> types = FXCollections.observableArrayList("Supervisor", "Doctor", "Accountant", "Nurse");
    @FXML
    private Button updateBtn;
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO\
        empCB.setItems(types);
        emloyee.setCellValueFactory(new PropertyValueFactory<EmployeeType,String>("desig"));
        salary.setCellValueFactory(new PropertyValueFactory<EmployeeType,String>("salary"));
        File f = new File("SalaryData.txt");
        Scanner s = null;
        String str = "";
        
        try {
            s = new Scanner(f);
            while(s.hasNextLine()){
                str = s.nextLine();               
                String[] str_split = str.split("#");
                EmployeeType emp = new EmployeeType(str_split[0], str_split[1]);
                emps.add(emp);
            }
        } catch (FileNotFoundException ex) {
            
        }
                    
        table.setItems(emps);
    }  

    @FXML
    private void addToTableAction(ActionEvent event) throws IOException {
        Admin admin = new Admin("admin");
        //System.out.println("hello1");
        admin.showAndEditSalaryData(empCB.getValue(), salaryTF.getText());
        Stage stage = (Stage) updateBtn.getScene().getWindow();  
        stage.close();
        Parent pane = FXMLLoader.load(getClass().getResource("SalaryDataFXML.fxml"));
        Scene scene = new Scene(pane);       
        stage.setScene(scene);
        stage.show();
    }  

    @FXML
    private void showPieChartAction(ActionEvent event) throws IOException {
        Parent pane = FXMLLoader.load(getClass().getResource("PieChart2FXML.fxml"));
        Scene scene = new Scene(pane);
        Stage stage = new Stage();
        stage.setScene(scene);
        stage.show();
    }

    @FXML
    private void showBarChartAction(ActionEvent event) throws IOException {
        Parent pane = FXMLLoader.load(getClass().getResource("BarChart2FXML.fxml"));
        Scene scene = new Scene(pane);
        Stage stage = new Stage();
        stage.setScene(scene);
        stage.show();
    }

    @FXML
    private void close(ActionEvent event) {
        Stage stage = (Stage) updateBtn.getScene().getWindow();  
        stage.close();
    }
    
}
