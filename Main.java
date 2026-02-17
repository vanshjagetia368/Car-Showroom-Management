import java.util.*;

public class Main{

    static void menu(){
        System.out.println("\n========= SHOWROOM MANAGEMENT SYSTEM =========");
        System.out.println("1.ADD SHOWROOM");
        System.out.println("2.ADD EMPLOYEE");
        System.out.println("3.ADD CAR");
        System.out.println("4.VIEW ALL SHOWROOMS");
        System.out.println("5.VIEW ALL EMPLOYEES");
        System.out.println("6.VIEW ALL CARS");
        System.out.println("7.SEARCH EMPLOYEE");
        System.out.println("8.SEARCH CAR");
        System.out.println("9.SELL CAR");
        System.out.println("10.DELETE EMPLOYEE");
        System.out.println("11.SHOW SHOWROOM DETAILS");
        System.out.println("0.EXIT");
        System.out.print("ENTER CHOICE: ");
    }

    public static void main(String[] args){
        Scanner sc=new Scanner(System.in);
        ArrayList<Showroom> showrooms=new ArrayList<>();
        ArrayList<Employees> employees=new ArrayList<>();
        ArrayList<Cars> cars=new ArrayList<>();
        int choice;

        do{
            menu();
            choice=sc.nextInt();
            sc.nextLine();

            switch(choice){

                case 1:
                    Showroom s=new Showroom();
                    s.set_details(sc);
                    showrooms.add(s);
                    System.out.println("SHOWROOM ADDED");
                    break;

                case 2:
                    Employees e=new Employees();
                    e.set_details(sc);
                    employees.add(e);
                    for(Showroom sh:showrooms)
                        if(sh.showroom_name.equalsIgnoreCase(e.assigned_showroom))
                            sh.addEmployee(e);
                    System.out.println("EMPLOYEE ADDED");
                    break;

                case 3:
                    Cars c=new Cars();
                    c.set_details(sc);
                    cars.add(c);
                    for(Showroom sh:showrooms)
                        if(sh.showroom_name.equalsIgnoreCase(c.showroom_name))
                            sh.addCar(c);
                    System.out.println("CAR ADDED");
                    break;

                case 4:
                    for(Showroom sh:showrooms) sh.get_details();
                    break;

                case 5:
                    for(Employees emp:employees) emp.get_details();
                    break;

                case 6:
                    for(Cars car:cars) car.get_details();
                    break;

                case 7:
                    System.out.print("ENTER EMPLOYEE ID: ");
                    String empId=sc.nextLine();
                    for(Employees emp:employees)
                        if(emp.emp_id.equals(empId)) emp.get_details();
                    break;

                case 8:
                    System.out.print("ENTER CAR NAME: ");
                    String carName=sc.nextLine();
                    for(Cars car:cars)
                        if(car.car_name.equalsIgnoreCase(carName)) car.get_details();
                    break;

                case 9:
                    System.out.print("ENTER CAR ID: ");
                    String sellId=sc.nextLine();
                    for(Showroom sh:showrooms) sh.sellCar(sellId);
                    cars.removeIf(car->car.car_id.equals(sellId));
                    System.out.println("CAR SOLD IF ID EXISTS");
                    break;

                case 10:
                    System.out.print("ENTER EMPLOYEE ID: ");
                    String delId=sc.nextLine();
                    for(Showroom sh:showrooms) sh.removeEmployee(delId);
                    employees.removeIf(emp->emp.emp_id.equals(delId));
                    System.out.println("EMPLOYEE REMOVED IF ID EXISTS");
                    break;

                case 11:
                    System.out.print("ENTER SHOWROOM NAME: ");
                    String name=sc.nextLine();
                    for(Showroom sh:showrooms)
                        if(sh.showroom_name.equalsIgnoreCase(name)){
                            sh.get_details();
                            System.out.println("EMPLOYEES:");
                            sh.showEmployees();
                            System.out.println("CARS:");
                            sh.showCars();
                        }
                    break;
            
                case 0:
                    System.out.println("THANK YOU");
                    break;
                    
                default:
                    System.out.println("INVALID CHOICE");
            }
        }while(choice!=0);
        sc.close();
    }
}
