/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package myjava;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.CheckBox;
import javafx.scene.control.ComboBox;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleGroup;
import javas.Employee;
import javas.SalaryStatus;
import javas.User;

/**
 * FXML Controller class
 *
 * @author Dell
 */
public class SalaryStatusFXMLController implements Initializable {

    ObservableList<String> types = FXCollections.observableArrayList("Doctor", "Patient", "Accountant", "Supervisor");
    @FXML
    private ComboBox<String> desigCB;
    @FXML
    private RadioButton paidRB;
    @FXML
    private RadioButton dueRB;
    @FXML
    private TextField salaryTF;
    @FXML
    private CheckBox humanCheck;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        desigCB.setItems(types);
        ToggleGroup group = new ToggleGroup();
        paidRB.setToggleGroup(group);
        dueRB.setToggleGroup(group);
    }    

    @FXML
    private void saveAsObjectAction(ActionEvent event) {
        if(!humanCheck.isSelected()){
            Alert a = new Alert(Alert.AlertType.ERROR);
            a.setContentText("Complete Human Check!");
            a.showAndWait();
        }else{
            String userID = User.findLoggedInID();
            String status = "DUE";
            if(paidRB.isSelected()) status = "PAID";
            SalaryStatus ss = new SalaryStatus(userID, desigCB.getValue(), status, salaryTF.getText());
            Employee.appendSalaryStatusAsObject(ss);
            salaryTF.setText("");
            Alert a = new Alert(Alert.AlertType.INFORMATION);
            a.setContentText("Saved as Object in SalaryStatus.bin file!");
            a.showAndWait();
        }
    }
    
}
