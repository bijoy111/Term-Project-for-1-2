package sample;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;

public class Printtotalsalary {
    private Main main;
    @FXML
    private Label message;
    @FXML
    private Button mainmenu;

    @FXML
    void mainmenu(ActionEvent event) throws Exception {
        main.showMain();
    }
    public void init(String msg) {
        message.setText(msg);
    }
    void setMain(Main main) {
        this.main = main;
    }
}
