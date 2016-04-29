package com.pl.alkosoft.repositories;

import org.apache.tomcat.util.codec.binary.Base64;
import org.junit.Test;

/**
 * Created by mwrobel on 06.10.15.
 */
public class PlayerRepositoryTests {


    @Test
    public void isFileConvertToBase64() throws Exception {
        byte[] encodedBytes = Base64.encodeBase64("Test".getBytes());
        System.out.println("encodedBytes " + new String(encodedBytes));
        byte[] decodedBytes = Base64.decodeBase64(encodedBytes);
        System.out.println("decodedBytes " + new String(decodedBytes));
    }
}
