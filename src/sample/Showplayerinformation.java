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

public class Showplayerinformation {
    private Main main;
    @FXML
    private TableView<Player> tableview;
    @FXML
    private Button back;

    @FXML
    void back(ActionEvent event) throws Exception {
main.showOption1();
    }

    ObservableList<Player> list;
    private List<Player> tmpList;

    public void init() {
        initializec();
        list=FXCollections.observableArrayList(tmpList);
        tableview.setEditable(true);
        tableview.setItems(list);
    }

    public void setMain(Main main,List<Player>tmpList) {

        this.main = main;
        this.tmpList=tmpList;
    }

    public void initializec()
    {
        TableColumn<Player,String>name=new TableColumn<>("name");
        name.setMinWidth(80);
        name.setCellValueFactory(new PropertyValueFactory<>("name"));
        TableColumn<Player,String>country=new TableColumn<>("country");
        country.setMinWidth(80);
        country.setCellValueFactory(new PropertyValueFactory<>("country"));
        TableColumn<Player,Integer>age=new TableColumn<>("age");
        age.setMinWidth(80);
        age.setCellValueFactory(new PropertyValueFactory<>("age"));
        TableColumn<Player,Double>height=new TableColumn<>("height");
        height.setMinWidth(80);
        height.setCellValueFactory(new PropertyValueFactory<>("height"));
        TableColumn<Player,String>club=new TableColumn<>("club");
        club.setMinWidth(80);
        club.setCellValueFactory(new PropertyValueFactory<>("club"));
        TableColumn<Player,String>position=new TableColumn<>("position");
        position.setMinWidth(80);
        position.setCellValueFactory(new PropertyValueFactory<>("position"));
        TableColumn<Player,Integer>number=new TableColumn<>("number");
        number.setMinWidth(80);
        number.setCellValueFactory(new PropertyValueFactory<>("number"));
        TableColumn<Player,Double>salary=new TableColumn<>("wsalary");
        salary.setMinWidth(80);
        salary.setCellValueFactory(new PropertyValueFactory<>("wsalary"));
        tableview.getColumns().addAll(name,country,age,height,club,position,number,salary);
    }
}
