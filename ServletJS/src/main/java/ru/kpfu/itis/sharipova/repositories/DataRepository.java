package ru.kpfu.itis.sharipova.repositories;

import ru.kpfu.itis.sharipova.exceptions.*;
import ru.kpfu.itis.sharipova.entities.User;
import ru.kpfu.itis.sharipova.utils.Db;

import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by Baths on 12.10.2015.
 */
public class DataRepository {
    private static String dataBase = "dataBase";
    private static File db = new File("C:\\Users\\Baths\\Documents\\web\\dataBase.txt");


    private static void checkForDuplicates(User user) throws DuplicateEntryException, DatabaseException {

        for (User userEntry : getData()  ) {
            if(userEntry.getEmail().equals(user.getEmail()))
                throw new DuplicateEntryException("This user already exists!");
        }
    }
    public static User identifyUser(String email, String password) throws DatabaseException, IdentityException {
        for (User userEntry : getData()  ) {
            if (userEntry.getEmail().equals(email) && userEntry.getPassword().equals(password))
                return userEntry;
        }
        throw new IdentityException("No such user");
    }

    public static void addUser(User user) throws NotValidEmailException, ShortPasswordException, LongPasswordException,
            DatabaseException, DuplicateEntryException {
        checkForDuplicates(user);
        emailCheck(user.getEmail());
        passwCheck(user.getPassword());
        if(user.getSubscribe()==null){
            user.setSubscribe("off");
        }
        try {
            Db.addEntry(dataBase, new String[]{user.getEmail(), user.getPassword(), user.getGender(), user.getSubscribe(),
                    user.getAboutMe()});

        } catch (DatabaseException e) {
            e.printStackTrace();
        }

    }
    public static List<User> getData() throws DatabaseException {
        List<String[]> entries = Db.getAllEntries(dataBase);
        List<User> users = new ArrayList<>();
        for (String[] entry : entries) {
            User user = new User(entry[0], entry[1], entry[2], entry[3], entry[4]);
            users.add(user);
        }
        return users;
    }

    protected  static void emailCheck(String email) throws NotValidEmailException {
        Pattern pattern= Pattern.compile("((?:\\w+(?:\\-|\\.)?)+)@((?:\\w{2,}\\.)+\\w{2,6})");
        Matcher matcher= pattern.matcher(email);
        if(!matcher.matches()) throw new NotValidEmailException("Email is not valid");
    }
    protected static void passwCheck(String pass) throws ShortPasswordException, LongPasswordException {
         if(pass.length()<4 ) throw  new ShortPasswordException("Password is too short");
         if (pass.length()>16)throw  new LongPasswordException("Password is too long");
    }
    protected String datacheck(String str) {
        return str.replace(' ', '$');
    }
}
