package top.datacluster.craw.worker;

import java.util.Date;

public class HupuUser {

    private String id = "";

    private String name = "";

    private String sex = "";

    private String city = "";

    private int level = 0;

    private String mass = "";

    private String cash = "";

    private String onlive_time = "";

    private String register_time = "";

    private String last_lgoin_time = "";

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public int getLevel() {
        return level;
    }

    public void setLevel(int level) {
        this.level = level;
    }

    public String getMass() {
        return mass;
    }

    public void setMass(String mass) {
        this.mass = mass;
    }

    public String getCash() {
        return cash;
    }

    public void setCash(String cash) {
        this.cash = cash;
    }

    public String getOnlive_time() {
        return onlive_time;
    }

    public void setOnlive_time(String onlive_time) {
        this.onlive_time = onlive_time;
    }

    public String getRegister_time() {
        return register_time;
    }

    public void setRegister_time(String register_time) {
        this.register_time = register_time;
    }

    public String getLast_lgoin_time() {
        return last_lgoin_time;
    }

    public void setLast_lgoin_time(String last_lgoin_time) {
        this.last_lgoin_time = last_lgoin_time;
    }

    public Object[] getSqlObject(){
        return new Object[]{name, id, sex, level, mass, cash, onlive_time, register_time, last_lgoin_time, city, new Date()};
    }

    @Override
    public String toString() {
        return "HupuUser{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                ", sex='" + sex + '\'' +
                ", city='" + city + '\'' +
                ", level=" + level +
                ", mass='" + mass + '\'' +
                ", cash='" + cash + '\'' +
                ", onlive_time='" + onlive_time + '\'' +
                ", register_time='" + register_time + '\'' +
                ", last_lgoin_time='" + last_lgoin_time + '\'' +
                '}';
    }
}
