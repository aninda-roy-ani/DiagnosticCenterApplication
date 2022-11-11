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
import javas.User;

/**
 * FXML Controller class
 *
 * @author Dell
 */
public class ProfileFXMLController implements Initializable {

    @FXML
    private Label typeLabel;
    @FXML
    private Label nameLabel;
    @FXML
    private Label emailLabel;
    @FXML
    private Label phoneLabel;
    @FXML
    private Label salaryLabel;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        String userID = User.findLoggedInID();
        User user = new User(userID);
        typeLabel.setText(user.viewProfile()[0]);
        nameLabel.setText(user.viewProfile()[1]+" "+user.viewProfile()[2]);
        emailLabel.setText(user.viewProfile()[3]);
        phoneLabel.setText(user.viewProfile()[4]);
        salaryLabel.setText(user.viewProfile()[5]);
    }    
    
}
