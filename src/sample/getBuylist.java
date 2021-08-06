package sample;

import java.io.Serializable;
import java.util.List;

public class getBuylist implements Serializable {
    private List<Player> List;
public getBuylist()
{

}
    public List<Player> getPlayerList() {
        return List;
    }

    public void setPlayerList(List<Player> List) {
        this.List = List;
    }
}