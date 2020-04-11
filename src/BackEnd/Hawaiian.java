package BackEnd;

import java.util.ArrayList;

public class Hawaiian extends Pizza {

    int SMALL = 8;
    int MEDIUM = 10;
    int LARGE = 12;

    public Hawaiian(String size, ArrayList<String> toppings){
        super("Hawaiian", size, toppings);
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
