package BackEnd;

import java.util.ArrayList;

public class Deluxe extends Pizza {

    int SMALL = 14;
    int MEDIUM = 16;
    int LARGE = 18;

    public Deluxe(String size, ArrayList<String> toppings){
        super("Deluxe", size, toppings);
    }
    public int pizzaPrice(){
        int price = SMALL;
        if(super.size.equals("Medium")){
            price = MEDIUM;
        } else if(super.size.equals("Large")){
            price = LARGE;
        }
        return price;
    }


}
