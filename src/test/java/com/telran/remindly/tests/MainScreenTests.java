package com.telran.remindly.tests;

import org.testng.Assert;
import org.testng.annotations.Test;

public class MainScreenTests extends TestBase{

    @Test
    public void appLaunchTest() {
        Assert.assertTrue(app.getMainScreen().isNoReminderTextPresent());

    }

    @Test
    public void checkLicenseTest() {
        app.getMainScreen().isLicenseeTextPresent();
//        Assert.assertTrue(app.getMainScreen().isLicenseeTextPresent());

    }
}
