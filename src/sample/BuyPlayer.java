package sample;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TableCell;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.util.Callback;

import java.io.IOException;
import java.util.List;

public class BuyPlayer {
    private Main main;
    @FXML
    private TableView<Player> tableview;
    @FXML
    private Button mainmenu;
    @FXML
    private Button refresh;
    @FXML
    void refresh(ActionEvent event) {
        try {
            main.getinfoforbuy();
        } catch (IOException e) {
            e.printStackTrace();
        }
        main.Buyplayer();
    }
    @FXML
    void mainmenu(ActionEvent event) throws Exception {
        main.set(0);
        main.showMain();
    }
    ObservableList<Player> list;
    private List<Player> tmpList;
    public void init() {
        initializec();
        list= FXCollections.observableArrayList(tmpList);
        tableview.setEditable(true);
        tableview.setItems(list);
    }
    public void load(List<Player>tmpList) {

        list= FXCollections.observableArrayList(tmpList);
        tableview.setEditable(true);
        tableview.setItems(list);
    }
    public void setMain(Main main, List<Player> tmpList) {

        this.main = main;
        this.tmpList=tmpList;
    }
    public void initializec()
    {
        addButtonToTable();
        TableColumn<Player,String> name=new TableColumn<>("name");
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
    private void addButtonToTable() {
        TableColumn<Player, Void> colBtn = new TableColumn("Action");

        Callback<TableColumn<Player, Void>, TableCell<Player, Void>> cellFactory = new Callback<TableColumn<Player, Void>, TableCell<Player, Void>>() {
            @Override
            public TableCell<Player, Void> call(final TableColumn<Player, Void> param) {
                final TableCell<Player, Void> cell = new TableCell<Player, Void>() {

                    private final Button btn = new Button("Buy Player");

                    {
                        btn.setOnAction((ActionEvent event) -> {
                            Player t = getTableView().getItems().get(getIndex());
                            Player selectedItem = tableview.getSelectionModel().getSelectedItem();
                            tableview.getItems().remove(selectedItem);
                            try {
                                main.add(t);
                                main.med();
                            } catch (IOException e) {
                                e.printStackTrace();
                            }
                        });
                    }

                    @Override
                    public void updateItem(Void item, boolean empty) {
                        super.updateItem(item, empty);
                        if (empty) {
                            setGraphic(null);
                        } else {
                            setGraphic(btn);
                        }
                    }
                };
                return cell;
            }
        };

        colBtn.setCellFactory(cellFactory);

        tableview.getColumns().add(colBtn);

    }
}
