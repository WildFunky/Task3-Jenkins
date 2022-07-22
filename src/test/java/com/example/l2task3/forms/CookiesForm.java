package com.example.l2task3.forms;

import aquality.selenium.elements.interfaces.IButton;
import aquality.selenium.forms.Form;
import org.openqa.selenium.By;

public class CookiesForm extends Form {

    private final IButton hideCookiesBtn = getElementFactory()
            .getButton(By.xpath("//button[contains(text(), 'Not really, no')]"), "Hide cookies btn");

    protected CookiesForm() {
        super(By.xpath("//div[@class='cookies']"), "Cookies form");
    }

    public void clickHideCookies() {
        hideCookiesBtn.clickAndWait();
    }
}
