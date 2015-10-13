package ru.kpfu.itis.sharipova.entities;

/**
 * Created by Baths on 12.10.2015.
 */
public class User {
    private String email;
    private String password;
    private String gender;
    private  String subscribe;
    public  User(){};
    public User(String email, String password, String gender, String subscribe) {
        this.email = email;
        this.password = password;
        this.gender = gender;
        this.subscribe = subscribe;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public void setSubscribe(String subscribe) {
        this.subscribe = subscribe;
    }

    public String getEmail() {
        return email;
    }

    public String getPassword() {
        return password;
    }

    public String getGender() {
        return gender;
    }

    public String getSubscribe() {
        return subscribe;
    }
}
