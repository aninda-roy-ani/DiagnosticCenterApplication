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
import javafx.scene.control.TextArea;
import javas.User;

/**
 * FXML Controller class
 *
 * @author Dell
 */
public class ComplainFXMLController implements Initializable {

    @FXML
    private TextArea txtEditor;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        
    }    

    @FXML
    private void saveAction(ActionEvent event) {
        String userID = User.findLoggedInID();
        //String userType = User.findLoggedInIdType();
        User user = new User(userID);
        user.complain("* "+txtEditor.getText());
        txtEditor.setText("");
        Alert a = new Alert(Alert.AlertType.INFORMATION);
        a.setContentText(" Complaint sent!");
        a.showAndWait();
    }
    
}
