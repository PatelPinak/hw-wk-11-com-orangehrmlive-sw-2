package testsuite;

import browserfactory.BaseTest;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class LoginTest extends BaseTest {

    String baseUrl = "https://opensource-demo.orangehrmlive.com/";

    @Before
    public void setUp() {
        openBrowser(baseUrl);
    }

    @Test
    public void userShouldLoginSuccessfullyWithValidCredentials() {
        //Find the Username Field Element
        WebElement usernameField = driver.findElement(By.name("username"));
        // Type the Username to username field element
        usernameField.sendKeys("Admin");
        //Find the Password Field Element and send password on password field
        driver.findElement(By.name("password")).sendKeys("admin123");
        //Find the Login btn Element and click
        WebElement loginBtn = driver.findElement(By.xpath("//button[@type='submit']"));
        loginBtn.click();

        String expectedMessage = "Dashboard";
        WebElement actualTextElement = driver.findElement(By.xpath("//h6[text()='Dashboard']")); //xpath for locating dashboard
        String actualMessage = actualTextElement.getText();

        //Assert.assertEquals(expectedMessage, actualMessage);
        Assert.assertEquals("Not redirected to dashboard", expectedMessage, actualMessage);
    }

    @After
    public void tearDown() {
        closeBrowser();
    }
}
