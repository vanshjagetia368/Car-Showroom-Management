import java.util.*;

public class Showroom implements utility{
    String showroom_id;
    String showroom_name;
    String showroom_address;
    String manager_name;
    int total_employees=0;
    int total_cars_in_stock=0;
    double total_revenue=0;

    ArrayList<Employees> employees=new ArrayList<>();
    ArrayList<Cars> cars=new ArrayList<>();

    @Override
    public void get_details(){
        System.out.println("SHOWROOM ID: "+showroom_id);
        System.out.println("NAME: "+showroom_name);
        System.out.println("ADDRESS: "+showroom_address);
        System.out.println("MANAGER: "+manager_name);
        System.out.println("TOTAL EMPLOYEES: "+total_employees);
        System.out.println("TOTAL CARS: "+total_cars_in_stock);
        System.out.println("TOTAL REVENUE: "+total_revenue);
    }

    @Override
    public void set_details(Scanner sc){
        showroom_id=UUID.randomUUID().toString();
        System.out.println("ENTER SHOWROOM DETAILS");
        System.out.print("SHOWROOM NAME: ");
        showroom_name=sc.nextLine();
        System.out.print("SHOWROOM ADDRESS: ");
        showroom_address=sc.nextLine();
        System.out.print("MANAGER NAME: ");
        manager_name=sc.nextLine();
    }

    public void addEmployee(Employees e){
        employees.add(e);
        total_employees++;
    }

    public void removeEmployee(String id){
        Iterator<Employees> it=employees.iterator();
        while(it.hasNext()){
            if(it.next().emp_id.equals(id)){
                it.remove();
                total_employees--;
                break;
            }
        }
    }

    public void addCar(Cars c){
        cars.add(c);
        total_cars_in_stock++;
    }

    public void sellCar(String id){
        Iterator<Cars> it=cars.iterator();
        while(it.hasNext()){
            Cars c=it.next();
            if(c.car_id.equals(id)){
                total_revenue+=c.car_price;
                it.remove();
                total_cars_in_stock--;
                break;
            }
        }
    }

    public void showEmployees(){
        for(Employees e:employees) e.get_details();
    }

    public void showCars(){
        for(Cars c:cars) c.get_details();
    }
}
