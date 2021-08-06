package sample;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;

import java.util.List;

public class Searchcountrywiseplayercount {
    private Main main;
    @FXML
    private TableView<Country> tableview;
    @FXML
    private Button back;

    @FXML
    void back(ActionEvent event) throws Exception {
main.showOption1();
    }
    ObservableList<Country> list;
    private List<Country> tmpList;

    public void init() {
        initializec();
        list= FXCollections.observableArrayList(tmpList);
        tableview.setEditable(true);
        tableview.setItems(list);
    }
    public void setMain(Main main, List<Country> tmpList) {

        this.main = main;
        this.tmpList=tmpList;
    }
    public void initializec()
    {
        TableColumn<Country,String> country=new TableColumn<>("country");
        country.setMinWidth(80);
        country.setCellValueFactory(new PropertyValueFactory<>("country"));
        TableColumn<Country,Integer>count=new TableColumn<>("count");
        count.setMinWidth(80);
        count.setCellValueFactory(new PropertyValueFactory<>("count"));
        tableview.getColumns().addAll(country,count);
    }
}
