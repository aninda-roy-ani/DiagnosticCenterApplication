/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javas;

/**
 *
 * @author Dell
 */
public class EmployeeType {
    private String desig;
    private String salary;

    public EmployeeType(String desig, String salary) {
        this.desig = desig;
        this.salary = salary;
    }

    public String getDesig() {
        return desig;
    }

    public void setDesig(String desig) {
        this.desig = desig;
    }

    public String getSalary() {
        return salary;
    }

    public void setSalary(String salary) {
        this.salary = salary;
    }
    
    
    
}
