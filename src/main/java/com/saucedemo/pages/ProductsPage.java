package com.saucedemo.pages;

import org.openqa.selenium.By;

public class ProductsPage extends BasePage {
    private By productsPageHeader = By.xpath("//div[@class='app_logo'][contains(text(),'Swag Labs')]");

    public boolean isProductsPagheHeaderDisplayed() {
        return find(productsPageHeader).isDisplayed();
    }
}
