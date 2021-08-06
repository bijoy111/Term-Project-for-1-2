package sample;

import javafx.application.Application;
import javafx.application.Platform;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Main extends Application {
    private Stage stage;
    public static List<Player> players;
    public  static List<Player> buylist;
    private String club;
    private BuyPlayer object;
    private boolean state;
    private NetworkUtil networkUtil;
    public void set(int t)
    {
        if(t==1)state=true;
        else if(t==0)state=false;
    }
    public boolean get()
    {
        return state;
    }
    public void update()
    {
        Platform.runLater(new Runnable() {
            @Override
            public void run() {
                try {
                    getinfoforbuy();
                } catch (IOException e) {
                    e.printStackTrace();
                }
                Buyplayer();
            }
        });

    }
    public Stage getStage() {
        return stage;
    }
    @Override
    public void start(Stage primaryStage) throws Exception {
        stage = primaryStage;
        soMain();
    }
    public void networkfix(NetworkUtil networkUtil)
    {
        this.networkUtil=networkUtil;
    }
    public static void fixed(List<Player> Players)
    {
        players=Players;
    }
    public static void buyfix(List<Player> List)
    {
        buylist=List;
    }
    public void delete(Player p) throws IOException {
        players.remove(p);
        forbuy playe = new forbuy();
        playe.setPlayer(p);
        playe.setClubofPlayer(club);
        networkUtil.write(playe);

    }
    public void med() throws IOException {
        sendall send=new sendall();
        send.set(club);
        networkUtil.write(send);
    }
    public void add(Player p) throws IOException {
        foraddinclub playe = new foraddinclub();
        playe.setPlayer(p);
        playe.setClubofPlayer(club);
        networkUtil.write(playe);
        p.setClub(club);
        players.add(p);
    }
    public void getinfoforbuy() throws IOException {
        takelistforbuy s=new takelistforbuy();
        s.set(club);
        networkUtil.write(s);
    }
    public void soMain() throws Exception {
        // XML Loading using FXMLLoader
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(getClass().getResource("tmp.fxml"));
        Parent root = loader.load();

        // Loading the controller
        Tmp controller = loader.getController();
        controller.setMain(this);

        // Set the primary stage
        stage.setTitle("Main");
        stage.setScene(new Scene(root, 600, 350));
        stage.show();
    }
    public void sMain(String name) throws Exception {
        String serverAddress = "127.0.0.1";
        int serverPort = 33333;
        club=name;
        Client client = new Client(serverAddress, serverPort,name, this,club);
        showMain();
    }
    public void showMain() throws Exception {
        // XML Loading using FXMLLoader

        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(getClass().getResource("sample.fxml"));
        Parent root = loader.load();

        // Loading the controller
        Controller controller = loader.getController();
        controller.setMain(this);

        // Set the primary stage
        stage.setTitle("Main");
        stage.setScene(new Scene(root, 600, 350));
        stage.show();
    }
    public void showOption1() throws Exception {
        // XML Loading using FXMLLoader
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(getClass().getResource("option1.fxml"));
        Parent root = loader.load();

        // Loading the controller
        Option1 controller = loader.getController();
        controller.setMain(this);

        // Set the primary stage
        stage.setTitle("Player Search");
        stage.setScene(new Scene(root, 600, 450));
        stage.show();
    }
    public void showOption2() throws Exception {
        // XML Loading using FXMLLoader
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(getClass().getResource("option2.fxml"));
        Parent root = loader.load();

        // Loading the controller
        Option2 controller = loader.getController();
        controller.setMain(this);

        // Set the primary stage
        stage.setTitle("Club Information");
        stage.setScene(new Scene(root, 600, 450));
        stage.show();
    }
    public void showmaxsalary()  {
        try {
            List<Player> tmpList = new ArrayList<>();
            double maxsalary=0;
            for (int i = 0; i < players.size(); i++)
            {
                Player t = players.get(i);
                if(t.getClub().equalsIgnoreCase(club))
                {
                    if(Double.compare(maxsalary,t.getWsalary())<0)
                    {
                        maxsalary=t.getWsalary();
                    }
                }
            }
            for (int i = 0; i < players.size(); i++)
            {
                Player t = players.get(i);
                if(t.getClub().equalsIgnoreCase(club))
                {
                    if(Double.compare(maxsalary,t.getWsalary())==0)
                    {
                        tmpList.add(t);
                    }
                }
            }
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(getClass().getResource("show.fxml"));
            Parent root = loader.load();

            // Loading the controller
            Show controller = loader.getController();


            controller.setMain(this, tmpList);
            controller.init();
            // Set the primary stage
            stage.setTitle("Max Salary");
            stage.setScene(new Scene(root, 600, 450));
            stage.show();
        }catch (Exception e)
        {
            System.out.println(e);
        }
    }
    public void showtotalsalary()  {
        try {
            int tmp = -1;
            double totalsalary=0;
            for (int i = 0; i < players.size(); i++)
            {
                Player t = players.get(i);
                if(t.getClub().equalsIgnoreCase(club))
                {
                    totalsalary+=t.getWsalary();
                    tmp=0;
                }
            }
            if(tmp==0)
            {
                totalsalary *= 365;
                totalsalary = totalsalary / 7;
            }
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(getClass().getResource("printtotalsalary.fxml"));
            Parent root = loader.load();

            // Loading the controller
            Printtotalsalary controller = loader.getController();

            String ts=String.valueOf(totalsalary);
            controller.setMain(this);
            controller.init(ts);
            // Set the primary stage
            stage.setTitle("Total Salary");
            stage.setScene(new Scene(root, 600, 450));
            stage.show();
        }catch (Exception e)
        {
            System.out.println(e);
        }
    }

    public void showmaxage()  {
        try {
            List<Player> tmpList = new ArrayList<>();
            double maxage=0;
            for (int i = 0; i < players.size(); i++)
            {
                Player t = players.get(i);
                if(t.getClub().equalsIgnoreCase(club))
                {
                    if(Double.compare(maxage,t.getAge())<0)
                    {
                        maxage=t.getAge();
                    }
                }
            }
            for (int i = 0; i < players.size(); i++)
            {
                Player t = players.get(i);
                if(t.getClub().equalsIgnoreCase(club))
                {
                    if(Double.compare(maxage,t.getAge())==0)
                    {
                        tmpList.add(t);
                    }
                }
            }
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(getClass().getResource("show.fxml"));
            Parent root = loader.load();

            // Loading the controller
            Show controller = loader.getController();


            controller.setMain(this, tmpList);
            controller.init();
            // Set the primary stage
            stage.setTitle("Max Age");
            stage.setScene(new Scene(root, 600, 450));
            stage.show();
        }catch (Exception e)
        {
            System.out.println(e);
        }
    }
    public void showmaxheight()  {
        try {
            List<Player> tmpList = new ArrayList<>();
            double maxheight=0;
            for (int i = 0; i < players.size(); i++)
            {
                Player t = players.get(i);
                if(t.getClub().equalsIgnoreCase(club))
                {
                    if(Double.compare(maxheight,t.getHeight())<0)
                    {
                        maxheight=t.getHeight();
                    }
                }
            }
            for (int i = 0; i < players.size(); i++)
            {
                Player t = players.get(i);
                if(t.getClub().equalsIgnoreCase(club))
                {
                    if(Double.compare(maxheight,t.getHeight())==0)
                    {
                        tmpList.add(t);
                    }
                }
            }
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(getClass().getResource("show.fxml"));
            Parent root = loader.load();

            // Loading the controller
            Show controller = loader.getController();


            controller.setMain(this, tmpList);
            controller.init();
            // Set the primary stage
            stage.setTitle("Max Height");
            stage.setScene(new Scene(root, 600, 450));
            stage.show();
        }catch (Exception e)
        {
            System.out.println(e);
        }
    }
    public void givePlayername() throws Exception {
        // XML Loading using FXMLLoader
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(getClass().getResource("searchplayername.fxml"));
        Parent root = loader.load();

        // Loading the controller
        Searchplayername controller = loader.getController();
        controller.setMain(this);

        // Set the primary stage
        stage.setTitle("PlayerName");
        stage.setScene(new Scene(root, 600, 450));
        stage.show();
    }
    public void givePosition() throws Exception {
        // XML Loading using FXMLLoader
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(getClass().getResource("searchposition.fxml"));
        Parent root = loader.load();

        // Loading the controller
        Searchposition controller = loader.getController();
        controller.setMain(this);

        // Set the primary stage
        stage.setTitle("Position");
        stage.setScene(new Scene(root, 600, 450));
        stage.show();
    }
    public void giveClubandCountryname() throws Exception {
        // XML Loading using FXMLLoader
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(getClass().getResource("searchclubandcountryname.fxml"));
        Parent root = loader.load();

        // Loading the controller
        Searchclubandcountryname controller = loader.getController();
        controller.setMain(this);

        // Set the primary stage
        stage.setTitle("Country Name");
        stage.setScene(new Scene(root, 600, 450));
        stage.show();
    }
    public void giveSalaryrange() throws Exception {
        // XML Loading using FXMLLoader
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(getClass().getResource("searchsalaryrange.fxml"));
        Parent root = loader.load();

        // Loading the controller
        Searchsalaryrange controller = loader.getController();
        controller.setMain(this);

        // Set the primary stage
        stage.setTitle("Salary Range");
        stage.setScene(new Scene(root, 600, 450));
        stage.show();
    }
    public void giveCountrywiseplayercount()  {
        // XML Loading using FXMLLoader
        try {
            List<Country> tmplist = new ArrayList<>();
            List<String> country = new ArrayList<String>();
            List<Integer> count = new ArrayList<Integer>();
            for (int i = 0; i < players.size(); i++) {
                Player t = players.get(i);
                if (country.contains(t.getCountry())) {
                    int index = country.indexOf(t.getCountry());
                    count.set(index, count.get(index) + 1);
                } else {
                    country.add(t.getCountry());
                    count.add(1);
                }
            }
            for (int i = 0; i < country.size(); i++) {
                tmplist.add(new Country(country.get(i), count.get(i)));
            }
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(getClass().getResource("searchcountrywiseplayercount.fxml"));
            Parent root = loader.load();

            // Loading the controller
            Searchcountrywiseplayercount controller = loader.getController();
            controller.setMain(this, tmplist);
            controller.init();
            // Set the primary stage
            stage.setTitle("Country Wise Player");
            stage.setScene(new Scene(root, 600, 450));
            stage.show();
        }catch (Exception e)
        {
            System.out.println(e);
        }
    }
    public void Sellplayer()  {
        // XML Loading using FXMLLoader
        try {
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(getClass().getResource("sellPlayer.fxml"));
            Parent root = loader.load();

            // Loading the controller
            SellPlayer controller = loader.getController();
            controller.setMain(this, players);
            controller.init();
            // Set the primary stage
            stage.setTitle("Sell Player");
            stage.setScene(new Scene(root, 600, 450));
            stage.show();
        }catch (Exception e)
        {
            System.out.println(e);
        }
    }
    public void Buyplayer()  {
        // XML Loading using FXMLLoader
        try {

            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(getClass().getResource("buyPlayer.fxml"));
            Parent root = loader.load();

            // Loading the controller
            BuyPlayer controller = loader.getController();
            controller.setMain(this, buylist);
            controller.init();
            // Set the primary stage
            stage.setTitle("Buy Player");
            stage.setScene(new Scene(root, 600, 450));
            stage.show();
        }catch (Exception e)
        {
            System.out.println(e);
        }
    }
    public void showplayername(String playername)  {
        // XML Loading using FXMLLoader
        try {
            List<Player> tmpList = new ArrayList<>();
            for (int i = 0; i < players.size(); i++) {
                Player t = players.get(i);
                if (t.getName().equalsIgnoreCase(playername)) {
                    tmpList.add(t);
                }
            }
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(getClass().getResource("showplayerinformation.fxml"));
            Parent root = loader.load();

            // Loading the controller
            Showplayerinformation controller = loader.getController();


            controller.setMain(this, tmpList);
            controller.init();
            // Set the primary stage
            stage.setTitle("Player information");
            stage.setScene(new Scene(root, 600, 450));
            stage.show();
        }catch (Exception e)
        {
            System.out.println(e);
        }
    }
    public void showposition(String position)  {
        // XML Loading using FXMLLoader
        try {
            List<Player> tmpList = new ArrayList<>();
            for (int i = 0; i < players.size(); i++)
            {
                Player t = players.get(i);
                if (t.getPosition().equalsIgnoreCase(position))
                {
                    tmpList.add(t);
                }
            }
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(getClass().getResource("showplayerinformation.fxml"));
            Parent root = loader.load();

            // Loading the controller
            Showplayerinformation controller = loader.getController();


            controller.setMain(this, tmpList);
            controller.init();
            // Set the primary stage
            stage.setTitle("Player information");
            stage.setScene(new Scene(root, 600, 450));
            stage.show();
        }catch (Exception e)
        {
            System.out.println(e);
        }
    }
    public void showclubandcountryname(String countryname)  {
        // XML Loading using FXMLLoader
        try {
            List<Player> tmpList = new ArrayList<>();
                for (int i = 0; i < players.size(); i++)
                {
                    Player t = players.get(i);
                    if (t.getCountry().equalsIgnoreCase(countryname))
                    {
                        tmpList.add(t);
                        //break;
                    }
                }
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(getClass().getResource("showplayerinformation.fxml"));
            Parent root = loader.load();

            // Loading the controller
            Showplayerinformation controller = loader.getController();

            controller.setMain(this, tmpList);
            controller.init();
            // Set the primary stage
            stage.setTitle("Player information");
            stage.setScene(new Scene(root, 600, 450));
            stage.show();
        }catch (Exception e)
        {
            System.out.println(e);
        }
    }
    public void showsalaryrange(Double l,Double r)  {
        // XML Loading using FXMLLoader
        try {
            List<Player> tmpList = new ArrayList<>();
            for (int i = 0; i < players.size(); i++)
            {
                Player t = players.get(i);
                if ((Double.compare(t.getWsalary(), l) >=0) && (Double.compare(t.getWsalary(), r) <=0))
                {
                    tmpList.add(t);
                }
            }

            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(getClass().getResource("showplayerinformation.fxml"));
            Parent root = loader.load();

            // Loading the controller
            Showplayerinformation controller = loader.getController();

            controller.setMain(this, tmpList);
            controller.init();
            // Set the primary stage
            stage.setTitle("Player information");
            stage.setScene(new Scene(root, 600, 450));
            stage.show();
        }catch (Exception e)
        {
            System.out.println(e);
        }
    }

    public static void main(String[] args) throws Exception{
        launch(args);
    }
}




