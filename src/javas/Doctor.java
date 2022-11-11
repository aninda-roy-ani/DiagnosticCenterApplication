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
import java.util.Date;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;
import myjava.MainFXMLController;

/**
 *
 * @author Dell
 */
public class Doctor extends Employee {
    
    static int noOfPatients;

    public Doctor(String id, String password, String firstName, String lastName, String email, String phone, String type, float salary) {
        super(id, password, firstName, lastName, email, phone, type, salary);
    }


    public Doctor(String id, String password, String firstName, String lastName, String email, String phone, String type) {
        super(id, password, firstName, lastName, email, phone, type);
    }

    public Doctor(String id, String password, String type) {
        super(id, password, type);
    }

    public Doctor(String id) {
        super(id);
    }
    
    
    
    public void approveAppointment(String time, String status, String appID) throws FileNotFoundException, IOException{
        File f = null;
        Scanner s = null;
        f = new File("Appointment.txt");
        
        s = new Scanner(f);
        String string = "";
        while(s.hasNext()){
            String str = s.nextLine();
            String[] str_split = str.split("#");
            if(str_split[4].equals("Pending") && str_split[0].equals(id) && str_split[2].equals(appID)){
                string+=str_split[0]+"#"+str_split[1]+"#"+str_split[2]+"#"+str_split[3]+"#"+status+"#"+time+"\n";
            }else
                string+=str+"\n";
        }
        if(f.delete()){
            //
        }
        f.createNewFile();
        FileWriter fw = new FileWriter (f);
        fw.write(string);
        fw.close();
    }
    
    public void askForDayOff(LocalDate date){
        //System.out.println("here2");
        File f = null;
        FileWriter fw = null;
        try {

            f = new File("DayOffDates.txt");
            if(f.exists()) fw = new FileWriter(f,true);
            else fw = new FileWriter(f);
           
            fw.write(id+"#"+date.toString()+"#Pending\n");
            System.out.println(date.toString());
            
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
    
    
    
    
}
