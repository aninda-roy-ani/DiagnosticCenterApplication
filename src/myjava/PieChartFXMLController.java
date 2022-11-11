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
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.chart.PieChart;
import javafx.scene.chart.PieChart.Data;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javas.Supervisor;

/**
 * FXML Controller class
 *
 * @author Dell
 */
public class PieChartFXMLController implements Initializable {

    @FXML
    private Label statusLabel;
    @FXML
    private PieChart pieChart;
    @FXML
    private Button loadPieChart;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

    @FXML
    private void loadPieChartAction(ActionEvent event) throws FileNotFoundException {
        ObservableList <Data> list = FXCollections.observableArrayList();
        File f = new File("Profiles.txt");
        Scanner s = null;
        try {
            s = new Scanner(f);
            while(s.hasNextLine()){
                String str = s.nextLine();           
                String[] str_split = str.split("#");
                if(str_split[0].equals("Doctor")){
                    
                    Data d = new Data("Dr. "+str_split[2]+" "+str_split[3], Supervisor.doctorsPatientCount(str_split[1]));
                    list.add(d);
                }
            }
        }catch (FileNotFoundException ex) {
            
        }
        pieChart.setData(list);
    }
    
}
