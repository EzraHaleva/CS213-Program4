package BackEnd;
import java.util.ArrayList;
// CURRENT ISSUES
/* todo -currently able to place an order for a build your own with no toppings, minimum is 1

   todo -currently able to place an order for a build your own with more than 6 toppings, max is 6

        * For the toppings min and max, if we disable the add to order button when conditions
          aren't met, then we won't have to do error messages for those.

   todo -details screen does not show details, nor does clear order button work

   todo -output is not done yet, need to add error/success messages.


   I didn't do any JUnit testing or javadoc commenting. I can do javadoc at least on Sat night.
   Feel free to call or text if you have any questions about my code.
   -Ezra

 */
public class PizzaOrder {
    static ArrayList<Pizza> pizzaList;

    public PizzaOrder(){

        this.pizzaList = new ArrayList<Pizza>();
    }
    public static void initialize(){
        pizzaList = new ArrayList<Pizza>();
    }


    public static void addPizzaToOrder(String style, String size, ArrayList<String> toppings){
        if(style.equals("Build Your Own")){
            BuildYourOwn pizzaToAdd = new BuildYourOwn(size, toppings);
            pizzaList.add(pizzaToAdd);
        } else if(style.equals("Hawaiian")){
            Hawaiian pizzaToAdd = new Hawaiian(size, toppings);
            pizzaList.add(pizzaToAdd);
        } else if(style.equals("Deluxe")){
            Deluxe pizzaToAdd = new Deluxe(size, toppings);
            pizzaList.add(pizzaToAdd);
        }
    }
    public static void clearOrder(){
        pizzaList = new ArrayList<Pizza>();
    }

    public static int orderTotal(){
        int orderTotal = 0;
        for(Pizza pizza : pizzaList){
            orderTotal += pizza.pizzaPrice();
        }
        return orderTotal;
    }
    public static String details(){
        String output = "";
        for(Pizza pizza : pizzaList){
            output += pizza.toString();
        }
        int orderTotal = orderTotal();
        output += ("Total cost of order: $" + orderTotal + "\n");
        return output;
    }



}
