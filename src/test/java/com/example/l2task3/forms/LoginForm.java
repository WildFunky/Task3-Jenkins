package com.example.l2task3.forms;

import aquality.selenium.elements.ElementType;
import aquality.selenium.elements.interfaces.*;
import aquality.selenium.forms.Form;
import org.openqa.selenium.By;

import java.util.List;
import java.util.Random;

public class LoginForm extends Form {
    private final ITextBox passwordField = getElementFactory()
            .getTextBox(By.xpath("//input[@placeholder='Choose Password']"), "password field");
    private final ITextBox emailField = getElementFactory()
            .getTextBox(By.xpath("//input[@placeholder='Your email']"), "email field");
    private final ITextBox domainField = getElementFactory()
            .getTextBox(By.xpath("//input[@placeholder='Domain']"), "domain field");
    private final IButton dropDownOpener = getElementFactory()
            .getButton(By.xpath("//div[@class='dropdown dropdown--gray']"), "dropDown opener btn");
    private final ICheckBox termsAndConditions = getElementFactory()
            .getCheckBox(By.xpath("//span[@class='checkbox__box']"), "terms and conditions checkbox");
    private final ILink nextLnk = getElementFactory()
            .getLink(By.xpath("//a[@class='button--secondary']"), "next link");
    private final By dropDownListXpath = By.xpath("//div[contains(@class, 'dropdown__list-item')]");

    protected LoginForm() {
        super(By.xpath("//div[@class='login-form__container']"), "Login form");
    }

    public void inputPassword(String password) {
        passwordField.clearAndType(password);
    }

    public void inputEmail(String email) {
        emailField.clearAndType(email);
    }

    public void inputDomain(String domain) {
        domainField.clearAndType(domain);
    }

    public void chooseDomainZone() {
        clickDropDownOpener();
        List<IElement> elements = getElementFactory().findElements(dropDownListXpath, ElementType.TEXTBOX);
        Random random = new Random();
        int randomDomainZone = random.ints(1, elements.size())
                .findFirst()
                .orElse(1);
        elements.get(randomDomainZone).clickAndWait();
    }

    public void clickAcceptTermsAndConditions() {
        termsAndConditions.clickAndWait();
    }

    private void clickDropDownOpener() {
        dropDownOpener.clickAndWait();
    }

    public void clickNextLnk() {
        nextLnk.click();
    }
}
