/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package myjava;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author Dell
 */
public class AdminFXMLController implements Initializable {

    @FXML
    private BorderPane bp;
    @FXML
    private Button logOutBtn;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

    @FXML
    private void editOurServicesAction(ActionEvent event) throws IOException {
        Parent pane = FXMLLoader.load(getClass().getResource("EditOurServicesFXML.fxml"));
        bp.setCenter(pane);
    }

    @FXML
    private void editContactAction(ActionEvent event) throws IOException {
        Parent pane = FXMLLoader.load(getClass().getResource("EditContactFXML.fxml"));
        bp.setCenter(pane);
    }

    @FXML
    private void editLocationAction(ActionEvent event) throws IOException {
        Parent pane = FXMLLoader.load(getClass().getResource("EditLocationFXML.fxml"));
        bp.setCenter(pane);
    }

    @FXML
    private void logOutAction(ActionEvent event) throws IOException {
        Stage stage = (Stage) logOutBtn.getScene().getWindow();  
        stage.close();
        Parent pane = FXMLLoader.load(getClass().getResource("MainFXML.fxml"));
        Scene scene = new Scene(pane);       
        stage.setScene(scene);
        stage.show();
    }


    @FXML
    public void salaryDataAction(ActionEvent event) throws IOException {
        bp.setCenter(null);
        Stage stage = new Stage();
        Parent pane = FXMLLoader.load(getClass().getResource("SalaryDataFXML.fxml"));
        Scene scene = new Scene(pane);       
        stage.setScene(scene);
        stage.show();
    }
    
    

}
