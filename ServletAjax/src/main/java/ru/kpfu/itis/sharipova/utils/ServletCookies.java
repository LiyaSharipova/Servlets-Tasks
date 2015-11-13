package ru.kpfu.itis.sharipova.utils;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;

/**
 * Created by Baths on 13.11.2015.
 */
public class ServletCookies {
    public static Cookie getCookie(HttpServletRequest req,String name){
        Cookie[] cookies = req.getCookies();
        if (cookies != null){
            for (Cookie cookie : cookies){

                if(cookie.getName().equals(name)){
                    return cookie;
                }
            }
        }
        return null;
    }
}
