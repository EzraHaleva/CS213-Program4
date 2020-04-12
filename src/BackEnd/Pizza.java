package BackEnd;

import java.util.ArrayList;

/**
 * Abstract class for Pizza.
 *
 * @author Ezra Haleva
 */
public abstract class Pizza {
    protected String style;
    protected String size;
    protected ArrayList<String> toppings;

    /**
     * Constructor used for a Pizza with toppings.
     * @param style String Build Your Own, Deluxe or Hawaiian
     * @param size  String size of pizza
     * @param toppings  String list of toppings
     */
    public Pizza(String style, String size, ArrayList<String> toppings) {
        this.style = style;
        this.size = size;
        this.toppings = toppings;
    }

    /**
     * Constructor used when there is not a list of toppings.
     * @param style String Build Your Own, Deluxe or Hawaiian
     * @param size  String size of pizza
     */
    public Pizza(String style, String size) {
        this.style = style;
        this.size = size;
    }

    /**
     * Abstract method for subclasses to implement pizza price.
     * @return int total price of pizza
     */
    public abstract int pizzaPrice();

    /**
     * Generates a String representation of Pizza.
     * @return String
     */
    public String toString(){
        String output = "";
        output += "Style: " + style + ", ";
        output += "Size: " + size + ", ";
        output += "Toppings: ";
        for(String topping : toppings){
            output += topping + ", ";
        }
        output += "Price: $" + pizzaPrice() + "\n";
        return output;
    }
}
