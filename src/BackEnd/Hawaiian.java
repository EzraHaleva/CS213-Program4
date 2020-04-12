package BackEnd;

import java.util.ArrayList;

/**
 * Class to represent a Hawaiian pizza.
 *
 * @author Ezra Haleva
 */
public class Hawaiian extends Pizza {

    int SMALL = 8;
    int MEDIUM = 10;
    int LARGE = 12;

    /**
     * Default constructor for Hawaiian pizza.
     * @param size
     * @param toppings
     */
    public Hawaiian(String size, ArrayList<String> toppings){
        super("Hawaiian", size, toppings);
    }

    /**
     * Calculates total price of pizza based on size.
     * @return int total price of pizza.
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
