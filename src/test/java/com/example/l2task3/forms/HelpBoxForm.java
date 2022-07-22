package com.example.l2task3.forms;

import aquality.selenium.elements.interfaces.IButton;
import aquality.selenium.forms.Form;
import org.openqa.selenium.By;

public class HelpBoxForm extends Form {

    private final IButton hideHelpBoxBtn = getElementFactory()
            .getButton(By.xpath("//span[@class='highlight']"), "hide helpBox btn");

    protected HelpBoxForm() {
        super(By.xpath("//h2[@class='help-form__title']"), "HelpBox form");
    }

    public void clickHideHelpBtn() {
        hideHelpBoxBtn.click();
    }
}
