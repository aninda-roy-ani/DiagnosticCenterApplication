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
import javafx.scene.chart.BarChart;
import javafx.scene.chart.CategoryAxis;
import javafx.scene.chart.NumberAxis;
import javafx.scene.chart.XYChart;
import javas.Supervisor;

/**
 * FXML Controller class
 *
 * @author Dell
 */
public class BarChartFXMLController implements Initializable {

    @FXML
    private BarChart<String, Number> barChart;
    @FXML
    private NumberAxis yAxis;
    @FXML
    private CategoryAxis xAxis;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        try {
            XYChart.Series<String,Number> series = new XYChart.Series<String,Number>();
            File f = new File("Profiles.txt");
            Scanner s = new Scanner(f);
            
            while(s.hasNext()){
                
                String str = s.nextLine();
                String[] str_split = str.split("#");
                if(str_split[0].equals("Doctor"))
                    series.getData().add(new XYChart.Data<String,Number>("Dr. "+str_split[2]+" "+str_split[3], Supervisor.doctorsPatientCount(str_split[1])));
            }
            series.setName("Number of Patients Per Doctor");
            barChart.getData().add(series);
        } catch (FileNotFoundException ex) {
        }
    }    
    
}
