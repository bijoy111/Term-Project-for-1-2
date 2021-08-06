package sample;

import java.io.Serializable;

public class forbuy implements Serializable {
    private Player p;
    private String club;
    public forbuy() {

    }

    public Player getPlayer() {
        return p;
    }

    public void setPlayer(Player p) {
        this.p = p;
    }

    public void setClubofPlayer(String club) {
        this.club = club;
    }

    public String getClubofPlayer()
    {
        return club;
    }
}