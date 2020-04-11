package BackEnd;

import java.util.ArrayList;

public class BuildYourOwn extends Pizza {
    public BuildYourOwn(String size, ArrayList<String> toppings){
        super("Build Your Own", size, toppings);
    }

    public int pizzaPrice(){
        int basePrice = 5;
        if (size.equals("Medium")) {
            basePrice+=2;
        } else if (size.equals("Large")) {
            basePrice+=4;
        }
        int numToppings = toppings.size();
        return basePrice + numToppings * 2;
    }
}
