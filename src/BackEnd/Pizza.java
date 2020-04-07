package BackEnd;

import java.util.ArrayList;

public abstract class Pizza {
    protected String style;
    protected String size;
    protected ArrayList<String> toppings;

    public Pizza(String style, String size, ArrayList<String> toppings) {
        this.style = style;
        this.size = size;
        this.toppings = toppings;
    }

    public Pizza(String style, String size) {
        this.style = style;
        this.size = size;
    }

    public abstract int pizzaPrice();
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
