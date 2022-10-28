package com.telran.remindly.fw;

        import io.appium.java_client.AppiumDriver;
        import io.appium.java_client.TouchAction;
        import io.appium.java_client.touch.offset.PointOption;
        import org.openqa.selenium.By;
        import org.openqa.selenium.Dimension;
        import org.openqa.selenium.WebElement;

        import java.util.List;

public class MainScreenHelper extends HelperBase{

    public MainScreenHelper(AppiumDriver driver) {
       super(driver);
    }

    public boolean isNoReminderTextPresent() {
        return isElementPresent(By.id("no_reminder_text"));
    }

    public boolean isLicenseeTextPresent() {
        tapMoreOptions();
        return isElementPresent(By.id("title"));
    }


    public void tapMoreOptions() {
        tap(By.xpath("//android.widget.ImageView[@content-desc='More options']"));
    }

    public int getTotalReminders() {
        List<WebElement> id = driver.findElements(By.id("thumbnail_image"));
        int idCount = id.size();
        System.out.println("Total reminders quantity: " + idCount) ;
        return idCount;
    }

    public void tapTitle() {
        tap(By.id("title"));
    }

    public boolean isLicensesExist(){
        return isElementPresent(By.id("licenses_text_view"));
    }

    public void removeReminder() {
        TouchAction action = new TouchAction(driver);
        Dimension size = driver.manage().window().getSize();
        int x = size.width / 2;
        int y = size.height / 5;
        action.longPress(PointOption.point(x, y))
                .release()
                .perform();
        tap(By.id("discard_reminder"));
    }
}
