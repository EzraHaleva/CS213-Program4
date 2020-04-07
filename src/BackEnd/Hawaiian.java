package BackEnd;

import java.util.ArrayList;

public class Hawaiian extends Pizza {

    public Hawaiian(String size, ArrayList<String> toppings){
        super("Hawaiian", size, toppings);
    }
    public int pizzaPrice(){
        int price = 8;
        if(super.size.equals("Medium")){
            price = 10;
        } else if(super.size.equals("Large")){
            price = 12;
        }
        return price;
    }

}
