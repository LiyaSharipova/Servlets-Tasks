package ru.kpfu.itis.sharipova.repository;

import ru.kpfu.itis.sharipova.entities.User;
import ru.kpfu.itis.sharipova.exceptions.LongPasswordException;
import ru.kpfu.itis.sharipova.exceptions.NotValidEmailException;
import ru.kpfu.itis.sharipova.exceptions.ShortPasswordException;
import ru.kpfu.itis.sharipova.servlets.MainServlet;

import java.io.*;
import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by Baths on 12.10.2015.
 */
public class DataRepository {
    private static File db = new File("C:\\Users\\Baths\\Documents\\web\\dataBase.txt");
    public void addUser(User user) throws NotValidEmailException,ShortPasswordException,LongPasswordException {
        emailCheck(user.getEmail());
        passwCheck(user.getPassword());
        try {
            writeToFail(user.getEmail(), user.getPassword(), user.getGender(), user.getSubscribe());
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
    public static ArrayList<String[]> getData() {
        ArrayList<String[]> database = new ArrayList<>();
        try {
            BufferedReader reader = new BufferedReader(new InputStreamReader(new FileInputStream(db)));
            String s;
            while ((s = reader.readLine()) != null) {
                database.add(s.split(" "));
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return database;
    }
    protected void writeToFail(String email, String pass, String gender, String suscribe) throws IOException {
        if (suscribe == null) suscribe = "off";
        try (PrintWriter writer = new PrintWriter(new OutputStreamWriter(new FileOutputStream(db, true), "UTF-8"));) {
            writer.println(email + " " + datacheck(pass) + " " + gender + " " + suscribe);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    protected void emailCheck(String email) throws NotValidEmailException {
        Pattern pattern= Pattern.compile("((?:\\w+(?:\\-|\\.)?)+)@((?:\\w{2,}\\.)+\\w{2,6})");
        Matcher matcher= pattern.matcher(email);
        if(!matcher.matches()) throw new NotValidEmailException("Email is not valid");
    }
    protected void passwCheck(String pass) throws ShortPasswordException, LongPasswordException{
         if(pass.length()<4 ) throw  new ShortPasswordException("Password is too short");
         if (pass.length()>16)throw  new LongPasswordException("Password is too long");
    }
    protected String datacheck(String str) {
        return str.replace(' ', '$');
    }
}
