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

/**
 * Class used to represent all information associated with a single pizza
 * order.
 */
public class PizzaOrder {
    static ArrayList<Pizza> pizzaList;

    /**
     * Initializes pizzalist to empty.
     */
    public PizzaOrder(){
        this.pizzaList = new ArrayList<Pizza>();
    }

    /**
     * Seems redundant, as it does the same things as default constructor.
     */
    public static void initialize(){
        pizzaList = new ArrayList<Pizza>();
    }

    /**
     * Creates specifies pizza and adds to pizza order list.
     * @param style Specifies what style of pizza
     * @param size  Specifies size of pizza
     * @param toppings  A list of toppings on pizza
     */
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

    /**
     * Clears the pizza order by assigning a new list of of pizzas to the
     * pizzaList variable.
     */
    public static void clearOrder(){
        pizzaList = new ArrayList<Pizza>();
    }

    /**
     * Returns the total cost of order by summing up the cost of each pizza
     * in list.
     * @return Total cost of order.
     */
    public static int orderTotal(){
        int orderTotal = 0;
        for(Pizza pizza : pizzaList){
            orderTotal += pizza.pizzaPrice();
        }
        return orderTotal;
    }

    /**
     * Returns details of pizzaList as a String.
     * @return String detail of pizzaList.
     */
    public static String details(){
        StringBuilder output = new StringBuilder();
        for(Pizza pizza : pizzaList){
            output.append(pizza.toString());
        }
        int orderTotal = orderTotal();
        output.append("Total cost of order: $");
        output.append(orderTotal).append("\n");
        return output.toString();
    }



}
