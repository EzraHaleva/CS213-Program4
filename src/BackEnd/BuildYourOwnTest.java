package BackEnd;

import java.lang.reflect.Array;
import java.util.ArrayList;

import static org.junit.Assert.*;

public class BuildYourOwnTest {

   @org.junit.Test
   public void pizzaPrice() {
      //5 steps
      int numTestCases = 9;
      BuildYourOwn[] testCases = new BuildYourOwn[numTestCases];

      ArrayList<String> toppings1 = new ArrayList<>();
      ArrayList<String> toppings2 = new ArrayList<>();
      ArrayList<String> toppings3 = new ArrayList<>();

      String cheese = "Cheese";
      String pepperoni = "Pepperoni";
      String sausage = "Sausage";
      String onion = "Onion";
      String ham = "Ham";
      String pineapple = "Pineapple";

      toppings1.add(cheese);
      toppings1.add(pepperoni);

      toppings2.add(cheese);
      toppings2.add(pepperoni);
      toppings2.add(sausage);
      toppings2.add(onion);

      toppings3.add(cheese);
      toppings3.add(pepperoni);
      toppings3.add(sausage);
      toppings3.add(onion);
      toppings3.add(ham);
      toppings3.add(pineapple);

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