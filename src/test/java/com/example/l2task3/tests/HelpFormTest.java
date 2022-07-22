package com.example.l2task3.tests;

import com.example.l2task3.forms.GamePage;
import com.example.l2task3.forms.HelpBoxForm;
import com.example.l2task3.forms.WelcomePage;
import org.testng.Assert;
import org.testng.annotations.Test;

public class HelpFormTest extends BaseTest {

    @Test
    public void helpFormTest() {
        WelcomePage homePage = new WelcomePage();
        Assert.assertTrue(homePage.state().isDisplayed(), "Welcome page is not displayed!");

        homePage.clickHereLink();
        GamePage gamePage = new GamePage();
        HelpBoxForm helpBoxForm = gamePage.getHelpBoxForm();
        helpBoxForm.clickHideHelpBtn();
        Assert.assertTrue(helpBoxForm.state().waitForNotDisplayed(), "HelpBox is still displaying!");
    }
}
