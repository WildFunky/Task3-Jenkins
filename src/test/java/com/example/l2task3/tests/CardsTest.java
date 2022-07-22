package com.example.l2task3.tests;

import com.example.l2task3.forms.*;
import com.example.l2task3.utils.RandomUtils;
import org.testng.Assert;
import org.testng.annotations.Test;

public class CardsTest extends BaseTest {

    @Test
    public void cardsTest() {

        WelcomePage homePage = new WelcomePage();
        Assert.assertTrue(homePage.state().waitForDisplayed(), "Home page is not displayed!");
        homePage.clickHereLink();

        GamePage gamePage = new GamePage();
        Assert.assertTrue(gamePage.state().waitForDisplayed(), "Card 1 is not displayed!");

        LoginForm loginForm = gamePage.getLoginForm();
        String email = RandomUtils.getRandomString(testData.getValue("/emailLength").toString());
        String domain = RandomUtils.getRandomString(testData.getValue("/domainLength").toString());
        String password = RandomUtils.generatePassword(email, testData.getValue("/passwordLength").toString());
        loginForm.inputEmail(email);
        loginForm.inputDomain(domain);
        loginForm.inputPassword(password);
        loginForm.chooseDomainZone();
        loginForm.clickAcceptTermsAndConditions();
        loginForm.clickNextLnk();
        AvatarAndInterestsForm avatarAndInterestsForm = new AvatarAndInterestsForm();
        Assert.assertTrue(avatarAndInterestsForm.state().waitForDisplayed(), "Card 2 is not displayed!");


        avatarAndInterestsForm.clickRandomInterests(testData.getValue("/numberOfInterests").toString());
        avatarAndInterestsForm.clickUploadBtn();
        avatarAndInterestsForm.uploadImg(testData.getValue("/pathToImage").toString());
        avatarAndInterestsForm.clickNextBtn();

        PersonalDetailsForm personalDetailsForm = gamePage.getPersonalDetailsForm();
        Assert.assertTrue(personalDetailsForm.state().waitForDisplayed(), "Card 3 is not displayed!");
    }
}
