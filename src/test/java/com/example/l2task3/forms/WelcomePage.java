package com.example.l2task3.forms;

import aquality.selenium.elements.interfaces.ILink;
import aquality.selenium.forms.Form;
import org.openqa.selenium.By;

public class WelcomePage extends Form {

    private final ILink hereLink = getElementFactory().getLink(By.xpath("//a[@class='start__link']"), "HereLink");

    public WelcomePage() {
        super(By.xpath("//div[@class='logo__icon']"), "Home Page");
    }

    public void clickHereLink() {
        hereLink.click();
    }
}
