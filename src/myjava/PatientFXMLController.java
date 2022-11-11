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
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author Dell
 */
public class PatientFXMLController implements Initializable {

    @FXML
    private BorderPane bp;
    @FXML
    private Button logOutBtn;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

    @FXML
    private void createAppointmentAction(ActionEvent event) throws IOException {
        Parent pane = FXMLLoader.load(getClass().getResource("CreateAppointmentFXML.fxml"));
        bp.setCenter(pane);
    }

    @FXML
    private void appointmentStatusAction(ActionEvent event) throws IOException {
        Parent pane = FXMLLoader.load(getClass().getResource("AppointmentStatusFXML.fxml"));
        bp.setCenter(pane);
    }
    
    @FXML
    private void complainAction(ActionEvent event) throws IOException {
        Parent pane = FXMLLoader.load(getClass().getResource("ComplainFXML.fxml"));
        bp.setCenter(pane);
    }

    @FXML
    private void logOutAction(ActionEvent event) throws IOException {
        Stage stage = (Stage) logOutBtn.getScene().getWindow();  
        stage.close();
        Parent pane = FXMLLoader.load(getClass().getResource("MainFXML.fxml"));
        Scene scene = new Scene(pane);       
        stage.setScene(scene);
        stage.show();
    }

    @FXML
    private void Profile(ActionEvent event) throws IOException {
        Parent pane = FXMLLoader.load(getClass().getResource("ProfileFXML.fxml"));
        bp.setCenter(pane);
    }

    @FXML
    private void editProfile(ActionEvent event) throws IOException {
        Parent pane = FXMLLoader.load(getClass().getResource("EditProfileFXML.fxml"));
        bp.setCenter(pane);
    }
}
