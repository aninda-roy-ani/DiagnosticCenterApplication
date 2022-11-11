/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package myjava;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javas.Supervisor;
import javas.User;

/**
 * FXML Controller class
 *
 * @author Dell
 */
public class ComplaintsFXMLController implements Initializable {

    @FXML
    private Label reportLabel;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        String userID = User.findLoggedInID();
        //String userType = User.findLoggedInIdType();
        Supervisor sv = new Supervisor(userID);
        reportLabel.setText(sv.checkComplaints());
    }    
    
}
