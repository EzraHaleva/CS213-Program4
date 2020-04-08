package FrontEnd;

import BackEnd.PizzaOrder;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.ComboBox;
import javafx.scene.control.ListView;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.stage.Stage;

import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;

/**
 * Controller for FXML Order Screen GUI.
 */
public class OrderScreenController implements Initializable {
    @FXML
    ComboBox pizzaTypeComboBox;
    @FXML
    ComboBox pizzaSizeComboBox;
    @FXML
    ImageView pizzaImage;
    @FXML
    ListView allToppings, selectedToppings;
    @FXML
    Parent customToppingFunctionality;

    /**
     * Initializes ComboBoxes, ImageView and ListView to default values.
     * @param location
     * @param resources
     */
    public void initialize(URL location, ResourceBundle resources){
        pizzaSizeComboBox.getItems().addAll("Small", "Medium", "Large");
        pizzaSizeComboBox.getSelectionModel().select("Medium");
        pizzaTypeComboBox.getItems().addAll("Build Your Own", "Hawaiian",
                "Deluxe");
        pizzaTypeComboBox.getSelectionModel().select("Build Your Own");

        pizzaImage.setImage(new Image("/Assets/BuildYourOwn.jpg"));

        allToppings.getItems().addAll("Beef", "Cheese", "Chicken",
                "Green Pepper", "Ham", "Mushroom", "Onion", "Pepperoni",
                "Pineapple", "Sausage");
    }

    /**
     * Updates pizzaImage and selectable toppings when a new pizzaType is
     * selected.
     */
    @FXML
    public void selectPizzaType(){
        String pizzaType = (String) pizzaTypeComboBox.getSelectionModel().getSelectedItem();

        if (pizzaType.equals("Build Your Own")) {
            pizzaImage.setImage(new Image("/Assets/BuildYourOwn.jpg"));
            selectedToppings.getItems().clear();
            customToppingFunctionality.setDisable(false);
        } else if(pizzaType.equals("Hawaiian")){
            pizzaImage.setImage(new Image("/Assets/Hawaiian.jpg"));
            customToppingFunctionality.setDisable(true);
            selectedToppings.getItems().clear();
            selectedToppings.getItems().addAll("Ham", "Pineapple");
        } else if(pizzaType.equals("Deluxe")){
            pizzaImage.setImage(new Image("/Assets/Deluxe.jpg"));
            customToppingFunctionality.setDisable(true);
            selectedToppings.getItems().clear();
            selectedToppings.getItems().addAll("Sausage", "Pepperoni",
                    "Green Pepper","Onion","Mushroom");
        }
    }

    /**
     * Takes selected topping from left-side ListView, and moves it to the
     * right-side ListView.
     */
    @FXML
    public void addTopping(){
        String topping = (String)allToppings.getSelectionModel().getSelectedItem();
        if(topping != null && !selectedToppings.getItems().contains(topping)){
            selectedToppings.getItems().add(topping);
        }
    }

    /**
     * Removes selected topping from selectedToppings ListView.
     */
    @FXML
    public void removeTopping() {
        String topping = (String) selectedToppings.getSelectionModel().getSelectedItem();
        if(topping == null && !selectedToppings.getItems().isEmpty())
            topping = (String)selectedToppings.getItems().get(0);
        selectedToppings.getItems().remove(topping);
    }

    /**
     * Clears all selected toppings from ListView.
     */
    @FXML
    public void clearSelection(){
        selectedToppings.getItems().clear();
    }

    /**
     * Creates new stage and sets scene for Order Details page.
     * @throws Exception
     */
    @FXML
    public void openDetailsScreen()throws Exception{
        Stage detailsStage = new Stage();
        Parent root = FXMLLoader.load(getClass().getResource("DetailsStage.fxml"));
        detailsStage.setTitle("Details");
        detailsStage.setScene(new Scene(root, 360, 350));
        detailsStage.show();
        detailsStage.setResizable(false);
    }

    /**
     * Adds pizza to list based on style, size and toppings selected.
     */
    @FXML
    public void addPizzaToOrder(){
        String style = (String) pizzaTypeComboBox.getSelectionModel().getSelectedItem();
        String size = (String) pizzaSizeComboBox.getSelectionModel().getSelectedItem();
        ArrayList<String> toppings = new ArrayList<String>();
        for(Object topping : selectedToppings.getItems()){
            toppings.add((String)topping);
        }
        PizzaOrder.addPizzaToOrder(style, size, toppings);
        System.out.print(PizzaOrder.details());
    }

}
