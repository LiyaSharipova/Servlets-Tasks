package ru.kpfu.itis.sharipova.utils;

import java.io.UnsupportedEncodingException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;
import java.security.spec.InvalidKeySpecException;
import java.security.spec.KeySpec;

import org.apache.commons.codec.DecoderException;
import org.apache.commons.codec.binary.Hex;
import org.apache.commons.lang3.ArrayUtils;

import javax.crypto.SecretKeyFactory;
import javax.crypto.spec.PBEKeySpec;

/**
 * Created by Baths on 05.11.2015.
 */
public class SecurityService {
    public static String getHesh(String password, String salt) {
//        byte[] salt = new byte[16];
//        SecureRandom random = new SecureRandom();
//        random.nextBytes(salt);
//        salt=salt.getBytes();
        KeySpec spec = new PBEKeySpec(password.toCharArray(), salt.getBytes(), 1000, 128);
        SecretKeyFactory f = null;
        try {
            f = SecretKeyFactory.getInstance("PBKDF2WithHmacSHA256");
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        }
        try {
            return  Hex.encodeHexString(f.generateSecret(spec).getEncoded());
        } catch (InvalidKeySpecException e) {
            e.printStackTrace();
        }
        return null;
    }

    public static boolean validate(String password, String hash, String salt)
            throws SecurityException {
//        byte[] saltByte = salt.getBytes();
        String currentHash = getHesh(password, salt);
        return hash.equals(currentHash);
    }

    public static String getSalt() {
        byte[] salt = new byte[16];
        SecureRandom random = new SecureRandom();
        random.nextBytes(salt);
        return Hex.encodeHexString(salt);
    }
}