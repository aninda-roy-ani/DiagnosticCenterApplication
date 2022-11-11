/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javas;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.util.Scanner;

/**
 *
 * @author Dell
 */
public class Accountant extends Employee {

    public Accountant(String id, String password, String firstName, String lastName, String email, String phone, String type, float salary) {
        super(id, password, firstName, lastName, email, phone, type, salary);
    }

    public Accountant(String id, String password, String type) {
        super(id, password, type);
    }

    public Accountant(String id) {
        super(id);
    }

    
    
    
    public void issueSalaries() throws IOException{
        File f = new File("Profiles.txt");
        Scanner s = new Scanner(f);
        String string = "";
        while(s.hasNextLine()){
            String str = s.nextLine();
            String[] str_split = str.split("#");
            if(!str_split[0].equals("Patient")){
                if(str_split[6].equals("N/A"))
                    string += str_split[0]+ "#"+ str_split[1]+ "#"+ str_split[2]+ "#"+ str_split[3]+ "#"+ str_split[4]+ "#"+ str_split[5] + "#"+ Employee.getSalary(str_split[0]) + "\n";
                else
                    string += str+"\n";
            }
        }
        if(f.delete()){}
        f.createNewFile();
        FileWriter fw = new FileWriter(f);
        fw.write(string);
        fw.close();
    }
    /*
    public Revenue[] generateFinancialSummery(){
        //ObjectInputStream ois=null;
        Revenue[] rev = new Revenue[99];
        int i = 0;
        System.out.println("x1");
        /*try {
            
            ois = new ObjectInputStream(new FileInputStream("FinancialSum.bin"));
            while(true){
            rev[i++] = (Revenue) ois.readObject();
            }
            
        }catch (Exception ex) {
            try {
                if(ois!=null)
                    ois.close();
            } 
            catch (IOException e) {
                e.printStackTrace();
            }
            ex.printStackTrace();
        }
        File f = null;
        FileInputStream fis = null;      
        ObjectInputStream ois = null;
        
        try {
            f = new File("Revenue.bin");
            fis = new FileInputStream(f);
            ois = new ObjectInputStream(fis);
            Revenue r;
            System.out.println("x2");
            try{
                while(true){
                    System.out.println("x3");
                    r = (Revenue)ois.readObject();
                    
                    System.out.println("x");
                    r.submitReport();
                    rev[i++] = r;
                }
            }
            catch(Exception e){
                //
            }    
                      
        } catch (IOException ex) { } 
        finally {
            try {
                if(ois != null) ois.close();
            } catch (IOException ex) { }
        } 
        return rev;
    }*/

    public Employee[] getSalaries() throws FileNotFoundException {
        Employee[] empArray = new Employee[99];
        int i = 0;
        File f = new File("Profiles.txt");
        Scanner s = new Scanner(f);
        while(s.hasNextLine()){
            String str = s.nextLine();
            String[] str_split = str.split("#");
            if(!str_split[0].equals("Patient")){
                if(str_split[6].equals("N/A"))
                    empArray[i++] = new Employee(str_split[3], Employee.getSalary(str_split[0]), str_split[0]);
                else
                    empArray[i++] = new Employee(str_split[1], Float.parseFloat(str_split[6]), str_split[0]);
            }
        }
        
        return empArray;
    }


}
