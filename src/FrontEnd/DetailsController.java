package FrontEnd;

import BackEnd.Pizza;
import BackEnd.PizzaOrder;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.stage.Stage;

import java.net.URL;
import java.util.ResourceBundle;

public class DetailsController implements Initializable {

    @FXML
    TextArea textArea;

    @FXML
    Button backButton;

    /**
     * Clears entire order history.
     * Invoked when 'Clear Selection' Button is clicked.
     */
    public void clear(){
        PizzaOrder.clearOrder();
        textArea.appendText("\nYour order has been cleared\n");
        textArea.appendText(PizzaOrder.details());
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        textArea.appendText(PizzaOrder.details());
    }

    @FXML
    public void close(){
        Stage stage = (Stage) backButton.getScene().getWindow();
        stage.close();
    }
}
