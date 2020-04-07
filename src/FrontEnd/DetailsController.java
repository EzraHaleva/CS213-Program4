package FrontEnd;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.stage.Stage;

public class DetailsController {

    @FXML
    Button backButton;

    @FXML
    public void close(){
        Stage stage = (Stage) backButton.getScene().getWindow();
        stage.close();
    }
}
