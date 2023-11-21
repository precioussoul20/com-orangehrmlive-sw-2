package testsuite;

import browserfactory.BaseTest;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class ForgotPasswordTest extends BaseTest {

    static String baseUrl = "https://opensource-demo.orangehrmlive.com/";

    @Before
    public void setUp() {
        openBrowser(baseUrl);
    }

    @Test
    public void userShouldNavigateToForgotPasswordPageSuccessfully() throws InterruptedException {

        // click on the forgot your password link
        WebElement forgotPswdLink = driver.findElement(By.xpath("//div[@class='orangehrm-login-forgot']"));
        forgotPswdLink.click();
        Thread.sleep(5000);

        //Verify the text
        String expectedText = "Reset Password";
        String actualText = driver.findElement(By.xpath("//h6[contains(@class,'oxd-text oxd-text--h6 orangehrm-forgot-password-title')]")).getText();
        Assert.assertEquals(expectedText, actualText);
    }

    @After
    public void tearDown() {
        closeBrowser();
    }
}
