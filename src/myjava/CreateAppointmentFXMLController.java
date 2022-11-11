/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package myjava;

import java.io.File;
import java.io.FileNotFoundException;
import java.net.URL;
import java.util.Random;
import java.util.ResourceBundle;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javas.Doctor;
import javas.Patient;
import javas.User;

/**
 * FXML Controller class
 *
 * @author Dell
 */
public class CreateAppointmentFXMLController implements Initializable {
    
    
    @FXML
    private DatePicker date;
    @FXML
    private ComboBox<String> doctorsCB;
    @FXML
    private Label appIDLabel;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        //System.out.println("here1");
        File f = null;
        Scanner s = null;
        try {
            f = new File("Profiles.txt");
            s = new Scanner(f);
            //System.out.println("here2");
            while(s.hasNextLine()){
                String str = s.nextLine();
                String[] str_split = str.split("#");
                //System.out.println("here3");
                if(str_split[0].equals("Doctor")){
                    //System.out.println("here4");
                    String added = "Dr. "+str_split[2]+" "+str_split[3]+", ID:"+str_split[1];
                    doctorsCB.getItems().add(added);
                }
            }
        } catch (FileNotFoundException ex) {
            Logger.getLogger(CreateAppointmentFXMLController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }    

    @FXML
    private void confirmAction(ActionEvent event) {
        String userID = User.findLoggedInID();
        //String userType = User.findLoggedInIdType();
        Patient patient = new Patient(userID);
        Random random = new Random();
        int randomNumber = random.nextInt(99999999 - 9999999) + 9999999;
        String[] doctorID = doctorsCB.getValue().split(", ID:");
        String appID = doctorID[1]+randomNumber;
        appIDLabel.setText(appID);
        patient.createAppointment(doctorID[1],appID,date.getValue());
        Alert a = new Alert(Alert.AlertType.INFORMATION);
        a.setContentText(" Your appointment is taken.\n Wait for confirmation!");
        a.showAndWait();
    }

    
}
