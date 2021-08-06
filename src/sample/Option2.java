package sample;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;

public class Option2 {
    private Main main;
    @FXML
    private Button maximumsalary;

    @FXML
    private Button maximumage;

    @FXML
    private Button maximumheight;

    @FXML
    private Button yearlysalary;

    @FXML
    private Button backtomainmenu;

    @FXML
    void backtomainmenu(ActionEvent event) throws Exception {
        main.showMain();
    }

    @FXML
    void maximumage(ActionEvent event) throws Exception {
        main.showmaxage();
    }

    @FXML
    void maximumheight(ActionEvent event) throws Exception {
        main.showmaxheight();
    }

    @FXML
    void maximumsalary(ActionEvent event) throws Exception {
        main.showmaxsalary();
    }

    @FXML
    void totalyearlysalary(ActionEvent event) throws Exception {
        main.showtotalsalary();
    }

    void setMain(Main main) {
        this.main = main;
    }
}
