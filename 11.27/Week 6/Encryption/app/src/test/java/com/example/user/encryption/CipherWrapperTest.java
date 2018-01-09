package com.example.user.encryption;

import org.junit.Before;
import org.junit.Test;
import org.mockito.MockitoAnnotations;

import java.security.InvalidAlgorithmParameterException;
import java.security.KeyPair;
import java.security.NoSuchAlgorithmException;
import java.security.NoSuchProviderException;

import javax.crypto.NoSuchPaddingException;

/**
 * Created by singh on 1/9/18.
 */

public class CipherWrapperTest {

    CipherWrapper cipherWrapper;




    @Before
    public void setup() throws NoSuchAlgorithmException, NoSuchPaddingException, NoSuchProviderException, InvalidAlgorithmParameterException {



        cipherWrapper = new CipherWrapper(MainActivity.TRANSFORMATION);



    }

    @Test
    public void should_encrypt_data() {



    }


}
