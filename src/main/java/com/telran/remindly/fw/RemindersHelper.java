package com.telran.remindly.fw;

import com.telran.remindly.model.Reminder;
import io.appium.java_client.AppiumDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.List;

public class RemindersHelper extends HelperBase{

    public RemindersHelper(AppiumDriver driver) {
        super(driver);
    }

    public void tapOnAddReminder() {
        tap(By.id("add_reminder"));
    }

    public void fillReminderTitle(String title) {
        type(By.id("reminder_title"), title);
        hideKeyboard();
    }

    public void saveReminder() {
        tap(By.id("save_reminder"));
    }

    public void tapOnDataField() {
        tap(By.id("date"));
    }

    public void selectMonth(String time) {
        pause(500);
        if (time.equals("past")) {
            swipeDown();
        } else if (time.equals("future")) {
            swipeUp();
        }
    }
    public void selectDay(int index) {
        List<WebElement> days = driver.findElements(By.className("android.view.View"));
        days.get(index).click();
    }

    public void tapOnOK() {
        tap(By.id("ok"));
    }

    public void selectCertainMonth(String type, int number, String month) {
        pause(1000);
//        int i = number;
        if (!selectedMonth().equals(month)) {
//            for (int j = 0; j < i; j++) {
            for (int j = 0; j < number; j++) {
                if (type.equals("future")) {
                    swipeUp();
                } else if (type.equals("past")) {
                    swipeDown();
                }
            }
        }
    }

    private String selectedMonth() {
        return driver.findElement(By.id("date_picker_month")).getText();
    }

    public void tapOnYear() {
        tap(By.id("date_picker_year"));
    }

    public void selectYear(String type1, String year) {
        pause(2000);
        if (!getSelectedYear().equals(year)) {
            if (type1.equals("future")) {
                swipeUpUntilNeededYear(year);
            } else if (type1.equals("past")) {
                swipeDownUntilNeededYear(year);
            }
        }
        tap(By.id("month_text_view"));
    }

    public void swipeDownUntilNeededYear(String year) {
        while (!getSelectedYear().equals(year)) {
            moveDown(By.className("android.widget.ListView"));
            getSelectedYear();
        }
    }

    public void swipeUpUntilNeededYear(String year) {
        while (!getSelectedYear    ().equals(year)) {
            moveUp(By.className("android.widget.ListView"));
            getSelectedYear();
        }
    }

    private String getSelectedYear() {
        return driver.findElement(By.id("month_text_view")).getText();
    }

    public void tapOnTime() {
        tap(By.id("time"));
    }

    public void selectTimeOfDay(String td) {
        if (td.equals("am")) {
            tapWithCoordinates(281, 1332);
        } else if (td.equals("pm")) {
            tapWithCoordinates(793, 1323);
        }
    }


    public void tapOnRepeatSwitch() {
        tap(By.id("repeat_switch"));
    }

    public void enterRepeatNumber(String number) {
        tap(By.id("repeat_no_text"));
        type(By.className("android.widget.EditText"), number);
        tap(By.id("android:id/button1"));
    }

    public void selectRepeatTime(String repeatMonth) {

        tap(By.id("repeat_type_text"));
        tap(By.xpath("//android.widget.TextView[@text='"+ repeatMonth +"']"));
    }

    public void enterAllData(Reminder reminder) {
        tapOnAddReminder();
        fillReminderTitle(reminder.getTitle());
        tapOnDataField();
        selectCertainMonth(reminder.getType(), reminder.getNumber(), reminder.getMonth());
        selectDay(reminder.getIndex());
        tapOnYear();
        selectYear(reminder.getType1(), reminder.getYear());
        tapOnOK();
        tapOnTime();
        selectTimeOfDay(reminder.getTd());
        tapWithCoordinates(reminder.getX(), reminder.getY());
        tapWithCoordinates(reminder.getX(), reminder.getY());
        tapOnOK();
        tapOnRepeatSwitch();
        enterRepeatNumber(reminder.getRepeat());
        swipeUp();
        selectRepeatTime(reminder.getType2());
        saveReminder();
    }

    public String isTitlePresent() {
        String recycle_title = driver.findElement(By.id("recycle_title")).getText();
        System.out.println(recycle_title);
        return recycle_title;
    }
}

