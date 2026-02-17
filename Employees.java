import java.util.*;

public class Employees implements utility{
    String emp_id;
    String emp_name;
    int emp_age;
    String emp_department;
    String assigned_showroom;

    @Override
    public void get_details(){
        System.out.println("EMPLOYEE ID: "+emp_id);
        System.out.println("NAME: "+emp_name);
        System.out.println("AGE: "+emp_age);
        System.out.println("DEPARTMENT: "+emp_department);
        System.out.println("SHOWROOM: "+assigned_showroom);
        System.out.println("--------------------------------");
    }

    @Override
    public void set_details(Scanner sc){
        emp_id=UUID.randomUUID().toString();
        System.out.println("ENTER EMPLOYEE DETAILS");
        System.out.print("NAME: ");
        emp_name=sc.nextLine();
        do{
            System.out.print("AGE: ");
            emp_age=sc.nextInt();
        }while(emp_age<=18);
        sc.nextLine();
        System.out.print("DEPARTMENT: ");
        emp_department=sc.nextLine();
        System.out.print("ASSIGNED SHOWROOM: ");
        assigned_showroom=sc.nextLine();
    }

    public void updateDepartment(String dept){
        emp_department=dept;
    }
}
