package sample;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;

public class Option1 {
    private Main main;
    @FXML
    private Button playername;

    @FXML
    private Button clubandcountryname;

    @FXML
    private Button position;

    @FXML
    private Button salaryrange;

    @FXML
    private Button countrywiseplayercount;

    @FXML
    private Button backtomainmenu;

    @FXML
    void backtomainmenu(ActionEvent event) throws Exception {
     main.showMain();
    }

    @FXML
    void clubandcountryname(ActionEvent event) throws Exception{
    main.giveClubandCountryname();
    }

    @FXML
    void countrywiseplayercount(ActionEvent event) throws Exception {
    main.giveCountrywiseplayercount();
    }

    @FXML
    void playername(ActionEvent event) throws Exception{
    main.givePlayername();
    }

    @FXML
    void position(ActionEvent event) throws Exception {
    main.givePosition();
    }

    @FXML
    void salaryrange(ActionEvent event) throws Exception {
    main.giveSalaryrange();
    }
    void setMain(Main main) {
        this.main = main;
    }
}
