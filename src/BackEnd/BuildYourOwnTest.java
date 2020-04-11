package BackEnd;

import java.util.ArrayList;
import static org.junit.Assert.*;

/**
 * Class used to test BuildYourOwn method.
 * Tests the pizzaPrice method.
 *
 * @author Robert Bonagura
 */
public class BuildYourOwnTest {

   /**
    * Test pizzaPrice method
    * For each size pizza test pizza price using 2, 4 and 6 toppings each.
    */
   @org.junit.Test
   public void pizzaPrice() {

      ArrayList<String> toppings1 = new ArrayList<>();
      ArrayList<String> toppings2 = new ArrayList<>();
      ArrayList<String> toppings3 = new ArrayList<>();

      toppings1.add("Cheese");
      toppings1.add("Pepperoni");

      toppings2.add("Cheese");
      toppings2.add("Pepperoni");
      toppings2.add("Sausage");
      toppings2.add("Onion");

      toppings3.add("Cheese");
      toppings3.add("Pepperoni");
      toppings3.add("Sausage");
      toppings3.add("Onion");
      toppings3.add("Ham");
      toppings3.add("Pineapple");

      BuildYourOwn smallPizza1 = new BuildYourOwn("Small", toppings1);
      BuildYourOwn smallPizza2 = new BuildYourOwn("Small", toppings2);
      BuildYourOwn smallPizza3 = new BuildYourOwn("Small", toppings3);
      BuildYourOwn medPizza1 = new BuildYourOwn("Medium", toppings1);
      BuildYourOwn medPizza2 = new BuildYourOwn("Medium", toppings2);
      BuildYourOwn medPizza3 = new BuildYourOwn("Medium", toppings3);
      BuildYourOwn largePizza1 = new BuildYourOwn("Large", toppings1);
      BuildYourOwn largePizza2 = new BuildYourOwn("Large", toppings2);
      BuildYourOwn largePizza3 = new BuildYourOwn("Large", toppings3);

      assertEquals(5 + (2 * 2), smallPizza1.pizzaPrice());
      assertEquals(5 + (2 * 4), smallPizza2.pizzaPrice());
      assertEquals(5 + (2 * 6), smallPizza3.pizzaPrice());
      assertEquals(7 + (2 * 2), medPizza1.pizzaPrice());
      assertEquals(7 + (2 * 4), medPizza2.pizzaPrice());
      assertEquals(7 + (2 * 6), medPizza3.pizzaPrice());
      assertEquals(9 + (2 * 2), largePizza1.pizzaPrice());
      assertEquals(9 + (2 * 4), largePizza2.pizzaPrice());
      assertEquals(9 + (2 * 6), largePizza3.pizzaPrice());

   }
}