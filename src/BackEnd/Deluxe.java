package BackEnd;

import java.util.ArrayList;

/**
 * Class used to represent a Deluxe pizza.
 *
 * @author Ezra Haleva
 */
public class Deluxe extends Pizza {

    int SMALL = 14;
    int MEDIUM = 16;
    int LARGE = 18;

    /**
     * Constructor for Deluxe pizza.
     * @param size
     * @param toppings
     */
    public Deluxe(String size, ArrayList<String> toppings){
        super("Deluxe", size, toppings);
    }

    /**
     * Calculates the price of pizza based on the given size.
     * @return  int total price of pizza
     */
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
