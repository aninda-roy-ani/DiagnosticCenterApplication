/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package myjava;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author Dell
 */
public class ChartsFXMLController implements Initializable {

    @FXML
    private BorderPane bp;
    @FXML
    private Button pie;
    @FXML
    private Button bar;
    @FXML
    private Button clearButton;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

    private void loadUI(String ui) {
        Parent root;
        try {
            root = FXMLLoader.load(getClass().getResource(ui+"ChartFXML.fxml"));
            bp.setCenter(root);
        } catch (IOException ex) {
            Logger.getLogger(ChartsFXMLController.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }
    @FXML
    private void closeStage(ActionEvent event) throws IOException {
        Stage stage = (Stage) clearButton.getScene().getWindow();  
        stage.close();
        Parent pane = FXMLLoader.load(getClass().getResource("MainFXML.fxml"));
        Scene scene = new Scene(pane);       
        stage.setScene(scene);
        stage.show();
    }

    @FXML
    private void barChartAction(MouseEvent event) {
        loadUI("Bar");
    }

    @FXML
    private void clearButtonOnClick(ActionEvent event) {
        bp.setCenter(null);
    }

    @FXML
    private void pieChartAction(ActionEvent event) throws IOException {
        Parent pane = FXMLLoader.load(getClass().getResource("PieChartFXML.fxml"));
        bp.setCenter(pane);
    }
    
}
