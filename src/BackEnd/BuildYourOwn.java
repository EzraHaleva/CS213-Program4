package BackEnd;

import java.util.ArrayList;

/**
 * Class used to represent a Build Your Own pizza.
 *
 * @author Ezra Haleva
 * @author Robert Bonagura
 */
public class BuildYourOwn extends Pizza {

    int SMALL = 5;
    int MEDIUM = 7;
    int LARGE = 9;
    int PRICE_PER_TOPPING = 2;

    /**
     * Constructor for BuildYourOwn.
     * @param size  String specifying pizza size
     * @param toppings A String list of toppings
     */
    public BuildYourOwn(String size, ArrayList<String> toppings){
        super("Build Your Own", size, toppings);
    }

    /**
     * Determine the price of the pizza based on size and toppings.
     * @return  int total price of pizza
     */
    public int pizzaPrice(){
        int basePrice = SMALL;
        if (size.equals("Medium")) {
            basePrice = MEDIUM;
        } else if (size.equals("Large")) {
            basePrice = LARGE;
        }
        int numToppings = toppings.size();
        return basePrice + (numToppings * PRICE_PER_TOPPING);
    }
}
