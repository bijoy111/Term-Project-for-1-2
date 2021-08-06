package sample;

import java.io.Serializable;

public class takelistforbuy implements Serializable {
    private String str;
    public takelistforbuy()
    {

    }
    public String get() {
        return str;
    }

    public void set(String str) {
        this.str=str;
    }
}