package com.saucedemo.pages.base;

import com.saucedemo.pages.BasePage;
import com.saucedemo.pages.LoginPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;



public class BaseTest {
    protected static WebDriver driver;
    protected static BasePage basePage;
    protected static LoginPage loginPage;
    private static final String baseUrl = "https://www.saucedemo.com";

    private static final Logger logger = LoggerFactory.getLogger(BaseTest.class);
    @BeforeAll
    static void setUp() {
        logger.info("Launching browser Chrome");
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get(baseUrl);
        logger.info("Site oppened: {}", baseUrl);

        basePage = new BasePage();
        basePage.setDriver(driver);
        loginPage = new LoginPage();
    }

    @AfterAll
    static void tearDown() {
        if (driver != null) {
            logger.info("Closing browser");
            driver.quit();
        }
    }
}
