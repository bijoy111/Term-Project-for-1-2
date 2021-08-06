package sample;

import java.io.Serializable;

public class sendall implements Serializable {
    private String str;
    public sendall()
    {

    }
    public String get() {
        return str;
    }

    public void set(String str) {
        this.str=str;
    }
}