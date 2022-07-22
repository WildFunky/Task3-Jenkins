package com.example.l2task3.tests;

import com.example.l2task3.forms.GamePage;
import com.example.l2task3.forms.WelcomePage;
import org.testng.Assert;
import org.testng.annotations.Test;

public class TimerTest extends BaseTest {

    @Test
    public void timerTest() {

        WelcomePage welcomePage = new WelcomePage();
        welcomePage.clickHereLink();
        GamePage gamePage = new GamePage();
        String timerValue = gamePage.getTimerValue();

        String timerStartValue = testData.getValue("/timerStartValue").toString();
        Assert.assertTrue(timerValue.startsWith(timerStartValue), "Timer not starts with 00:00!");
    }
}
