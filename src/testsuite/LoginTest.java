package testsuite;

import browserfactory.BaseTest;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class LoginTest extends BaseTest {

    static String baseUrl = "https://opensource-demo.orangehrmlive.com/";

    @Before
    public void setUp(){
        openBrowser(baseUrl);
    }

    @Test
    public void userShouldLoginSuccessfullyWithValidCredentials() throws InterruptedException {

        // Enter username
        WebElement username = driver.findElement(By.name("username"));
        username.sendKeys("Admin");
        Thread.sleep(5000);

        //Enter password
        WebElement password = driver.findElement(By.name("password"));
        password.sendKeys("admin123");
        Thread.sleep(5000);

        // Click Login button
        WebElement loginLink = driver.findElement(By.xpath("(//button[@type='submit'])"));
        loginLink.click();
        Thread.sleep(5000);

        // Verify the dashboard text
        String expectedMsg = "Dashboard";
        String actualMsg = driver.findElement(By.xpath("//div[@class='oxd-topbar-header-title']")).getText();
        Assert.assertEquals(expectedMsg, actualMsg);
    }

    @After
    public void tearDown(){
        closeBrowser();
    }
}
