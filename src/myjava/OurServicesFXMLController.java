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
public class OurServicesFXMLController implements Initializable {

    @FXML
    private Label servicesLabel;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        String string = "";
        File f = null;
        Scanner s = null;
        try {
            f = new File("OurServices.txt");
            s = new Scanner(f);
            while(s.hasNextLine()){
                string += s.nextLine() + "\n";
            }
            servicesLabel.setText(string);
        } catch (FileNotFoundException ex) {
            Logger.getLogger(AvailableDoctorFXMLController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }    
    
}
