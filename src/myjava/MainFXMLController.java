/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package myjava;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Menu;
import javafx.scene.control.MenuItem;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import javas.Accountant;
import javas.Admin;
import javas.Doctor;
import javas.Patient;
import javas.Supervisor;
import javas.User;

/**
 *
 * @author Dell
 */
public class MainFXMLController implements Initializable {
    
    ObservableList<String> types = FXCollections.observableArrayList("Admin", "Doctor", "Patient", "Accountant", "Supervisor");
    @FXML
    private MenuItem exitBtn;
    @FXML
    private TextField id;
    @FXML
    private TextField password;
    @FXML
    private ComboBox<String> typeCB;
    @FXML
    private Button loginBtn;
    @FXML
    private MenuItem guestBtn;
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        typeCB.setItems(types);
    }    

    @FXML
    private void guestLoginAction(ActionEvent event) throws IOException {
        Stage stage = (Stage) loginBtn.getScene().getWindow();  
        stage.close();
        Parent pane = FXMLLoader.load(getClass().getResource("GuestFXML.fxml"));
        Scene scene = new Scene(pane);       
        stage.setScene(scene);
        stage.show();
    }

    @FXML
    private void exitAction(ActionEvent event) {
        Stage stage = (Stage) loginBtn.getScene().getWindow();  
        stage.close();
    }

    @FXML
    private void loginAction(ActionEvent event) throws IOException {
        Doctor doctor = null;
        Patient patient = null;
        Accountant accountant = null;
        Supervisor supervisor = null;
        Admin admin = null;
        if(typeCB.getValue().equals("Admin") && id.getText().equals("admin") && password.getText().equals("admin")){
            admin = new Admin(id.getText(), password.getText(), typeCB.getValue());
            admin.saveInLoggedInBinFile();
            Stage stage = (Stage) loginBtn.getScene().getWindow();  
            stage.close();
            Parent pane = FXMLLoader.load(getClass().getResource("AdminFXML.fxml"));
            Scene scene = new Scene(pane);       
            stage.setScene(scene);
            stage.show();
        }
        else if(User.checkIdPasswordMatch(id.getText(), password.getText(), typeCB.getValue())){
            if(typeCB.getValue().equals("Doctor")){
                doctor = new Doctor(id.getText(), password.getText(), typeCB.getValue());                
                doctor.saveInLoggedInBinFile();
                Stage stage = (Stage) loginBtn.getScene().getWindow();  
                stage.close();
                Parent pane = FXMLLoader.load(getClass().getResource("DoctorFXML.fxml"));
                Scene scene = new Scene(pane);       
                stage.setScene(scene);
                stage.show();
            }
            else if(typeCB.getValue().equals("Patient")){
                patient = new Patient(id.getText(), password.getText(), typeCB.getValue());
                patient.saveInLoggedInBinFile();
                Stage stage = (Stage) loginBtn.getScene().getWindow();  
                stage.close();
                Parent pane = FXMLLoader.load(getClass().getResource("PatientFXML.fxml"));
                Scene scene = new Scene(pane);       
                stage.setScene(scene);
                stage.show();
            }
            else if(typeCB.getValue().equals("Accountant")){
                accountant = new Accountant(id.getText(), password.getText(), typeCB.getValue());
                accountant.saveInLoggedInBinFile();
                Stage stage = (Stage) loginBtn.getScene().getWindow();  
                stage.close();
                Parent pane = FXMLLoader.load(getClass().getResource("AccountantFXML.fxml"));
                Scene scene = new Scene(pane);       
                stage.setScene(scene);
                stage.show();
            }
            else if(typeCB.getValue().equals("Supervisor")){
                supervisor = new Supervisor(id.getText(), password.getText(), typeCB.getValue());
                supervisor.saveInLoggedInBinFile();
                Stage stage = (Stage) loginBtn.getScene().getWindow();  
                stage.close();
                Parent pane = FXMLLoader.load(getClass().getResource("SupervisorFXML.fxml"));
                Scene scene = new Scene(pane);       
                stage.setScene(scene);
                stage.show();
            }
            else if(typeCB.getValue().equals("Admin")){
                
            }
            
            id.setText("");
            password.setText("");
        }
        else{
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setHeaderText("ERROR");
            alert.setContentText("UserID or Password or User type doesn't match!!");
            alert.showAndWait();
        }
    }

    @FXML
    private void registerAction(ActionEvent event) throws IOException {
        Parent pane = FXMLLoader.load(getClass().getResource("RegisterFXML.fxml"));        
        Scene scene = new Scene(pane);
        Stage stage = new Stage();
        stage.setScene(scene);
        stage.show();
    }
    
}
