package FrontEnd;

import BackEnd.BuildYourOwn;
import BackEnd.Deluxe;
import BackEnd.Hawaiian;
import BackEnd.PizzaOrder;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.ComboBox;
import javafx.scene.control.ListView;
import javafx.scene.control.TextArea;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.stage.Stage;

import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;

/**
 * Controller for FXML Order Screen GUI.
 *
 * @author Ezra Haleva
 * @author Robert Bonagura
 */
public class OrderScreenController implements Initializable {

    int MIN_TOPPINGS = 1;
    int MAX_TOPPINGS = 6;

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
    @FXML
    TextArea textArea;

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
        detailsStage.setScene(new Scene(root, 700, 350));
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
        switch (style){
            case "Build Your Own": {
                if (!isValidNumToppings(toppings)) {
                    String toppingError = createToppingError(toppings);
                    textArea.appendText(toppingError);
                    return;
                }
                BuildYourOwn pizza = new BuildYourOwn(size, toppings);
                textArea.appendText(pizza.toString());
                break;
            }
            case "Hawaiian": {
                Hawaiian pizza = new Hawaiian(size, toppings);
                textArea.appendText(pizza.toString());
                break;
            }
            case "Deluxe": {
                Deluxe pizza = new Deluxe(size, toppings);
                textArea.appendText(pizza.toString());
            }
        }
        PizzaOrder.addPizzaToOrder(style, size, toppings);
        resetGUI();

    }

    /**
     * Checks if there is no less than 1 and no more than 6 toppings.
     * @param toppings
     * @return
     */
    private boolean isValidNumToppings(ArrayList<String> toppings){
        if (toppings.size() < MIN_TOPPINGS || toppings.size() > MAX_TOPPINGS){
            return false;
        }
        return true;

    }

    /**
     * Create topping error based on number of toppings.
     */
    private String createToppingError(ArrayList<String> toppings){
        String error;
        if (toppings.size() < MIN_TOPPINGS){
            error = "Please select at least one topping\n";
        } else {
            error = "Please select at most 6 toppings\n";
        }
        return error;
    }

    /**
     * Reset GUI to default setting.
     * Style set to Build Your Own, size set to Medium and all Selected
     * Toppings are cleared.
     */
    private void resetGUI(){
        clearSelection();
        pizzaSizeComboBox.getSelectionModel().select("Medium");
        pizzaTypeComboBox.getSelectionModel().select("Build Your Own");
        pizzaImage.setImage(new Image("/Assets/BuildYourOwn.jpg"));
        allToppings.getItems().addAll("Beef", "Cheese", "Chicken",
                "Green Pepper", "Ham", "Mushroom", "Onion", "Pepperoni",
                "Pineapple", "Sausage");
    }
}
