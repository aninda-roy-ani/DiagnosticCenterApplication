/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javas;

import java.io.BufferedInputStream;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;
import myjava.AvailableDoctorFXMLController;
import myjava.MainFXMLController;

/**
 *
 * @author Dell
 */
public class User implements CommonWorks {
    protected String id;
    private String password;
    private String type;
    private String firstName;
    private String lastName;
    private String email;
    private String phone;

    public User(String id, String password, String firstName, String lastName, String email, String phone, String type) {
        this.id = id;
        this.password = password;
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.phone = phone;
        this.type = type;
    }

    public User(String id, String password, String type) {
        this.id = id;
        this.password = password;
        this.type = type;
    }
    
    public User(String id, String firstName, String lastName, String email, String phone) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.phone = phone;
    }

    public User(String id, String type) {
        this.id = id;
        this.type = type;
    }

    public User(String id) {
        this.id = id;
    }
    
    
    
    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }
    
    public static String findLoggedInID(){
        String userID = "";
        File f = null;
        FileInputStream fis = null;
        BufferedInputStream bis = null;
        DataInputStream dis = null;
       
        try {
            f = new File("LoggedIn.bin");
               
            fis = new FileInputStream(f);
            bis = new BufferedInputStream(fis);
            dis = new DataInputStream(bis);
            
            userID = dis.readUTF();  
            
        } catch (IOException ex) {
            
        } finally {
            try {
                if(dis != null) dis.close();
            } catch (IOException ex) {
                
            }
        }
        //return 
        return userID;
    }
   /* public static String findLoggedInIdType(){
        String userID = "";
        String userType = "";
        File f = null;
        FileInputStream fis = null;
        BufferedInputStream bis = null;
        DataInputStream dis = null;
       
        try {
            f = new File("LoggedIn.bin");
               
            fis = new FileInputStream(f);
            bis = new BufferedInputStream(fis);
            dis = new DataInputStream(bis);
            
            userID = dis.readUTF();  
            userType = dis.readUTF();  
            
        } catch (IOException ex) {
            
        } finally {
            try {
                if(dis != null) dis.close();
            } catch (IOException ex) {
                
            }
        }
        //return 
        return userType;
    }*/
    
    @Override
    public void complain(String complaint){
        File f = null;
        FileWriter fw = null;
        try {

            f = new File("Complaints.txt");
            if(f.exists()) fw = new FileWriter(f,true);
            else fw = new FileWriter(f);
           
            fw.write(complaint+"\n");           
            
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
    
    @Override
    public String checkNotices(){
        //System.out.println("here1");
        String string = "";
        File f = null;
        Scanner s = null;
        try {
            f = new File("Notices.txt");
            s = new Scanner(f);
            while(s.hasNextLine()){
                string += s.nextLine();
                //System.out.println("here2"+" "+str);
                    
            }
        } catch (FileNotFoundException ex) {
            Logger.getLogger(AvailableDoctorFXMLController.class.getName()).log(Level.SEVERE, null, ex);
        }
        //System.out.println(string[0]+" "+string[1]);
        return string;
    }
    
    @Override
    public String[] checkSalaryStatus(){
        //System.out.println("here1");
        String string[] = new String[2];
        File f = null;
        Scanner s = null;
        try {
            f = new File("Salaries.txt");
            s = new Scanner(f);
            while(s.hasNextLine()){
                String str = s.nextLine();
                //System.out.println("here2"+" "+str);
                String[] str_split = str.split("#");
                //System.out.println("here3"+" "+str_split[1]+" "+id);
                if(str_split[0].equals(id)){
                    //System.out.println("...");
                    string[0] = str_split[1];
                    string[1] = str_split[2];
                    //System.out.println("here3");
                }
                    
            }
        } catch (FileNotFoundException ex) {
            Logger.getLogger(AvailableDoctorFXMLController.class.getName()).log(Level.SEVERE, null, ex);
        }
        //System.out.println(string[0]+" "+string[1]);
        return string;
    }
    
    public void saveInUserBinFile(){
        File f = null;
        FileOutputStream fos = null;
        DataOutputStream dos = null;
        
        try {
            f = new File("User.bin");
            if(f.exists()) fos = new FileOutputStream(f,true);
            else fos = new FileOutputStream(f);
            dos = new DataOutputStream(fos);
          
            dos.writeUTF(id);
            dos.writeUTF(password);
            dos.writeUTF(type);

        } catch (IOException ex) {
            Logger.getLogger(MainFXMLController.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            try {
                if(dos != null) dos.close();
            } catch (IOException ex) {
                Logger.getLogger(MainFXMLController.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }
    
    public void saveInProfilesTextFile(){
        String str = type + "#"+ id + "#"+ firstName + "#"+ lastName + "#"+ email + "#"+ phone + "#N/A\n";
        File f = null;
        FileWriter fw = null;
        try {

            f = new File("Profiles.txt");
            if(f.exists()) fw = new FileWriter(f,true);
            else fw = new FileWriter(f);
           
            fw.write(str);           
            
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
    
    public static boolean checkUserIdExistence(String userId){
        boolean exist = false;
        File f = null;
        FileInputStream fis = null;
        DataInputStream dis = null;
        String str1="", str2 = "", str3 ="";
        try {
            f = new File("User.bin");
            if(!f.exists()){
            }
            else{
                
                fis = new FileInputStream(f);
                dis = new DataInputStream(fis);
                while(true){
                    str1 = dis.readUTF();
                    str2 = dis.readUTF();
                    str3 = dis.readUTF();
                    if(str1.equals(userId)){
                        exist = true;
                        break;
                    }
                }
            }
        } catch (IOException ex) {
            Logger.getLogger(MainFXMLController.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            try {
                if(dis != null) dis.close();
            } catch (IOException ex) {
                Logger.getLogger(MainFXMLController.class.getName()).log(Level.SEVERE, null, ex);
            }
        } 
        return exist;
    }
    
    public void saveInLoggedInBinFile(){
        File f = null;
        FileOutputStream fos = null;
        DataOutputStream dos = null;
        
        try {
            f = new File("LoggedIn.bin");
            fos = new FileOutputStream(f);
            dos = new DataOutputStream(fos);
          
            dos.writeUTF(id);
            dos.writeUTF(type);

        } catch (IOException ex) {
            Logger.getLogger(MainFXMLController.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            try {
                if(dos != null) dos.close();
            } catch (IOException ex) {
                Logger.getLogger(MainFXMLController.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }
    
    public static boolean checkIdPasswordMatch(String id1, String password1, String type1){
        boolean match = false;
        File f = null;
        FileInputStream fis = null;
        DataInputStream dis = null;
        String str1="", str2 = "", str3="";
        try {
            f = new File("User.bin");
            if(!f.exists()){
            }
            else{
                
                fis = new FileInputStream(f);
                dis = new DataInputStream(fis);
                while(true){
                    str1 = dis.readUTF();
                    str2 = dis.readUTF();
                    str3 = dis.readUTF();
                    if(str1.equals(id1) && str2.equals(password1) && str3.equals(type1)){
                        match = true;
                        break;
                    }
                }
            }
        } catch (IOException ex) {
            Logger.getLogger(MainFXMLController.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            try {
                if(dis != null) dis.close();
            } catch (IOException ex) {
                Logger.getLogger(MainFXMLController.class.getName()).log(Level.SEVERE, null, ex);
            }
        } 
        return match;
    }

    @Override
    public String[] viewProfile() {
        String[] string = new String[6];
        File f = null;
        Scanner s = null;
        try {
            
            f = new File("Profiles.txt");
            s = new Scanner(f);
            while(s.hasNextLine()){
                String str = s.nextLine();
                String[] str_split = str.split("#");
                if(this.id.equals(str_split[1])){
                    string[0] = str_split[0];
                    string[1] = str_split[2];
                    string[2] = str_split[3];
                    string[3] = str_split[4];
                    string[4] = str_split[5];
                    string[5] = str_split[6];
                }
            }
            
        } catch (FileNotFoundException ex) {
            Logger.getLogger(User.class.getName()).log(Level.SEVERE, null, ex);
        }
        return string;
    }
    
    @Override
    public void editProfile(){
        String string = "";
        File f = new File("Profiles.txt");
        Scanner s = null;
        try {
            s = new Scanner(f);
            while(s.hasNextLine()){
                String str = s.nextLine();
                String[] str_split = str.split("#");
                if(this.id.equals(str_split[1]))
                    string += str_split[0]+ "#" + str_split[1] + "#" + this.firstName+ "#" + this.lastName + "#" + 
                            this.email + "#" + this.phone + "#" + str_split[6] + "\n";
                else
                    string += str+"\n";
                
            }
                       
        } catch (FileNotFoundException ex) {
            Logger.getLogger(User.class.getName()).log(Level.SEVERE, null, ex);
        }
        if(f.delete()){}
        try {
            f.createNewFile();
            FileWriter fw = new FileWriter(f);
            fw.write(string);
            fw.close();
        } catch (IOException ex) {
            Logger.getLogger(User.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
