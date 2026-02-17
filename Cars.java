import java.util.*;

public class Cars implements utility{
    String car_id;
    String car_name;
    String car_color;
    String car_fuel_type;
    int car_price;
    String car_type;
    String car_transmission;
    String showroom_name;

    @Override
    public void get_details(){
        System.out.println("CAR ID: "+car_id);
        System.out.println("NAME: "+car_name);
        System.out.println("COLOR: "+car_color);
        System.out.println("FUEL: "+car_fuel_type);
        System.out.println("PRICE: "+car_price);
        System.out.println("TYPE: "+car_type);
        System.out.println("TRANSMISSION: "+car_transmission);
        System.out.println("SHOWROOM: "+showroom_name);
        System.out.println("--------------------------------");
    }

    @Override
    public void set_details(Scanner sc){
        car_id=UUID.randomUUID().toString();
        System.out.println("ENTER CAR DETAILS");
        System.out.print("CAR NAME: ");
        car_name=sc.nextLine();
        System.out.print("COLOR: ");
        car_color=sc.nextLine();
        System.out.print("FUEL TYPE: ");
        car_fuel_type=sc.nextLine();
        do{
            System.out.print("PRICE: ");
            car_price=sc.nextInt();
        }while(car_price<=0);
        sc.nextLine();
        System.out.print("CAR TYPE: ");
        car_type=sc.nextLine();
        System.out.print("TRANSMISSION: ");
        car_transmission=sc.nextLine();
        System.out.print("SHOWROOM NAME: ");
        showroom_name=sc.nextLine();
    }
}
