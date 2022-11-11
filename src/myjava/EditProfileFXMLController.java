/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package myjava;


import java.io.FileNotFoundException;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.TextField;
import javas.User;

/**
 * FXML Controller class
 *
 * @author User
 */
public class EditProfileFXMLController implements Initializable {

    @FXML
    private TextField fName;
    @FXML
    private TextField lName;
    @FXML
    private TextField email;
    @FXML
    private TextField phone;
    @FXML
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        String userID = User.findLoggedInID();
        User user = new User(userID);
        fName.setText(user.viewProfile()[1]);
        lName.setText(user.viewProfile()[2]);
        email.setText(user.viewProfile()[3]);
        phone.setText(user.viewProfile()[4]);
    }    

    @FXML
    private void SavedAction(ActionEvent event) throws FileNotFoundException, IOException {
        String userID = User.findLoggedInID();
        User user = new User(userID, fName.getText(), lName.getText(), email.getText(), phone.getText());
        user.editProfile();
        fName.setText("");
        lName.setText("");
        email.setText("");
        phone.setText("");
        Alert a = new Alert(Alert.AlertType.INFORMATION);
        a.setContentText("Profile Updated!");
        a.showAndWait();
    }
    
}
