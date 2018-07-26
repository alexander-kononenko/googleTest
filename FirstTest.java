package test1;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import pages.HomePage;
import pages.LoginPage;

import java.sql.Timestamp;
import java.util.concurrent.TimeUnit;


public class FirstTest {

public static WebDriver driver;
public static LoginPage loginPage;
public static HomePage homePage;
Timestamp timestamp;

@BeforeClass
public static void setup() {
    System.setProperty("webdriver.chrome.driver", "C:\\chromedriver\\chromedriver.exe");
    driver = new ChromeDriver();
    loginPage = new LoginPage(driver);
    homePage = new HomePage(driver);
    driver.manage().window().maximize();
    driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
    driver.get("https://www.google.com/intl/ru/gmail/about/#");
}


@Test
public void userLogin() {
    loginPage.loginInput();
    loginPage.passInput();
    homePage.wrEmail();
    homePage.sendEmails();
    homePage.incEmailClick();
//Check if zalupa was send
    List<WebElement> mailList = driver.findElements(By.xpath("//span[@class='bog']/b"));
    int zalupaFound = 0;
    for (WebElement row: mailList) {
        if (row.getText().equals("zalupa")) {
                zalupaFound += 1;
        }
    }

    Assert.assertEquals(zalupaFound, 1); 
}

@AfterClass
public static void tearDown() {
    driver.quit();
    }
}

