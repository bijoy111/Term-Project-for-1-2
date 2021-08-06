package sample;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;

public class Searchposition {
    private Main main;
    @FXML
    private TextField position;

    @FXML
    private Button search;

    @FXML
    private Button back;

    @FXML
    void back(ActionEvent event) throws Exception {
        main.showOption1();
    }

    @FXML
    void search(ActionEvent event) {
        String Position = position.getText();
        main.showposition(Position);
    }

    void setMain(Main main) {
        this.main = main;
    }
}
