package com.telran.remindly.tests;

import com.telran.remindly.model.Reminder;
import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;

public class CreateReminderTests extends TestBase {


    @Test
    public void addReminderWithDefaultDataTest() {
        int quantityBeforeAdd;
        int quantityAfterAdd;
        quantityBeforeAdd = app.getMainScreen().getTotalReminders();
        app.getReminders().tapOnAddReminder();
        app.getReminders().pause(1000);
        app.getReminders().fillReminderTitle("Test");
        app.getReminders().saveReminder();
        app.getReminders().pause(2000);
        quantityAfterAdd = app.getMainScreen().getTotalReminders();
        Assert.assertEquals(quantityAfterAdd, quantityBeforeAdd + 1);
    }

    @Test
    public void addReminderWithDefaultDataAndTitleTextAssertTest() {
        app.getReminders().tapOnAddReminder();
        app.getReminders().fillReminderTitle("Test");
        app.getReminders().saveReminder();
        Assert.assertTrue(app.getMainScreen().isElementPresent(By.id("recycle_title")));
    }

    @Test
    public void addReminderWithRandomSwipeTest() {
        int quantityBeforeAdd;
        int quantityAfterAdd;
        quantityBeforeAdd = app.getMainScreen().getTotalReminders();
        app.getReminders().tapOnAddReminder();
        app.getReminders().fillReminderTitle("Test");
        app.getReminders().tapOnDataField();
        app.getReminders().selectMonth("future");
        app.getReminders().selectDay(19);
        app.getReminders().tapOnOK();
        app.getReminders().saveReminder();
        quantityAfterAdd = app.getMainScreen().getTotalReminders();
        Assert.assertEquals(quantityAfterAdd, quantityBeforeAdd + 1);
    }

    @Test
    public void addReminderWithAllDataTest() {
        app.getReminders().tapOnAddReminder();
        app.getReminders().fillReminderTitle("Christmas");
        app.getReminders().tapOnDataField();
        app.getReminders().pause(500);
        app.getReminders().selectCertainMonth("future", 4, "Dec");
        app.getReminders().selectDay(23);
        app.getReminders().tapOnYear();
        app.getReminders().selectYear("future", "2022");
//        app.getReminders().selectYear("past", "2018");
        app.getReminders().tapOnOK();
        app.getReminders().tapOnTime();
        app.getReminders().selectTimeOfDay("am");
        app.getReminders().tapWithCoordinates(288, 1322);
        app.getReminders().tapWithCoordinates(789, 1331);
        app.getReminders().tapOnOK();
        app.getReminders().tapOnRepeatSwitch();
        app.getReminders().enterRepeatNumber("3");
        app.getReminders().swipeUp2();
        app.getReminders().selectRepeatTime("Month");
        app.getReminders().saveReminder();

    }

    @Test
    public void addReminderPositiveWithOneMethodTest() {
        app.getReminders().enterAllData(new Reminder().setTitle("Christmas").setType("future")
                .setNumber(5).setMonth("Dec").setIndex(23).setType1("past")
                .setYear("2019").setTd("pm").setX(288).setY(1322).setX(789).setY(1331)
                .setRepeat("3").setType2("Month"));
        app.getReminders().pause(1000);
        Assert.assertTrue(app.getReminders().isTitlePresent().contains("Christmas"));

    }
    @AfterMethod
    public void removeReminders() {
        app.getMainScreen().removeReminder();
    }
}

