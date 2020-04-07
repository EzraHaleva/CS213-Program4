package BackEnd;

import java.util.ArrayList;

public class Deluxe extends Pizza {
    public Deluxe(String size, ArrayList<String> toppings){
        super("Deluxe", size, toppings);
    }
    public int pizzaPrice(){
        int price = 14;
        if(super.size.equals("Medium")){
            price = 16;
        } else if(super.size.equals("Large")){
            price = 18;
        }
        return price;
    }


}
