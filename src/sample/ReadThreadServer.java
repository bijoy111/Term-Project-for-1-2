package sample;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;


public class  ReadThreadServer implements Runnable {

    private Thread thr;
    private NetworkUtil networkUtil;
    public HashMap<String, ClientInfo> clientMap;
    public List<Player> playerList;
    public List<Player> tmp;

    public ReadThreadServer(HashMap<String, ClientInfo> map, NetworkUtil networkUtil,List<Player>tmp,List<Player>playerList) throws Exception {
        this.clientMap = map;
        this.networkUtil = networkUtil;
        this.playerList=playerList;
        this.tmp=tmp;

        this.thr = new Thread(this);
        thr.start();
    }

    public void run() {
        try {
            while (true) {
                Object o = networkUtil.read();

                        if(o instanceof Owninfolist) {
                            Owninfolist obj = (Owninfolist) o;
                            ClientInfo clientInfo = new ClientInfo();
                            clientInfo.setNetworkUtil(networkUtil);
                            clientMap.put(obj.getName(), clientInfo);
                            List<Player> tmpList = new ArrayList<>();
                            for (int i = 0; i < playerList.size(); i++) {
                                Player t = playerList.get(i);
                                if (t.getClub().equalsIgnoreCase(obj.getName())) {
                                    tmpList.add(t);
                                }
                            }
                            Getowninfolist getowninfolist = new Getowninfolist();
                            getowninfolist.setPlayerList(tmpList);
                            networkUtil.write(getowninfolist);
                        }
                        else if(o instanceof forbuy) {
                            forbuy obj = (forbuy) o;
                            Player p=obj.getPlayer();
                            for(int i=0;i<playerList.size();i++)
                            {
                                Player t=playerList.get(i);
                                if(t.getName().equalsIgnoreCase(p.getName()))
                                {
                                    playerList.remove(t);
                                }
                            }
                            obj.getPlayer().setClub(obj.getClubofPlayer());
                            tmp.add(obj.getPlayer());
                            getBuylist getlist = new getBuylist();
                            getlist.setPlayerList(tmp);
                            networkUtil.write(getlist);
                        }
                        else if (o instanceof sendall) {
                            sendall obje = (sendall) o;
                            Iterator<String> iterator = clientMap.keySet().iterator();
                            while (iterator.hasNext()) {
                                String name = iterator.next();
                                ClientInfo clientInfo = clientMap.get(name);
                                    sendlisttoallclient getlist = new sendlisttoallclient();
                                    getlist.setPlayerList(tmp);
                                if (!name.equalsIgnoreCase(obje.get())) {
                                    clientInfo.getNetworkUtil().write(getlist);
                                }

                            }
                        }
                        else if(o instanceof foraddinclub){
                            foraddinclub obje = (foraddinclub) o;
                            Player p=obje.getPlayer();
                            for (int i = 0; i < tmp.size(); i++)
                            {
                                Player t = tmp.get(i);
                                if(t.getName().equalsIgnoreCase(p.getName()))
                                {
                                    tmp.remove(t);
                                    t.setClub(obje.getClubofPlayer());
                                    playerList.add(t);
                                }
                            }
                        }
                        else if(o instanceof takelistforbuy)
                        {
                            takelistforbuy obj=(takelistforbuy) o;
                            List<Player> tm = new ArrayList<>();
                            for (int i = 0; i < tmp.size(); i++) {
                                Player t = tmp.get(i);

                                if (!t.getClub().equalsIgnoreCase(obj.get())) {
                                    tm.add(t);
                                }
                            }
                            getBuylist getlist = new getBuylist();
                            getlist.setPlayerList(tm);
                            networkUtil.write(getlist);
                        }
            }
        } catch (Exception e) {
            System.out.println(e);
        } finally {
            try {
                networkUtil.closeConnection();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}



