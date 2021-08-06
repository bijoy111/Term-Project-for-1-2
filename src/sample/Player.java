package sample;

import java.io.Serializable;

public class Player implements Serializable {
    private String name;
    private String country;
    private int age;
    private double height;
    private String club;
    private String position;
    private int number;
    private double wsalary;
    public Player() {

    }

    public Player(String name, String country, int age, double height, String club, String position, int number, double wsalary) {
        this.name=name;
        this.country=country;
        this.age=age;
        this.height=height;
        this.club=club;
        this.position=position;
        this.number=number;
        this.wsalary=wsalary;
    }
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country=country;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public double getHeight() {
        return height;
    }

    public void setHeight(double height) {
        this.height=height;
    }

    public String getClub() {
        return club;
    }

    public void setClub(String club) {
        this.club = club;
    }

    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        this.position=position;
    }

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    public double getWsalary() {
        return wsalary;
    }

    public void setWsalary(double wsalary) {
        this.wsalary = wsalary;
    }
}
