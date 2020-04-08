package FrontEnd;

import BackEnd.PizzaOrder;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

/**
 * Main class to run Pizza Store application.
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


    public static void main(String[] args) {
        launch(args);
    }
}
