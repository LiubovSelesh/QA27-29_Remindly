package com.telran.remindly.tests;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;

public class CreateReminderTests extends TestBase {

    @Test
    public void addReminderWithDefaultDataTest() {
        int quantityBeforeAdd;
        int quantityAfterAdd;
        quantityBeforeAdd = app.getMainScreen().getTotalReminders();
//tap on add reminder
        app.getReminders().tapOnAddReminder();
//fill reminder title
        app.getReminders().pause(1000);
        app.getReminders().fillReminderTitle("Test");
//save reminder
        app.getReminders().saveReminder();
//assert to add new reminder
        app.getReminders().pause(2000);
        quantityAfterAdd = app.getMainScreen().getTotalReminders();

        Assert.assertEquals(quantityAfterAdd, quantityBeforeAdd + 1);
    }

    @Test
    public void addReminderWithDefaultDataAndTitleTextAssertTest() {
//tap on add reminder
        app.getReminders().tapOnAddReminder();
    //fill reminder title
        app.getReminders().fillReminderTitle("Test");
//save reminder
        app.getReminders().saveReminder();
//assert to add new reminder for title text
        Assert.assertTrue(app.getMainScreen().isElementPresent(By.id("recycle_title")));
    }

    @Test
    public void addReminderWithRandomSwipeTest() {
        int quantityBeforeAdd;
        int quantityAfterAdd;
        quantityBeforeAdd = app.getMainScreen().getTotalReminders();
////tap on add reminder
        app.getReminders().tapOnAddReminder();
//fill reminder title
        app.getReminders().fillReminderTitle("Test");
//tap on data field
        app.getReminders().tapOnDataField();
//choose month
        app.getReminders().pause(500);
        app.getReminders().selectMonth("future");
//select day
        app.getReminders().selectDay(19);
//tap on OK
        app.getReminders().tapOnOK();
//save reminder
        app.getReminders().saveReminder();
//assert to add new reminder
        quantityAfterAdd = app.getMainScreen().getTotalReminders();
        Assert.assertEquals(quantityAfterAdd,quantityBeforeAdd+1);
    }
}


