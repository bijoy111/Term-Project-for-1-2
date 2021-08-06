package sample;

public class Client {
    private Main main;
    private String club;
    public Client(String serverAddress, int serverPort, String name, Main main,String club) {
        this.main = main;
        this.club=club;
        try {
            NetworkUtil networkUtil = new NetworkUtil(serverAddress, serverPort);
            new ClientMenu(networkUtil,name, this.main,this.club);
        } catch (Exception e) {
            System.out.println(e);
        }
    }

}


