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
public class AvailableDoctorFXMLController implements Initializable {

    @FXML
    private Label doctorsLabel;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        String string = "";
        File f = null;
        Scanner s = null;
        //System.out.println("hello1");
        try {
            f = new File("Profiles.txt");
            s = new Scanner(f);
            while(s.hasNextLine()){
            String str = s.nextLine();
            String[] str_split = str.split("#");
                //System.out.println(str_split[0] + " " + str_split[4]);
                //System.out.println("Im here 1");
            if(str_split[0].equals("Doctor"))
                string += "Dr. " + str_split[2] + " " + str_split[3] +
                        "\n" + "Email ID: " + str_split[4] +
                        "\n" + "Phone NO: " + str_split[5] +"\n\n";
                //System.out.println(string+"!");
            }
            doctorsLabel.setText(string);
            //System.out.println("Im here3");
            //System.out.println(string+" ");
        } catch (FileNotFoundException ex) {
            Logger.getLogger(AvailableDoctorFXMLController.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }    
    
}
