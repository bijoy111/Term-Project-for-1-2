package sample;

import java.io.Serializable;
import java.util.List;

public class sendlisttoallclient implements Serializable {
    private List<Player> List;
    public sendlisttoallclient()
    {

    }
    public List<Player> getPlayerList() {
        return List;
    }

    public void setPlayerList(List<Player> List) {
        this.List = List;
    }
}