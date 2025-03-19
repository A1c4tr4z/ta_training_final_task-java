package com.saucedemo.pages.test;

import com.saucedemo.pages.ProductsPage;
import com.saucedemo.pages.base.BaseTest;
import org.hamcrest.Matchers;
import org.junit.jupiter.api.*;

import static org.hamcrest.MatcherAssert.assertThat;

@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class LoginTests extends BaseTest {
    @Test
    @Order(1)
    void testUserNameErrorMessage(){
        loginPage.setUsernameField("");
        loginPage.setPasswordField("");
        loginPage.clickLoginButton();
        String errorMessage = loginPage.getErrorMessage();
        //Assertions.assertTrue(errorMessage.contains("Username is required"));
        assertThat("Error does not match the expectation!", errorMessage, Matchers.containsString("Username is required"));
    }
    @Test
    @Order(2)
    void testPasswordErrorMessage(){
        loginPage.setUsernameField("standard_user");
        loginPage.setPasswordField("");
        loginPage.clickLoginButton();
        String errorMessage = loginPage.getErrorMessage();
        //Assertions.assertTrue(errorMessage.contains("Password is required"));
        assertThat("Error does not match the expectation!", errorMessage, Matchers.containsString("Password is required"));
    }
    @Test
    @Order(3)
    void testLoginSuccess(){
        ProductsPage productsPage = loginPage.login("standard_user", "secret_sauce");
        //Assertions.assertTrue(productsPage.isProductsPagheHeaderDisplayed());
        assertThat("Page header is missing!", productsPage.isProductsPagheHeaderDisplayed(), Matchers.is(true));
    }
}
