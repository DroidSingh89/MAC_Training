package com.example.user.firebase;

import com.example.user.firebase.view.login.LoginAuthenticator;
import com.example.user.firebase.view.login.LoginContract;
import com.example.user.firebase.view.login.LoginPresenter;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;

/**
 * Created by singh on 1/9/18.
 */

public class LoginPresenterTest {


    @Mock
    LoginAuthenticator loginAuthenticator;

    @Mock
    LoginContract.View view;
    private LoginPresenter loginPresenter;

    @Before
    public void setup() {
        MockitoAnnotations.initMocks(this);

        loginPresenter = new LoginPresenter(loginAuthenticator);


    }


    @Test
    public void should_attach_view() {

        loginPresenter.attachView(view);
        verify(loginPresenter, times(1)).attachView(view);
    }

    @Test
    public void should_call_authenticator_validation() {
        String email = "abc@abc.com";
        String password = "abc123";

        loginPresenter.validateUser(email, password);
        verify(loginAuthenticator, times(1)).validateUser(email, password,loginPresenter);


    }

    @Test
    public void checkValue() {

        int actualValue = 20;
        int expectedValue = loginPresenter.checkInt(10);

        assertEquals(expectedValue, actualValue);

    }




}
