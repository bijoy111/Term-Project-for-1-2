package sample;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;

public class Searchsalaryrange {
    private Main main;
    @FXML
    private TextField lowerbound;

    @FXML
    private TextField upperbound;

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
        String lb = lowerbound.getText();
        String ub = upperbound.getText();
        Double llb=Double.parseDouble(lb);
        Double uub=Double.parseDouble(ub);
        main.showsalaryrange(llb,uub);
    }
    void setMain(Main main) {
        this.main = main;
    }
}
