/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package myjava;

import java.io.FileNotFoundException;
import java.net.URL;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javas.Patient;
import javas.User;

/**
 * FXML Controller class
 *
 * @author Dell
 */
public class AppointmentStatusFXMLController implements Initializable {

    @FXML
    private Label timeLabel;
    @FXML
    private Label statusLabel;
    @FXML
    private Label appIdLabel;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        try {
            // TODO
            String userID = User.findLoggedInID();
            Patient patient = new Patient(userID);
            appIdLabel.setText(patient.checkAppointmentStatus()[0]);
            statusLabel.setText(patient.checkAppointmentStatus()[1]);
            timeLabel.setText(patient.checkAppointmentStatus()[2]);
        } catch (FileNotFoundException ex) {
            Logger.getLogger(AppointmentStatusFXMLController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }    
    
}
