package testsuite;

import browserfactory.BaseTest;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class ForgotPasswordTest extends BaseTest {

    String baseUrl = "https://opensource-demo.orangehrmlive.com/";

    @Before
    public void setUp() {
        openBrowser(baseUrl);
    }

    @Test
    public void userShouldLoginSuccessfullyWithValidCredentials() {
        //Find the forgot your password btn Element and click
        WebElement loginBtn = driver.findElement(By.xpath("//p[text()='Forgot your password? ']"));
        loginBtn.click();

        String expectedMessage = "Reset Password";
        WebElement actualTextElement = driver.findElement(By.xpath("//h6[text()='Reset Password']")); //xpath for locating dashboard
        String actualMessage = actualTextElement.getText();

        //Assert.assertEquals(expectedMessage, actualMessage);
        Assert.assertEquals("Not redirected to rest password page", expectedMessage, actualMessage);
    }
    @After
    public void tearDown() {
        closeBrowser();
    }
}
