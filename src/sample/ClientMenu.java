package sample;

public class ClientMenu implements Runnable {

    private Thread thr;
    private NetworkUtil networkUtil;
    private String clientName;
    private boolean isLoggedIn;
    private String name;
    private Main main;
    private String club;
    public ClientMenu(NetworkUtil networkUtil, String name, Main main,String club) {
        this.main = main;
        this.club=club;
        this.networkUtil = networkUtil;
        this.name=name;
        this.thr = new Thread(this);
        thr.start();
        new ReadThreadClient(networkUtil, this, this.main,this.club);
    }

    public void setLoggedIn(boolean loggedIn) {
        isLoggedIn = loggedIn;
    }

    public void run() {
        try {
                clientName = name;
                Owninfolist owninfolist = new Owninfolist();
                owninfolist.setName(clientName);
                networkUtil.write(owninfolist);

        } catch (Exception e) {
            System.out.println(e);
        }
    }
}



