package sample;

import java.util.List;

import static sample.Main.buyfix;
import static sample.Main.fixed;

public class ReadThreadClient implements Runnable {
    private Main main;
    private String club;
    private Thread thr;
    private NetworkUtil networkUtil;
    private ClientMenu clientMenu;
    private List<Player> tmpList;
    private List<Player> tmpL;
    public ReadThreadClient()
    {
    }
    public ReadThreadClient(NetworkUtil networkUtil, ClientMenu clientMenu, Main main,String club){
        this.main = main;
        this.club=club;
        this.networkUtil = networkUtil;
        this.thr = new Thread(this);
        this.clientMenu = clientMenu;
        thr.start();
    }

    public void run() {
        try {
            main.networkfix(networkUtil);
            while (true) {
                Object o = networkUtil.read();
                if (o instanceof Getowninfolist) {
                    Getowninfolist obj = (Getowninfolist) o;
                    tmpList= obj.getPlayerList();
                    fixed(tmpList);
                }
                else if (o instanceof getBuylist) {
                    getBuylist obj = (getBuylist) o;
                    tmpL= obj.getPlayerList();
                    buyfix(tmpL);

                }
                 else if (o instanceof sendlisttoallclient) {
                    sendlisttoallclient obj = (sendlisttoallclient) o;
                    if(main.get())
                    main.update();
                 }
            }

        } catch (Exception e) {
            System.out.println(e);
        }
    }
    public List<Player> getTmpList() {
        return tmpList;
    }
}



