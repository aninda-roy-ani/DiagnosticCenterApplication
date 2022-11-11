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
public class GuestFXMLController implements Initializable {

    @FXML
    private BorderPane bp;
    @FXML
    private Button homepageBtn;



    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

    @FXML
    private void ourServicesAction(ActionEvent event) throws IOException {
        Parent pane = FXMLLoader.load(getClass().getResource("OurServicesFXML.fxml"));
        bp.setCenter(pane);
    }

    @FXML
    private void availableDoctorsAction(ActionEvent event) throws IOException {
        Parent pane = FXMLLoader.load(getClass().getResource("AvailableDoctorFXML.fxml"));
        bp.setCenter(pane);
    }

    @FXML
    private void locContAction(ActionEvent event) throws IOException {
        Parent pane = FXMLLoader.load(getClass().getResource("LocationContactFXML.fxml"));
        bp.setCenter(pane);
    }

    @FXML
    private void registerAction(ActionEvent event) throws IOException {
        Stage stage = new Stage();
        Parent pane = FXMLLoader.load(getClass().getResource("RegisterFXML.fxml"));
        Scene scene = new Scene(pane);       
        stage.setScene(scene);
        stage.show();
    }

    @FXML
    private void homepageAction(ActionEvent event) throws IOException {
        Stage stage = (Stage) homepageBtn.getScene().getWindow();  
        stage.close();
        Parent pane = FXMLLoader.load(getClass().getResource("MainFXML.fxml"));
        Scene scene = new Scene(pane);       
        stage.setScene(scene);
        stage.show();
    }


    
}
