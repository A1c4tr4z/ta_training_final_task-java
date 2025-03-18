package com.saucedemo.pages.test;

import com.saucedemo.pages.ProductsPage;
import com.saucedemo.pages.base.BaseTest;
import org.hamcrest.Matchers;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import static org.hamcrest.MatcherAssert.assertThat;

public class LoginTests extends BaseTest {
    @Test
    void testUserNameErrorMessage(){
        loginPage.setUsernameField("");
        loginPage.setPasswordField("");
        loginPage.clickLoginButton();
        String errorMessage = loginPage.getErrorMessage();
        //Assertions.assertTrue(errorMessage.contains("Username is required"));
        assertThat("Error does not match the expectation!", errorMessage, Matchers.containsString("Username is required"));
    }
    @Test
    void testPasswordErrorMessage(){
        loginPage.setUsernameField("standard_user");
        loginPage.setPasswordField("");
        loginPage.clickLoginButton();
        String errorMessage = loginPage.getErrorMessage();
        //Assertions.assertTrue(errorMessage.contains("Password is required"));
        assertThat("Error does not match the expectation!", errorMessage, Matchers.containsString("Password is required"));
    }
    @Test
    void testLoginSuccess(){
        ProductsPage productsPage = loginPage.login("standard_user", "secret_sauce");
        //Assertions.assertTrue(productsPage.isProductsPagheHeaderDisplayed());
        assertThat("Page header is missing!", productsPage.isProductsPagheHeaderDisplayed(), Matchers.is(true));
    }
}
