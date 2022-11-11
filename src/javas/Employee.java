/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javas;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.util.Scanner;


/**
 *
 * @author Dell
 */
public class Employee extends User {
    
    private float salary;

    public Employee(String id, String password, String firstName, String lastName, String email, String phone, String type, float salary) {
        super(id, password, firstName, lastName, email, phone, type);
        this.salary = salary;
    }

    public Employee(String id, String password, String firstName, String lastName, String email, String phone, String type) {
        super(id, password, firstName, lastName, email, phone, type);
    }

    public Employee(String id, String password, String type) {
        super(id, password, type);
    }

    public Employee(String id, float salary,  String type) {
        super(id, type);
        this.salary = salary;
    }

    public Employee(String type, float salary) {
        super(type);
        this.salary = salary;
    }
    
    public Employee(String id) {
        super(id);
    }

    
    
    

    public float getSalary() {
        return salary;
    }

    public void setSalary(float salary) {
        this.salary = salary;
    }

    public static void appendSalaryStatusAsObject(SalaryStatus ss){
        File f = null;
        FileOutputStream fos = null;      
        ObjectOutputStream oos = null;
        
        try {
            f = new File("SalaryStatus.bin");
            if(f.exists()){
                fos = new FileOutputStream(f,true);
                oos = new AppendableObjectOutputStream(fos);                
            }
            else{
                fos = new FileOutputStream(f);
                oos = new ObjectOutputStream(fos);               
            }
           
            oos.writeObject(ss);

        } catch (IOException ex) {} 
        finally {
            try {
                if(oos != null) oos.close();
            } catch (IOException ex) {}
        }
    }
    
    public static float getSalary(String desig) throws FileNotFoundException{
        float salar = 0.0f;
        File f = new File("SalaryData.txt");
        Scanner s = new Scanner(f);
        while(s.hasNextLine()){
            String str = s.nextLine();
            String[] str_split = str.split("#");
            if(str_split[0].equals(desig))
                salar = Float.parseFloat(str_split[1]);
        }
        return salar;
    }
}
