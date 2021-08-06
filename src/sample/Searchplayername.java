package sample;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;

public class Searchplayername {
    private Main main;
    @FXML
    private TextField playername;

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
        String playerName = playername.getText();
        main.showplayername(playerName);
    }

    void setMain(Main main) {
        this.main = main;
    }
}
