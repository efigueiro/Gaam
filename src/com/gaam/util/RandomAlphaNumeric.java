package com.gaam.util;

import java.util.Random;

/**
 * Use this class to build randomic passwords
 * @author everson.figueiro
 *
 */
public class RandomAlphaNumeric {  
	  
    private static final Random random = new Random();  
  
    private RandomAlphaNumeric() {}  
  
    //[0 - 9] =  0-9  
    //[A - Z] = 10-35  
    //[a - z] = 36-61  
    private static char toChar(int index) {  
        if (index < 10)  
            return (char)(index + 48); //the chars 48 a 57 represent [0 - 9]  
        else if (index < 36)  
            return (char)(index + 55); //the chars 65 a 90 represent [A - Z]  
        else  
            return (char)(index + 61); //the chars 97 a 122 represent [a - z]  
    }  
  
    //randomic chars between [0 - 9], [A - Z] e [a - z]  
    public static char randomChar() {  
        return toChar(random.nextInt(62));  
    }  
  
    //randomic string length, with just alphanumerics chars  
    public static String randomString(int length) {  
        return new String(randomCharSequence(length));  
    }  
  
    //randomic char sequence length, with just alphanumerics  
    public static char[] randomCharSequence(int length) {  
        if (length < 0)  
            throw new IllegalArgumentException("The string length cannot be negative");  
        if (length == 0)  
            return new char[0];  
          
        char[] charSequence = new char[length];  
        for (int i = 0; i<length; i++)  
            charSequence[i] = randomChar();  
        return charSequence;  
    }  
  
    //randomic char sequence between minLength and maxLength, with alphanumerics chars  
    public static String randomString(int minLength, int maxLength) {  
        if (minLength < 0 || maxLength < 0)  
            throw new IllegalArgumentException("The string length cannot be negative");  
        if (minLength > maxLength)  
            throw new IllegalArgumentException("The string length cannot be less than minLength");  
  
        if (minLength == maxLength)  
            return randomString(maxLength);  
        int size = minLength + random.nextInt(maxLength-minLength+1);  
        return randomString(size);  
    }  
}  