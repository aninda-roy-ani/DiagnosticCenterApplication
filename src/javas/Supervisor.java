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
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;
import static javas.Doctor.noOfPatients;
import myjava.AvailableDoctorFXMLController;
import myjava.MainFXMLController;

/**
 *
 * @author Dell
 */
public class Supervisor extends Employee {

    public Supervisor(String id, String password, String firstName, String lastName, String email, String phone, String type, float salary) {
        super(id, password, firstName, lastName, email, phone, type, salary);
    }

    public Supervisor(String id, String password, String type) {
        super(id, password, type);
    }

    public Supervisor(String id) {
        super(id);
    }

    
    
    
    public void approveDayOff(String status, String empID) throws FileNotFoundException, IOException{
        File f = null;
        Scanner s = null;
        f = new File("DayOffDates.txt");
        
        s = new Scanner(f);
        String string = "";
        while(s.hasNext()){
            String str = s.nextLine();
            String[] str_split = str.split("#");
            if(str_split[2].equals("Pending") && str_split[0].equals(empID)){
                string+=str_split[0]+"#"+str_split[1]+"#"+status+"\n";
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
    
    public void createNotices(String notice){
        File f = null;
        FileWriter fw = null;
        try {

            f = new File("Notices.txt");
            if(f.exists()) fw = new FileWriter(f,true);
            else fw = new FileWriter(f);
           
            fw.write(notice+"\n");           
            
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
    
    public String checkComplaints(){
        //System.out.println("here1");
        String string = "";
        File f = null;
        Scanner s = null;
        try {
            f = new File("Complaints.txt");
            s = new Scanner(f);
            while(s.hasNextLine()){
                string += s.nextLine()+"\n";
                //System.out.println("here2"+" "+str);
                    
            }
        } catch (FileNotFoundException ex) {
            Logger.getLogger(AvailableDoctorFXMLController.class.getName()).log(Level.SEVERE, null, ex);
        }
        //System.out.println(string[0]+" "+string[1]);
        return string;
    }
    
    public static int doctorsPatientCount(String userID) throws FileNotFoundException{
        noOfPatients = 0;
        File f = new File("Appointment.txt");
        Scanner s = new Scanner(f);
        while(s.hasNextLine()){
            String str = s.nextLine();
            String[] str_split = str.split("#");
            if(str_split[0].equals(userID) && str_split[4].equals("Approved"))
                noOfPatients++;
        }
        return noOfPatients;
    }
    
    
}
