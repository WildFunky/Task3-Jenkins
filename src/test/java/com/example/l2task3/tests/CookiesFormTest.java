package com.example.l2task3.tests;

import com.example.l2task3.forms.CookiesForm;
import com.example.l2task3.forms.GamePage;
import com.example.l2task3.forms.WelcomePage;
import org.testng.Assert;
import org.testng.annotations.Test;

public class CookiesFormTest extends BaseTest {

    @Test
    public void cookiesFormTest() {
        WelcomePage welcomePage = new WelcomePage();
        Assert.assertTrue(welcomePage.state().isDisplayed(), "Welcome page is not displayed!");

        welcomePage.clickHereLink();
        GamePage gamePage = new GamePage();
        CookiesForm cookiesForm = gamePage.getCookiesForm();
        cookiesForm.clickHideCookies();
        Assert.assertTrue(cookiesForm.state().waitForNotDisplayed(), "Cookies form is still displaying!");
    }
}
