/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package myjava;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.DatePicker;
import javas.Doctor;
import javas.User;

/**
 * FXML Controller class
 *
 * @author Dell
 */
public class AskDayOffFXMLController implements Initializable {

    @FXML
    private DatePicker date;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        
    }    

    @FXML
    private void confirmAction(ActionEvent event) {
        String userID = User.findLoggedInID();
        //String userType = User.findLoggedInIdType();
        Doctor doctor = new Doctor(userID);
        doctor.askForDayOff(date.getValue());
        //System.out.println("here1");
        Alert a = new Alert(Alert.AlertType.INFORMATION);
        a.setContentText(" Wait for confirmation of Day Off!");
        a.showAndWait();
    }
    
}
