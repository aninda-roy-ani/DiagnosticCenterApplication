/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package myjava;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleGroup;
import javafx.stage.Stage;
import javas.Accountant;
import javas.Admin;
import javas.Doctor;
import javas.Patient;
import javas.Supervisor;
import javas.User;

/**
 * FXML Controller class
 *
 * @author Dell
 */
public class RegisterFXMLController implements Initializable {

    @FXML
    private RadioButton doctorRB;
    @FXML
    private RadioButton patientRB;
    @FXML
    private RadioButton accountantRB;
    @FXML
    private TextField firstName;
    @FXML
    private TextField lastName;
    @FXML
    private TextField email;
    @FXML
    private TextField phone;
    @FXML
    private TextField id;
    @FXML
    private TextField password;
    @FXML
    private Button homepageBtn;
    @FXML
    private RadioButton supervisorRB;
    //private RadioButton adminRB;
    @FXML
    private CheckBox agreeCheck;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        ToggleGroup group = new ToggleGroup();
        doctorRB.setToggleGroup(group);
        patientRB.setToggleGroup(group);
        accountantRB.setToggleGroup(group);
        supervisorRB.setToggleGroup(group);
        //adminRB.setToggleGroup(group);
    }    

    @FXML
    private void registerDoneAction(ActionEvent event) {
        Doctor doctor = null;
        Patient patient = null;
        Accountant accountant = null;
        Supervisor supervisor = null;
        String type = "";
        if(!agreeCheck.isSelected()){
            Alert a = new Alert(Alert.AlertType.ERROR);
            a.setContentText("First agree to the terms and conditions!");
            a.showAndWait();
        }else{
            if(!User.checkUserIdExistence(id.getText())){
                if(doctorRB.isSelected()){
                    //doctor = new Doctor(id.getText(), password.getText(), firstName.getText(), lastName.getText(), email.getText(), phone.getText(), doctorRB.getText());
                    //doctor.saveInUserBinFile();
                    //doctor.saveInProfilesTextFile();
                    type = doctorRB.getText();
                }
                else if(patientRB.isSelected()){
                    //patient = new Patient(id.getText(), password.getText(), firstName.getText(), lastName.getText(), email.getText(), phone.getText(), patientRB.getText());
                    //patient.saveInUserBinFile();
                    //patient.saveInProfilesTextFile();
                    type = patientRB.getText();
                }
                else if(accountantRB.isSelected()){
                    //accountant = new Accountant(id.getText(), password.getText(), firstName.getText(), lastName.getText(), email.getText(), phone.getText(), accountantRB.getText(), (float) 0.0);
                    //accountant.saveInUserBinFile();
                    //accountant.saveInProfilesTextFile();
                    type = accountantRB.getText();
                }
                else if(supervisorRB.isSelected()){
                    //supervisor = new Supervisor(id.getText(), password.getText(), firstName.getText(), lastName.getText(), email.getText(), phone.getText(), supervisorRB.getText(), (float) 0.0);
                    //supervisor.saveInUserBinFile();
                    //supervisor.saveInProfilesTextFile();
                    type = supervisorRB.getText();
                }
                //else if(adminRB.isSelected()){
                    //Admin admin = new Admin(id.getText(), password.getText(), firstName.getText(), lastName.getText(), email.getText(), phone.getText(), adminRB.getText());
                    //admin.saveInUserBinFile();
                    //supervisor.saveInProfilesTextFile();
                    //type = doctorRB.getText();
                //}
                User user = new User(id.getText(), password.getText(), firstName.getText(), lastName.getText(), email.getText(), phone.getText(), type);
                user.saveInUserBinFile();
                user.saveInProfilesTextFile();
                id.setText("");
                password.setText("");
                firstName.setText("");
                lastName.setText("");
                email.setText("");
                phone.setText("");
                Alert a = new Alert(Alert.AlertType.INFORMATION);
                a.setContentText("Registration is complete!\n Remember User ID: "+user.getId()+"\n & Password: "+ user.getPassword());
                a.showAndWait();
            }
            else{
                Alert alert = new Alert(Alert.AlertType.ERROR);
                alert.setHeaderText("ERROR");
                alert.setContentText("UserID already exists!!");
                alert.showAndWait();
                id.setText("");
                password.setText("");
                firstName.setText("");
                lastName.setText("");
                email.setText("");
                phone.setText("");
            }
        }        
    }

    @FXML
    private void homepageAction(ActionEvent event) throws IOException {
        Stage stage = (Stage) homepageBtn.getScene().getWindow();  
        stage.close();
    }
    
}
