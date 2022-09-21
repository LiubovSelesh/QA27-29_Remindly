package com.telran.remindly.fw;

        import io.appium.java_client.AppiumDriver;
        import org.openqa.selenium.By;
        import org.openqa.selenium.WebElement;

        import java.util.List;

public class MainScreenHelper extends HelperBase{

    public MainScreenHelper(AppiumDriver driver) {
       super(driver);
    }

    public boolean isNoReminderTextPresent() {
        return isElementPresent(By.id("no_reminder_text"));
//        return isElementPresent(By.xpath("//*[@resource-id='com.blanyal.remindly:id/no_reminder_text']");
    }

    public boolean isLicenseeTextPresent() {
//        return isElementPresent(By.id("toolbar"));
        tapMoreOptions();
        return isElementPresent(By.id("title"));
//        return isElementPresent(By.xpath("toolbar"));
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

}
