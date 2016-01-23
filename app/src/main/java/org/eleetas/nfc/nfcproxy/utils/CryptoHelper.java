package org.eleetas.nfc.nfcproxy.utils;

import android.util.Base64;

import java.security.SecureRandom;

public class CryptoHelper {
	
    public static String generateSalt() {
        SecureRandom sr = new SecureRandom();
        byte[] salt = new byte[8];
        sr.nextBytes(salt);
        return Base64.encodeToString(salt, Base64.DEFAULT);        
        
    }    

}
