package FrontEnd;

import BackEnd.PizzaOrder;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

/**
 * Main class to run Pizza Store application.
 *
 * @author Ezra Haleva
 * @author Robert Bonagura
 */
public class Main extends Application {

    /**
     * Creates stage for Pizza Store app.
     * Initialize the PizzaOrder.
     * @param primaryStage
     * @throws Exception
     */
    @Override
    public void start(Stage primaryStage) throws Exception{
        Parent root = FXMLLoader.load(getClass().getResource("OrderScreenStage.fxml"));
        primaryStage.setTitle("Pizza Store");
        primaryStage.setScene(new Scene(root, 600, 618));
        primaryStage.show();
        primaryStage.setResizable(false);
        PizzaOrder.initialize();
    }

    /**
     * Main method to launch application.
     * @param args
     */
    public static void main(String[] args) {
        launch(args);
    }
}
