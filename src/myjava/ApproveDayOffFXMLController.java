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
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javas.Doctor;
import javas.Supervisor;
import javas.User;

/**
 * FXML Controller class
 *
 * @author Dell
 */
public class ApproveDayOffFXMLController implements Initializable {

    @FXML
    private ComboBox<String> employeeCB;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        String userID = User.findLoggedInID();
        File f = null;
        Scanner s = null;
        try {
            f = new File("DayOffDates.txt");
            s = new Scanner(f);
            //System.out.println("here2");
            while(s.hasNextLine()){
                String str = s.nextLine();
                String[] str_split = str.split("#");
                //System.out.println("here3");
                if(str_split[2].equals("Pending")){
                    //System.out.println("here4");
                    String added = "Date:"+str_split[1]+" ID:"+str_split[0];
                    employeeCB.getItems().add(added);
                    
                }
            }
        } catch (FileNotFoundException ex) {
            Logger.getLogger(CreateAppointmentFXMLController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }    

    @FXML
    private void declineAction(ActionEvent event) throws IOException {
        String userID = User.findLoggedInID();
        Supervisor sv = new Supervisor(userID);
        String[] doID = employeeCB.getValue().toString().split(" ID:");
        sv.approveDayOff("Declined", doID[1]);
        Alert a = new Alert(Alert.AlertType.INFORMATION);
        a.setContentText("Day Off declined!");
        a.showAndWait();
    }

    @FXML
    private void approveAction(ActionEvent event) throws IOException {
        String userID = User.findLoggedInID();
        Supervisor sv = new Supervisor(userID);
        String[] doID = employeeCB.getValue().toString().split(" ID:");
        sv.approveDayOff("Approved", doID[1]);
        Alert a = new Alert(Alert.AlertType.INFORMATION);
        a.setContentText("Day Off approved!");
        a.showAndWait();
    }
    
}
