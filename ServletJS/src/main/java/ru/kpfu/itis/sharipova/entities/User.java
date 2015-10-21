package ru.kpfu.itis.sharipova.entities;

/**
 * Created by Baths on 12.10.2015.
 */
public class User {
    private String email;
    private String password;
    private String gender;
    private  String subscribe;
    private String aboutMe;

    public String getAboutMe() {
        return aboutMe;
    }

    public void setAboutMe(String aboutMe) {
        this.aboutMe = aboutMe;
    }

    public User(){};
    public User(String email, String password, String gender, String subscribe, String aboutMe) {
        this.email = email;
        this.password = password;
        this.gender = gender;
        this.subscribe = subscribe;
        this.aboutMe=aboutMe;
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
