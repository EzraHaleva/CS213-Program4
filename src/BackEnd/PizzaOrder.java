package BackEnd;

import java.util.ArrayList;

/**
 * Class used to represent all information associated with a single pizza
 * order.
 *
 * @author Ezra Haleva
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
     * Calls default constructor, initializing the pizza list.
     */
    public static void initialize(){
        pizzaList = new ArrayList<Pizza>();
    }

    /**
     * Creates specified pizza and adds to pizza order list.
     * @param style Specifies what style of pizza
     * @param size  Specifies size of pizza
     * @param toppings  A list of toppings on pizza
     */
    public static Pizza addPizzaToOrder(String style, String size, ArrayList<String> toppings){
        if(style.equals("Build Your Own")){
            BuildYourOwn pizzaToAdd = new BuildYourOwn(size, toppings);
            pizzaList.add(pizzaToAdd);
            return pizzaToAdd;
        } else if(style.equals("Hawaiian")){
            Hawaiian pizzaToAdd = new Hawaiian(size, toppings);
            pizzaList.add(pizzaToAdd);
            return pizzaToAdd;
        } else if(style.equals("Deluxe")){
            Deluxe pizzaToAdd = new Deluxe(size, toppings);
            pizzaList.add(pizzaToAdd);
            return pizzaToAdd;
        }
        return null;
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
