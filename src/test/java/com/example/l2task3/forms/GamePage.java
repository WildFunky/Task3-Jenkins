package com.example.l2task3.forms;

import aquality.selenium.browser.AqualityServices;
import aquality.selenium.elements.interfaces.IComboBox;
import aquality.selenium.forms.Form;
import org.openqa.selenium.By;

import java.util.concurrent.TimeoutException;

public class GamePage extends Form {

    private final HelpBoxForm helpBoxForm = new HelpBoxForm();
    private final LoginForm loginForm = new LoginForm();
    private final PersonalDetailsForm personalDetailsForm = new PersonalDetailsForm();
    private final CookiesForm cookiesForm = new CookiesForm();

    private final IComboBox timer = getElementFactory()
            .getComboBox(By.xpath("//div[contains(@class, 'timer')]"), "timer");

    public GamePage() {
        super(By.xpath("//div[@class='game view']"), "Game form");
    }

    public HelpBoxForm getHelpBoxForm() {
        return this.helpBoxForm;
    }

    public LoginForm getLoginForm() {
        return this.loginForm;
    }

    public PersonalDetailsForm getPersonalDetailsForm() {
        return this.personalDetailsForm;
    }

    public CookiesForm getCookiesForm() {
        try {
            AqualityServices.getConditionalWait().waitForTrue(() -> cookiesForm.state().waitForDisplayed());
        } catch (TimeoutException e) {
            throw new RuntimeException(e);
        }
        return this.cookiesForm;
    }

    public String getTimerValue() {
        return timer.getText();
    }
}
