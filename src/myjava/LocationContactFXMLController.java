/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package myjava;

import java.io.File;
import java.io.FileNotFoundException;
import java.net.URL;
import java.util.ResourceBundle;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;

/**
 * FXML Controller class
 *
 * @author Dell
 */
public class LocationContactFXMLController implements Initializable {

    @FXML
    private Label locConLabel;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        String string = "Location:\n";
        File f = null;
        Scanner s = null, s1 = null;
        try {
            f = new File("Location.txt");
            s = new Scanner(f);
            while(s.hasNextLine()){
                string += s.nextLine() + "\n";
            }
            string += "\nContact: \n";
            
        } catch (FileNotFoundException ex) {
            Logger.getLogger(AvailableDoctorFXMLController.class.getName()).log(Level.SEVERE, null, ex);
        }
        try {
            f = new File("Contact.txt");
            s1 = new Scanner(f);
            
            while(s1.hasNextLine()){
                string += s1.nextLine() + "\n";
            }
        } catch (FileNotFoundException ex) {
            Logger.getLogger(LocationContactFXMLController.class.getName()).log(Level.SEVERE, null, ex);
        }
        locConLabel.setText(string);
           
    }    
    
}
