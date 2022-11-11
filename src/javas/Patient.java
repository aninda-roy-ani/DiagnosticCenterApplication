/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javas;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDate;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;
import myjava.MainFXMLController;

/**
 *
 * @author Dell
 */
public class Patient extends User{

    public Patient(String id, String password, String firstName, String lastName, String email, String phone, String type) {
        super(id, password, firstName, lastName, email, phone, type);
    }

    public Patient(String id, String password, String type) {
        super(id, password, type);
    }

    public Patient(String id) {
        super(id);
    }

    
    
    
    
    public void createAppointment(String doctorID, String randomNumber, LocalDate date){
        File f = null;
        FileWriter fw = null;
        try {

            f = new File("Appointment.txt");
            if(f.exists()) fw = new FileWriter(f,true);
            else fw = new FileWriter(f);
           
            fw.write(doctorID+"#"+id+"#"+randomNumber+"#"+date.toString()+"#Pending#N/A\n");           
            
        } catch (IOException ex) {
            Logger.getLogger(MainFXMLController.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            try {
                if(fw != null) fw.close();
            } catch (IOException ex) {
                Logger.getLogger(MainFXMLController.class.getName()).log(Level.SEVERE, null, ex);
            }
        }

    }
    
    public String[] checkAppointmentStatus() throws FileNotFoundException{
        String[] string = new String[3];
        File f = new File("Appointment.txt");
        Scanner s = new Scanner(f);
        while(s.hasNextLine()){
            String str = s.nextLine();
            String[] str_split = str.split("#");
            if(str_split[1].equals(id)){
                string[0] = str_split[2];
                string[1] = str_split[4];
                string[2] = str_split[5];
                break;
            }
        }
        return string;
    }
    
    public void pay(){
        
    }
    
    public void downloadTransactionReport(){
        
    }


    
    
    
    
}
