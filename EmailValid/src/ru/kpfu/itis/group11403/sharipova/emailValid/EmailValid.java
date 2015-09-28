package ru.kpfu.itis.group11403.sharipova.emailValid;

import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class EmailValid {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Pattern pattern= Pattern.compile("((?:\\w+(?:\\-|\\.)?)+)@((?:\\w{2,}\\.)+\\w{2,6})"); 
		System.out.println("Email:");
		Scanner sc=new Scanner(System.in);
		Matcher matcher= pattern.matcher(sc.next());
		sc.close();
        if(matcher.matches()){
        	System.out.println("Valid email");
        	System.out.println("ID: "+matcher.group(1));
            System.out.println("DOMEN: "+matcher.group(2));
        }
        else
        System.out.println("Not valid");
       
	}

}
