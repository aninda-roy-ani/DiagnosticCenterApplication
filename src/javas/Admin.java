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

/**
 *
 * @author Dell
 */
public class Admin extends User {

    public Admin(String id, String password, String firstName, String lastName, String email, String phone, String type) {
        super(id, password, firstName, lastName, email, phone, type);
    }

    public Admin(String id, String password, String type) {
        super(id, password, type);
    }

    public Admin(String id) {
        super(id);
    }

    
    
    
    public void updateOurServices(String txt) throws IOException{
        File f = new File("OurServices.txt");
        if(f.delete()){
            //
        }
        FileWriter fw = new FileWriter(f);
        fw.write(txt);
        fw.close();
    }
    
    
    public void updateContact(String txt) throws IOException{
        File f = new File("Contact.txt");
        if(f.delete()){
            //
        }
        FileWriter fw = new FileWriter(f);
        fw.write(txt);
        fw.close();
    }
    
    public void updateLocation(String txt) throws IOException{
        File f = new File("Location.txt");
        if(f.delete()){
            //
        }
        FileWriter fw = new FileWriter(f);
        fw.write(txt);
        fw.close();
    }
    
    public void showAndEditSalaryData(String emp, String salary) throws IOException{
        
        boolean bool = false;
        File f = null;
        Scanner s = null;
        String string = "";
        f = new File("SalaryData.txt");
        if(!f.exists()){
            f.createNewFile();
            FileWriter fw = new FileWriter(f);
            fw.write(emp + "#" + salary + "\n");
            fw.close();
        }
        s = new Scanner(f);
        
        while(s.hasNextLine()){
            String str = s.nextLine();
            String[] str_split = str.split("#");
            if(str_split[0].equals(emp))
            {
                string += emp + "#" + salary + "\n";
                bool = true;
            }
            else
                string += str+ "\n";
        }
        if(bool == false)
            string += emp + "#" + salary + "\n";
        if(f.delete()){
            //
        }
        f.createNewFile();
        FileWriter fw = new FileWriter(f);
        fw.write(string);
        fw.close();
        
    }
}
