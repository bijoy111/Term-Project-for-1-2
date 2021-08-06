package sample;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;

import java.io.IOException;

public class Controller {
    private Main main;
    @FXML
    private Button searchplayer;

    @FXML
    private Button searchclubs;


    @FXML
    private Button sellplayer;

    @FXML
    private Button buyplayer;

    @FXML
    private Button exit;
    @FXML
    void buyplayer(ActionEvent event) {
        try {
            main.getinfoforbuy();
        } catch (IOException e) {
            e.printStackTrace();
        }
        main.set(1);
        main.Buyplayer();
    }
    @FXML
    void sellplayer(ActionEvent event) {
main.Sellplayer();
    }

    @FXML
    void exit(ActionEvent event) {
        System.exit(0);
    }

    @FXML
    void searchclubs(ActionEvent event) throws Exception {
          main.showOption2();
    }

    @FXML
    void searchplayer(ActionEvent event) throws Exception {
           main.showOption1();
    }
    void setMain(Main main) {
        this.main = main;
    }


}
