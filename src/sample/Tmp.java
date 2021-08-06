package sample;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;

public class Tmp {
    private Main main;
    @FXML
    private TextField clubname;

    @FXML
    private TextField password;

    @FXML
    private Button submit;

    @FXML
    void submit(ActionEvent event) throws Exception {
        String name = clubname.getText();
        String pass=password.getText();
        main.sMain(name);
    }

    public void setMain(Main main) {
        this.main=main;
    }
}
